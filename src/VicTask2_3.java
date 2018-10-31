
/*Консольная программа.
Предыдущая задача. Только результат вывести в файл (можно захардкодить имя и путь к файлу).
Формат вывода - по 10 пар "слово количествоПовторений" в каждой строке.
Пары разделены символом "|". В начале и в конце строк этого символа нет.
На каждое слово отвести места, как длина самого длинного слова в файле.
Более короткие слова дополнить слева пробелами.
На каждое число отвести N символов, слева дополнить пробелами.
Число N запросить с консоли в начале работы программы.
Вывести в файл одной строкой. !?
Подсказка - для конкатенации строк выбрать правильный способ, обеспечивающий экономию памяти и быстродействие.*/
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VicTask2_3 {

	public static void main(String[] args) throws IOException
	{
		String dataLine = "один, два.три;четыре!пять?шесть-семь восемь;один,, два....три;четыре!?пять?-семь восемь";
		// Соз
		FilterLineReader filterLineReader = new FilterLineReader(new StringReader(dataLine));

		filterLineReader.regex = "[\\.,;!\\?-]";
		filterLineReader.replacement = " ";

		String currentLine;
		int maxLenghtWord = 0;
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		while ((currentLine = filterLineReader.readLine()) != null)
		{
			Scanner scanner = new Scanner(currentLine);

			while (scanner.hasNext())
			{
				String currentWorld = scanner.next();
				maxLenghtWord = Math.max(currentWorld.length(), maxLenghtWord);
				Integer i = treeMap.get(currentWorld);
				treeMap.put(currentWorld, i == null ? 1 : ++i);
			}
			scanner.close();

		}

		filterLineReader.close();

		// System.out.println(treeMap.toString());
		int i = 1;
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> entry : treeMap.entrySet())
		{
			String key = entry.getKey();
			Integer value = entry.getValue();
			sb.append(String.format("%" + (maxLenghtWord + 1) + "s %d", key, value));
			if (i % 2 == 0)
				sb.append("\n");

			i++;
		}
		System.out.println(sb.toString());

		PrintWriter printWriter = new PrintWriter("out.txt");
		printWriter.print(sb.toString());
		printWriter.close();
	}

}
