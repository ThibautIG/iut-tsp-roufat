import java.awt.Graphics;
import java.util.ArrayList;


public class CreationGraphe
{
	protected Graphe g;
	public double minparcours = 0;
	public ArrayList<Point> parcoursmin;
	public double tempsParcours = 0;
	
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
	
	
	public void afficheminparcours ()
	{
		for (Point p : parcoursmin)
		{
			System.out.println(p.getIdent() + " ");
		}
	}
	
	
	// Affichage Graphique des parcours
	public void affichageParcoursGraphe(Graphics g, int dimGrille)
	{
		System.out.println("Affichage Graphe");
		Point u = null;
		Point v = null;
		
		for (int i=1; i < parcoursmin.size()-1; i++)
		{
			u = parcoursmin.get(i-1);
			v = parcoursmin.get(i);
			g.drawLine((int)u.getX(),(int)u.getY(),(int)v.getX(), (int)v.getY());
		}
		u = parcoursmin.get(parcoursmin.size()-1);
		v = parcoursmin.get(0);
		// Dessin de la ligne qui amene au 0
		g.drawLine((int)u.getX(), (int)u.getY(), (int)v.getX(), (int)v.getY());
	}
	
}
