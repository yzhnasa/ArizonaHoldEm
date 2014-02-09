package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

import ArizonaHoldEmLogic.Card;

public class PlayerPanel extends JPanel{
	private Image image1;
	private Image image2;
	
	public PlayerPanel(){
		
	}
	
	public void setPlayerPanelCards(ArrayList<Card> twoCards){
		image1 = twoCards.get(0).getCardImage();
		image2 = twoCards.get(1).getCardImage();
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(image1, 5, 5, this);
		g2.drawImage(image2, 45, 5, this);
	}
}
