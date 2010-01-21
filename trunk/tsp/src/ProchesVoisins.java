import java.util.ArrayList;

public class ProchesVoisins extends CreationGraphe
{

	private ArrayList<Point> aParcourir;
	private ArrayList<Point> subtour;
	int pointDepart = 0;

	public ProchesVoisins (Graphe g)
	{
		super(g);
	}

	public void lancement ()
	{
		double begin = System.currentTimeMillis();
		
		super.minparcours = 5000000;

		aParcourir = new ArrayList<Point>();
		aParcourir.addAll(g.getListePoints());

		subtour = new ArrayList<Point>();

		if (!aParcourir.isEmpty()) 
		{
			// Ajout du premier point
			Point p = aParcourir.get(0);
			subtour.add(p); 
			aParcourir.remove(p);


			recherche (aParcourir, subtour, p);
			
			super.tempsParcours = System.currentTimeMillis() - begin;
		}
	}

	public void recherche (ArrayList<Point> aParcourir, ArrayList<Point> subtour, Point sommet)
	{
		if (aParcourir.isEmpty())
		{
			super.minparcours = cout(subtour);
			super.parcoursmin.addAll(subtour);
		}
		else 
		{	
			// On cree une nouvelle liste qui contient les points de aParcourir
			ArrayList<Point> copieAParcourir = new ArrayList<Point>();
			copieAParcourir = super.copieListe(aParcourir);
			
			// On cree une nouvelle liste qui contient les points de subtour
			ArrayList<Point> copieSubtour = new ArrayList<Point>();
			copieSubtour = super.copieListe(subtour);
			
			// On cherche le point le plus près du sommet.
			Point sommetSuivant = ppv (sommet, copieAParcourir);
			
			// On l'ajoute au parcours
			copieSubtour.add(sommetSuivant);
			
			// On l'enleve de la liste des points à parcourir puisqu'on vient d'y passer.
			copieAParcourir.remove(sommetSuivant);

			// Et on fait appel à la méthode récursive
			recherche (copieAParcourir, copieSubtour, sommetSuivant);
		}
	}


	public Point ppv (Point pSommet, ArrayList<Point> aParcourir)
	{
		double pluspetit = 5000000;
		// On initialise le point le plus proche à la première case de aParcourir
		Point pointProche = aParcourir.get(0);

		for (Point p : aParcourir)
		{
			if (pluspetit > super.g.getDistance(pSommet,p))
			{
				// On stocke le point le plus proche et la distance
				pointProche = p;
				pluspetit = super.g.getDistance(pSommet,pointProche);
			}
		}
		return pointProche;
	}

	public double cout (ArrayList<Point> liste)
	{
		double distancefinale = 0;
		for (int i=0; i < liste.size() - 1; i++)
		{
			distancefinale += super.g.getDistance(liste.get(i), liste.get(i+1));
		}
		// On revient au point de départ
		distancefinale += super.g.getDistance(liste.get(liste.size() - 1), liste.get(0));
		return distancefinale;
	}
}