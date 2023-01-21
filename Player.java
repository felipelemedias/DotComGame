import java.util.ArrayList;

public abstract class Player {
	protected String name;
	protected Grid grid;
	protected ArrayList<DotCom> dotcoms;
	protected GameHelper helper = new GameHelper();
	
	public ArrayList<DotCom> getDotcoms() {
		return dotcoms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public abstract String takeTurn();

	public String sufferTurn(String guess) {
		grid.setGrid(guess, 2);
		String result = "miss";
	      DotCom hitted = null;
	      for(DotCom dotcom : dotcoms) {
	        result = dotcom.checkYourself(guess, grid);   
	        if (result != "miss") {
	          hitted = dotcom;
	          grid.setGrid(guess, 3);
	          if(result == "hit") {
	        	  if(hitted instanceof BigCom) {
	        		  System.out.println(dotcom.hitMessage(grid));
	        	  }else {
	        		  System.out.println(dotcom.hitMessage()); 
	        	  }	
	          }else {
	        	  System.out.println(dotcom.killMessage());
	          }
	          
	          break;
	        }
	        
	      }
	      if (result == "kill") {
	    	  dotcoms.remove(hitted);
	      }else if(result == "miss"){
	    	  System.out.println(result); 
	      }
	      return result;
	}
	
	public boolean placeDotCom(DotCom dotcom) {
		dotcoms.add(dotcom);
		return true;
	}
	
}

