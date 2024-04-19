package Vue;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Modele.Jeu;

public class AdaptateurCharger implements ActionListener{
    Jeu jeu;

    AdaptateurCharger(Jeu jeu){
        this.jeu=jeu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jeu.chargerSauvegarde();
        
    }

}
