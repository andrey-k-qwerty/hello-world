import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.TreeMap;

/*
 * Консольная программа.
Ручками создать текстовый файл, в котором накидать произвольные слова. Некоторые слова должны повторяться в произвольных местах
 текста.
Разделителями между словами являются ".,;!?- " и перевод строки - в любом сочетании 
(может быть несколько произвольных разделителей между словами).
Прочитать этот файл (можно захардкодить имя и путь к файлу), подсчитать количество повторений слов и вывести на экран.
Порядок вывода - "слово количествоПовторений" на отдельных строчках.
Строки выводить в порядке алфавитной сортировки слов.
Алгоритм должен работать без переделки кода при любом содержании файла.
http://developer.alexanderklimov.ru/android/java/hashmap.php
http://proglang.su/java/regular-expressions
https://ru.stackoverflow.com/questions/330039/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0-map-%D0%BF%D0%BE-%D0%B7%D0%BD%D0%B0%D1%87%D0%B5%D0%BD%D0%B8%D1%8E-java
https://stackoverflow.com/questions/922528/how-to-sort-map-values-by-key-in-java
*/
public class VikTask2_2 {

	public static void main(String[] args) throws IOException {

		String currentLine = "один, два.три;четыре!пять?шесть-семь восемь;один,, два....три;четыре!?пять?-семь восемь";
		// BufferedReader br = new BufferedReader(new FileReader("source.txt"));
		BufferedReader br = new BufferedReader(new StringReader(currentLine));
		HashMap<String, Integer> hm = new HashMap<>();
		while ((currentLine = br.readLine()) != null) 
		{
			String[] changeLine = currentLine.replaceAll("[\\.,;!\\?-]", " ").split(" +");
			for (String str : changeLine) 
			{
				Integer value = hm.get(str);
				hm.put(str, value == null ? 1 : ++value);
			}

		}
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(hm);
		System.out.println(treeMap.toString().replaceAll("[{},]", "\n"));
	//	System.out.println(hm);

	}
}
