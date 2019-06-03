import java.util.ArrayList;


public class Echequier {
	private ArrayList<ArrayList<Piece>> matrice; // matrice d'ArrayList d'ArrayList de Piece

	public Echequier(){
		this.matrice = new ArrayList<ArrayList<Piece>>();

		for (int i = 0; i < 8; i++){
			this.matrice.add(new ArrayList<Piece>()); // création des "lignes" de la matrice de pieces
		}

		// placement des pieces

		this.matrice.get(0).add(new Tour(0));
		this.matrice.get(0).add(new Cavalier(0));
		this.matrice.get(0).add(new Fou(0));
		this.matrice.get(0).add(new Dame(0));
		this.matrice.get(0).add(new Roi(0));
		this.matrice.get(0).add(new Fou(0));
		this.matrice.get(0).add(new Cavalier(0));
		this.matrice.get(0).add(new Tour(0));

		for (int i = 0; i < 8; i++){ 
			this.matrice.get(1).add(new Pion(0)); // placement des pions blanc
		}
		for (int i = 2; i < 6; i++){ 
			for (int j = 0; j < 8; j++){
				this.matrice.get(i).add(new PieceNull(0)); // placement du vide
			}
		}
		for (int i = 0; i < 8; i++){ 
			this.matrice.get(6).add(new Pion(1)); // placement des pions noir
		}

		this.matrice.get(7).add(new Tour(1));
		this.matrice.get(7).add(new Cavalier(1));
		this.matrice.get(7).add(new Fou(1));
		this.matrice.get(7).add(new Dame(1));
		this.matrice.get(7).add(new Roi(1));
		this.matrice.get(7).add(new Fou(1));
		this.matrice.get(7).add(new Cavalier(1));
		this.matrice.get(7).add(new Tour(1));

	}

	public Piece getEchec(int x, int y){
		if (x >= 0 && x <= 8 && y >= 0 && y <= 8){
			return this.matrice.get(x).get(y);
		}
		else{
			return new PieceNull(0);
		}
	}
	public int setEchec(int x, int y, int p, int c){ // x, y : coord de la piece; p : numero de la piece; c : couleur de la piece en corrélation avec la valeur 0 ou 1 du joueur
		if (x >= 0 && x <= 8 && y >= 0 && y <= 8 && p >= 0 && p <= 8 && c >= 0 && c <= 8){
			switch(p){
				case 0:
					this.matrice.get(x).add(y, new PieceNull(c));
					break;
				case 1:
					this.matrice.get(x).add(y, new Roi(c));
					break;
				case 2:
					this.matrice.get(x).add(y, new Dame(c));
					break;
				case 3:
					this.matrice.get(x).add(y, new Tour(c));
					break;
				case 4:
					this.matrice.get(x).add(y, new Cavalier(c));
					break;
				case 5:
					this.matrice.get(x).add(y, new Fou(c));
					break;
				case 6:
					this.matrice.get(x).add(y, new Pion(c));
					break;
			}
			return 0;
		}
		else{
			return 1;
		}
	}
}