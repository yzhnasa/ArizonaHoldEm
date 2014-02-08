/* Class Dealer has the function to
 * collect the antes to a pot at beginning of each round,
 * split the pot according to the number of winner,
 * record the players to a list,
 * deal two cards for each player,
 * deal the five community cards,
 * show the community cards in string form
 * sort the players from worst hand to best hand
 * pick the winners and them to a list
 */
package ArizonaHoldEmLogic;
import java.util.ArrayList;
import java.util.Collections;

public class Dealer {
	private float pot;
	private PokerDeck deck;
	private ArrayList<Card> communityCards = new ArrayList<>();
	private ArrayList<Card> twoCards = new ArrayList<>();
	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<Player> winnerList = new ArrayList<>();
	
	//collect the antes at the start of each game, the pot = 2 * the number of players
	public void collectAntes(int i) {
		pot = 2.00f*i;
	}
	
	// the getter of pot
	public float showPot() {
		return pot;
	}
	
	//split the pot based on the number of players
	public float splitPort(int winnerNum) {
		float winMoney = pot/winnerNum;
		return winMoney;
	}
		
	
	//add player to the player list
	public  ArrayList<Player> addPlayers(ArrayList<Player> players){
		this.players.clear();
		this.players = players;
		return players;
	}
	
	//the getter of the deck
	public PokerDeck getDeck(){
		return deck;
	}
	
	//set up a new deck
		public void newDeck() {
			deck = new PokerDeck();
		}
		
	//the setter of the two cards for each player
	public void setTwoCards() {
		twoCards.clear();
		Card tempCard = new Card();
		for(int i = 0; i < 2; i++){
			tempCard = deck.getTopCard();
			twoCards.add(tempCard);
		}
	}
	
	//the getter of the two cards
	public ArrayList<Card> getTwoCards(){
		ArrayList<Card> tempTwoCards = new ArrayList<>();
		tempTwoCards.addAll(twoCards);
		twoCards.clear();
		return tempTwoCards;
	}	
	
	//the setter of the community card
	public void setCommunityCards() {		
		communityCards.clear();
		Card tempCard = new Card();
		for(int i = 0; i < 5; i++){
			tempCard = deck.getTopCard();
			communityCards.add(tempCard);
		}
	}
	
	//the getter of the community cards
	public ArrayList<Card> getCommunityCards() {
		return communityCards;
	}
	
	//the method to generate a string form of the five community cards
	public String showCommunitycard() {
		String CardsName;
		CardsName = communityCards.get(0).whatCard(communityCards.get(0)) + " ";
		for(int i=1; i < 5; i++){
			CardsName += communityCards.get(i).whatCard(communityCards.get(i)) + " ";
		}
		return CardsName;
	}
		
	//sort the players from the worst hand to best hand 
	public ArrayList<Player> winner(){
		Collections.sort(players);
		return players;
	}

	//generate a list of players who win the game	
	public void setWinnerList() {
		winnerList.clear();
		int j = players.size();
		winnerList.add(players.get(j-1));
		while((players.get(j-1)).compareTo(players.get(j-2)) == 0){
			winnerList.add(players.get(j-2));
			j--;
		}
		
	}
	
	//the getter of winnerlist
	public ArrayList<Player> getWinnerList() {
		return winnerList;
	}	
}
