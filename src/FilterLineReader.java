
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FilterLineReader extends BufferedReader {
	String regex ="";
	String replacement = "";
	
	public FilterLineReader(Reader in) {
		super(in);
		// TODO Auto-generated constructor stub
	}
	public FilterLineReader(InputStream in) {
		
		super(new InputStreamReader(in));
		// TODO Auto-generated constructor stub
	}
	
	   @Override
	public String readLine() throws IOException {
		// TODO Auto-generated method stub
		   String currentLine =  super.readLine();
		   
		return currentLine == null ?  currentLine :currentLine.replaceAll(regex, replacement);
	}
	   public String[] toArrayString() throws IOException {
		   
			// TODO Auto-generated method stub
		   StringBuilder arrayString = new StringBuilder();
		   String currentLine = "";
		   while (( currentLine = readLine()) != null) 
			{
			   arrayString.append(currentLine);
		    }  
		   return arrayString.toString().split(" +");
	   }
	   
	

}