package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerBienestar implements Initializable {

	@FXML
	ComboBox<String> cb;
	@FXML
	Slider sl;
	
	ObservableList<String> ol = FXCollections.observableArrayList("Suenio", "Concentracion", "Ejercicio");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (cb != null) {
			cb.setItems(ol);
		}
	}
	
	public void regresar(MouseEvent event) {
		(((Node) event.getSource())).getScene().getWindow().hide();
	}
	
	public void goTo(ActionEvent event) {
		String res = cb.getValue();

		if (res.equals("Suenio")) {
			try {
				(((Node) event.getSource())).getScene().getWindow().hide();
				FXMLLoader fl = new FXMLLoader(getClass().getResource("suenio.fxml"));
				Parent p = fl.load();
				Stage st = new Stage();
				st.setScene(new Scene(p));				
				st.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (res.equals("Concentracion")) {
			try {
				(((Node) event.getSource())).getScene().getWindow().hide();
				FXMLLoader fl = new FXMLLoader(getClass().getResource("concentracion.fxml"));
				Parent p = fl.load();
				Stage st = new Stage();
				st.setScene(new Scene(p));				
				st.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (res.equals("Ejercicio")){
			try {
				(((Node) event.getSource())).getScene().getWindow().hide();
				FXMLLoader fl = new FXMLLoader(getClass().getResource("ejercicio.fxml"));
				Parent p = fl.load();
				Stage st = new Stage();
				st.setScene(new Scene(p));				
				st.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void tellme() {
		System.out.println(sl.getValue()+"");
		
	}

}
