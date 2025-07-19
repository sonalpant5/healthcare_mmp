package mmp_utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

	public static void main(String[] args) {
		
		//getFutureDate("MM/d/YYYY", 90);
		//getFutureDate("MM/d/YYYY", 0, "IST");
		//	getCurrentDate();

	}
	
	/*
	 * Method to get Current/Future Date (Without Timezone).
	 */
	public static String getFutureDate(String pattern, int n)
	{
		Calendar cal = Calendar.getInstance();
	//	Date todaysdate = cal.getTime();
	//	System.out.println("Todays Date -> " +todaysdate);
		
		cal.add(Calendar.DAY_OF_MONTH, n);
		Date futuredate = cal.getTime();
		//System.out.println("Future Date after " +n+ " days -> " +futuredate);
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		//String formattodaysdate = sdf.format(todaysdate);
		//System.out.println("Formatted Todays Date -> "+formattodaysdate);
		
		String formatfuturedate = sdf.format(futuredate);
		//System.out.println("Formatted Future Date after " +n+ " days -> "+formatfuturedate);
		return formatfuturedate;

	}
	
	/*
	 * Method to get Different timezone's Current/Future Date.
	 */
	public static String getFutureDate(String pattern, int n, String timezone)
	{
		Calendar cal = Calendar.getInstance();
		Date todaysDate = cal.getTime();      //fetch current date
		cal.add(Calendar.DAY_OF_MONTH, n);
		
			
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);   //create a formatter for dates
		TimeZone tmz = TimeZone.getTimeZone(timezone);			//returns a TimeZone object based on the provided ID.
		sdf.setTimeZone(tmz);									//set the timezone
		String formatdate = sdf.format(todaysDate);				//format the timezone date to the given pattern.
		
		//System.out.println(timezone+ " TimeZone Date -> " +sdf.getTimeZone());
		//System.out.println(timezone+ " Date:: "+formatdate);
		
		return formatdate;
	}
	
	public static String getCurrentDate()
	{
		Calendar cal = Calendar.getInstance();
		Date todaysdate = cal.getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
		String tdate = sdf.format(todaysdate);
		return tdate;
	}
	
}
