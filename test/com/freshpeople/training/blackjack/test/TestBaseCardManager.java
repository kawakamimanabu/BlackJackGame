package com.freshpeople.training.blackjack.test;

import java.util.ArrayList;
import java.util.List;

import com.freshpeople.training.blackjack.Card;
import com.freshpeople.training.blackjack.CardManagerTask;

/**
 * テスト用 CardManager クラスの基底クラス
 * @author
 *
 */
public abstract class TestBaseCardManager implements CardManagerTask {
	protected final String[] cardMark = {"Spade", "Club", "Heart", "Diamond"};
	protected final List<Card> cardList = new ArrayList<>();

	/**
	 * List の中から Spade -> Club -> Heart -> Diamond のカードを順番に 1 枚取得する。
	 * カードが 1 枚も無い場合は Exception を発生させること
	 * 例外メッセージは以下の通り
	 *  "No more card."
	 * @return
	 */
	@Override
	public Card getRandomCard() throws Exception {
		if (cardList.size() > 0) {
			Card c = cardList.get(0);
			cardList.remove(c);
			return c;
		}
		else {
			throw new Exception("No more card.");
		}
	}

	//--- getter, setter ---
	public List<Card> getCardList() {
		return cardList;
	}

}
