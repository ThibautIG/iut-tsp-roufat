
public class SampleFixePoint {


	private int ident;
	private int x;
	private int y;

	public SampleFixePoint (int ident)
	{
		this.ident = ident;
		switch (ident)
		{
		case 0 : x = 2; y = 3; break;
		case 1 : x = 5; y = 1; break;
		case 2 : x = 9; y = 4; break;
		case 3 : x = 12; y = 5; break;
		case 4 : x = 7; y = 9; break;
		case 5 : x = 22; y = 11; break;
		case 6 : x = 2; y = 3; break;
		case 7 : x = 5; y = 1; break;
		case 8 : x = 9; y = 4; break;
		case 9 : x = 12; y = 5; break;

		}
	}
	
	public double distance (SampleFixePoint p2)
	// Retourne la distance entre le point courant et le point p2.
	{
		return (Math.abs(Math.sqrt(Math.pow((this.x - p2.x), 2) + Math.pow((this.y - p2.y), 2))));
	}

	public int getIdent ()
	{
		return ident;
	}
	
	
}
