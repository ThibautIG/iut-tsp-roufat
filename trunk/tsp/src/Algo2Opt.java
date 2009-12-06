import java.util.ArrayList;



public class Algo2Opt extends CreationGraphe
{

	private double minParcours;
	private ArrayList<Point> listePoints ; 
	private ProchesVoisins ppv;
	
	public Algo2Opt (Graphe g)
	{
		super(g);
	}
	
	public void lancement ()
	{
		ppv = new ProchesVoisins (super.g);
		minParcours = ppv.lancement(); 
		
		listePoints = new ArrayList<Point>();
		listePoints.addAll(super.g.getListePoints());
		
		
		for (int i=0; i < listePoints.size()-1; i++)
		{
			for (int j=i+1; j < listePoints.size()-1; j++)
			{
				if (test(listePoints.get(i), listePoints.get(j)))
				{
					
				}
			}
		}
	
	}
	
	
	private boolean test (Point i, Point j)
	{
		
	}
	
}
