
import java.util.ArrayList;

public class ComputerPlayer extends Player{
	private ArrayList<String> jogadas;
	private int index;
	
	@Override
	public String takeTurn() {
		int indexGuess = (int) (Math.random() * index);
		String guess = jogadas.get(indexGuess);
		return guess;
	}
	
	private void buildCom(String name, int size) {
	    DotCom dotcom = null;
	    ArrayList<String> l;
	    if(size == 3) {
	    	dotcom = new StartupCom();
	    	l = grid.createDotCom(size);
	    	dotcom.setName(name);
	        dotcom.setLocationCells(l);
	    	System.out.print(l);
	    }else if(size == 4) {
	    	dotcom = new MicroCom();
	    	l = grid.createDotCom(size);
	    	dotcom.setName(name);
	        dotcom.setLocationCells(l);
	    	System.out.print(l);
	    }else if (size == 5) {
	    	dotcom = new JustAnotherDotCom();
	    	dotcom.setName(name);
	    	l = grid.createDotCom(size);
	    	dotcom.setLocationCells(l);
	    	System.out.print(l);
	    }else if (size == 6) {
	    	dotcom = new BigCom();
	    	dotcom.setName(name);
	    	l = grid.createDotCom(size);
	    	dotcom.setLocationCells(l);
	    	((BigCom) dotcom).setup();
	    	System.out.print(l);
	    }
	    dotcoms.add(dotcom);
	  }
	
	public ArrayList<String> createDotCom(int comSize) {
		  ArrayList<String> alphaCells = new ArrayList<String>();
		  int [] coords = new int[comSize];
		  int attempts = 0;   
		  boolean success = false;
		  int location = 0;                               
		    
		  //se a com for impar ela fica na vertical, se for par na horizontal
		  grid.comCount++;                                       
		  int incr = 1;                                     
		  if ((grid.comCount % 2) == 1) {                   
		    incr = grid.getGridLength();                              
		  }
		    
		  //tentar as posicoes ate arumar uma posicao sem problemas para a dotcom
		  while (!success & attempts++ < 100 ) {
		  location = (int) (Math.random() * grid.getGridSize());
			int x = 0;                                      
		        success = true;                  
		        while (success && x < comSize) {       
		          if (grid.getGrid(location) == 0) {                  
		             coords[x++] = location;               
		             location += incr;                   
		             if (location >= grid.getGridSize()){ //passou da grid            
		               success = false;                
		             }
		             if (x>0 & (location % grid.getGridLength() == 0)) { //passou da grid
		               success = false;                       
		             }
		          } else {//grid ocupada
		              success = false;                      
		          }
		        }
		    }                                            

		    //converter de vetor para alpha (de "12" para "a2")
		    int x = 0;
		    while (x < comSize) {
		      grid.setGrid(coords[x], 1);
		      alphaCells.add(helper.convertNumberToAlpha(coords[x]));
		      x++; 
		    }
		    
		    return alphaCells;
	  }
	
	public ComputerPlayer(String name) {
		grid = new Grid();
		dotcoms = new ArrayList<DotCom>();
		this.name = name;
		this.jogadas = new ArrayList<String>();
		for(int i = 0; i < grid.getGridSize(); i++) {
			jogadas.add(helper.convertNumberToAlpha(i));
		}
		index = grid.gridSize;
    	buildCom("BigCom1", 6);
    	buildCom("StartupCom1", 3);
    	buildCom("StartupCom2", 3);
    	buildCom("StartupCom3", 3);
    	buildCom("StartupCom4", 3);
    	buildCom("MicroCom1", 4);
    	buildCom("MicroCom2", 4);
    	buildCom("MicroCom3", 4);
    	buildCom("JustAnotherDotCom1", 5);
    	buildCom("JustAnotherDotCom2", 5); 
	}

	
	
}
