package com.freshpeople.training.blackjack.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.freshpeople.training.blackjack.Card;

public class CardTest {

	@Test
	public void testGetIntNumber() {
		for (int i = 1; i <= 13; i++) {
			Card c = new Card("Club", i);
			assertEquals(c.getIntNumber(), i);
		}
	}

	@Test
	public void testGetStringNumber() {
		Card c = new Card("Club", 1);
		assertEquals(c.getStringNumber(), "A");
		for (int i = 2; i <= 10; i++) {
			c = new Card("Club", i);
			assertEquals(c.getStringNumber(), String.valueOf(i));
		}
		c = new Card("Club", 11);
		assertEquals(c.getStringNumber(), "J");
		c = new Card("Club", 12);
		assertEquals(c.getStringNumber(), "Q");
		c = new Card("Club", 13);
		assertEquals(c.getStringNumber(), "K");
	}
}
