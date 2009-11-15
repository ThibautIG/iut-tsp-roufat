import java.util.ArrayList;


public class SampleFixeBruteForce extends SampleFixeCreationGraphe{

	private ArrayList<SampleFixePoint> subtour;
	private ArrayList<SampleFixePoint> aParcourir;
	private double minparcours = 500000000;
	
	public SampleFixeBruteForce (SampleFixeGraphe g)
	{
		super(g);
		aParcourir = new ArrayList<SampleFixePoint>();
		aParcourir = g.getListePoints();
		subtour = new ArrayList<SampleFixePoint>();
	}
	
	public double lancement ()
	{
		return recherche (subtour,aParcourir);
	}
	
	public double recherche (ArrayList<SampleFixePoint> subtour, ArrayList<SampleFixePoint> aParcourir)
	{
		if (aParcourir.isEmpty())
		{
			return cout (subtour);
		}
		else
		{
			for (SampleFixePoint p : aParcourir)
			{
				ArrayList<SampleFixePoint> subtourZ = new ArrayList<SampleFixePoint>();
				subtourZ.addAll(subtour);
				subtourZ.add(new SampleFixePoint(p.getIdent()));
				double n = recherche (subtourZ, suppressionPoint(aParcourir, p));
				if (n < minparcours)
				{
					minparcours = n;
				}
			}
			return minparcours;
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<SampleFixePoint> suppressionPoint (ArrayList<SampleFixePoint> liste, SampleFixePoint p)
	{
		ArrayList<SampleFixePoint> liste2 = (ArrayList<SampleFixePoint>) liste.clone();
		liste2.remove(p);
		return liste2;
	}
	
	public double cout (ArrayList<SampleFixePoint> liste)
	{
		double distancefinale = 0;
		for (int i=0; i < liste.size() - 1; i++)
		{
			distancefinale += liste.get(i).distance(liste.get(i+1));
		}
		distancefinale += liste.get(liste.size()-1).distance(liste.get(0));
		return distancefinale;
	}
	
}
