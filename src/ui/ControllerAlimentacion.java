package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class ControllerAlimentacion implements Initializable {

	private ControllerMenu cm;
	
	public ControllerAlimentacion(ControllerMenu cm) {
		this.cm = cm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	public void regresar(MouseEvent event) throws IOException {
		Pane pane = cm.getMainPane();
		FXMLLoader fl = new FXMLLoader(getClass().getResource("menu.fxml"));
		fl.setController(cm);
		Parent p = fl.load();
		pane.getChildren().clear();
		pane.getChildren().add(p);
	}

}
