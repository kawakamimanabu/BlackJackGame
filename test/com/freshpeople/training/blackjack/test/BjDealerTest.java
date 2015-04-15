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
import com.freshpeople.training.blackjack.CardManagerTask;

public class BjDealerTest {

	private BjDealer bjDealer = null;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
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
	}

	/**
	 * 同名プレイヤー名の登録時に例外が発生すること
	 * @throws Exception
	 */
	@Test
	public void testAddBjPlayer_2() throws Exception {
	}

	/**
	 * プレイヤーの名前のテスト
	 * @throws Exception
	 */
	@Test
	public void testGetPlayerNameList() throws Exception {
	}

	/**
	 * 勝敗判定のテスト
	 * プレイヤーが負けること
	 * @throws Exception
	 */
	@Test
	public void testStartGameLose() throws Exception {
		// テスト用カード管理クラスを設定
		// テスト用プレイヤーの追加
	}

	/**
	 * 勝敗判定のテスト
	 * プレイヤーが勝つこと
	 * @throws Exception
	 */
	@Test
	public void testStartGameWin() throws Exception {
		// テスト用カード管理クラスを設定
		// テスト用プレイヤーの追加
	}

	/**
	 * 勝敗判定のテスト
	 * 引き分けとなること
	 * @throws Exception
	 */
	@Test
	public void testStartGameDraw() throws Exception {
		// テスト用カード管理クラスを設定
		// テスト用プレイヤーの追加
	}

}
