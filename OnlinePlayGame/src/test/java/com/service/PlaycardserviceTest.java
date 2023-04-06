package com.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.service.*;
import com.Model.PlayCard;
import com.Repository.PlayCardRepository;
public class PlaycardserviceTest {
   
	
	@Mock
	private PlayCardRepository cardRepository;
	
	@InjectMocks
	private PlayCardService playservice;
	
	@BeforeEach
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testAddPlaycard() throws Exception
	{
		PlayCard playcard = new PlayCard();
		playcard.setId(1);
		playcard.setName("testPlaycard");
		playcard.setOffer(20);
		playcard.setPrice(750);
		playcard.setGames(null);
		when(cardRepository.save(playcard)).thenReturn(playcard);
		PlayCard saveplaycard = playservice.AddPlayCard(playcard);
		
		assertNotNull(saveplaycard);
		assertEquals("testPlaycard",saveplaycard.getName());
		
	}
	@Test
	public void testUpdatePlaycard() throws Exception
	{
		PlayCard playcard = new PlayCard();
		playcard.setId(1);
		playcard.setName("TestPlaycard");
		playcard.setOffer(20);
		playcard.setPrice(750);
		playcard.setGames(null);
		
		when(cardRepository.findById(1)).thenReturn(Optional.of(playcard));
		when(cardRepository.save(playcard)).thenReturn(playcard);
		PlayCard updatedplaycard = playservice.updatePlaycard(playcard);
		
		assertNotNull(updatedplaycard);
		assertEquals("TestPlaycard",updatedplaycard.getName());
	}
	@Test
	public void testGetAllPlaucards()
	{
		PlayCard playcard = new PlayCard();
		playcard.setId(1);
		playcard.setName("TestPlaycard");
		playcard.setOffer(20);
		playcard.setPrice(750);
		playcard.setGames(null);
		
		PlayCard playcard1 = new PlayCard();
		playcard1.setId(2);
		playcard1.setName("TestPlaycard1");
		playcard1.setOffer(25);
		playcard1.setPrice(700);
		playcard1.setGames(null);
		
		List<PlayCard> cardList = new ArrayList<PlayCard>();
		cardList.add(playcard1);
		cardList.add(playcard);
		
		when(cardRepository.findAll()).thenReturn(cardList);
		List<PlayCard> foundPlaycardList = playservice.getAllPlaycards();
		 assertNotNull(foundPlaycardList);
		 assertEquals(2,foundPlaycardList.size());
		
	}
	
	
}