package Views;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class LoginController {

    @FXML
    public static ImageView imgFondo;
    
    @FXML
    private ImageView imgInstagram;

    
    public static void name() {
	LoginController.imgFondo.setVisible(true);
	}

}
