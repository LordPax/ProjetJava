import java.util.ArrayList;

public class Echequier {
	private ArrayList<Piece> echequier;

	public Echequier(){
		this.echequier = new ArrayList<Piece>();

		for (int i = 0; i < 64; i++) {
			this.echequier.add(new Piece());
		}
	}

	public Piece getEchec(int i){
		return this.echequier.get(i);
	}
}
