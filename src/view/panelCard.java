package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

import ArizonaHoldEmLogic.*;

public class panelCard extends JPanel{
	private Card card1;
	private Card card2;
	private Image image1;
	private Image image2;
	
	public panelCard(){
		card1 = new Card(Rank.Ace, Suit.Clubs);
		card2 = new Card(Rank.Five,Suit.Spades);
		image1 = card1.getCardImage();
		image2 = card2.getCardImage();
	}
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image1, 5, 5, 50, 50, this);
		g2.drawImage(image2, 100, 5, 50, 50, this);
	}
}

