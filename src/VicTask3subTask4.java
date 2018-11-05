import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

public class VicTask3subTask4 {
     //https://www.tutorialspoint.com/java/java_bytearrayoutputstream.htm
	 //https://ru.stackoverflow.com/questions/533675/%D0%A0%D0%B5%D0%B3%D1%83%D0%BB%D1%8F%D1%80%D0%BD%D0%BE%D0%B5-%D0%B2%D1%8B%D1%80%D0%B0%D0%B6%D0%B5%D0%BD%D0%B8%D0%B5-%D0%B4%D0%BB%D1%8F-%D0%BF%D0%B0%D1%80%D0%BE%D0%BB%D1%8F-%D0%BE%D1%82-6-%D1%81%D0%B8%D0%BC%D0%B2%D0%BE%D0%BB%D0%BE%D0%B2-%D1%81-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5%D0%BC-%D1%86%D0%B8%D1%84%D1%80-%D1%81%D0%BF%D0%B5%D1%86-%D1%81%D0%B8%D0%BC%D0%B2%D0%BE/533681
	//https://www.quora.com/How-do-I-write-a-regex-for-a-string-that-contains-alphanumeric-characters-having-at-least-one-uppercase-letter-one-lowercase-letter-and-one-digit
	public static ByteArrayOutputStream getPassword() throws IOException
	{
		Random random = new Random(System.nanoTime());
		StringBuilder sb = new StringBuilder("abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
		int lenghtPassword = 8;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(lenghtPassword);
		
		do
		{	
			byteArrayOutputStream.reset();
	    	while( byteArrayOutputStream.size() < lenghtPassword) {
	    		
			int index = sb.charAt(random.nextInt(sb.length()));
			byteArrayOutputStream.write(index);
	      }
		}
		while (!PasswordGenerator.validatePassword(byteArrayOutputStream.toString()));
		return byteArrayOutputStream;
	}
	public static void main(String[] args) throws IOException
	{
//		ByteArrayOutputStream baos = getPassword();
		for (int i = 0; i < 15 ; i++ )
		{
			System.out.println(getPassword());
			
		}
		//String str = "(.*)(\\d+)([a-z])(.*)";
		String str = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{1,})";
		System.out.println("3f".matches(str));
		System.out.println("f3fsdfasf".matches(str));
//		for(byte bt : baos.toByteArray())
//	  	  System.out.print((char)bt);
	      System.out.println("Is 'mvashok21' a valid ? " + PasswordGenerator.validatePassword("mvashok21"));
	      System.out.println("Is 'mvAshok1#@' a valid ? " + PasswordGenerator.validatePassword("mvAshok1#@"));
	      System.out.println("Is 'MvAshok21' a valid ? " + PasswordGenerator.validatePassword("MvAshok21"));
	      System.out.println("Is '234abc' a valid ? " + PasswordGenerator.validatePassword("234abc"));
	      System.out.println("Is '3fF' a valid ? " + PasswordGenerator.validatePassword("3fF"));
	      System.out.println("Is 'ff3' a valid ? " + PasswordGenerator.validatePassword("ff3"));
	}
}
