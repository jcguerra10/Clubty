package model;

import java.util.ArrayList;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Almuerzo {

	private ArrayList<Elemento> elementos;

	private Almuerzo siguiente;
	private Almuerzo anterior;
	private double caloriasTotales;
	private String dia;

	public Almuerzo(ArrayList<Elemento> elementos, Almuerzo siguiente, Almuerzo anterior, double caloriasTotales,
			String dia) {
		super();
		this.elementos = elementos;
		this.siguiente = siguiente;
		this.anterior = anterior;
		this.caloriasTotales = caloriasTotales;
		this.dia = dia;
	}

	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	public void setElementos(ArrayList<Elemento> elementos) {
		this.elementos = elementos;
	}

	public Almuerzo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Almuerzo siguiente) {
		this.siguiente = siguiente;
	}

	public Almuerzo getAnterior() {
		return anterior;
	}

	public void setAnterior(Almuerzo anterior) {
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

	public void anadirElemento(Elemento e) {
		elementos.add(e);
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
