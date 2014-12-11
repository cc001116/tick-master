package cn.flower.tick.client.util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

  public final static String PATTERN_FULL = "yyyy-MM-dd HH:mm:ss";
  public final static String PATTERN_DAY = "yyyy-MM-dd"; 
  
  private DateUtils() {}

  public static Date getCurrentDate() {
    return new Date();
   /* String date = "2014-05-30 15:27:56";
    return parseDate(date, "yyyy-MM-dd HH:mm:ss");*/
  }

  /**
   * Allocates a Date object and initializes it to represent the specified number of milliseconds
   * since the standard base time known as "the epoch", namely January 1, 1970, 00:00:00 GMT.
   * 
   * @param date the milliseconds since January 1, 1970, 00:00:00 GMT.
   * @return
   */
  public static Date parseDate(long date) {
    return new Date(date);
  }

  /**
   * Parses text from the beginning of the given string to produce a date. The method may not use
   * the entire text of the given string.
   * 
   * @param date A String whose beginning should be parsed
   * @param pattern the pattern describing the date and time format
   * @return
   */
  public static Date parseDate(String date, String pattern) {
    DateFormat format = new SimpleDateFormat(pattern);
    try {
      return format.parse(date);
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }
  
  public static Date parseDateWithFullPattern(String date) {
	  return parseDate(date, PATTERN_FULL);
  }

  public static String format(Date date, String pattern) {
    DateFormat format = new SimpleDateFormat(pattern);
    return format.format(date);
  }
  
  public static String format(String date, String srcPattern, String targetPattern) {
	  return format(parseDate(date, srcPattern), targetPattern);
  }

  public static Date addYears(final Date date, final int amount) {
    return add(date, Calendar.YEAR, amount);
  }

  public static Date addMonths(final Date date, final int amount) {
    return add(date, Calendar.MONTH, amount);
  }

  public static Date addWeeks(final Date date, final int amount) {
    return add(date, Calendar.WEEK_OF_YEAR, amount);
  }

  public static Date addDays(final Date date, final int amount) {
    return add(date, Calendar.DAY_OF_MONTH, amount);
  }

  public static Date addHours(final Date date, final int amount) {
    return add(date, Calendar.HOUR_OF_DAY, amount);
  }

  public static Date addMinutes(final Date date, final int amount) {
    return add(date, Calendar.MINUTE, amount);
  }

  public static Date addSeconds(final Date date, final int amount) {
    return add(date, Calendar.SECOND, amount);
  }

  /**
   * Adds to a date returning a new object. The original {@code Date} is unchanged.
   * 
   * @param date the date, not null
   * @param calendarField the calendar field to add to
   * @param amount the amount to add, may be negative
   * @return the new {@code Date} with the amount added
   * @throws IllegalArgumentException if the date is null
   */
  private static Date add(final Date date, final int calendarField, final int amount) {
    if (date == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    final Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(calendarField, amount);
    return c.getTime();
  }



  /**
   * 两个时间之差(day)
   * 
   * @param date1
   * @param date2
   * @return
   */
  public static int dayDif(Date date1, Date date2) {
    Date dateA = parseDate(format(date1, "yyyy-MM-dd"), "yyyy-MM-dd");
    Date dateB = parseDate(format(date2, "yyyy-MM-dd"), "yyyy-MM-dd");
    Long currentDate = dateA.getTime();
    Long sourceDate = dateB.getTime();
    int day = (int) (currentDate - sourceDate) / (86400 * 1000);
    return day;
  }

  /**
   * 两个时间相差小时数（4舍5入）
   * @param date1
   * @param date2
   * @return
   */
  public static int hourDif(Date date1, Date date2) {
	  /*Date dateA = parseDate(format(date1, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:");
	  Date dateB = parseDate(format(date2, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm");*/
	  Long currentDate = date1.getTime();
	  Long sourceDate = date2.getTime();
	  double hour = (currentDate - sourceDate) / (3600 * 1000.0);
	  int h = (int)Math.round(hour);
	  return h;
  }
  
  public static int minuteDif(Date date1, Date date2) {
	  Long currentDate = date1.getTime();
	  Long sourceDate = date2.getTime();
	  double minute = (currentDate - sourceDate) / (60 * 1000.0);
	  int m = (int)Math.round(minute);
	  return m;
  }
  /*
   * public static int hourOfDay(Date date) { String tempDate = format(date, "hh"); int day =
   * Integer.parseInt(tempDate); return day; }
   */

  public static void main(String[] args) {
    Date date1 = parseDate("2014-05-09 09:35:53", "yyyy-MM-dd HH:mm:ss");
    Date date2 = getCurrentDate();
    // getTop(date1, 5000);
    System.out.println(dayDif(date1, date2));


    Integer a = new Integer(1);
    Integer b = new Integer(1);

    System.out.println(a.intValue() == b.intValue());
  }

}
