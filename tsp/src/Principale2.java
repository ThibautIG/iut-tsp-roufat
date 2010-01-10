import java.util.ArrayList;

public class Principale2 {


	public static void main(String[] args) {



		long begin, end; double time;

		//		ArrayList <Double> listetempsBruteForce = new ArrayList<Double> ();
		//		ArrayList <Double> listevaleurBruteForce = new ArrayList <Double> ();
		//		
		//		ArrayList <Double> listetempsBackTrack = new ArrayList<Double> ();
		//		ArrayList <Double> listevaleurBackTrack = new ArrayList <Double> ();
		//		
		//		ArrayList <Double> listetempsAlgo2Opt = new ArrayList<Double> ();
		//		ArrayList <Double> listevaleurAlgo2Opt = new ArrayList <Double> ();
		//		
		//		ArrayList <Double> listetempsProchesVoisins = new ArrayList<Double> ();
		//		ArrayList <Double> listevaleurProchesVoisins = new ArrayList <Double> ();

		/*
		for (int i=0; i<10; i++)
		{
		 */Graphe g = new Graphe (13);

		 /*
		 System.out.println("=== BRUTE FORCE ===");
		 BruteForce graphe = new BruteForce (g);
		 begin = System.currentTimeMillis();
		 graphe.lancement(); System.out.println("Distance : " + graphe.minparcours);
		 end = System.currentTimeMillis();
		 time = ((float) (end-begin)) / 1000f;
		 System.out.println("Temps d'execution : " + time);
		 //listetempsBruteForce.add(((double) (end-begin)) / 1000f);
		 //listevaleurBruteForce.add(graphe.minparcours);

		 System.out.println();
		  */
		 System.out.println("=== BACKTRACK VERSION 4===");
		 BackTrack_v4 graphe4 = new BackTrack_v4 (g);
		 begin = System.currentTimeMillis();
		 graphe4.lancement();	
		 System.out.println("Distance : " + graphe4.minparcours);
		 end = System.currentTimeMillis();
		 time = (end - begin) / 1000;
		 //listetempsBackTrack.add(time/1000);
		 //listevaleurBackTrack.add(graphe4.minparcours);
		 System.out.println("Temps d'execution : " + time);

		 System.out.println("=== BACKTRACK VERSION 3===");
		 BackTrack_v3 graphe2 = new BackTrack_v3 (g);
		 begin = System.currentTimeMillis();
		 graphe2.lancement();	System.out.println("Distance : " + graphe4.minparcours);
		 end = System.currentTimeMillis();
		 time = (end - begin)/ 1000;
		 //listetempsBackTrack.add(time/1000);
		 //listevaleurBackTrack.add(graphe2.minparcours);
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
		 //listetempsAlgo2Opt.add(time/1000);
		 //listevaleurAlgo2Opt.add(graphe5.minparcours);

		 //	System.out.println();
		 /*
		//	System.out.println("=== PLUS PROCHES VOISINS ===");
			ProchesVoisins graphe6 = new ProchesVoisins (g);
			begin = System.currentTimeMillis();
			graphe6.lancement();	
			//System.out.println("Distance : " + graphe6.minparcours);
			end = System.currentTimeMillis();
			time = ((float) (end-begin)) / 1000f;
		//	System.out.println("Temps d'execution : " + time);
			listetempsProchesVoisins.add(time/1000);
			listevaleurProchesVoisins.add(graphe6.minparcours);

		//	System.out.println();

		System.out.println("=== KRUSKAL ===");
		Algo_Kruskal graphe7 = new Algo_Kruskal (g);
		begin = System.currentTimeMillis();
		graphe7.lancement();
		end = System.currentTimeMillis();
		time = ((float) (end-begin)) / 1000f;
		System.out.println("Temps d'execution : " + time);
		System.out.println("Cout : " + graphe7.minparcours);
		//listetemps.add(((double) (end-begin)) / 1000f);
		//listevaleur.add(graphe7.cout());
		  */		 	
	}
	/*		
		//System.out.println("===== TEMPS =====");
		double temps = 0;
		for (Double d : listetempsBruteForce)
		{
			temps = temps +  d;
		}
		temps = temps / listetempsBruteForce.size();

		//System.out.println("===== DISTANCE =====");
		double distance = 0;
		for (Double d : listevaleurBruteForce)
		{
			distance = distance + d;
		}
		distance = distance / listevaleurBruteForce.size();

		System.out.println("BruteForce : Temps : " + temps + "        Distance : " + distance);




		//System.out.println("===== TEMPS =====");
		temps = 0;
		for (Double d : listetempsBackTrack)
		{
			temps = temps +  d;
		}
		temps = temps / listetempsBackTrack.size();

		//System.out.println("===== DISTANCE =====");
		distance = 0;
		for (Double d : listevaleurBackTrack)
		{
			distance = distance + d;
		}
		distance = distance / listevaleurBackTrack.size();

		System.out.println("BackTrack : Temps : " + temps + "        Distance : " + distance);





		//System.out.println("===== TEMPS =====");
		temps = 0;
		for (Double d : listetempsAlgo2Opt)
		{
			temps = temps +  d;
		}
		temps = temps / listetempsAlgo2Opt.size();

	//	System.out.println("===== DISTANCE =====");
		distance = 0;
		for (Double d : listevaleurAlgo2Opt)
		{
			distance = distance + d;
		}
		distance = distance / listevaleurAlgo2Opt.size();

		System.out.println("Algo 2 Opt : Temps : " + temps + "        Distance : " + distance);




		//System.out.println("===== TEMPS =====");
		temps = 0;
		for (Double d : listetempsProchesVoisins)
		{
			temps = temps +  d;
		}
		temps = temps / listetempsProchesVoisins.size();

		//System.out.println("===== DISTANCE =====");
		distance = 0;
		for (Double d : listevaleurProchesVoisins)
		{
			distance = distance + d;
		}
		distance = distance / listevaleurProchesVoisins.size();

		System.out.println("Proches Voisins : Temps : " + temps + "        Distance : " + distance);


	 */
}

