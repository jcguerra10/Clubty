package model;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Personal {
    
    private Ejercicio raizE;
    private Suenio raizS;
    private Concentracion raizC;

    public Personal() {

            raizE = null;
            raizS = null;
            raizC = null;
    }
    
    public Ejercicio BuscarEjercicios(String nom) {

        if (raizE.getTipoEjercicio().equalsIgnoreCase(nom)) {

                return raizE;
        } else {

                return raizE.BuscarEjercicio(nom);
        }
    }
    
    public double caloriaQuemadas() {
        double total = 0;
        if (raizE != null) {
                total += raizE.getCaloriasQuemadas();

                total += raizE.totalCaloriasQuemadas();
        }
        return total;
    }
    
    public void AgregarEjercicio(Ejercicio e) {

        if (raizE == null) {

                raizE = e;
        } else {

                raizE.insertar(e);
        }
    }
    
    public Suenio buscarSuenio(String dia) {
        if (raizS.getNoDia().equalsIgnoreCase(dia)) {
                return raizS;
        } else {
                return raizS.BuscarSuenio(dia);
        }
    }
    
    public void AgregarSuenio(Suenio e) {

        if (raizS == null) {

                raizS = e;
        } else {

                raizS.insertar(e);
        }
    }
    
    public void AgregarConcentracion(Concentracion e) {
        if (raizC == null) {
                raizC = e;
        } else {
            raizC.insertar(e);
        }
    }    
        
    public Concentracion buscarConcentracion(String dia) {
        if (raizS.getNoDia().equalsIgnoreCase(dia)) {
                return raizC;
        } else {
                return raizC.buscarConcentracion(dia);
        }
    }    
}
