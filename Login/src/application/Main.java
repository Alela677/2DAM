package application;
	
import java.io.IOException;

import Controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Views/LoginView.fxml"));
			Parent root =loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			LoginController controler = loader.getController();
			controler.setStage(primaryStage);
			primaryStage.show();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}