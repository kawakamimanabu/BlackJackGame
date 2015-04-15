package com.freshpeople.training.blackjack;

/**
 * トランプの1枚の情報を保持するクラス
 * mark : "Spade", "Club", "Heart", "Diamond"
 * number : 数字 (1 = "A", 11 = "J", 12 = "Q", 13 = "K" の文字列で保持する)
 * @author
 *
 */
public class Card {
	private String mark = "";
	private String number = "";

	/**
	 * コンストラクタ
	 * @param mark
	 * @param number
	 */
	public Card(String mark, int number) {
	}

	/**
	 * マーク文字列を取得します。
	 * @return
	 */
	public String getMark() {
	}

	/**
	 * カードの数値を取得します。
	 * @return
	 */
	public int getIntNumber() {
	}

	/**
	 * カードの数値を文字列で取得します。
	 * 1 のときは "A", 11 のときは "J", 12 のときは "Q", 13 のときは "K"
	 * @return
	 */
	public String getStringNumber() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [mark=" + mark + ", number=" + number + "]";
	}
}
