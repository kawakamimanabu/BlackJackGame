package com.freshpeople.training.blackjack;

/**
 * カード管理クラスが実装するメソッド
 * @author
 *
 */
public interface CardManagerTask {
	/**
	 * カードの初期化
	 */
	public void init();
	/**
	 * ランダムにカードを取り出す
	 * @return
	 * @throws Exception
	 */
	public Card getRandomCard() throws Exception;
}
