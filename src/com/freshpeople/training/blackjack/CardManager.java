package com.freshpeople.training.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * トランプ管理クラス
 * @author
 *
 */
public class CardManager {
	private final String[] cardMark = {"Spade", "Club", "Heart", "Diamond"};
	private final List<Card> cardList = new ArrayList<>();

	//--- public methods ---
	/**
	 * Joker 2 枚を除く全てのカードをListに詰める
	 */
	public void init() {
		cardList.clear();
		for (String mark : cardMark) {
			for (int i = 1; i <= 13; i++) {
				Card card = new Card(mark, i);
				cardList.add(card);
			}
		}
	}

	/**
	 * List の中から任意のカードを選んで取得する。
	 * カードが 1 枚も無い場合は Exception を発生させること
	 * 例外メッセージは以下の通り
	 *  "No more card."
	 * @return
	 */
	public Card getRandomCard() throws Exception {
		if (cardList.size() > 0) {
			Random random = new Random();
			int num = random.nextInt(cardList.size());
			Card c = cardList.get(num);
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
