package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Model.PlayCard;
import com.Repository.PlayCardRepository;
import com.exception.PlayCardException;

@Service
public class PlayCardService implements PlayCardInterface{
	@Autowired
	private PlayCardRepository playCardRepository;
	
//	addGame
	
	public PlayCard AddPlayCard(PlayCard game) throws PlayCardException {
		return playCardRepository.save(game);
	}
	
//	update Game discount
	public PlayCard UpdateDiscount(int gid,int discount) throws PlayCardException {
		PlayCard game = playCardRepository.findById(gid).get();
		if(game != null) {
			game.setOffer(discount);
		return 	playCardRepository.save(game);
		}else {
			throw new PlayCardException("Game Not In List");
		}
	}
	
//	update game
	public PlayCard updatePlaycard( PlayCard game) throws PlayCardException {
		PlayCard game2 = playCardRepository.findById(game.getId()).get();
		if(game2 != null) {
			return playCardRepository.save(game);
		}else {
			throw new PlayCardException("Game Not In List");
		}
	}
	
	
//	Delete Game
	public PlayCard DeletePlaycard(int gid) throws PlayCardException {
		PlayCard game = playCardRepository.findById(gid).get();
		if(game != null) {
			game.getGames().clear();
			playCardRepository.save(game);
			playCardRepository.deleteById(game.getId());
			 return game;
//			 "Deleted SuccessFully";
		}else {
			throw new PlayCardException("Game Not In List");
		}
	}
	
//	seeAllGames
	
	public List<PlayCard> getAllPlaycards(){
		return playCardRepository.findAll();
	}

}

