import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper{
	private ArrayList<String> letras = new ArrayList<String> ();
	protected int gridLength = 10;
	protected int gridSize = 100;
	private static final String alphabet = "abcdefghij";
	
	public GameHelper() {
		letras.add("a");
		letras.add("b");
		letras.add("c");
		letras.add("d");
		letras.add("e");
		letras.add("f");
		letras.add("g");
		letras.add("h");
		letras.add("i");
		letras.add("j");
	}
	
	public String convertNumberToAlpha(int number){
		  int row = 0;
		  int column = 0;
		  row = (int) (number / gridLength);        
	      column = number % gridLength;            
	      String temp = String.valueOf(alphabet.charAt(column));   
	      return temp.concat(Integer.toString(row));
	  }
	  
	  public int convertAlphatoNuber(String s) {
      if(s == null || s.length() != 2){
        return -1;
      }
			 String primeiro = ""+s.charAt(1);
  			String segundo = ""+s.charAt(0);
  			int seg;
  			seg = letras.indexOf(segundo);
  			int pri = Integer.parseInt(primeiro) * 10;
  			return seg + pri;
		}
	
  public String getUserInput(String prompt) {
	 String inputLine = null;
	 System.out.print(prompt + "  ");
     try {
       BufferedReader is = new BufferedReader(
	 new InputStreamReader(System.in));
       inputLine = is.readLine();
       if (inputLine.length() == 0 )  return null; 
     } catch (IOException e) {
       System.out.println("IOException: " + e);
     }
     return inputLine.toLowerCase();
  }
}

  
  
  
  
  