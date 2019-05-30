import java.util.ArrayList;


public class Echequier {
	private ArrayList<ArrayList<Piece>> matrice;
	//private ArrayList<Piece> matrice = new ArrayList<Piece>();

	public Echequier(){
		this.matrice = new ArrayList<ArrayList<Piece>>();

		for (int i = 0; i < 8; i++){
			this.matrice.add(new ArrayList<Piece>());
		}

		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				//this.matrice.get(i).add(new Piece("x : " + String.valueOf(i) + " y : " + String.valueOf(j)));
				this.matrice.get(i).add(new Pion(String.valueOf(i * this.matrice.size() + j)));
			}
		}
	}

	public Piece getEchec(int x, int y){
		return this.matrice.get(x).get(y);
	}
}