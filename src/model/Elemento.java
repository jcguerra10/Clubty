package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Elemento implements Serializable {

	public static ArrayList<String> tiposArr = new ArrayList<String>();

	private String nombre;
	private boolean saludable;
	private double calorias;
	private String tipo;
	private boolean favorito;

	public Elemento(String nombre, boolean saludable, double calorias, String tipo, boolean favorito) {
		super();
		this.nombre = nombre;
		this.saludable = saludable;
		this.calorias = calorias;
		this.tipo = tipo;
		this.favorito = favorito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isSaludable() {
		return saludable;
	}

	public void setSaludable(boolean saludable) {
		this.saludable = saludable;
	}

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	@Override
	public String toString() {
		return "\t nombre: " + nombre + ", saludable: " + (saludable == true ? "Saludable" : "No Saludable");
	}

}
