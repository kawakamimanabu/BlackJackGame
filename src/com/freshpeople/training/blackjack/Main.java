package com.freshpeople.training.blackjack;

public class Main {

	public static void main(String[] args) {
		
		BlackJackManager bjMngr = new BlackJackManager();
		
		BaseBjPlayer you = new ConcreteBjPlayer("you");
		BaseBjPlayer com = new BjDealer("dealer");
		bjMngr.addBjPlayer(you);
		bjMngr.addBjPlayer(com);
		
		bjMngr.startGame();

//		if (you.isBust() || (yourGap > compGap && !com.isBust())) {
//			System.out.println("You missed the game...");
//		}
//		else {
//			System.out.println("You won the game!!");
//		}
		
	}

}
