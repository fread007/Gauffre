package Modele;

public class Jeu /*extends Historique<Coup> implements Cloneable */{
	static final int PLEIN = 0;
	static final int VIDE = 1;
	static final int POISON = 2;
    private int l;
    private int c;
    int[][] morceaux;
	private boolean tourJoueur1;

    public Jeu(int l,int c) {
        this.l = l;
        this.c = c;
        morceaux = new int[l][c];
        morceaux[0][0] = POISON;
		tourJoueur1 = true;
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

	public boolean tourJoueur(){
		return tourJoueur1;
	}

    boolean estPlein(int l, int c) {
		return morceaux[l][c] == PLEIN;
	}

	boolean estPoison(int l, int c) {
		return morceaux[l][c] == POISON;
	}
	
	int valeurMorceau(int l, int c){
		return morceaux[l][c];
	}
	
	boolean coup(int x, int y){
		try {
			if (estPoison(x, y)) {
				return false;
			}
			for (int i = x; i < l; i ++){
				for (int j = y; j < c; j++){
					videCase(i, j);
				}
			}
			tourJoueur1 = !tourJoueur1;
		}
		catch(Exception e){
			System.err.println(e);
		}
		return true;
	}

	

    /*public static void main(String[] args) {
        // Création d'une instance de la classe Jeu
		int l = 6;
		int c = 5;
        Jeu Jeu = new Jeu(l,c);

        // Affichage de la taille initiale du tableau
        System.out.println("Taille initiale du tableau : " + Jeu.morceaux.length + "x" + Jeu.morceaux[0].length);

        for (int i = 0; i < Jeu.l; i++) {
            for (int j = 0; j < Jeu.c; j++) {
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

