import java.util.ArrayList;

public class Echequier {
	private ArrayList<Piece> echequier;

	public Echequier(){
		this.echequier = new ArrayList<Piece>();

		for (int i = 0; i < 64; i++)
			this.echequier.add(new Piece());
	}

	public Piece getEchec(int x, int y){
		if (x <= this.echequier.size() && y <= this.echequier.size() && x >= 0 && y >= 0){
			//return this.echequier.get(((y - 1) * this.echequier.size() + x) - 1);
			//System.out.println(y * this.echequier.size() + x);
			return this.echequier.get(x);
		}
	}
}
