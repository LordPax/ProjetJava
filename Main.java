import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.stage.*;

public class Main extends Application{

	@Override
	public void start(Stage stage){
		Affichage aff = new Affichage(500, 350);
        aff.init(stage);
	}

	public static void main(String[] args){
		Partie p = new Partie();
		p.lancerPartie(); // lance la partie
		launch(Main.class, args);
	}
}
