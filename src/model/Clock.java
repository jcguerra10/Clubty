package model;

/**
 *
 * @author diegoa.torres
 */
public class Clock {

    public int hour, minute, second, mili;

    public Clock(int minute, int second, int mili, int hour) {
        this.minute = minute;
        this.second = second;
        this.mili = mili;
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMili() {
        return mili;
    }

    public void setMili(int mili) {
        this.mili = mili;
    }  

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
    
    
}

