import java.util.Random;

public class ProchesVoisins 
{
	/* Algorithme des plus proches voisins.
	Algorithme heuristique. 
	But : On prend un sommet de départ. On recherche le sommet qui est le plus proche.
	On va à ce sommet et ainsi de suite. On reviens au point de départ à la fin.
	 */

	private int villeDepart;
	private int villeUn;
	private int villeDeux;
	private int petiteArete;
	private int compteur;
	private int [] [] mat;
	private int [] [] matdebut;
	private int nombrevilles;
	private int nombreSommetsParcourus = 0;
	private int sommeDistances = 0;

	// Tableau qui contient les aretes déjà utilisées
	//private int [] tab;
	//private int indiceTab = 0;

	public ProchesVoisins (int n, int [][] matriceVilles)
	{
		// Constructeur où on prend en paramètre le nombre de villes.
		this.nombrevilles = n;
		this.mat = matriceVilles;
		matdebut = new int [n][n];
		cloneMat();
	}

	public void cloneMat ()
	{
		for (int i = 0; i < nombrevilles ; i++)
		{
			for (int j = 0 ; j < nombrevilles; j++)
			{
				matdebut[i][j] = mat[i][j];
			}
		}
	}
	
	public void afficheMat (int [] [] mat)
	{
		System.out.println("\n\n\n");
		for (int i = 0 ; i < nombrevilles; i++)
		{
			for (int j = 0; j < nombrevilles; j++)
			{
				System.out.print(mat [i][j]);
				System.out.print(" ");
			}
			System.out.println("\n");
		}
		System.out.println("\n\n\n");
	}

	public void RandomisationVilleDepart ()
	{
		// On choisit une ville au hasard
		Random rd = new Random ();       
		this.villeDepart = 0 ; //rd.nextInt(nombrevilles-1);		// On prend une ville au hasard. "-1" car le tableau comprend un indice 0.
		this.villeUn = villeDepart;							// Et on la sauvegarde dans villeUn (pour y retourner à la fin du parcours)
		System.out.println("La ville de depart est : " + villeUn);
	}

	public int main ()
	// Renvoie la distance du parcours des points du graphe.
	{

		// Tant que on n'a pas parcouru tous les points du graphe
		while (nombreSommetsParcourus < (nombrevilles-1))
		{
			if (nombreSommetsParcourus == 0)
			{
				RandomisationVilleDepart ();			// Si on est au départ du parcours, on choisit une ville au hasard
			}

			compteur = 1;
			for (int i=0 ; i < nombrevilles ; i++)	
			{
				if ((mat [villeUn] [i] != (-1)) && (mat [villeUn] [i] != 0))		// Si on n'est jamais passé par la ville et si on n'est pas sur la diagonale
				{
					if (compteur == 1)
					{
						petiteArete = mat [villeUn] [i];
						villeDeux = i;
						compteur++;
					}

					if ((mat [villeUn] [i]) < petiteArete)
					{
						// Alors c'est le plus proche voisin
						villeDeux = i;
						petiteArete = mat [villeUn] [i];
					}
				}

			}
			// On a maintenant le voisin le plus proche de notre point.
			sommeDistances += petiteArete;          // on incrémente la distance.
			nombreSommetsParcourus++;				// on incrémente le nombre de sommets.

			System.out.println("Ville : "+villeUn+" vers Ville : " + villeDeux + "\t\tDistance : " + petiteArete +"\tDistance totale : " + sommeDistances);
			//System.out.println(mat [villeDeux] [villeDepart]);

			for (int k = 0; k < nombrevilles ; k++)
			{
				mat [villeUn] [k] = (-1); mat [k] [villeUn] = (-1);
			}
			mat [villeDeux] [villeUn] = (-1);

			villeUn = villeDeux;
			//afficheMat(mat);
		}
		
		//afficheMat(matdebut);
		sommeDistances += matdebut [villeDeux] [villeDepart]; 
		System.out.println("Ville : " + villeDeux + " vers Ville : " + villeDepart + "\t\tDistance : " + matdebut [villeDeux] [villeDepart]);
		
		return sommeDistances;
	}
}

