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
	private final String[] lettre = {"A", "B", "C", "D", "E", "F", "G", "H"};

	public Affichage(int w, int h){
		this.w = w;
		this.h = h;
	}

	public void init(Stage stage, Partie partie){
		this.partie = partie;
		stage.setTitle("♙ BroLord Chess ♙");
		Group root = new Group();
		Scene scene = new Scene(root, this.w, this.h, Color.LIGHTBLUE);
		stage.setScene(scene);
		HBox box = new HBox();
		Label labelX = new Label("X : ");
		Label labelY = new Label("Y : ");
		Label labelDX = new Label("DX : ");
		Label labelDY = new Label("DY : ");
		double widthText = 50;
		int x = 50, y = 50 * 9 + 10;

		// root.getChildren().add(this.control());
		
		// this.partie.h_deplacerPiece('E', 7, 'E', 5, 0);
		
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

				System.out.println("tour de : " + partie.tourJeu());
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
		Rectangle r;
		ImageView imgV;
		Label coordX, coordY;
		//Rectangle fond = carre(int x, int y, int w, int h, int couleur)
		
		int x = 50, y = 50, w = 50, h = 50, nb = 0;
		int x2 = 0, y2 = 0;
		int lx = 0, ly = 0;
		int lx2 = 0, ly2 = 0;
		double fontSize = 25.0;
		int fs = (int)fontSize;

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
		Rectangle r = new Rectangle();
		r.setFill((couleur == 0) ? Color.WHITE : Color.GRAY);
		r.setX(x);
		r.setY(y);
		r.setWidth(w);
		r.setHeight(h);
		r.setArcWidth(1);
		r.setArcHeight(1);

		return r;
	}
}