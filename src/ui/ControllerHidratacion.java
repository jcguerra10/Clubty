package ui;

import Thread.CoffeFill;
import Thread.WaterFill;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
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
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class ControllerHidratacion implements Initializable {

	private ControllerMenu cm;

	@FXML
	public ComboBox<String> cb;
	public Canvas canvas;
	public ImageView iv;

	ObservableList<String> ol = FXCollections.observableArrayList("Agua", "Cafe");

	public ControllerHidratacion(ControllerMenu cm) {
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

		if (res.equals("Agua")) {
			try {
				Pane pane = cm.getMainPane();
				FXMLLoader fl = new FXMLLoader(getClass().getResource("agua.fxml"));
				fl.setController(this);
				Parent p = fl.load();
				pane.getChildren().clear();
				pane.getChildren().add(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (res.equals("Cafe")) {
			try {
				Pane pane = cm.getMainPane();
				FXMLLoader fl = new FXMLLoader(getClass().getResource("cafe.fxml"));
				fl.setController(this);
				Parent p = fl.load();
				pane.getChildren().clear();
				pane.getChildren().add(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

		}
	}

	public void addCoffee(ActionEvent event) {

		Image fondo = new Image("img/silueta-de-forma-circular.png");
		Image Vaso = new Image("img/taza-de-cafe.png");
		GraphicsContext gc = canvas.getGraphicsContext2D();
		CoffeFill gf = new CoffeFill(canvas, gc, fondo, Vaso);
		Thread t = new Thread(gf);
		t.start();

	}

	public void addGlass(ActionEvent event) {

		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image glass = iv.getImage();
		Image fill = new Image("img/fill.png");
		Image fondo = new Image("/img/fondo.png");
		WaterFill wf = new WaterFill(canvas, gc, fondo, glass, fill);
		wf.start();

	}

}
