public class Principale2 {


	public static void main(String[] args) {

		for (int i=2; i<13; i++) {
		Graphe g = new Graphe (7);
		long begin, end; float time;

		System.out.println("=== BRUTE FORCE ===");
		BruteForce graphe = new BruteForce (g);
		begin = System.currentTimeMillis();
		System.out.println(graphe.lancement());
		end = System.currentTimeMillis();
		time = ((float) (end-begin)) / 1000f;
		System.out.println("Temps d'execution : " + time);

		System.out.println();

		System.out.println("=== BACKTRACK ===");
		BackTrack graphe3 = new BackTrack (g);
		begin = System.currentTimeMillis();
		System.out.println(graphe3.lancement());
		end = System.currentTimeMillis();
		time = ((float) (end-begin)) / 1000f;
		System.out.println("Temps d'execution : " + time);
		
		System.out.println();
		
		/*System.out.println("=== PLUS PROCHES VOISINS ===");
		ProchesVoisins graphe2 = new ProchesVoisins (g);
		begin = System.currentTimeMillis();
		System.out.println(graphe2.lancement());
		end = System.currentTimeMillis();
		time = ((float) (end-begin)) / 1000f;
		System.out.println("Temps d'execution : " + time);

		System.out.println();

		System.out.println("=== KRUSKAL ===");
		Algo_Kruskal graphe4 = new Algo_Kruskal (g);
		begin = System.currentTimeMillis();
		graphe4.lancement();
		end = System.currentTimeMillis();
		time = ((float) (end-begin)) / 1000f;
		System.out.println(graphe4.cout());
		System.out.println("Temps d'execution : " + time);*/


		}

	}
}
