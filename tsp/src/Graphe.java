import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Graphe {

	public static ArrayList <Point> listePoints;		// Liste de Point
	private double [] [] distanceVilles;		// Distance entre les villes
	private int nbrVilles;				    	// Nombre de villes
	private static int identVille = -1;

	public Graphe (int nbrVilles)
	{

		this.nbrVilles = nbrVilles;
		listePoints = new ArrayList<Point>();
		for (int i=0 ; i < nbrVilles ; i++)
		{
			listePoints.add(new Point(i));
			identVille = i;
		}

		calculeDist();
	}


	public Graphe ()
	{
		identVille = -1;
		listePoints = new ArrayList<Point>();
	}


	public void calculeDist ()
	// Calcule les distances entre les villes
	{
		distanceVilles = new double [nbrVilles] [nbrVilles];
		for (int i=0 ; i < nbrVilles; i++)
		{
			for (int j=0; j < nbrVilles; j++)
			{
				distanceVilles [i] [j] = listePoints.get(i).distance(listePoints.get(j));
			}
		}		
	}

	public void addPoint (int x, int y)
	// Ajoute un point
	{
		listePoints.add(new Point(x,y, nextID()));
		this.nbrVilles++;
	}
	
	public int nextID ()
	{
		identVille++;
		return identVille;
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
	
	public void miseZeroIdentVille ()
	{
		Graphe.identVille = -1;
	}

	/**
	 * Distance entre deux Points
	 *  
	 * @param a : Premier point
	 * @param b : Deuxieme point
	 * @return : la distance entre les deux points
	 */
	public double getDistance (Point a, Point b)
	{
		return distanceVilles [a.getIdent()] [b.getIdent()];
	}

	public void dessineVilles (Graphics g, Color couleur)
	{
		afficheliste (listePoints);
		// Dessin des villes
		if (!listePoints.isEmpty())
			for (Point p : listePoints)
			{
				p.dessinePoint(g, couleur);
			}
	}
	
	public void afficheliste (ArrayList<Point> liste)
	{
//		for (Point p : liste)
//		{
//			System.out.println("Ident : " + p.getIdent() + "    X : " + p.getX() + "    Y : " + p.getY());
//		}
	}

}
