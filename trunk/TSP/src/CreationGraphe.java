import java.util.ArrayList;


public class CreationGraphe
{
	protected Graphe g;
	
	public CreationGraphe (Graphe g)
	{
		this.g = g;
	}
	
	public ArrayList<Point> copieListe (ArrayList<Point> liste)
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
	
	public void afficheliste (ArrayList<Point> liste)
	// Affichage d'une liste.
	{
		for (Point p : liste)
		{
			System.out.println(p.getIdent());
		}
	}
	
}
