public class Principale {


	public static void main(String[] args) {
		Graphe g = new Graphe (7);

		/*System.out.println("=== BRUTE FORCE ===");
		BruteForce graphe = new BruteForce (g);
		long begin = System.currentTimeMillis();
		System.out.println(graphe.lancement());
		long end = System.currentTimeMillis();
		float time = ((float) (end-begin)) / 1000f;
		System.out.println("Temps d'execution : " + time);
		
		System.out.println();
		
		System.out.println("=== PLUS PROCHES VOISINS ===");
		ProchesVoisins graphe2 = new ProchesVoisins (g);
		begin = System.currentTimeMillis();
		System.out.println(graphe2.lancement());
		end = System.currentTimeMillis();
		time = ((float) (end-begin)) / 1000f;
		System.out.println("Temps d'execution : " + time);

		System.out.println();
		
		
		System.out.println("=== BACKTRACK ===");
		BackTrack graphe3 = new BackTrack (g);
		System.out.println(graphe3.lancement());


		//System.out.println();*/
		
		System.out.println("=== KRUSKAL ===");
		Algo_Kruskal graphe4 = new Algo_Kruskal (g);
		graphe4.lancement();



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
