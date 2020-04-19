package model;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Alimento {

	public static final int LACTEOS = 1;
	public static final int AZUCARES = 2;
	public static final int HARINAS = 3;
	public static final int PROTEINAS = 4;

	private double calorias;
	private int tipo;
	private boolean favorito;

    public Alimento(double calorias, int tipo, boolean favorito) {
        this.calorias = calorias;
        this.tipo = tipo;
        this.favorito = favorito;
    }
	
        
	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
	
}
