package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Time implements Serializable {

	private static Calendar c;
	private static int day;
	private static int month;
	private static int year;

	public Time() {
		c = new GregorianCalendar();

		Time.day = setDay();
		Time.month = setMonth();
		Time.year = setYear();
	}

	private static int setDay() {
		return c.get(Calendar.DAY_OF_MONTH);
	}

	private static int setMonth() {
		return c.get(Calendar.MONTH);
	}

	private static int setYear() {
		return c.get(Calendar.YEAR);
	}

	private static void refresh() {
		c = new GregorianCalendar();
		day = setDay();
		month = setMonth();
		year = setYear();
	}

	public static String getDay() {
		refresh();
		String actualDay = "";
		if (month+1 >= 10) {
			actualDay = day + "/" + (month+1) + "/" + year;
		} else {
			actualDay = day + "/0" + (month+1) + "/" + year;
		}
		return actualDay;
	}

}
