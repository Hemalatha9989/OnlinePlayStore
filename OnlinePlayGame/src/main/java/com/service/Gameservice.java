package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Model.Game;
import com.Model.PlayCard;
import com.Repository.GameRepository;
import com.Repository.PlayCardRepository;
import com.exception.GameException;

@Service
public class Gameservice implements GameInterface{
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private PlayCardRepository cardRepository;

	public Game AddGame(Game game) {
		// TODO Auto-generated method stub
		return gameRepository.save(game);
	}

	public Game UpdateGame(int gid, String gname) throws GameException {
		// TODO Auto-generated method stub
		Game game = gameRepository.findById(gid).get();
		if(game != null) {
			game.setName(gname);
		return	gameRepository.save(game);
		}
		throw new GameException("Game Not Found");
	}

	public List<Game> getAllGame() {
		// TODO Auto-generated method stub
		return gameRepository.findAll();
	}

	public Game DeleteGame(int gid) throws GameException {
		Game game = gameRepository.findById(gid).get();
		if(game != null) {
			gameRepository.deleteById(game.getId());
			return game;

		}
		throw new GameException("Delete successful Game Not Found");
	}

	public PlayCard AddGameTocard(int pcid, int gid) throws GameException {
		// TODO Auto-generated method stub
		PlayCard card = cardRepository.findById(pcid).get();
		if(card !=null) {
			Game game = gameRepository.findById(gid).get();
			if(game != null) {
				card.addgame(game);
				return cardRepository.save(card);
			}else {
				throw new GameException("Game Not Found");
			}
		}else {
			throw new GameException("Playcard Not Found");
		}
		
	}

}
