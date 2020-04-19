package model;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Agua extends Liquido implements Comparable<Agua>{

    private Agua derecha;
    private Agua izquierda;
    private String noVaso;

    public Agua(String noVaso, double mililitros, String fecha, String hora) {
        super(mililitros, fecha, hora);
        this.noVaso = noVaso;
    }

    public Agua getDerecha() {
        return derecha;
    }

    public void setDerecha(Agua derecha) {
        this.derecha = derecha;
    }

    public Agua getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Agua izquierda) {
        this.izquierda = izquierda;
    }

    public String getNoVaso() {
        return noVaso;
    }

    public void setNoVaso(String noVaso) {
        this.noVaso = noVaso;
    }

    @Override
    public int compareTo(Agua o) {
        return this.noVaso.compareTo(noVaso);
    }
    
    
    public  void insertar(Agua c){
        
        if (compareTo(c) > 0) {
            
            if (izquierda == null) {
                
                izquierda = c; 
            }else{
                
                izquierda.insertar(c);
            }
        }else{
            
            if (derecha == null) {
                
                derecha = c;
            }else{
                
                derecha.insertar(c);
            }
        }
    }    
    
    
}
