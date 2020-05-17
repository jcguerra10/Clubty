package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.App;
import model.Usuario;

public class ControllerUsuario implements Initializable {

	private ControllerMenu cm;

	@FXML
	private Pane mainPane;

	@FXML
	private Label nombre;

	@FXML
	private Label apellido;

	@FXML
	private Label altura;

	@FXML
	private Label peso;

	@FXML
	private Label fechaNacimiento;

	@FXML
	private Label sexo;

	@FXML
	private Label anios;

	@FXML
	private Button Cambiar;

	public ControllerUsuario(ControllerMenu cm) {
		this.cm = cm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (nombre != null && apellido != null && altura != null && peso != null && fechaNacimiento != null
				&& sexo != null && anios != null) {
			setLabels();
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

	public void setLabels() {
		App a = cm.getApp();
		String[] allName = a.getAllUsuario();
		if (allName != null) {
			nombre.setText(allName[0]);
			apellido.setText(allName[1]);
			altura.setText(allName[2]);
			peso.setText(allName[3]);
			fechaNacimiento.setText(allName[4]);
			sexo.setText(allName[5]);
			anios.setText(allName[6]);
		}
	}

	public void cambiarUsuario() {
		App a = cm.getApp();
		a.nuevoUsuario(nombre.getText(), apellido.getText(), Double.parseDouble(altura.getText()),
				Double.parseDouble(peso.getText()), fechaNacimiento.getText(), sexo.getText().charAt(0),
				Integer.parseInt(anios.getText()));
	}

	public void cambiarVentanaUsuACambio() throws IOException {
		Pane pane = cm.getMainPane();
		FXMLLoader fl = new FXMLLoader(getClass().getResource("cambioUsuario.fxml"));
		fl.setController(this);
		Parent p = fl.load();
		pane.getChildren().clear();
		pane.getChildren().add(p);
	}
}
