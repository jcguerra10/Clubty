package model;

import exceptions.EqualsException;
import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Ejercicio extends Salud implements Comparable<Ejercicio>, Serializable{

    private String target, tipoEjercicio;
    private boolean  favorito;
    private Ejercicio derecha;
    private Ejercicio izquierda;
    public  String NoDia;

    public Ejercicio(String target, String tipoEjercicio, boolean favorito, double rate, int dia, int month, int year, int horas, int minutos) {
        super(rate, dia, month, year, horas, minutos);
        NoDia = dia+"/"+month+"/"+year;
        this.target = target;
        this.tipoEjercicio = tipoEjercicio;
        this.favorito = favorito;
        this.derecha = null;
        this.izquierda = null;
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
    public int compareTo(Ejercicio arg0) {
            return this.NoDia.compareToIgnoreCase(arg0.NoDia);
    }

    public void insertar(Ejercicio nuevo) throws EqualsException{


        if (compareTo(nuevo) > 0) {

            if (izquierda == null) {

                izquierda = nuevo;
            } else {

                izquierda.insertar(nuevo);
            }
        } else if(compareTo(nuevo) < 0){

            if (derecha == null) {

                derecha = nuevo;
            } else {

                derecha.insertar(nuevo);
            }
        }else{
            
            throw new EqualsException("No se puede registrar sueños de un mismo dia");
        }
    }
    
    public Ejercicio BuscarEjercicio(String dia) {

        if (NoDia.compareToIgnoreCase(dia) == 0) {

                return this;
        } else if (NoDia.compareToIgnoreCase(dia) > 0) {

                return (izquierda == null) ? null : izquierda.BuscarEjercicio(dia);
        } else {

                return (derecha == null) ? null : derecha.BuscarEjercicio(dia);
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
		re += "Ejercicio [target: " + target + ", tipoEjercicio: " + tipoEjercicio
				+ ", favorito: " + favorito + " " + super.toString() +" ]";
		return re;
	}
    
    
   
}
