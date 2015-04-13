package com.freshpeople.training.blackjack;

public class Main {

	public static void main(String[] args) {
		BjDealer com = new BjDealer("dealer");
		BaseBjPlayer you = new BjPlayer("you");
		try {
			com.addBjPlayer(you);
			com.startGame();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
