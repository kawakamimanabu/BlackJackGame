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
	private CardManagerTask cardManagerTask = new CardManager();
	private List<BaseBjPlayer> bjPlayerList = new ArrayList<>();
	private List<BaseBjPlayer> winList		= new ArrayList<>();
	private List<BaseBjPlayer> loseList		= new ArrayList<>();
	private List<BaseBjPlayer> drawList		= new ArrayList<>();

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
		// 勝敗者リストを初期化
		winList.clear();
		loseList.clear();
		drawList.clear();
		// カードを初期化
		cardManagerTask.init();
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
		// 全 Player に 2 枚ずつカードを配る
		for (BaseBjPlayer player : bjPlayerList) {
			player.addCard(cardManagerTask.getRandomCard());
			player.addCard(cardManagerTask.getRandomCard());
		}
		// ディーラー自身にカードを配る
		addCard(cardManagerTask.getRandomCard());
		addCard(cardManagerTask.getRandomCard());
	}

	/**
	 * 引数で与えられたプレイヤーに対して hit するか否かを判別して
	 * Hit する場合はカードを配る
	 * @param player
	 * @throws Exception
	 */
	private void askHitDealCard(BaseBjPlayer player) throws Exception {
		while (player.judgeHit()) {
			player.addCard(cardManagerTask.getRandomCard());
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
				drawList.add(player);
			}
			else if (player.isBust() && !isBust() || (player.getDiff() > getDiff() && !isBust())) {
				System.out.println(player.getPlayerName() + " missed the game...");
				loseList.add(player);
			}
			else {
				System.out.println(player.getPlayerName() + " won the game!!");
				winList.add(player);
			}
		}
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}


	//--- getter, setter ---
	/**
	 * cardManager をセットする
	 * @param cardManagerTask
	 */
	public void setCardManagerTask(CardManagerTask cardManagerTask) {
		this.cardManagerTask = cardManagerTask;
	}

	/**
	 * @return winList
	 */
	public List<BaseBjPlayer> getWinList() {
		return winList;
	}

	/**
	 * @return loseList
	 */
	public List<BaseBjPlayer> getLoseList() {
		return loseList;
	}

	/**
	 * @return drawList
	 */
	public List<BaseBjPlayer> getDrawList() {
		return drawList;
	}


}
