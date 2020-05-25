package model;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Liquido implements Serializable {

    private double mililitros;
    private String fecha, hora;

    public Liquido(double mililitros, String fecha, String hora) {
        this.mililitros = mililitros;
        this.fecha = fecha;
        this.hora = hora;
    }

    public double getMililitros() {
        return mililitros;
    }

    public void setMililitros(double mililitros) {
        this.mililitros = mililitros;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
