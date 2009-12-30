import java.util.ArrayList;

public class BackTrack_v2 extends CreationGraphe 
{
	private ArrayList <Point> aParcourir;
	private ArrayList <Point> subtour;
	private double newDist;
	private Point q;

	public BackTrack_v2 (Graphe g)
	{
		super(g);
	}

	public void lancement ()
	{
		//ProchesVoisins initPpv = new ProchesVoisins (super.g); 
		//initPpv.lancement();
		super.minparcours = 500000;

		System.out.println("Min parcours : " + super.minparcours);

		aParcourir = new ArrayList<Point>();
		aParcourir.addAll(super.g.getListePoints());

		subtour = new ArrayList<Point>();

		// On cree une distance de base (0) et on passe les deux listes en paramètres.
		recherche (subtour, aParcourir, 0);
	}

	public void recherche (ArrayList <Point> subtour, ArrayList <Point> aParcourir, double distance)
	{
		newDist = distance;
		if (aParcourir.isEmpty())
		{
			// Ajout de la derniere arete
			newDist = distance + super.g.getDistance(subtour.get(subtour.size()-1), subtour.get(0));

			if (newDist < super.minparcours) {
				//System.out.println("passe");
				super.minparcours = newDist;
				super.parcoursmin = subtour;
				//afficheliste(subtour);
				//System.out.println("  -> "+minparcours);}
			}
		}
		else
		{ 
			if (distance < super.minparcours)
			{
				for (Point p : aParcourir)
				{
					// On calcule le cout du parcours
					if (!subtour.isEmpty()){
						q = subtour.get(subtour.size()-1);
						newDist = distance + super.g.getDistance(q, p);}

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

					// Puis on descend dans l'arbre
					recherche (copieSubtour, copieAParcourir, newDist);
				}
			}
		}
	}
}
