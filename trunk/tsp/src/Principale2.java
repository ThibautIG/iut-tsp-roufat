import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Principale2 {


	public static void main(String[] args) throws IOException {

		long begin, end; double time;
		int nombre_villes = 17;
		
		// FAIRE LA MODIFICATION SUR LA LIGNE AU-DESSOUS : CHANGER LE CHEMIN ET LE NOM DU FICHIER
		PrintWriter ecri = new PrintWriter(new FileWriter("/home/tommi/TestTSP/essai_" + nombre_villes + "_points"));
		try
		{   
			ArrayList <Double> listetempsBruteForce = new ArrayList<Double> ();
			ArrayList <Double> listevaleurBruteForce = new ArrayList <Double> ();

			ArrayList <Double> listetempsBackTrack = new ArrayList<Double> ();
			ArrayList <Double> listevaleurBackTrack = new ArrayList <Double> ();

			ArrayList <Double> listetempsAlgo2Opt = new ArrayList<Double> ();
			ArrayList <Double> listevaleurAlgo2Opt = new ArrayList <Double> ();

			ArrayList <Double> listetempsProchesVoisins = new ArrayList<Double> ();
			ArrayList <Double> listevaleurProchesVoisins = new ArrayList <Double> ();

			//for (int j = 15; j < 18; j++)
			//{
				ecri.println("======= GRAPHE AVEC " + nombre_villes + " POINTS =======");
				listetempsAlgo2Opt.clear();
				listetempsBackTrack.clear();
				listetempsBruteForce.clear();
				listetempsProchesVoisins.clear();

				listevaleurAlgo2Opt.clear();
				listevaleurBackTrack.clear();
				listevaleurBruteForce.clear();
				listevaleurProchesVoisins.clear();

				for (int i=0; i<10; i++)
				{
					Graphe g = new Graphe (nombre_villes);

/*
					//ecri.println("=== BRUTE FORCE ===");
					BruteForce graphe = new BruteForce (g);
					begin = System.currentTimeMillis();
					graphe.lancement(); //ecri.println("Distance : " + graphe.minparcours);
					end = System.currentTimeMillis();
					time = ((float) (end-begin)) / 1000f;
					//ecri.println("Temps d'execution : " + time);
					listetempsBruteForce.add(((double) (end-begin)) / 1000f);
					listevaleurBruteForce.add(graphe.minparcours);
*/
					//ecri.println();

					//ecri.println("=== BACKTRACK VERSION 4===");
					BackTrack_v4 graphe4 = new BackTrack_v4 (g);
					begin = System.currentTimeMillis();
					graphe4.lancement();	
					//ecri.println("Distance : " + graphe4.minparcours);
					end = System.currentTimeMillis();
					time = (end - begin) / 1000f;
					listetempsBackTrack.add(time/1000);
					listevaleurBackTrack.add(graphe4.minparcours);
				//	ecri.println("Temps d'execution : " + time);
					/*
		 System.out.println("=== BACKTRACK VERSION 3===");
		 BackTrack_v3 graphe2 = new BackTrack_v3 (g);
		 begin = System.currentTimeMillis();
		 graphe2.lancement();	System.out.println("Distance : " + graphe4.minparcours);
		 end = System.currentTimeMillis();
		 time = (end - begin)/ 1000;
		 //listetempsBackTrack.add(time/1000);
		 //listevaleurBackTrack.add(graphe2.minparcours);
		 System.out.println("Temps d'execution : " + time);
					 */

					//ecri.println();

				//	ecri.println("=== ALGO_2_Opt ===");
					Algo2Opt graphe5 = new Algo2Opt(g);
					begin = System.currentTimeMillis();
					graphe5.lancement();	
				//	ecri.println("Distance : " + graphe5.minparcours);
					end = System.currentTimeMillis();
					time = ((float) (end-begin)) / 1000f;
				//	ecri.println("Temps d'execution : " + time);
					listetempsAlgo2Opt.add(time/1000);
					listevaleurAlgo2Opt.add(graphe5.minparcours);

				//	ecri.println();

				//	ecri.println("=== PLUS PROCHES VOISINS ===");
					ProchesVoisins graphe6 = new ProchesVoisins (g);
					begin = System.currentTimeMillis();
					graphe6.lancement();	
				//	ecri.println("Distance : " + graphe6.minparcours);
					end = System.currentTimeMillis();
					time = ((float) (end-begin)) / 1000f;
				//	ecri.println("Temps d'execution : " + time);
					listetempsProchesVoisins.add(time/1000);
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
				}
/*
				double temps = 0;
				for (Double d : listetempsBruteForce)
				{
					temps = temps +  d;
				}
				temps = temps / listetempsBruteForce.size();

				ecri.println("===== DISTANCE =====");
				double distance = 0;
				for (Double d : listevaleurBruteForce)
				{
					distance = distance + d;
				}
				distance = distance / listevaleurBruteForce.size();

				ecri.println("BruteForce : Temps : " + temps + "        Distance : " + distance);

*/

				double temps = 0;
				for (Double d : listetempsBackTrack)
				{
					temps = temps +  d;
				}
				temps = temps / listetempsBackTrack.size();

				ecri.println("===== DISTANCE =====");
				double distance = 0;
				for (Double d : listevaleurBackTrack)
				{
					distance = distance + d;
				}
				distance = distance / listevaleurBackTrack.size();

				ecri.println("BackTrack : Temps : " + temps + "        Distance : " + distance);




				temps = 0;
				for (Double d : listetempsAlgo2Opt)
				{
					temps = temps +  d;
				}
				temps = temps / listetempsAlgo2Opt.size();

				ecri.println("===== DISTANCE =====");
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

				ecri.println("===== DISTANCE =====");
				distance = 0;
				for (Double d : listevaleurProchesVoisins)
				{
					distance = distance + d;
				}
				distance = distance / listevaleurProchesVoisins.size();

				ecri.println("Proches Voisins : Temps : " + temps + "        Distance : " + distance);


				ecri.println();
				ecri.println();
			//}  

			ecri.flush();
			ecri.close();
		}
		catch (NullPointerException a)
		{
			System.out.println("Erreur : pointeur null");
		}



	}
}