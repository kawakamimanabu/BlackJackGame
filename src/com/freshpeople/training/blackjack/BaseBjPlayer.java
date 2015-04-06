package com.freshpeople.training.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * BlackJack プレイヤー抽象クラス
 * @author 
 *
 */
public abstract class BaseBjPlayer {
	private String playerName;
	// 21 を超えたらバスト
	protected boolean bust = false;
	// ディーラーか否か
	protected boolean dealer = false;
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
		getSum();
	}
	
	/**
	 * 手持ちのカードを表示する。
	 */
	public void showMyCards() {
		System.out.println("*** [" + playerName + "] ***");
		myCardList.stream().forEach(System.out::println);
		System.out.println("Sum : [" + getSum() + "], diff : [" + (21 - getSum()) + "]");
		if (bust) {
			System.out.println("Busted!!");
		}
		System.out.println("*** [end] ***");
	}
	
	/**
	 * 合計を取得する。
	 * A（エース）は、手持ちのカードの合計が21を超えない範囲で11と数え、超える場合は1として数える。
	 * 21 を超えた場合は bust 状態になる。
	 * @return
	 */
	public int getSum() {
		int sum = 0;
		for (Card c : myCardList) {
			if (c.getStringNumber().equals("A")) {
				if (sum >= 21) {sum += 1;}
				else {sum += 11;}
			}
			else {
				sum += (c.getIntNumber() > 10 ? 10 : c.getIntNumber());
			}
		}
		if (sum > 21) {bust = true;}
		return sum;
	}
	
	//--- getter, setter ---
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public boolean isBust() {
		return bust;
	}

	public boolean isDealer() {
		return dealer;
	}
	
	
}
