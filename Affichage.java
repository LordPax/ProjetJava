import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.geometry.*;

public class Affichage{
	private int w;
	private int h;
	private Partie partie;
	// private Button btnValide;
	private int nb = 7, nb2 = 6;
	private TextField champX;
	private TextField champY;
	private TextField champDX;
	private TextField champDY;
	private Label score_B;
	private Label score_N;
	private HBox prise_B;
	private HBox prise_N;
	private final String[] lettre = {"A", "B", "C", "D", "E", "F", "G", "H"};

	public Affichage(int w, int h){
		this.w = w;
		this.h = h;
	}

	public void init(Stage stage, Partie partie){
		this.partie = partie;
		stage.setTitle("♙ BroLord Chess ♙");
		stage.setResizable(false);

		Group root = new Group();
		Scene scene = new Scene(root, this.w, this.h, Color.LIGHTBLUE);
		stage.setScene(scene);
		HBox box = new HBox();

		Label labelX = new Label("X : ");
		Label labelY = new Label("Y : ");
		Label labelDX = new Label("DX : ");
		Label labelDY = new Label("DY : ");

		Group score = score(550, 50);
		double widthText = 50;
		int x = 50, y = 50 * 9 + 10;
		
		Button btnValide = new Button("Valider");
		this.champX = new TextField();
		this.champY = new TextField();
		this.champDX = new TextField();
		this.champDY = new TextField();

		this.champX.setMaxWidth(widthText);
		this.champY.setMaxWidth(widthText);
		this.champDX.setMaxWidth(widthText);
		this.champDY.setMaxWidth(widthText);

		System.out.println("tour de : " + partie.tourJeu());

		btnValide.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				char chx = champX.getText().charAt(0);
				int chy = Integer.parseInt(champY.getText());
				char chdx = champDX.getText().charAt(0);
				int chdy = Integer.parseInt(champDY.getText());

				if (partie.h_deplacerPiece(chx, chy, chdx, chdy, partie.tourJeu()) == 0){
					partie.tourPlus();
					champX.setText("");
					champY.setText("");
					champDX.setText("");
					champDY.setText("");
				}

				// score_B.setText(Integer.toString(partie.getJoueur(0).getPts()));
				// score_N.setText(Integer.toString(partie.getJoueur(1).getPts()));
				// prise_B = prise(0);
				// prise_N = prise(1);

				System.out.println("tour de : " + partie.tourJeu());
				root.getChildren().add(score(550, 50));
				root.getChildren().add(g_affichage());
			}
		});

		box.getChildren().add(labelX);
		box.getChildren().add(this.champX);
		box.getChildren().add(labelY);
		box.getChildren().add(this.champY);
		box.getChildren().add(labelDX);
		box.getChildren().add(this.champDX);
		box.getChildren().add(labelDY);
		box.getChildren().add(this.champDY);
		box.getChildren().add(btnValide);
		box.setLayoutX(x);
		box.setLayoutY(y);

		root.getChildren().add(this.score(550, 50));
		root.getChildren().add(this.g_affichage());
		root.getChildren().add(box);
		
		stage.show();

	}
	// public HBox control(){
	// 	HBox box = new HBox();
	// 	this.btnValide = new Button("Valider");

	// 	this.btnValide.setOnAction(new EventHandler<ActionEvent>(){
	// 		public void handle(ActionEvent e){
	// 			System.out.println("retour : " + partie.h_deplacerPiece('E', nb--, 'E', nb2--, 0));
	// 			partie.afficher();
	// 		}
	// 	});

	// 	box.getChildren().add(btnValide);

	// 	return box;
	// }
	public Group g_affichage(){
		Group g = new Group();
		Rectangle r, fond;
		ImageView imgV;
		Label coordX, coordY;
		
		int x = 50, y = 50, w = 50, h = 50, nb = 0;
		int x2 = 0, y2 = 0;
		int lx = 0, ly = 0;
		int lx2 = 0, ly2 = 0;
		double fontSize = 25.0;
		int fs = (int)fontSize;

		fond = carre(x - x / 10, y - y / 10, w * 8 + w / 5, h * 8 + w / 5, Color.BROWN);
		g.getChildren().add(fond);

		for (int i = 0; i < 8; i++) {
			
			for (int j = 0; j < 8; j++) {
				nb = (i + j) % 2;

				x2 = w * i + x;
				y2 = h * j + y;

				lx = y2 + w / 2 - fs / 2;
				ly = x2 + h / 2 - fs / 2;

				lx2 = w / 2 - fs / 2;

				coordX = this.labX(lettre[i], lx2, ly, fontSize);
				coordY = this.labY(i + 1, ly, lx2, fontSize);
				r = this.cases(y2, x2, w, h, nb);
				imgV = this.piece(i, j, x2, y2, w, h);
				
				g.getChildren().add(coordX);
				g.getChildren().add(coordY);
				g.getChildren().add(r);
				g.getChildren().add(imgV);
			}
		}

		return g;
	}
	public Group score(int x, int y){
		double fontSize = 30.0;
		double fontSize2 = 20.0;
		Group g = new Group();
		HBox gp1 = new HBox();
		HBox gp2 = new HBox();
		VBox sc = new VBox();

		Rectangle fond = carre(-50, -50, 500, 500, Color.WHITE);

		Label joueur_B = new Label("Joueur blanc");
		Label joueur_N = new Label("Joueur noir");
		Label infoScore_B = new Label("score : ");
		Label infoScore_N = new Label("score : ");
		String text = (this.partie.getTour() % 2 == 0) ? "Blanc" : "Noir";
		Label labTour = new Label("Tour au " + text);

		this.prise_B = prise(0);
		this.prise_N = prise(1);
		this.score_B = new Label("0");
		this.score_N = new Label("0");
		this.score_B.setText(Integer.toString(partie.getJoueur(0).getPts()));
		this.score_N.setText(Integer.toString(partie.getJoueur(1).getPts()));
		// this.score_B = new Label("0");
		// this.score_N = new Label("0");

		joueur_B.setFont(new Font(fontSize));
		joueur_N.setFont(new Font(fontSize));

		infoScore_B.setFont(new Font(fontSize2));
		infoScore_N.setFont(new Font(fontSize2));
		score_B.setFont(new Font(fontSize2));
		score_N.setFont(new Font(fontSize2));
		labTour.setFont(new Font(fontSize));

		gp1.getChildren().add(infoScore_B);
		gp1.getChildren().add(score_B);

		gp2.getChildren().add(infoScore_N);
		gp2.getChildren().add(score_N);

		sc.getChildren().add(joueur_B);
		sc.getChildren().add(gp1);
		sc.getChildren().add(prise_B);

		sc.getChildren().add(joueur_N);
		sc.getChildren().add(gp2);
		sc.getChildren().add(prise_N);
		sc.getChildren().add(labTour);

		g.getChildren().add(fond);
		g.getChildren().add(sc);
		g.setLayoutX(x);
		g.setLayoutY(y);

		return g;
	}
	public HBox prise(int c){
		HBox pr = new HBox();
		ImageView img;
		int prise;
		int w = 20, h = 20;
		String url = "";

		for (int i = 0; i < this.partie.getJoueur(c).getTaillePrise(); i++){
			prise = this.partie.getJoueur(c).getPrise(i);
			switch(prise){
				case 1:
					url = (c == 1) ? "Images/Roi_B.png" : "Images/Roi_N.png";
					break;
				case 2:
					url = (c == 1) ? "Images/Dame_B.png" : "Images/Dame_N.png";
					break;
				case 3:
					url = (c == 1) ? "Images/Tour_B.png" : "Images/Tour_N.png";
					break;
				case 4:
					url = (c == 1) ? "Images/Cavalier_B.png" : "Images/Cavalier_N.png";
					break;
				case 5:
					url = (c == 1) ? "Images/Fou_B.png" : "Images/Fou_N.png";
					break;
				case 6:
					url = (c == 1) ? "Images/Pion_B.png" : "Images/Pion_N.png";
					break;
			}

			img = new ImageView(url);
			img.setFitWidth(w);
			img.setFitHeight(h);

			pr.getChildren().add(img);
		}

		return pr;
	}
	public Label labX(String labX, int x, int y, double size){
		Label l = new Label(labX);
		l.setLayoutX(y);
		l.setLayoutY(x);
		l.setFont(new Font(size));

		return l;
	}
	public Label labY(int labY, int x, int y, double size){
		Label l = new Label(Integer.toString(labY));
		l.setLayoutX(y);
		l.setLayoutY(x);
		l.setFont(new Font(size));

		return l;
	}
	public ImageView piece(int i, int j, int x, int y, int w, int h){
		ImageView img = new ImageView(this.partie.getEchequier().getEchec(j, i).getImage());
		img.setFitWidth(w);
		img.setFitHeight(h);
		img.setX(y);
		img.setY(x);

		return img;
	}
	public Rectangle cases(int x, int y, int w, int h, int couleur){
		Color color = (couleur == 0) ? Color.WHITE : Color.GRAY; 
		return carre(x, y, w, h, color);
	}
	public Rectangle carre(int x, int y, int w, int h, Color couleur){
		Rectangle r = new Rectangle();
		r.setFill(couleur);
		r.setX(x);
		r.setY(y);
		r.setWidth(w);
		r.setHeight(h);
		r.setArcWidth(1);
		r.setArcHeight(1);

		return r;
	}
}