import java.util.ArrayList;

public class HumanPlayer extends Player {

	@Override
	public String takeTurn() {
		String jogada = helper.getUserInput("Informe a jogada");
	    System.out.println();
		return jogada;
	}
	
	public DotCom createDotCom(String name, int comSize) {
		  DotCom dotcom = null;
		  int [] coords = new int[comSize];
		  boolean success = true;
		  ArrayList<String> alphaCells = new ArrayList<String>();
		  System.out.println("Criando uma dotcom de tamanho " + comSize);
		  String position = helper.getUserInput("Digite a posicao que a DotCom vai ficar");
		  while(helper.convertAlphatoNuber(position) >= 100 || helper.convertAlphatoNuber(position) < 0) {
			  System.out.println("Fora da Grid");
			  position = helper.getUserInput("Digite a posicao que a DotCom vai ficar");
		  }
		  int displayed = Integer.parseInt(helper.getUserInput("1 - Horizontal, 2 - Vertical"));
		  if(displayed != 1) {
			  displayed = 10;
		  }
		  int positionNumber = helper.convertAlphatoNuber(position);
		  int x = 0;
		  while (success && x < comSize){     
	          if (grid.getGrid(positionNumber) == 0) {                  
	            System.out.println(positionNumber); 
              coords[x++] = positionNumber;
              if(x<comSize){
                positionNumber += displayed;
                                   
    	          if(positionNumber >= grid.getGridSize()){ //passou da grid            
    	               success = false;
    	               System.out.println("passou da grid11");
    	            }
    	          if (displayed == 1 && x > 0 & (positionNumber % grid.getGridLength() == 0)) { //passou da grid
    	               success = false;
    	               System.out.println("passou da grid12");
    	          }
    	        } 
            }else {//grid ocupada
    	              success = false;
    	              System.out.println("passou da grid13");
    	      }
	      }
		  if(!success) {
			  coords = new int[comSize];
			  x = 0;
			  success = true;
			  displayed = displayed * (-1);
			  positionNumber = helper.convertAlphatoNuber(position);
			  while (success && x < comSize){     
		          if (grid.getGrid(positionNumber) == 0){ 
                 System.out.println(positionNumber); 
		             coords[x++] = positionNumber;  
		             positionNumber += displayed;
                if(x<comSize){
                  if (positionNumber < 0){ //passou da grid            
		               success = false;
		               System.out.println("passou da grid1");
		             }
                
		             if (displayed == -1 && positionNumber % grid.getGridLength() == 0 && x<comSize-1) { //passou da grid
		               success = false;
		               System.out.println("passou da grid2");
		             }
                } 
		          } else {//grid ocupada
		              success = false;
		              System.out.println("passou da grid3");
		          }
		          
		      }
			  
			  
		  }
		  if(!success) {
			  System.out.println("Impossivel fazer a DotCom, tente novamente");
			  return null;
		  }else {
			  x = 0;
			  while (x < comSize) {
			      grid.setGrid(coords[x], 1);
			      alphaCells.add(helper.convertNumberToAlpha(coords[x]));
			      x++; 
			  }
			  if(comSize == 3) {
			    	dotcom = new StartupCom();
			    	dotcom.setName(name);
			        dotcom.setLocationCells(alphaCells);
			    	System.out.print(alphaCells);
			    }else if(comSize == 4) {
			    	dotcom = new MicroCom();
			    	dotcom.setName(name);
			        dotcom.setLocationCells(alphaCells);
			    	System.out.print(alphaCells);
			    }else if (comSize == 5) {
			    	dotcom = new JustAnotherDotCom();
			    	dotcom.setName(name);
			        dotcom.setLocationCells(alphaCells);
			    	System.out.print(alphaCells);
			    }else if (comSize == 6) {
			    	dotcom = new BigCom();
			    	dotcom.setName(name);
			        dotcom.setLocationCells(alphaCells);
			    	System.out.print(alphaCells);
			    	((BigCom) dotcom).setup();
			    }
		  }
		  
		  return dotcom;
	  }
	
	public HumanPlayer(String name) {
		grid = new Grid();
		dotcoms = new ArrayList<DotCom>();
		this.name = name;
		DotCom teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("BigCom1", 6);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("StartupCom1", 3);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("StartupCom2", 3);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("StartupCom3", 3);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("StartupCom4", 3);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("MicroCom1", 4);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("MicroCom2", 4);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("MicroCom3", 4);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("JustAnotherDotCom1", 5);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("JustAnotherDotCom2", 5);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
	}
}
