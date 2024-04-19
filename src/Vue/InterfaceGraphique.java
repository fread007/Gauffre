package Vue;


import Modele.Jeu;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

// L'interface runnable déclare une méthode run
public class InterfaceGraphique implements Runnable{
	Jeu j;
	JPanel panel=new JPanel(new GridLayout(5,1));
	JFrame frame;
	boolean maximized;
	GaufreGraphique gaufre;
	
	

	InterfaceGraphique(Jeu jeu) {
		j = jeu;
	}

	public static void demarrer(Jeu j) {
		InterfaceGraphique vue = new InterfaceGraphique(j);
		SwingUtilities.invokeLater(vue);
	}

	public void toggleFullscreen() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice();
		if (maximized) {
			device.setFullScreenWindow(null);
			maximized = false;
		} else {
			device.setFullScreenWindow(frame);
			maximized = true;
		}
	}




	/* 
	public static JComponent creerAnnulerRefaire(Jeu j, CollecteurEvenements control) {
		
		BoutonAnnuler annuler = new BoutonAnnuler(j);
		annuler.setFocusable(false);
		BoutonRefaire refaire = new BoutonRefaire(j);
		refaire.setFocusable(false);
		Box annulerRefaire = creerBoiteHorizontale();
		annulerRefaire.add(annuler);
		annulerRefaire.add(refaire);
		annuler.addActionListener(new AdaptateurAnnuler(control));
		refaire.addActionListener(new AdaptateurRefaire(control));
		return annulerRefaire;
		
	}
	*/

	public void run() {
		try {
			gaufre = new GaufreGraphique(j, frame,panel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		frame = new JFrame("Ma fenetre a moi");

		
		//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//panel.setBackground(Color.LIGHT_GRAY);

		//boiteTexte.add(Box.createGlue());
		JButton nouvelle= new JButton("Nouvelle partie JcJ");
		JButton nouvelleIA= new JButton("Nouvelle partie JcIA");
		JButton changer= new JButton("Changer joueur de départ");
		//JButton regle =new JButton("règle du jeu");
		JButton charger =new JButton("Charger Partie");
		JLabel Jeugauffre=new JLabel("GAUFFRE");
		Jeugauffre.setAlignmentY(Component.CENTER_ALIGNMENT);
		Font font = Jeugauffre.getFont();
        float newSize = font.getSize() + 55;
		Jeugauffre.setFont(font.deriveFont(newSize));

		JPanel PanelGauffre = new JPanel();

		PanelGauffre.setBackground(new Color(243,217,179));
		PanelGauffre.add(Jeugauffre);
		PanelGauffre.setPreferredSize(Jeugauffre.getPreferredSize());
		
		nouvelle.setBackground(Color.ORANGE);
		nouvelleIA.setBackground(new Color(243,217,179));
		charger.setBackground(Color.ORANGE);
		changer.setBackground(new Color(243,217,179));
		//regle.setBackground(Color.ORANGE);

		nouvelle.addActionListener(new AdaptateurNouvelle(gaufre));
		nouvelleIA.addActionListener(new AdaptateurNouvelleIA(j));
		charger.addActionListener(new AdaptateurCharger(j));
		changer.addActionListener(new AdaptateurChanger(j));

		panel.add(PanelGauffre);
		panel.add(nouvelle);
		panel.add(nouvelleIA);
		panel.add(charger);
		panel.add(changer);
		//panel.add(regle);

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}


	

	


}
