package com.freshpeople.training.blackjack.test;

import com.freshpeople.training.blackjack.BaseBjPlayer;

/**
 * テスト用 Bjプレイヤー
 * @author
 *
 */
public class TestBjPlayer extends BaseBjPlayer {

	public TestBjPlayer(String playerName) {
		super(playerName);
	}

	@Override
	public boolean judgeHit() {
		return false;
	}

}
