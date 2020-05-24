package model;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Cafe extends Liquido implements Comparable<Cafe>{

    private Cafe derecha;
    private Cafe izquierda;
    private String noVaso;

    public Cafe(String noVaso, double mililitros, String fecha, String hora) {
        super(mililitros, fecha, hora);
        this.noVaso = noVaso;
    }

    public Cafe getDerecha() {
        return derecha;
    }

    public void setDerecha(Cafe derecha) {
        this.derecha = derecha;
    }

    public Cafe getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Cafe izquierda) {
        this.izquierda = izquierda;
    }

    public String getNoVaso() {
        return noVaso;
    }

    public void setNoVaso(String NoVaso) {
        this.noVaso = NoVaso;
    }
    
    public  void insertar(Cafe c){
        
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

    @Override
    public int compareTo(Cafe o) {
        
        return this.noVaso.compareTo(noVaso);
    }
    
    public boolean esHoja(){
        
        return izquierda == null && derecha == null;
    }
    
    public Cafe darMenor(){
        return (izquierda == null) ? this : izquierda.darMenor();
    }
    
    public Cafe deleteCafe(String numVaso){
        
        if (esHoja()) {
            
            return null;
            
        }if (numVaso.compareToIgnoreCase(noVaso) == 0) {
            
            if (izquierda == null) {
            
                return derecha;
                
            }if (derecha == null) {
                
                return izquierda;
            }
            
            Cafe sucesor = derecha.darMenor();
            derecha = derecha.deleteCafe(sucesor.getNoVaso());
            sucesor.izquierda =izquierda;
            sucesor.derecha = derecha;
            
            return sucesor;
            
        }else if (noVaso.compareToIgnoreCase(numVaso)>0) {
            
            izquierda = izquierda.deleteCafe(numVaso);
            
        }else            
            derecha = derecha.deleteCafe(numVaso);
        
        return this;
        
    }
    
    
}
