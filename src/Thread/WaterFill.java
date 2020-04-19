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

    public WaterFill(Canvas canvas, GraphicsContext gc, Image fondo, Image vaso, Image fill) {
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
       
        for ( x = 1; !parar; x+=dir) {

            try {
                
                gc.drawImage(vaso, 80, 30, 170, 180);
                
                //gc.drawImage(fondo, 68, 179, 100, 100);                
                gc.drawImage(fill, 132, 200, 58, x);
                gc.drawImage(vaso, 80, 30, 170, 180);
                Thread.sleep(300);
                if(x>-10)dir=-10;
                if(x<-118)dir=+10;
                if(x==-118)parar = true;
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
    }
    
    
}
