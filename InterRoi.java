public interface InterRoi{
	public final int depOk[][] = {
		{1, 1, 1},
		{1, 0, 1},
		{1, 1, 1}
	}; // déplacement autoriser
	public final int range = 1; 
	public final int pts = 10; // points gagner lors de la prise de la picece
	public final String nom = "Roi";
	public final String symboleB = "♔";
	public final String symboleN = "♚";
	public final String imageB = "Images/Roi_B.png";
	public final String imageN = "Images/Roi_N.png";
	public final int numPiece = 1;
}