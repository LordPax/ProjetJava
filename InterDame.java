public interface InterDame{
	public final int depOk[][] = {
		{1, 1, 1},
		{1, 0, 1},
		{1, 1, 1}
	}; // déplacement autoriser
	public final int range = 2; // 0 = cavalier; 1 = une case; 2 = ilimité
	public final int pts = 9;
	public final String nom = "Reine";
	public final String symboleB = "♕";
	public final String symboleN = "♛";
	public final int numPiece = 2;
}