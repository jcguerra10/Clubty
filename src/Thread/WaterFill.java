package Thread;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author diegoa.torres
 */
public class WaterFill extends Thread{

    private Canvas canvas;
    private GraphicsContext gc;
    private AnchorPane root;
    private Image fondo;
    private Image vaso;
    private Image fill;

    public WaterFill(Canvas canvas, GraphicsContext gc, AnchorPane root, Image fondo, Image vaso, Image fill) {
        this.canvas = canvas;
        this.gc = gc;
        this.root = root;
        this.fondo = fondo;
        this.vaso = vaso;
        this.fill = fill;
    }

    @Override
    public void run() {
        
        double dir =- 10;
        boolean parar = false;
        double x;
       
        for ( x = 10; !parar; x+=dir) {

            try {
                gc.drawImage(fill, 110, 100, 100, 100);
                gc.drawImage(fondo, 30, 30, 100, 100);                
                gc.drawImage(vaso, 131, 189, 58, x);
                Thread.sleep(300);
                if(x>-10)dir=-10;
                if(x<-70)dir=+10;
                if(x==-70)parar = true;
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
    }
    
    
}
