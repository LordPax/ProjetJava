import java.util.ArrayList;

public class Piece{
	private int x;
	private int y;
	private int dirX;
	private int dirY;
	private int nbCase;
	private int pts;
	private int couleur;
	protected String test;

	public Piece(String str){
		this.test = str;
	}
	public String getTest(){
		return this.test;
	}
}
