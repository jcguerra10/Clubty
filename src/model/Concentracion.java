package model;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Concentracion extends Salud implements Comparable<Concentracion>, Serializable{
        
        private String motivo;
	private int horaComienzo, horaTermina, minutoComienzo, minutoTermina;
	private int minutos;
	private String fecha;
	private String noDia;
        private Concentracion izquierda;
        private Concentracion derecha;

    public Concentracion(String motivo, int horaComienzo, int horaTermina, int minutoComienzo, int minutoTermina, String fecha, String noDia, double caloriasQuemadas, int dia, int month, int year, int horas, int minutos) {
        super(caloriasQuemadas, dia, month, year, horas, minutos);
        this.motivo = motivo;
        this.horaComienzo = horaComienzo;
        this.horaTermina = horaTermina;
        this.minutoComienzo = minutoComienzo;
        this.minutoTermina = minutoTermina;
        this.fecha = fecha;
        this.noDia = noDia;
        minutos = setMinutos(horaComienzo, minutoComienzo, horaTermina, minutoTermina);
        this.izquierda = null;
        this.derecha = null;
    }

        

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getHoraComienzo() {
        return horaComienzo;
    }

    public void setHoraComienzo(int horaComienzo) {
        this.horaComienzo = horaComienzo;
    }

    public int getHoraTermina() {
        return horaTermina;
    }

    public void setHoraTermina(int horaTermina) {
        this.horaTermina = horaTermina;
    }

    public int getMinutoComienzo() {
        return minutoComienzo;
    }

    public void setMinutoComienzo(int minutoComienzo) {
        this.minutoComienzo = minutoComienzo;
    }

    public int getMinutoTermina() {
        return minutoTermina;
    }

    public void setMinutoTermina(int minutoTermina) {
        this.minutoTermina = minutoTermina;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNoDia() {
        return noDia;
    }

    public void setNoDia(String noDia) {
        this.noDia = noDia;
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
    public int compareTo(Concentracion o) {
            if (this.getMinutos() > o.getMinutos()) {
                    return 1;
            } else {
                    return 2;
            }
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
    
    public void insertar(Concentracion nuevo) {
            if (compareTo(nuevo) > 0) {

                    if (izquierda == null) {

                            izquierda = nuevo;
                    } else {

                            izquierda.insertar(nuevo);
                    }
            } else {

                    if (derecha == null) {

                            derecha = nuevo;
                    } else {

                            derecha.insertar(nuevo);
                    }
            }
    }
    
    public void mostrarPorFecha(String fecha) {
        if (izquierda != null) {
                izquierda.mostrarPorFecha(fecha);
        }
        if (this.getFecha().compareToIgnoreCase(fecha) == 0) {
                System.out.println(this);
        }
        if (derecha != null) {
                derecha.mostrarPorFecha(fecha);
        }
    }
    
    public Concentracion buscarPorFecha(String fecha) {
        if (getFecha().compareToIgnoreCase(fecha) == 0) {
                return this;
        } else if (getFecha().compareToIgnoreCase(fecha) > 0) {
                return (izquierda == null) ? null : izquierda.buscarPorFecha(fecha);
        } else {
                return (derecha == null) ? null : derecha.buscarPorFecha(fecha);
        }
    }
    
    public Concentracion buscarConcentracion(String dia) {
        if (noDia.compareToIgnoreCase(dia) == 0) {

                return this;
        } else if (noDia.compareToIgnoreCase(dia) > 0) {

                return (izquierda == null) ? null : izquierda.buscarConcentracion(dia);
        } else {

                return (derecha == null) ? null : derecha.buscarConcentracion(dia);
        }
    }

}
