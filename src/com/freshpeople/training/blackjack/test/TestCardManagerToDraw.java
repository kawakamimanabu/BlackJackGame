package com.freshpeople.training.blackjack.test;

import java.util.ArrayList;
import java.util.List;

import com.freshpeople.training.blackjack.Card;
import com.freshpeople.training.blackjack.CardManagerTask;

/**
 * Test 用トランプ管理クラス
 * @author
 *
 */
public class TestCardManagerToDraw implements CardManagerTask {
	private final String[] cardMark = {"Spade", "Club", "Heart", "Diamond"};
	private final List<Card> cardList = new ArrayList<>();

	//--- public methods ---
	/**
	 * Joker 2 枚を除く全てのカードをListに詰める
	 */
	@Override
	public void init() {
		cardList.clear();
		for (String mark : cardMark) {
			for (int i = 10; i < 12; i++) {
				Card c = new Card(mark, i);
				cardList.add(c);
			}
		}
	}

	/**
	 * List の中から Spade -> Club -> Heart -> Diamond のカードを順番(1 to 13)に取得する。
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
