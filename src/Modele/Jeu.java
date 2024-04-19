package Modele;

public class Jeu /*extends Historique<Coup> implements Cloneable */{
	static final int PLEIN = 0;
	static final int VIDE = 1;
	static final int POISON = 2;
    int l;
    int c;
    int[][] morceaux;

    public Jeu(int l,int c) {
        this.l = l;
        this.c = c;
        morceaux = new int[l][c];
        morceaux[0][0] = POISON;
    }

    public void videCase(int i, int j) {
		morceaux[i][j] = VIDE;
	}

    public int lignes() {
		return l;
	}

	public int colonnes() {
		return c;
	}

    boolean estPlein(int l, int c) {
		return morceaux[l][c] == PLEIN;
	}

	void coup(int x, int y){
		for (int i = x; i < l; i ++){
			for (int j = y; j < c; j++){
				videCase(i, j);
			}
		}
	}

	

    /*public static void main(String[] args) {
        // Création d'une instance de la classe Jeu
		int l = 6;
		int c = 5;
        Jeu Jeu = new Jeu(l,c);

        // Affichage de la taille initiale du tableau
        System.out.println("Taille initiale du tableau : " + Jeu.morceaux.length + "x" + Jeu.morceaux[0].length);

        for (int i = 0; i < Jeu.morceaux.length; i++) {
            for (int j = 0; j < Jeu.morceaux[0].length; j++) {
                System.out.print(Jeu.morceaux[i][j] + " ");
            }
            System.out.println();
        }
        
        Jeu.coup(3,3);

        System.out.println("Nouvelle taille du tableau : " + Jeu.morceaux.length + "x" + Jeu.morceaux[0].length);

        System.out.println("Contenu du tableau après mangeage :");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(Jeu.morceaux[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(Jeu.morceaux[3][3]);
    }*/


}

