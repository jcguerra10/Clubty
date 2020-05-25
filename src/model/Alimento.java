package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Alimento implements Serializable {

	protected ArrayList<Elemento> elementos;
	protected double caloriasTotales;
	protected String dia;

	public Alimento(ArrayList<Elemento> elementos, String dia) {
		super();
		this.elementos = elementos;
		this.caloriasTotales = contarCalorias();
		this.dia = dia;
	}

	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	public void setElementos(ArrayList<Elemento> elementos) {
		this.elementos = elementos;
	}

	public double getCaloriasTotales() {
		return caloriasTotales;
	}

	public void setCaloriasTotales(double caloriasTotales) {
		this.caloriasTotales = caloriasTotales;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
	
	protected double contarCalorias() {
		double cal = 0;
		for (int i = 0; i < elementos.size(); i++) {
			cal += elementos.get(i).getCalorias();
		}
		return cal;
	}

}
