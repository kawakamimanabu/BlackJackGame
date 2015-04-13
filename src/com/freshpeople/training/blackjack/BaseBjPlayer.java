package com.freshpeople.training.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * BlackJack プレイヤー抽象クラス
 * @author
 *
 */
public abstract class BaseBjPlayer {
	protected static int BLACKJACK_NUMBER = 21;
	// プレイヤー名
	private String playerName;
	// 手持ちのカードの合計
	protected int sum = 0;
	// 手持ちのカード一覧
	protected List<Card> myCardList = new ArrayList<>();

	/**
	 * コンストラクタ
	 * @param playerName
	 */
	public BaseBjPlayer(String playerName) {
		this.playerName = playerName;
	}

	//--- public methods ---
	/**
	 * 手持ちのカードを追加するか判定する抽象メソッド
	 * @return
	 */
	public abstract boolean judgeHit();

	/**
	 * 手持ちのカードリストにカードを追加する
	 * @param c
	 */
	public void addCard(Card c) {
		myCardList.add(c);
		sum = getSum();
	}

	/**
	 * 手持ちのカードをクリアする
	 */
	public void clearCard() {
		myCardList.clear();
		sum = 0;
	}

	/**
	 * 手持ちのカードを表示する。
	 */
	public void showMyCards() {
		System.out.println("*** [" + playerName + "] ***");
		myCardList.stream().forEach(System.out::println);
		System.out.println("Sum : [" + getSum() + "], diff : [" + (BLACKJACK_NUMBER - sum) + "]");
		if (sum > 21) {
			System.out.println(playerName + " Busted!!");
		}
	}

	/**
	 * 合計を取得する。
	 * A（エース）は、手持ちのカードの合計が 21 未満では 11 と数え、21 以上の場合は 1 として数える。
	 * J, Q, K は 10 として数える
	 * @return
	 */
	public int getSum() {
		sum = 0;
		for (Card c : myCardList) {
			if (c.getStringNumber().equals("A")) {
				if (sum >= 21) {sum += 1;}
				else {sum += 11;}
			}
			else {
				sum += (c.getIntNumber() > 10 ? 10 : c.getIntNumber());
			}
		}
		return sum;
	}

	//--- getter ---
	/**
	 * プレイヤーの名前を取得する
	 * @return
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * 合計が 21 を超えていた場合は true
	 * @return
	 */
	public boolean isBust() {
		return sum > 21 ? true : false;
	}

	/**
	 * 21 との差を取得する
	 */
	public int getDiff() {
		return BLACKJACK_NUMBER - sum;
	}
}
