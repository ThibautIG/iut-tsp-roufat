

import java.util.ArrayList;

public class SampleFixeGraphe {

	private ArrayList <SampleFixePoint> listePoints;		// Liste de Point
	private double [] [] distanceVilles;		// Distance entre les villes
	//private int nbrVilles;						// Nombre de villes

	public SampleFixeGraphe (int nbrVilles)
	{
		//this.nbrVilles = nbrVilles;
		listePoints = new ArrayList<SampleFixePoint>();
		
		listePoints.add(new SampleFixePoint(0));
		listePoints.add(new SampleFixePoint(1));
		listePoints.add(new SampleFixePoint(2));
		listePoints.add(new SampleFixePoint(3));
		listePoints.add(new SampleFixePoint(4));
		listePoints.add(new SampleFixePoint(5));
		listePoints.add(new SampleFixePoint(6));
		listePoints.add(new SampleFixePoint(7));
		listePoints.add(new SampleFixePoint(8));
		listePoints.add(new SampleFixePoint(9));
		

		distanceVilles = new double [10] [10];
		for (int i=0 ; i < nbrVilles; i++)
		{
			for (int j=0; j < nbrVilles; j++)
			{
				distanceVilles [i] [j] = listePoints.get(i).distance(listePoints.get(j));
			}
		}		
	}

	/*public void affiche ()
		{
			for (int i=0 ; i < nbrVilles; i++)
			{
				for (int j=0; j < nbrVilles; j++)
				{
					System.out.print(distanceVilles [i] [j] + " ");
				}
				System.out.println("\n");
			}	
		}*/

	public ArrayList<SampleFixePoint> getListePoints()
	// Retourne la liste de points
	{
		return listePoints;
	}




}




