import java.util.*;

public class MST_2
{
	private ArrayList<Aretes> aretesCroiss;
	private ArrayList<Point> listePoints;
	private Map<Point,Collection<Point>> connexComponents;
	private ArrayList<Aretes> aretesChoisies;
    
	public MST_2 (ArrayList<Point> vect)
	{
		listePoints = new ArrayList<Point>();
		this.listePoints = vect;
	}

	public void lancement ()
	{
		// Initialisation de listePoints
		aretesCroiss = new ArrayList<Aretes>();
		aretesChoisies = new ArrayList<Aretes>();

		connexComponents = new HashMap<Point, Collection<Point>>();
		
		// Création et tri du tableau d'Aretes
		initAretes();

		initComponent();
		
		mst ();
	}

	public double cout() {
	    double cout = 0;
	    for(Aretes a : aretesChoisies)
	           cout += a.getPoids();
	    return cout;
	}
	
	
	public void initAretes ()
	{
		// Initialisation des aretes
		for (int i = 0; i < listePoints.size()-1; i++)
		{
			for (int j= i+1; j < listePoints.size() ; j++)
			{
				aretesCroiss.add(new Aretes(listePoints.get(i), listePoints.get(j)));
			}
		}

		// Tri des arêtes
		Collections.sort(aretesCroiss);
		
		// Affichage de l'ensemble des aretes
		//afficheAretes(aretesCroiss);
	}
	public void initComponent ()
    {
	       for(Point p : listePoints) {
	           Collection<Point> points = new HashSet<Point>();
	           points.add(p);
	           connexComponents.put(p, points);
	       }
    }
	
	public void addArrete(Aretes a) {
	    aretesChoisies.add(a);
	    Point p1 = a.getU();
	    Point p2 = a.getV();
        
	    connexComponents.get(p1).addAll(connexComponents.get(p2));
	    for (Point p3 : connexComponents.get(p2)) {
	        connexComponents.put(p3, connexComponents.get(p1));   
	    }
	}
	
	public boolean areSameComponet(Point p1, Point p2) {
	    return connexComponents.get(p1).contains(p2);
	}
	

	public void mst ()
	{
	    for(Aretes a : aretesCroiss) {
	        Point p1 = a.getU();
	        Point p2 = a.getV();
	        if (!areSameComponet(p1, p2)) {
	            addArrete(a);
	        }
	    }

        //System.out.println("\n aretes choisies");
	    //for (Aretes a2 : aretesChoisies) {
	    //    System.out.println(a2);
	    // }
	}
	
	public ArrayList<Aretes> getAretesChoisies ()
	{
		return aretesChoisies;
	}
}
