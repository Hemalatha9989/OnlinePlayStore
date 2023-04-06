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

import com.Model.Game;
import com.Model.PlayCard;
import com.Repository.GameRepository;
import com.Repository.PlayCardRepository;
import com.service.Gameservice;

public class GameserviceTest {

    @Mock
    private GameRepository gameRepository;

    @Mock
    private PlayCardRepository cardRepository;

    @InjectMocks
    private Gameservice gameService;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddGame() {
        Game game = new Game();
        game.setId(1);
        game.setName("testGame");
        game.setImageurl("testImageUrl");
        game.setCreatedby("testCreatedby");
        game.setLevel("testLevel");

        when(gameRepository.save(game)).thenReturn(game);

        Game savedGame = gameService.AddGame(game);

        assertNotNull(savedGame);
        assertEquals("testGame", savedGame.getName());
    }

    @Test
    public void testUpdateGame() throws Exception {
        Game game = new Game();
        game.setId(1);
        game.setName("testGame");
        game.setImageurl("testImageUrl");
        game.setCreatedby("testCreatedby");
        game.setLevel("testLevel");

        when(gameRepository.findById(1)).thenReturn(Optional.of(game));
        when(gameRepository.save(game)).thenReturn(game);

        Game updatedGame = gameService.UpdateGame(1, "updatedTestGame");

        assertNotNull(updatedGame);
        assertEquals("updatedTestGame", updatedGame.getName());
    }

    @Test
    public void testGetAllGame() {
        Game game1 = new Game();
        game1.setId(1);
        game1.setName("testGame1");
        game1.setImageurl("testImageUrl1");
        game1.setCreatedby("testCreatedby1");
        game1.setLevel("testLevel1");

        Game game2 = new Game();
        game2.setId(2);
        game2.setName("testGame2");
        game2.setImageurl("testImageUrl2");
        game2.setCreatedby("testCreatedby2");
        game2.setLevel("testLevel2");

        List<Game> gameList = new ArrayList<Game>();
        gameList.add(game1);
        gameList.add(game2);

        when(gameRepository.findAll()).thenReturn(gameList);

        List<Game> foundGameList = gameService.getAllGame();

        assertNotNull(foundGameList);
        assertEquals(2, foundGameList.size());
    }

    @Test
    public void testDeleteGame() throws Exception {
        Game game = new Game();
        game.setId(1);
        game.setName("testGame");
        game.setImageurl("testImageUrl");
        game.setCreatedby("testCreatedby");
        game.setLevel("testLevel");

        when(gameRepository.findById(1)).thenReturn(Optional.of(game));
        when(gameRepository.save(game)).thenReturn(game);

        Game deletedGame = gameService.DeleteGame(1);

        assertNotNull(deletedGame);
        assertEquals("testGame", deletedGame.getName());
    }

    @Test
    public void testAddGameTocard() throws Exception {
        PlayCard card = new PlayCard();
        card.setId(1);
        card.setName("testPlayCard");

        Game game = new Game();
        game.setId(1);
        game.setName("testGame");
        game.setImageurl("testImageUrl");
        game.setCreatedby("testCreatedby");
        game.setLevel("testLevel");
    }
    
}
