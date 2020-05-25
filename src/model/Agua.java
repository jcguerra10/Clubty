package model;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Agua extends Liquido implements Comparable<Agua>, Serializable {

	private Agua derecha;
	private Agua izquierda;

	public Agua(int noVasos, String fecha, String hora) {
		super(noVasos, fecha, hora);
	}

	public Agua getDerecha() {
		return derecha;
	}

	public void setDerecha(Agua derecha) {
		this.derecha = derecha;
	}

	public Agua getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(Agua izquierda) {
		this.izquierda = izquierda;
	}

	@Override
	public int compareTo(Agua o) {
		int i = 0;
		if (noVasos < o.getNoVasos()) {
			i = 1;
		} else {
			i = -1;
		}
		return i;
	}

	public void insertar(Agua c) {

		if (compareTo(c) > 0) {

			if (izquierda == null) {

				izquierda = c;
			} else {

				izquierda.insertar(c);
			}
		} else {

			if (derecha == null) {

				derecha = c;
			} else {

				derecha.insertar(c);
			}
		}
	}

	public boolean esHoja() {

		return izquierda == null && derecha == null;
	}

	public Agua darMenor() {
		return (izquierda == null) ? this : izquierda.darMenor();
	}

	public Agua deleteAgua(int numVaso) {

		if (esHoja()) {

			return null;
		}
		if (numVaso == noVasos) {

			if (izquierda == null) {

				return derecha;
			}
			if (derecha == null) {

				return izquierda;
			}
			Agua sucesor = derecha.darMenor();
			derecha = derecha.deleteAgua(sucesor.getNoVasos());
			sucesor.izquierda = izquierda;
			sucesor.derecha = derecha;
			return sucesor;
		} else if (noVasos > numVaso) {

			izquierda = izquierda.deleteAgua(numVaso);
		} else
			derecha = derecha.deleteAgua(numVaso);
		return this;

	}

	public double contarAgua() {
		double tot = 0;
		if (getIzquierda() != null) {
			getIzquierda().contarAgua();
		}
		tot += getMililitros();
		if (getDerecha() != null) {
			getDerecha().contarAgua();
		}
		return tot;
	}

	@Override
	public String toString() {
		return "Agua [noVasos: " + noVasos + ", "+ fecha + ", " + hora + "]";
	}

}
