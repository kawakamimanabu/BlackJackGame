package com.freshpeople.training.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
	public void addBjPlayer(BaseBjPlayer bjPlayer) throws Exception{
		if (!bjPlayerList.contains(bjPlayer)) {
			bjPlayerList.add(bjPlayer);
		}
		else {
			throw new Exception("Duplicate BlackJack Player Name.[" + bjPlayer.getPlayerName() + "]");
		}
	}

	@Override
	public List<String> getPlayerNameList() {
		Function<BaseBjPlayer, String> mapper = bjPlayer -> bjPlayer.getPlayerName();
		return bjPlayerList.stream().map(mapper).collect(Collectors.toList());
	}

	@Override
	public void startGame() throws Exception {
		// カードを初期化
		cardManager.init();
		// ディーラーを含む全プレイヤーにカードを配る
		dealCards();
		// ディーラー自身の最初の 1 枚を公開する
		showMyFirstCard();
		// ディーラー以外の Player が Hit する場合にカードを配る
		for (BaseBjPlayer player : bjPlayerList) {
			// Player が Hit しなくなるまでカードを配る
			askHitDealCard(player);
		}
		// 最後にディーラー自身に対して Hit する
		askHitDealCard(this);
		// 結果判定
		judgeGame();
	}

	//--- private methods ---
	/**
	 * ディーラーを含む全プレイヤーにカードを配る
	 * @throws Exception
	 */
	private void dealCards() throws Exception {
		// ディーラーを除く全 Player に 2 枚ずつカードを配る
		for (BaseBjPlayer player : bjPlayerList) {
			player.addCard(cardManager.getRandomCard());
			player.addCard(cardManager.getRandomCard());
		}
		addCard(cardManager.getRandomCard());
		addCard(cardManager.getRandomCard());
	}

	/**
	 * 引数で与えられたプレイヤーに対して hit するか否かを判別して
	 * Hit する場合はカードを配る
	 * @param player
	 * @throws Exception
	 */
	private void askHitDealCard(BaseBjPlayer player) throws Exception {
		while (player.judgeHit()) {
			player.addCard(cardManager.getRandomCard());
		}
	}

	/**
	 * 結果判定
	 */
	private void judgeGame() {
		System.out.println("\n\n>>>>>>>>>> Game Result <<<<<<<<<<");
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
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}


	//--- getter, setter ---
	/**
	 * cardManager をセットする
	 * @param cardManager
	 */
	public void setCardManager(CardManager cardManager) {
		this.cardManager = cardManager;
	}

}
