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

	/**
	 * addCard と getSum のテスト
	 */
	@Test
	public void testAddCardGetSum() {
		bjPlayer.addCard(new Card("Club",1));
		assertEquals(bjPlayer.getSum(), 11);
		bjPlayer.addCard(new Card("Club",11));
		assertEquals(bjPlayer.getSum(), 21);
	}

	/**
	 * clearCard のテスト
	 */
	@Test
	public void testClearCard() {
		bjPlayer.addCard(new Card("Club",1));
		assertEquals(bjPlayer.getSum(), 11);
		bjPlayer.clearCard();
		assertEquals(bjPlayer.getSum(), 0);
	}

	/**
	 * bust 判定のテスト1
	 * カードが無い場合に Bust していないこと
	 */
	@Test
	public void testBust_1() {
		assertFalse(bjPlayer.isBust());
	}

	/**
	 * bust 判定のテスト2
	 * カードの合計が21の場合に Bust していないこと
	 */
	@Test
	public void testBust_2() {
		bjPlayer.addCard(new Card("Club",8));
		bjPlayer.addCard(new Card("Club",3));
		bjPlayer.addCard(new Card("Club",12));
		assertFalse(bjPlayer.isBust());
	}

	/**
	 * bust 判定のテスト3
	 * カードの合計が22の場合に Bust していること
	 */
	@Test
	public void testBust_3() {
		bjPlayer.addCard(new Card("Club",10));
		bjPlayer.addCard(new Card("Club",11));
		bjPlayer.addCard(new Card("Club",2));
		assertTrue(bjPlayer.isBust());
	}

	/**
	 * judgeHit 判定のテスト
	 * カードの合計が22の場合に Hit できないこと
	 */
	@Test
	public void testJudgeHit() {
		bjPlayer.addCard(new Card("Club",10));
		bjPlayer.addCard(new Card("Club",11));
		bjPlayer.addCard(new Card("Club",2));
		assertFalse(bjPlayer.judgeHit());
	}


	/**
	 * 合計値は 20 となり、Diff が 1 となること
	 */
	@Test
	public void testGetDiff_1() {
		bjPlayer.addCard(new Card("Club",8));
		bjPlayer.addCard(new Card("Heart",2));
		bjPlayer.addCard(new Card("Spade",12));
		assertEquals(bjPlayer.getSum(), 20);
		assertEquals(bjPlayer.getDiff(), 1);
	}

	/**
	 * 合計値は 21 となり、Diff が 0 となること
	 */
	@Test
	public void testGetDiff_2() {
		bjPlayer.addCard(new Card("Club",8));
		bjPlayer.addCard(new Card("Heart",3));
		bjPlayer.addCard(new Card("Spade",12));
		assertEquals(bjPlayer.getDiff(), 0);
	}


	/**
	 * 合計値は 22 となり、Diff が -1 となること
	 */
	@Test
	public void testGetDiff_3() {
		bjPlayer.addCard(new Card("Club",2));
		bjPlayer.addCard(new Card("Heart",13));
		bjPlayer.addCard(new Card("Spade",12));
		assertEquals(bjPlayer.getDiff(), -1);
	}

	/**
	 * 合計値は 23 となり、Diff が -2 となること
	 */
	@Test
	public void testGetDiff_3A() {
		bjPlayer.addCard(new Card("Club",1));
		bjPlayer.addCard(new Card("Heart",1));
		bjPlayer.addCard(new Card("Spade",1));
		assertEquals(bjPlayer.getSum(), 23);
		assertEquals(bjPlayer.getDiff(), -2);
	}

}
