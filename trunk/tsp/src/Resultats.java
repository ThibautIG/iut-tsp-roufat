import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Resultats extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField resultatAlgo, tempsExecAlgo;

	public Resultats ()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		JLabel lresultat = new JLabel("Resultat : ");
		c.gridx = 0; c.gridy = 1; c.fill = GridBagConstraints.HORIZONTAL;
		this.add(lresultat,c);

		resultatAlgo = new JTextField("0",20);
		c.gridx = 1; c.gridy = 1; c.fill = GridBagConstraints.HORIZONTAL;
		this.add(resultatAlgo,c);

		JLabel ltempsExec = new JLabel("Temps d'execution : ");
		c.gridx = 0; c.gridy = 2; c.fill = GridBagConstraints.HORIZONTAL;
		this.add(ltempsExec,c);

		tempsExecAlgo = new JTextField("0",20);
		c.gridx = 1; c.gridy = 2; c.fill = GridBagConstraints.HORIZONTAL;
		this.add(tempsExecAlgo,c);
	}
	
	public void remplirCases (double resultat, double temps)
	{
		resultatAlgo.setText(resultat+"");
		tempsExecAlgo.setText(temps+"");
	}
}
