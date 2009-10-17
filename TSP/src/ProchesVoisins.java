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
	private int [] [] mat;
	private int nombrevilles;
	private int nombreAretesParcourues = 0;
	private int sommeDistances = 0;

	// Tableau qui contient les aretes déjà utilisées
	//private int [] tab;
	//private int indiceTab = 0;

	public ProchesVoisins (int n, int [][] matriceVilles)
	{
		// Constructeur où on prend en paramètre le nombre de villes.
		this.nombrevilles = n;
		this.mat = matriceVilles;
	}

	public void RandomisationVilleDepart ()
	{
		// On choisit une ville au hasard
		Random rd = new Random ();       
		this.villeDepart = rd.nextInt(nombrevilles-1);		// On prend une ville au hasard. "-1" car le tableau comprend un indice 0.
		while (this.villeDepart == 0)
		{
			this.villeDepart = rd.nextInt(nombrevilles-1);
		}
		this.villeUn = villeDepart;							// Et on la sauvegarde dans villeUn (pour y retourner à la fin du parcours)
		System.out.println("La ville de depart est : " + villeUn);
	}

	public int main ()
	// Renvoie la distance du parcours des points du graphe.
	{

		// Tant que on n'a pas parcouru tous les points du graphe
		while (nombreAretesParcourues < (nombrevilles - 1))
		{
			int compteur = 1;
			if (nombreAretesParcourues == 0)
			{
				RandomisationVilleDepart ();			// Si on est au départ du parcours, on choisit une ville au hasard
			}

			for (int i=0 ; i < (nombrevilles) ; i++)	// A revoir pour la diagonale.
			{
				if ((mat [villeUn] [i] != (-1)) && (mat [villeUn] [i] != 0))		// Si on n'est jamais passé par la ville et si on n'est pas sur la diagonale
				{
					// La premiere bonne valeur est stockée dans petiteArete
					if (compteur == 1)
					{
						petiteArete = mat [villeUn] [i];
						villeDeux = i;
						compteur++; 	// Cette condition ne sera plus utilisée après
					}
					// Si on trouve un point plus petit que celui de base
					else if (mat [villeUn] [i] < petiteArete)
					{
						// Alors c'est le plus proche voisin
						villeDeux = i;
						petiteArete = mat [villeUn] [i];
					}
				}
			}
			// On a maintenant le voisin le plus proche de notre point.
			sommeDistances += petiteArete;          // on incrémente la distance.
			nombreAretesParcourues++;                        // on incrémente le nombre d'aretes.
			// On stockera ici l'arete par concaténation dans tab (je ne sais pas encore)
			System.out.println("Ville Un : "+villeUn+" vers Ville Deux : " + villeDeux);

			if (nombreAretesParcourues == nombrevilles - 1)
				sommeDistances += mat [villeDeux] [villeDepart];
			else
				mat [villeUn] [villeDeux]  = (-1); mat [villeDeux] [villeUn] = (-1);

			villeUn = villeDeux;
		}	
		return sommeDistances;
	}
}

