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
	private double colesterol;
	private double vitaminaA;
	private double vitaminaC;
	private double calcio;
	private double hierro;
	private double sodio;
	private double carbohidrato;
	private double azucar;
	private double proteina;
	private double porciones;
	private boolean favorito;
	private boolean omitir;
	private double grasasSaturadas;
	private double fibra;

	public Alimento(double calorias, int tipo, double colesterol, double vitaminaA, double vitaminaC, double calcio,
			double hierro, double sodio, double carbohidrato, double azucar, double proteina, double porciones,
			boolean favorito, boolean omitir, double grasasSaturadas, double fibra) {

		this.calorias = calorias;
		this.tipo = tipo;
		this.colesterol = colesterol;
		this.vitaminaA = vitaminaA;
		this.vitaminaC = vitaminaC;
		this.calcio = calcio;
		this.hierro = hierro;
		this.sodio = sodio;
		this.carbohidrato = carbohidrato;
		this.azucar = azucar;
		this.proteina = proteina;
		this.porciones = porciones;
		this.favorito = favorito;
		this.omitir = omitir;
		this.grasasSaturadas = grasasSaturadas;
		this.fibra = fibra;
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

	public double getColesterol() {
		return colesterol;
	}

	public void setColesterol(double colesterol) {
		this.colesterol = colesterol;
	}

	public double getVitaminaA() {
		return vitaminaA;
	}

	public void setVitaminaA(double vitaminaA) {
		this.vitaminaA = vitaminaA;
	}

	public double getVitaminaC() {
		return vitaminaC;
	}

	public void setVitaminaC(double vitaminaC) {
		this.vitaminaC = vitaminaC;
	}

	public double getCalcio() {
		return calcio;
	}

	public void setCalcio(double calcio) {
		this.calcio = calcio;
	}

	public double getHierro() {
		return hierro;
	}

	public void setHierro(double hierro) {
		this.hierro = hierro;
	}

	public double getSodio() {
		return sodio;
	}

	public void setSodio(double sodio) {
		this.sodio = sodio;
	}

	public double getCarbohidrato() {
		return carbohidrato;
	}

	public void setCarbohidrato(double carbohidrato) {
		this.carbohidrato = carbohidrato;
	}

	public double getAzucar() {
		return azucar;
	}

	public void setAzucar(double azucar) {
		this.azucar = azucar;
	}

	public double getProteina() {
		return proteina;
	}

	public void setProteina(double proteina) {
		this.proteina = proteina;
	}

	public double getPorciones() {
		return porciones;
	}

	public void setPorciones(double porciones) {
		this.porciones = porciones;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public boolean isOmitir() {
		return omitir;
	}

	public void setOmitir(boolean omitir) {
		this.omitir = omitir;
	}

	public double getGrasasSaturadas() {
		return grasasSaturadas;
	}

	public void setGrasasSaturadas(double grasasSaturadas) {
		this.grasasSaturadas = grasasSaturadas;
	}

	public double getFibra() {
		return fibra;
	}

	public void setFibra(double fibra) {
		this.fibra = fibra;
	}
	
	
}
