package com.freshpeople.training.blackjack.test;

import com.freshpeople.training.blackjack.BaseBjPlayer;

/**
 * テスト用 BOT Bjプレイヤー
 * @author
 *
 */
public class TestBjPlayer extends BaseBjPlayer {

	public TestBjPlayer(String playerName) {
		super("Bot");
	}

	@Override
	public boolean judgeHit() {
		return false;
	}

}
