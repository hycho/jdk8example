package com.pipi.study.jdk8.chapter12;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TimeMain {

	public static void main(String[] args) {
//		testLocalDate();
//		testLocalDateNow();
//		testLocalTime();
//		testParseWithDateTime();
//		testInstant();
//		testDuration();
//		testPeriod();
		testInstanceDurationAndPeriod();
	}
	
	/**
	 * Duration, Period의 인스턴스 생성과 활용
	 */
	public static void testInstanceDurationAndPeriod() {
		LocalDateTime dt1 = LocalDateTime.of(2015, Month.NOVEMBER, 15, 1, 20, 30);
		
		Duration threeMinutes = Duration.ofMinutes(3);
		Duration fourMinutes = Duration.of(4, ChronoUnit.MINUTES);
		
		LocalDateTime dt2 = dt1.plus(threeMinutes);	//2015-11-15 1:20:30에서 3분 후 시간의 복제를 리턴.
		LocalDateTime mdt2 = dt1.minus(fourMinutes); //2015-11-15 1:20:30에서 4분 전 시간의 복제를 리턴.
		System.out.println(dt2);
		System.out.println(mdt2);
		
		Period tenDays = Period.ofDays(10);
		Period twoWeeks = Period.ofWeeks(2);
		Period fourYearsSixMonthsOneDay = Period.of(4, 6, 1);
				
		LocalDateTime dt3 = dt1.plus(twoWeeks);	//2015-11-15 1:20:30에서 2주 후 더한 시간의 복제를 리턴.
		System.out.println(dt3);
	}
	
	/**
	 * Period의 활용
	 */
	public static void testPeriod() {
		LocalDate date1 = LocalDate.of(2015, 11, 13);
		LocalDate date2 = LocalDate.of(2015, 11, 16);
		
		Period p1 = Period.between(date1, date2);
		System.out.println(p1.getDays());
	}
	
	/**
	 * Duration 테스트 Duration은 두 데이터의 차이를 초, 나노초로 표시
	 */
	public static void testDuration() {
		LocalDateTime dt1 = LocalDateTime.of(2015, Month.NOVEMBER, 15, 1, 20, 30);
		LocalDateTime dt2 = LocalDateTime.of(2014, Month.NOVEMBER, 15, 1, 20, 30);
		LocalTime time1 = LocalTime.of(1,2,30);
		LocalTime time2 = LocalTime.of(1,2,50);
		Instant i1 = Instant.ofEpochSecond(2, 1_000_000_000);
		Instant i2 = Instant.ofEpochSecond(4, -1_000_000_000);
		
		Duration d1 = Duration.between(dt1, dt2);
		Duration d2 = Duration.between(time1, time2);
		Duration d3 = Duration.between(i1, i2);
		
		System.out.println(d1.getSeconds());
		System.out.println(d2.getSeconds());
		System.out.println(d3.getSeconds());
	}
	
	/**
	 * Instant 테스트 Instant는 기계를 위한 것
	 */
	public static void testInstant() {
		Instant i1 = Instant.ofEpochSecond(3);
		Instant i2 = Instant.ofEpochSecond(3, 0);
		Instant i3 = Instant.ofEpochSecond(2, 1_000_000_000);
		Instant i4 = Instant.ofEpochSecond(4, -1_000_000_000);
		
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		
		int day = Instant.now().get(ChronoField.DAY_OF_MONTH);
	}
	
	/**
	 * LocalDateTime 테스트
	 */
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
	
	/**
	 * LocalDate, LocalTime의 조합 활용.
	 */
	public static void testParseWithDateTime() {
		LocalDate date = LocalDate.parse("2015-11-15");
		LocalTime time = LocalTime.parse("01:28:32");
		
		showDate(date);
		showTime(time);
	}
	
	/**
	 * LocalTime 테스트
	 * of메소드를 통한 생성
 	 */
	public static void testLocalTime() {
		LocalTime time = LocalTime.of(1,2,30); //1시 2분 30초
		showTime(time);
	}
	
	/**
	 * LocalDate 현재 시간 테스트
	 */
	public static void testLocalDateNow() {
		LocalDate today = LocalDate.now();
		showDateWithTempField(today);
	}
	
	/**
	 * LocalDate 테스트
	 */
	public static void testLocalDate() {
		LocalDate date = LocalDate.of(2015, 11, 15);	//2015-11-18
		showDate(date);
	}
	
	/**
	 * Local Time을 화면에 표시
	 * @param time
	 */
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
