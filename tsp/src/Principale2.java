import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Principale2 {


	public static void main(String[] args) throws IOException {

		long begin, end; double time;
		
		for (int j = 14; j < 16; j++)
	{
			int nombre_villes = j;

		// FAIRE LA MODIFICATION SUR LA LIGNE AU-DESSOUS : CHANGER LE CHEMIN ET LE NOM DU FICHIER
		PrintWriter ecri = new PrintWriter(new FileWriter("/home/tommi/tsp/TestTSP_20_janvier/" + nombre_villes + "_points.txt"));
		try
		{   
			ArrayList <Double> listetempsBruteForce = new ArrayList<Double> ();
			ArrayList <Double> listevaleurBruteForce = new ArrayList <Double> ();

			ArrayList <Double> listetempsBackTrack = new ArrayList<Double> ();
			ArrayList <Double> listevaleurBackTrack = new ArrayList <Double> ();
			
			ArrayList <Double> listetempsBackTrackv2 = new ArrayList<Double> ();
			ArrayList <Double> listevaleurBackTrackv2 = new ArrayList <Double> ();
			
			ArrayList <Double> listetempsBackTrackv3 = new ArrayList<Double> ();
			ArrayList <Double> listevaleurBackTrackv3 = new ArrayList <Double> ();
			
			ArrayList <Double> listetempsBackTrackv4 = new ArrayList<Double> ();
			ArrayList <Double> listevaleurBackTrackv4 = new ArrayList <Double> ();

			ArrayList <Double> listetempsAlgo2Opt = new ArrayList<Double> ();
			ArrayList <Double> listevaleurAlgo2Opt = new ArrayList <Double> ();

			ArrayList <Double> listetempsProchesVoisins = new ArrayList<Double> ();
			ArrayList <Double> listevaleurProchesVoisins = new ArrayList <Double> ();

			
			ecri.println("======= GRAPHE AVEC " + nombre_villes + " POINTS =======");
			listetempsAlgo2Opt.clear();
			listetempsBackTrack.clear();
			listetempsBruteForce.clear();
			listetempsProchesVoisins.clear();

			listevaleurAlgo2Opt.clear();
			listevaleurBackTrack.clear();
			listevaleurBruteForce.clear();
			listevaleurProchesVoisins.clear();

			
			
			for (int i=0; i<1; i++)
			{
				Graphe g = new Graphe (nombre_villes);

				/*ecri.println("=== BRUTE FORCE ===");
				BruteForce graphe = new BruteForce (g);
				begin = System.currentTimeMillis();
				graphe.lancement(); 
				end = System.currentTimeMillis();
				ecri.println("Distance : " + graphe.minparcours);
				time = ((float) (end-begin)) / 1000;
				ecri.println("Temps d'execution : " + time);
				listetempsBruteForce.add(time);
				listevaleurBruteForce.add(graphe.minparcours);

				ecri.println();
				*/
				ecri.println("=== BACKTRACK VERSION 4 : BackTrack + Init 2Opt + Condition MST ===");
				BackTrack_v4 graphe4 = new BackTrack_v4 (g);
				begin = System.currentTimeMillis();
				graphe4.lancement();	
				end = System.currentTimeMillis();
				ecri.println("Distance : " + graphe4.minparcours);
				time = (end - begin) / 1000;
				ecri.println("Temps d'execution : " + time);
				listetempsBackTrackv4.add(time);
				listevaleurBackTrackv4.add(graphe4.minparcours);

				ecri.println();

				ecri.println("=== BACKTRACK VERSION 3 : BackTrack + Init 2Opt===");
				BackTrack_v3 graphe2 = new BackTrack_v3 (g);
				begin = System.currentTimeMillis();
				graphe2.lancement();	
				end = System.currentTimeMillis();
				ecri.println("Distance : " + graphe2.minparcours);
				time = (end - begin)/ 1000;
				listetempsBackTrackv3.add(time);
				listevaleurBackTrackv3.add(graphe2.minparcours);
				ecri.println("Temps d'execution : " + time);
			
				ecri.println();

				ecri.println("=== BACKTRACK VERSION 2 : BackTrack + MST===");
				BackTrack_v2 graphe1 = new BackTrack_v2 (g);
				begin = System.currentTimeMillis();
				graphe1.lancement();	
				end = System.currentTimeMillis();
				ecri.println("Distance : " + graphe1.minparcours);
				time = (end - begin)/ 1000;
				listetempsBackTrackv2.add(time);
				listevaleurBackTrackv2.add(graphe1.minparcours);
				ecri.println("Temps d'execution : " + time);
				
				ecri.println();

				ecri.println("=== BACKTRACK VERSION 1 : BackTrack===");
				BackTrack graphe0 = new BackTrack(g);
				begin = System.currentTimeMillis();
				graphe0.lancement();	
				end = System.currentTimeMillis();
				ecri.println("Distance : " + graphe0.minparcours);
				time = (end - begin)/ 1000;
				listetempsBackTrack.add(time);
				listevaleurBackTrack.add(graphe0.minparcours);
				ecri.println("Temps d'execution : " + time);
				ecri.println();

				ecri.println("=== ALGO_2_Opt ===");
				Algo2Opt graphe5 = new Algo2Opt(g);
				begin = System.currentTimeMillis();
				graphe5.lancement();	
				end = System.currentTimeMillis();
				ecri.println("Distance : " + graphe5.minparcours);
				time = ((float) (end-begin)) / 1000;
				ecri.println("Temps d'execution : " + time);
				listetempsAlgo2Opt.add(time);
				listevaleurAlgo2Opt.add(graphe5.minparcours);

				ecri.println();

				ecri.println("=== PLUS PROCHES VOISINS ===");
				ProchesVoisins graphe6 = new ProchesVoisins (g);
				begin = System.currentTimeMillis();
				graphe6.lancement();	
				end = System.currentTimeMillis();
				ecri.println("Distance : " + graphe6.minparcours);
				time = ((float) (end-begin)) / 1000;
				ecri.println("Temps d'execution : " + time);
				listetempsProchesVoisins.add(time);
				listevaleurProchesVoisins.add(graphe6.minparcours);

				//	ecri.println();
				/*
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

				System.out.println("FIN BOUCLE " + i);
			}
			
			double temps = 0;
			for (Double d : listetempsBruteForce)
			{
				temps = temps + d;
			}
			temps = temps / listetempsBruteForce.size();

			double distance = 0;
			for (Double d : listevaleurBruteForce)
			{
				distance = distance + d;
			}
			distance = distance / listevaleurBruteForce.size();

			ecri.println("BruteForce : Temps : " + temps + "        Distance : " + distance);


			temps = 0;
			for (Double d : listetempsBackTrack)
			{
				temps = temps +  d;
			}
			temps = temps / listetempsBackTrack.size();

			distance = 0;
			for (Double d : listevaleurBackTrack)
			{
				distance = distance + d;
			}
			distance = distance / listevaleurBackTrack.size();

			ecri.println("1 - BackTrack : Temps : " + temps + "        Distance : " + distance);
			
			temps = 0;
			for (Double d : listetempsBackTrackv2)
			{
				temps = temps +  d;
			}
			temps = temps / listetempsBackTrackv2.size();

			distance = 0;
			for (Double d : listevaleurBackTrackv2)
			{
				distance = distance + d;
			}
			distance = distance / listevaleurBackTrackv2.size();

			ecri.println("2 - BackTrack + MST : Temps : " + temps + "        Distance : " + distance);
			
			
			temps = 0;
			for (Double d : listetempsBackTrackv3)
			{
				temps = temps +  d;
			}
			temps = temps / listetempsBackTrackv3.size();

			distance = 0;
			for (Double d : listevaleurBackTrackv3)
			{
				distance = distance + d;
			}
			distance = distance / listevaleurBackTrackv3.size();

			ecri.println("3 - BackTrack + Init2Opt : Temps : " + temps + "        Distance : " + distance);

			
			temps = 0;
			for (Double d : listetempsBackTrackv4)
			{
				temps = temps +  d;
			}
			temps = temps / listetempsBackTrackv4.size();

			distance = 0;
			for (Double d : listevaleurBackTrackv4)
			{
				distance = distance + d;
			}
			distance = distance / listevaleurBackTrackv4.size();

			ecri.println("4 - BackTrack + Init2Opt + MST : Temps : " + temps + "        Distance : " + distance);



			temps = 0;
			for (Double d : listetempsAlgo2Opt)
			{
				temps = temps +  d;
			}
			temps = temps / listetempsAlgo2Opt.size();

			distance = 0;
			for (Double d : listevaleurAlgo2Opt)
			{
				distance = distance + d;
			}
			distance = distance / listevaleurAlgo2Opt.size();

			ecri.println("Algo 2 Opt : Temps : " + temps + "        Distance : " + distance);




			temps = 0;
			for (Double d : listetempsProchesVoisins)
			{
				temps = temps +  d;
			}
			temps = temps / listetempsProchesVoisins.size();

			distance = 0;
			for (Double d : listevaleurProchesVoisins)
			{
				distance = distance + d;
			}
			distance = distance / listevaleurProchesVoisins.size();

			ecri.println("Proches Voisins : Temps : " + temps + "        Distance : " + distance);



			

			ecri.flush();
			ecri.close();
		}
		catch (NullPointerException a)
		{
			System.out.println("Erreur : pointeur null");
		}



	}
	}
}