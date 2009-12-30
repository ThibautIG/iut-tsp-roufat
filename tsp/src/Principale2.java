import java.util.ArrayList;

public class Principale2 {


	public static void main(String[] args) {

		
		
		long begin, end; float time;
		ArrayList <Double> listetemps = new ArrayList<Double> ();
		ArrayList <Double> listevaleur = new ArrayList <Double> ();

		//for (int i=2; i<12; i++) {
		Graphe g = new Graphe (13);
		
		
		/*System.out.println("=== BRUTE FORCE ===");
		BruteForce graphe = new BruteForce (g);
		begin = System.currentTimeMillis();
		graphe.lancement(); //System.out.println("Distance : " + graphe.minparcours);
		end = System.currentTimeMillis();
//		time = ((float) (end-begin)) / 1000f;
//		System.out.println("Temps d'execution : " + time);
		listetemps.add(((double) (end-begin)) / 1000f);
		listevaleur.add(graphe.minparcours);
		
		System.out.println();

		System.out.println("=== BACKTRACK ===");
		BackTrack graphe3 = new BackTrack (g);
		begin = System.currentTimeMillis();
		graphe3.lancement(); 
		System.out.println("Distance : " + graphe3.minparcours);
		end = System.currentTimeMillis();
		time = ((float) (end-begin)) / 1000f;
		System.out.println("Temps d'execution : " + time);
		listetemps.add(((double) (end-begin)) / 1000f);
		listevaleur.add(graphe3.minparcours);
*/		
		System.out.println();

		System.out.println("=== BACKTRACK VERSION 2===");
		BackTrack_v2 graphe4 = new BackTrack_v2 (g);
		begin = System.currentTimeMillis();
		graphe4.lancement();	System.out.println("Distance : " + graphe4.minparcours);
		end = System.currentTimeMillis();
		time = ((float) (end-begin)) / 1000f;
		System.out.println("Temps d'execution : " + time);
		
		System.out.println();
		
		System.out.println("=== ALGO_2_Opt ===");
		Algo2Opt graphe5 = new Algo2Opt(g);
		begin = System.currentTimeMillis();
		graphe5.lancement();	
		System.out.println("Distance : " + graphe5.minparcours);
		end = System.currentTimeMillis();
		time = ((float) (end-begin)) / 1000f;
		System.out.println("Temps d'execution : " + time);
		listetemps.add(((double) (end-begin)) / 1000f);
		listevaleur.add(graphe5.minparcours);
		
		System.out.println();
		
		System.out.println("=== PLUS PROCHES VOISINS ===");
		ProchesVoisins graphe6 = new ProchesVoisins (g);
		begin = System.currentTimeMillis();
		graphe6.lancement();	
		System.out.println("Distance : " + graphe6.minparcours);
		end = System.currentTimeMillis();
		time = ((float) (end-begin)) / 1000f;
		System.out.println("Temps d'execution : " + time);
		listetemps.add(((double) (end-begin)) / 1000f);
		listevaleur.add(graphe6.minparcours);

		System.out.println();

		System.out.println("=== KRUSKAL ===");
		Algo_Kruskal graphe7 = new Algo_Kruskal (g);
		begin = System.currentTimeMillis();
		graphe7.lancement();
		end = System.currentTimeMillis();
		time = ((float) (end-begin)) / 1000f;
		System.out.println(graphe7.cout());
		System.out.println("Temps d'execution : " + time);
		listetemps.add(((double) (end-begin)) / 1000f);
		listevaleur.add(graphe7.cout());
		
//		System.out.println("===== TEMPS =====");
//		for (Double d : listetemps)
//		{
//			System.out.print(d.doubleValue() + " ");
//		}
//		
//		System.out.println("===== DISTANCE =====");
//		for (Double d : listevaleur)
//		{
//			System.out.print(d.doubleValue() + " ");
//		}
//		
//		listetemps.clear();
//		listevaleur.clear();

		}

	//}
}
