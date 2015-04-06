package com.freshpeople.training.blackjack;

import java.util.Scanner;

/**
 * プレイヤー具象クラス
 * Bust している場合はヒットできない
 * ユーザに入力を促し、ヒットするかどうかを判別する
 * @author 
 *
 */
public class ConcreteBjPlayer extends BaseBjPlayer {

	public ConcreteBjPlayer(String playerName) {
		super(playerName);
	}

	@Override
	public boolean judgeHit() {
		showMyCards();
		if (bust) {return false;}
		int i = 0;
		do {
			System.out.println("Need more card? input number [1], else input [0]");
			try (Scanner sc = new Scanner(System.in);) {
				i = sc.nextInt();
				if (i != 1 && i != 0) {
					System.out.println("wrong number!! please input 0 or 1.");
				}
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}while(i != 1 && i != 0);
		if (i == 1) {
			return true;
		}
		return false;
	}

}
