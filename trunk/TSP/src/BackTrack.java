import java.util.ArrayList;

public class BackTrack extends CreationGraphe 
{
	private ArrayList <Point> aParcourir;
	private ArrayList <Point> subtour;
	private double minparcours;

	public BackTrack (Graphe g)
	{
		super(g);
	}

	public double lancement ()
	{
		ProchesVoisins initPpv = new ProchesVoisins (super.g); 			// PROBLEME - Le graphe g disparait.
		this.minparcours = initPpv.lancement();
		
		aParcourir = new ArrayList<Point>();
		aParcourir = g.getListePoints();
		
		afficheliste (aParcourir);
		
		subtour = new ArrayList<Point>();

		// On cree une distance de base et on passe les deux listes en paramètres.
		recherche (subtour, aParcourir, 0);
		return minparcours;
	}

	public void recherche (ArrayList <Point> subtour, ArrayList <Point> aParcourir, double distance)
	{
		if (aParcourir.isEmpty())
		{
			//double coutS = cout (subtour);
			double coutS = distance;
			if (coutS < this.minparcours)
				this.minparcours = coutS;
		}
		else if (distance < this.minparcours)
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

				// On ajoute la distance entre le point p actuel et le dernier point de subtour
				distance = distance + super.g.getDistance(subtour.get(subtour.size()),p);

				// Puis on descend dans l'arbre
				recherche (copieSubtour, copieAParcourir, distance);
			}
		}
	}

	/*private double cout (ArrayList <Point> liste)
	{
		double distancefinale = 0;
		for (int i=0; i < liste.size() - 1; i++)
		{
			distancefinale += super.g.getDistance(liste.get(i), liste.get(i+1));
		}
		// On revient au point de départ
		distancefinale += super.g.getDistance(liste.get(liste.size() - 1), liste.get(0));
		return distancefinale;

	}*/

}