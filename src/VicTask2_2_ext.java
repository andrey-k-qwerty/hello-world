import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;
import java.util.TreeMap;

public class VicTask2_2_ext {
	public static void main(String[] args) throws IOException {
		String dataLine = "один, два.три;четыре!пять?шесть-семь восемь;один,, два....три;четыре!?пять?-семь восемь";
		FilterLineReader filterLineReader = new FilterLineReader(new StringReader(dataLine));
	
		filterLineReader.regex = "[\\.,;!\\?-]" ; 
		filterLineReader.replacement = " ";
		
		 String currentLine;
		 TreeMap<String, Integer> treeMap = new TreeMap<>();
		while (( currentLine = filterLineReader.readLine()) != null) 
			{
			Scanner scanner = new Scanner(currentLine);
			
			while (scanner.hasNext())
			{
				 String  currentWorld = scanner.next();
				 Integer i = treeMap.get(currentWorld);
				 treeMap.put(currentWorld, i == null ? 1 : ++i) ;
			}
			scanner.close();
			
		    }  
		  
		filterLineReader.close();
		System.out.println(treeMap.toString().replaceAll("[,]", "\n").replaceAll("[{}]", " "));
	}

}
