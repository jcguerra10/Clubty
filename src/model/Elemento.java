package model;

import java.util.ArrayList;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Elemento extends Alimento {

	public static ArrayList<String> tiposArr = new ArrayList<String>();

	private String nombre;
	private boolean saludable;
	private String tipo;

	public Elemento(String nombre, boolean saludable, double calorias, String tipo, boolean favorito) {
		super(calorias, tipo, favorito);
		this.nombre = nombre;
		this.saludable = saludable;
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

	@Override
	public String toString() {
		return "\t nombre: " + nombre + ", saludable: " + (saludable == true ? "Saludable" : "No Saludable");
	}

}
