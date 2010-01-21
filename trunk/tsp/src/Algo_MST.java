import java.util.ArrayList;


public class Algo_MST extends CreationGraphe 
{
	private ArrayList<Aretes> aretesChoisies;
	private ArrayList<Point> listePoints;
	private ArrayList<Point> subtour;
	
	public Algo_MST (Graphe g)
	{
		super(g);
	}
	
	public void lancement ()
	{		
		// Initialisation du MST
		MST mst = new MST (super.g);
		mst.lancement();
		aretesChoisies = new ArrayList<Aretes>();
		aretesChoisies.addAll(mst.getAretesChoisies());

				
		// Initialisation de listePoints
		listePoints = new ArrayList<Point>();
		listePoints.addAll(super.g.getListePoints());
		
		// Initialisation de subtour
		subtour = new ArrayList<Point>();
		
		// Lancement de l'algorithme
		int i = 0; 		// Premiere arete
		recherche (i);
	}
	
	public void recherche (int i)
	{
		System.out.println("Subtour : " + subtour.size() + "       listePoints : " + listePoints.size() + "          Aretes Choisies : " + aretesChoisies.size());
		if (subtour.size() == listePoints.size()-2)
		{
			super.parcoursmin.addAll(subtour);
			super.minparcours = cout(subtour);			
			System.out.println(super.minparcours);
		}
		else
		{
			Point u = aretesChoisies.get(i).getU();
			Point v = aretesChoisies.get(i).getV();
			if (subtour.contains(u))
			{
				if (!subtour.contains(v))
				{
					subtour.add(v);
				}
			}
			else if (subtour.contains(v))
				subtour.add(u);

			
			recherche (i+1);
		}
	}
		
	public double cout (ArrayList<Point> liste)
	{
		double distancefinale = 0;
		for (int i=0; i < liste.size() - 1; i++)
		{
			distancefinale += super.g.getDistance(liste.get(i), liste.get(i+1));
		}
		// On revient au point de départ
		distancefinale += super.g.getDistance(liste.get(liste.size() - 1), liste.get(0));

		return distancefinale;
	}

}
