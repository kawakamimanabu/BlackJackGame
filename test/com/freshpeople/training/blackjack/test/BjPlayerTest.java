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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPlayerName() {
	}

	/**
	 * addCard と getSum のテスト
	 */
	@Test
	public void testAddCardGetSum() {
	}

	/**
	 * clearCard のテスト
	 */
	@Test
	public void testClearCard() {
	}

	/**
	 * bust 判定のテスト1
	 * カードが無い場合に Bust していないこと
	 */
	@Test
	public void testBust_1() {
	}

	/**
	 * bust 判定のテスト2
	 * カードの合計が21の場合に Bust していないこと
	 */
	@Test
	public void testBust_2() {
	}

	/**
	 * bust 判定のテスト3
	 * カードの合計が22の場合に Bust していること
	 */
	@Test
	public void testBust_3() {
	}

	/**
	 * judgeHit 判定のテスト
	 * カードの合計が22の場合に Hit できないこと
	 */
	@Test
	public void testJudgeHit() {
	}


	/**
	 * 合計値は 20 となり、Diff が 1 となること
	 */
	@Test
	public void testGetDiff_1() {
	}

	/**
	 * 合計値は 21 となり、Diff が 0 となること
	 */
	@Test
	public void testGetDiff_2() {
	}


	/**
	 * 合計値は 22 となり、Diff が -1 となること
	 */
	@Test
	public void testGetDiff_3() {
	}

	/**
	 * 合計値は 23 となり、Diff が -2 となること
	 */
	@Test
	public void testGetDiff_3A() {
	}

}
