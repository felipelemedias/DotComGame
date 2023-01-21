
public class DotComBust {
  private GameHelper helper;
  public Player PlayerOne;
  public Player PlayerTwo;
  public int countPlayerOne;
  public int countPlayerTwo;
  
  public DotComBust() {
    helper = new GameHelper();
    String escolha = helper.getUserInput("Player um sera maquina ou humano? 1 - Humano 2 - Computador");
    if(Integer.parseInt(escolha) == 2) {
    	PlayerOne = new ComputerPlayer("Computador 1");
    }else if(Integer.parseInt(escolha) == 1) {
    	escolha = helper.getUserInput("Digite seu nome");
    	PlayerOne = new HumanPlayer(escolha);
    }
    System.out.println();
    escolha = helper.getUserInput("Player dois sera maquina ou humano? 1 - Humano 2 - Computador");
    if(Integer.parseInt(escolha) == 2) {
    	PlayerTwo = new ComputerPlayer("Computador 2");
    }else if(Integer.parseInt(escolha) == 1) {
    	escolha = helper.getUserInput("Digite seu nome");
    	PlayerTwo = new HumanPlayer(escolha);
    }
    System.out.println();
    countPlayerOne = 0;
    countPlayerTwo = 0;
  }
  
  // Inserir o método para iniciar o jogo, apresentar as regras, receber as jogadas do usuário, processar e informar o resultado de cada jogada, apresentar os resultados finais
  public void turn() {
      System.out.println("Player One - Informe a jogada");
      countPlayerOne++;
      PlayerTwo.sufferTurn(PlayerOne.takeTurn());
      if(!PlayerTwo.getDotcoms().isEmpty()) {
    	  System.out.println("Player Two - Informe a jogada");
          countPlayerTwo++;
          PlayerOne.sufferTurn(PlayerTwo.takeTurn());
      }
    if(PlayerOne.getDotcoms().isEmpty() || PlayerTwo.getDotcoms().isEmpty()){
      finishGame();
    }
    
  }

// Inserir o método para apresentar os resultados do jogo  
  public void finishGame() {
	  if(PlayerOne.getDotcoms().isEmpty()) {
		  System.out.println("Player Two ganhou o jogo!!!");
	  }else if(PlayerTwo.getDotcoms().isEmpty()){
		  System.out.println("Player One ganhou o jogo!!!");
	  }
    System.out.println("Jogo terminado após Player One - " + countPlayerOne + " jogadas e Player Two - " + countPlayerTwo + " jogadas");
  }
  
  
}
