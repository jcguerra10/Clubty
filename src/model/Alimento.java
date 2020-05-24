package model;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Alimento {

	private double calorias;
	private String tipo;
	private boolean favorito;

    public Alimento(double calorias, String tipo, boolean favorito) {
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
	
}
