/* Algorithme des plus proches voisins.
Algorithme heuristique. 
But : On prend un sommet de départ. On recherche le sommet qui est le plus proche.
On va à ce sommet et ainsi de suite. On reviens au point de départ à la fin.
*/

public class Proches_Voisins
{
    private int ordonneeDepart;
    private int abscisseDepart;
    private int departAbs;
    private int departOrd;
    private int [] [] mat;
    private int nombrevilles;
    private int nombreAretesDeja;
    private int sommeDistances = 0;
    private int [] tab;                         // Tableau qui contient les aretes déjà utilisées
    private int indiceTab = 0;

    public Proches_Voisins (int n)
    {
	// Constructeur où on prend en paramètre le nombre de villes.
	this.nombrevilles = n;
	mat = new int [n] [n];                // A voir avec une autre classe pour l'initialisation
        tab = new int [n];
    }

    public RandomisationNombreDepart ()
    {
	// On prend un point au hasard dans la partie haute de la matrice. 
	Random rd = new Random ();       
	this.ordonneeDepart = rd.nextInt(nombrevilles / 2);
	this.departOrd = ordonneeDepart;
	this.abscisseDepart = rd.nextInt(nombrevilles / 2);
	this.departAbs = abscisseDepart;
    }

    public int main ()
    // Renvoie la distance du parcours des points du graphe.
    {
	// Tant que on n'a pas parcouru tous les points du graphe
	while (nombreAretesDeja < (nombrevilles - 1))
	    {
		// On stocke la longueur du point randomisé au dessus dans pluspetit.
		pluspetit = Mat [abscisseDepart] [ordonneeDepart];
		for (i=0, j=0 ; i < (nombrevilles/2), j < (nombrevilles/2); i++, j++)
		    {
			// Si on trouve un point plus petit que celui de base
			if Mat [i] [j] < pluspetit
				   {
				       // Alors c'est le plus proche voisin
				       pluspetitabscisse = i; pluspetitordonne = j;
				       pluspetit = Mat [i] [j];
				   }
		    }

		// On a maintenant le voisin le plus proche de notre point.
		sommeDistances += pluspetit;          // on incrémente la distance.
                nombreAretesDeja++;                        // on incrémente le nombre d'aretes.
		// On stockera ici l'arete par concaténation dans tab (je ne sais pas encore)
	        indiceTab++;
		abscisseDepart = pluspetitabscisse;
		ordonneeDepart = pluspetitordonnee;
		if (nombreAretesDeja == nombrevilles - 1)
		    s += Mat [abscissedebut] [ordonneedebut];
		else
		    Mat [pluspetitabscisse] [pluspetitordonnee]  = (-1);
	    }	
	// On a parcouru tous les sommets du graphe.
	// On revient au point de départ.
      
	return sommeDistances;
    }