package Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrincipalC {

	private Stage stage;
	private LoginController controLogin;
	private BorderPane borderPane;
	
	@FXML
	private Label nombreUsuario;

	@FXML
	private MenuButton menuVentas;

	@FXML
	private MenuButton menuEmpleados;

	@FXML
	private MenuButton menuMecanicos;

	public void init(Stage stage, LoginController loginController, String usuario, BorderPane border) throws IOException {
		this.stage = stage;
		this.controLogin = loginController;
		nombreUsuario.setText(usuario);
		this.borderPane = border;
		escenaInicio();
	}
	
	
	public void escenaInicio() throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("/Views/ScenaInicio.fxml"));
		AnchorPane root = load.load();
		borderPane.setCenter(root);
		
		
		
	}
	
		@FXML
	    private Button btnInicio;

	    @FXML
	    void vistaInicio(MouseEvent event) throws IOException {
	    	escenaInicio();
	    }

	
}