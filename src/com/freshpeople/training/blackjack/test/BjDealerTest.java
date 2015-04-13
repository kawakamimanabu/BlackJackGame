package com.freshpeople.training.blackjack.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.freshpeople.training.blackjack.BaseBjPlayer;
import com.freshpeople.training.blackjack.BjDealer;
import com.freshpeople.training.blackjack.BjPlayer;

public class BjDealerTest {

	private BjDealer bjDealer = null;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		bjDealer = new BjDealer("dealer");
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 異なるプレイヤー名で登録できること
	 * @throws Exception
	 */
	@Test
	public void testAddBjPlayer_1() throws Exception {
		for (int i = 0; i < 5; i++) {
			BaseBjPlayer player = new BjPlayer("name" + i);
			bjDealer.addBjPlayer(player);
		}
		assertEquals(bjDealer.getPlayerNameList().size(), 5);
	}

	/**
	 * 同名プレイヤー名の登録時に例外が発生すること
	 * @throws Exception
	 */
	@Test
	public void testAddBjPlayer_2() throws Exception {
		BaseBjPlayer player = new BjPlayer("name1");
		bjDealer.addBjPlayer(player);
		BaseBjPlayer player2 = new BjPlayer("name1");
		thrown.equals(Exception.class);
		thrown.expectMessage("Duplicate BlackJack Player Name.[name1]");
		bjDealer.addBjPlayer(player2);
	}

	/**
	 * プレイヤーの名前のテスト
	 * @throws Exception
	 */
	@Test
	public void testGetPlayerNameList() throws Exception {
		for (int i = 0; i < 5; i++) {
			BaseBjPlayer player = new BjPlayer("name" + i);
			bjDealer.addBjPlayer(player);
			assertEquals(bjDealer.getPlayerNameList().get(i), "name" + i);
		}
	}

	@Test
	public void testStartGame() {

	}

}
