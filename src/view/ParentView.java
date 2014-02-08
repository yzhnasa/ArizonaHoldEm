package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ParentView extends JFrame {
	protected JPanel panelOfPlayer1;
	protected JPanel panelOfPlayer2;
	protected JPanel panelOfPlayer3;
	protected JPanel panelOfPlayer4;
	protected JPanel panelOfPot;
	private JPanel buttonPanel1;
	private JPanel buttonPanel2;
	
	private JButton newRound;
	private JButton quit;
	private JButton bet;
	private JButton fold;
	
	private JTextField pot;
	private JTextField blanceOfPlayer1;
	private JTextField blanceOfPlayer2;
	private JTextField blanceOfPlayer3;
	private JTextField blanceOfPlayer4;
	
	public ParentView(){
		this.setSize(1200, 800);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		
		initializePanelOfPlayer1();//Player1 is a real person.
		initializePanelOfPlayer2();
		initializePanelOfPlayer3();
		initializePanelOfPlayer4();
		initializePanelOfPot();
		
		this.add(panelOfPlayer1, BorderLayout.SOUTH);
		this.add(panelOfPlayer2, BorderLayout.WEST);
		this.add(panelOfPlayer3, BorderLayout.NORTH);
		this.add(panelOfPlayer4, BorderLayout.EAST);
		this.add(panelOfPot, BorderLayout.CENTER);
	}

	private void initializePanelOfPot() {
		panelOfPot = new JPanel();
		panelOfPot.setPreferredSize(new Dimension(800, 400));
		panelOfPot.setLayout(new GridLayout(1, 6));
		pot = new JTextField();
		pot.setEditable(false);
		pot.setText("0.0");;
		panelOfPot.add(pot, 1);
	}

	private void initializePanelOfPlayer4() {
		panelOfPlayer4 = new JPanel();
		panelOfPlayer4.setSize(200, 600);
		panelOfPlayer4.setLayout(new GridLayout(2, 1));
		
		JPanel panelOfBlance = new JPanel();
		panelOfBlance.setPreferredSize(new Dimension(200, 100));
		blanceOfPlayer4 = new JTextField();
		blanceOfPlayer4.setEditable(false);
		blanceOfPlayer4.setText("100.0");
		panelOfBlance.add(blanceOfPlayer4);
		panelOfPlayer4.add(panelOfBlance, 2);
	}

	private void initializePanelOfPlayer3() {
		panelOfPlayer3 = new JPanel();
		panelOfPlayer3.setSize(200, 600);
		panelOfPlayer3.setLayout(new GridLayout(1, 2));
		
		JPanel panelOfBlance = new JPanel();
		panelOfBlance.setPreferredSize(new Dimension(100, 200));
		blanceOfPlayer3 = new JTextField();
		blanceOfPlayer3.setEditable(false);
		blanceOfPlayer3.setText("100.0");
		panelOfBlance.add(blanceOfPlayer3);
		panelOfPlayer3.add(panelOfBlance, 2);
	}

	private void initializePanelOfPlayer2() {
		panelOfPlayer2 = new JPanel();
		panelOfPlayer2.setSize(200, 600);
		panelOfPlayer2.setLayout(new GridLayout(2, 1));
		
		JPanel panelOfBlance = new JPanel();
		panelOfBlance.setPreferredSize(new Dimension(200, 100));
		blanceOfPlayer2 = new JTextField();
		blanceOfPlayer2.setEditable(false);
		blanceOfPlayer2.setText("100.0");
		panelOfBlance.add(blanceOfPlayer2);
		panelOfPlayer2.add(panelOfBlance, 1);
	}

	private void initializePanelOfPlayer1() {
		panelOfPlayer1 = new JPanel();
		panelOfPlayer1.setPreferredSize(new Dimension(1200, 200));
		
		buttonPanel1 = new JPanel();
		buttonPanel1.setPreferredSize(new Dimension(200, 200));
		buttonPanel1.setLayout(new GridLayout(3, 1));
		blanceOfPlayer1 = new JTextField();
		blanceOfPlayer1.setEditable(false);
		blanceOfPlayer1.setText("100.0");
		buttonPanel1.add(blanceOfPlayer1);
		bet = new JButton("Bet");
		buttonPanel1.add(bet);
		fold = new JButton("Fold");
		buttonPanel1.add(fold);
		
		buttonPanel2 = new JPanel();
		buttonPanel2.setPreferredSize(new Dimension(200, 200));
		buttonPanel2.setLayout(new GridLayout(2, 1));
		quit = new JButton("Quit");
		buttonPanel2.add(quit);
		newRound = new JButton("New Round");
		buttonPanel2.add(newRound);
		
		panelOfPlayer1.setLayout(new GridLayout(1, 3));
		panelOfPlayer1.add(buttonPanel1, 1);
		panelOfPlayer1.add(buttonPanel1, 3);
	}
	
	public static void main(String[] args){
		ParentView view = new ParentView();
		view.setVisible(true);
	}
}
