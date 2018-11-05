import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordGenerator {
	   private static Pattern password = Pattern
		         .compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{1,})");
		 
		   public static boolean validatePassword(String userName) {
		      Matcher mtch = password.matcher(userName);
		      return mtch.matches();
		        
		   }	      
}
