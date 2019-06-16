import java.util.ArrayList;

public class PieceNull extends Piece implements InterPieceNull{
	public PieceNull(int couleur){
		super(couleur);
		//this.setTest(this.getNom());
		//this.test = "0";
	}

	public String getNom(){
		return this.nom;
	}
	public String getSymbole(){
		return this.symboleB;
	}
	public int getNumPiece(){
		return this.numPiece;
	}
	public int getPts(){
		return this.pts;
	}
	public String getImage(){
		return this.imageB; // si la couleur == 0 (si elle est blanche) alors retourne symboleB (picece de couleur blanche) sinon retourne symboleN (picece de couleur noire)
	}
}