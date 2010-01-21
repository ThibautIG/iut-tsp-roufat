import java.util.ArrayList;



public class Algo2Opt_V2 extends CreationGraphe
{
	private ArrayList<Point> listePoints ; 
	private ProchesVoisins ppv;

	public Algo2Opt_V2 (Graphe g)
	{
		super(g);
	}

	public void lancement ()
	{
		double begin = System.currentTimeMillis();
		
		ppv = new ProchesVoisins (g);
		ppv.lancement();
		
		
		boolean change = true;

		listePoints = new ArrayList<Point>();
		listePoints.addAll(super.g.getListePoints());
		
		ppv.parcoursmin.add(listePoints.get(0));

		while (change){
			change = false;	
			for (int i=0; i < listePoints.size(); i++)
			{
				for (int j=i+1; j < listePoints.size(); j++)
				{
					if (test(i,j))
					{
						// On echange
						echange (listePoints.get(i).getIdent(), listePoints.get(j).getIdent());
						change = true;
					}
				}
			}
		}

		super.tempsParcours = System.currentTimeMillis() - begin;

		super.parcoursmin = this.ppv.parcoursmin;
		super.minparcours = cout(super.parcoursmin);

		afficheliste(super.parcoursmin);
		System.out.println("    --> " + super.minparcours);
	} 


	private boolean test (int i, int j)
	// Teste si l'echange des deux sommets ne rajoutera pas de la distance
	{
		boolean teste = false;
		if ((super.g.getDistance(this.ppv.parcoursmin.get(i+1), this.ppv.parcoursmin.get(i)) + super.g.getDistance(this.ppv.parcoursmin.get(j+1), this.ppv.parcoursmin.get(j))) 
				> (super.g.getDistance(this.ppv.parcoursmin.get(i+1), this.ppv.parcoursmin.get(j+1)) + super.g.getDistance(this.ppv.parcoursmin.get(j), this.ppv.parcoursmin.get(i))))
		{
			teste = true;
		}
		return teste;
	}

	// Echange de deux villes du parcours
	private void echange (int i, int j)
	{
		Point tmp = this.ppv.parcoursmin.get(i+1);
		this.ppv.parcoursmin.set(i+1, this.ppv.parcoursmin.get(j));
		this.ppv.parcoursmin.set(j, tmp);
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
