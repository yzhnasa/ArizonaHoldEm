package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

import ArizonaHoldEmLogic.Card;

public class potPanel extends JPanel {
	
	private Image image1;
	private Image image2;
	private Image image3;
	private Image image4;
	private Image image5;
	
	public potPanel(ArrayList<Card> communityCards) {
		image1 = communityCards.get(0).getCardImage();
		image2 = communityCards.get(1).getCardImage();
		image3 = communityCards.get(2).getCardImage();
		image4 = communityCards.get(3).getCardImage();
		image5 = communityCards.get(4).getCardImage();
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image1, 5, 5, 50, 50, this);
		g2.drawImage(image2, 45, 5, 50, 50, this);
		g2.drawImage(image3, 85, 5, 50, 50, this);
		g2.drawImage(image4, 125, 5, 50, 50, this);
		g2.drawImage(image5, 165, 5, 50, 50, this);
	
}
