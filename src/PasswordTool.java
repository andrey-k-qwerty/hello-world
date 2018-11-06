import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordTool
{
	public static int lenghtPassword = 8;
	public static Pattern password = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{1,})");

	public static boolean validatePassword(String userName)
	{
		Matcher mtch = password.matcher(userName);
		return mtch.matches();
	}
	public static ByteArrayOutputStream getPassword() throws IOException
	{
		Random random = new Random(System.nanoTime());
		StringBuilder sb = new StringBuilder(
				"abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
	
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(lenghtPassword);

		do
		{
			byteArrayOutputStream.reset();
			while (byteArrayOutputStream.size() < lenghtPassword)
			{

				int randomIndex = sb.charAt(random.nextInt(sb.length()));
				byteArrayOutputStream.write(randomIndex);
			}
		} while (!PasswordTool.validatePassword(byteArrayOutputStream.toString()));
		return byteArrayOutputStream;
	}
}
