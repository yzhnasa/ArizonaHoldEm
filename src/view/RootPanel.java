package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ArizonaHoldEmLogic.Card;

public class RootPanel extends JPanel {
	protected JPanel panelOfPlayer;
	protected JPanel panelOfBot1;
	protected JPanel panelOfBot2;
	protected JPanel panelOfBot3;
	protected JPanel potPanel;
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
		add(panelOfBot1);
		add(new JPanel());
		add(panelOfBot2);
		add(potPanel);
		add(panelOfBot3);
		add(new JPanel());
		add(panelOfPlayer);
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

	private void initializePanelOfPot() {
		potPanel = new JPanel();
		
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

	private void setPotPanel(ArrayList<Card> communityCards) {
		potPanel = new potPanel(communityCards);
		
	}
	
	private JPanel getpotPanel(){
		return potPanel;
	}

	private void initializePanelOfBot3() {
		panelOfBot3 = new JPanel();
		panelOfBot3.setLayout(new GridLayout(1, 2));
	}
	

	private void initializePanelOfBot2() {
		panelOfBot1 = new JPanel();
		panelOfBot1.setLayout(new GridLayout(1, 2));
	}

	private void initializePanelOfBot1() {
		panelOfBot2 = new JPanel();
		panelOfBot2.setLayout(new GridLayout(1, 2));
	}

	private void initializePanelOfPlayer() {
		panelOfPlayer = new JPanel();
		panelOfPlayer.setLayout(new GridLayout(1, 2));
		panelCard card1 = new panelCard();
		panelCard card2 = new panelCard();
		panelOfPlayer.add(card1);
		panelOfPlayer.add(card2);
		
	}

	public void setCommunityPanel(ArrayList<Card> communityCards) {
		
		
	}
	
	public JPanel getPanelOfPlayer(){
		return panelOfPlayer;
	}
	
	public JPanel getpanelOfBot1(){
		return panelOfBot1;
	}
	
	public JPanel getpanelOfBot2(){
		return panelOfBot2;
	}
	
	public JPanel getpanelOfBot3(){
		return panelOfBot3;
	}
	
	public JPanel getPotPanel(){
		return potPanel;
	}
	
	public JPanel getButtonPanel(){
		return buttonPanel;
	}
}
