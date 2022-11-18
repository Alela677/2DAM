package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PrincipalViewControlador {
	
	private LoginViewControlador controlLogin;
	private Stage stage;
    @FXML
    private Button volver;

    @FXML
    void volverLogin(ActionEvent event) {
    	controlLogin.show();
    	stage.close();
    }	

	public void init(Stage stage, LoginViewControlador loginViewControlador) {
		// TODO Auto-generated method stub
		
		this.controlLogin = loginViewControlador;
		this.stage = stage;
	}

}
