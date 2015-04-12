package com.freshpeople.training.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * ディーラークラス
 * 手持ちのカードの合計が 16 以下の場合は常にヒットしなくてはいけない
 * @author
 *
 */
public class BjDealer extends BaseBjPlayer implements DealerTask {
	private CardManager cardManager = new CardManager();
	private List<BaseBjPlayer> bjPlayerList = new ArrayList<>();

	// この数以下の場合は必ずヒットする
	private int point = 16;

	/**
	 * コンストラクタ
	 * @param playerName
	 */
	public BjDealer(String playerName) {
		super(playerName);
	}

	@Override
	public boolean judgeHit() {
		if (getSum() <= point)
			return true;
		return false;
	}

	@Override
	public void showMyFirstCard() {
		if (myCardList.size() > 1) {
			System.out.println("\t*** dealer's first card ***");
			System.out.println("\t" + myCardList.get(0).toString());
			System.out.println("\t********");
		}
	}

	@Override
	public void addBjPlayer(BaseBjPlayer bjPlayer) {
		if (!bjPlayerList.contains(bjPlayer)) {
			bjPlayerList.add(bjPlayer);
		}
	}

	@Override
	public void startGame() {
		// カードを初期化
		cardManager.init();
		// 全 Player に 2 枚ずつカードを配る
		for (BaseBjPlayer player : bjPlayerList) {
			player.addCard(cardManager.getRandomCard());
			player.addCard(cardManager.getRandomCard());
		}
		// 自分自身に 2 枚配り、最初の 1 枚を公開する
		addCard(cardManager.getRandomCard());
		addCard(cardManager.getRandomCard());
		showMyFirstCard();

		// ディーラー以外の Player が Hit する場合にカードを配る
		for (BaseBjPlayer player : bjPlayerList) {
			while(player.judgeHit()) {
				player.addCard(cardManager.getRandomCard());
			}
		}
		// 最後に自分自身に対して Hit する
		while (judgeHit()) {
			addCard(cardManager.getRandomCard());
		}
		judgeGame();
	}

	//--- private methods ---
	/**
	 * 結果判定
	 */
	private void judgeGame() {
		System.out.println("\n\n>>>>>>>>>>");
		showMyCards();

		for(BaseBjPlayer player : bjPlayerList) {
			player.showMyCards();
			if (player.isBust() && isBust() || player.getDiff() == getDiff()) {
				System.out.println("Draw.");
			}
			else if (player.isBust() && !isBust() || (player.getDiff() > getDiff() && !isBust())) {
				System.out.println(player.getPlayerName() + " missed the game...");
			}
			else {
				System.out.println(player.getPlayerName() + " won the game!!");
			}
		}
		System.out.println("<<<<<<<<<<");
	}

}
