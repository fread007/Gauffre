package Modele;
import java.util.Random;

class IAAleatoire extends IA {
	Random r;

	public IAAleatoire() {
		r = new Random();
	}

	@Override
	public int[] joue() {
		//ont recupere la taille du terrain
		int nbr_l = G.morceaux.length;
		int nbr_c = G.morceaux[0].length;

		//creation d'un tableau pour stoquer les case restante
		int[][] case_restante = new int[nbr_l*nbr_c][2];
		int ctr = 0;

		//ont recherche toute les case jouable
		for(int i = 0; i < nbr_l; i++){
			for(int j = 0; j < nbr_c; j++){
				if(G.morceaux[i][j] == Gaufre.PLEIN){
					case_restante[ctr][0] = i;
					case_restante[ctr][1] = j;
					ctr++;
				}
			}
		}

		//ont choisi une case jouable aleatoire
		int res = r.nextInt(ctr);

		return case_restante[res];
	}
}
