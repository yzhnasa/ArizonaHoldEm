/*Class of the game, including the main method of the game, has the function to
 * ask the number of players and check if the number is within 2-10;
 * record the players and initialize each player;
 * initialize the dealer, collect the antes, initiale a new deck and shuffle it;
 * deal two cards to each player and deal the five community cards;
 * show the information of the community cards and each player's two cards and their balance;
 * pick the winners and show them, give them the winning balance;
 * ask if another round, if yes begin another round, if no, end the game;
 */
package ArizonaHoldEmLogic;
import java.util.ArrayList;
import java.util.Scanner;

public class ArizonaHoldEm {

	private ArrayList<Player> player = new ArrayList<>();
	private Dealer dealer = new Dealer();
	private int playerNum;
	public static void main(String[] args){
		ArizonaHoldEm newGame = new ArizonaHoldEm();
		Scanner in = new Scanner(System.in);
		System.out.print("How many players?(2-10)");
		newGame.playerNum = in.nextInt();
		
		//check if the number of players is within 2-10, if not, throw an exception and end the game;
		//if the number if alright, record the players and begin the game;
		//check if the user want another round at the end of each round;
		try{
			newGame.checkPlayerNumber(newGame.playerNum);
			for(int i=1; i <= newGame.playerNum; i++){
				System.out.print("Player "+ i + " name:");
				String playerName = in.next();
				Player newPlayer = new Player(playerName);
				newGame.player.add(newPlayer);
			}
			
			boolean continueGame = true;
			while(continueGame){
				newGame.gameBegin();
				System.out.print("Play another game?(Y/N)");
				String yOrN = in.next();
				//if the user input Y or y, start another round, if not, quit the game
				if( yOrN.equals("Y") || yOrN.equals("y")){
					continueGame = true;
				}else {
					continueGame = false;
				}
			}
		}catch(WrongPlayerNumber e){
				System.out.println(e.toString());
			}
		System.out.println("Have a Nice Day!");
	}
	
	//the method throw the exception when the players' number is incorrect
	public void checkPlayerNumber(int num) throws WrongPlayerNumber{
		if(num < 2 || num > 10){
			throw new WrongPlayerNumber();
		}
	}
	
	/*the method of each round;
	 *initialize the dealer, collect the antes, initiale a new deck and shuffle it;
	 */
	public void gameBegin(){
		Dealer dealer = new Dealer();
		dealer.newDeck();
		dealer.collectAntes(playerNum);
		dealer.getDeck().shuffle();
		
		//each player get two cards from the dealer and bet 2.00 antes 
		for(int i = 0; i < playerNum; i++){
			dealer.setTwoCards();
			player.get(i).setTwoCards(dealer);
			player.get(i).bet();
		}
		
		//deal the five community cards and show them
		dealer.setCommunityCards();
		System.out.println("Community Cards: " + dealer.showCommunitycard());
		
		//each player get the five community cards, pick his best hand
		//print out the name of player, his balance, his two cards and his best hand;
		for(int i = 0; i < playerNum; i++){
			player.get(i).setCommunityCards(dealer);
			player.get(i).setCombineedCards();
			player.get(i).setPokerHands21();
			player.get(i).chooseBestHand();
			System.out.print(player.get(i).getName() + "  $" + player.get(i).getBalance() + "  -  ");
			System.out.println(player.get(i).showTwoCards());
			player.get(i).showBestHand().setCardsName();
			System.out.println("\t"+player.get(i).showBestHand().getCardsName());
		}
		
		//record all player's information and pick the winners 
		dealer.addPlayers(player);
		dealer.winner();
		dealer.setWinnerList();
		int j = dealer.getWinnerList().size();// check the number of winners
		
		//if just one winner, print out his name, balance, and besthand
		if( j == 1 ){
			System.out.println("Winning Hand");
			float winMoney = dealer.splitPort(j);
			dealer.getWinnerList().get(0).addBalance(winMoney);
			Player p1 = dealer.getWinnerList().get(0);
			p1.showBestHand().setCardsName();
			System.out.print(p1.showBestHand().getCardsName() + " ");
			System.out.println(p1.getName() + " $" + p1.getBalance());
		}
		
		//if tie, show all the winners' name, balance and besthand
		else{
			System.out.println("Winning Hand(tie)");
			float winMoney = dealer.splitPort(j);
			for(int k = 0; k < j; k++){
				dealer.getWinnerList().get(k).addBalance(winMoney);
				Player p1 = dealer.getWinnerList().get(k);
				p1.showBestHand().setCardsName();
				System.out.print(p1.showBestHand().getCardsName() + " ");
				System.out.println(p1.getName() + " " + p1.getBalance());
			}
		}
		
	}
	
	//just for test use;
	//getter of the dealer
	public Dealer getDealer() {
		return dealer;
	}

	//just for test use
	//generate a list of player without system input
	public void setPlayerForTest() {
		Player P1 = new Player("P1");
		Player P2 = new Player("P2");
		Player P3 = new Player("P3");
		Player P4 = new Player("P4");
		Player P5 = new Player("P5");
		player.add(P1);
		player.add(P2);
		player.add(P3);
		player.add(P4);
		player.add(P5);
	}
	
	//just for test use;
	//the getter of players
	public ArrayList<Player> getPlayers() {
		return player;
	}
	
	
}


