package Game;
import javax.swing.JFrame;

import ArizonaHoldEmLogic.*;
import view.*;

public class ArizonaHoldEmGame extends JFrame{
	protected RootPanel rootPanel;
	public ArizonaHoldEmGame(){
		this.setSize(1000,800);
		rootPanel = new RootPanel();
		this.add(rootPanel);
	}
	public static void main(String[] args){
		ArizonaHoldEmGame newGame = new ArizonaHoldEmGame();
		newGame.setVisible(true);
		newGame.gameBegin();
	}
	
	public void gameBegin(){
		Dealer dealer = new Dealer();
		dealer.newDeck();
		dealer.collectAntes(4);
		dealer.getDeck().shuffle();
		dealer.setCommunityCards();
		rootPanel.setCommunityPanel(dealer.getCommunityCards());
	}
}
