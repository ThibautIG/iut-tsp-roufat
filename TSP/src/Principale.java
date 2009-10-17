
public class Principale {

	/**
	 * @param args
	 */
	public static void main (String args []) 
	{		
		CreationTableau4 tab = new CreationTableau4 (4);
		tab.afficheTableau();
		System.out.println("\n\n");
		ProchesVoisins algo1 = new ProchesVoisins(4, tab.getTableau());
		System.out.println("Distance : " + algo1.main());
	}

}
