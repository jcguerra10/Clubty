package ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class ControllerAlimentacion implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	public void regresar(MouseEvent event) {
		(((Node) event.getSource())).getScene().getWindow().hide();
	}

}
