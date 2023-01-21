import java.util.ArrayList;

public class JustAnotherDotCom extends DotCom{
	private ArrayList<String> contratantes = new ArrayList<String> ();

	public JustAnotherDotCom() {
		contratantes.add("Americanas");
		contratantes.add("Ponto Frio");
		contratantes.add("Amazon");
		contratantes.add("Wallmart");
		contratantes.add("Carrefour");
	}
	
	public String hitMessage() {
		String c = contratantes.get(0);
		contratantes.remove(0);
		return "Voce Acertou a " + name + "e tirou a contratante " + c;
	}
	
	
}
