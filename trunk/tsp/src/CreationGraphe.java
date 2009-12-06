import java.util.ArrayList;


public class CreationGraphe
{
	protected Graphe g;
	public double minparcours;
	public ArrayList<Point> parcoursmin;
	
	public CreationGraphe (Graphe g)
	{
		this.g = g;
		parcoursmin = new ArrayList<Point>();
	}
	
	public static ArrayList<Point> copieListe (ArrayList<Point> liste)
	// Méthode permettant de copier une liste passée en paramètre.
	// Renvoie une liste.
	{
		ArrayList <Point> copie = new ArrayList<Point>();
		for (Point p : liste)
		{
			copie.add(p);
		}
		return copie;
	}
	
	public static void afficheliste (ArrayList<Point> liste)
	// Affichage d'une liste.
	{
		for (Point p : liste) // parcours des points de la listes
		{
			System.out.println(p.getIdent() + " - " + p.getX() + ", " + p.getY());
		}
	}
	
	public static void afficheAretes (ArrayList<Aretes> liste)
	{
		for (Aretes a : liste)
		{
			a.afficheAretes();
		}
	}
	
	public void saveParcours (ArrayList<Point> liste)
	{
		this.parcoursmin = liste;
	}
	
	public void afficheminparcours ()
	{
		for (Point p : parcoursmin)
		{
			System.out.println(p.getIdent() + " ");
		}
	}
	
}
