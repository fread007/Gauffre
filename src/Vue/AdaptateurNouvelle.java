package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdaptateurNouvelle implements ActionListener {
    
    GaufreGraphique gaufre;

    AdaptateurNouvelle(GaufreGraphique gaufre){
        this.gaufre=gaufre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gaufre.JeuEnCours=1;
        gaufre.repaint();
    }

}
