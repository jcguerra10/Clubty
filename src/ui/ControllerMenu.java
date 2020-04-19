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
import javafx.stage.Stage;

public class ControllerMenu implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void alimentacion() {
		try {
			FXMLLoader fl = new FXMLLoader(getClass().getResource("alimentacion.fxml"));
			Parent p = fl.load();
			Stage s = new Stage();
			s.setScene(new Scene(p));			
			s.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void hidratacion() {
		try {
			FXMLLoader fl = new FXMLLoader(getClass().getResource("hidratacionPre.fxml"));
			Parent p = fl.load();
			Stage s = new Stage();
			s.setScene(new Scene(p));			
			s.show();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
