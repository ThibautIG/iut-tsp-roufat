public class ProchesVoisins 
{
	/* Algorithme des plus proches voisins.
	Algorithme heuristique. 
	But : On prend un sommet de départ. On recherche le sommet qui est le plus proche.
	On va à ce sommet et ainsi de suite. On revient au point de départ à la fin.
	 */

	private int villeDepart;					// Ville de départ : où on part.
	private int villeUn;						// Première ville dans la méthode main
	private int villeDeux;						// Deuxième ville dans la méthode main
	private int petiteArete;					// Distance minimale entre la 1e ville et la 2e ville
	private int compteur;						// Utile pour définir la première arête valide d'une ligne de villes
	private int [] [] mat;						// Matrice de villes.
	private int [] [] matdebut;					// Matrice clonée de mat. (utile pour le dernier trajet)
	private int nombrevilles;					// Nombre de villes
	private int nombreSommetsParcourus = 0;		// Nombre de villes parcourues
	private int sommeDistances = 0;				// Somme des distances totales

	public ProchesVoisins (int n, int [][] matriceVilles)
	{
		// Constructeur où on prend en paramètre le nombre de villes et la matrice créée.
		this.nombrevilles = n;
		this.mat = matriceVilles;
		matdebut = new int [n][n];
		cloneMat();
	}

	public void cloneMat ()
	// Permet de cloner la première matrice (utile pour le dernier trajet. Dernière ville --> ville de départ)
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
	// Affichage de la matrice.
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
		// TO DO :
		// Essayer de mettre un Pour dans le main qui calcule pour chaque point de commencement, la distance finale.
		// Puis retourner la plus petite distance du tableau obtenu.
		this.villeDepart = 0 ;	
		this.villeUn = villeDepart;							// Et on la sauvegarde dans villeUn (pour y retourner à la fin du parcours)
		System.out.println("La ville de depart est : " + villeUn);
	}

	public int main ()
	// Renvoie la distance du parcours des points du graphe.
	{

		// Tant que on n'a pas parcouru tous les points du graphe
		while (nombreSommetsParcourus < (nombrevilles-1))
		{
			// Si on est au départ du parcours, on choisit une ville au hasard
			if (nombreSommetsParcourus == 0)
			{
				RandomisationVilleDepart ();			
			}

			compteur = 1;
			// Parcours d'une ligne de ville
			for (int i=0 ; i < nombrevilles ; i++)	
			{
				// On exclut les villes par lesquelles on est déjà passé et celles qui sont sur la diagonale.
				if ((mat [villeUn] [i] != (-1)) && (mat [villeUn] [i] != 0))		
				{
					// Si c'est la première arête valide de la ligne
					if (compteur == 1)
					{
						petiteArete = mat [villeUn] [i];
						villeDeux = i;
						compteur++;
					}
					
					// Si ce n'est pas la première
					if ((mat [villeUn] [i]) < petiteArete)
					{
						// Alors c'est le plus proche voisin
						// On enregistre l'indice de la ville
						villeDeux = i;
						// Et la distance entre la ville un et la ville deux
						petiteArete = mat [villeUn] [i];
					}
				}

			}
			// On a maintenant le voisin le plus proche de notre point
			// Incrémentation de la distance totale
			sommeDistances += petiteArete;     
			// Incrémentation du nombre de sommets
			nombreSommetsParcourus++;				
		
			// Affichage du parcours : ville 1 vers ville 2
			System.out.println("Ville : "+villeUn+" vers Ville : " + villeDeux + "\t\tDistance : " + petiteArete +"\tDistance totale : " + sommeDistances);

			// On remplace par (-1) les lignes et les colonnes correspondant aux villes où on vient de passer
			for (int k = 0; k < nombrevilles ; k++)
			{
				mat [villeUn] [k] = (-1); mat [k] [villeUn] = (-1);
			}
			mat [villeDeux] [villeUn] = (-1);

			// Et on affecte ville 1 de ville 2. Ce qui nous permet de recommencer le cycle
			villeUn = villeDeux;
			//afficheMat(mat);
		}
		
		//afficheMat(matdebut);
		// On incrémente le retour (dernière ville à ville de départ)
		sommeDistances += matdebut [villeDeux] [villeDepart]; 
		System.out.println("Ville : " + villeDeux + " vers Ville : " + villeDepart + "\t\tDistance : " + matdebut [villeDeux] [villeDepart]);
		
		// Et on retourne la somme des distances finales.
		return sommeDistances;
	}
}

