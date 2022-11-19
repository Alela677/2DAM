package Controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import DAOS.UsuariosDAO;
import Models.Usuarios;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {

	private Stage stage;

	@FXML
	private Button btnCancel;

	@FXML
	private Button btnLogin;

	@FXML
	private ImageView facebook;

	@FXML
	private ImageView instagram;

	@FXML
	private ImageView twitter;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private TextField txtUser;

	@FXML
	void logeo(MouseEvent event) {

		String nombre = txtUser.getText();
		String passwd = txtPassword.getText();

		Usuarios comprobar = UsuariosDAO.consultarUsuarios(nombre, passwd);

		boolean registrado = false;

		if (comprobar.getNombre().equals(nombre) && comprobar.getPassword().equals(passwd)) {
			registrado = true;
		}

		if (registrado == true) {
			try {
				FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("../Views/PrincipalView.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);
				PrincipalLogin controller = loader.getController();
				Stage stage2 = new Stage();
				stage.setScene(scene);
				controller.init(stage2, this);
				stage.show();
				this.stage.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		} else {
			alertaError();
		}
	}

	@FXML
	void salir(MouseEvent event) {
		Platform.exit();
	}

	@FXML
	void webFacebook(MouseEvent event) {
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

	@FXML
	void webInstagram(MouseEvent event) {
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
	void webTwitter(MouseEvent event) {
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

	public void setStage(Stage primaryStage) {
		stage = primaryStage;

	}

	public static void alertaError() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setContentText("Usuario incorrecto");
		alert.showAndWait();

	}
}
