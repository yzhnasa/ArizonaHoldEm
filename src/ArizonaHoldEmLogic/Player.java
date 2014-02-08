/*Class Player has the function to
 * Generate a new player getting its name from the input and set his original balance to 100;
 * bet 2.0 ante at the beginning of each round;
 * add his balance when win the game;
 * get the two cards from the dealer;
 * show the two cards in string form;
 * get the five communitycards from the dealer;
 * combine the two cards and five community cards and get the 21 possible combinations of the pokerhands;
 * choose the best poker hand;
 * check the best pokerhand;
 * sort method of players based on their best hand;
 */
package ArizonaHoldEmLogic;
import java.util.ArrayList;

public class Player implements Comparable<Player>{
	private String name;
	private float balance;
	private ArrayList<Card> twoCards = new ArrayList<>();
	private ArrayList<Card> communityCards = new ArrayList<>();
	private ArrayList<Card> sevenCards = new ArrayList<>();
	private ArrayList<PokerHand> pokerHands21 = new ArrayList<>();
	private PokerHand bestHand;

	//initiate a player, set his name and give him a balance of 100
	public Player(String name){
		this.name = name;
		balance = 100.00f;
	}

	//the getter of the name
	public String getName() {
		return name;
	}
	
	//the getter of the balance
	public float getBalance() {
		return balance;
	}

	//take 2.00 ante out of balance at start of every game
	public void bet() {
		balance -= 2.00f;
	}
	
	//add the winMoney to balance if win the game
	public void addBalance(float winMoney) {
		balance += winMoney;
	}
	
	//get two cards from the dealer
	public void setTwoCards(Dealer dealer) {
		twoCards.clear();
		twoCards = dealer.getTwoCards();
	}

	//the getter of the twoCards
	public ArrayList<Card> getTwoCards() {
		return twoCards;
	}
	
	//the method to show the two cards in string form
	public String showTwoCards() {
		String twoCards;
		twoCards = this.twoCards.get(0).whatCard(this.twoCards.get(0)) + " ";
		twoCards += this.twoCards.get(1).whatCard(this.twoCards.get(1));
		return twoCards;
	}
	
	//get community cards from the dealer
	public void setCommunityCards(Dealer dealer) {
		communityCards.clear();
		communityCards = dealer.getCommunityCards();
	}
	
	//the getter of the community cards
	public ArrayList<Card> getCommunityCards() {
		return communityCards;
	}
	
	//combine the two cards and five community cards to one arraylist
	public void setCombineedCards() {
		sevenCards.clear();
		sevenCards.addAll(twoCards);
		sevenCards.addAll(communityCards);
	}

	//the getter of sevenCards
	public ArrayList<Card> getCombinedCard() {
		return sevenCards;
	}

	/*find out all 21 possible pokerhands and store them in a list
	 * we look the seven cards in a round order, which means 1,2,3,4,5,6,7,1,2,3,....
	 * the method we use to pick the five cards is done by three cases:
	 * case1, choose five consecutive cards, like: 
	 * 1,2,3,4,5; 2,3,4,5,6; 3,4,5,6,7; 4,5,6,7,1;.....; 7 combinations
	 * case2, choose four consecutive cards, skip one, add the next, like:
	 * 1,2,3,4,6; 2,3,4,5,7; 3,4,5,6,1; 4,5,6,7,2;.....; 7 combinations
	 * case3, choose three consecutive cards, skip one, add the next, skip one again  like:
	 * 1,2,3,6,7; 2,3,4,6,7; 3,4,5,7,1; 4,5,6,1,2; ...; 7 combinations;
	 * and 21 combinations in total;
	*/
		
		public void setPokerHands21() {
			pokerHands21.clear();
			for(int i = 0; i < 7; i++){
				PokerHand tempHand = new PokerHand(sevenCards.get(i),
						sevenCards.get((i+1)%7),
						sevenCards.get((i+2)%7),
						sevenCards.get((i+3)%7),
						sevenCards.get((i+4)%7));
				pokerHands21.add(tempHand);
			}
			for(int i = 0; i < 7; i++){
				 PokerHand tempHand = new PokerHand(sevenCards.get(i),
						sevenCards.get((i+1)%7),
						sevenCards.get((i+2)%7),
						sevenCards.get((i+3)%7),
						sevenCards.get((i+5)%7));
				 pokerHands21.add(tempHand);
			 }
			 
			 for(int i = 0; i < 7; i++){
				 PokerHand tempHand = new PokerHand(sevenCards.get(i),
						sevenCards.get((i+1)%7),
						sevenCards.get((i+2)%7),
						sevenCards.get((i+4)%7),
						sevenCards.get((i+5)%7));
				 pokerHands21.add(tempHand);
			 }
		}
	
	//the getter pf pokerHands21	
	public ArrayList<PokerHand> getPokerHands21() {
			return pokerHands21;
	}	
	
	
	//compare all the 21 pokerhands and choose the best hand
	public void chooseBestHand(){
		bestHand = new PokerHand(sevenCards.get(0),
					sevenCards.get(1),
					sevenCards.get(2),
					sevenCards.get(3),
					sevenCards.get(4));
		 for(PokerHand p : pokerHands21){
			 if(bestHand.compareTo(p) < 0){
				 bestHand = p;
			 }
		 }
	}
	
	//the getter of the bestHand
	public PokerHand showBestHand(){
		return bestHand;
	}
	
	//compare the best hand to all the 21 pokerhands to see if it is the greatest hand
	public boolean ifBestHand(){
		for(PokerHand p : pokerHands21){
			if(p.compareTo(bestHand) > 0){
				return false;
			}
		}
		return true;
	}
	
	//rewrite the compareTo method to compare the player according to their best hand
	public int compareTo(Player anotherPlayer){
		if(this.showBestHand().compareTo(anotherPlayer.showBestHand()) > 0){
			return 1;
		}
		else if(this.showBestHand().compareTo(anotherPlayer.showBestHand()) < 0){
			return -1;	
		}
		return 0;
	}
	
	


	
}
