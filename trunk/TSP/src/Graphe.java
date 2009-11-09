import java.util.ArrayList;


public class Graphe {

	private ArrayList <Point> listePoints;		// Liste de Point
	private double [] [] distanceVilles;		// Distance entre les villes
	private int nbrVilles;				    	// Nombre de villes
	
	public Graphe (int nbrVilles)
	{
		this.nbrVilles = nbrVilles;
		listePoints = new ArrayList<Point>();
		for (int i=0 ; i < nbrVilles ; i++)
		{
			listePoints.add(new Point(i));
		}
		
		distanceVilles = new double [nbrVilles] [nbrVilles];
		for (int i=0 ; i < nbrVilles; i++)
		{
			for (int j=0; j < nbrVilles; j++)
			{
				distanceVilles [i] [j] = listePoints.get(i).distance(listePoints.get(j));
			}
		}		
	}
	
	public void affiche ()
	{
		for (int i=0 ; i < listePoints.size(); i++)
		{
			for (int j=0; j < listePoints.size(); j++)
			{
				System.out.print(distanceVilles [i] [j] + " ");
			}
			System.out.println("\n");
		}	
	}
	
	public ArrayList<Point> getListePoints()
	// Retourne la liste de points
	{
		return listePoints;
	}
	
	
	public int getNbrVille()
	// Retourne le nombre de villes.
	{
		return nbrVilles;
	}
	
	public double getDistance (Point a, Point b)
	{
		return distanceVilles [a.getIdent()] [b.getIdent()];
	}
	
}
