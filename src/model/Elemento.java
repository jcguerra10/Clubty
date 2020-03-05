package model;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Elemento extends Alimento{

	private String nombre;
	private boolean saludable;
	
	public Elemento(double calorias, int tipo, double colesterol, double vitaminaA, double vitaminaC, double calcio,
			double hierro, double sodio, double carbohidrato, double azucar, double proteina, double porciones,
			boolean favorito, boolean omitir, double grasasSaturadas, double fibra, String nombre, boolean saludable) {
		super(calorias, tipo, colesterol, vitaminaA, vitaminaC, calcio, hierro, sodio, carbohidrato, azucar, proteina,
				porciones, favorito, omitir, grasasSaturadas, fibra);
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
		return "Elemento [nombre=" + nombre + ", saludable=" + saludable + "]";
	}
	
}
