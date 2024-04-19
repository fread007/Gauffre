package Vue;

import javax.swing.*;
import java.awt.*;
import Modele.Jeu;

import java.io.*;
import javax.imageio.ImageIO;




public class GaufreGraphique extends JComponent{
    Jeu jeu;
    JFrame frame;
    Image poison,normal;
    int JeuEnCours;
    JPanel panelMenu;
    JPanel reglesP;
    Box boite_d;
    
	int regles;

    GaufreGraphique(Jeu jeu,JFrame frame,JPanel panel)throws FileNotFoundException{
        this.jeu = jeu;
        this.frame = frame;
        poison = lisImage("Vue/poison.png");
        normal = lisImage("Vue/normal.png");
        this.panelMenu=panel;
        JeuEnCours=0;
        //regles=0;
        //boite_d=initB();
    }

    public Image lisImage(String nom)  {
		try {
            InputStream in = new FileInputStream(nom);
			// Chargement d'une image utilisable dans Swing
			return ImageIO.read(in);
		} 
        catch (java.io.FileNotFoundException e) {
			System.out.println(e);
		}
        catch(java.io.IOException e){

        }
		return null;
	}



    public void paintComponent(Graphics g) {
        
        
        Graphics2D drawable = (Graphics2D) g;
        
        int l =jeu.lignes(),c=jeu.colonnes();
        int hauteur = getSize().height;
        int largeur = getSize().width;
        int casehaut_t = hauteur / l;
        int caselarg_t = largeur / c;
        int i,j;

        for(i=0;i<l;i++){
            for(j=0;j<c;j++){
                if (jeu.valeurMorceau(i,j) == Jeu.PLEIN){
                    drawable.drawImage(normal, j*caselarg_t, i*casehaut_t,caselarg_t,casehaut_t,null);
                }
                else if(jeu.valeurMorceau(i, j) == Jeu.VIDE){
                    drawable.drawRect(j*caselarg_t, i*casehaut_t, caselarg_t, casehaut_t);
                    drawable.setColor(Color.WHITE);
                    drawable.fillRect(j*caselarg_t, i*casehaut_t, caselarg_t, casehaut_t);
                }
                else{
                    drawable.drawImage(poison, j*caselarg_t, i*casehaut_t,caselarg_t,casehaut_t,null);
                }
            }
        }
        if(JeuEnCours==1){
            frame.remove(panelMenu);
            //to do faire les boites pour 
            //initBoite();
            JeuEnCours=3;
            frame.add(this);
        }
        
        

    }

    
}
