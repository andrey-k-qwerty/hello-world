import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

/* В консоли вывести запрос на ввод 2-х параметров. прочитать с консоли эти 2 параметра и 
   записать их в файл пропертей (java class Properties).
   Потом прочитать и обратно вывести все в консоль*/
public class VikTask2_1 {

		
	public static void main(String[] args) throws IOException {
		
		System.out.println("Веддите два параметра через пробел:");
		
		Scanner scan = new Scanner(System.in);
		Properties prop = new Properties();
		String param = "";
		int counter = 0, amount = 2;
		
		while (( counter++ != amount ) && scan.hasNext()  ) {
		  param = scan.next();
		  prop.setProperty(Integer.toString(counter), param);
		};
		 
		scan.close();

		System.out.println("Запись в файл");
		prop.store(new FileOutputStream("property.ini"), "comments");
		
		System.out.println("-------------");
	
		System.out.println("Чтение из  файла");
		prop.load(new FileInputStream("property.ini"));
		
		Set<String> keys = prop.stringPropertyNames();
		for (String str : keys) {
			System.out.println(prop.getProperty(str));
		}
	}

}
