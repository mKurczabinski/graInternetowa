package pl.wlochynski.utilites;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSecurityUtils {

	public static boolean checkEmailOrPassword(String pattern, String pStr)
	{
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(pStr); 
		return m.matches();
	}
}
