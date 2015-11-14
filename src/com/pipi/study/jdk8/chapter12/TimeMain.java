package com.pipi.study.jdk8.chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class TimeMain {

	public static void main(String[] args) {
//		testLocalDate();
//		testLocalDateNow();
//		testLocalTime();
		testParseWithDateTime();
	}
	
	public static void testLocalDateTime() {
		LocalDate date = LocalDate.parse("2015-11-15");
		LocalTime time = LocalTime.parse("01:28:32");
		
		LocalDateTime dt1 = LocalDateTime.of(2015, Month.NOVEMBER, 15, 1, 20, 30);
		LocalDateTime dt2 = LocalDateTime.of(date, time);
		LocalDateTime dt3 = date.atTime(20, 30, 11);
		LocalDateTime dt4 = date.atTime(time);
		LocalDateTime dt5 = time.atDate(date);
		
		LocalDate date1 = dt1.toLocalDate();
		LocalTime time1 = dt1.toLocalTime();
	}
	
	public static void testParseWithDateTime() {
		LocalDate date = LocalDate.parse("2015-11-15");
		LocalTime time = LocalTime.parse("01:28:32");
		
		showDate(date);
		showTime(time);
	}
	
	public static void testLocalTime() {
		LocalTime time = LocalTime.of(1,2,30); //1시 2분 30초
		showTime(time);
	}
	
	public static void testLocalDateNow() {
		LocalDate today = LocalDate.now();
		showDateWithTempField(today);
	}
	
	public static void testLocalDate() {
		LocalDate date = LocalDate.of(2015, 11, 15);	//2015-11-18
		showDate(date);
	}
	
	public static void showTime(LocalTime time) {
		int hour = time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();
		
		System.out.println("hour = " + hour);
		System.out.println("minute = " + minute);
		System.out.println("second = " + second);
	}
	
	/**
	 * ChronoField를 인자로 받는 get메소드를 통해 LocalDate를 출력해주는 메소드
	 * @param date LocalDate
	 */
	public static void showDateWithTempField(LocalDate date) {
		int year = date.get(ChronoField.YEAR);	
		int month = date.get(ChronoField.MONTH_OF_YEAR);
		int day = date.get(ChronoField.DAY_OF_MONTH);
		int dow = date.get(ChronoField.DAY_OF_WEEK);
		
		System.out.println("year = " + year); //2015
		System.out.println("month = " + month); //NOVEMBER
		System.out.println("day = " + day); //15
		System.out.println("dow = " + dow); //SUNDAY
	}
	
	/**
	 * 인자 LocalDate의 기본 getter메소드를 사용하여 날짜정보를 출력해주는 메소드
	 * @param date LocalDate
	 */
	public static void showDate(LocalDate date) {
		int year = date.getYear();	
		Month month = date.getMonth();
		int day = date.getDayOfMonth();
		DayOfWeek dow = date.getDayOfWeek();
		int len = date.lengthOfMonth();
		
		System.out.println("year = " + year); //2015
		System.out.println("month = " + month); //NOVEMBER
		System.out.println("day = " + day); //15
		System.out.println("dow = " + dow); //SUNDAY
		System.out.println("len = " + len); //30
	}

}
