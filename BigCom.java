import java.util.ArrayList;

public class BigCom extends DotCom{
	private ArrayList<String> filiais = new ArrayList<String> ();
	int count = 0;
	int space = 0;
	GameHelper h = new GameHelper();
	
	public String hitMessage() {
		return "error";
	}
	
	public String hitMessage(Grid grid) {
		count++;
		String message;
		movePositions(grid);
		if(count == 2){
			String s = filiais.get(0);
			filiais.remove(0);
			count = 0;
			message = "Voce Acertou a " + name + " e removeu a filial " + s;
		}else {
			message = "Voce Acertou a " + name;
		}
		return message;
	}

	public void setup() {
		filiais.add("Pichau");
		filiais.add("Kabum");
		space = h.convertAlphatoNuber(locationCells.get(1)) - h.convertAlphatoNuber(locationCells.get(0));
	}
	
	public boolean movePositions(Grid grid) {
		String s;
		int random = (int)(Math.random() * 4);
		if(random == 3 & !grid.gridOccupied(h.convertAlphatoNuber(locationCells.get(0)) - space)) {
			for(int i = 0; i < locationCells.size(); i++){
				s = locationCells.get(0);
				int temp = h.convertAlphatoNuber(s);
				temp -= space;
				grid.setGrid(h.convertAlphatoNuber(locationCells.get(0)) - space, 1);
				locationCells.add(h.convertNumberToAlpha(temp));
				locationCells.remove(s);
			}
			System.out.println("A " + name + " moveu para frente");
			return true;
		}else if (random == 2 & !grid.gridOccupied(h.convertAlphatoNuber(locationCells.get(locationCells.size()-1)) + space)) {
			for(int i = 0; i < locationCells.size(); i++){
				s = locationCells.get(0);
				int temp = h.convertAlphatoNuber(s);
				temp += space;
				locationCells.add(h.convertNumberToAlpha(temp));
				locationCells.remove(s);
			}
			System.out.println("A " + name + " moveu para tras");
			return true;
		}
		System.out.println("A " + name + " nao se moveu");
		return false;
	}
	
}
