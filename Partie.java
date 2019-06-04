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
		System.out.println(this.deplacerPiece(1, 1, 3, 1, 0)); // déplacement d'une piece
		this.afficher();
		System.out.println(this.deplacerPiece(6, 7, 4, 7, 1));
		this.afficher();
		System.out.println(this.deplacerPiece(6, 6, 5, 6, 1)); // retourne 1
		this.afficher();
		System.out.println(this.deplacerPiece(1, 3, 3, 3, 0)); // retourne 1
		this.afficher();
		System.out.println(this.deplacerPiece(6, 7, 4, 7, 3)); // retourne 3
		this.afficher();
		System.out.println(this.deplacerPiece(4, 4, 4, 7, 1)); // retourne 2
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
	public int deplacerPiece(int x, int y, int dx, int dy, int joueur){ // x, y : coord initial; dx, dy : coord d'arriver; joueur : couleur du joueur
		int num = this.echequier.getEchec(x, y).getNumPiece(); // "copie" la piece au coord initial
		int couleur = this.echequier.getEchec(x, y).getCouleur(); // copie la couleur

		if (x >= 0 && x < 8 && y >= 0 && y < 8 && dx >= 0 && dx < 8 && dy >= 0 && dy < 8 && (joueur == 0 || joueur == 1)) {
			if (num != 0){
				if (couleur == joueur) {
					this.echequier.setEchec(x, y, 0, 0); // remplace la piece au coord initial par une piece null
					this.echequier.setEchec(dx, dy, num, couleur); // remplace la piece null au coord d'arriver par la piece copier au par avant

					return 0; // retourne 0 si tout ce passe bien
				}
				else{
					return 1; // retourne 1 si la couleur du joueur est différente de la couleur de la piece choisi
				}
			}
			else{
				return 2; // retourne 2 si il n'y a aucune piece su endroit choisi
			}
		}
		else{
			return 3; // retourne 3 si les valeur d'entrer son invalide
		}
	}
}
