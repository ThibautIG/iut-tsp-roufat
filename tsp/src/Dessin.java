import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Dessin extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel menugrille;
	private int dimensionGrille = 50;			// Par défaut
	private boolean grilleActive = true;
	private JButton bActivation, bCouleur;
	private JTextField nbrVillesFenetre;
	private Color couleurChoisie = Color.RED;
	public static Graphe graphe = new Graphe();
	private int sourisX, sourisY;
	private String methode;
	private boolean valide = false;
	private boolean bvalide = false;		// Bouton valider
	private boolean gvalide = true;			// False si on est déjà passé par la generation

	private Resultats result;

	private CreationGraphe choix;

	/**
	 * 
	 * @param s : Chaine de caractères qui explicite la méthode employée (bruteforce, backtrack, etc.).
	 */
	public Dessin (String s, Resultats result, JTextField nbrville)
	{
		Dessin.graphe = new Graphe();
		this.result = result;
		this.nbrVillesFenetre = nbrville;

		setLayout(new BorderLayout());
		barreMenu ();

		// Ecouteur de la souris
		addMouseListener(this);
		addMouseMotionListener(this);

		// Enregistrement de la methode employee
		this.methode = s;

	}

	public void barreMenu ()
	{
		// Barre de menu en bas de la grille
		menugrille = new JPanel ();
		menugrille.setLayout(new FlowLayout(FlowLayout.LEFT));

		// Bouton d'Activation / Desactivation de la grille
		bActivation = new JButton ("Activation/Desactivation Grille");
		bActivation.setActionCommand("activationgrille"); bActivation.addActionListener(this);

		// Bouton de choix de couleur pour le pointeur
		bCouleur = new JButton("Couleur du Pointeur");
		bCouleur.setActionCommand("couleurpointeur"); bCouleur.addActionListener(this);

		menugrille.add(bActivation); menugrille.add(bCouleur);
		this.add(menugrille, BorderLayout.SOUTH);

	}

	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);

		System.out.println("Dans le paint component avec bvalide = " + bvalide);
		// Affichage de la grille
		affichageGrille(g);

		// Affichage des coordonnees de la souris
		coordonneesSouris(g);

		// Affichage des points
		graphe.dessineVilles(g, couleurChoisie);

		// Affichage du parcours
		System.out.println("Avant l'affichage du parcours : Methode : " + methode + " Valide : " + valide + " BValide : " + bvalide);
		if (valide && bvalide)
		{
			System.out.println("Methode utilisee : " + methode);
			this.generationParcours(g);
			System.out.println("Apres la generation");
			gvalide = false;
		}
	}

	public void affichageGrille (Graphics g)
	{
		if (grilleActive)
		{
			g.setColor(Color.gray);
			for (int i = 1; i < this.getWidth()/dimensionGrille; i++)
			{
				g.drawLine(0, i*dimensionGrille,this.getWidth() , i*dimensionGrille);
				g.drawLine(i*dimensionGrille, 0, i*dimensionGrille, this.getHeight());
			}
		}
	}

	public void setCliqueParcours (boolean b)
	{
		this.valide = b;
		System.out.println("passe par set avec comme methode : " + methode + " et avec comme valide : " + b);
		this.repaint();
	}

	public void setBoutonValider (boolean b)
	{
		this.bvalide = b;
		System.out.println("Dans le SETBOUTONVALIDER avec methode : " + methode + " et avec valide : " + valide + " et avec bvalide : " + bvalide);
		this.repaint();
	}


	public void generationVilles (int nbrVilles)
	{
		Dessin.graphe = new Graphe(nbrVilles);
		this.repaint();
	}


	// MOUVEMENTS DE LA SOURIS
	public void coordonneesSouris (Graphics g)
	{
		g.drawString("("+sourisX+","+sourisY+")",10,20);
	}

	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {
		// Si la souris est dans la grille
		if (contains(e.getX(),e.getY()))
		{
			sourisX = e.getX();
			sourisY = e.getY();
			repaint();
		}
	}


	/** 
	 * 
	 * 
	 */
	public void generationParcours (Graphics g)
	{

		System.out.println("Dans GenerationParcours");
		if (methode.equals("bruteforce"))
		{
			if (gvalide) 
			{choix = new BruteForce(graphe);
			((BruteForce) choix).lancement();}
			choix.affichageParcoursGraphe(g, dimensionGrille);
			result.remplirCases(choix.minparcours, choix.tempsParcours);
		}
		else if (methode.equals("backtrack"))
		{
			if (gvalide)
			{choix = new BackTrack(graphe);
			((BackTrack) choix).lancement();}
			choix.affichageParcoursGraphe(g, dimensionGrille);
			result.remplirCases(choix.minparcours, choix.tempsParcours);
		}
		else if (methode.equals("backtrackv2"))
		{
			if (gvalide)
			{choix = new BackTrack_v2(graphe);
			((BackTrack_v2) choix).lancement();}
			choix.affichageParcoursGraphe(g, dimensionGrille);
			result.remplirCases(choix.minparcours, choix.tempsParcours);
			
		}
		else if (methode.equals("backtrackv3"))
		{
			if (gvalide)
			{choix = new BackTrack_v3(graphe);
			((BackTrack_v3) choix).lancement();}
			choix.affichageParcoursGraphe(g, dimensionGrille);
			result.remplirCases(choix.minparcours, choix.tempsParcours);
			
		}
		else if (methode.equals("backtrackv4"))
		{
			if (gvalide)
			{choix = new BackTrack_v4(graphe);
			((BackTrack_v4) choix).lancement();}
			choix.affichageParcoursGraphe(g, dimensionGrille);
			result.remplirCases(choix.minparcours, choix.tempsParcours);
			
		}
		else if (methode.equals("mst"))
		{
			if (gvalide) 
			{choix = new Algo_MST(graphe);
			((Algo_MST) choix).lancement();}
			choix.affichageParcoursGraphe(g, dimensionGrille);
			result.remplirCases(choix.minparcours, choix.tempsParcours);
		}
		else if (methode.equals("opt"))
		{
			if (gvalide) 
			{choix = new Algo2Opt(graphe);
			((Algo2Opt) choix).lancement();}
			choix.affichageParcoursGraphe(g, dimensionGrille);
			System.out.println("Min parcours : " + choix.minparcours + "Temps parcours : " + choix.tempsParcours);
			this.result.remplirCases(choix.minparcours, choix.tempsParcours);
		}
		else if (methode.equals("plusprochesvoisins"))
		{
			if (gvalide) 
			{choix = new ProchesVoisins(graphe);
			((ProchesVoisins) choix).lancement();}
			choix.affichageParcoursGraphe(g, dimensionGrille);
			this.result.remplirCases(choix.minparcours, choix.tempsParcours/1000);
		}


	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getActionCommand().equals("activationgrille"))
		{
			if (this.grilleActive == true) { this.grilleActive = false;}
			else {this.grilleActive = true;}
			this.repaint();
		}
		else if (ev.getActionCommand().equals("couleurpointeur"))
		{
			couleurChoisie = JColorChooser.showDialog(this,"Choose Background Color",getBackground());
		}
		else if (ev.getActionCommand().equals("effacergrille"))
		{
			Graphe.listePoints.clear();
			graphe.miseZeroIdentVille();
			repaint();
		}
	}

	public void mousePressed(MouseEvent ev) {}
	public void mouseClicked(MouseEvent ev) 
	{	
		// Si le graphe a deja ete valide, on n'autorise pas de nouveau point
		if (gvalide)
		{
			int x = ev.getX();
			int y = ev.getY();
			graphe.addPoint(x,y);
			nbrVillesFenetre.setText(Graphe.listePoints.size() + "");
			System.out.println("passe");
			repaint();
		}
	} 
	public void mouseEntered(MouseEvent arg0) {	}
	public void mouseExited(MouseEvent arg0) { }
	public void mouseReleased(MouseEvent arg0) { }


}
