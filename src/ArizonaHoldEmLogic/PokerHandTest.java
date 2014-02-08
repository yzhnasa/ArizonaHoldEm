package ArizonaHoldEmLogic;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the PokerHand class and the enums 
 * 
 * Rick includes all 52 cards to save you time (see end of file, after the @Test methods)
 * 
* There are also some additional test cases here.  But this is in no way complete.  Many more are needed
 */
public class PokerHandTest {

  @Test
  public void testSuitEnum() {
    String result = "";
    for (Suit suit : Suit.values())
      result += suit + " ";
    assertEquals("Diamonds Clubs Hearts Spades", result.trim());
  }

  @Test
  public void testRankEnum() {
    String result = "";
    for (Rank rank : Rank.values())
      result += rank + " ";
    assertEquals(
        "Deuce Three Four Five Six Seven Eight Nine Ten Jack Queen King Ace",
        result.trim());
  }
  
  @Test
  public void testCard(){
	  assertTrue( C2.getRank()+ C2.getSuit()== C2.getValue());
  }

  // Do not allow duplicate cards, throw an exception
  @Test(expected = DuplicateCardException.class)
  public void tryToAddTheSameCardTwiceA() {
    new PokerHand(C2, C3, C4, C5, C5);
  }

  /*@Test(expected = DuplicateCardException.class)
  public void testPair2() {
    PokerHand a = new PokerHand(H3, CA, D4, H6, DA);
    a.toString();
    PokerHand b = new PokerHand(H3, C5, HA, SA, C6);
    assertTrue(a.compareTo(b) < 0);
  }*/
 

  @Test
  public void testTwoPairWhenOnePairIsEqual() {
    PokerHand a = new PokerHand(C4, HK, D4, H3, DK);
    PokerHand b = new PokerHand(H4, C10, CA, DA, S4);
    assertTrue(a.compareTo(b) < 0);
    assertTrue(b.compareTo(a) > 0);
  }

  @Test
  public void testAceLowStraight() {
    PokerHand a = new PokerHand(CA, C2, C3, C4, H5);
    PokerHand b = new PokerHand(D2, D3, D4, D5, H6);
    boolean answer = a.compareTo(b) < 0;
    assertTrue(answer);
  }

  // Set up 52 cards so we can use C2 instead of new Card(Rank.Deuce, Suit.Clubs)
  private final static Card C2 = new Card(Rank.Deuce, Suit.Clubs);
  private final static Card C3 = new Card(Rank.Three, Suit.Clubs);
  private final static Card C4 = new Card(Rank.Four, Suit.Clubs);
  private final static Card C5 = new Card(Rank.Five, Suit.Clubs);
  private final static Card C6 = new Card(Rank.Six, Suit.Clubs);
  private final static Card C7 = new Card(Rank.Seven, Suit.Clubs);
  private final static Card C8 = new Card(Rank.Eight, Suit.Clubs);
  private final static Card C9 = new Card(Rank.Nine, Suit.Clubs);
  private final static Card C10 = new Card(Rank.Ten, Suit.Clubs);
  private final static Card CJ = new Card(Rank.Jack, Suit.Clubs);
  private final static Card CQ = new Card(Rank.Queen, Suit.Clubs);
  private final static Card CK = new Card(Rank.King, Suit.Clubs);
  private final static Card CA = new Card(Rank.Ace, Suit.Clubs);

  private final static Card D2 = new Card(Rank.Deuce, Suit.Diamonds);
  private final static Card D3 = new Card(Rank.Three, Suit.Diamonds);
  private final static Card D4 = new Card(Rank.Four, Suit.Diamonds);
  private final static Card D5 = new Card(Rank.Five, Suit.Diamonds);
  private final static Card D6 = new Card(Rank.Six, Suit.Diamonds);
  private final static Card D7 = new Card(Rank.Seven, Suit.Diamonds);
  private final static Card D8 = new Card(Rank.Eight, Suit.Diamonds);
  private final static Card D9 = new Card(Rank.Nine, Suit.Diamonds);
  private final static Card D10 = new Card(Rank.Ten, Suit.Diamonds);
  private final static Card DJ = new Card(Rank.Jack, Suit.Diamonds);
  private final static Card DQ = new Card(Rank.Queen, Suit.Diamonds);
  private final static Card DK = new Card(Rank.King, Suit.Diamonds);
  private final static Card DA = new Card(Rank.Ace, Suit.Diamonds);

  private final static Card H2 = new Card(Rank.Deuce, Suit.Hearts);
  private final static Card H3 = new Card(Rank.Three, Suit.Hearts);
  private final static Card H4 = new Card(Rank.Four, Suit.Hearts);
  private final static Card H5 = new Card(Rank.Five, Suit.Hearts);
  private final static Card H6 = new Card(Rank.Six, Suit.Hearts);
  private final static Card H7 = new Card(Rank.Seven, Suit.Hearts);
  private final static Card H8 = new Card(Rank.Eight, Suit.Hearts);
  private final static Card H9 = new Card(Rank.Nine, Suit.Hearts);
  private final static Card H10 = new Card(Rank.Ten, Suit.Hearts);
  private final static Card HJ = new Card(Rank.Jack, Suit.Hearts);
  private final static Card HQ = new Card(Rank.Queen, Suit.Hearts);
  private final static Card HK = new Card(Rank.King, Suit.Hearts);
  private final static Card HA = new Card(Rank.Ace, Suit.Hearts);

  private final static Card S2 = new Card(Rank.Deuce, Suit.Spades);
  private final static Card S3 = new Card(Rank.Three, Suit.Spades);
  private final static Card S4 = new Card(Rank.Four, Suit.Spades);
  private final static Card S5 = new Card(Rank.Five, Suit.Spades);
  private final static Card S6 = new Card(Rank.Six, Suit.Spades);
  private final static Card S7 = new Card(Rank.Seven, Suit.Spades);
  private final static Card S8 = new Card(Rank.Eight, Suit.Spades);
  private final static Card S9 = new Card(Rank.Nine, Suit.Spades);
  private final static Card S10 = new Card(Rank.Ten, Suit.Spades);
  private final static Card SJ = new Card(Rank.Jack, Suit.Spades);
  private final static Card SQ = new Card(Rank.Queen, Suit.Spades);
  private final static Card SK = new Card(Rank.King, Suit.Spades);
  private final static Card SA = new Card(Rank.Ace, Suit.Spades);

  // TEST CARD HGH HANDS

  private static PokerHand nothing72 = new PokerHand(C2, C3, C4, C5, D7);
  private static PokerHand nothing73 = new PokerHand(D2, D4, D5, D6, C7);
  private static PokerHand nothingJ = new PokerHand(C8, C9, C10, SJ, D3);
  private static PokerHand nothingK9 = new PokerHand(CK, CQ, CJ, D10, H9);
  private static PokerHand nothingK8 = new PokerHand(HK, HQ, HJ, H10, S8);
  private static PokerHand nothingA = new PokerHand(S9, SJ, SQ, SK, CA);

  @Test
  public void testNothing0() {
    assertTrue(nothing73.compareTo(nothing72) > 0);
  }

  @Test
  public void testNothing1() {
    assertTrue(nothingJ.compareTo(nothing73) > 0);
  }

  @Test
  public void testNothing2() {
    assertTrue(nothingK8.compareTo(nothingJ) > 0);
  }

  @Test
  public void testNothing3() {
    assertTrue(nothingK9.compareTo(nothingK8) > 0);
  }

  @Test
  public void testNothing4() {
    assertTrue(nothingK8.compareTo(nothingA) < 0);
  }
  
  // Many more tests needed
  //Compare two Straight Flush
  private static PokerHand sFlushDA = new PokerHand(DA, DK, DQ, DJ, D10);
  private static PokerHand sFlushCA = new PokerHand(CA, CK, CQ, CJ, C10);
  private static PokerHand sFlushD5 = new PokerHand(S5, S3, S4, S2, SA);
  private static PokerHand sFlushH9 = new PokerHand(H7, H5, H6, H8, H9);
 
  @Test
  public void testTwoSFlush1(){
	  assertTrue(sFlushDA.compareTo(sFlushCA) == 0);
  }
  
  @Test
  public void testTwoSFlush2(){
	  assertTrue(sFlushDA.compareTo(sFlushD5) > 0);
  }
  
  @Test
  public void testTwoSFlush3(){
	  assertTrue(sFlushD5.compareTo(sFlushH9) < 0);
  }
  
  //Compare two Four of a Kind 
  @Test
  public void testFourOfAKind1(){
	  PokerHand fourOfAKindA10 = new PokerHand(DA, CA, HA, SA, D10);
	  PokerHand fourOfAKind9K = new PokerHand(D9, C9, H9, S9, DK);
	  assertTrue(fourOfAKindA10.compareTo(fourOfAKind9K) > 0);
	  assertTrue(fourOfAKind9K.compareTo(fourOfAKindA10) < 0);
  } 
  
  //Compare two Full House
  @Test
  public void testFullHouse(){
	  PokerHand fullHouse9K = new PokerHand(D9, C9, H9, CK, DK);
	  PokerHand fullHouseA8 = new PokerHand(DA, CA, HA, C8, D8);
	  assertTrue(fullHouse9K.compareTo(fullHouseA8) < 0);
	  assertTrue(fullHouseA8.compareTo(fullHouse9K) > 0);
  }
  
  //Compare two flush, with the four cards have the same rank
  private static PokerHand flushS3 = new PokerHand(SK, S6, S7, S8, S3);
  private static PokerHand flushH2 = new PokerHand(HK, H6, H7, H8, H2);
 
  @Test
  public void testTwoFlush0(){
	  assertTrue(flushS3.compareTo(flushH2) > 0);
	  assertTrue(flushH2.compareTo(flushS3) < 0);
  }
  
  @Test
  public void testTwoflush1(){
	  PokerHand flushHQ = new PokerHand(HQ, H9, H7, H4, H2);
	  assertTrue(flushS3.compareTo(flushHQ) > 0);
	  assertTrue(flushHQ.compareTo(flushS3) < 0);
  }
  
  @Test
  public void testTwoflush2(){
	  PokerHand flushH7 = new PokerHand(HK, H3, H7, H4, H2);
	  assertTrue(flushS3.compareTo(flushH7) > 0);
	  assertTrue(flushH7.compareTo(flushS3) < 0);
  }
  
  @Test
  public void testTwoflush3(){
	  PokerHand flushH4 = new PokerHand(HK, H3, H8, H4, H2);
	  assertTrue(flushS3.compareTo(flushH4) > 0);
	  assertTrue(flushH4.compareTo(flushS3) < 0);
  }
  
  @Test
  public void testTwoflush4(){
	  PokerHand flushH4 = new PokerHand(HK, H3, H8, H4, H7);
	  assertTrue(flushS3.compareTo(flushH4) > 0);
	  assertTrue(flushH4.compareTo(flushS3) < 0);
  }
  
  @Test
  public void testTwoflush5(){
	  PokerHand flushH2 = new PokerHand(HK, H8, H7, H6, H2);
	  assertTrue(flushS3.compareTo(flushH2) > 0);
	  assertTrue(flushH2.compareTo(flushS3) < 0);
  }
  
  @Test
  public void testTwoflush6(){
	  PokerHand flushH3 = new PokerHand(HK, H3, H7, H6, H8);
	  assertTrue(flushS3.compareTo(flushH3) == 0);
  }
  
  
  //Compare a flush with a straight flush
  @Test
  public void flushVsStraightFlush(){
	  assertTrue(sFlushH9.compareTo(flushS3) > 0);
  }
 
  //compare two straight
  @Test
  public void sameStraight(){
	  PokerHand straightA101 = new PokerHand(SA, D10, DQ, CJ, HK);
	  PokerHand straightA102 = new PokerHand(DJ, SK, C10, HQ, DA);
	  assertTrue(straightA101.compareTo(straightA102) == 0);
  }
 
  @Test
  public void twoStraight(){
	  PokerHand straight5A = new PokerHand(C4, D3, HA, D2, S5);
	  PokerHand straight95 = new PokerHand(H5, S6, H7, D8, D9);
	  assertTrue(straight95.compareTo(straight5A) > 0);
  }
 
  //compare two Three of a Kind
  @Test
  public void testThreeOfAKind(){
	  PokerHand threeOfAKind9 = new PokerHand(H9, D9, S9, HK, D8);
	  PokerHand threeOfAKind7 = new PokerHand(S7, H7, C7, DA, C9);
	  PokerHand threeOfAKindA = new PokerHand(S7, HA, CA, DA, C9);
	  assertTrue(threeOfAKind9.compareTo(threeOfAKind7) > 0);
	  assertTrue(threeOfAKind9.compareTo(threeOfAKindA) < 0);
  }
 
  //compare Three of a Kind to Full House
  @Test
  public void ThreeOfAKindVsFullHouse(){
	  PokerHand threeOfAKind9 = new PokerHand(H9, D9, S9, HK, D8);
	  PokerHand fullHouseA8 = new PokerHand(DA, CA, HA, C8, H8);
	  assertTrue(threeOfAKind9.compareTo(fullHouseA8) < 0);
  }
 
  //compare two Two Pair
  //compare Two pair with the larger pair are equal
  @Test
  public void testTwoPair1(){
	  PokerHand twoPair96K = new PokerHand(H9, S9, H6, S6, DK);
	  PokerHand twoPair95A = new PokerHand(DA, C5, D5, C9, D9);
	  assertTrue(twoPair96K.compareTo(twoPair95A) > 0);
	  assertTrue(twoPair95A.compareTo(twoPair96K) < 0);
  }
 
  //compare Two Pair with the samller one equal
  @Test
  public void testTwoPair2(){
	  PokerHand twoPairQ9K = new PokerHand(H9, S9, HQ, SQ, DK);
	  PokerHand twoPairJ9A = new PokerHand(DJ, CJ, DA, C9, D9);
	  assertTrue(twoPairQ9K.compareTo(twoPairJ9A) > 0);
	  assertTrue(twoPairJ9A.compareTo(twoPairQ9K) < 0);
  }
 
  //compare Two Pair with both pairs equal
  @Test
  public void testTwoPair3(){
	  PokerHand twoPairQ9K = new PokerHand(H9, S9, HQ, SQ, DK);
	  PokerHand twoPairQ9A = new PokerHand(DQ, CQ, DA, C9, D9);
	  assertTrue(twoPairQ9K.compareTo(twoPairQ9A) < 0);
	  assertTrue(twoPairQ9A.compareTo(twoPairQ9K) > 0);
  }
  
  //when all equal
  @Test
  public void testTwoPair4(){
	  PokerHand twoPairQ9K = new PokerHand(H9, S9, HQ, SQ, DK);
	  PokerHand twoPairQ9K_1 = new PokerHand(C9, SK, DQ, D9, CQ);
	  assertTrue(twoPairQ9K.compareTo(twoPairQ9K_1) == 0);
  }
 
  //compare two One Pair
  private static PokerHand onePairQK64 = new PokerHand(CQ, S4, HK, DQ, C6);
  private static PokerHand onePair31064 = new PokerHand(C3, D4, H10, D3, S6);
  private static PokerHand onePairQK63 = new PokerHand(HQ, S3, SK, SQ, D6);
  private static PokerHand onePairQ764 = new PokerHand(HQ, H4, S7, SQ, D6);
  private static PokerHand onePairQ954 = new PokerHand(HQ, D4, S9, SQ, C5);
  
  //with pair different
  @Test 
  public void testOnePair1(){
	  assertTrue(onePairQK64.compareTo(onePair31064) > 0);
	  assertTrue(onePair31064.compareTo(onePairQK64) < 0);
  }
  
  //same pair, single rank different
  @Test 
  public void testOnePair2(){
	  assertTrue(onePairQK64.compareTo(onePairQK63) > 0);
	  assertTrue(onePairQK63.compareTo(onePairQK64) < 0);
  } 
  
  @Test 
  public void testOnePair3(){
	  assertTrue(onePairQK64.compareTo(onePairQ764) > 0);
	  assertTrue(onePairQ764.compareTo(onePairQK64) < 0);
  }
  
  @Test 
  public void testOnePair4(){
	  assertTrue(onePairQK64.compareTo(onePairQ954) > 0);
	  assertTrue(onePairQ954.compareTo(onePairQK64) < 0);
  }
  
  @Test 
  public void testOnePair5(){
	  PokerHand onePair7KJ2_1 = new PokerHand(H2, SJ, D7, HK, S7);
	  PokerHand onePair7KJ2_2 = new PokerHand(HJ, S2, C7, DK, H7);
	  assertTrue(onePair7KJ2_1.compareTo(onePair7KJ2_2) == 0);
  }
  
  @Test 
  public void testOnePair6(){
	  PokerHand onePair7K63 = new PokerHand(H3, S6, D7, HK, S7);
	  PokerHand onePair7K52 = new PokerHand(H5, S2, C7, DK, H7);
	  assertTrue(onePair7K63.compareTo(onePair7K52) > 0);
	  assertTrue(onePair7K52.compareTo(onePair7K63) < 0);
  }
  //compare two Nothing
  //Largest one equal
  @Test
  public void testNothing5(){
	  PokerHand NothingQ10 = new PokerHand(SQ, S10, S8, C4, H2);
	  PokerHand NothingQ8 = new PokerHand(D5, C3, H4, DQ, H6);
	  assertTrue(NothingQ10.compareTo(NothingQ8) > 0);
	  assertTrue(NothingQ8.compareTo(NothingQ10) < 0);
  }
  
  //when largest two cards equal
  @Test
  public void testNothing6(){
	  PokerHand NothingQ108 = new PokerHand(SQ, D10, S8, C4, H2);
	  PokerHand NothingQ105 = new PokerHand(D5, C3, H4, DQ, H10);
	  assertTrue(NothingQ108.compareTo(NothingQ105) > 0);
	  assertTrue(NothingQ105.compareTo(NothingQ108) < 0);
  }
  
  //when three larger cards equal
  @Test
  public void testNothing7(){
	  PokerHand NothingQ1098 = new PokerHand(SQ, D10, S8, C9, H2);
	  PokerHand NothingQ1095 = new PokerHand(D5, C3, H9, DQ, H10);
	  assertTrue(NothingQ1098.compareTo(NothingQ1095) > 0);
	  assertTrue(NothingQ1095.compareTo(NothingQ1098) < 0);
  }
  
  //when just smallest differ
  @Test
  public void testNothing8(){
	  PokerHand NothingQ10863 = new PokerHand(SQ, D10, S8, C6, H3);
	  PokerHand NothingQ10862 = new PokerHand(D6, C8, H2, DQ, H10);
	  assertTrue(NothingQ10863.compareTo(NothingQ10862) > 0);
	  assertTrue(NothingQ10862.compareTo(NothingQ10863) < 0);
  }
  
  //when all equal
  @Test
  public void testNothing9(){
	  PokerHand NothingQ10854 = new PokerHand(SQ, D10, S8, C4, H5);
	  PokerHand NothingQ10854_1 = new PokerHand(D5, C8, H4, DQ, H10);
	  assertTrue(NothingQ10854.compareTo(NothingQ10854_1) == 0);
  }
  
  @Test
  public void testDuplicate02(){
	  PokerHand dup1 = new PokerHand(C5,C6,C7,C8,C9);
	  PokerHand dup2 = new PokerHand(C10,D10,S10,H10,C9);
	  assertTrue(dup1.compareTo(dup2) > 0);
  }
  
  //Test card names
  @Test
  public void testFiveCards(){
	  PokerHand dup1 = new PokerHand(C5,C6,C7,C8,C9);
	  dup1.setCardsName();
	  System.out.println(dup1.getCardsName());
	  //assertTrue(dup1.getCardsName().equals("9C 8C 7C 6C 5C"));
  }
 
}