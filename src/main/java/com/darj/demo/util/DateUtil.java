package com.darj.demo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	public final static String DATE_FORMAT = "yyyy-MM-dd";

	public final static String DATEE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public DateUtil() {
	}

	public static boolean isDateBeforeOrEquals(LocalDate initDate, LocalDate endDate) {
		if (initDate == null)
			return true;

		if (endDate == null)
			return true;

		return !endDate.isBefore(endDate);
	}

	public static String parseDateToString(LocalDate date, String format) {
		if (date == null) {
			return null;
		}
		return date.format(DateTimeFormatter.ofPattern(format));
	}
}
