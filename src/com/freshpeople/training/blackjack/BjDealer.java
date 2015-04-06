package com.freshpeople.training.blackjack;

/**
 * ディーラークラス
 * 手持ちのカードの合計が 16 以下の場合は常にヒットしなくてはいけない
 * @author 
 *
 */
public class BjDealer extends BaseBjPlayer implements DealerTask {
	// この数以下の場合は必ずヒットする
	private int point = 16;

	/**
	 * コンストラクタ
	 * ディーラーであることを設定する
	 * @param playerName
	 */
	public BjDealer(String playerName) {
		super(playerName);
		dealer = true;
	}

	@Override
	public boolean judgeHit() {
		if (getSum() <= point)
			return true;
		return false;
	}

	@Override
	public void showMyFirstCard() {
		System.out.println("*** dealer's first card ***");
		System.out.println(myCardList.get(0).toString());
		System.out.println("********");
	}
}
