package model;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Elemento extends Alimento{

	private String nombre;
	private boolean saludable;

    public Elemento(String nombre, boolean saludable, double calorias, int tipo, boolean favorito) {
        super(calorias, tipo, favorito);
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
