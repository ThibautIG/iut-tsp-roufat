import java.util.ArrayList;
import java.util.Collections;

public class Algo_Kruskal extends CreationGraphe
{
	/* EnsArete est composé d'Aretes. Une arete contient un Point u, un Point v et la distance entre les deux u et v. */
	private ArrayList<Aretes> aretesCroiss;
	private ArrayList<Point> listePoints;
	private ArrayList<ArrayList<Point>> ensEns;
	private ArrayList<Point> ensPoints;
	


	public Algo_Kruskal (Graphe g)
	{
		super (g);
	}

	public void lancement ()
	{
		// Initialisation de ensAretes et de listePoints
		aretesCroiss = new ArrayList<Aretes>();
		/*listePoints = new ArrayList<Integer>();
		for (int i=0; i<super.g.getNbrVille(); i++) {listePoints.add(i);}*/
		listePoints = new ArrayList<Point>();
		listePoints = super.g.getListePoints();

		// Création des ensembles
		creationEnsemble ();

		// Création et tri du tableau d'Aretes
		initAretes();

		// Creation du graphe
		run ();
	}

	public void initAretes ()
	{
		// Initialisation des aretes
		for (int i = 0; i < listePoints.size(); i++)
		{
			for (int j= 0; j < listePoints.size() ; j++)
			{
				aretesCroiss.add(new Aretes(listePoints.get(i), listePoints.get(j)));
			}
		}

		// Tri des arêtes
		Collections.sort(aretesCroiss);

		// Suppression des arêtes vides
		ArrayList<Aretes> aEnlever = new ArrayList<Aretes>();
		for (Aretes a : aretesCroiss)
		{
			if (a.getPoids() == 0.0)
				aEnlever.add(a);
		}
		for (Aretes a : aEnlever) {aretesCroiss.remove(a);}

		/* Suppression des arêtes dupliques
		for (int i=0; i < ensAretes.size(); i = i+2)
		{
			ensAretes.remove(i);
		}*/

		// Affichage de l'ensemble des aretes
		afficheAretes(aretesCroiss);
	}

	public void creationEnsemble ()
	{
		for (int i=0; i < listePoints.size(); i++)
		{
			ensPoints = new ArrayList<Point>();
			ensEns.add(ensPoints);
			ensPoints.add(listePoints.get(i));
		}
	}

	public void run ()
	{
		int nbrAretes = 0;
		// Parcours de l'ensemble des arêtes
		while (nbrAretes < super.g.getNbrVille())
		{
			if (getIndexTab())
		}
	}

	public int getIndexTab (ArrayList<Integer> ensPts, int pt)
	{
		boolean trouve = false;
		int i = 0;
		while ((trouve == false) && (i<ensPts.size()))
		{
			if (ensPts.get(i) == pt)
			{
				trouve = true;
			}
			else
			{
				i++;
			}
		}
		return i;
	}

	public void union (ArrayList<Point> liste1, ArrayList<Point> liste2)
	{
		for (Point p : liste2)
		{
			liste1.add(p);
		}
		ensEns.remove(liste2);
	}



}
