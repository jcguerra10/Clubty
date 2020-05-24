package ui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.App;
import model.Suenio;

public class ControllerBienestar implements Initializable {

	private ControllerMenu cm;

	@FXML
	ComboBox<String> cb;
	@FXML
	Slider sl;
        @FXML
        TextField horas;
        @FXML
        TextField minutos;
        @FXML
        Button fin;
        @FXML
        DatePicker diaBuscar;
        @FXML
        Button buscar;
        @FXML
        DatePicker dp;

	ObservableList<String> ol = FXCollections.observableArrayList("Suenio", "Concentracion", "Ejercicio");

	public ControllerBienestar(ControllerMenu cm) {
		this.cm = cm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (cb != null) {
			cb.setItems(ol);
		}
	}

	public void regresar(MouseEvent event) throws IOException {
		Pane pane = cm.getMainPane();
		FXMLLoader fl = new FXMLLoader(getClass().getResource("menu.fxml"));
		fl.setController(cm);
		Parent p = fl.load();
		pane.getChildren().clear();
		pane.getChildren().add(p);
	}

	public void goTo(ActionEvent event) {
		String res = cb.getValue();

		if (res.equals("Suenio")) {
			try {
				Pane pane = cm.getMainPane();
				FXMLLoader fl = new FXMLLoader(getClass().getResource("suenio.fxml"));
				fl.setController(this);
				Parent p = fl.load();
				pane.getChildren().clear();
				pane.getChildren().add(p);
                                
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (res.equals("Concentracion")) {
			try {
				Pane pane = cm.getMainPane();
				FXMLLoader fl = new FXMLLoader(getClass().getResource("concentracion.fxml"));
				fl.setController(this);
				Parent p = fl.load();
				pane.getChildren().clear();
				pane.getChildren().add(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (res.equals("Ejercicio")) {
			try {
				Pane pane = cm.getMainPane();
				FXMLLoader fl = new FXMLLoader(getClass().getResource("ejercicio.fxml"));
				Parent p = fl.load();
				pane.getChildren().clear();
				pane.getChildren().add(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        
        public  void addSuenio(ActionEvent event) {

           App a = new App();
            if (horas.getText().equalsIgnoreCase("") || horas.getText().equalsIgnoreCase(" ") || horas.getText().equalsIgnoreCase(null)
                    && minutos.getText().equalsIgnoreCase("") || minutos.getText().equalsIgnoreCase(" ") || minutos.getText().equalsIgnoreCase(null) ) {
                
                
            }else{
                
                
                LocalDate ld = dp.getValue();
                String dia = ld.getDayOfMonth()+"/"+ld.getMonth()+"/"+ld.getYear();
                int horaSuenio = Integer.parseInt(horas.getText());
                int minutoSuenio = Integer.parseInt(minutos.getText());
                double rate = sl.getValue();
                int day = ld.getDayOfMonth();
                int month = ld.getMonthValue();
                int year = ld.getYear();
                Suenio s = new Suenio(rate, horaSuenio, minutoSuenio, dia);
                a.agregarSuenio(s);
                
                
            }
        }

	public void tellme() {
                System.out.println(sl.getValue() + "");
                

	}

}
