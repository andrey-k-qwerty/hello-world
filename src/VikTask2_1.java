import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

/* � ������� ������� ������ �� ���� 2-� ����������. ��������� � ������� ��� 2 ��������� � 
   �������� �� � ���� ��������� (java class Properties).
   ����� ��������� � ������� ������� ��� � �������*/
public class VikTask2_1 {

		
	public static void main(String[] args) throws IOException {
		
		System.out.println("������� ��� ��������� ����� ������:");
		
		Scanner scan = new Scanner(System.in);
		Properties prop = new Properties();
		String param = "";
		int counter = 0, amount = 2;
		
		while (( counter++ != amount ) && scan.hasNext()  ) {
		  param = scan.next();
		  prop.setProperty(Integer.toString(counter), param);
		};
		 
		scan.close();

		System.out.println("������ � ����");
		prop.store(new FileOutputStream("property.ini"), "comments");
		
		System.out.println("-------------");
	
		System.out.println("������ ��  �����");
		prop.load(new FileInputStream("property.ini"));
		
		Set<String> keys = prop.stringPropertyNames();
		for (String str : keys) {
			System.out.println(prop.getProperty(str));
		}
	}

}
