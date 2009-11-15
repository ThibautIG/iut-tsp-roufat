public class Principale {


	public static void main(String[] args) {
		Graphe g = new Graphe (6);

		System.out.println("=== BRUTE FORCE ===");
		BruteForce graphe = new BruteForce (g);
		System.out.println(graphe.lancement());
		
		/*System.out.println();
		
		System.out.println("=== PLUS PROCHES VOISINS ===");
		ProchesVoisins graphe2 = new ProchesVoisins (g);
		System.out.println(graphe2.lancement());

		System.out.println();
		
		System.out.println("=== BACKTRACK ===");
		BackTrack graphe3 = new BackTrack (g);
		System.out.println(graphe3.lancement());*/






		/* BruteForce avec sample 
		SampleFixeGraphe h = new SampleFixeGraphe (10);
		SampleFixeBruteForce graphe2 = new SampleFixeBruteForce (h);
		System.out.println("=== BRUTE FORCE SAMPLE 10 points ===");
		//for (int i=0; i < 15 ; i++)

		// Pour calculer le temps
		long begin = System.currentTimeMillis();
		System.out.println(graphe2.lancement());
		long end = System.currentTimeMillis();
		float time = ((float) (end-begin)) / 1000f;
		System.out.println("Temps d'execution : " + time);*/


	}

}
