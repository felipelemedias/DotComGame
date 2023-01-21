import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Menu extends JFrame implements ActionListener{
    private JMenuBar BarraMenu = null;
    private JMenu mnuJogo = null;
    private JMenu mnuMapas = null;
    private JMenu mnuHelper = null;
    private JMenuItem mnuNovo = null;
    private JMenuItem mnuSair = null;
    private JMenuItem mnuMapaPlayer = null;
    private JMenuItem mnuMapaComputador = null;
    private JMenuItem mnuNovaJogada = null;
    private JMenuItem mnuTiros = null;
    private DotComBust game;
    
    public Menu(DotComBust game) {
    	this.game = game;
      initialize();
      
    }
    
    private void initialize(){
    	this.setTitle("DotComGame");
    	this.setJMenuBar(getBarraMenu());
    	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	this.setSize(800,600);
    	this.setVisible(true);
    }
    
    private JMenuBar getBarraMenu() {
    	if (BarraMenu == null){
    		BarraMenu = new JMenuBar();
    		BarraMenu.add(getMnuJogo());
        BarraMenu.add(getMnuMapas());
        BarraMenu.add(getMnuHelper());
    	}
    	return BarraMenu;
    }
    
    private JMenu getMnuJogo() {
    	if (mnuJogo == null){
    		mnuJogo = new JMenu();
    		mnuJogo.setText("Jogo");
        mnuJogo.add(getMnuNovo());
    		mnuJogo.add(getMnuSair());
    	}
    	return mnuJogo;
    }

    private JMenuItem getMnuNovo() {
    	if (mnuNovo == null){
    		mnuNovo = new JMenuItem();
    		mnuNovo.setText("Novo Jogo");
        mnuNovo.addActionListener(this);
    	}
    	return mnuNovo;
    }
    
    private JMenuItem getMnuSair() {
    	if (mnuSair == null){
    		mnuSair = new JMenuItem();
    		mnuSair.setText("Sair");
        mnuSair.addActionListener(this);
    	}
    	return mnuSair;
    }

    private JMenu getMnuMapas() {
    	if (mnuMapas == null){
    		mnuMapas = new JMenu();
    		mnuMapas.setText("Mapas");
        mnuMapas.add(getMnuMapaPlayer());
    		mnuMapas.add(getMnuMapaComputador());
    	}
    	return mnuMapas;
    }

    private JMenuItem getMnuMapaPlayer() {
    	if (mnuMapaPlayer == null){
    		mnuMapaPlayer = new JMenuItem();
    		mnuMapaPlayer.setText("Mapa Player");
        mnuMapaPlayer.addActionListener(this);
    	}
    	return mnuMapaPlayer;
    }
    
    private JMenuItem getMnuMapaComputador() {
    	if (mnuMapaComputador == null){
    		mnuMapaComputador = new JMenuItem();
    		mnuMapaComputador.setText("Mapa Computador");
        mnuMapaComputador.addActionListener(this);
    	}
    	return mnuMapaComputador;
    }

    private JMenu getMnuHelper() {
    	if (mnuHelper == null){
    		mnuHelper = new JMenu();
    		mnuHelper.setText("Helper");
        mnuHelper.add(getMnuNovaJogada());
    		mnuHelper.add(getMnuTiros());
    	}
    	return mnuHelper;
    }

    private JMenuItem getMnuNovaJogada() {
    	if (mnuNovaJogada == null){
    		mnuNovaJogada = new JMenuItem();
    		mnuNovaJogada.setText("Nova Jogada");
        mnuNovaJogada.addActionListener(this);
    	}
    	return mnuNovaJogada;
    }
    
    private JMenuItem getMnuTiros() {
    	if (mnuTiros == null){
    		mnuTiros = new JMenuItem();
    		mnuTiros.setText("Tiros Executados");
        mnuTiros.addActionListener(this);
    	}
    	return mnuTiros;
    }
  
    public void actionPerformed(ActionEvent e){
      if(e.getSource() == mnuNovo){
        System.out.println("Novo Jogo");
        game = new DotComBust();
      }
      if(e.getSource() == mnuSair){
        showMessageDialog(null, "Sair");
        game.finishGame();
        System.exit(0);
      }
      if(e.getSource() == mnuMapaPlayer){
        System.out.println("Mapa Player 1");
        game.PlayerOne.getGrid().printGridGui();
      }
      if(e.getSource() == mnuMapaComputador){
        System.out.println("Mapa Player 2");
        game.PlayerTwo.getGrid().printGridGuiInimigo();
      }
      if(e.getSource() == mnuNovaJogada){
        System.out.println("Nova Jogada");
        game.turn();
      }
      if(e.getSource() == mnuTiros){
        showMessageDialog(null, "Tiros Efetuados: Player One - " + game.countPlayerOne + " jogadas e Player Two - " + game.countPlayerTwo + " jogadas");
      }
    }
}