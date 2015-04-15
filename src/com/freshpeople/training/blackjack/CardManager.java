package com.freshpeople.training.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * トランプ管理クラス
 * @author
 *
 */
public class CardManager implements CardManagerTask {
	private final String[] cardMark = {"Spade", "Club", "Heart", "Diamond"};
	private final List<Card> cardList = new ArrayList<>();

	//--- public methods ---
	/**
	 * Joker 2 枚を除く全てのカードをListに詰める
	 */
	@Override
	public void init() {
	}

	/**
	 * List の中から任意のカードを選んで取得する。
	 * カードが 1 枚も無い場合は Exception を発生させること
	 * 例外メッセージは以下の通り
	 *  "No more card."
	 * @return
	 */
	@Override
	public Card getRandomCard() throws Exception {
	}

	//--- getter, setter ---
	public List<Card> getCardList() {
		return cardList;
	}

}
