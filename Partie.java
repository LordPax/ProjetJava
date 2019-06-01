import java.util.ArrayList;

public class Partie{
	private int tour; // nombre de tour éffectuer par les joueurs
	private Joueur[] joueur; // joueurs au nombre de 2
	private Echequier echequier; // //échéquier ou ce trouve les piceces 

	public Partie(){
		this.echequier = new Echequier();
	}
	public void lancerPartie(){
		this.afficher();
		this.deplacerPiece(1, 1, 3, 1, 0); // déplacement d'une piece
		//this.deplacerPiece(0, 1, 3, 1, 0);
		this.afficher();
	}
	public void afficher(){
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				System.out.print(this.echequier.getEchec(i, j).getSymbole() + " "); // affichage 1 par 1 des piceces de l'échéquier
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	public void deplacerPiece(int x, int y, int dx, int dy, int joueur){ // x, y : coord initial; dx, dy : coord d'arriver; joueur : couleur du joueur
		if (x < 0 || x >= 8  || y < 0 || y >= 8 || dx < 0 || dx >= 8 || dy < 0 || dy >= 8 || joueur < 0 || joueur > 1){
			x = 0;
			y = 0;
			dx = 0;
			dy = 0;
			joueur = 0;
		}
		if (this.echequier.getEchec(x, y).getNumPiece() != 0){

			int num = this.echequier.getEchec(x, y).getNumPiece(); // "copie" la piece au coord initial
			this.echequier.setEchec(x, y, 0, joueur); // remplace la piece au coord initial par une piece null
			this.echequier.setEchec(dx, dy, num, joueur); // remplace la piece null au coord d'arriver par la piece copier au par avant
		}
	}
}
