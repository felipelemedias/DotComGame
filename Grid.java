import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class Grid{
	protected int gridLength = 10;
	protected int gridSize = 100;
	protected int []grid;
	public int comCount = 0;
	private GameHelper helper = new GameHelper();

	public Grid(){
		grid = new int[gridSize];
    }

  public void printGridGui(){
    JFrame f = new JFrame();
    f.setLayout(new FlowLayout());
    f.setSize(150, 300);
    JLabel label = new JLabel("Grid");
    JLabel label2 = new JLabel("Instruções");
    label2.setText("<html> Mapa <br> 0 - Inocupado <br> 1 - Ocupado <br> 2 - Tiro Agua <br> 3 - Tiro Acertado </html>");
    label.setText("<html>  -- A B C D E F G H I J <br> </html>");
    String s;
    for(int i = 0; i < gridLength;i++){
      s = label.getText();
      label.setText(s.substring(0, s.length() - 8) + i + " </html>");
      for(int j = i*gridLength; j < (i+1)*gridLength; j++) {
				s = label.getText();
        label.setText(s.substring(0, s.length() - 8) + " " + grid[j] + " " + " </html>");
			}
      s = label.getText();
      label.setText(s.substring(0, s.length() - 8) + "<br>  </html>");
    }
    f.add(label2);
    f.add(label);
    f.setVisible(true);
  }

  public void printGridGuiInimigo(){
    JFrame f = new JFrame();
    f.setLayout(new FlowLayout());
    f.setSize(150, 300);
    JLabel label = new JLabel("Grid");
    JLabel label2 = new JLabel("Instruções");
    label2.setText("<html> Mapa <br> 0 - Inocupado <br> 1 - Ocupado <br> 2 - Tiro Agua <br> 3 - Tiro Acertado </html>");
    label.setText("<html>  -- A B C D E F G H I J <br> </html>");
    String s;
    for(int i = 0; i < gridLength;i++){
      s = label.getText();
      label.setText(s.substring(0, s.length() - 8) + "-" + i + " </html>");
      for(int j = i*gridLength; j < (i+1)*gridLength; j++) {
				s = label.getText();
        if(grid[j] == 1){
          label.setText(s.substring(0, s.length() - 8) + " 0 " + " </html>");
        }else{
          label.setText(s.substring(0, s.length() - 8) + " " + grid[j] + " " + " </html>");
        }
        
			}
      s = label.getText();
      label.setText(s.substring(0, s.length() - 8) + "<br>  </html>");
    }
    f.add(label2);
    f.add(label);
    f.setVisible(true);
  }
  
	public void printGrid() {
		for(int i = 0; i < gridLength; i++) {
			for(int j = i*gridLength; j < (i+1)*gridLength; j++) {
				System.out.print(grid[j] + " ");
			}
			System.out.println();
		}
	}
	public int getGridSize() {
		return gridSize;
	}
	
	public int getGridLength() {
		return gridLength;
	}

	public void setGridLength(int gridLength) {
		this.gridLength = gridLength;
	}

	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}

	public boolean gridOccupied(int x) {
		  if(x<0 || x >= 100) {
			  return true;
		  }
		  if(grid[x] == 1){
			  return true;
		  }else {
			  return false;
		  }
	 }
	
		
	public void setGrid(String place, int num) {
		int number = helper.convertAlphatoNuber(place);
		grid[number] = num;
	}
	
	public void setGrid(int place, int num) {
		grid[place] = num;
	}
	
	public int getGrid(int number) {
		return grid[number];
	}
	
	public void clearGrid() {
		for(int i = 0; i < gridSize; i++) {
			grid[i] = 0;
		}
	}
	
	public ArrayList<String> createDotCom(int comSize) {
		  ArrayList<String> alphaCells = new ArrayList<String>();                                 
		  int [] coords = new int[comSize];                  
		  int attempts = 0;                                 
		  boolean success = false;                          
		  int location = 0;                               
		    
		  //se a com for impar ela fica na vertical, se for par na horizontal
		  comCount++;                                       
		  int incr = 1;                                     
		  if ((comCount % 2) == 1) {                   
		    incr = gridLength;                              
		  }
		    
		  //tentar as posicoes ate arumar uma posicao sem problemas para a dotcom
		  while (!success & attempts++ < 100 ) {          
		  location = (int) (Math.random() * gridSize);
			int x = 0;                                      
		        success = true;                  
		        while (success && x < comSize) {       
		          if (grid[location] == 0) {                  
		             coords[x++] = location;               
		             location += incr;                   
		             if (location >= gridSize){ //passou da grid            
		               success = false;                
		             }
		             if (x>0 & (location % gridLength == 0)) { //passou da grid
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
		      grid[coords[x]] = 1;
		      alphaCells.add(helper.convertNumberToAlpha(coords[x]));
		      x++; 
		    }
		    
		    return alphaCells;
	  }
	
}
