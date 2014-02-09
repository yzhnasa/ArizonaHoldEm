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
		//newGame.setVisible(true);
	}
	
	public void gameBegin(){
		Dealer dealer = new Dealer();
		dealer.newDeck();
		dealer.collectAntes(4);
		dealer.getDeck().shuffle();
		dealer.setCommunityCards();
		rootPanel.setPotPanel(dealer.getCommunityCards());
		//Player realPerson = new Player();
		//realPerson.setCommunityCards(dealer);
		//rootPanel.setRealPersonPanel(dealer.getTwoCards());
		//rootPanel.setBotPanel1(dealer.getTwoCards());
		//rootPanel.setBotPanel2(dealer.getTwoCards());
		//rootPanel.setBotPanel3(dealer.getTwoCards());
	}
}
