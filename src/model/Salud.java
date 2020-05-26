package model;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class Salud implements Serializable {
    
    private double rate;
    private int dia, month, year, horas, minutos;

    public Salud(double rate, int dia, int month, int year, int horas, int minutos) {
        this.rate = rate;
        this.dia = dia;
        this.month = month;
        this.year = year;
        this.horas = horas;
        this.minutos = minutos;
    }

    public double getCaloriasQuemadas() {
        return rate;
    }

    public void setCaloriasQuemadas(double rate) {
        this.rate = rate;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    @Override
    public String toString() {
        return "Salud{" + "rate=" + rate + ", dia=" + dia + ", month=" + month + ", year=" + year + ", horas=" + horas + ", minutos=" + minutos + '}';
    }
    
    
}
