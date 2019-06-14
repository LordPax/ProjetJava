import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class Main extends Application{
	public void start(Stage stage){
		Label l = new Label("salut bande de connard");
		Scene scene = new Scene(new StackPane(l), 500, 350);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args){
		Partie p = new Partie();
		p.lancerPartie(); // lance la partie
		launch();
	}
}
