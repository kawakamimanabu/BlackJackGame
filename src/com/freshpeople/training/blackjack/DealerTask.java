package com.freshpeople.training.blackjack;

/**
 * ディーラーがやるべきことのインタフェイス
 * @author
 *
 */
public interface DealerTask {
	/**
	 * リストにプレイヤーを追加
	 * @param bjPlayer
	 */
	public void addBjPlayer(BaseBjPlayer bjPlayer);
	/**
	 * ゲーム開始
	 */
	public void startGame();
	/**
	 * 最初のカードを示す
	 */
	public void showMyFirstCard();
}
