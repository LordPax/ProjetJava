import java.util.ArrayList;

public class Partie{
	private int tour;
	private Joueur[] joueur;
	private Echequier echequier;

	public Partie(){
		this.echequier = new Echequier();
	}
	public void afficher(){
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				System.out.print(this.echequier.getEchec(i, j).getSymbole() + " ");
			}
			System.out.print("\n");
		}


		// test
		System.out.println("\n\n" + this.echequier.getEchec(0, 0).getSymbole());
		System.out.println(this.echequier.getEchec(0, 1).getSymbole());
		System.out.println(this.echequier.getEchec(1, 0).getSymbole());
		System.out.println(this.echequier.getEchec(1, 1).getSymbole());
	}
}
