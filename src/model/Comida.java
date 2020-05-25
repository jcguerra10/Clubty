package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Comida extends Alimento implements Serializable {

	private Comida siguiente;
	private Comida anterior;

	public Comida(ArrayList<Elemento> elementos, String dia) {
		super(elementos, dia);
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

	@Override
	public String toString() {
		String s = "";
		s = "Comida [caloriasTotales: " + caloriasTotales + ", dia: " + dia + "]" + "\n \n" + "Elementos " + "\n";
		for (int i = 0; i < elementos.size(); i++) {
			s += elementos.get(i) + "\n";
		}
		return s;

	}
}
