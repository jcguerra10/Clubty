package model;

import exceptions.EqualsException;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Concentracion extends Salud implements Comparable<Concentracion>{
        
        private String motivo;
	private String fecha;
        private Concentracion izquierda;
        private Concentracion derecha;

    public Concentracion(String motivo, String fecha,  double caloriasQuemadas, int dia, int month, int year, int horas, int minutos) {
        super(caloriasQuemadas, dia, month, year, horas, minutos);
        this.motivo = motivo;
        this.fecha = fecha;
        this.izquierda = null;
        this.derecha = null;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Concentracion getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Concentracion izquierda) {
        this.izquierda = izquierda;
    }

    public Concentracion getDerecha() {
        return derecha;
    }

    public void setDerecha(Concentracion derecha) {
        this.derecha = derecha;
    }

    

    @Override
    public int compareTo(Concentracion arg0) {
        return this.getFecha().compareToIgnoreCase(arg0.getFecha());
    }
        
    private int setMinutos(int ch, int cm, int th, int tm) {
            int total = 0;
            if (ch >= th && cm >= tm) {
                    int hora = ch - th;
                    int minuto = cm - tm;
                    total = (hora * 60) + minuto;
            } else {
                    //new EXCEPTION();
            }

            return total;
    }  
    
    public void insertar(Concentracion nuevo)throws EqualsException{
        if (compareTo(nuevo) > 0) {

            if (izquierda == null) {

                izquierda = nuevo;
            } else {

                izquierda.insertar(nuevo);
            }
        } else if(compareTo(nuevo) < 0){

            if (derecha == null) {

                derecha = nuevo;
            } else {

                derecha.insertar(nuevo);
            }
        }else{
            
            throw new EqualsException("No se puede registrar sueños de un mismo dia");
        }
    }
    
        public Concentracion BuscarConcentracion(String dia) {

        if (fecha.compareToIgnoreCase(dia) == 0) {

                return this;
        } else if (fecha.compareToIgnoreCase(dia) > 0) {

                return (izquierda == null) ? null : izquierda.BuscarConcentracion(dia);
        } else {

                return (derecha == null) ? null : derecha.BuscarConcentracion(dia);
        }
    }

}
