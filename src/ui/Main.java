/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.App;

/**
 * @author JuanC.Guerra
 * @author diegoa.torres
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fl = new FXMLLoader(getClass().getResource("fondo.fxml"));
			fl.setController(new ControllerMenu(new App()));		
			Parent p = fl.load();			
			primaryStage.setScene(new Scene(p));
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
