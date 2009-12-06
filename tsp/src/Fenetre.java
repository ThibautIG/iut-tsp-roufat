import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Fenetre extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel choixElements, graphiqueVilles;
	private JMenuBar menu;
	private JMenu fichier;
	private JMenuItem ouvrir;

	public Fenetre ()
	{	
		this.setSize(800,600);										// Taille de la fenetre
		this.setTitle("Probleme du voyageur de commerce");			// Titre de la fenetre
		this.setResizable(false);									// Fenetre non redimensionnable
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(this.getParent());				// Affichage au milieu de l'ecran

		initMenu();			// Initialisation du menu
		
		
		this.setVisible(true);	// Affichage de la fenetre
	}
	
	public void initMenu ()
	{
		// Creation de la barre de menu
		menu = new JMenuBar();
		
		// Creation des menus
		fichier = new JMenu("Fichier"); add(fichier);
		
		// Creation des sous-menus
		ouvrir = new JMenuItem("Ouvrir");
		
		// Ajout des identifications de menu
		ouvrir.setActionCommand("ouvrir");
		
		// Ajout des ecouteurs de menu
		ouvrir.addActionListener(this);
		
		// Ajout des menus à la barre
		fichier.add(ouvrir);
		menu.add(fichier);
		
		
		
		setJMenuBar(menu);
	}
	
	public void actionPerformed (ActionEvent ev)
	{
		
	}
}
