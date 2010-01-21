import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Fenetre extends JFrame implements ActionListener, ChangeListener, ItemListener
{
	private static final long serialVersionUID = 1L;
	private JPanel barreFenetre, parametres, choixVilles, choixMethodes, methodes1, methodes2, methodes3;
	private Dessin grillePrincipale, grilleBruteForce, grilleBacktrack, grilleBackTrackv2, grilleBackTrackv3, grilleBackTrackv4, grillePlusProchesVoisins, grilleMST, grille2Opt;
	private JMenuBar menu;
	private JMenu fichier, aPropos;
	private JMenuItem open, saveParcours, newParcours, about, quit;
	private JButton boutonNouveau, boutonOuvrir, validerParcours, validerNbrVilles;
	private JSlider sliderVilles;
	private JTabbedPane tableOnglets;
	private int nombreslider;
	private JTextField nbrVilles;
	private JCheckBox checkBruteForce, checkBackTrack, checkBackTrackv2, checkBackTrackv3, checkBackTrackv4, checkPlusProchesVoisins, checkMST, checkAlgo2Opt;
	private int nombreMethodes = 1;			// Par défaut sur la bruteforce
	private boolean villesGenerees = false;
	private XmlSerializer xml;

	private Resultats result;

	private boolean valideParc = false;


	public Fenetre ()
	{	
		this.setSize(950,800);										// Taille de la fenetre
		this.setTitle("Probleme du voyageur de commerce");			// Titre de la fenetre
		this.setResizable(true);									// Fenetre non redimensionnable
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);				// Affichage au milieu de l'ecran
		this.setLayout(new BorderLayout());

		// Initialisation des onglets
		tableOnglets = new JTabbedPane();

		initResultats ();		// Initialisation de la fenetre de resultat
		initMenu();				// Initialisation du menu
		//initBarreFenetre();		// Initialisation de la barre boutons du haut
		initParametres();		// Initialisation du JPanel Parametre
		initGrille ();			// Initialisation de la grille


		this.setVisible(true);	// Affichage de la fenetre
	}

	public void initMenu ()
	{
		// Creation de la barre de menu
		menu = new JMenuBar();

		// Creation des menus
		fichier = new JMenu("Fichier"); add(fichier);
		aPropos = new JMenu("A propos"); add(aPropos);

		// Creation des sous-menus
		newParcours = new JMenuItem("Nouveau Parcours");
		open = new JMenuItem("Ouvrir");
		saveParcours = new JMenuItem("Sauvegarder Parcours");
		about = new JMenuItem("A propos");
		quit = new JMenuItem("Quitter");

		// Ajout des identifications de menu
		open.setActionCommand("ouvrir");
		saveParcours.setActionCommand("saveparcours");
		newParcours.setActionCommand("newParcours");
		about.setActionCommand("apropos");
		quit.setActionCommand("quit");

		// Ajout des ecouteurs de menu
		open.addActionListener(this);
		saveParcours.addActionListener(this);
		newParcours.addActionListener(this);
		about.addActionListener(this);
		quit.addActionListener(this);

		// Ajout des menus à la barre
		fichier.add(newParcours);
		fichier.add(open);
		fichier.add(saveParcours);
		fichier.add(quit);
		menu.add(fichier);
		aPropos.add(about);
		menu.add(aPropos);

		setJMenuBar(menu);
	}

	public void initBarreFenetre()
	{
		barreFenetre = new JPanel ();

		boutonNouveau = new JButton (/* image */ "New");
		boutonNouveau.setActionCommand("newParcours");
		boutonNouveau.addActionListener(this);
		barreFenetre.add(boutonNouveau);

		boutonOuvrir = new JButton (/* image */ "Open");
		boutonOuvrir.setActionCommand("ouvrir");
		boutonOuvrir.addActionListener(this);
		barreFenetre.add(boutonOuvrir);

		// Positionnement
		add(barreFenetre);
	}

	public void initParametres ()
	{
		parametres = new JPanel();
		parametres.setLayout(new BorderLayout());;
		parametres.setPreferredSize(new Dimension(getWidth()/3, getHeight()- getHeight()/4));

		choixVilles = new JPanel ();
		choixVilles.setLayout(new GridBagLayout());			// Utilisation d'un GridBagLayout		
		creationPanelVilles();								// Appel Méthode Création JPanel
		choixVilles.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.GRAY));
		parametres.add(choixVilles, BorderLayout.NORTH);

		choixMethodes = new JPanel ();
		choixMethodes.setLayout(new GridLayout(3,1));
		creationPanelMethodes();
		choixMethodes.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.GRAY));
		parametres.add(choixMethodes, BorderLayout.CENTER);

		validerParcours = new JButton("Valider");
		validerParcours.setActionCommand("validerparcours"); validerParcours.addActionListener(this);
		parametres.add(validerParcours, BorderLayout.SOUTH);

		parametres.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.GRAY));
		add(parametres, BorderLayout.WEST);
	}

	public void creationPanelVilles ()
	{
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		choixVilles.setBorder(BorderFactory.createTitledBorder("Villes"));

		nbrVilles = new JTextField("0",8);
		c.gridx = 2; c.gridy = 0; c.fill = GridBagConstraints.BOTH;
		choixVilles.add(nbrVilles,c);
		
		validerNbrVilles = new JButton("Generation");
		c.gridx = 3; c.gridy = 0; c.fill = GridBagConstraints.BOTH;
		validerNbrVilles.setActionCommand("generation"); validerNbrVilles.addActionListener(this);
		choixVilles.add(validerNbrVilles,c);

		sliderVilles = new JSlider(JSlider.HORIZONTAL,0,100,0);
		sliderVilles.setBorder(BorderFactory.createTitledBorder("Nombre de villes"));
		sliderVilles.addChangeListener(this);
		sliderVilles.setMajorTickSpacing(20);					// Graduations
		sliderVilles.setMinorTickSpacing(5);
		sliderVilles.setPaintTicks(true);						// Affichage des graduations
		sliderVilles.setPaintLabels(true);						// Affichage des labels de graduations
		c.gridx = 1; c.gridwidth = 3; c.gridy = 1; c.weightx = 10;
		c.fill = GridBagConstraints.BOTH;
		choixVilles.add(sliderVilles,c);

		JButton btGenerationVilles = new JButton("Generation Slider");
		btGenerationVilles.setActionCommand("generation"); btGenerationVilles.addActionListener(this); 
		c.gridx = 2; c.gridy = 2; c.gridwidth = 1; c.weightx = 0;
		choixVilles.add(btGenerationVilles,c);	
	}

	public void creationPanelMethodes ()
	{
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		choixMethodes.setBorder(BorderFactory.createTitledBorder("Methodes de resolution"));

		methodes1 = new JPanel ();					// JPanel pour les methodes completes
		methodes1.setLayout(new GridLayout(5,1));			// 3 lignes, 1 colonne
		methodes1.setBorder(BorderFactory.createTitledBorder("Exactes"));
		checkBruteForce = new JCheckBox("BruteForce"); checkBruteForce.setActionCommand("bruteforce"); checkBruteForce.addItemListener(this);
		checkBackTrack = new JCheckBox("BackTrack");  checkBackTrack.setActionCommand("backtrack"); checkBackTrack.addItemListener(this);
		checkBackTrackv2 = new JCheckBox("BackTrack + MST"); checkBackTrackv2.setActionCommand("backtrackv2"); checkBackTrackv2.addItemListener(this);
		checkBackTrackv3 = new JCheckBox("BackTrack + 2-Opt"); checkBackTrackv3.setActionCommand("backtrackv3"); checkBackTrackv3.addItemListener(this);
		checkBackTrackv4 = new JCheckBox("BackTrack + 2-Opt + MST"); checkBackTrackv4.setActionCommand("backtrackv4"); checkBackTrackv4.addItemListener(this);
		
		methodes1.add(checkBruteForce); methodes1.add(checkBackTrack); methodes1.add(checkBackTrackv2); methodes1.add(checkBackTrackv3); methodes1.add(checkBackTrackv4);

		methodes2 = new JPanel();
		methodes2.setLayout(new GridLayout(3,1));
		methodes2.setBorder(BorderFactory.createTitledBorder("Approchees - Recherche Locale"));
		checkPlusProchesVoisins = new JCheckBox("Plus Proches Voisins"); checkPlusProchesVoisins.setActionCommand("plusprochesvoisins"); checkPlusProchesVoisins.addItemListener(this);
		checkAlgo2Opt = new JCheckBox("2-Opt"); checkAlgo2Opt.setActionCommand("opt"); checkAlgo2Opt.addItemListener(this);
		methodes2.add(checkPlusProchesVoisins); methodes2.add(checkAlgo2Opt);
		
		methodes3 = new JPanel();
		methodes3.setLayout(new GridLayout(1,1));
		methodes3.setBorder(BorderFactory.createTitledBorder("Approchees - Approximation"));
		checkMST = new JCheckBox("MST"); checkMST.setActionCommand("mst"); checkMST.addItemListener(this);
		methodes3.add(checkMST); 
	

		choixMethodes.add(methodes1);
		choixMethodes.add(methodes2);
		choixMethodes.add(methodes3);
	}

	/**
	 * Affichage de la grille principale.
	 * Les autres onglets seront affichés dans la suite des instructions.
	 */
	public void initGrille ()
	{		
		// NbrVilles est en parametre pour permettre de changer le nombre de villes lorsqu'on clique sur la grille.
		grillePrincipale = new Dessin("principale", result, nbrVilles);
		grillePrincipale.setPreferredSize(new Dimension(2*getWidth()/3,  3*(getHeight()/4)));

		grilleBruteForce = new Dessin("bruteforce", result, nbrVilles);
		grilleBruteForce.setPreferredSize(new Dimension(2*getWidth()/3,  3*(getHeight()/4)));

		grilleBacktrack = new Dessin ("backtrack", result, nbrVilles);
		grilleBacktrack.setPreferredSize(new Dimension(2*getWidth()/3,  3*(getHeight()/4)));
		
		grilleBackTrackv2 = new Dessin ("backtrackv2", result, nbrVilles);
		grilleBackTrackv2.setPreferredSize(new Dimension(2*getWidth()/3,  3*(getHeight()/4)));
		
		grilleBackTrackv3 = new Dessin ("backtrackv3", result, nbrVilles);
		grilleBackTrackv3.setPreferredSize(new Dimension(2*getWidth()/3,  3*(getHeight()/4)));
		
		grilleBackTrackv4 = new Dessin ("backtrackv4", result, nbrVilles);
		grilleBackTrackv4.setPreferredSize(new Dimension(2*getWidth()/3,  3*(getHeight()/4)));

		grillePlusProchesVoisins = new Dessin ("plusprochesvoisins", result, nbrVilles);
		grillePlusProchesVoisins.setPreferredSize(new Dimension(2*getWidth()/3,  3*(getHeight()/4)));

		grille2Opt = new Dessin ("opt", result, nbrVilles);
		grille2Opt.setPreferredSize(new Dimension(2*getWidth()/3,  3*(getHeight()/4)));

		grilleMST = new Dessin ("mst", result, nbrVilles);
		grilleMST.setPreferredSize(new Dimension(2*getWidth()/3,  3*(getHeight()/4)));

		tableOnglets.add("Principal", grillePrincipale);
		System.out.println("passe");
		this.add(tableOnglets, BorderLayout.CENTER);
	}


	public void initResultats ()
	{
		result = new Resultats();
		result.setPreferredSize(new Dimension(getWidth(), getHeight()- 3*(getHeight()/4)));
		result.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.GRAY));

		this.add(result, BorderLayout.SOUTH);
	}

	public void actionPerformed (ActionEvent ev)
	{
		// Bouton Ouvrir et Sauvegarder
		if (ev.getActionCommand().equals("ouvrir") || ev.getActionCommand().equals("saveParcours"))
		{
			xml = new XmlSerializer();
			if (ev.getActionCommand().equals("ouvrir"))
			{
				
			}
			else if (ev.getActionCommand().equals("saveParcours"))
			{
				
			}
		}
		
		// Quitter
		else if (ev.getActionCommand().equals("quit"))
		{
			System.exit(0);
		}
		
		// Nouveau parcours
		else if (ev.getActionCommand().equals("newParcours"))
		{
			// Suppression de la table des méthodes
			tableOnglets.removeAll();
			
			// Décochage des JCheckBox
			checkBruteForce.setSelected(false);	checkBackTrack.setSelected(false); checkBackTrackv2.setSelected(false); checkBackTrackv3.setSelected(false); checkBackTrackv4.setSelected(false);
			checkPlusProchesVoisins.setSelected(false); checkMST.setSelected(false); checkAlgo2Opt.setSelected(false);
			
			// Ajout de la grille principale
			initGrille();
			
			// Initialisation de Resultats
			initResultats();
			
			villesGenerees = false;
			valideParc = false;
		}
				
		// Generation des villes
		else if (ev.getActionCommand().equals("generation"))
		{
			System.out.println("passe");
			villesGenerees = true;
			grillePrincipale.generationVilles(Integer.parseInt(nbrVilles.getText()));
			
			if (Integer.parseInt(nbrVilles.getText()) <= 100)
			{
				sliderVilles.setValue(Integer.parseInt(nbrVilles.getText()));
			}
			else
				sliderVilles.setValue(100);
		}	
		
		// Validation des parcours
		else if (ev.getActionCommand().equals("validerparcours"))
		{
			if (!villesGenerees)		// Si les villes ont ete cliquees
			{
				this.grillePrincipale.graphe.calculeDist();
			}

			valideParc = true;
			System.out.println("Valider : " + valideParc);

			grilleBruteForce.setBoutonValider(true);
			grilleBacktrack.setBoutonValider(true);
			grilleBackTrackv2.setBoutonValider(true);
			grilleBackTrackv3.setBoutonValider(true);
			grilleBackTrackv4.setBoutonValider(true);
			grillePlusProchesVoisins.setBoutonValider(true);
			grilleMST.setBoutonValider(true);
			grille2Opt.setBoutonValider(true);
		}
	}

	// Changement du nombre de villes dans le slider
	public void stateChanged(ChangeEvent ev) {
			nbrVilles.setText(sliderVilles.getValue()+"");
	}

	// Cochage des JCheckBox
	public void itemStateChanged(ItemEvent e) {

		tableOnglets.removeAll();
		if (checkBruteForce.isSelected())
		{
			tableOnglets.addTab("BruteForce", grilleBruteForce);
			grilleBruteForce.setCliqueParcours(true);
		}
		else
			grilleBruteForce.setCliqueParcours(false);

		if (checkBackTrack.isSelected())
		{
			tableOnglets.addTab("Backtrack", grilleBacktrack);
			grilleBacktrack.setCliqueParcours(true);
		}
		else
			grilleBacktrack.setCliqueParcours(false);
		
		if (checkBackTrackv2.isSelected())
		{
			tableOnglets.addTab("BackTrack + MST", grilleBackTrackv2);
			grilleBackTrackv2.setCliqueParcours(true);
		}
		else
			grilleBackTrackv2.setCliqueParcours(false);
		
		if (checkBackTrackv3.isSelected())
		{
			tableOnglets.addTab("BackTrack + 2Opt", grilleBackTrackv3);
			grilleBackTrackv3.setCliqueParcours(true);
		}
		else
			grilleBackTrackv3.setCliqueParcours(false);
		
		if (checkBackTrackv4.isSelected())
		{
			tableOnglets.addTab("BackTrack + 2Opt + MST", grilleBackTrackv4);
			grilleBackTrackv4.setCliqueParcours(true);
		}
		else
			grilleBackTrackv4.setCliqueParcours(false);

		if (checkPlusProchesVoisins.isSelected())
		{
			tableOnglets.addTab("Plusprochesvoisins", grillePlusProchesVoisins);
			grillePlusProchesVoisins.setCliqueParcours(true);
		}
		else
			grillePlusProchesVoisins.setCliqueParcours(false);

		if (checkMST.isSelected())
		{
			tableOnglets.addTab("MST", grilleMST);
			grilleMST.setCliqueParcours(true);
		}
		else
			grilleMST.setCliqueParcours(false);

		if (checkAlgo2Opt.isSelected())
		{
			tableOnglets.addTab("Algo-2Opt", grille2Opt);
			grille2Opt.setCliqueParcours(true);
		}
		else
			grille2Opt.setCliqueParcours(false);

		this.add(tableOnglets);
	}
}
