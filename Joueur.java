import java.util.ArrayList;

public class Joueur{
	private int couleur;
	private int pts;
	private ArrayList<Integer> prise;

	public Joueur(int c){
		this.couleur = c;
		this.pts = 0;
	}

	public int getPts(){
		return this.pts;
	}
	public int getCouleur(){
		return this.couleur;
	}

	public void setPts(int pts){
		this.pts = pts;
	}
	public void setCouleur(int c){
		this.couleur = c;
	}
}
