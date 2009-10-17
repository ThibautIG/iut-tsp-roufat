public class CreationTableau4 {
	
	private int [][] tab = {{0,5,6,8},{5,0,13,2},{6,13,0,7},{8,2,7,0}};
	private int n;

	public CreationTableau4 (int nombreVilles)
	{
		this.n = nombreVilles;
	}
	
	public void afficheTableau()
	{
		for (int i = 0 ; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				System.out.print(tab [i][j]);
				System.out.print(" ");
			}
			System.out.println("\n");
		}
	}
	
	public int [][] getTableau ()
	{
		return tab;
	}
}
