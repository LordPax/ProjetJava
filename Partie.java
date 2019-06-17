import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class Partie {
	private int tour; // nombre de tour éffectuer par les joueurs
	private ArrayList<Joueur> joueur; // joueurs au nombre de 2
	private Echequier echequier; // //échéquier ou ce trouve les piceces 

	public Partie(){
		this.joueur = new ArrayList<Joueur>();
		this.joueur.add(new Joueur(0));
		this.joueur.add(new Joueur(1));
		this.echequier = new Echequier();
		this.tour = 0;
	}

	public Echequier getEchequier(){
		return this.echequier;
	}
	public Joueur getJoueur(int c){
		return this.joueur.get(c);
	}
	public int getTour(){
		return this.tour;
	}
	public void tourPlus(){
		this.tour++;
	}
	public int tourJeu(){
		return this.tour % 2;
	}

	public void lancerPartie(){
		// this.echequier.setEchec(4, 6, 6, 0);
		// this.echequier.setEchec(3, 1, 6, 1);
		// this.echequier.setEchec(4, 3, 6, 1);
		// this.echequier.setEchec(3, 5, 6, 1);

		// h_deplacerPiece('B', 1, 'A', 1, 1);
		
		// this.afficher();
		// System.out.println("retour : " + this.h_deplacerPiece('E', 7, 'E', 5, 0));
		// System.out.println("retour : " + this.deplacerPiece(3, 1, 3, 3, 1));
		// this.afficher();
		// System.out.println("retour : " + this.deplacerPiece(4, 4, 5, 3, 0));
		// this.afficher();

		// System.out.println("retour : " + this.deplacerPiece(3, 1, 5, 3, 1));
		// // System.out.println("retour : " + this.deplacerPiece(3, 6, 6, 6, 1));
		// this.afficher();
	}
	public void afficher(){
		// for (int i = 0; i < 8; i++){
		// 	for (int j = 0; j < 8; j++){
		// 		System.out.print(this.echequier.getEchec(j, i).getSymbole() + " "); // affichage 1 par 1 des piceces de l'échéquier
		// 	}
		// 	System.out.print("\n");
		// }

		// this.getJoueur(0).statistique();
		// this.getJoueur(1).statistique();

		// System.out.print("\n");
	}
	public int deplacerPiece(int x, int y, int dx, int dy, int joueur){ // x, y : coord initial; dx, dy : coord d'arriver; joueur : couleur du joueur
		int num = this.echequier.getEchec(x, y).getNumPiece(); // "copie" la piece au coord initial
		int couleur = this.echequier.getEchec(x, y).getCouleur(); // copie la couleur

		if (x >= 0 && x < 8 && y >= 0 && y < 8 && dx >= 0 && dx < 8 && dy >= 0 && dy < 8 && (joueur == 0 || joueur == 1)) {
			if (num != 0){
				if (couleur == joueur) {
					if (this.trajOk(x, y, dx, dy) == 0) {	
						return this.deplacementValide(x, y, dx, dy, joueur, num, couleur);
					}
					else
						return 5; // retourne 5 si il y un obstacle sur le trajet
				}
				else
					return 1; // retourne 1 si la couleur du joueur est différente de la couleur de la piece choisi
			}
			else
				return 2; // retourne 2 si il n'y a aucune piece su endroit choisi
		}
		else
			return 3; // retourne 3 si les valeur d'entrer son invalide
	}
	public int h_deplacerPiece(char x, int y, char dx, int dy, int joueur){
		int x2 = x - 65, dx2 = dx - 65;
		int y2 = y - 1, dy2 = dy - 1;

		return deplacerPiece(x2, y2, dx2, dy2, joueur);
	}
	public int deplacementValide(int x, int y, int dx, int dy, int joueur, int num, int couleur){
		int dep = 0, deb0 = 0, deb1 = 0;
		int rx = dx - x; // coord relatif x
		int ry = dy - y; // coord relatif y
		int numAutre = this.echequier.getEchec(dx, dy).getNumPiece(); // 
		int couleurAutre = this.echequier.getEchec(dx, dy).getCouleur(); // 

		switch (num) {
			case 1 : // Roi
				if (!(Math.abs(rx) <= 1 && Math.abs(ry) <= 1))
					return 4; // retourne 4 si le déplacement est invalide pour cette piece
				break;

			case 2 : // Dame
				if (!(x == dx || y == dy || Math.abs(rx) == Math.abs(ry)))
					return 4; // retourne 4 si le déplacement est invalide pour cette piece
				break;

			case 3 : // Tour
				if (!(x == dx || y == dy))
					return 4; // retourne 4 si le déplacement est invalide pour cette piece
				break;

			case 4 : // Cavalier
				if (!(Math.abs(rx) == 1 && Math.abs(ry) == 2 || Math.abs(rx) == 2 && Math.abs(ry) == 1))
					return 4; // retourne 4 si le déplacement est invalide pour cette piece
				break;

			case 5 : // Fou
				if (!(Math.abs(rx) == Math.abs(ry)))
					return 4; // retourne 4 si le déplacement est invalide pour cette piece
				break;

			case 6 : // Pion
				dep = (couleur == 0) ? -1 : 1; // permet de ce déplacer dans un sens ou dans l'autre en fonction de la valeur de la couleur du pion
				deb0 = (y == 1 && couleur == 1) ? 2 : 1; // permet à un pion blanc de pouvoir avancer de 2 case si le pion est a son point départ
				deb1 = (y == 6 && couleur == 0) ? 2 : 1; // idem mais pour les pion noir

				if (!((rx == 1 || rx == -1) && ry == dep && numAutre != 0 || x == dx && (ry == deb0 * dep || ry == deb1 * dep) && numAutre == 0))
					return 4; // retourne 4 si le déplacement est invalide pour cette piece
				break;
		}

		if (numAutre != 0 && numAutre != 1 && couleurAutre != couleur) {
			this.prendrePiece(dx, dy, joueur, couleur);
			this.echequier.setEchec(x, y, 0, couleur); // remplace la piece au coord initial par une piece null
			this.echequier.setEchec(dx, dy, num, couleur); // remplace la piece null au coord d'arriver par la piece copier au par avant
		}
		else if (numAutre == 0){
			this.echequier.setEchec(x, y, 0, couleur); // remplace la piece au coord initial par une piece null
			this.echequier.setEchec(dx, dy, num, couleur); // remplace la piece null au coord d'arriver par la piece copier au par avant
		}

		return 0; // retourne 0 si tout ce passe bien
	}
	public int trajOk(int x, int y, int dx, int dy){
		int rx = dx - x; // coord relatif x
		int ry = dy - y; // coord relatif y
		int num = this.echequier.getEchec(x, y).getNumPiece();
		int couleurInit = this.echequier.getEchec(x, y).getNumPiece();
		int dirx = 0, diry = 0;
		int coordx = 0, coordy = 0;

		if (rx < 0) dirx = -1;
		else if (rx > 0) dirx = 1;
		else dirx = 0;

		if (ry < 0) diry = -1;
		else if (ry > 0) diry = 1;
		else diry = 0;

		if (num != 4){
			for (int i = 1; i < Math.abs(rx) || i < Math.abs(ry); i++) {
				coordx = i * dirx;
				coordy = i * diry;
				num = this.echequier.getEchec(x + coordx, y + coordy).getNumPiece();
				if (num != 0) 
					return 1;
			}
		}
		else{
			num = this.echequier.getEchec(dx, dy).getNumPiece();
			if (num != 0)
				return 1;
		}

		return 0; // retourne 0 si il n'y aucun obstacle
	}
	public int prendrePiece(int x, int y, int joueur, int couleurAutre){
		int ptsPiece = this.echequier.getEchec(x, y).getPts();
		int ptsJoueur = this.getJoueur(joueur).getPts();
		int numPiece = this.echequier.getEchec(x, y).getNumPiece();

		this.getJoueur(joueur).setPts(ptsJoueur + ptsPiece);
		this.getJoueur(joueur).addPrise(numPiece);

		return 0;
	}
}