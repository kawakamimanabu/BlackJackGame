package com.freshpeople.training.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * ゲームの進行を行うクラス
 * @author 
 *
 */
public class BlackJackManager {
	private CardManager mngr = new CardManager();
	private List<BaseBjPlayer> bjPlayerList = new ArrayList<>();
	
	//--- public methods ---
	/**
	 * ゲーム開始
	 */
	public void startGame() {
		// カードを初期化
		mngr.prepareCard();

		BaseBjPlayer dealer = null;
		// 全 Player に 2 枚ずつカードを配る
		for (BaseBjPlayer player : bjPlayerList) {
			player.addCard(mngr.getRandomCard());
			player.addCard(mngr.getRandomCard());
			// ディーラーを特定しておく
			if (player.isDealer() && dealer == null) {
				dealer = player;
				((DealerTask)dealer).showMyFirstCard();
			}
		}
		// ディーラー以外の Player が Hit する場合にカードを配る
		for (BaseBjPlayer player : bjPlayerList) {
			if (player != dealer) {
				while(player.judgeHit()) {
					player.addCard(mngr.getRandomCard());
				}
			}
		}
		// 最後にディーラーに対して Hit する
		while (dealer.judgeHit()) {
			dealer.addCard(mngr.getRandomCard());
		}
		
		judgeGame();
	}
	
	/**
	 * リストにプレイヤーを追加
	 * @param bjPlayer
	 */
	public void addBjPlayer(BaseBjPlayer bjPlayer) {
		if (!bjPlayerList.contains(bjPlayer)) {
			bjPlayerList.add(bjPlayer);
		}
	}
	
	//--- private methods ---
	/**
	 * 
	 */
	private void judgeGame() {
		Predicate<BaseBjPlayer> bjFilter = player -> !player.isBust();
		BiPredicate<Integer, BaseBjPlayer> bjFinder = (gap, player) -> gap - (21 - player.getSum()) == 0;
		OptionalInt minGap = bjPlayerList.stream().filter(bjFilter).mapToInt(player -> 21 - player.getSum()).min();
		if (minGap.isPresent()) {
			
		}
		for(BaseBjPlayer player : bjPlayerList) {
			player.showMyCards();
		}
	}
}
