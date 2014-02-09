package view;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ArizonaHoldEmLogic.Card;

public class RootPanel extends JPanel {
	protected PlayerPanel realPersonPanel;
	protected PlayerPanel botPanel1;
	protected PlayerPanel botPanel2;
	protected PlayerPanel botPanel3;
	protected PotPanel potPanel;
	private JPanel buttonPanel;
	
	private JButton newRound;
	private JButton quit;
	private JButton bet;
	private JButton fold;
	
	private JTextField pot;
	private JTextField blanceOfPlayer;
	private JTextField blanceOfBot1;
	private JTextField blanceOfBot2;
	private JTextField blanceOfBot3;
	
	public RootPanel(){
		this.setSize(1000, 800);
		this.setLayout(new GridLayout(3,3));
		this.setVisible(true);
		
		initializePanels();
		
		add(new JPanel());
		add(botPanel1);
		add(new JPanel());
		add(botPanel2);
		add(potPanel);
		add(botPanel3);
		add(new JPanel());
		add(realPersonPanel);
		add(buttonPanel);
	}
	
	private void initializePanels(){
		initializePanelOfPlayer();//Player1 is a real person.
		initializePanelOfBot1();
		initializePanelOfBot2();
		initializePanelOfBot3();
		initializePanelOfPot();
		initializeButtonPanel();
	}

	private void initializeButtonPanel() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 2));
		newRound = new JButton("New Button");
		quit = new JButton("Quit");
		bet = new JButton("Bet");
		fold = new JButton("Fold");
		buttonPanel.add(newRound);
		buttonPanel.add(quit);
		buttonPanel.add(bet);
		buttonPanel.add(fold);
	}

	private void initializePanelOfPot() {
		//potPanel = new JPanel();
		potPanel = new PotPanel();
		potPanel.setLayout(new GridLayout(1, 2));
	}
	
	private void initializePanelOfBot3() {
		botPanel3 = new PlayerPanel();
		botPanel3.setLayout(new GridLayout(1, 2));
	}
	

	private void initializePanelOfBot2() {
		botPanel1 = new PlayerPanel();
		botPanel1.setLayout(new GridLayout(1, 2));
	}

	private void initializePanelOfBot1() {
		botPanel2 = new PlayerPanel();
		botPanel2.setLayout(new GridLayout(1, 2));
	}

	private void initializePanelOfPlayer() {
		realPersonPanel = new PlayerPanel();
		realPersonPanel.setLayout(new GridLayout(1, 2));
		panelCard card1 = new panelCard();
		panelCard card2 = new panelCard();
		realPersonPanel.add(card1);
		realPersonPanel.add(card2);
		
	}
	

	public void setPotPanel(ArrayList<Card> communityCards) {
		//potPanel = new PotPanel(communityCards);
		//potPanel.setVisible(true);
		potPanel.setPotPanelCards(communityCards);
		potPanel.repaint();
		//potPanel.validate();
	}
	
	public void setRealPersonPanel(ArrayList<Card> twoCards){
		realPersonPanel.setPlayerPanelCards(twoCards);
		realPersonPanel.repaint();
	}

	public void setBotPanel1(ArrayList<Card> twoCards) {
		botPanel1.setPlayerPanelCards(twoCards);
		botPanel1.repaint();
	}

	public void setBotPanel2(ArrayList<Card> twoCards) {
		botPanel2.setPlayerPanelCards(twoCards);
		botPanel2.repaint();
	}

	public void setBotPanel3(ArrayList<Card> twoCards) {
		botPanel3.setPlayerPanelCards(twoCards);
		botPanel3.repaint();
	}
}
