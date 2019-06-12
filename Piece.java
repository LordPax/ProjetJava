import java.util.ArrayList;

public abstract class Piece{
	protected int x;
	protected int y;
	protected int couleur;
	//protected String test;

	public Piece(int couleur){
		this.couleur = couleur;
	}

	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setCouleur(int c){
		this.couleur = c;
	}
	// public void setTest(String str){
	// 	this.test = str;
	// }

	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public int getCouleur(){
		return this.couleur;
	}
	// public String getTest(){
	// 	return this.test;
	// }

	public abstract String getNom();
	public abstract int getPts();
	public abstract String getSymbole();
	public abstract int getNumPiece();
}
