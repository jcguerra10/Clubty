package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Desayuno extends Alimento {	

	private Desayuno siguiente;
	private Desayuno anterior;			

	public Desayuno(ArrayList<Elemento> elementos, String dia) {
		super(elementos, dia);	
	}

	public Desayuno getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Desayuno siguiente) {
		this.siguiente = siguiente;
	}

	public Desayuno getAnterior() {
		return anterior;
	}

	public void setAnterior(Desayuno anterior) {
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
		s = "Desayuno [caloriasTotales: " + caloriasTotales + ", dia: " + dia + "]" +"\n \n"
				+ "Elementos "+ "\n";
		for (int i = 0; i < elementos.size(); i++) {
			s += elementos.get(i) +"\n";
		}
		return s;
		
	}	

}
