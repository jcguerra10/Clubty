package model;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Cafe extends Liquido implements Comparable<Cafe>, Serializable {

	private Cafe derecha;
	private Cafe izquierda;

	public Cafe(int noVasos, String fecha, String hora) {
		super(noVasos, fecha, hora);
	}

	public Cafe getDerecha() {
		return derecha;
	}

	public void setDerecha(Cafe derecha) {
		this.derecha = derecha;
	}

	public Cafe getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(Cafe izquierda) {
		this.izquierda = izquierda;
	}

	public void insertar(Cafe c) {

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

	@Override
	public int compareTo(Cafe o) {
		int i = 0;
		if (noVasos < o.getNoVasos()) {
			i = 1;
		} else {
			i = -1;
		}
		return i;
	}

	public boolean esHoja() {

		return izquierda == null && derecha == null;
	}

	public Cafe darMenor() {
		return (izquierda == null) ? this : izquierda.darMenor();
	}

	public Cafe deleteCafe(int numVaso) {

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

			Cafe sucesor = derecha.darMenor();
			derecha = derecha.deleteCafe(sucesor.getNoVasos());
			sucesor.izquierda = izquierda;
			sucesor.derecha = derecha;

			return sucesor;

		} else if (noVasos > numVaso) {

			izquierda = izquierda.deleteCafe(numVaso);

		} else
			derecha = derecha.deleteCafe(numVaso);

		return this;

	}
	@Override
	public String toString() {
		return "Cafe [noVasos: " + noVasos + ", "+ fecha + ", " + hora + "]";
	}
	

}
