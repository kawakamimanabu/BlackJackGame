package com.freshpeople.training.blackjack;

public class Main {

	public static void main(String[] args) {
		BjDealer com = new BjDealer("dealer");
		BaseBjPlayer you = new BjPlayer("you");
		com.addBjPlayer(you);
		com.startGame();
	}

}
