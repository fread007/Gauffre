package Vue;

import javax.swing.JComponent;

import Modele.Jeu;

import javax.swing.*;
import java.awt.*;


public class Menu extends JComponent{
    Jeu jeu;
    JFrame frame;

    Menu(Jeu jeu,JFrame frame){
        this.jeu=jeu;
        this.frame=frame;
    }

    public void paintComponent(Graphics g) {
        

    }
}
