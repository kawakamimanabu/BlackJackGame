package com.freshpeople.training.blackjack;

/**
 * トランプの1枚の情報を保持するクラス
 * mark : "Spade", "Club", "Heart", "Diamond"
 * number : 数字 (0 = "A", 10 = "J", 11 = "Q", 12 = "K" の文字列で保持する)
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
		this.mark = mark;
		if (number == 0) {this.number = "A";}
		else if (number == 10) {this.number = "J";}
		else if (number == 11) {this.number = "Q";}
		else if (number == 12) {this.number = "K";}
		else {this.number = String.valueOf(number + 1);}
	}

	/**
	 * マーク文字列を取得します。
	 * @return
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * カードの数値を取得します。
	 * @return
	 */
	public int getIntNumber() {
		if (number.equals("A")) {return 1;}
		else if (number.equals("J")) {return 11;}
		else if (number.equals("Q")) {return 12;}
		else if (number.equals("K")) {return 13;}
		else {return Integer.parseInt(number);}
	}

	/**
	 * カードの数値を文字列で取得します。
	 * @return
	 */
	public String getStringNumber() {
		return number;
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
