package mmp_utilities;

import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {

		int random3Digit = generateRandomNum(3);  // Example: 3-digit number
		System.out.println("Random 3-digit number: " + random3Digit);
		String rndstring =  generateRandomString(5);
		System.out.println(rndstring);
	}
	public static void generateRandomChar()
	{
		Random rand = new Random();
		for (int i =0;i<10;i++)
		{
			int randInt  = rand.nextInt(200);
			System.out.println(randInt);
		}//
		int lBound = 10,uBound=99;
		int randInt2Digit = lBound+rand.nextInt(uBound-lBound+1);//lBound+(uBound-lBound+1);
		System.out.println("Random 2 digit number"+ randInt2Digit);

		int j = 65;

		char ch = (char) j;
		System.out.println(ch);

		//upper case 
		lBound = 65;
		uBound=90;
		char upperch = (char) (lBound+rand.nextInt(uBound-lBound+1));
		System.out.println("Random uupercase character::" + upperch);

		//upper case 
		lBound = 97;
		uBound=122;
		char lowerch = (char) (lBound+rand.nextInt(uBound-lBound+1));
		System.out.println("Random uupercase character::" + lowerch);


		String randomEmail = "AUTIITWF"+upperch+lowerch+randInt2Digit;	
		System.out.println(randomEmail);
	}

	//		Calendar cal = Calendar.getInstance();
	//		long phNo = cal.getTimeInMillis()%1000000000;
	//		System.out.println("Time in milliseconds"+cal.getTimeInMillis()%1000000000);
	//		System.out.println("outcome" + 20%5);




	// Generate Random Numbers.
	public static int generateRandomNum(int num) {
		if (num <= 0) {
			throw new IllegalArgumentException("Number of digits must be positive.");
		}
		Random rand = new Random();

		// Smallest N-digit number: 10^(digits - 1)
		int min = (int) Math.pow(10, num - 1);

		// Largest N-digit number: 10^digits - 1
		int max = (int) Math.pow(10, num) - 1;

		// Random number between min and max
		return rand.nextInt((max - min) + 1) + min;
	}

	// Generate Random Integers

	public static String generateRandomString(int n) {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String randomString ="";
		StringBuilder strb = new StringBuilder(n);
		Random rand = new Random();
		int min = 0;
		int max = str.length() - 1;

		for (int i = 0; i < n; i++) {
			int randnum = min + rand.nextInt(max - min + 1);
			char ch = str.charAt(randnum);
			randomString = strb.append(ch + "").toString();
			
		}
		
		return randomString;
	}

}
