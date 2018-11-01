/*4. Консольная программа.
Предыдущая программа.
Только перед выводом в файл сделать фильтрацию слов.
Выводить только слова, длина которых больше 2-х символов и в которых число согласных больше, чем гласных.
Работать с английским алфавитом.
Позаботиться о максимальной производительности алгоритма фильтрации.*/
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VicTask2_4 {
	public static boolean isMoreVowels(String src)
	{
		int lenghtWord = src.length();
		int changeWord = src.replaceAll("[AaEeIiOoUuYy]+", "").length();
		return (lenghtWord - changeWord) > changeWord;
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String dataLine = "one, two.three;four!five?six-seven eight --- foo;one,, two....three;four!?five?-seven-foo- eight;;ten";
		
		Scanner scannerDataLine = new Scanner(dataLine);
		//Для файла
		//Scanner scanerFile = new Scanner(Paths.get("myfile.txt")); 
		
		scannerDataLine.useDelimiter("[\\.,;!\\?\\s-]+");
				
		int maxLenghtWord = 0;
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		
		while (scannerDataLine.hasNext())
		{
			String currentWord = scannerDataLine.next();
			maxLenghtWord = Math.max(currentWord.length(), maxLenghtWord);
			Integer i = treeMap.get(currentWord);
			treeMap.put(currentWord, i == null ? 1 : ++i);
		}
		scannerDataLine.close();
		
		Scanner scannerConsole = new Scanner(System.in);
		System.out.println("Введите количество разрядов для числа:");
		Integer countDigit =  scannerConsole.nextInt();
		int i = 1;
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> entry : treeMap.entrySet())
		{
			String key = entry.getKey();
			Integer value = entry.getValue();
			if (key.length() > 2 && !isMoreVowels(key))
			{	
			sb.append(String.format("%" + (maxLenghtWord + 1) + "s %"+ countDigit + "d", key, value));
			 
			if (i % 10 == 0)
				sb.append("\n");

			i++;
			}
		}
		System.out.println(sb.toString());

		PrintWriter printWriter = new PrintWriter("out.txt");
		printWriter.print(sb.toString());
		printWriter.close();
	}

}
