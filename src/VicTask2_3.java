import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.sun.org.apache.xml.internal.serialize.Printer;

public class VicTask2_3 {

	public static void main(String[] args) throws IOException {
		String dataLine = "один, два.три;четыре!пять?шесть-семь восемь;один,, два....три;четыре!?пять?-семь восемь";
		FilterLineReader filterLineReader = new FilterLineReader(new StringReader(dataLine));
	
		filterLineReader.regex = "[\\.,;!\\?-]" ; 
		filterLineReader.replacement = " ";
		 
		 String currentLine;
		 int maxLenghtWord = 0;
		 TreeMap<String, Integer> treeMap = new TreeMap<>();
		while (( currentLine = filterLineReader.readLine()) != null) 
			{
			Scanner scanner = new Scanner(currentLine);
			
			while (scanner.hasNext())
			{
				 String  currentWorld = scanner.next();
				 maxLenghtWord = Math.max(currentWorld.length(), maxLenghtWord);
				 Integer i = treeMap.get(currentWorld);
				 treeMap.put(currentWorld, i == null ? 1 : ++i) ;
			}
			scanner.close();
			
		    }  
		  
		filterLineReader.close();
		
		PrintWriter printWriter = new PrintWriter("out.txt");
	//	System.out.println(treeMap.toString());
		
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String,Integer> entry : treeMap.entrySet()) {
			  String key = entry.getKey();
			  Integer value = entry.getValue();
			//   String.format("%10s %4d", name, lName, nick);
           //    sb.append(key).append(" ").append(value)
			  System.out.println(String.format("%"+maxLenghtWord+"s %4d", key, value));
             //  sb.toString().f
			}
			
		}
       
	}




