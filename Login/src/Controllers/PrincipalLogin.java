package Controllers;

import javafx.stage.Stage;

public class PrincipalLogin {

	private Stage stage;
	private LoginController loginController;

	public void init(Stage stage2, LoginController loginController) {
		this.loginController = loginController;
		this.stage = stage2;

	}

}
