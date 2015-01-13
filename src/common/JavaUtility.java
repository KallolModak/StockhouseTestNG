/*
 * This is Java Utility, contains all common Java Functions.
 */

package common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaUtility {

	/*
	 * Function to get unique Name
	 */
	public static String unique(String input) {
		return input + Calendar.getInstance().getTimeInMillis();
	}

	/*
	 * Function to get Current Date
	 */
	public static String getCurrentDate() {
		String[] parts;
		String str_curDate;
		Calendar cal = Calendar.getInstance();
		Date date_currentDate = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"MM/dd/yyyy  hh:mm:ss");
		str_curDate = formatter.format(date_currentDate);
		parts = str_curDate.split(" ");
		str_curDate = parts[0].trim();
		return str_curDate;
	}//END public static String getCurrentDate()

	/*
	 * Function to get End Date for Verification
	 */
	public static String getEndDateForValidation() {
		String[] parts;
		String str_endDate;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date date_endDate = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"MM/dd/yyyy  hh:mm:ss");
		String date = formatter.format(date_endDate);
		parts = date.split(" ");
		str_endDate = parts[0].trim();
		return str_endDate;
	}//END public getEndDateForValidation()

	/*
	 * Function to get End Date After 30 days from Current month
	 */
	public static String getEndDate() {
		String[] parts;
		String str_endDate;
		Calendar cal = Calendar.getInstance();
		/*cal.add(Calendar.DAY_OF_MONTH, 30);*/
		cal.add(Calendar.MONTH,1);
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date date_endDate = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"MM/dd/yyyy  hh:mm:ss");
		str_endDate = formatter.format(date_endDate);
		parts = str_endDate.split(" ");
		str_endDate = parts[0].trim();
		return str_endDate;
	}//END public static String getEndDate()

	/*
	 * Function to get current time after five minitue
	 */
	public static String getCurrentTimeAfterFiveMinute() {
		String[] parts;
		String curTimeAfterFiveMin;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 5);
		Date date_curTimeAfterFiveMin = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy  HH:mm");
		curTimeAfterFiveMin = formatter.format(date_curTimeAfterFiveMin);
		parts = curTimeAfterFiveMin.split(" ");
		curTimeAfterFiveMin = parts[2].trim();
		return curTimeAfterFiveMin;
	}//END static String getCurrentTimeAfterFiveMinute()

	/*
	 * Function to get current time after three hour
	 */
	public static String getCurrentTimeAfterThreeHour() {
		String[] parts;
		String curTimeAfterFiveMin;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, 3);
		Date date_curTimeAfterFiveMin = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy  HH:mm");
		curTimeAfterFiveMin = formatter.format(date_curTimeAfterFiveMin);
		parts = curTimeAfterFiveMin.split(" ");
		curTimeAfterFiveMin = parts[2].trim();
		return curTimeAfterFiveMin;
	}//END public static String getCurrentTimeAfterThreeHour

	
	/*
	 * Function to get week day number
	 */
	public static int getWeekDayNumber() {
		Calendar cal = Calendar.getInstance();
		Date tommrrow = cal.getTime();
		return tommrrow.getDay() + 1;
	}//END public static int getWeekDayNumber()

	/*
	 * Function to get current day from current date
	 */
	public static String getCurrentDayFromCurrentDate() {
		String[] parts;
		String str_curDayFrmDate;
		Calendar cal = Calendar.getInstance();
		Date date_curDayFrmDate = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"M/d/yyyy  hh:mm:ss");
		str_curDayFrmDate = formatter.format(date_curDayFrmDate);
		parts = str_curDayFrmDate.split("/");
		str_curDayFrmDate = parts[1].trim();
		System.out.println();
		return str_curDayFrmDate;
	}//END  public static String getCurrentDayFromCurrentDate()

	/*
	 * Function to get before current month number
	 */
	public static int getBeforeCurrentMonthNumber() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		return month;
	}//END public static int getBeforeCurrentMonthNumber()

	/*
	 * Function to get current month number
	 */

	public static int getCurrentMonthNumber() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println(month);
		return month;
	}//END public static int getCurrentMonthNumber()

	/*
	 * Function to get time for Verification
	 */
	public static String getTimeForValidationCheck() {
		String[] parts;
		String curTime;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -15);
		Date date = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"MM/dd/yyyy  HH:mm:ss");
		curTime = formatter.format(date);
		parts = curTime.split(" ");
		curTime = parts[2].trim();
		return curTime;
	}//END public static String getTimeForValidationCheck()

	/*
	 * Function to get current time after 10Minitue for Verification
	 */
	public static String getCurrentTimeAfterTenMinitue() {
		String[] parts;
		String curTime;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 10);
		Date tommrrow = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"MM/dd/yyyy  HH:mm:ss");
		String date = formatter.format(tommrrow);
		parts = date.split(" ");
		curTime = parts[2].trim();
		return curTime;
	}//END public static String getCurrentTimeAfterTenMinitue()
	
	
	public static String getTimeForSuite(){
	return	new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar
					.getInstance().getTime());
	}
	
	

}//End JavaUtility

