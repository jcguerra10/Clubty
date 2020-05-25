/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
			App a = new App();
			fl.setController(new ControllerMenu(a, primaryStage));		
			Parent p = fl.load();
			primaryStage.setResizable(false);
			primaryStage.setScene(new Scene(p));
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	
//	private App load() {
//		App a = new App();
//		try {
//			File f = new File(ControllerMenu.PATH);
//			if (f.exists()) {
//				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
//				a = (App) ois.readObject();
//				ois.close();
//			}			
//		} catch (FileNotFoundException e) {
//
//		} catch (IOException e) {
//			
//		} catch (ClassNotFoundException e) {
//			
//		}
//		return a;
//	}


	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
