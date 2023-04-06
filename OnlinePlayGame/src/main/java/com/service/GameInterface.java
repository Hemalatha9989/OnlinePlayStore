package com.service;

import java.util.List;

import com.Model.Game;
import com.Model.PlayCard;
import com.exception.GameException;

public interface GameInterface {
	public Game AddGame(Game game);
	public Game UpdateGame(int gid, String gname) throws GameException;
	public List<Game> getAllGame();
	public Game DeleteGame(int gid) throws GameException;
	public PlayCard AddGameTocard(int pcid, int gid) throws GameException;
}
