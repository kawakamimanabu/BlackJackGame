package com.freshpeople.training.blackjack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * プレイヤー具象クラス
 * Bust している場合はヒットできない
 * ユーザに入力を促し、ヒットするかどうかを判別する
 * @author
 *
 */
public class BjPlayer extends BaseBjPlayer {

	public BjPlayer(String playerName) {
		super(playerName);
	}

	@Override
	public boolean judgeHit() {
		showMyCards();
		if (bust) {
			return false;
		}
		int i = 0;
		for(;;) {
			System.out.println("Input number [1] to add more card, else input [0]");
			try
			{
				InputStreamReader reader = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(reader);
				String val = br.readLine().trim();
				i = Integer.parseInt(val);
				if (i != 1 && i != 0) {
					System.out.println("wrong number!! please input [0] or [1].");
				}
				else {
					if (i == 1) return true;
					else return false;
				}
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				break;
			}
		}
		return false;
	}

}
