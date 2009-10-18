public class CreationTableau8 {
	
	private int [][] tab = {{0,672,848,1737,954,1195,1850,906},{672,0,255,2383,1368,1047,2520,1572},{848,255,0,2489,1617,1270,2689,1753},{1737,2383,2489,0,1891,2732,708,1033},{954,1368,1617,1891,0,967,1615,871},{1195,1047,1270,2732,967,0,2565,1710},{1850,2520,2689,708,1615,2565,0,952},{906,1572,1753,1033,871,1710,952,0}};
	private int n = 8;

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
