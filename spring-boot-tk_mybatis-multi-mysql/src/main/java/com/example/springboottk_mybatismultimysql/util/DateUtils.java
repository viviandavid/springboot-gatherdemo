
/************************ CHANGE REPORT HISTORY ******************************\
** Product VERSION,UPDATED BY,UPDATE DATE                                     *
*   DESCRIPTION OF CHANGE: modify(M),add(+),del(-)                             *
*-----------------------------------------------------------------------------*
* V1.0DEMO,xiaoran27,2016-3-23
* create 注释
*-----------------------------------------------------------------------------*
* V2.0.4 2018-1-22
* M RDM#8821 检查规范修正 by maxp
\*************************** END OF CHANGE REPORT HISTORY ********************/
package com.example.springboottk_mybatismultimysql.util;


import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateUtils {
	
	// 用于DateUtil--------------------------------------------------
	public final static String START_DATE = "1";
	public final static String END_DATE = "7";

	public static final String DateFormat = "yyyy-MM-dd";
	public static final String DateAndTimeFormat = "yyyy-MM-dd HH:mm:ss";
	public static final String DateAndTimeFormat1 = "yyyy-mm-dd hh:mm:ss";
	public static final String DateFormatChina = "yyyy 年 MM 月 dd 日";	
	public static final String DateFormatChina_YYYY_MM = "yyyy 年 MM 月";
	public static final String DateFormatChina_YYYY ="yyyy 年";
	public static final String MonthFormat="MM-dd";
	public static final String DayFormat="dd";
	public static final String DateTimeNoFormat="yyyyMMddHHmmss";
	
	public static final String timeNowPattern = "yyyy-MM-dd HH:mm:ss";
	public static final String timeBeginPattern = "yyyy-MM-dd 00:00:00";
	public static final String timeEndPattern = "yyyy-MM-dd 23:59:59";
	public static final String dateAndMinusPattern = "yyyy-MM-dd";
	public static final String dateNoMinusPattern = "yyyyMMdd";
	public static final String monthAndDateNoMinusPattern = "MMdd";
	public static final String yearPattern = "yyyy";
	public static final String DateFormat_YYYY_MM ="yyyy-MM";
	public static final String DateFormat_M ="M";
	public static final String DateFormat_d ="d";
	public static final String DateFormat_M_CHINA ="M月";
	
	private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
	
	public static String getYear(){
		return new DateTime().toString(yearPattern);
	}
	
	public static String getMonthAndDateNoMinus(String time){
		return new DateTime(time).toString(monthAndDateNoMinusPattern);
	}
	
	public static String getNow(String pattern){
		return new DateTime().toString(pattern);
	}
	
	public static String getWeekBegin(int weeks, String pattern){
		return weeks == 0 ? new DateTime().dayOfWeek().withMinimumValue().toString(pattern) : new DateTime().plusWeeks(weeks).dayOfWeek().withMinimumValue().toString(pattern);
	}

	public static String getWeekEnd(int weeks, String pattern){
			return weeks == 0 ? new DateTime().dayOfWeek().withMaximumValue().toString(pattern) : new DateTime().plusWeeks(weeks).dayOfWeek().withMaximumValue().toString(pattern);
	}

	public static String getMonthBegin(int months, String pattern){
		return months == 0 ? new DateTime().dayOfMonth().withMinimumValue().toString(pattern) : new DateTime().plusMonths(months).dayOfMonth().withMinimumValue().toString(pattern);
	}

	public static String getMonthEnd(int months, String pattern){
		return months == 0 ? new DateTime().dayOfMonth().withMaximumValue().toString(pattern) : new DateTime().plusMonths(months).dayOfMonth().withMaximumValue().toString(pattern);
	}
	
	public static String getYearBegin(int years, String pattern){
		return years == 0? new DateTime().dayOfYear().withMinimumValue().toString(pattern) : new DateTime().plusYears(years).dayOfYear().withMinimumValue().toString(pattern);
	}

	public static String getYearEnd(int years, String pattern){
		return years == 0 ? new DateTime().dayOfYear().withMaximumValue().toString(pattern) : new DateTime().plusYears(years).dayOfYear().withMaximumValue().toString(pattern);
	}

	/** now methods **/
	public static String getNowDateAndMinus(){
		return getNow(dateAndMinusPattern);
	}
	public static String getNowDateNoMinus(){
		return getNow(dateNoMinusPattern);
	}
	public static String getNowTime(){
		return getNow(timeNowPattern);
	}
	
	public static String get3daysLaterTime(){
		return new DateTime().plusDays(2).toString(timeEndPattern);
	}
	
	
	/**	week methods **/
	public static String getWeekBeginDateAndMinus(int weeks){
		return getWeekBegin(weeks, dateAndMinusPattern);
	}
	public static String getWeekBeginDateNoMinus(int weeks){
		return getWeekBegin(weeks, dateNoMinusPattern);
	}
	public static String getWeekBeginTime(int weeks){
		return getWeekBegin(weeks, timeBeginPattern);
	}
	public static String getWeekEndDateAndMinus(int weeks){
		return getWeekEnd(weeks, dateAndMinusPattern);
	}
	public static String getWeekEndDateNoMinus(int weeks){
		return getWeekEnd(weeks, dateNoMinusPattern);
	}
	public static String getWeekEndTime(int weeks){
		return getWeekEnd(weeks, timeEndPattern);
	}

	/*** month methods **/
	public static String getMonthBeginDateAndMinus(int months){
		return getMonthBegin(months, dateAndMinusPattern);
	}
	public static String getMonthBeginDateNoMinus(int months){
		return getMonthBegin(months, dateNoMinusPattern);
	}
	public static String getMonthBeginTime(int months){
		return getMonthBegin(months, timeBeginPattern);
	}
	public static String getMonthEndDateAndMinus(int months){
		return getMonthEnd(months, dateAndMinusPattern);
	}
	public static String getMonthEndDateNoMinus(int months){
		return getMonthEnd(months, dateNoMinusPattern);
	}
	public static String getMonthEndTime(int months){
		return getMonthEnd(months, timeEndPattern);
	}

	/** year methods **/
	
	public static String getYearBeginDateAndMinus(int years){
		return getYearBegin(years, dateAndMinusPattern);
	}
	public static String getYearBeginDateNoMinus(int years){
		return getYearBegin(years, dateNoMinusPattern);
	}
	public static String getYearBeginTime(int years){
		return getYearBegin(years, timeBeginPattern);
	}
	public static String getYearEndDateAndMinus(int years){
		return getYearEnd(years, dateAndMinusPattern);
	}
	public static String getYearEndDateNoMinus(int years){
		return getYearEnd(years, dateNoMinusPattern);
	}
	public static String getYearEndTime(int years){
		return getYearEnd(years, timeEndPattern);
	}
	
	public static String getWeekBegin(String dateStr, String pattern){
		return new DateTime(dateStr).dayOfWeek().withMinimumValue().toString(pattern);
	}
	
	public static String getWeekEnd(String dateStr, String pattern){
		return new DateTime(dateStr).dayOfWeek().withMaximumValue().toString(pattern);
	}
	
	public static String getLastWeekBeginDate(String dateStr){
		return getWeekBegin(dateStr, dateAndMinusPattern);
	}
	
	public static String getLastWeekEndDate(String dateStr){
		return getWeekEnd(dateStr, dateAndMinusPattern);
	}
	public static String getLastWeekBeginTime(String dateStr){
		return getWeekBegin(dateStr, timeBeginPattern);
	}
	
	public static String getLastWeekEndTime(String dateStr){
		return getWeekEnd(dateStr, timeEndPattern);
	}

	public static String getLastWeekBeginDate(){
		return DateUtils.getWeekBeginDateAndMinus(-1);
	}
	public static String getLastWeekEndDate(){
		return DateUtils.getWeekEndDateAndMinus(-1);
	}
	public static String getLastWeekBeginTime(){
		
		return DateUtils.getWeekBeginTime(-1);
	}
	public static String getLastWeekEndTime(){
		return DateUtils.getWeekEndTime(-1);
	}
	
	public static String getLast30daysBeginDate(String dateStr){
		return new DateTime(dateStr).plusMonths(-1).toString(dateAndMinusPattern);
	}
	
	public static String getYesterdayDateNoMinus(){
		
		return new DateTime().plusDays(-1).toString(dateNoMinusPattern);
	}
	
	public static String getYesterdayDateAndMinus(){
		
		return new DateTime().plusDays(-1).toString(dateAndMinusPattern);
	}
	
	public static String getDateNoMinus(Date date){
		return new DateTime(date).toString(dateNoMinusPattern);
	}
	
	public static String getDateAndTime(Date date){
		return new DateTime(date).toString(timeNowPattern);
	}
	
	public static ArrayList<String> getDate(String starDate, String endDate){
		ArrayList<String> dates = new ArrayList<String>();
		String startDate = new DateTime(starDate).toString("yyyy-MM-dd");
		for(int i=0;;i++){
			String temp = new DateTime(endDate).minusDays(i).toString("yyyy-MM-dd");
			if(!dates.contains(temp)){
				dates.add(temp);
			}
			if(temp.equals(startDate)){
				break;
			}
		}
		return dates;
	}
	
	/**
	 * 根据年，月，日获取日期对象 
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @return 日期对象 
	 */
	public static Date getTheDayOfMonth(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DATE, day);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return getSqlDate(calendar.getTime());
	}
	/**
	 * 根据年，月，日，时，分，秒获取日期对象 
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @param hour 时
	 * @param minute 分
	 * @param second 秒
	 * @return 日期对象 
	 */
	public static Date getTheTimeOfMonth(int year, int month, int day, int hour, int minute, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DATE, day);
		calendar.set(Calendar.HOUR, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		return getSqlDate(calendar.getTime());
	}
	

	
	/**
	 * 将日期格式化为字符串,日期格式有参数format决定
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            日期格式
	 * @return 格式化后的字符串
	 */
	public static String formatAll(Date date, String format) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String ret = sdf.format(date);
		return ret;
	}

	/**
	 * 将日期格式化为(yyyy-MM-dd)格式的字符串
	 * 
	 * @param date
	 *            日期
	 * @return 格式化后的字符串
	 */
	public static String format(Date date) {
		if (date == null) {
			return "";
		} else {
			return formatAll(date, DateFormat);
		}
	}

	/**
	 * 将日期格式化为（yyyy-MM-dd HH:mm:ss）的字符串
	 * 
	 * @param date
	 *            日期
	 * @return 格式化后的字符串
	 */
	public static String formatDateAndTime(Date date) {
		return formatAll(date, DateAndTimeFormat);
	}

	/**
	 * 将日期类型格式化为(yyyy 年 mm 月 dd 日)的字符串
	 * 
	 * @param date
	 *            日期
	 * @return 格式化后的字符串
	 */
	public static String formatChina(Date date) {
		return formatAll(date, DateFormatChina);
	}

	/**
	 * 获取当前系统日期和时间,日期格式为（yyyy-MM-dd HH:mm:ss）
	 * 
	 * @return 当前系统日期和时间
	 */
	public static Date getSysDate() {
		Date sysDate = null;
		SimpleDateFormat a = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat b = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			sysDate = b.parse(a.format(new Date()));
		} catch (ParseException ex) {
			ex.getMessage();
		}
		return sysDate;
	}

	/**
	 * 获取指定分钟的日期
	 * @param dateTime
	 * @param minute
	 * @return
	 */
	public static Date getCollectorForMinuteRange(Date dateTime, int minute,int second,int milliSecond) {
		//Calendar cd = Calendar.getInstance();
		Calendar cd = getUTCCalendar();
		cd.setTime(dateTime);
		cd.add(Calendar.MINUTE, minute);
		cd.set(Calendar.SECOND, second);
		cd.set(Calendar.MILLISECOND, milliSecond);
		return cd.getTime();
	}

	public static Calendar getUTCCalendar(){
		Calendar calendar = Calendar.getInstance();
		int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
		int dstOffset = calendar.get(Calendar.DST_OFFSET);
		calendar.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		return calendar;
	}


	/**
	 * 将字符串的日期转换成日期对象 日期格式由参数format指定
	 *
	 * @param stringDate
	 *            字符串日期
	 * @param format
	 *            日期格式
	 * @return 日期
	 */
	public static Date formatStringToDate(String stringDate, String format) {
		if ((stringDate == null) || stringDate.trim().equals("")) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(stringDate);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return null;
	}


	/**
	 * 将字符串的日期转换成日期对象,日期格式（yyyy-MM-dd）
	 *
	 * @param stringDate
	 *            字符串日期
	 * @return 日期对象
	 */
	public static Date formateStringToDate(String stringDate) {
		return formatStringToDate(stringDate, DateFormat);
	}
	public static Date formateStringToDate(String stringDate,String format) {
		return formatStringToDate(stringDate, format);
	}

	/**
	 * 根据原日期获取相对偏移N天的时间
	 *
	 * @param dateTime
	 *            原日期
	 * @param day
	 *            (向前移正数，向后移负数)
	 * @return Date
	 */
	public static Date getDateAddDay(Date dateTime, int day) {
		Calendar cald = Calendar.getInstance();
		cald.setTime(dateTime);
		cald.add(Calendar.DATE, day);
		return cald.getTime();
	}

	/**
	 * 根据原日期获取相对偏移N月的时间
	 *
	 * @param dateTime
	 *            原日期
	 * @param month
	 *            (向前移正数，向后移负数)
	 * @return Date
	 */
	public static Date getDateAddMonth(Date dateTime, int month) {
		Calendar cald = Calendar.getInstance();
		cald.setTime(dateTime);
		cald.add(Calendar.MONTH, month);
		return cald.getTime();
	}

	/**
	 * 根据原日期获取相对偏移N小时的时间
	 *
	 * @param dateTime
	 *            原日期
	 * @param hours
	 *            (向前移正数，向后移负数)
	 * @return Date
	 */
	public static Date getDateAddHour(Date dateTime, int hours) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(dateTime);
		ca.add(Calendar.HOUR, hours);
		return ca.getTime();
	}

	/**
	 * 根据原日期获取相对偏移N分钟的时间
	 *
	 * @param dateTime
	 *            原日期
	 * @param minute
	 *            (向前移正数，向后移负数)
	 * @return Date
	 */
	public static Date getDateAddMinute(Date dateTime, int minute) {

		Calendar cd = Calendar.getInstance();

		cd.setTime(dateTime);

		cd.add(Calendar.MINUTE, minute);

		return cd.getTime();

	}

	/**
	 * 根据原日期获取相对偏移N秒的时间
	 *
	 * @param dateTime
	 *            原日期
	 * @param second
	 *            (向前移正数，向后移负数)
	 * @return Date
	 */
	public static Date getDateAddSecond(Date dateTime, int second) {

		Calendar cd = Calendar.getInstance();

		cd.setTime(dateTime);

		cd.add(Calendar.SECOND, second);

		return cd.getTime();

	}

	/**
	 * 根据原日期获取相对偏移N年的时间
	 *
	 * @param dateTime
	 *            原日期
	 * @param year
	 *            (向前移正数，向后移负数)
	 * @return Date
	 */
	public static Date getDateAddYear(Date dateTime, int year) {
		Calendar cald = Calendar.getInstance();
		cald.setTime(dateTime);
		cald.add(Calendar.YEAR, year);
		return cald.getTime();
	}

	/**
	 * 由java.util.Date到java.sql.Date的类型转换
	 *
	 * @param date
	 *            java.util.Date
	 * @return Date java.sql.Date
	 */
	public static Date getSqlDate(Date date) {
		return new Date(date.getTime());
	}

	/**
	 * 是否为闰年
	 * 
	 * @param year
	 * @return 布尔类型 true表示是闰年，false不是闰年
	 */
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	/**
	 * 获得某年某月最后一天的日期
	 * 
	 * @param year 某年
	 * @param month 某月
	 * @return Date
	 */
	public static Date getLastDayOfMonth(int year, int month) {
		int date = 0;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12){
			
				date = 31;
			}
		if (month == 4 || month == 6 || month == 9 || month == 11)
			{
			date = 30;
			}
		if (month == 2) {
		   if (isLeapYear(year))
				{
				date = 29;
				}
			else
				{
				date = 28;
				}
		
		}
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DATE, date);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获得某一日期的最后一刻 
	 * @param curDate 某日期
	 * @return Date
	 */
	public static Date clearToMillSec(Date curDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(curDate);
		calendar.set(Calendar.AM_PM, Calendar.AM);
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	} 

	/**
	 * 两日期相差的天数 ，参数是日期类型
	 * 
	 * @param date1
	 *            作为减数的日期
	 * @param date2
	 *            作为被减数的日期
	 * @return
	 */
	public static Long getOffsetDay(Date date1, Date date2) {
		return Long.valueOf((date1.getTime() - date2.getTime())
				/ (1000 * 60 * 60 * 24));
	}
	/**
	 * 两日期相差的小时数
	 * 
	 * @param date1
	 *            作为减数的日期
	 * @param date2
	 *            作为被减数的日期
	 * @return
	 */
	public static Long getOffsetHour(Date date1, Date date2) {
		return Long.valueOf((date1.getTime() - date2.getTime())
				/ (1000 * 60 * 60));
	}
	
	public static Long getOffsetMinute(Date date1,Date date2){
		return Long.valueOf((date1.getTime() - date2.getTime())
				/ (1000 * 60));
	}

	/**
	 * 两日期相差的天数,参数时字符串类型
	 * 
	 * @param date1
	 *            作为减数的日期字符
	 * @param date2
	 *            作为被减数的日期字符
	 * @return 
	 */
	public static Long getOffsetDay(String dateStr1, String dateStr2) {
		Date date1 = formateStringToDate(dateStr1);
		Date date2 = formateStringToDate(dateStr2);
		return getOffsetDay(date1, date2);
	}

	/**
	 * 获取当天的开始时间
	 * @return
	 */
	public static Date getCurrentDayBegin() {

		Calendar cd = Calendar.getInstance();
		cd.set(Calendar.HOUR_OF_DAY, 0);
		cd.set(Calendar.MINUTE, 0);
		cd.set(Calendar.SECOND, 0);
		return cd.getTime();
	}
	 

	/**
	 * 获取当天的结束时间
	 * 
	 * @return
	 */
	public static Date getCurrentDayEnd() {

		Calendar cd = Calendar.getInstance();
		cd.set(Calendar.HOUR_OF_DAY, 23);
		cd.set(Calendar.MINUTE, 59);
		cd.set(Calendar.SECOND, 59);
		return cd.getTime();
	}

	/**
	 * 判断一字符串是否为日期字串
	 * 
	 * @param str
	 * 
	 * @return boolean
	 */
	public static boolean isDateStr(String str) {

		boolean isDate = false;

		try {
			Date date = formateStringToDate(str, "yyyy-MM-dd HH:mm:ss");

			if (null == date)
			{
				date = formateStringToDate(str, "yyyy-MM-dd");
			}

			if (null != date)
			{
				isDate = true;
			}
		} catch (Exception e) {

		}
		return isDate;
	}
	
	/**
	 * 判断字符串所代表的日期是否为周末（周六、周日）
	 * @param date
	 * @return
	 */
	public static boolean isWeekend(String date) {
		int day = 0;
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date time = df.parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(time);

			day = cal.get(Calendar.DAY_OF_WEEK);

		} catch (ParseException e) {
			System.out.println("Format date error!");
			return false;
		}
		
		if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 本月第一天
	 * @return
	 */
	public static Date getFirstDayOfTheMonth(){
	   Calendar calendar = Calendar.getInstance();    
		  		calendar.add(Calendar.MONTH, 0);
		  		calendar.set(Calendar.DAY_OF_MONTH,1);
	    return calendar.getTime(); 
	}
	
	/**
	 * 本月第一天
	 * @return
	 */
	public static Date getFirstDayOfTheMonth(Date targetDate){
	   Calendar calendar = Calendar.getInstance();
	   			calendar.setTime(targetDate);
		  		calendar.add(Calendar.MONTH, 0);
		  		calendar.set(Calendar.DAY_OF_MONTH,1);
	    return calendar.getTime(); 
	}
	
	/**
	 * 本月最后一天
	 * @return
	 */
	public static Date getLastDayOfTheMonth(){
	   Calendar calendar = Calendar.getInstance();    
	   			calendar.set(Calendar.DAY_OF_MONTH, 
			    calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
	    return calendar.getTime(); 
	}
	
	/**
	 * 本月最后一天
	 * @return
	 */
	public static Date getLastDayOfTheMonth(Date targetDate){
	   Calendar calendar = Calendar.getInstance();    
	   			calendar.setTime(targetDate);
	   			calendar.set(Calendar.DAY_OF_MONTH, 
			    calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	    return calendar.getTime(); 
	}

	/**
	 * 格式化 日期
	 * @param targetDate
	 * @param targetFormat
	 * @return
	 */
	public static Date formatDate(Date targetDate , String targetFormat){
		SimpleDateFormat format = new SimpleDateFormat(targetFormat);
		return formateStringToDate(format.format(targetDate),targetFormat); 
	}
	/**
	 * 本周第一天
	 * @return
	 */
	public static Date getFirstDayOfTheWeek(){
		Calendar calendar = Calendar.getInstance();  
				 calendar = getADayOfWeek(calendar, Calendar.MONDAY);   
		  return calendar.getTime();
    }
	
	/**
	 * 上周第一天
	 * @lastPeriod 周期 1本周，-1向前推迟一周，2下周，依次类推
	 * @return
	 */
	public static Date getLastWeekOfDayForTarget(int lastPeriod,int dayOfWeek){
		Calendar calendar = Calendar.getInstance();  
				 calendar.add(Calendar.DATE, lastPeriod*7);
				 calendar = getADayOfWeek(calendar, dayOfWeek);   //Calendar.MONDAY
		  return calendar.getTime();
    }
	
	
	/**
	 * 上周第一天
	 * @lastPeriod 周期 1本周，-1向前推迟一周，2下周，依次类推
	 * @return
	 */
	public static Date getLastWeekOfDayForTarget(int lastPeriod,int dayOfWeek,Date date){
		Calendar calendar = Calendar.getInstance();  
		
		calendar.setTime(date);
				 calendar.add(Calendar.DATE, lastPeriod*7);
				 calendar = getADayOfWeek(calendar, dayOfWeek);   //Calendar.MONDAY
		  return calendar.getTime();
    }
	
	
	
	/**
	 * 本周第一天
	 * @param currentDate
	 * @return
	 */
	public static Date getFirstDayOfTheWeek(Date currentDate){
		Calendar calendar = Calendar.getInstance();  
				 calendar.setTime(currentDate);
				 calendar = getADayOfWeek(calendar, Calendar.MONDAY);   
		  return calendar.getTime();
    }
	
	/**
	 * 本周最后一天
	 * 
	 * @return
	 */
	public static Date getLastDayOfTheWeek(){
		Calendar calendar = Calendar.getInstance(); 
				 calendar = getADayOfWeek(calendar, Calendar.SUNDAY);  
		 return calendar.getTime();
    }
	/**
	 * 本周最后一天
	 * 
	 * @param currentDate
	 * @return
	 */
	public static Date getLastDayOfTheWeek(Date currentDate){
		Calendar calendar = Calendar.getInstance(); 
				 calendar.setTime(currentDate);
				 calendar = getADayOfWeek(calendar, Calendar.SUNDAY);  
		 return calendar.getTime();
    }
	
	/**
	 * 本年第一天
	 * @return
	 */
	public static Date getFirstDayOfTheYear(){
		Calendar calendar = Calendar.getInstance();  
				 calendar.set(Calendar.DAY_OF_YEAR, 1);
		return calendar.getTime();
	}
	
	/**
	 * 本年第一天
	 * @param currentDate
	 * @return
	 */
	public static Date getFirstDayOfTheYear(Date currentDate){
		Calendar calendar = Calendar.getInstance();  
				 calendar.set(Calendar.DAY_OF_YEAR, 1);
		return calendar.getTime();
	}

	/**
	 * 
	 * @return
	 */
	public static int getCountWeekOfYear(){
		 Calendar calendar = Calendar.getInstance();
		 		  calendar.setFirstDayOfWeek(Calendar.MONDAY);
		  return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	public static int getCountWeekOfYear(Date currentDate){
		 Calendar calendar = Calendar.getInstance();
		  		  calendar.setTime(currentDate);
		  		  calendar.setFirstDayOfWeek(Calendar.MONDAY);
		  return calendar.get(Calendar.WEEK_OF_YEAR);	
	}
	
	private static Calendar getADayOfWeek(Calendar day, int dayOfWeek) {  
	    int week = day.get(Calendar.DAY_OF_WEEK);  
	    if (week == dayOfWeek)  
	    {
	    	return day;  
	    }
	    int diffDay = dayOfWeek - week;  
	    if (week == Calendar.SUNDAY) {  
	        diffDay -= 7;  
	    } else if (dayOfWeek == Calendar.SUNDAY) {  
	        diffDay += 7;  
	    }  
	    day.add(Calendar.DATE, diffDay);  
	    return day;  
	} 
	
	/**
	 * 月份递推
	 * @param date
	 * @param factor 递推因子
	 * @return
	 */
	public static Date getDayOfMonth(Date date,int month){
		 Calendar calendar = Calendar.getInstance();
         calendar.setTime(date);
         calendar.add(Calendar.MONTH, -month);
         int index = calendar.get(Calendar.DAY_OF_MONTH);
         calendar.add(Calendar.DATE, (month - index));
         return calendar.getTime();
	}
	
	 
	
	/**
	 * 获取去年今日周一
	 * @param currentDate
	 * @return
	 */
	public static Date getLastWeekMonday(Date currentDate) {    
         Calendar calendar = Calendar.getInstance();    
         		  calendar.setTime(currentDate);    
         		  calendar.add(Calendar.YEAR, -1);
         		  calendar.add(Calendar.DAY_OF_MONTH, -1);    
         		  calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);    
           return calendar.getTime();    
     }
	
	/**
	 * 获取去年今日周末
	 * @param currentDate
	 * @return
	 */
	public static Date getLastWeekSunday(Date currentDate) {    
         Calendar calendar = Calendar.getInstance();    
         		  calendar.setTime(currentDate);    
         		  calendar.add(Calendar.YEAR, -1);
         		  calendar.add(Calendar.DAY_OF_MONTH, -1);    
         		  calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);    
           return getDateAddDay(DateUtils.getLastWeekMonday(currentDate),6);
     }
	
	/**
	 * 获取目标日期为第几周
	 * @param targetDate
	 * @return
	 */
	public static int getWeekOfDate(Date targetDate){
		Calendar calendar = Calendar.getInstance();  
	     calendar.setTime(targetDate);  
	     calendar.setFirstDayOfWeek(Calendar.MONDAY);  
	     return calendar.get(Calendar.WEEK_OF_MONTH);
	}
	
	/**
	 * 统计一个月份共多少周
	 * @param currentDate   
	 * @return
	 */
	public static int getCountWeek(Date currentDate){
		Calendar calendar = Calendar.getInstance(); 
				 calendar.setTime(currentDate);
				 calendar.setFirstDayOfWeek(Calendar.MONDAY);  
		return calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
	}
	 
	
	/**
	 * 判断当前月份为周几
	 * @param currentDate
	 * @return
	 */
	public static int getDayForWeek(Date currentDate){
		Calendar calendar = Calendar.getInstance(); 
		 calendar.setTime(currentDate);
		 int dayForWeek = 0;  
		 if(calendar.get(Calendar.DAY_OF_WEEK) == 1){  
			 dayForWeek = 7;  
		 }else{  
		  dayForWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;  
		 }  
		 return dayForWeek;  
	}
	
	public static Date getDayForWeek(int week){
		Calendar calendar = Calendar.getInstance();
		 calendar.setFirstDayOfWeek(Calendar.MONDAY);
		if(week == 1){
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		}else if(week == 2){
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		}else if(week == 3){
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		}else if(week == 4){
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		}else if(week == 5){
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		}else if(week == 6){
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		}else if(week == 7){
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		}
		return calendar.getTime();
	}
	
	/**
	 * 获取某月份第几周的开始日期
	 * @param currentDate
	 * @param week
	 * @return
	 */
 
	
	public static final Date convertStringToDate(String strDate) throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			logger.error("ParseException: " + pe);
		}
		return (date);
	}

	public static Calendar getCalendar(String month, int week) {

		Date newDate;
		Calendar caleNew = null;
        try {
	        newDate = convertStringToDate(month + "-01");
	        caleNew = Calendar.getInstance();
			caleNew.setTime(newDate);
			caleNew.add(Calendar.WEEK_OF_MONTH, week - 1);
        } catch (ParseException e) {
        	logger.error("ParseException: " + e);
        }
		
		return caleNew;
	}

	/**
	 * 获取month月的第week星期的第一天
	 * 
	 * @param month yyyy-MM
	 * @param week 
	 * @return
	 */
	public static Date getFirstOfWeek(String month, int week) {

		Calendar ca = Calendar.getInstance();
		try {
			GregorianCalendar calendar = (GregorianCalendar) getCalendar(month, week); 
			ca.setTime(calendar.getTime());
			ca.set(Calendar.DATE, calendar.get(Calendar.DATE) - calendar.get(Calendar.DAY_OF_WEEK) + 2);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return ca.getTime();
	}

	/**
	 * 获取month月的第week星期的最后一天
	 * 
	 * @param month yyyy-MM
	 * @param week 
	 * @return
	 */
	public static Date getLastOfWeek(String month, int week) {
		Calendar ca = Calendar.getInstance();
		try {
			GregorianCalendar calendar = (GregorianCalendar) getCalendar(month, week);
			ca.setTime(calendar.getTime());
			ca.set(Calendar.DATE, calendar.get(Calendar.DATE) + 8 - calendar.get(Calendar.DAY_OF_WEEK));
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return ca.getTime();

	}
	
	
 
	/**
	 * 获得某一日期的第一刻 
	 * @param curDate 某日期
	 * @return Date
	 */
	public static Date getNohhmmss(Date curDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(curDate);
		calendar.set(Calendar.AM_PM, Calendar.AM);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
}