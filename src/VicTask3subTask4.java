import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class VicTask3subTask4 {
     
	public static ByteArrayOutputStream getPassword() throws IOException
	{
		Random random = new Random(new Date().getTime());
		StringBuilder sb = new StringBuilder("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
		int lenghtPassword = 8;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(lenghtPassword * 2);
		while( byteArrayOutputStream.size()!= lenghtPassword) {
	         // Gets the inputs from the user
			byteArrayOutputStream.write("hello".getBytes());  
	      }
		return byteArrayOutputStream;
	}
	public static void main(String[] args) throws IOException
	{
		ByteArrayOutputStream baos = getPassword();
		System.out.println(baos);
	}
}
