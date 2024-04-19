package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Jeu;

public class AdaptateurChanger implements ActionListener{
    Jeu jeu;

    AdaptateurChanger(Jeu jeu){
        this.jeu=jeu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jeu.changerJoueur();
        
    }


    
}
