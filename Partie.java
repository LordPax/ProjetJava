import java.util.ArrayList;

public class Partie{
	private int tour; // nombre de tour éffectuer par les joueurs
	private ArrayList<Joueur> joueur; // joueurs au nombre de 2
	private Echequier echequier; // //échéquier ou ce trouve les piceces 

	public Partie(){
		this.joueur.add(new Joueur(0));
		this.joueur.add(new Joueur(1));
		this.echequier = new Echequier();
	}

	public Joueur getJoueur(int c){
		return this.joueur.get(c);
	}

	public void lancerPartie(){
		//this.echequier.setEchec(3, 1, 2, 0);
		this.echequier.setEchec(3, 6, 2, 1);
		this.echequier.setEchec(3, 1, 6, 1);
		
		this.afficher();
		System.out.println(this.deplacerPiece(3, 6, 3, 1, 1));
		this.afficher();

		// System.out.println(this.deplacerPiece(1, 1, 1, 3, 0)); // déplacement d'une piece
		// this.afficher();
		// System.out.println(this.deplacerPiece(7, 6, 7, 4, 1));
		// this.afficher();
		// System.out.println(this.echequier.getEchec(7, 6).getNom());
		// System.out.println(this.deplacerPiece(5, 6, 5, 5, 1)); // retourne 1
		// this.afficher();
		// System.out.println(this.echequier.getEchec(7, 6).getNom());
		// System.out.println(this.deplacerPiece(2, 1, 2, 3, 0)); // retourne 1
		// this.afficher();
	}
	public void afficher(){
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				System.out.print(this.echequier.getEchec(j, i).getSymbole() + " "); // affichage 1 par 1 des piceces de l'échéquier
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
				dep = (couleur == 0) ? 1 : -1; // permet de ce déplacer dans un sens ou dans l'autre en fonction de la valeur de la couleur du pion
				deb0 = (y == 1 && couleur == 0) ? 2 : 1; // permet à un pion blanc de pouvoir avancer de 2 case si le pion est a son point départ
				deb1 = (y == 6 && couleur == 1) ? 2 : 1; // idem mais pour les pion noir

				if (!(x == dx && (rx == deb0 * dep || ry == deb1 * dep)))
					return 4; // retourne 4 si le déplacement est invalide pour cette piece
				break;
		}

		if (numAutre != 0 && couleurAutre != couleur)
			this.prendrePiece(x, y, joueur, couleur);
		
		this.echequier.setEchec(x, y, 0, couleur); // remplace la piece au coord initial par une piece null
		this.echequier.setEchec(dx, dy, num, couleur); // remplace la piece null au coord d'arriver par la piece copier au par avant
		
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
		return 0;
	}
}