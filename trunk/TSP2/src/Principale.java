
public class Principale {

	/**
	 * @param args
	 */
	public static void main (String args []) 
	{		
		CreationTableau tab = new CreationTableau (26);
		tab.afficheTableau();
		System.out.println("\n\n");
		ProchesVoisins algo1 = new ProchesVoisins(26, tab.getTableau());
		System.out.println("Distance : " + algo1.main());
	}

}
