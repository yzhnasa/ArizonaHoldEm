/*This is the running time exception class for the user wrongly input the number of players
 * If the user input a number bigger than 10 or smaller than 2, it will throw an exception.
 */
package ArizonaHoldEmLogic;
public class WrongPlayerNumber extends RuntimeException {
	public String toString(){
		return "Please input players number from 2 to 10";
	}
}
