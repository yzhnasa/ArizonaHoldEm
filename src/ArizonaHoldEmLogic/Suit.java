/* Create a enum class for the Suits, in the order "Diamonds, Clubs, Hearts, Spades";
 * Buld a constructor, gives each suit an int value, the value difference is 20, which is bigger than 14,
 * will be used in the compare method;
 * Declare a getter to return the int value of suit.
 */
package ArizonaHoldEmLogic;
public enum Suit {
	Diamonds(80), Clubs(20), Hearts(60), Spades(40);
	
	private int suit = 0;//set each suit an int
	Suit(int suit){
		this.suit = suit;
	}
	
	public int getSuit(){
		//method to get suit
		return suit;
	}
}
