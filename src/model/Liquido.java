package model;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Liquido implements Serializable {

	protected int noVasos;
	protected double mililitros;
	protected String fecha, hora;

	public Liquido(int noVasos, String fecha, String hora) {
		super();
		this.noVasos = noVasos;
		this.fecha = fecha;
		this.hora = hora;
	}

	protected int getNoVasos() {
		return noVasos;
	}

	protected void setNoVasos(int noVasos) {
		this.noVasos = noVasos;
	}

	protected double getMililitros() {
		return mililitros;
	}

	protected void setMililitros(double mililitros) {
		this.mililitros = mililitros;
	}

	protected String getFecha() {
		return fecha;
	}

	protected void setFecha(String fecha) {
		this.fecha = fecha;
	}

	protected String getHora() {
		return hora;
	}

	protected void setHora(String hora) {
		this.hora = hora;
	}

}
