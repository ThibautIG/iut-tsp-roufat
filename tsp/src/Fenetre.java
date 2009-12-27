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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Fenetre extends JFrame implements ActionListener, ChangeListener, ItemListener
{
	private static final long serialVersionUID = 1L;
	private JPanel barreFenetre, parametres, choixVilles, choixMethodes, informations, resultats, methodes1, methodes2;
	private Dessin grille;
	private JMenuBar menu;
	private JMenu fichier, edition, aPropos;
	private JMenuItem open, saveParcours, newParcours, about;
	private JButton boutonNouveau, boutonOuvrir;
	private JSlider sliderVilles;
	private int nombreslider;
	private JTextField nbrVilles, resultatAlgo, tempsExecAlgo;
	private JCheckBox rb1, rb2, rb3, rb4, rb5;
	private int nombreMethodes = 1;			// Par défaut sur la bruteforce
	private JTextArea explicationsMethodes;
	private JScrollPane barreDefilInformations;
	

	public Fenetre ()
	{	
		this.setSize(950,600);										// Taille de la fenetre
		this.setTitle("Probleme du voyageur de commerce");			// Titre de la fenetre
		this.setResizable(true);									// Fenetre non redimensionnable
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);				// Affichage au milieu de l'ecran
		this.setLayout(new BorderLayout());
		
		initMenu();				// Initialisation du menu
		initBarreFenetre();		// Initialisation de la barre boutons du haut
		initParametres();		// Initialisation du JPanel Parametre
		initGrille ();			// Initialisation de la grille
		initResultats ();		// Initialisation de la fenetre de resultat
		
		//JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, parametres, grille);add(split);
	
		
		this.setVisible(true);	// Affichage de la fenetre
	}
	
	public void initMenu ()
	{
		// Creation de la barre de menu
		menu = new JMenuBar();
		
		// Creation des menus
		fichier = new JMenu("Fichier"); add(fichier);
		edition = new JMenu("Edition"); add(edition);
		aPropos = new JMenu("A propos"); add(aPropos);
		
		// Creation des sous-menus
		newParcours = new JMenuItem("Nouveau Parcours");
		open = new JMenuItem("Ouvrir");
		saveParcours = new JMenuItem("Sauvegarder Parcours");
		about = new JMenuItem("A propos");
		
		// Ajout des identifications de menu
		open.setActionCommand("ouvrir");
		saveParcours.setActionCommand("saveparcours");
		newParcours.setActionCommand("newParcours");
		about.setActionCommand("apropos");
		
		// Ajout des ecouteurs de menu
		open.addActionListener(this);
		saveParcours.addActionListener(this);
		newParcours.addActionListener(this);
		about.addActionListener(this);
		
		// Ajout des menus à la barre
		fichier.add(newParcours);
		fichier.add(open);
		fichier.add(saveParcours);
		menu.add(fichier);
		menu.add(edition);
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
		parametres.setLayout(new GridLayout(3,1));
		//parametres.setBackground(Color.blue);
		parametres.setPreferredSize(new Dimension(getWidth()/3, getHeight()- getHeight()/4));
		
		choixVilles = new JPanel ();
		choixVilles.setLayout(new GridBagLayout());			// Utilisation d'un GridBagLayout		
		//choixVilles.setBackground(Color.lightGray);
		creationPanelVilles();								// Appel Méthode Création JPanel
		choixVilles.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.GRAY));
		parametres.add(choixVilles);
		
		
		choixMethodes = new JPanel ();
		choixMethodes.setLayout(new BorderLayout());
		//choixMethodes.setBackground(Color.white);
		creationPanelMethodes();
		choixMethodes.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.GRAY));
		parametres.add(choixMethodes);
	
		
		informations = new JPanel ();
		//informations.setBackground(Color.orange);
		creationPanelInformations();
		informations.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.GRAY));
		parametres.add(informations);
			
		parametres.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.GRAY));
		add(parametres, BorderLayout.WEST);
	}
	
	public void creationPanelVilles ()
	{
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		choixVilles.setBorder(BorderFactory.createTitledBorder("Villes"));
		
//		JLabel textvilles = new JLabel("Villes : ");
//		c.gridx = 1; c.gridy = 0;
//		choixVilles.add(textvilles,c);
		
		nbrVilles = new JTextField("0",8);
		c.gridx = 2; c.gridy = 0; c.fill = GridBagConstraints.BOTH;
		choixVilles.add(nbrVilles,c);
		
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
		
		JButton btGenerationVilles = new JButton("Generer");
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
		methodes1.setLayout(new GridLayout(3,1));			// 3 lignes, 1 colonne
		methodes1.setBorder(BorderFactory.createTitledBorder("Completes"));
		rb1 = new JCheckBox("BruteForce"); rb1.setActionCommand("bruteforce");	rb1.addActionListener(this); rb1.addItemListener(this);
		rb2 = new JCheckBox("BackTrack");  rb2.setActionCommand("backtrack"); rb2.addActionListener(this);rb2.addItemListener(this);
		methodes1.add(rb1); methodes1.add(rb2);
		
		methodes2 = new JPanel();
		methodes2.setLayout(new GridLayout(3,1));
		methodes2.setBorder(BorderFactory.createTitledBorder("Approximatives"));
		rb3 = new JCheckBox("Plus Proches Voisins"); rb3.setActionCommand("plusprochesvoisins"); rb3.addActionListener(this);rb3.addItemListener(this);
		rb4 = new JCheckBox("MST"); rb4.setActionCommand("mst"); rb4.addActionListener(this);rb4.addItemListener(this);
		rb5 = new JCheckBox("2-Opt"); rb5.setActionCommand("opt"); rb5.addActionListener(this); rb5.addItemListener(this);
		methodes2.add(rb3); methodes2.add(rb4); methodes2.add(rb5);
		
		choixMethodes.add(methodes1,BorderLayout.WEST);
		choixMethodes.add(methodes2,BorderLayout.EAST);
		
	}
	
	public void creationPanelInformations ()
	{
		informations.setBorder(BorderFactory.createTitledBorder("Informations"));
		informations.setLayout(new BorderLayout());
		
		explicationsMethodes = new JTextArea();
		barreDefilInformations = new JScrollPane();
		informations.add(barreDefilInformations);
		
		if (nombreMethodes == 1)
		{
			explicationsMethodes.removeAll();
			explicationsMethodes.append("La methode Bruteforce est une methode permettant de tester toutes les combinaisons possibles. Elle est particulierement lente pour un grand nombre de villes. ");
		}
		
		informations.add(explicationsMethodes);
		barreDefilInformations.setViewportView(explicationsMethodes);
		explicationsMethodes.setEditable(false);
	}
	
	public void initGrille ()
	{
		grille = new Dessin();

		grille.setPreferredSize(new Dimension(2*getWidth()/3,  3*(getHeight()/4)));
		//grille.setBackground(Color.yellow);
		grille.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.GRAY));
		add (grille, BorderLayout.CENTER);
	}
	
	
	public void initResultats ()
	{
		resultats = new JPanel ();
		resultats.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		JLabel lresultat = new JLabel("Resultat : ");
		c.gridx = 0; c.gridy = 1; c.fill = GridBagConstraints.HORIZONTAL;
		resultats.add(lresultat,c);
		
		resultatAlgo = new JTextField(20);
		c.gridx = 1; c.gridy = 1; c.fill = GridBagConstraints.HORIZONTAL;
		resultats.add(resultatAlgo,c);
		
		JLabel ltempsExec = new JLabel("Temps d'execution : ");
		c.gridx = 0; c.gridy = 2; c.fill = GridBagConstraints.HORIZONTAL;
		resultats.add(ltempsExec,c);
		
		tempsExecAlgo = new JTextField(20);
		c.gridx = 1; c.gridy = 2; c.fill = GridBagConstraints.HORIZONTAL;
		resultats.add(tempsExecAlgo,c);
		 
		 
		resultats.setPreferredSize(new Dimension(getWidth(), getHeight()- 3*(getHeight()/4)));

		resultats.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.GRAY));
		add(resultats, BorderLayout.SOUTH);
	}
	
	public void actionPerformed (ActionEvent ev)
	{
		if (ev.getActionCommand().equals("generation"))
		{
			grille.generationVilles(this.nombreslider);
		}		
	}
	
	public void stateChanged(ChangeEvent ev) {
		JSlider source = (JSlider) ev.getSource();
		if (!source.getValueIsAdjusting())
		{
			nombreslider = (int) source.getValue();
			nbrVilles.setText(""+nombreslider);
		}
		
	}

	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();

		if (source == rb1)
		{
			grille.addParcours("bruteforce");
			System.out.println("DEBUG");
		}
		if (source == rb2)
		{
			grille.addParcours("backtrack");
			System.out.println("DEBUG");
		}
		if (source == rb3)
		{
			grille.addParcours("plusprochesvoisins");
			System.out.println("DEBUG");
		}
		if (source == rb4)
		{
			grille.addParcours("mst");
			System.out.println("DEBUG");
		}
		if (source == rb5)
		{
			grille.addParcours("opt");
			System.out.println("DEBUG");
		}
	}
}
