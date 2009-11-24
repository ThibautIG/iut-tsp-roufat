
public class Aretes implements Comparable<Aretes>
{
	private Point u;
	private Point v;
	
	public Aretes (Point u, Point v)
	{
		this.u = u;
		this.v = v;
	}

	public int compareTo(Aretes o) {
		double nbr1 = ((Aretes) o).getPoids();
		double nbr2 = this.getPoids();
		if (nbr1 > nbr2) return -1;
		else if (nbr1 == nbr2) return 0;
		else return 1;
	}
	
	public double getPoids ()
	{
		return (u.distance(v));
	}
	
	public void afficheAretes ()
	{
		System.out.println ("Point : " + u.getIdent() + " avec Point : " + v.getIdent());
		System.out.println ("Poids : " + getPoids ());
		System.out.println();
	}
	
	public Point getU ()
	{
		return u;
	}
	
	public Point getV ()
	{
		return v;
	}
	
}
