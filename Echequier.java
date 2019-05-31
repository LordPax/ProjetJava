import java.util.ArrayList;


public class Echequier {
	private ArrayList<ArrayList<Piece>> matrice; // matrice d'ArrayList d'ArrayList de Piece

	public Echequier(){
		this.matrice = new ArrayList<ArrayList<Piece>>();

		for (int i = 0; i < 8; i++){
			this.matrice.add(new ArrayList<Piece>());
		}

		// for (int i = 0; i < 8; i++){
		// 	for (int j = 0; j < 8; j++){
		// 		//this.matrice.get(i).add(new Piece("x : " + String.valueOf(i) + " y : " + String.valueOf(j)));
		// 		if ((i * this.matrice.size() + j) % 2 == 0){
		// 			this.matrice.get(i).add(new Tour(0));
		// 		}
		// 		else{
		// 			this.matrice.get(i).add(new Roi(1));	
		// 		}
		// 	}
		// }

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
		return this.matrice.get(x).get(y);
	}
}