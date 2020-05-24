package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import exceptions.EmptyException;
import exceptions.NoElementosException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Almuerzo;
import model.App;
import model.Comida;
import model.Desayuno;
import model.Elemento;
import model.Time;
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class ControllerAlimentacion implements Initializable {

	private ControllerMenu cm;
//	private	App app;

	@FXML
	private ComboBox<String> cbtipo;
	private ObservableList<String> olTipo = FXCollections.observableArrayList("Lacteo", "Azucares", "Harinas",
			"Proteinas", "Carbohidratos", "Liquido", "Vegetales", "Granos");

	@FXML
	private ComboBox<String> cbtipoAlimentacion;
	@FXML
	private ComboBox<String> cbtipoAlimentacionBusqueda;

	private ObservableList<String> olTipoAlimentacion = FXCollections.observableArrayList("Desayuno", "Almuerzo",
			"Comida");

	@FXML
	private TextField fNombre;
	@FXML
	private TextField fCalorias;

	@FXML
	private CheckBox cbFavorito;
	@FXML
	private CheckBox cbSaludable;

	@FXML
	private DatePicker dpDia;

	private ArrayList<Elemento> elementos;

	public ControllerAlimentacion(ControllerMenu cm) {
		this.cm = cm;
//		app = cm.getApp();
		elementos = new ArrayList<Elemento>();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbtipo.setItems(olTipo);
		cbtipoAlimentacion.setItems(olTipoAlimentacion);
		cbtipoAlimentacionBusqueda.setItems(olTipoAlimentacion);
	}

	public void regresar(MouseEvent event) throws IOException {
		Pane pane = cm.getMainPane();
		FXMLLoader fl = new FXMLLoader(getClass().getResource("menu.fxml"));
		fl.setController(cm);
		Parent p = fl.load();
		pane.getChildren().clear();
		pane.getChildren().add(p);
	}

	public void finalizarAgregarComida() {
		App app = cm.getApp();
		try {
			if (cbtipoAlimentacion.getValue() == null) {
				throw new EmptyException();
			}
			if (elementos.size() == 0) {
				throw new NoElementosException();
			}
			String alimentacion = cbtipoAlimentacion.getValue();
			if (alimentacion.equalsIgnoreCase("Desayuno")) {
				Desayuno d = new Desayuno(elementos, Time.getDay());
				app.agregarDesayuno(d);
			}else if (alimentacion.equalsIgnoreCase("Almuerzo")) {
				Almuerzo a = new Almuerzo(elementos, Time.getDay());
				app.agregarAlmuerzo(a);
			}else if (alimentacion.equalsIgnoreCase("Comida")) {
				Comida c = new Comida(elementos, Time.getDay());
				app.agregarComida(c);
			}else {
				throw new EmptyException();
			}
			cbtipoAlimentacion.setValue(null);
			vaciarElementos();
			dpDia.setValue(null);
		} catch (EmptyException e) {
			aviso1();
		} catch (NoElementosException e) {
			aviso2();
		}
	}	

	public void agregarAElementos() {
		try {
			if (fNombre.getLength() == 0 || fCalorias.getLength() == 0 || cbtipo.getValue() == null) {
				throw new EmptyException();
			}
			elementos.add(new Elemento(fNombre.getText(), cbSaludable.isSelected(),
					Double.parseDouble(fCalorias.getText()), cbtipo.getValue(), cbFavorito.isSelected()));
			vaciarElementos();
		} catch (EmptyException e) {
			aviso1();
		}
	}

	private void vaciarElementos() {
		fNombre.setText("");
		fCalorias.setText("");
		cbtipo.setValue(null);
		cbFavorito.setSelected(false);
		cbSaludable.setSelected(false);
	}
	
	private void vaciarBuscar() {
		cbtipoAlimentacionBusqueda.setValue(null);
		dpDia.setValue(null);
	}

	private void aviso1() {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Espacio vacio");
		a.setContentText("ha dejado un espacio en Blanco");
		a.showAndWait();
	}
	private void aviso2() {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("No existen elementos");
		a.setContentText("no ha agregado ningun elemento a la comida");
		a.showAndWait();
	}
}
