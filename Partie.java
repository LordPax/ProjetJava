public class Partie{
  private int tour;
  private Joueur[] joueur;
  private Echequier echequier;

  public Partie(){
    this.echequier = new Echequier();
  }
  public void afficher(){
    System.out.println(this.echequier.getEchec(0).getTest());
  }
}
