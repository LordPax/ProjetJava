public interface InterTour{
	public final int depOk[][] = {
		{0, 1, 0},
		{1, 0, 1},
		{0, 1, 0}
	}; // déplacement autoriser
	public final int range = 2;
	public final int pts = 5;
	public final String nom = "Tour";
	public final String symboleB = "♖";
	public final String symboleN = "♜";
	public final int numPiece = 3;
}