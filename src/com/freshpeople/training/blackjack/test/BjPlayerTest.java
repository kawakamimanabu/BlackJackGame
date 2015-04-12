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
		
	}
	
	/**
	 * 3 枚すべて A の時の合計テスト
	 */
	@Test
	public void testGetSumWhen3Ace() {
		bjPlayer.addCard(new Card("Club",0));
		bjPlayer.addCard(new Card("Heart",0));
		bjPlayer.addCard(new Card("Spade",0));
		assertEquals(bjPlayer.getSum(), 23);
		assertEquals(bjPlayer.getDiff(), -2);
	}

}
