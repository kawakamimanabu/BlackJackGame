package com.freshpeople.training.blackjack.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.freshpeople.training.blackjack.Card;

public class CardTest {

	@Test
	public void testCardIntNumber_1() {
		Card c = new Card("Club", 0);
		assertEquals(c.getIntNumber(), 1);
	}
	
	@Test
	public void testCardIntNumber_2() {
		Card c = new Card("Club", 1);
		assertEquals(c.getIntNumber(), 2);
	}

	@Test
	public void testCardIntNumber_3() {
		Card c = new Card("Club", 2);
		assertEquals(c.getIntNumber(), 3);
	}

	@Test
	public void testCardIntNumber_4() {
		Card c = new Card("Club", 3);
		assertEquals(c.getIntNumber(), 4);
	}

	@Test
	public void testCardIntNumber_5() {
		Card c = new Card("Club", 4);
		assertEquals(c.getIntNumber(), 5);
	}

	@Test
	public void testCardIntNumber_6() {
		Card c = new Card("Club", 5);
		assertEquals(c.getIntNumber(), 6);
	}

	@Test
	public void testCardIntNumber_7() {
		Card c = new Card("Club", 6);
		assertEquals(c.getIntNumber(), 7);
	}

	@Test
	public void testCardIntNumber_8() {
		Card c = new Card("Club", 7);
		assertEquals(c.getIntNumber(), 8);
	}

	@Test
	public void testCardIntNumber_9() {
		Card c = new Card("Club", 8);
		assertEquals(c.getIntNumber(), 9);
	}

	@Test
	public void testCardIntNumber_10() {
		Card c = new Card("Club", 9);
		assertEquals(c.getIntNumber(), 10);
	}

	@Test
	public void testCardIntNumber_11() {
		Card c = new Card("Club", 10);
		assertEquals(c.getIntNumber(), 11);
	}

	@Test
	public void testCardIntNumber_12() {
		Card c = new Card("Club", 11);
		assertEquals(c.getIntNumber(), 12);
	}

	@Test
	public void testCardIntNumber_13() {
		Card c = new Card("Club", 12);
		assertEquals(c.getIntNumber(), 13);
	}
}
