
/* Implements Comparable Interface to class PokerHand, overwrite the CompareTo() method;
 * 
 * In the constructor, get the suit value, rank value and card value for each of the five cards, store the value 
 * in arrays, reorder the card from largest to smallest based on the rank value;
 * 
 * Based on the card value, judge if there is duplicate cards in one PokerHand, throws DuplicateCardException if there are;
 * 
 * Based on the suit value and rank value of the cards in one hand, define what kind of hand the Pokerhand is, 
 * use variable "ranking" to represent the kind;
 * Based on the kind of the PokerHand, initiate some variables(sameKind1, sameKind2, singleRank, ...) for the hand, which will
 * be used in the compareTo() method;
 *  
 * In the compareTo() method, judge if there are duplicate cards in two PokerHands, throws DuplicateCardException if there are;
 * 
 * Compare the kind of the PokeHands based on the ranking value of each PokerHand, if the two PokerHand are of the same kind, 
 * compare their variables based on their kind. 
 */
package ArizonaHoldEmLogic;
public class PokerHand implements Comparable<PokerHand> {
	private Card A1;
	private Card A2;
	private Card A3;
	private Card A4;
	private Card A5;
	// get the value of each card, the cardValue will be used to detect duplicate cards
	int [] cardValue = new int[5];
	
	//build constructor for Class PokerHand
	public PokerHand(Card A1, Card A2, Card A3, Card A4, Card A5){
		cardValue[0] = A1.getValue();
		cardValue[1] = A2.getValue();
		cardValue[2] = A3.getValue();
		cardValue[3] = A4.getValue();
		cardValue[4] = A5.getValue();
		
		try{
			ifDupInOneHand(); // to detect if there are two or more duplicate cards in this hand
			this.A1 = A1;
			this.A2 = A2;
			this.A3 = A3;
			this.A4 = A4;
			this.A5 = A5;
			handSort(); // sort the hand 
		}catch(DuplicateCardException Ex){
			System.out.println("duplicate in this one PokerHands");
			throw Ex;
			}
		}
	
	public void ifDupInOneHand() throws DuplicateCardException{
		for(int i=0; i < 5; i++){
			for(int j = i+1; j < 5; j++){
				if(cardValue[i] == cardValue[j]){
					throw new DuplicateCardException();
				}
			}
		}
	}
	
	
	//this method initialize a string variable to show the five cards of one pokerhand
	String FiveCards;
	public void setCardsName(){
		FiveCards = A1.whatCard(A1) + " ";
		FiveCards += A2.whatCard(A2) + " ";
		FiveCards += A3.whatCard(A3) + " ";
		FiveCards += A4.whatCard(A4) + " ";
		FiveCards += A5.whatCard(A5);
	}
	
	//this is the getter of the string FiveCards
	public String getCardsName(){
		return FiveCards;
	}
		
	/*get each card's suit value and rank value
	*compare the values to decide the pokerhand's ranking
	*start from detecting if the hands is straight flush, if true initiate the parameters of the hand, if false
	*detect if it is four of a kind, ....., until nothing
	*/
	private void handSort(){
		suitSort();
		rankSort();
		ifStraightFlush();
	}

	//get the suit value of each card
	int [] cardSuit = new int[5];
	private void suitSort(){
		cardSuit[0] = A1.getSuit();
		cardSuit[1] = A2.getSuit();
		cardSuit[2] = A3.getSuit();
		cardSuit[3] = A4.getSuit();
		cardSuit[4] = A5.getSuit();
	}
	
	//get the rank value of each card and sort the card from the largest rank to smallest rank
	int [] cardRank = new int[5];
	private void rankSort(){
		cardRank[0] = A1.getRank();
		cardRank[1] = A2.getRank();
		cardRank[2] = A3.getRank();
		cardRank[3] = A4.getRank();
		cardRank[4] = A5.getRank();
	
		//sort the card from the largest rank to smallest rank
		int temp = 0;
		for(int i = 0; i<5; i++){
			for(int j = i+1; j<5; j++){
				if(cardRank[i]<cardRank[j]){
					temp = cardRank[i];
					cardRank[i] = cardRank[j];
					cardRank[j] = temp;
				}
			}
		}
	}
	

	/* use ranking for the ranking of the hands; 
	 * use sameKind1 for the rank of the same kind cards 1.in Four of A Kind; 2.the three in Full House; 
	 * 												3.Three of a Kind; 4.the larger ones in Two Pairs; 5. One Pair;
	 * use sameKind2 for the rank of the same kind cards 1. the two in Full House; 2. the smaller ones in Two Pairs;
	 * use singleRank1 to singleRank5 to represent the single ranks of card have no same rank in the hand,
	 * which singleRank1 is the largest, singleRank5 is the smallest
	 */
	private int ranking; 
	private int sameKind1;
	private int sameKind2;
	private int singleRank1;
	private int singleRank2;
	private int singleRank3;
	private int singleRank4;
	private int singleRank5;
	
	//Straight Flush
	private void ifStraightFlush(){
		//compare the suits first, if all same suit, then two cases 
		//A 5 4 3 2, or
		//cardRank[0] = cardrank[1] + 1 = cardRank[2] + 2 = cardRank[3] + 3 = cardRank[4] + 4
		//if not straight flush, then test if four of a kind
		if (cardSuit[0] == cardSuit[1] && cardSuit[1] == cardSuit[2] && cardSuit[2] == cardSuit[3] 
				&& cardSuit[3] == cardSuit[4]){
			if(cardRank[0] == 14 && cardRank[1] == 5 && cardRank[2] == 4 && cardRank[3] == 3 && cardRank[4] == 2){
				ranking = 9;
				singleRank1 = cardRank[1];
			}else if (cardRank[0] == (cardRank[1] + 1) && cardRank[1] == (cardRank[2] + 1) 
					&& cardRank[2] == (cardRank[3] + 1) && cardRank[3] == (cardRank[4] + 1) ){
				ranking = 9;
				singleRank1 = cardRank[0];			
			}else{				
				ifFourOfAKind(); 
				}
		}else {
			ifFourOfAKind();
			}
	}

	//Four of a Kind
	private void ifFourOfAKind(){
		//because cardRank[0] >= cardRank[1] >= cardRank[2] >= cardRank[3] >= cardRank[4]
		//so just two cases of Four of a Kind: 
		//cardRank[0] = cardRank[1] = cardRank[2] = cardRank[3], or
		//cardRank[1] = cardRank[2] = cardRank[3] = cardRank[4]
		//if not four of a kind, then test if full house
		if(cardRank[0] == cardRank[1] && cardRank[1] == cardRank[2] && cardRank[2] == cardRank[3]){
			ranking = 8;
			sameKind1 = cardRank[0];
		} else if (cardRank[1] == cardRank[2] && cardRank[2] == cardRank[3] && cardRank[3] == cardRank[4]){
			ranking = 8;
			sameKind1 = cardRank[1];
		} else {
			ifFullHouse();
		}
	}
	
	//Full House
	private void ifFullHouse(){
		//two cases
		//cardRank[0] = cardRank[1] = cardRank[2] > cardRank[3] = cardRank[4],or
		//cardRank[0] = cardRank[1] > cardRank[2] = cardRank[3] = cardRank[4]
		//if not full house, test if flush
		if(cardRank[0] == cardRank[1] && cardRank[1] == cardRank[2] && cardRank[3] == cardRank[4]){
			ranking = 7;
			sameKind1 = cardRank[0];
		}else if (cardRank[0] == cardRank[1] && cardRank[2] == cardRank[3] && cardRank[3] == cardRank[4]){
			ranking = 7;
			sameKind1 = cardRank[2];
		}else{
			ifFlush();
		}
	}
	
	//Flush
	private void ifFlush(){
		//Just test if the suits are the same
		//if not flush, test if straight
		if (cardSuit[0] == cardSuit[1] && cardSuit[1] == cardSuit[2] && cardSuit[2] == cardSuit[3] 
				&& cardSuit[3] == cardSuit[4]){
			ranking = 6;
			singleRank1 = cardRank[0];
			singleRank2 = cardRank[1];
			singleRank3 = cardRank[2];
			singleRank4 = cardRank[3];
			singleRank5 = cardRank[4];
		}else{
			ifStraight();
		}
		
	}
	
	//Straight
	private void ifStraight(){
		//two cases 
		//A 5 4 3 2, or
		//cardRank[0] = cardrank[1] + 1 = cardRank[2] + 2 = cardRank[3] + 3 = cardRank[4] + 4
		//if not straight, test if three of a kind
		if(cardRank[0] == 14 && cardRank[1] == 5 && cardRank[2] == 4 && cardRank[3] == 3 && cardRank[4] == 2){
			ranking = 5;
			singleRank1 = cardRank[1];
		}else if (cardRank[0] == (cardRank[1] + 1) && cardRank[1] == (cardRank[2] + 1) 
				&& cardRank[2] == (cardRank[3] + 1) && cardRank[3] == (cardRank[4] + 1) ){
			ranking = 5;
			singleRank1 = cardRank[0];		
			}else{
				ifThreeOfAKind();
			}
		
	}
	
	//Three of a Kind
	private void ifThreeOfAKind(){
		//three cases
		//cardRank[0] = cardRank[1] = cardRank[2] > cardRank[3] > cardRank[4]
		//cardRank[0] > cardRank[1] = cardRank[2] = cardRank[3] > cardRank[4]
		//cardRank[0] > cardRank[1] > cardRank[2] = cardRank[3] = cardRank[4]
		//if not three of a kind, test if two pairs
		if(cardRank[0] == cardRank[1] && cardRank[1] == cardRank[2]){
			ranking = 4;
			sameKind1 = cardRank[0];
		}else if(cardRank[1] == cardRank[2] && cardRank[2] == cardRank[3]){
			ranking = 4;
			sameKind1 = cardRank[1];
		}else if(cardRank[2] == cardRank[3] && cardRank[3] == cardRank[4]){
			ranking = 4;
			sameKind1 = cardRank[2];
		}else{
			ifTwoPair();
		}
	}
	
	//Two Pair
	private void ifTwoPair(){
		//three cases
		//cardRank[0] = cardRank[1] > cardRank[2] = cardRank[3] > cardRank[4]
		//cardRank[0] = cardRank[1] > cardRank[2] > cardRank[3] = cardRank[4]
		//cardRank[0] > cardRank[1] = cardRank[2] > cardRank[3] = cardRank[4]
		//if not tow pair, test if one pair
		if(cardRank[0] == cardRank[1] && cardRank[2] == cardRank[3]){
			ranking = 3;
			sameKind1 = cardRank[0];
			sameKind2 = cardRank[2];
			singleRank1 = cardRank[4];
		}else if(cardRank[0] == cardRank[1] && cardRank[3] == cardRank[4]){
			ranking = 3;
			sameKind1 = cardRank[0];
			sameKind2 = cardRank[3];
			singleRank1 = cardRank[2];
		}else if(cardRank[1] == cardRank[2] && cardRank[3] == cardRank[4]){
			ranking = 3;
			sameKind1 = cardRank[1];
			sameKind2 = cardRank[3];
			singleRank1 = cardRank[0];
		}else{
			ifOnePair();
		}
	}
	
	//One Pair
	private void ifOnePair(){
		//four cases
		//cardRank[0] = cardRank[1] > cardRank[2] > cardRank[3] > cardRank[4]
		//cardRank[0] > cardRank[1] = cardRank[2] > cardRank[3] > cardRank[4]
		//cardRank[0] > cardRank[1] > cardRank[2] = cardRank[3] > cardRank[4]
		//cardRank[0] > cardRank[1] > cardRank[2] > cardRank[3] = cardRank[4]
		//if not one pair, test if nothing
		if(cardRank[0] == cardRank[1]){
			ranking = 2;
			sameKind1 = cardRank[0];
			singleRank1 = cardRank[2];
			singleRank2 = cardRank[3];
			singleRank3 = cardRank[4];
		}else if(cardRank[1] == cardRank[2]){
			ranking = 2;
			sameKind1 = cardRank[1];
			singleRank1 = cardRank[0];
			singleRank2 = cardRank[3];
			singleRank3 = cardRank[4];
		}else if(cardRank[2] == cardRank[3]){
			ranking = 2;
			sameKind1 = cardRank[2];
			singleRank1 = cardRank[0];
			singleRank2 = cardRank[1];
			singleRank3 = cardRank[4];
		}else if(cardRank[3] == cardRank[4]){
			ranking = 2;
			sameKind1 = cardRank[3];
			singleRank1 = cardRank[0];
			singleRank2 = cardRank[1];
			singleRank3 = cardRank[2];
		}else{
			ifNothing();
		}
	}
	
	//Nothing
	private void ifNothing(){
		//one case
		//cardRank[0] > cardRank[1] > cardRank[2] > cardRank[3] > cardRank[4]
		ranking = 1;
		singleRank1 = cardRank[0];
		singleRank2 = cardRank[1];
		singleRank3 = cardRank[2];
		singleRank4 = cardRank[3];
		singleRank5 = cardRank[4];
	}
	
	public int compareTo(PokerHand p){
		try{
			//check DuplicateCardException in the two hands
			//dupInTwoHands(this, p);
		}catch(DuplicateCardException dupEx){
			System.out.println("duplication in the two PokerHands");
			throw dupEx;
		}
		//compare the ranking first, the one with the higher ranking wins
		if ( this.ranking > p.ranking){
			return 1;
		}else if (this.ranking < p.ranking){
			return -1;
		}
		// if the two hands have the same ranking, then we should discuss in 9 cases
			else if(this.ranking == 9){
				//if both straight flush, compare the singleRank1
				if(this.singleRank1 > p.singleRank1){
					return 1;
				}else if(this.singleRank1 < p.singleRank1){
					return -1;
				}else{return 0;}
				}
			else if(this.ranking == 8){
				//if both four of a kind, compare smaeKind1
				if(this.sameKind1 > p.sameKind1){
					return 1;
				}else{return -1;}
			}
			else if(this.ranking == 7){
				//if both full house, compare sameKind1
				if(this.sameKind1 > p.sameKind1){
					return 1;
				}else{return -1;}
			}
			else if(this.ranking == 6){
				//if both flush, compare the singleRank1 - singRank5, once different, the larger one wins
				if(this.singleRank1 > p.singleRank1){
					return 1;
				}else if(this.singleRank1 < p.singleRank1){
					return -1;
				}else if(this.singleRank2 > p.singleRank2){
					return 1;
				}else if(this.singleRank2 < p.singleRank2){
					return -1;
				}else if(this.singleRank3 > p.singleRank3){
					return 1;
				}else if(this.singleRank3 < p.singleRank3){
					return -1;
				}else if(this.singleRank4 > p.singleRank4){
					return 1;
				}else if(this.singleRank4 < p.singleRank4){
					return -1;
				}else if(this.singleRank5 > p.singleRank5){
					return 1;
				}else if(this.singleRank5 < p.singleRank5){
					return -1;
				}else{return 0;}
			}
			else if(this.ranking == 5){
				// if both straight, compare the singleRank1
				if(this.singleRank1 > p.singleRank1){
					return 1;
				}else if(this.singleRank1 < p.singleRank1){
					return -1;
				}else{return 0;}
			}
			else if(this.ranking == 4){
				//if three of a kind, compare the sameKind1
				if(this.sameKind1 > p.sameKind1){
					return 1;
				}else{return -1;}
			}
			else if(this.ranking == 3){
				// if two pairs, compare the sameKind1 first, then the sameKind2, then the singleRank1
				if(this.sameKind1 > p.sameKind1){
					return 1;
				}else if(this.sameKind1 < p.sameKind1){
					return -1;
				}if(this.sameKind2 > p.sameKind2){
					return 1;
				}else if(this.sameKind2 < p.sameKind2){
					return -1;
				}else if(this.singleRank1 > p.singleRank1){
					return 1;
				}else if(this.singleRank1 < p.singleRank1){
					return -1;
				}else{
					return 0;
				}
			}
			else if(this.ranking == 2){
				// if one pair, compare the sameKind1 first, then the singleRank1, singleRank2,singleRank3
				if(this.sameKind1 > p.sameKind1){
					return 1;
				}else if(this.sameKind1 < p.sameKind1){
					return -1;
				}else if(this.singleRank1 > p.singleRank1){
					return 1;
				}else if(this.singleRank1 < p.singleRank1){
					return -1;
				}else if(this.singleRank2 > p.singleRank2){
					return 1;
				}else if(this.singleRank2 < p.singleRank2){
					return -1;
				}else if(this.singleRank3 > p.singleRank3){
					return 1;
				}else if(this.singleRank3 < p.singleRank3){
					return -1;
				}else{return 0;}
			}
			else{
			//if Nothing, compare the singleRank1 - singRank5, once different, the larger one wins
				if(this.singleRank1 > p.singleRank1){
					return 1;
				}else if(this.singleRank1 < p.singleRank1){
					return -1;
				}else if(this.singleRank2 > p.singleRank2){
					return 1;
				}else if(this.singleRank2 < p.singleRank2){
					return -1;
				}else if(this.singleRank3 > p.singleRank3){
					return 1;
				}else if(this.singleRank3 < p.singleRank3){
					return -1;
				}else if(this.singleRank4 > p.singleRank4){
					return 1;
				}else if(this.singleRank4 < p.singleRank4){
					return -1;
				}else if(this.singleRank5 > p.singleRank5){
					return 1;
				}else if(this.singleRank5 < p.singleRank5){
					return -1;
				}else{return 0;}
			}
	}
	
	
	//the method to test if the two hands have duplicate cards
	//compare each card's cardValue in p1 to each card's cardValue in p2
	public void dupInTwoHands(PokerHand p1, PokerHand p2) throws DuplicateCardException{
		for(int i : p1.cardValue){
			for(int j : p2.cardValue){
				if(i == j){
					throw new DuplicateCardException();
				}
			}
		}
	}
}

