import java.util.ArrayList;


public class CreationGraphe
{
	protected Graphe g;
	
	public CreationGraphe (Graphe g)
	{
		this.g = g;
	}
	
	public ArrayList<Point> copieListe (ArrayList<Point> liste)
	{
		ArrayList <Point> copie = new ArrayList<Point>();
		for (Point p : liste)
		{
			copie.add(p);
		}
		return copie;
	}
	
}
