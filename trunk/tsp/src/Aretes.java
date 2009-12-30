
public class Aretes implements Comparable<Aretes>
{
	private Point u;
	private Point v;
	private double poids;
	
	public Aretes (Point u, Point v)
	{
		this.u = u;
		this.v = v;
		this.poids = getPoids();
	}

	public int compareTo(Aretes o) {
	    return (int) (getPoids() - o.getPoids());
	}
	
	public double getPoids ()
	{
		return (u.distance(v));
	}
	
	public void afficheAretes ()
	{
		System.out.print ("Point : " + u.getIdent() + " avec Point : " + v.getIdent());
		System.out.println ("  Poids : " + this.poids);
		//System.out.println();
	}
	
	public Point getU ()
	{
		return u;
	}
	
	public Point getV ()
	{
		return v;
	}

    public String toString()
    {
        return "Point : " + u.getIdent() + " avec Point : " + v.getIdent() +"  Poids : " + this.poids;
        //System.out.println();
    }
	
}
