package mmp_utilities;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 
Letters + digits	random(8)
Letters only	random(8, true, false)
Digits only	random(6, false, true)
Only symbols	random(5, 33, 48, false, false)
Specific chars	random(5, "ABC123")
 */
public class RandomDataUtils {

//   public static void main(String[] args) {
//
//	  String name = randomAlphabets(8);
//	  System.out.println("Name: "+name);
//	
//	  String num = randomNumbers(10);
//	  System.out.println("Phone No.: "+num);
//	  
//	  String alphanum = randomAlphaNumeric(4);
//	  System.out.println(alphanum);
//	  
//	  String remail = randomEmail();
//	  System.out.println("Email id: "+remail);
//	  
//	  String pwd = randomPassword();
//	  System.out.println("Password: "+pwd);
//		
//}
    
	public static String randomAlphabets(int n)
	{
	@SuppressWarnings("deprecation")
	String randomAlpha = RandomStringUtils.random(n,true,false);
	return randomAlpha;
	}
	
	@SuppressWarnings("deprecation")
	public static String randomNumbers(int n)
	{
		String randomNum = RandomStringUtils.random(n, false, true);
		return randomNum;
	}
	
	@SuppressWarnings("deprecation")
	public static String randomAlphaNumeric(int n)
	{
		String randomAlphaNum = RandomStringUtils.randomAlphanumeric(n);
		return randomAlphaNum;
	}
	
	public static String randomEmail()
	{
		String remail = randomAlphabets(6)+randomNumbers(2)+"@gmail.com";
		return remail;
	}
	
	public static String randomPassword()
	{
		String randomPwd =randomAlphabets(1).toUpperCase()+randomAlphabets(10).toLowerCase()+randomNumbers(2);
		return randomPwd;
	}
	
	public static String randomSSN()
	{
		String SSN = RandomDataUtils.randomNumbers(3)+"-"+RandomDataUtils.randomNumbers(2)+"-"+RandomDataUtils.randomNumbers(4);
		return SSN;
	}
	
	public static String randomAddress()
	{
		String addr = RandomDataUtils.randomAlphabets(1).toUpperCase()+"-"+RandomDataUtils.randomNumbers(3)+"  "+RandomDataUtils.randomAlphabets(6)
		+" "+RandomDataUtils.randomAlphabets(6);
		return addr;
	}
	
	public static String randomLicense()
	{
		String license = "10"+RandomDataUtils.randomNumbers(6);
		return license;
	}
	
	
}
