package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Almuerzo extends Alimento implements Serializable {

	private Almuerzo siguiente;
	private Almuerzo anterior;

	public Almuerzo(ArrayList<Elemento> elementos, String dia) {
		super(elementos, dia);
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
	
	@Override
	public String toString() {
		String s = "";
		s = "Almuerzo [caloriasTotales: " + caloriasTotales + ", dia: " + dia + "]" +"\n \n"
				+ "Elementos "+ "\n";
		for (int i = 0; i < elementos.size(); i++) {
			s += elementos.get(i) +"\n";
		}
		return s;
		
	}
}
