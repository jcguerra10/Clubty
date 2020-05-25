package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.App;
import model.Time;
import model.Usuario;

public class ControllerMenu implements Initializable {
	
	private ControllerAlimentacion contAlimentacion;
	private ControllerBienestar contBienestar;
	private ControllerHidratacion contHidratacion;
	private ControllerUsuario contUsuario;

	private Time time;

	@FXML
	private Stage window;

	@FXML
	private Label nom;
	@FXML
	private Label ape;
	@FXML
	private Label eda;

	@FXML
	private Pane mainPane;

	private App app;

	public ControllerMenu(App app, Stage s) {
		contAlimentacion = new ControllerAlimentacion(this);
		contBienestar = new ControllerBienestar(this);
		contHidratacion = new ControllerHidratacion(this);
		contUsuario = new ControllerUsuario(this);
		this.app = app;
		window = s;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setLabels();
		window.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				//save();
				System.out.println("Closing the window!");
			}

//			private void save() {
//				try {
//					File f = new File(PATH);
//					if (f.exists() == false) {
//						f.createNewFile();
//					}
//					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
//					oos.writeObject(app);
//					System.out.println("Helo");
//					oos.close();
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
		});
	}

	private void setLabels() {
		String[] s = app.getAllUsuario();		
		if (s != null) {
			nom.setText(s[0]);
			ape.setText(s[1]);
			eda.setText(s[6]);
		}
	}

	public Pane getMainPane() {
		return mainPane;
	}

	public App getApp() {
		return app;
	}

	public void alimentacion() {
		try {
			FXMLLoader fl = new FXMLLoader(getClass().getResource("alimentacion.fxml"));
			fl.setController(contAlimentacion);
			Parent p = fl.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(p);
		} catch (IOException e) {
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
			e.printStackTrace();
		}
	}

	public void usuario() {
		try {
			FXMLLoader fl = new FXMLLoader(getClass().getResource("usuario.fxml"));
			fl.setController(contUsuario);
			Parent p = fl.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
