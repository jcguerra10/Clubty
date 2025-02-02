package ui;

import Thread.TimeThread;
import exceptions.EqualsException;
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
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.App;
import model.Concentracion;
import model.Ejercicio;
import model.Suenio;

public class ControllerBienestar implements Initializable {

	private ControllerMenu cm;
	App a;

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
	@FXML
	TextField cronometro;
	@FXML
	Slider sl1;
	@FXML
	Button fin1;
	@FXML
	DatePicker dp1;
	@FXML
	Button inicio;
	@FXML
	Button reset;
	@FXML
	Button save;
	@FXML
	Button inicio2;
	@FXML
	TextField motivo;
	@FXML
	TextField motivo1;
        @FXML
	CheckBox favorite;
        

	ObservableList<String> ol = FXCollections.observableArrayList("Suenio", "Concentracion", "Ejercicio");

	public ControllerBienestar(ControllerMenu cm) {
		this.cm = cm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (cb != null) {
			cb.setItems(ol);
		}

		a = new App();
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
                                fl.setController(this);
				Parent p = fl.load();
				pane.getChildren().clear();
				pane.getChildren().add(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void addSuenio(ActionEvent event) {

		if (horas.getText().equalsIgnoreCase("") || horas.getText().equalsIgnoreCase(" ")
				|| horas.getText().equalsIgnoreCase(null) && minutos.getText().equalsIgnoreCase("")
				|| minutos.getText().equalsIgnoreCase(" ") || minutos.getText().equalsIgnoreCase(null)
				|| dp.getValue() == null) {

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setTitle("Info");
			alert.setContentText("No se pueden dejar vacios los campos");
			alert.showAndWait();
		} else {

			LocalDate ld = dp.getValue();
			String dia = ld.getDayOfMonth() + "/" + ld.getMonth() + "/" + ld.getYear();
			int horaSuenio = Integer.parseInt(horas.getText());
			int minutoSuenio = Integer.parseInt(minutos.getText());
			double rate = sl.getValue();			
			Suenio s = new Suenio(rate, horaSuenio, minutoSuenio, dia);
			try {
				a.agregarSuenio(s);
                                System.out.println(s + " " + a.getPersonal().getRaizS() );
			} catch (EqualsException ex) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Error en la aplicacion: " + ex.getMessage());
				alert.showAndWait();
			}

		}
	}

	public void tellme() {
		System.out.println(favorite.isSelected()+ "");

	}

	public void addSuenioAuto(ActionEvent event) {

		TimeThread tt = new TimeThread(cronometro);
		Thread t = new Thread(tt);
		tt.setStop(false);
		t.start();
		reset.setDisable(true);
		save.setDisable(false);
		inicio.setDisable(true);
		inicio2.setDisable(true);
		fin1.setOnAction((event1) -> {
			tt.setStop(true);
			save.setDisable(false);
			reset.setDisable(false);
			inicio2.setDisable(false);
			fin1.setDisable(true);
		});

		inicio2.setOnAction((event3) -> {

			tt.setStop(false);
			inicio2.setDisable(true);
			fin1.setDisable(false);

		});

		reset.setOnAction((event2) -> {

			tt.setFin(true);
			tt.setStop(false);
			cronometro.setText("       " + 0 + ":" + 0 + ":" + 0);
			reset.setDisable(true);
			fin.setDisable(true);
			fin1.setDisable(true);
			save.setDisable(true);
			inicio.setDisable(false);
		});

		save.setOnAction((event3) -> {

			tt.setStop(false);
			fin1.setDisable(true);
			inicio.setDisable(false);
			cronometro.setText("       " + 0 + ":" + 0 + ":" + 0);
			if (sl1.getValue() == 0.0) {

				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				alert.setTitle("Confirmacion");
				alert.setContentText("La calidad de sueño esta en 0. ¿Deseas realmente confirmar?");
				alert.showAndWait();
				System.out.println();
				if (alert.getResult().getButtonData().compareTo(ButtonBar.ButtonData.OK_DONE) == 0) {

					if (tt.getR().getHour() == 0 && tt.getR().getMinute() == 0) {

						Alert alert1 = new Alert(Alert.AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setTitle("Error");
						alert.setContentText("No se puede registrar un sueño de menos de un 1 minuto. Se ha contado: "
								+ tt.getR().getHour() + "Horas, " + tt.getR().getMinute() + "Minutos, "
								+ tt.getR().getSecond() + "Segundos.");
						alert.showAndWait();
					} else {

						LocalDate ld = LocalDate.now();
						String dia = ld.getDayOfMonth() + "/" + ld.getMonth() + "/" + ld.getYear();
						Suenio s = new Suenio(sl1.getValue(), tt.getR().getHour(), tt.getR().getMinute(), dia);
						System.out.println(s);
						try {
							a.agregarSuenio(s);
						} catch (EqualsException ex) {
							Alert alert3 = new Alert(Alert.AlertType.ERROR);
							alert.setHeaderText(null);
							alert.setTitle("Error");
							alert.setContentText("Error en la aplicacion: " + ex.getMessage());
							alert.showAndWait();
						}
					}
				}
			} else if (tt.getR().getHour() == 0 && tt.getR().getMinute() == 0) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Info");
				alert.setContentText("No se puede registrar un sueño de menos de un 1 minuto. Se ha contado: "
						+ tt.getR().getHour() + "Horas, " + tt.getR().getMinute() + "Minutos, " + tt.getR().getSecond()
						+ "Segundos.");
				alert.showAndWait();
			} else {

				LocalDate ld = LocalDate.now();
				String dia = ld.getDayOfMonth() + "/" + ld.getMonth() + "/" + ld.getYear();
				Suenio s = new Suenio(sl1.getValue(), tt.getR().getHour(), tt.getR().getMinute(), dia);
				System.out.println(s);
				try {
					a.agregarSuenio(s);
				} catch (EqualsException ex) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("Error en la aplicacion: " + ex.getMessage());
					alert.showAndWait();
				}
			}
			tt.setFin(true);
		});

	}
	
	

	public void addConcentracion(ActionEvent event) {

		if (horas.getText().equalsIgnoreCase("") || horas.getText().equalsIgnoreCase(" ")
				|| horas.getText().equalsIgnoreCase(null) && minutos.getText().equalsIgnoreCase("")
				|| minutos.getText().equalsIgnoreCase(" ")
				|| minutos.getText().equalsIgnoreCase(null) && motivo.getText().equalsIgnoreCase("")
				|| motivo.getText().equalsIgnoreCase(" ") || motivo.getText().equalsIgnoreCase(null)) {

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setTitle("Info");
			alert.setContentText("No se pueden dejar vacios los campos");
			alert.showAndWait();
		} else {

			LocalDate ld = dp.getValue();
			String dia = ld.getDayOfMonth() + "/" + ld.getMonth() + "/" + ld.getYear();
			int horaConcentracion = Integer.parseInt(horas.getText());
			int minutoConcentracion = Integer.parseInt(minutos.getText());
			double rate = sl.getValue();
			int day = ld.getDayOfMonth();
			int month = ld.getMonthValue();
			int year = ld.getYear();
			String motive = motivo.getText();
			Concentracion c = new Concentracion(motive, dia, sl.getValue(), day, month, year, horaConcentracion,
					minutoConcentracion);
			try {
				a.agregarConcentracion(c);
				System.out.println(c + " " + a.getPersonal().getRaizC());

			} catch (EqualsException ex) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Error en la aplicacion: " + ex.getMessage());
				alert.showAndWait();
			}

		}

	}

	public void addConcentracionAuto(ActionEvent event) {

		TimeThread tt = new TimeThread(cronometro);
		Thread t = new Thread(tt);
		tt.setStop(false);
		t.start();
		reset.setDisable(true);
		save.setDisable(false);
		inicio.setDisable(true);
		inicio2.setDisable(true);
		fin1.setOnAction((event1) -> {
			tt.setStop(true);
			save.setDisable(false);
			reset.setDisable(false);
			inicio2.setDisable(false);
			fin1.setDisable(true);
		});

		inicio2.setOnAction((event3) -> {

			tt.setStop(false);
			inicio2.setDisable(true);
			fin1.setDisable(false);

		});

		reset.setOnAction((event2) -> {

			tt.setFin(true);
			tt.setStop(false);
			cronometro.setText("       " + 0 + ":" + 0 + ":" + 0);
			reset.setDisable(true);
			fin.setDisable(true);
			fin1.setDisable(true);
			save.setDisable(true);
			inicio.setDisable(false);
		});

		save.setOnAction((event3) -> {

			tt.setStop(false);
			fin1.setDisable(true);
			inicio.setDisable(false);
			cronometro.setText("       " + 0 + ":" + 0 + ":" + 0);
			if (sl1.getValue() == 0.0) {

				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				alert.setTitle("Confirmacion");
				alert.setContentText("La calidad de sueño esta en 0. ¿Deseas realmente confirmar?");
				alert.showAndWait();
				System.out.println();
				if (alert.getResult().getButtonData().compareTo(ButtonBar.ButtonData.OK_DONE) == 0) {

					if (tt.getR().getHour() == 0 && tt.getR().getMinute() == 0) {

						Alert alert1 = new Alert(Alert.AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setTitle("Error");
						alert.setContentText(
								"No se puede registrar una Concentracion de menos de un 1 minuto. Se ha contado: "
										+ tt.getR().getHour() + "Horas, " + tt.getR().getMinute() + "Minutos, "
										+ tt.getR().getSecond() + "Segundos.");
						alert.showAndWait();
					} else {

						LocalDate ld = LocalDate.now();
						String dia = ld.getDayOfMonth() + "/" + ld.getMonth() + "/" + ld.getYear();
						Concentracion c = new Concentracion(motivo1.getText(), dia, sl1.getValue(), ld.getDayOfMonth(),
								ld.getMonthValue(), ld.getYear(), tt.getR().getHour(), tt.getR().getMinute());

						try {
							a.agregarConcentracion(c);

						} catch (EqualsException ex) {
							Alert alert3 = new Alert(Alert.AlertType.ERROR);
							alert.setHeaderText(null);
							alert.setTitle("Error");
							alert.setContentText("Error en la aplicacion: " + ex.getMessage());
							alert.showAndWait();
						}
					}
				}
			} else if (tt.getR().getHour() == 0 && tt.getR().getMinute() == 0) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Info");
				alert.setContentText("No se puede registrar un sueño de menos de un 1 minuto. Se ha contado: "
						+ tt.getR().getHour() + "Horas, " + tt.getR().getMinute() + "Minutos, " + tt.getR().getSecond()
						+ "Segundos.");
				alert.showAndWait();
			} else {

				LocalDate ld = LocalDate.now();
				String dia = ld.getDayOfMonth() + "/" + ld.getMonth() + "/" + ld.getYear();
				Concentracion c = new Concentracion(motivo1.getText(), dia, sl1.getValue(), ld.getDayOfMonth(), ld.getMonthValue(),
						ld.getYear(), tt.getR().getHour(), tt.getR().getMinute());

				try {
					a.agregarConcentracion(c);

				} catch (EqualsException ex) {
					Alert alert3 = new Alert(Alert.AlertType.ERROR);
					alert3.setHeaderText(null);
					alert3.setTitle("Error");
					alert3.setContentText("Error en la aplicacion: " + ex.getMessage());
					alert3.showAndWait();
				}
			}
			tt.setFin(true);
		});

	}
        
        
        public void searchSuenio(ActionEvent event) {

		LocalDate ld = diaBuscar.getValue();

		if (diaBuscar.getValue() == null) {

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setTitle("Info");
			alert.setContentText("No se puede dejar el selector de fecha vacio");
			alert.showAndWait();
		} else {

                        String dia = ld.getDayOfMonth() + "/" + ld.getMonth() + "/" + ld.getYear();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Info");
                                                try {
                        alert.setContentText("Se encontro la concentracion del dia: " + dia + " Con informacion: "+a.buscarSuenio(dia));                        
                    } catch (NullPointerException e) {
                        
                            Alert alert2 = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("Error");
                            alert.setContentText("Error en la aplicacion, No se encuentra ningun dato ");
                            alert.showAndWait();
                    }
                        alert.showAndWait();
		}
	}

	public void searchConcentracion(ActionEvent event) {

		LocalDate ld = diaBuscar.getValue();

		if (diaBuscar.getValue() == null) {

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setTitle("Info");
			alert.setContentText("No se puede dejar el selector de fecha vacio");
			alert.showAndWait();
		} else {

			String dia = ld.getDayOfMonth() + "/" + ld.getMonth() + "/" + ld.getYear();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Info");
                        try {
                        alert.setContentText("Se encontro la concentracion del dia: " + dia + " Con informacion: "+a.buscarConcentracion(dia));                        
                    } catch (NullPointerException e) {
                        
                            Alert alert2 = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("Error");
                            alert.setContentText("Error en la aplicacion, No se encuentra ningun dato ");
                            alert.showAndWait();
                    }
                        alert.showAndWait();

		}
	}
        
            public void addEjercise(ActionEvent event) {

		if (horas.getText().equalsIgnoreCase("") || horas.getText().equalsIgnoreCase(" ")
				|| horas.getText().equalsIgnoreCase(null) && minutos.getText().equalsIgnoreCase("")
				|| minutos.getText().equalsIgnoreCase(" ")
				|| minutos.getText().equalsIgnoreCase(null) && motivo.getText().equalsIgnoreCase("")
				|| motivo.getText().equalsIgnoreCase(" ") || motivo.getText().equalsIgnoreCase(null)
                                || motivo1.getText().equalsIgnoreCase(" ") || motivo1.getText().equalsIgnoreCase(null)) {

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setTitle("Info");
			alert.setContentText("No se pueden dejar vacios los campos");
			alert.showAndWait();
		} else {


                    LocalDate ld = dp.getValue();
			String dia = ld.getDayOfMonth() + "/" + ld.getMonth() + "/" + ld.getYear();
			int horaConcentracion = Integer.parseInt(horas.getText());
			int minutoConcentracion = Integer.parseInt(minutos.getText());
			double rate = sl.getValue();
			int day = ld.getDayOfMonth();
			int month = ld.getMonthValue();
			int year = ld.getYear();
                        Ejercicio e = new Ejercicio(motivo1.getText(), motivo.getText(), favorite.isSelected(), rate, day, month, year, horaConcentracion, minutoConcentracion);
			try {
				a.agregarEjercicio(e);
				System.out.println(e + " " + a.getPersonal().getRaizE());

			} catch (EqualsException ex) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Error en la aplicacion: " + ex.getMessage());
				alert.showAndWait();
			}

		}

	}
            
            
        	public void searchEjercicio(ActionEvent event) {

		LocalDate ld = diaBuscar.getValue();
                 

		if (diaBuscar.getValue() == null) {

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setTitle("Info");
			alert.setContentText("No se puede dejar el selector de fecha vacio");
			alert.showAndWait();
		} else {

			String dia = ld.getDayOfMonth() + "/" + ld.getMonthValue()+ "/" + ld.getYear();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Info");
                        try {
                        alert.setContentText("Se encontro la concentracion del dia: " + dia + " Con informacion: "+a.buscarEjercicio(dia));                        
                    } catch (NullPointerException e) {
                        
                            Alert alert2 = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("Error");
                            alert.setContentText("Error en la aplicacion, No se encuentra ningun dato ");
                            alert.showAndWait();
                    }
                        alert.showAndWait();

		}
	}
            
        

}
