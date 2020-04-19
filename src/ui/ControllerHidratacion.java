package ui;

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
import javafx.stage.Stage;
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class ControllerHidratacion implements Initializable {

	@FXML
	public ComboBox<String> cb;
        public Canvas canvas;
        public ImageView iv;

	ObservableList<String> ol = FXCollections.observableArrayList("Agua", "Cafe");

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

		if (res.equals("Agua")) {
			try {
				(((Node) event.getSource())).getScene().getWindow().hide();
				FXMLLoader fl = new FXMLLoader(getClass().getResource("agua.fxml"));
				Parent p = fl.load();
				Stage st = new Stage();
				st.setScene(new Scene(p));				
				st.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (res.equals("Cafe")) {
			try {
				(((Node) event.getSource())).getScene().getWindow().hide();
				FXMLLoader fl = new FXMLLoader(getClass().getResource("cafe.fxml"));
				Parent p = fl.load();
				Stage st = new Stage();
				st.setScene(new Scene(p));				
				st.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			
		}
	}
        
        public void addGlass(ActionEvent event){
            
            GraphicsContext gc = canvas.getGraphicsContext2D();
            Image glass = iv.getImage();
            Image fill = new Image("img/fill.png");
            Image fondo = new Image("/img/fondo.png");
            WaterFill wf = new WaterFill(canvas, gc, fondo, glass, fill);
            wf.start();
                    
            
        }

}
