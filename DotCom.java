import java.util.ArrayList;
import java.util.List;

abstract public class DotCom {
	
	protected ArrayList<String> locationCells;
	protected String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getLocationCells() {
		return locationCells;
	}
	
	public void setLocationCells(ArrayList<String> cells) {
		this.locationCells = cells; 
	}
	
	public abstract String hitMessage();
	public String hitMessage(Grid grid) {
		return "n";
	}
	
	public String killMessage() {
		return "Voce Matou a " + name;
	}
	
	public String checkYourself(String guess, Grid grid) {
		 String result = "miss";
		 grid.setGrid(guess, 2);
		 for(String p : locationCells) {
		   if (p.equals(guess)) {
		     result = "hit";
		     break;
		   }
		 }
		 if (result == "hit") {
		   locationCells.remove(guess);
		 }
		 if (locationCells.isEmpty()) {
		   result = "kill";
		 }
		 return result;	
	}
}