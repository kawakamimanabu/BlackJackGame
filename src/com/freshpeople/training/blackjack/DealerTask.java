package com.freshpeople.training.blackjack;

import java.util.List;

/**
 * ディーラーがやるべきことのインタフェイス
 * @author
 *
 */
public interface DealerTask {
	/**
	 * リストにプレイヤーを追加する
	 * 同名プレイヤーを追加しようとした場合は Exception を発生させること
	 * 例外メッセージは以下の通り
	 *  "Duplicate BlackJack Player Name.[重複したプレイヤー名]"
	 * @param bjPlayer
	 */
	public void addBjPlayer(BaseBjPlayer bjPlayer) throws Exception;
	/**
	 * プレイヤー名の一覧を取得する
	 * @return
	 */
	public List<String> getPlayerNameList();
	/**
	 * ゲーム開始
	 */
	public void startGame() throws Exception;
	/**
	 * 最初のカードを示す
	 */
	public void showMyFirstCard();
}
