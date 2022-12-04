package Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InicioC {

	private BorderPane rooPane;
	private Stage stage;
	private PrincipalC controlPrincipal;

	@FXML
	private Pane ventas;

	@FXML
	private Pane empleados;

	@FXML
	private ImageView mecanicos;

	@FXML
	void vistaEmpleados(MouseEvent event) throws IOException {
		escenaEmpleados();
	}

	@FXML
	void vistaMecanicos(MouseEvent event) throws IOException {
		escenaMecanicos();
	}

	@FXML
	void vistaVentas(MouseEvent event) throws IOException {

		escenaVentas();

	}

	private void escenaVentas() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/SceneVentas.fxml"));
		AnchorPane root = loader.load();
		LoginController.root.setCenter(root);
	}

	private void escenaEmpleados() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/SceneEmpleados.fxml"));
		AnchorPane root = loader.load();
		LoginController.root.setCenter(root);
	}

	private void escenaMecanicos() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/SceneMecanicos.fxml"));
		AnchorPane root = loader.load();
		LoginController.root.setCenter(root);
	}
}
