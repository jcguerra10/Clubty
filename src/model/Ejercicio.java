package model;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Ejercicio extends Salud implements Comparable<Ejercicio>, Serializable{

    private double distancia;
    private String target, tipoEjercicio;
    private boolean  favorito;
    private Ejercicio derecha;
    private Ejercicio izquierda;

    public Ejercicio(double distancia, String target, String tipoEjercicio, boolean favorito, Ejercicio anterior, Ejercicio siguiente, double caloriasQuemadas, int dia, int month, int year, int horas, int minutos) {
        super(caloriasQuemadas, dia, month, year, horas, minutos);
        this.distancia = distancia;
        this.target = target;
        this.tipoEjercicio = tipoEjercicio;
        this.favorito = favorito;
        this.derecha = null;
        this.izquierda = null;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTipoEjercicio() {
        return tipoEjercicio;
    }

    public void setTipoEjercicio(String tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public Ejercicio getDerecha() {
        return derecha;
    }

    public void setDerecha(Ejercicio derecha) {
        this.derecha = derecha;
    }

    public Ejercicio getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Ejercicio izquierda) {
        this.izquierda = izquierda;
    }

        @Override
    public int compareTo(Ejercicio o) {
        return this.getTipoEjercicio().compareToIgnoreCase(o.getTipoEjercicio());
    }

    public  void insertar(Ejercicio nuevo){
        
        if (compareTo(nuevo) > 0) {
            
            if (izquierda == null) {
                
                izquierda = nuevo; 
            }else{
                
                izquierda.insertar(nuevo);
            }
        }else{
            
            if (derecha == null) {
                
                derecha = nuevo;
            }else{
                
                derecha.insertar(nuevo);
            }
        }
    }
    
    public Ejercicio BuscarEjercicio(String nombreEjercicio){
        
        if (tipoEjercicio.compareToIgnoreCase(nombreEjercicio)==0) {
            
            return this;
        }else if (tipoEjercicio.compareToIgnoreCase(nombreEjercicio)>0) {
            
            return (izquierda == null) ? null : izquierda.BuscarEjercicio(nombreEjercicio);
        }else{
            
            return (derecha == null) ? null : derecha.BuscarEjercicio(nombreEjercicio);
        }
    }
    
    public double totalCaloriasQuemadas() {
        double total = 0;
        if (getIzquierda() != null) {
                getIzquierda().totalCaloriasQuemadas();
        }
                total += this.getCaloriasQuemadas();
        if (getDerecha() != null) {
                getDerecha().totalCaloriasQuemadas();
        }
        return total;
    }

	@Override
	public String toString() {
		String re = "";
		re += "Ejercicio [distancia: " + distancia + ", target: " + target + ", tipoEjercicio: " + tipoEjercicio
				+ ", favorito: " + (favorito == true ? "Favorito":"No Favorito") + " ]";
		return re;
	}
    
    
   
}
