/*Class PokerDeck has the the functions to 
 * initialize an new deck of ordered 52 cards, 
 * shuffle it to reorder the cards, 
 * get the top card and remove it, 
 * show what the card is.
 * we use arraylist to store the cards.
 */
package ArizonaHoldEmLogic;
import java.util.ArrayList;

public class PokerDeck {
	private ArrayList <Card> deck;

	//add all the 52 cards into the deck in order
	public PokerDeck(){
			deck = new ArrayList <> ();
			deck.add(new Card(Rank.Deuce, Suit.Clubs));
			deck.add(new Card(Rank.Three, Suit.Clubs));
			deck.add(new Card(Rank.Four, Suit.Clubs));
			deck.add(new Card(Rank.Five, Suit.Clubs));
			deck.add(new Card(Rank.Six, Suit.Clubs));
			deck.add(new Card(Rank.Seven, Suit.Clubs));
			deck.add(new Card(Rank.Eight, Suit.Clubs));
			deck.add(new Card(Rank.Nine, Suit.Clubs));
			deck.add(new Card(Rank.Ten, Suit.Clubs));
			deck.add(new Card(Rank.Jack, Suit.Clubs));
			deck.add(new Card(Rank.Queen, Suit.Clubs));
			deck.add(new Card(Rank.King, Suit.Clubs));
			deck.add(new Card(Rank.Ace, Suit.Clubs));
			
			deck.add(new Card(Rank.Deuce, Suit.Diamonds));
			deck.add(new Card(Rank.Three, Suit.Diamonds));
			deck.add(new Card(Rank.Four, Suit.Diamonds));
			deck.add(new Card(Rank.Five, Suit.Diamonds));
			deck.add(new Card(Rank.Six, Suit.Diamonds));
			deck.add(new Card(Rank.Seven, Suit.Diamonds));
			deck.add(new Card(Rank.Eight, Suit.Diamonds));
			deck.add(new Card(Rank.Nine, Suit.Diamonds));
			deck.add(new Card(Rank.Ten, Suit.Diamonds));
			deck.add(new Card(Rank.Jack, Suit.Diamonds));
			deck.add(new Card(Rank.Queen, Suit.Diamonds));
			deck.add(new Card(Rank.King, Suit.Diamonds));
			deck.add(new Card(Rank.Ace, Suit.Diamonds));
			
			deck.add(new Card(Rank.Deuce, Suit.Hearts));
			deck.add(new Card(Rank.Three, Suit.Hearts));
			deck.add(new Card(Rank.Four, Suit.Hearts));
			deck.add(new Card(Rank.Five, Suit.Hearts));
			deck.add(new Card(Rank.Six, Suit.Hearts));
			deck.add(new Card(Rank.Seven, Suit.Hearts));
			deck.add(new Card(Rank.Eight, Suit.Hearts));
			deck.add(new Card(Rank.Nine, Suit.Hearts));
			deck.add(new Card(Rank.Ten, Suit.Hearts));
			deck.add(new Card(Rank.Jack, Suit.Hearts));
			deck.add(new Card(Rank.Queen, Suit.Hearts));
			deck.add(new Card(Rank.King, Suit.Hearts));
			deck.add(new Card(Rank.Ace, Suit.Hearts));
			
			deck.add(new Card(Rank.Deuce, Suit.Spades));
			deck.add(new Card(Rank.Three, Suit.Spades));
			deck.add(new Card(Rank.Four, Suit.Spades));
			deck.add(new Card(Rank.Five, Suit.Spades));
			deck.add(new Card(Rank.Six, Suit.Spades));
			deck.add(new Card(Rank.Seven, Suit.Spades));
			deck.add(new Card(Rank.Eight, Suit.Spades));
			deck.add(new Card(Rank.Nine, Suit.Spades));
			deck.add(new Card(Rank.Ten, Suit.Spades));
			deck.add(new Card(Rank.Jack, Suit.Spades));
			deck.add(new Card(Rank.Queen, Suit.Spades));
			deck.add(new Card(Rank.King, Suit.Spades));
			deck.add(new Card(Rank.Ace, Suit.Spades));
			
	}
	
	//shuffle the deck, reorder the 52 cards
	public void shuffle() {
		ArrayList <Card> deckTemp = new ArrayList <> (); 
		for(; deck.size()!= 0 ;){
			int j = (int)(Math.random()*(deck.size()));
			deckTemp.add(deck.get(j));
			deck.remove(j);
		}
		deck = deckTemp;
	}
	
	//the getter of the arraylist deck
	public ArrayList<Card> getDeck(){
		return deck;
	}

	//show the card in string form
	public String whatCard(Card card) {
		String whatCard = card.whatCard(card);
		return whatCard;
	}

	//get the top card of the deck, and remove the card from the deck
	public Card getTopCard() {
		Card tempCard = new Card();
		tempCard = deck.get(0);
		deck.remove(0);
		return tempCard;
	}	
}
