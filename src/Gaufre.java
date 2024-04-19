
import Controleur.ControleurMediateur;
import Global.Configuration;
import Modele.Jeu;
import Vue.CollecteurEvenements;
import Vue.InterfaceGraphique;
import Vue.InterfaceTextuelle;

public class Gaufre {
	final static String typeInterface = Configuration.lisChaine("Interface");

	public static void main(String[] args) {
		Jeu j;
		if (args.length > 0)
			j = new Jeu(args[0]);
		else
			j = new Jeu();
		CollecteurEvenements control = new ControleurMediateur(j);
		switch (typeInterface) {
			case "Graphique":
				InterfaceGraphique.demarrer(j, control);
				break;
			case "Textuelle":
				InterfaceTextuelle.demarrer(j, control);
				break;
			default:
				Configuration.erreur("Interface inconnue");
		}
	}
}
