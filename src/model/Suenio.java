package model;

import java.io.Serializable;

import exceptions.EqualsException;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Suenio implements Comparable<Suenio>, Serializable{

    private double rate;
    private int hora, min;
    private Suenio derecha;
    private Suenio izquierda;
    private String noDia;

    public Suenio(double rate, int hora, int min, String noDia) {
        
        this.rate = rate;
        this.hora = hora;
        this.min = min;
        this.noDia = noDia;
        this.derecha=null;
        this.izquierda=null;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public Suenio getDerecha() {
        return derecha;
    }

    public void setDerecha(Suenio derecha) {
        this.derecha = derecha;
    }

    public Suenio getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Suenio izquierda) {
        this.izquierda = izquierda;
    }

    public String getNoDia() {
        return noDia;
    }

    public void setNoDia(String noDia) {
        this.noDia = noDia;
    }

    @Override
    public int compareTo(Suenio arg0) {
        return this.getNoDia().compareToIgnoreCase(arg0.getNoDia());
    }
    
    public void insertar(Suenio nuevo) throws EqualsException{


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
        
    public Suenio BuscarSuenio(String dia) {

        if (noDia.compareToIgnoreCase(dia) == 0) {

                return this;
        } else if (noDia.compareToIgnoreCase(dia) > 0) {

                return (izquierda == null) ? null : izquierda.BuscarSuenio(dia);
        } else {

                return (derecha == null) ? null : derecha.BuscarSuenio(dia);
        }
    }

	@Override
	public String toString() {
		return "Suenio [rate: " + rate + ", Tiempo: " + hora + ":" + min + ", Dia: " + noDia + "]";
	}
       
}
