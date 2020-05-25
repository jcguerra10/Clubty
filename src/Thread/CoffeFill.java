package Thread;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author diegoa.torres
 */
public class CoffeFill implements Runnable {

 
    Canvas canvas;
    GraphicsContext gc;
    AnchorPane root;
    Image fondo;
    Image vaso;
    Image f;    

    public CoffeFill(Canvas canvas, GraphicsContext gc, Image fondo, Image vaso) {
        this.canvas = canvas;
        this.gc = gc;
        this.fondo = fondo;
        this.vaso = vaso;
        
    }
    
    

    @Override
    public void run() {
        
        double dir =- 1;
        boolean parar = false;
        double x;

        for ( x = 0; !parar; x+=dir) {

            try {
                //ImageView iv = new ImageView(vaso);
                //gc.drawImage(vaso, 73, 100, 190, 174);
                //gc.drawImage(vaso, iv.getLayoutX(), iv.getLayoutY());
                
                
                gc.drawImage(fondo, 90, 180, 126, x);              
                Thread.sleep(10);
                if(x>1)dir=-1;System.out.println(x);
                if(x<80)dir=+1; System.out.println(x);
                if(x==70)parar=true; System.out.println(parar);
              //  if(x==-70)parar = true;
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("OUT");
    } 
    
}
