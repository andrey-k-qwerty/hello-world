import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
/*
задан CSV файл. Например 5 полей, разделенных точкой-запятой. Пусть поле1 имеет тип строка, поле2 int, поле 3 double, поле4 
DateTime, поле 5 строка. Надо его прочитать в список объектов. В файле могут быть проблемы. Надо показать, что ты умеешь 
обрабатывать эксепшены. Подумать какие, как и где ты будешь ловить. Например. Из нескольких строк файла в одной не будет 
какого-то поля. поле даты-времени может быть неправильного формата. Разделитель вещественного числа другой. Разделитель 
между полями в файле не точка-запятая. Самого файла может не оказаться по указанному пути. Еще подумай над вариантами. 
У собеседующего ты должен спросить, как глобально реагировать на поломку данных - прочитать все, что возможно и сообщить 
о проблемах с некоторыми данными или вообще прекратить чтение и сообщить об ошибке.

 путь к файлу и разделитель будет не захардкожен, а передаваться как параметры и браться будут, как варианты, из проперти файла,
 а если его нет, то запрашиваться с консоли - написать, что дефолтный разделитель такой-то, введите другой. Если просто был 
 нажат ввод - остается дефолтный.
 
 выведи результат прочитанного в консоль - у класса строки данных можно перекрыть метод toString - в Эклипсе и в Идее есть быстрые 
 команды для генераци его.
 Предусмотри вариант старта программы из консоли, где путь и разделитель можно задать, как аргументы (что, если их поменяют 
 местами)
*/
/**
 * Программа может вызываться с параметрами java VicTaskCSV -Dseparator=char
 * -DfilePathProperty=fileProperty -DfileCSV=fileCSV <br>
 * param -s символ разделителя в файле между полями записи <br>
 * 
 */
public class VicTaskCSV {

	public static void main(String[] args)
		{

			String csvSeparator;
			File fileCSV = null;
			File fileProperty = null;
			
			String filePathProperty;
			String filePathCSV;
			String  originalFormatDate = "dd-MM-yyyy";
			
     
			csvSeparator = (System.getProperty("separator") == null) ? ";"
					: System.getProperty("separator");
			filePathProperty = System.getProperty("filePathProperty");
			filePathCSV = System.getProperty("filePathCSV");
      
			Scanner scanner = new Scanner(System.in);

			if(filePathProperty == null)
				{
					System.out.println("Не задан файл свойств. Введите путь и имя файла свойств или"
							+ "нажмите Enter чтобы использовать по умолчанию.");
					while ((filePathProperty = scanner.nextLine()) != null)
						{

							if(filePathProperty.isEmpty())
								break;
							fileProperty = new File(filePathProperty);
							if(!fileProperty.exists())
								{
									System.out.println("Такого файла не существует. Нажмите Enter чтобы использовать"
											+ " по умолчанию или ввидите правильный путь к файлу");
								} else
								{
									// TO-DO Сделать загрузку свойств, пока использую по умолчанию
								}

						}
				}// тут тоже необходим загрузка свойств

			if(filePathCSV == null)
				{
					System.out.println("Не задан файл CSV. Введите путь и имя файла  или" + "нажмите Enter чтобы иыйти.");
					while ((filePathCSV = scanner.nextLine()) != null)
						{

							if(filePathCSV.isEmpty())
								break;
							fileCSV = new File(filePathCSV);
							if(!fileCSV.exists())
								{
									System.out.println("Такого файла не существует. Нажмите Enter чтобы использовать"
											+ " по умолчанию или ввидите правильный путь к файлу");
								} else
								{
									break;
									// TO-DO Здесь пока ничего не делаем
								}

						}
				} else	fileCSV = new File(filePathCSV);
		  	scanner.close();
        ArrayList<Employee> listEmployee = new ArrayList<>();
			try
				{
					BufferedReader br = new BufferedReader(new FileReader(fileCSV));
					String lineBR;
					String str2 = "(.*[/]{2,}.*)|(^[#].*)|(^$)";
					while ((lineBR = br.readLine()) != null)
					  {
					  	// коменты пропускаем  -> // # и пустые строки
					  	if (lineBR.matches(str2)) continue;
					  	
					  	String[] recorddEmlpoyee = lineBR.split(csvSeparator);
					  	System.out.println(Arrays.toString(recorddEmlpoyee) );
					  	System.out.println(recorddEmlpoyee.length );
					    //field1 - string, f2-int,f3-double,f4-date,f5-string
					  	//Валидация - стринги не трогаем, int и double =0, date пока в new Date
					  	// 
					  	if (!recorddEmlpoyee[1].matches("[-+]?\\d+")) 
					  		recorddEmlpoyee[1] = "0";
					  	//double - проверим пока как целое
					  	if (!recorddEmlpoyee[2].matches("[-+]?\\d+[,.]?\\d*")) 
					  		recorddEmlpoyee[2] = "0.0";
					  	if  (!recorddEmlpoyee[3].matches("(0?[1-9]|[12][0-9]|3[01])[- /\\.](0?[1-9]|1[012])[- /\\.](19|20)\\d{2}")) 
					  		recorddEmlpoyee[3] = new SimpleDateFormat(originalFormatDate).format(new Date());
					  	// Заполняем...
					  	try
								{
									listEmployee.add(new Employee(recorddEmlpoyee));
								} catch (ParseException e)
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
					  	
					  	
					  }
					
					 for (Employee employee : listEmployee)
						{
							System.out.println(employee);
						}
					

				} catch (FileNotFoundException e)
				{
					System.out.println("File not found.");

				} catch (NullPointerException e)
				{
					System.out.println("No file specified.");

				} catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}

}

class Employee {
	String name;
	int pesonalNumber;
	double salary;
	Date hiredDay;
	String comment;
	
	public Employee(String name, int pesonalNumber, double salary, Date hiredDay, String comment) {
		super();
		this.name = name;
		this.pesonalNumber = pesonalNumber;
		this.salary = salary;
		this.hiredDay = hiredDay;
		this.comment = comment;
	}
	public Employee(String[] volue) throws ParseException {
		super();
		this.name = volue[0];
		this.pesonalNumber = Integer.parseInt(volue[1]);
		this.salary = Double.parseDouble(volue[2]);
		this.hiredDay = new SimpleDateFormat("dd-MM-yyyy").parse(volue[3]);
		this.comment = volue[4];
	}
	
	@Override
	public String toString()
		{
			return "Employee [name=" + name + ", pesonalNumber=" + pesonalNumber + ", salary=" + salary + "$, hiredDay="
					+ new SimpleDateFormat("dd.MM.yyyy").format(hiredDay) + ", comment=" + comment + "]";
			
		}
	  
}
