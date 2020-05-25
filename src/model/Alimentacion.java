 package model;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Alimentacion implements Serializable {
	private Desayuno primerDesayuno;
	private Almuerzo primerAlmuerzo;
	private Comida primerComida;

	public Alimentacion() {
		
	}

	public Desayuno ultimoDesayuno() {
		Desayuno ret = primerDesayuno;
		if (ret != null) {
			while (ret.getSiguiente() != null) {
				ret = ret.getSiguiente();
			}
		}
		return ret;
	}

	public void anadirDesayuno(Desayuno d) {
		Desayuno ult = ultimoDesayuno();
		if (ult != null) {
			ult.setSiguiente(d);
			d.setAnterior(ult);
		} else {
			primerDesayuno = d;
		}
	}

	public Desayuno buscarDesayuno(String dia) {
		Desayuno encontrado = null;
		Desayuno temp = primerDesayuno;
		if (temp != null) {
			while (temp != null && !(temp.getDia().equals(dia))) {
				temp = temp.getSiguiente();
			}
			if (temp.getDia().equals(dia)) {
				encontrado = temp;
			}
		}
		return encontrado;
	}

	public Almuerzo ultimoAlmuerzo() {
		Almuerzo ret = primerAlmuerzo;
		if (ret != null) {
			while (ret.getSiguiente() != null) {
				ret = ret.getSiguiente();
			}
		}
		return ret;
	}

	public void anadirAlmuerzo(Almuerzo a) {
		Almuerzo ult = ultimoAlmuerzo();
		if (ult != null) {
			ult.setSiguiente(a);
			a.setAnterior(ult);
		} else {
			primerAlmuerzo = a;
		}
	}
	
	public Almuerzo buscarAlmuerzo(String dia) {
		Almuerzo encontrado = null;
		Almuerzo temp = primerAlmuerzo;
		if (temp != null) {
			while (temp != null && !(temp.getDia().equals(dia))) {
				temp = temp.getSiguiente();
			}
			if (temp.getDia().equals(dia)) {
				encontrado = temp;
			}
		}
		return encontrado;
	}

	public Comida ultimoComida() {
		Comida ret = primerComida;
		if (ret != null) {
			while (ret.getSiguiente() != null) {
				ret = ret.getSiguiente();
			}
		}
		return ret;
	}

	public void anadirComida(Comida c) {
		Comida ult = ultimoComida();
		if (ult != null) {
			ult.setSiguiente(c);
			c.setAnterior(ult);
		} else {
			primerComida = c;
		}
	}

	public Comida buscarComida(String dia) {
		Comida encontrado = null;
		Comida temp = primerComida;
		if (temp != null) {
			while (temp != null && !(temp.getDia().equals(dia))) {
				temp = temp.getSiguiente();
			}
			if (temp.getDia().equals(dia)) {
				encontrado = temp;
			}
		}
		return encontrado;
	}
	
}
