import java.util.ArrayList;

public class Echequier {
  // private Piece[][] echequier;
  private ArrayList<Piece> echequier;

  public Echequier(){
    // this.echequier = new Piece[8][8];
    this.echequier = new ArrayList<Piece>();

    for (int i = 0; i < 64; i++) {
      this.echequier.add(new Piece());
    }
    /*this.echequier[] = new Piece[8];

    for (int i = 0; i < 8; i++) {
      this.echequier[i] = new Piece[8];
    }*/

    /*for (int i = 0; i < 8; i++) {
      for (int j = 0; i < 8; i++) {
        this.echequier[i][j] = new Piece();
      }
    }*/
  }

  public Piece getEchec(int i){
    return this.echequier.get(i);
  }
}
