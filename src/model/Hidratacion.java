package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Hidratacion implements Serializable {

    private Agua primerAgua;
    private Cafe primerCafe;

    public Hidratacion() {
        
        primerAgua = null;
        primerCafe = null;
    }

    public Agua getPrimerAgua() {
        return primerAgua;
    }

    public void setPrimerAgua(Agua primerAgua) {
        this.primerAgua = primerAgua;
    }

    public Cafe getPrimerCafe() {
        return primerCafe;
    }

    public void setPrimerCafe(Cafe primerCafe) {
        this.primerCafe = primerCafe;
    }
    
    public boolean esVacioC() {
            return primerCafe == null;
    }

    public boolean esVacioA() {
            return primerAgua == null;
    }    

    public void agregarCafe(Cafe newCafe) {
            
        if (esVacioC() == true) {

                primerCafe = newCafe;

        } else {

                primerCafe.insertar(newCafe);

        }

    }
    
    public void agregarAgua(Agua newAgua){
        
        if (esVacioA() == true) {
            
            primerAgua = newAgua;
        }else{
            
            primerAgua.insertar(newAgua);
        }
    }

	public ArrayList<Agua> todosAguaDia(String day) {
		return null;
	}
	
	public ArrayList<Cafe> todosCafeDia(String day) {
		return null;
	}
}
