package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerMenu implements Initializable {

	private ControllerAlimentacion contAlimentacion;
	private ControllerBienestar contBienestar;
	private ControllerHidratacion contHidratacion;
	
	@FXML
	private Pane mainPane;


	public ControllerMenu() {
		contAlimentacion = new ControllerAlimentacion(this);
		contBienestar = new ControllerBienestar(this);
		contHidratacion = new ControllerHidratacion(this);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public Pane getMainPane() {
		return mainPane;
	}

	public void alimentacion() {
		try {
			FXMLLoader fl = new FXMLLoader(getClass().getResource("alimentacion.fxml"));
			fl.setController(contAlimentacion);
			Parent p = fl.load();			
			mainPane.getChildren().clear();
			mainPane.getChildren().add(p);
//			Stage s = new Stage();
//			s.setScene(new Scene(p));			
//			s.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void hidratacion() {
		try {
			FXMLLoader fl = new FXMLLoader(getClass().getResource("hidratacionPre.fxml"));
			fl.setController(contHidratacion);
			Parent p = fl.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void bienestar() {
		try {
			FXMLLoader fl = new FXMLLoader(getClass().getResource("bienestarPre.fxml"));
			fl.setController(contBienestar);
			Parent p = fl.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
