package model;

import java.io.Serializable;

import exceptions.EqualsException;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Personal implements Serializable {
    
    private Ejercicio raizE;
    private Suenio raizS;
    private Concentracion raizC;

    public Personal() {

            raizE = null;
            raizS = null;
            raizC = null;
    }

    public Ejercicio getRaizE() {
        return raizE;
    }

    public void setRaizE(Ejercicio raizE) {
        this.raizE = raizE;
    }

    public Suenio getRaizS() {
        return raizS;
    }

    public void setRaizS(Suenio raizS) {
        this.raizS = raizS;
    }

    public Concentracion getRaizC() {
        return raizC;
    }

    public void setRaizC(Concentracion raizC) {
        this.raizC = raizC;
    }
    
    
    
    public double caloriaQuemadas() {
        double total = 0;
        if (raizE != null) {
                total += raizE.getCaloriasQuemadas();

                total += raizE.totalCaloriasQuemadas();
        }
        return total;
    }
    
    public void AgregarEjercicio(Ejercicio e) throws EqualsException {

        if (raizE == null) {

                raizE = e;
        } else {

                raizE.insertar(e);
        }
    }
    
    public void AgregarSuenio(Suenio e) throws EqualsException {

        if (raizS == null) {

                raizS = e;
        } else {

                raizS.insertar(e);
        }
    }
    
    public void AgregarConcentracion(Concentracion e) throws EqualsException {
        if (raizC == null) {
                raizC = e;
        } else {
            raizC.insertar(e);
        }
    }  
    
    public Suenio buscarSuenio(String dia) {        
        if (raizS.getNoDia().equalsIgnoreCase(dia)) {
                return raizS;
        } else {
                return raizS.BuscarSuenio(dia);
        }
    }
        
    public Concentracion buscarConcentracion(String dia) {
        if (raizC.getFecha().equalsIgnoreCase(dia)) {
                return raizC;
        } else {
                return raizC.BuscarConcentracion(dia);
        }
    }  

    public Ejercicio BuscarEjercicios(String nom) {
        System.out.println(nom + " " + raizE.NoDia);
        if (raizE.NoDia.equalsIgnoreCase(nom)) {

                return raizE;
        } else {

                return raizE.BuscarEjercicio(nom);
        }
    }
}