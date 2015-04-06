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
	String[] cardMark = {"Spade", "Club", "Heart", "Diamond"};
	private List<Card> cardList = new ArrayList<>();

	//--- public methods ---
	/**
	 * Joker 2 枚を除く全てのカードをListに詰める
	 */
	public void init() {
		cardList = new ArrayList<>();
		for (String mark : cardMark) {
			for (int i = 0; i < 13; i++) {
				Card card = new Card(mark, i);
				cardList.add(card);
			}
		}
	}

	/**
	 * List の中から任意のカードを選んで取得する。
	 * @return
	 */
	public Card getRandomCard() {
		Random random = new Random();
		int num = random.nextInt(cardList.size());
		Card c = cardList.get(num);
		cardList.remove(c);
		return c;
	}

	//--- private methods ---


	//--- getter, setter ---
	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}

}
