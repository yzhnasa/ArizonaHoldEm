/* Create a card class, build the constructor to import rank and suit to the card.
 * Declare the methods to get the int value of the rank and the suit.
 * Use the sum of rank and suit to represent the value of the card, value range is [22,34]U[42,54]U[62,74]U[82,94]
 * this value will be used to judge if duplication exists.
 */
package ArizonaHoldEmLogic;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
 
public class Card {
	private Rank rank;
	private Suit suit;
	private Image cardImage; 
	
	public Card(){
		this.rank = null;
		this.rank = null;
	}
	//build constructor for class Card
	
	public Card(Rank rank, Suit suit){
		this.rank = rank;
		this.suit = suit;
		setCardImage(rank,suit);

	}
		
		
	//build a method to return the rank when needed
	
	public int getRank() {
		return rank.getRank();								
	}
	
	//build a method to return the suit when needed
	public int getSuit() {
		return suit.getSuit();
	}

	//build a method to give value to each card
	public int getValue(){
		return suit.getSuit() + rank.getRank();
	}
	
	public void setCardImage(Rank rank, Suit suit){
		int x = rank.getRank();
		int y = suit.getSuit()/20;
		int cardNumber = (14-x)*4+y;
		try
		{
			cardImage = ImageIO.read(new File("cardImages" + File.separator + cardNumber + ".png"));
		} catch (IOException e) {
			System.out.println("Failed to read filename");
		}
	}
	public Image getCardImage(){
		return cardImage;
	}
	//this method is use to give the card name to the card, so we can print the card when need to
	//it is based on the the value of suit and rank.
	public String whatCard(Card card){
		int cardSuit = card.getSuit();
		int cardRank = card.getRank();
		String stringRank;
		switch (cardRank){
			case 11: stringRank = "J";
			break;
			case 12: stringRank = "Q";
			break;
			case 13: stringRank = "K";
			break;
			case 14: stringRank = "A";
			break;
			default: stringRank = String.valueOf(cardRank);
			break;
		}
		
		String cardName;
		switch (cardSuit) {
			case 20: cardName = stringRank + "D";
			break;
			case 40: cardName = stringRank + "C";
			break;
			case 60: cardName = stringRank + "H";
			break;
			default: cardName = stringRank + "S";
			break;			
		}
		return cardName;
	}
}
