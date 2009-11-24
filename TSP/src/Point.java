import java.util.Random;


public class Point {

	private int ident;
	private int x;
	private int y;

	public Point (int ident)
	{
		this.ident = ident;
		Random rd = new Random();
		this.x = rd.nextInt(1000);
		this.y = rd.nextInt(1000);

	}

	public double distance (Point p2)
	// Retourne la distance entre le point courant et le point p2.
	{
		return (Math.abs(Math.sqrt(Math.pow((this.x - p2.x), 2) + Math.pow((this.y - p2.y), 2))));
	}

	public int getIdent ()
	// Récupère l'identifiant du point
	{
		return ident;
	}
	
	public int getX () {return x;}
	public int getY () {return y;}
}
