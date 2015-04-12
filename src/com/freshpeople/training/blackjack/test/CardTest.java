package com.freshpeople.training.blackjack.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.freshpeople.training.blackjack.Card;

public class CardTest {

	@Test
	public void testCardIntNumber() {
		for (int i = 1; i <= 13; i++) {
			Card c = new Card("Club", i);
			assertEquals(c.getIntNumber(), i);
		}
	}
}
