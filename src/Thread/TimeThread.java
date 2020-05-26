package Thread;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Clock;

import javafx.scene.control.TextField;


/**
 *
 * @author diegoa.torres
 */
public class TimeThread implements  Runnable{

    Clock r;
    boolean stop, fin;
    TextField tf;
    

    public TimeThread(TextField tf) {
        
        r = new Clock(1, 0, 0, 0);
        
        stop = false;
        fin = false;
        this.tf = tf;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public boolean isStop() {
        return stop;
    }

    public boolean isFin() {
        return fin;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }

    public Clock getR() {
        return r;
    }



    @Override
    public void run() {
        int count = 0;
        while (!fin) {
  
            r.mili += 1;

            if (r.mili == 1000) {

                r.second += 1;
                r.mili = 0;
                tf.setText("       "+r.hour+ ":" +r.minute + ":" + r.second);

            }

            if (r.second == 60) {

                r.minute += 1;
                r.second = 0;
                tf.setText("       "+r.hour+ ":" +r.minute + ":" + r.second);

            }

            if (r.minute == 60) {

                r.hour += 1;
                r.minute = 0;
                tf.setText("       "+r.hour+ ":" +r.minute + ":" + r.second);
            }
            
            while (stop) {
                
                
                System.out.println("has parado: " + count + " Segundos");
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TimeThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                Thread.sleep(1);

            } catch (InterruptedException e) {
            }
        } 
        
    }
}