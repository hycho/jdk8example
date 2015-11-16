package com.pipi.study.jdk8.chapter12;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TimeSetupMain {

	public static void main(String[] args) {
		testConvLocalDate();
	}
	
/**
 * LocalDate의 데이터를 바꾼다. 모든 메소드는 복사본을 리턴한다.
 */
public static void testConvLocalDate() {
	LocalDate date1 = LocalDate.of(2015, 11, 16);
	LocalDate date2 = date1.withYear(2016);
	LocalDate date3 = date1.withDayOfMonth(25);
	LocalDate date4 = date1.with(ChronoField.MONTH_OF_YEAR, 9);
	LocalDate date5 = date1.plusWeeks(1);
	LocalDate date6 = date1.minusYears(2);
	LocalDate date7 = date1.plus(10, ChronoUnit.MONTHS);
	
	System.out.println(date1);
	System.out.println(date2);
	System.out.println(date3);
	System.out.println(date4);
	System.out.println(date5);
	System.out.println(date6);
	System.out.println(date7);
}

}
