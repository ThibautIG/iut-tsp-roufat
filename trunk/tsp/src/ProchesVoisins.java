import java.util.ArrayList;

public class ProchesVoisins extends CreationGraphe
{

	private ArrayList<Point> aParcourir;
	private ArrayList<Point> subtour;
	private double minparcours;
	int pointDepart;

	public ProchesVoisins (Graphe g)
	{
		super(g);
	}



	public double lancement ()
	{
		minparcours = 5000000;
		pointDepart = 0;

		aParcourir = new ArrayList<Point>();
		aParcourir.addAll(g.getListePoints());

		subtour = new ArrayList<Point>();

		if (!aParcourir.isEmpty()) {
			// Ajout du premier point
			Point p = aParcourir.get(0);
			subtour.add(p); 
			aParcourir.remove(p);


			recherche (aParcourir, subtour,aParcourir.get(0));

			// Ajout du dernier point
			subtour.add(new Point(subtour.get(0).getIdent()));

			super.saveParcours(subtour);}

		//afficheminparcours();

		return minparcours;
	}

	public void recherche (ArrayList<Point> aParcourir, ArrayList<Point> subtour, Point sommet)
	{
		if (aParcourir.isEmpty())
		{
			minparcours = cout(subtour);
		}
		else 
		{				
			// On cherche le point le plus près du sommet.
			Point sommetSuivant = ppv (sommet);

			// On l'ajoute au parcours
			subtour.add(sommetSuivant);

			// On l'enleve de la liste des points à parcourir puisqu'on vient d'y passer.
			aParcourir.remove(sommetSuivant);

			// Et on fait appel à la méthode récursive
			recherche (aParcourir, subtour, sommetSuivant);
		}
	}


	public Point ppv (Point pSommet)
	{
		double pluspetit = 5000000;
		// On initialise le point le plus proche à la première case de aParcourir
		Point pointProche = aParcourir.get(0);

		for (int i = 1 ; i < aParcourir.size() - 1; i++)
		{
			if ((pluspetit > super.g.getDistance(pSommet,aParcourir.get(i))))
			{
				// On stocke le point le plus proche et la distance
				pointProche = aParcourir.get(i);
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