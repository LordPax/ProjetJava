import java.util.ArrayList;

public class Joueur{
	private int couleur;
	private int pts;
	private ArrayList<Integer> prise;

	public Joueur(int c){
		this.prise = new ArrayList<Integer>();
		this.couleur = c;
		this.pts = 0;
	}

	public int getPts(){
		return this.pts;
	}
	public int getCouleur(){
		return this.couleur;
	}
	public int getPrise(int p){
		return this.prise.get(p);
	}

	public void setPts(int pts){
		this.pts = pts;
	}
	public void setCouleur(int c){
		this.couleur = c;
	}
	public void addPrise(int v){
		this.prise.add(v);
	}

	public void statistique(){
		System.out.println("=+=+=+=+=+= Joueur " + this.h_couleur() + " =+=+=+=+=+=");
		System.out.println("Point : " + this.getPts());
		System.out.println("Pieces prise : ");
	}
	public String h_couleur(){
		return (this.couleur == 0) ? "Blanc" : "Noir"; 
	}
	// public String h_prise(){
	// 	String piece;

	// 	for (int i = 0; i < this.prise.size(); i++) {
	// 		piece += String.valueOf(this.getPrise(i)) + " ";
	// 	}

	// 	return piece;
	// }
}
