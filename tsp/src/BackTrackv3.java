import java.util.ArrayList;

public class BackTrackv3 extends CreationGraphe 
{
	private ArrayList <Point> aParcourir;
	private ArrayList <Point> subtour;

	public BackTrackv3 (Graphe g)
	{
		super(g);
	}

	public void lancement ()
	{
		super.minparcours = 500000;
		
		aParcourir = new ArrayList<Point>();
		aParcourir.addAll(g.getListePoints());

		
		subtour = new ArrayList<Point>();

		// On cree une distance de base et on passe les deux listes en paramètres.
		recherche (subtour, aParcourir, 0);
		
	}

	public void recherche (ArrayList <Point> subtour, ArrayList <Point> aParcourir, double distance)
	{
		if (aParcourir.isEmpty())
		{
			if (distance < super.minparcours)
				super.minparcours = distance;
			//afficheliste(subtour);
			//System.out.println("    --> " + super.minparcours);
		}
		else if (distance < super.minparcours)
		{
			for (Point p : aParcourir)
			{
				// On cree une nouvelle liste qui contient les points de subtour
				ArrayList<Point> copieSubtour = new ArrayList<Point>();
				copieSubtour = super.copieListe(subtour);
				
				// On cree une nouvelle liste qui contient les points de aParcourir
				ArrayList<Point> copieAParcourir = new ArrayList<Point>();
				copieAParcourir = super.copieListe(aParcourir);

				// On ajoute le point parcouru
				copieSubtour.add(new Point(p.getIdent()));

				// On supprime le point p de la liste copiee
				copieAParcourir.remove(p);
				
				// On calcule le cout du parcours
				distance = cout (copieSubtour);
				
				// Puis on descend dans l'arbre
				recherche (copieSubtour, copieAParcourir, distance);
			}
		}
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