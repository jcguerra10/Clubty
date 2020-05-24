package model;

import java.util.ArrayList;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Comida {

	private ArrayList<Elemento> elementos;

	private Comida siguiente;
	private Comida anterior;
	private double caloriasTotales;
	private String dia;

	public Comida(ArrayList<Elemento> elementos, String dia) {
		super();
		this.elementos = elementos;
		this.dia = dia;
	}

	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	public void setElementos(ArrayList<Elemento> elementos) {
		this.elementos = elementos;
	}

	public Comida getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Comida siguiente) {
		this.siguiente = siguiente;
	}

	public Comida getAnterior() {
		return anterior;
	}

	public void setAnterior(Comida anterior) {
		this.anterior = anterior;
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

	public Elemento BuscarElementos(String nombre) {
		Elemento encontrado = null;
		int max = elementos.size() - 1;
		int min = 0;
		int centro;
		while (min <= max && encontrado == null) {
			centro = (max + min) / 2;
			if (elementos.get(centro).getNombre().compareTo(nombre) == 0) {
				encontrado = elementos.get(centro);
			} else {
				if (elementos.get(centro).getNombre().compareTo(nombre) > 0) {
					max = centro - 1;
				} else {
					min = centro + 1;
				}
			}
		}
		return encontrado;
	}

	public double contarCalorias() {
		double cal = 0;
		return cal;
	}
}
