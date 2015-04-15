package com.freshpeople.training.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ディーラークラス
 * 手持ちのカードの合計が 16 以下の場合は常にヒットしなくてはいけない
 * @author
 *
 */
public class BjDealer extends BaseBjPlayer implements DealerTask {
	private CardManagerTask cardManagerTask = new CardManager();
	private List<BaseBjPlayer> bjPlayerList = new ArrayList<>();
	private List<BaseBjPlayer> winList	= new ArrayList<>();
	private List<BaseBjPlayer> loseList	= new ArrayList<>();
	private List<BaseBjPlayer> drawList	= new ArrayList<>();

	// この数以下の場合は必ずヒットする
	private int point = 16;

	/**
	 * コンストラクタ
	 * @param playerName
	 */
	public BjDealer(String playerName) {
	}

	@Override
	public boolean judgeHit() {
	}

	@Override
	public void showMyFirstCard() {
	}

	@Override
	public void addBjPlayer(BaseBjPlayer bjPlayer) throws Exception{
	}

	@Override
	public List<String> getPlayerNameList() {
	}

	@Override
	public void startGame() throws Exception {
		// 勝敗者リストを初期化
		// カードを初期化
		// ディーラーを含む全プレイヤーにカードを配る
		// ディーラー自身の最初の 1 枚を公開する
		// ディーラー以外の Player が Hit する場合にカードを配る
		// 最後にディーラー自身に対して Hit する
		// 結果判定
	}

	//--- private methods ---
	/**
	 * ディーラーを含む全プレイヤーにカードを配る
	 * @throws Exception
	 */
	private void dealCards() throws Exception {
		// 全 Player に 2 枚ずつカードを配る
		// ディーラー自身にカードを配る
	}

	/**
	 * 引数で与えられたプレイヤーに対して hit するか否かを判別して
	 * Hit する場合はカードを配る
	 * @param player
	 * @throws Exception
	 */
	private void askHitDealCard(BaseBjPlayer player) throws Exception {
	}

	/**
	 * 結果判定
	 */
	private void judgeGame() {
	}


	//--- getter, setter ---
	/**
	 * cardManager をセットする
	 * @param cardManagerTask
	 */
	public void setCardManagerTask(CardManagerTask cardManagerTask) {
	}

	/**
	 * @return winList
	 */
	public List<BaseBjPlayer> getWinList() {
	}

	/**
	 * @return loseList
	 */
	public List<BaseBjPlayer> getLoseList() {
	}

	/**
	 * @return drawList
	 */
	public List<BaseBjPlayer> getDrawList() {
	}
}
