import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;

public class Affichage{
	private int w;
	private int h;

	public Affichage(int w, int h){
		this.w = w;
		this.h = h;
	}

	public void init(Stage stage){
		stage.setTitle("♙ Echéquier ♙");
		Group root = new Group();
		Scene scene = new Scene(root, this.w, this.h, Color.LIGHTBLUE);
		stage.setScene(scene);
		 
		root.getChildren().add(this.g_affichage());

		stage.show();
	}
	public Group g_affichage(){
		Group g = new Group();
		Rectangle r;
		Label l;
		int x = 50, y = 50, w = 50, h = 50, nb = 0;
		int x2 = 0, y2 = 0;
		int lx = 0, ly = 0;
		double fontSize = 30.0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				nb = (i + j) % 2;

				x2 = w * i + x;
				y2 = h * j + y;

				lx = y2 + w / 2;
				ly = x2 + h / 2;

				r = carre(y2, x2, w, h, nb);
				l = new Label("♙");
				l.setLayoutX(y2 + w / 2 - fontSize);
				l.setLayoutY(x2 + h / 2 - fontSize);
				l.setFont(new Font(fontSize));
				l.setTextFill(Color.WHITE);
				g.getChildren().add(r);
				g.getChildren().add(l);
				
			}
		}

		return g;
	}
	public Rectangle carre(int x, int y, int w, int h, int couleur){
		Rectangle r = new Rectangle();
		r.setFill((couleur == 0) ? Color.WHITE : Color.BLACK);
		r.setX(x);
		r.setY(y);
		r.setWidth(w);
		r.setHeight(h);
		r.setArcWidth(1);
		r.setArcHeight(1);

		return r;
	}
}