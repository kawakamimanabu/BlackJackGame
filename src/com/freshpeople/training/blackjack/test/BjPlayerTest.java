package com.freshpeople.training.blackjack.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.freshpeople.training.blackjack.BjPlayer;
import com.freshpeople.training.blackjack.Card;

public class BjPlayerTest {

	private BjPlayer bjPlayer = null;

	@Before
	public void setUp() throws Exception {
		bjPlayer = new BjPlayer("test");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPlayerName() {
		assertEquals(bjPlayer.getPlayerName(), "test");
	}

	@Test
	public void testAddCard() {
		bjPlayer.addCard(new Card("Club",1));
		assertEquals(bjPlayer.getSum(), 11);
		bjPlayer.addCard(new Card("Club",11));
		assertEquals(bjPlayer.getSum(), 21);
	}

	@Test
	public void testClearCard() {
		bjPlayer.addCard(new Card("Club",1));
		bjPlayer.addCard(new Card("Club",11));
		assertEquals(bjPlayer.getSum(), 21);
		bjPlayer.clearCard();
		assertEquals(bjPlayer.getSum(), 0);
	}

	@Test
	public void testBust() {
		bjPlayer.addCard(new Card("Club",9));
		bjPlayer.addCard(new Card("Club",11));
		bjPlayer.addCard(new Card("Club",12));
		assertTrue(bjPlayer.isBust());
	}

	/**
	 * 3 枚すべて A の時の合計テスト
	 * 合計値は 23 となり、Diff が -2 となること
	 */
	@Test
	public void testGetSumWhen3Ace() {
		bjPlayer.addCard(new Card("Club",1));
		bjPlayer.addCard(new Card("Heart",1));
		bjPlayer.addCard(new Card("Spade",1));
		assertEquals(bjPlayer.getSum(), 23);
		assertEquals(bjPlayer.getDiff(), -2);
	}

}
