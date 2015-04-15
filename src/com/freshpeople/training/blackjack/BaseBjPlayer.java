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
	}

	/**
	 * 手持ちのカードをクリアする
	 */
	public void clearCard() {
	}

	/**
	 * 手持ちのカードを表示する。
	 */
	public void showMyCards() {
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((playerName == null) ? 0 : playerName.hashCode());
		return result;
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseBjPlayer other = (BaseBjPlayer) obj;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		return true;
	}

	//--- private methods ---
	/**
	 * 合計を取得する。
	 * A（エース）は、手持ちのカードの合計が 21 未満では 11 と数え、21 以上の場合は 1 として数える。
	 * J, Q, K は 10 として数える
	 */
	private void calcSum() {
	}

	//--- getter ---
	/**
	 * プレイヤーの名前を取得する
	 * @return
	 */
	public String getPlayerName() {
	}

	/**
	 * 合計が BLACKJACK_NUMBER を超えていた場合は true
	 * @return
	 */
	public boolean isBust() {
	}

	/**
	 * @return sum
	 */
	public int getSum() {
	}

	/**
	 * BLACKJACK_NUMBER との差を取得する
	 */
	public int getDiff() {
	}
}
