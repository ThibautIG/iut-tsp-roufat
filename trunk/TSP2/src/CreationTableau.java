
public class CreationTableau
{
	private int [][] tab;
	private int n;

	public CreationTableau (int nombreVilles)
	{
		this.n = nombreVilles;
		tab = new int [n] [n];

		//Remplissage du tableau avec des points aleatoires.
		for (int i= 0; i < (n/2); i++)
		{
			for (int j = 0; j < n ; j++)
			{
				tab [j] [i] = tab [i] [j] = (int) (Math.random()*10000);
				while (tab [i][j] == 0)
				{
					tab [j] [i] = tab [i] [j] = (int) (Math.random()*10000);
				}
			}
		}
		
		// Initialisation de la diagonale à 0.
		for (int i = 0 ; i < n ; i++)
		{
			tab [i][i] = (0);
		} 
		
	}

	public void afficheTableau()
	{
		for (int i = 0 ; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				System.out.print(tab [i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
	}
	
	public int [][] getTableau ()
	{
		return tab;
	}

}
