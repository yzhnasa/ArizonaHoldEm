/* Create a enum class for the Ranks, from Deuce to Ace;
 * Build the constructor, gives each rank a int value, from 2 to 14, which will be used in the compare method;
 * Declare a getter to return the int value of the rank;
 */
package ArizonaHoldEmLogic;
public enum Rank {
	Deuce(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), 
	Ten(10), Jack(11), Queen(12), King(13), Ace(14);
	
	private int rank = 0; //set each suit an int
	Rank(int rank){
		this.rank = rank;
	}
	
	public int getRank(){
		//method to get rank
		return rank;
	}
}
