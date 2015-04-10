package com.freshpeople.training.blackjack.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import com.freshpeople.training.blackjack.Card;
import com.freshpeople.training.blackjack.CardManager;

/**
 * 
 * @author 
 *
 */
public class CardManagerTest {
	
	private CardManager cardManager;
	
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		System.out.println("@BeforeClass call");
//	}
// 
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//		System.out.println("@AfterClass call");
//	}
 
	@Before
	public void setUp() throws Exception {
		cardManager = new CardManager();
	}
 
//	@After
//	public void tearDown() throws Exception {
//		cardManager = null;
//	}

	@Test
	public void testInit() {
		assertEquals(cardManager.getCardList().size(), 0);
		cardManager.init();
		assertEquals(cardManager.getCardList().size(), 52);
	}

	@Test
	public void testGetRandomCard() {
		cardManager.init();
		ArrayList<Card> list = new ArrayList<>();
		int size = cardManager.getCardList().size();
		for (int i =0; i < size; i++) {
			Card c = cardManager.getRandomCard();
			if (!list.contains(c)) {
				System.out.println(c);
				list.add(c);
			}
			else {
				fail("Duplicate card");
			}
		}
		assertTrue(list.size() == size);
	}

}
