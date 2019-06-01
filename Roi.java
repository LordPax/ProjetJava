import java.util.ArrayList;

public class Roi extends Piece implements InterRoi{
	public Roi(int couleur){
		super(couleur);
		//this.test = this.nom;
		//this.test = "0";
	}

	public String getNom(){
		return this.nom;
	}
	public String getSymbole(){
		return (this.couleur == 0) ? this.symboleB : this.symboleN; // si la couleur == 0 (si elle est blanche) alors retourne symboleB (picece de couleur blanche) sinon retourne symboleN (picece de couleur noire)
	}
	public int getNumPiece(){
		return this.numPiece;
	}
}