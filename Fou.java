import java.util.ArrayList;

public class Fou extends Piece implements InterFou{
	public Fou(int couleur){
		super(couleur);
		//this.setTest(this.getNom());
		//this.test = "0";
	}

	public String getNom(){
		return this.nom;
	}
	public String getSymbole(){
		return (this.couleur == 0) ? this.symboleB : this.symboleN;
	}
}