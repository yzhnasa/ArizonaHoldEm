package ArizonaHoldEmLogic;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ArizonaHoldEmTest {
	
		//initiate a deck of 52 cards, check the first and second cards
		@Test 
		public void testDeck(){
			PokerDeck deck = new PokerDeck();
			assertTrue(deck.getDeck().size() == 52 );
			//to examine what the card
			assertTrue(deck.whatCard(deck.getTopCard()).equals("2C") 
							&& deck.whatCard(deck.getTopCard()).equals("3C"));
			assertTrue(deck.getDeck().size() == 50);
		}
		
		//shuffle the deck, check the first and second to examine if the cards has been reordered
		@Test
		public void testDeckShuffle(){
			PokerDeck deck = new PokerDeck();
			deck.shuffle();
			assertTrue(deck.getDeck().size() == 52);
			//check the first two cards to examine if the card is shuffled
			assertFalse(deck.whatCard(deck.getTopCard()).equals("2C") 
			              && deck.whatCard(deck.getTopCard()).equals("3C")
			              && deck.whatCard(deck.getTopCard()).equals("4C")
			              && deck.whatCard(deck.getTopCard()).equals("5C"));
		}
		
		//test the dealer's function in dealing with pot
		@Test
		public void testDealPot(){
			Dealer dealer = new Dealer();
			dealer.collectAntes(5);
			assertTrue(dealer.showPot() == 10.00);
			assertTrue(dealer.splitPort(5) == 2.00);
		}
		
		//test the dealer's function in dealing the cards
		@Test
		public void testDealerDealCards(){
			Dealer dealer = new Dealer();
			dealer.newDeck();
			dealer.getDeck().shuffle();
			dealer.setCommunityCards();
			dealer.setTwoCards();
			assertTrue(dealer.getCommunityCards().size() == 5);
			assertTrue(dealer.getTwoCards().size() == 2);
			assertTrue(dealer.getDeck().getDeck().size() == 45);
		}
		
		//test the name of the player
		//check the initial balance of a player and check his balance after he bet
		//and check the balance after add balance to it
		@Test
		public void testPlayer(){
			Player player = new Player("John");
			assertTrue(player.getName().equals("John"));
			assertTrue(player.getBalance() == 100.00f);
			player.bet();
			assertTrue(player.getBalance() == 98.00f);
			player.addBalance(8.00f);
			assertTrue(player.getBalance() == 106.00f);
		}	

		
		@Test
		public void playerGetTwoCards(){
			Player player = new Player("John");
			Dealer dealer = new Dealer();
			dealer.newDeck();
			dealer.getDeck().shuffle();
			dealer.setTwoCards();
			player.setTwoCards(dealer);
			assertTrue(player.getTwoCards().size() == 2);
		}
		
		@Test
		public void playerGetCommunityCards(){
			Player player = new Player("John");
			Dealer dealer = new Dealer();
			dealer.newDeck();
			dealer.setCommunityCards();
			player.setCommunityCards(dealer);
			assertTrue(player.getCommunityCards().size() == 5);
		}
		
		@Test
		public void testCombineCards(){
			Player player = new Player("John");
			Dealer dealer = new Dealer();
			dealer.newDeck();
			dealer.setTwoCards();
			dealer.setCommunityCards();
			player.setTwoCards(dealer);
			player.setCommunityCards(dealer);
			player.setCombineedCards();
			assertTrue(player.getCombinedCard().size() == 7);
			assertTrue(dealer.getDeck().getDeck().size() == 45);
		}
		
		@Test
		public void playernum(){
			Dealer dealer = new Dealer();
			dealer.newDeck();
			Player p1 = new Player("John");
			Player p2 = new Player("Ben");
			Player p3 = new Player("Kate");
			ArrayList <Player> players = new ArrayList<> ();
			players.add(p1);
			players.add(p2);
			players.add(p3);
			assertTrue(dealer.addPlayers(players).size() == 3);
		}
		
		@Test
		public void pokerHands21(){
			Player player = new Player("John");
			Dealer dealer = new Dealer();
			dealer.newDeck();
			dealer.getDeck().shuffle();
			dealer.setTwoCards();
			dealer.setCommunityCards();
			player.setTwoCards(dealer);
			player.setCommunityCards(dealer);
			player.setCombineedCards();
			player.setPokerHands21();		
			assertTrue(player.getPokerHands21().size() == 21);
			player.chooseBestHand();
			assertTrue(player.ifBestHand());
		}
		
		 @Test
		  public void testWinner(){
			  ArizonaHoldEm game = new ArizonaHoldEm();
			  game.setPlayerForTest();
			  //game.getDealer();
			  game.getDealer().newDeck();
			  game.getDealer().collectAntes(game.getPlayers().size());
			  game.getDealer().getDeck().shuffle();
				for(int i = 0; i < game.getPlayers().size(); i++){
					game.getDealer().setTwoCards();
					game.getPlayers().get(i).setTwoCards(game.getDealer());
					game.getPlayers().get(i).bet();
				}
				game.getDealer().setCommunityCards();
				for(int i = 0; i < game.getPlayers().size(); i++){
					game.getPlayers().get(i).setCommunityCards(game.getDealer());
					game.getPlayers().get(i).setCombineedCards();
					game.getPlayers().get(i).setPokerHands21();
					game.getPlayers().get(i).chooseBestHand();
				}
				game.getDealer().addPlayers(game.getPlayers());
				game.getDealer().winner();
				
			  for(int i = 1; i < game.getPlayers().size(); i++){
				  game.getPlayers().get(i).showBestHand().setCardsName();
				  System.out.println(game.getPlayers().get(i).showBestHand().getCardsName());
				  assertTrue(game.getPlayers().get(i).compareTo(game.getPlayers().get(i-1)) >=0);
			  }
			  
			  game.getDealer().setWinnerList();
			  int j =  game.getDealer().getWinnerList().size();
			  int k =  game.getPlayers().size();
			  for (int i = k-j; i != 0; i--){
				  assertTrue(game.getDealer().getWinnerList().get(0).compareTo(game.getPlayers().get(i -1)) > 0);
			  }
			  
		  }
		 
		 //to show the 5 comminuty cards and show the two player cards
		 @Test
		 public void showCommunityCardAndTwoCard(){
			 Player player = new Player("John");
				Dealer dealer = new Dealer();
				dealer.newDeck();
				dealer.getDeck().shuffle();
				dealer.setTwoCards();
				dealer.setCommunityCards();
				player.setTwoCards(dealer);
				player.setCommunityCards(dealer);
				player.setCombineedCards();
				System.out.println(dealer.showCommunitycard());
				System.out.println(player.showTwoCards());
				player.setPokerHands21();
				player.chooseBestHand();
				player.showBestHand().setCardsName();
				System.out.println(player.showBestHand().getCardsName());
				
		 }
		 
		 @Test
		 public void TestPlayerNum(){
			 ArizonaHoldEm game = new ArizonaHoldEm();
			 try{
				 game.checkPlayerNumber(11);
			 }catch(WrongPlayerNumber e){
				 assertEquals("Please input players number from 2 to 10", e.toString());
			 }
		 }
		 
		 
		 
}
