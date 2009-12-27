import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;


public class Dessin extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel menugrille;
	private int dimensionGrille = 50;			// Par défaut
	private boolean grilleActive = true;
	private JButton bActivation, bCouleur, bEffacer, bValider;
	private Color couleurChoisie = Color.RED;
	public Graphe graphe = new Graphe();
	private int sourisX, sourisY;
	
	private ArrayList<String> listeParcours = new ArrayList<String>();
	private boolean valide = false;
	

	public Dessin ()
	{
		setLayout(new BorderLayout());
		barreMenu ();

		// Ecouteur de la souris
		addMouseListener(this);
		addMouseMotionListener(this);
		
			
	}

	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);

		// Affichage de la grille
		affichageGrille(g);

		// Affichage des coordonnees de la souris
		coordonneesSouris(g);

		// Affichage des points
		graphe.dessineVilles(g, couleurChoisie);

		
		// Affichage du parcours
		if (valide)
		{
			this.generationParcours(g);
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

	public void barreMenu ()
	{
		// Barre de menu en bas de la grille
		menugrille = new JPanel ();
		menugrille.setLayout(new FlowLayout(FlowLayout.LEFT));

		// Validation de la grille
		bValider = new JButton("Valider");
		bValider.setActionCommand("valider"); bValider.addActionListener(this);

		// Bouton d'Activation / Desactivation de la grille
		bActivation = new JButton ("Activation/Desactivation Grille");
		bActivation.setActionCommand("activationgrille"); bActivation.addActionListener(this);

		// Bouton de choix de couleur pour le pointeur
		bCouleur = new JButton("Couleur du Pointeur");
		bCouleur.setActionCommand("couleurpointeur"); bCouleur.addActionListener(this);

		bEffacer = new JButton ("Effacer");
		bEffacer.setActionCommand("effacergrille"); bEffacer.addActionListener(this);


		menugrille.add(bValider); menugrille.add(bActivation); menugrille.add(bCouleur); menugrille.add(bEffacer);
		this.add(menugrille, BorderLayout.SOUTH);

	}



	public void generationVilles (int nbrVilles)
	{
		graphe = new Graphe(nbrVilles);
		System.out.println("DEBUG");
		repaint();
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
		else if (ev.getActionCommand().equals("valider"))
		{
			valide = true;
			System.out.println("Valider : " + valide);
			repaint();
		}

	}

	public void mousePressed(MouseEvent ev) {}
	public void mouseClicked(MouseEvent ev) 
	{	int x = ev.getX();
	int y = ev.getY();
	graphe.addPoint(x, y);
	System.out.println("passe");
	repaint();
	} 
	public void mouseEntered(MouseEvent arg0) {	}
	public void mouseExited(MouseEvent arg0) { }
	public void mouseReleased(MouseEvent arg0) { }


	// MOUVEMENTS DE LA SOURIS
	public void coordonneesSouris (Graphics g)
	{
		g.drawString("("+sourisX+","+sourisY+")",10,20);
	}

	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {
		// si la souris est dans la grille
		if (contains(e.getX(),e.getY()))
		{
			sourisX = e.getX();
			sourisY = e.getY();
			repaint();
		}
	}
	
	/**
	 * 
	 * @param s
	 */
	public void addParcours (String s)
	{
		int i = 0;
		// On vérifie si le parcours n'a pas déjà été ajouté
		while (i < listeParcours.size() && listeParcours.get(i).equals("s"))
		{
			i++;
		}
		
		// Si le parcours n'a pas ete trouve
		if (i == listeParcours.size())
		{System.out.println("RentreDansLeIf");
			listeParcours.add(s);}
		
		// DEBUG
		System.out.println("Avant le addParcours");
		for (String y : listeParcours)
		{
			System.out.println("Methodes : " + y);
		}
	}
	
	/**
	 * 
	 * @param s
	 */
	public void deleteParcours (String s)
	{
		int i = 0;
		// On vérifie si le parcours est ajouté
		while (i < listeParcours.size())
		{
			if (listeParcours.get(i).equals("s"))
			{listeParcours.remove(i);}
		}
	}
	
	/** 
	 * 
	 * @param g
	 */
	public void generationParcours (Graphics g)
	{
		//valide = false;
		System.out.println("Dans GenerationParcours");
		for (String s : listeParcours)
		{
			System.out.println("Dans le for");
			if (s.equals("bruteforce"))
			{
				BruteForce bf = new BruteForce(graphe);
				bf.lancement();
				bf.affichageParcoursGraphe(g, dimensionGrille);
			}
			if (s.equals("backtrack"))
			{
				BackTrack_v2 bt = new BackTrack_v2(graphe);
				bt.lancement();
				bt.affichageParcoursGraphe(g, dimensionGrille);
			}
			if (s.equals("mst"))
			{
				Algo_Kruskal ak = new Algo_Kruskal(graphe);
				ak.lancement();
				ak.affichageParcoursGraphe(g, dimensionGrille);
			}
			if (s.equals("opt"))
			{
				Algo2Opt ao = new Algo2Opt(graphe);
				ao.lancement();
				ao.affichageParcoursGraphe(g, dimensionGrille);
			}
			if (s.equals("plusprochesvoisins"))
			{
				ProchesVoisins pv = new ProchesVoisins(graphe);
				pv.lancement();
				pv.affichageParcoursGraphe(g, dimensionGrille);
			}
		}
	}


}
