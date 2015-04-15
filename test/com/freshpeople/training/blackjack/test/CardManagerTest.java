package com.freshpeople.training.blackjack.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.freshpeople.training.blackjack.CardManager;

/**
 *
 * @author
 *
 */
public class CardManagerTest {

	private CardManager cardManager;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInit() {
	}

	/**
	 * 52 枚のカードが重複無くランダムに取得されること
	 * ランダムに取得できるかは、カードをコンソール表示して目視確認とする
	 * @throws Exception
	 */
	@Test
	public void testGetRandomCard() throws Exception {
	}

	/**
	 * 52 枚以上のカードを取得しようとした際に例外が発生すること
	 */
	@Test
	public void testGetRandomCard_2() throws Exception {
	}
}
