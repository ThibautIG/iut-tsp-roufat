public class Principale {


	public static void main(String[] args) {
		Graphe g = new Graphe (7);
		
		/* BruteForce */
		
		System.out.println("=== BRUTE FORCE ===");
		//long begin = System.currentTimeMillis();
		BruteForce graphe = new BruteForce (g);
		for (int i=0; i < 20 ; i++) {
		//g.affiche();
		System.out.println(graphe.lancement()); }
			//long end = System.currentTimeMillis();
			//float time = ((float) (end-begin)) / 1000f;
			//System.out.println("Temps d'execution : " + time);

		
		/* BruteForce avec sample 
		SampleFixeGraphe h = new SampleFixeGraphe (10);
		SampleFixeBruteForce graphe2 = new SampleFixeBruteForce (h);
		System.out.println("=== BRUTE FORCE SAMPLE 10 points ===");
		//for (int i=0; i < 15 ; i++)
		
		long begin = System.currentTimeMillis();
		System.out.println(graphe2.lancement());
		long end = System.currentTimeMillis();
		float time = ((float) (end-begin)) / 1000f;
		System.out.println("Temps d'execution : " + time);*/
		
		/* Plus proches voisins 
		PlusProchesVoisins ppv = new PlusProchesVoisins (g);
		System.out.println("=== Plus Proches Voisins ===");
		for (int i=0; i < 20 ; i++)
			System.out.println(ppv.main()); */
	
	}

}
