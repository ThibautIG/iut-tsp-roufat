import java.util.ArrayList;

public class BruteForce extends CreationGraphe
{
	
	private ArrayList<Point> subtour;			// Liste des points du parcours optimal
	private ArrayList<Point> aParcourir;		// Liste des points à parcourir
	
	public BruteForce (Graphe g)
	{
		super(g);
	}
	
	public void lancement ()
	// Sert à appeler 'recherche' et à renvoyer à la procédure principale la distance du parcours optimal.
	{			
		super.minparcours = 5000000;
		
		aParcourir = new ArrayList<Point>();
		aParcourir.addAll(g.getListePoints());
		
		subtour = new ArrayList<Point>();
		
		// Lancement de la BruteForce
		if (!aParcourir.isEmpty())
			recherche (subtour,aParcourir);
	}
	
	private void recherche (ArrayList<Point> subtour, ArrayList<Point> aParcourir)
	// Renvoie la distance optimale d'un graphe.
	{
		// S'il n'y a plus de points a parcourir
		if (aParcourir.isEmpty())
		{
			double coutS = cout (subtour);
			if (coutS < super.minparcours) { 
			    
			    super.minparcours = coutS; 
			    super.parcoursmin = subtour;
			   // afficheliste(subtour);
			   // System.out.println("  -> "+minparcours);
		        
			}
		}
		else
		{
			for (Point p : aParcourir)
			{
				// On cree une nouvelle liste qui contient les points de subtour
				ArrayList<Point> copieSubtour = new ArrayList<Point>();
				copieSubtour = super.copieListe(subtour);
				
				// On cree une nouvelle liste qui contient les points de aParcourir
				ArrayList<Point> copieAParcourir = new ArrayList<Point>();
				copieAParcourir = super.copieListe(aParcourir);
				
				// On ajoute le point parcouru
				copieSubtour.add(new Point(p.getIdent()));
				
				// On supprime le point p de la liste copiee
				copieAParcourir.remove(p);
				
				// Puis on descend dans l'arbre
				recherche (copieSubtour, copieAParcourir);
			}

		}
	}
		
	private double cout (ArrayList<Point> liste)
	// Calcul de la distance totale entre les points de liste
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