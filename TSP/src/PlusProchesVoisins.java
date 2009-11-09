import java.util.ArrayList;

public class PlusProchesVoisins extends CreationGraphe
{
	/* Algorithme des plus proches voisins.
	Algorithme heuristique. 
	But : On prend un sommet de départ. On recherche le sommet qui est le plus proche.
	On va à ce sommet et ainsi de suite. On revient au point de départ à la fin.
	 */

	private int nbrVilles;
	private ArrayList<Point> listePoints;
	private ArrayList<Point> parcours;

	public PlusProchesVoisins (Graphe g)
	{
		super(g);
		this.parcours = new ArrayList<Point>();
		this.listePoints = new ArrayList<Point>();
		this.listePoints = g.getListePoints();
		this.nbrVilles = this.listePoints.size() - 1;
	}

	
	public Point plusPetitSommet (int ville)
	{
		double pluspetit = 40000000;
		int ident = 0;
		for (Point p : listePoints) {
			if (!estDansTableau(ville) && (listePoints.get(ville).distance(p) < pluspetit))
			{
				pluspetit = listePoints.get(ville).distance(p);
				ident = p.getIdent();
			}
		}
		return listePoints.get(ident);
	}
	
	public boolean estDansTableau(int ident)
	{
		int i = 0;
		boolean bool = false;
		while (i<listePoints.size() && bool == false)
		{
			if (ident == parcours.get(i).getIdent())
				bool = true;
			i++;
		}
		return bool;
	}
	
	public double cout ()
	{
		double distancefinale = 0;
		for (int i=0; i < parcours.size() - 1; i++)
		{
			distancefinale += parcours.get(i).distance(parcours.get(i+1));
		}
		distancefinale += parcours.get(parcours.size()-1).distance(parcours.get(0));
		return distancefinale;
	}
	
	public double main ()
	{
		//Point de départ
		int ind = 0;
		parcours.add(new Point(ind));	// Ajout du premier point
		
		while (!listePoints.isEmpty())
		{
			// Ajout du sommet le plus proche dans parcours
			parcours.add(plusPetitSommet(ind));
			listePoints.remove(ind);
			ind = parcours.lastIndexOf(parcours);
			
		}
		
		// Et on retourne la somme des distances finales.
		return cout ();
	}
}

