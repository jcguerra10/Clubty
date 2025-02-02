package ui;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import exceptions.EmptyException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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

	@FXML
	private TextField nombreT;

	@FXML
	private TextField apellidoT;

	@FXML
	private TextField alturaT;

	@FXML
	private TextField pesoT;

	@FXML
	private TextField aniosT;

	@FXML
	private DatePicker fechaNacimientoDP;

	@FXML
	private ComboBox<String> cbSexo;

	private ObservableList<String> ol = FXCollections.observableArrayList("M", "F");

	public ControllerUsuario(ControllerMenu cm) {
		this.cm = cm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (nombre != null && apellido != null && altura != null && peso != null && fechaNacimiento != null
				&& sexo != null && anios != null) {
			setLabels();
		}
		if (cbSexo != null) {
			cbSexo.setItems(ol);
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

	private void regresar() throws IOException {
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

	public void cambiarUsuario() throws IOException {
		App app = cm.getApp();
		try {
			if (nombreT.getLength() == 0 || apellidoT.getLength() == 0 || fechaNacimientoDP.getValue() == null
					|| cbSexo.getValue() == null) {
				throw new EmptyException();
			}
			String n = nombreT.getText();
			String ap = apellidoT.getText();
			double a = Double.parseDouble(alturaT.getText());
			double p = Double.parseDouble(pesoT.getText());
			String fn = fechaNacimientoDP.getEditor().getText();
			String sx = cbSexo.getValue();
			int an = Integer.parseInt(aniosT.getText());			
			app.nuevoUsuario(n, ap, a, p, fn, sx, an);
			regresar();
		} catch (NumberFormatException e) {
			aviso();
		} catch (EmptyException e) {
			aviso();
		}
	}

	public void cambiarVentanaUsuACambio() throws IOException {
		Pane pane = cm.getMainPane();
		FXMLLoader fl = new FXMLLoader(getClass().getResource("cambioUsuario.fxml"));
		fl.setController(this);
		Parent p = fl.load();
		pane.getChildren().clear();
		pane.getChildren().add(p);
	}

	private void aviso() {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Espacio vacio");
		a.setContentText("ha dejado un espacio en Blanco");
		a.showAndWait();
	}
}
