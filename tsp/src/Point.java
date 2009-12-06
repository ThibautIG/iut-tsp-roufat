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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ident;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Point))
            return false;
        Point other = (Point) obj;
        if (ident != other.ident)
            return false;
        return true;
    }
	
	
}
