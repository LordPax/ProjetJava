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

public class Main extends Application{
	private Partie partie;

	@Override
	public void start(Stage stage){
		Affichage aff = new Affichage(1000, 500);
		this.partie = new Partie();
		this.partie.afficher();

		
		aff.init(stage, this.partie);
	}

	public static void main(String[] args){
		launch(Main.class, args);
	}
}
