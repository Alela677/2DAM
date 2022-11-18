package application;

import java.io.IOException;

import View.LoginViewControlador;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class Main extends Application {

	private AnchorPane anchorPane;
	public Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		try {

			this.primaryStage = primaryStage;
			primaryStage.setTitle("LOGIN");
			
			inciarLogin();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void inciarLogin() {

		try {

			FXMLLoader load = new FXMLLoader();
			load.setLocation(Main.class.getResource("../View/LoginView.fxml"));
			anchorPane = (AnchorPane) load.load();

			Scene scene = new Scene(anchorPane);

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			

			LoginViewControlador controlador = load.getController();
			controlador.setStage(primaryStage);
			
			primaryStage.show();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
