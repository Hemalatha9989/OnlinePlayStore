package com.service;

import java.util.List;

import com.Model.Game;
import com.Model.Query;
import com.Model.User;
import com.exception.UserException;

public interface UserInterface {
	public User registerUser(User user) throws UserException;
	public User loginUser(String email,String Password) throws UserException ;
	public User addPlaycardToPlayer(int uid ,int gid) throws UserException;
	public User AddQuestion(int uid, String Query) throws UserException;
	public Query UpdateFeedback(int qid,String feedback) throws UserException;
	public List<Query> GetAllUserQuestion(int uid) throws UserException;
	public User getuserById(int id) ;
	public User RemovePlayCard(int uid, int pid) throws UserException;
	public User RemoveCards(int uid) throws UserException;
	public List<Game> GetUserGames(int uid, int pid) throws UserException;
}
