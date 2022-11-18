package View;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginViewControlador implements Initializable {
	String user = "Nuevo";
	String pass = "Nuevo";

	private Stage stage;

	@FXML
	public static ImageView insta;

	@FXML
	public ImageView face;

	@FXML
	public ImageView twet;

	@FXML
	public ImageView fondo;

	@FXML
	private Button validar;

	@FXML
	private Button cancelar;

	@FXML
	private TextField username;

	@FXML
	private TextField password;
	
	
	@FXML
	public void instagram() {

		URL url = null;
		try {
			url = new URL("http://instagram.com/");
			try {
				Desktop.getDesktop().browse(url.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	public void twitter() {

		URL url = null;
		try {
			url = new URL("https://twitter.com/?lang=es");
			try {
				Desktop.getDesktop().browse(url.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	public void facebook() {

		URL url = null;
		try {
			url = new URL("https://es-es.facebook.com/");
			try {
				Desktop.getDesktop().browse(url.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	}

	public void vaidarLogin() throws IOException {

		System.out.println(username.getText() + " " + password.getText());

		if ((username.getText().equals(user)) && (password.getText().equals(pass))) {
			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setContentText("Bienvenido");
			alerta.showAndWait();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/PrinciapalView.fxml"));
			Parent root = loader.load();
			PrincipalViewControlador controler = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			controler.init(stage, this);
			stage.show();
			this.stage.close();

		} else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setContentText("ERROR: El usuario no existe");
			alerta.showAndWait();
		}

	}

	public void cancel() {
		Platform.exit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void setStage(Stage primaryStage) {

		stage = primaryStage;
	}

	public void show() {

		stage.show();
	}

}