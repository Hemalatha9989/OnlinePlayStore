package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Model.Game;
import com.Model.PlayCard;
import com.Model.Query;
import com.Model.User;
import com.Repository.PlayCardRepository;
import com.Repository.QueryRepository;
import com.Repository.Userrepository;
import com.exception.UserException;

@Service
public class UserService implements UserInterface{
	
	@Autowired
	private Userrepository userRepository;
	
	@Autowired
	private PlayCardRepository playcardRepository;
	
	@Autowired
	private QueryRepository queryRepository;
//	to register user
	public User registerUser(User user) throws UserException {
		User user2 = userRepository.findByEmail(user.getEmail());
		if(user2 == null) {
			user.setRole("ROLE_USER");
			return userRepository.save(user);
		}
		throw new UserException("User Already Exist with "+user.getEmail());
	}
	
//	to login 
	public User loginUser(String email,String Password) throws UserException {
		User user = userRepository.authenticateuser(email, Password);
		if(user != null) {
			return user;
		}
		throw new UserException("Worng Credentials");
	}

//	to playgame
	
	public User addPlaycardToPlayer(int uid ,int gid) throws UserException {
		User user = userRepository.findById(uid).get();
		PlayCard game = playcardRepository.findById(gid).get();
		if(user != null) {
			if(game !=null) {
//				game.setAmountToPay(game.getPrice()*(game.getOffer()/100));
				 user.AddPlaycard(game);
				 return userRepository.save(user);	
			}else {
				throw new UserException("Game Not Avilable");
			}
		}else {
			throw new UserException("User Not Found");
		}
	}
	
	public User AddQuestion(int uid, String Query) throws UserException {
		User user = userRepository.findById(uid).get();
		if(user != null) {
			Query query2 = new Query();
			query2.setQuestion(Query);
			query2.setQueryCreatedDate(LocalDate.now());
			user.addQuestion(query2);
			queryRepository.save(query2);
			return userRepository.save(user);
		}else {
			throw new UserException("User Not Exist with userId "+uid);
		}
	}
	
	public Query UpdateFeedback(int qid,String feedback) throws UserException {
		Query query = queryRepository.findById(qid).get();
		if(query != null) {
			if(query.getAnswer()== "") {
				throw new UserException("Please Wait Till An Update from Us ! Thank you");
			}else {
				query.setUserfeedback(feedback);
				query.setFeedBacakDate(LocalDate.now());
				return queryRepository.save(query);
			}	
		}else {
			throw new UserException("Question Not Found");
		}
	}
	
	public List<Query> GetAllUserQuestion(int uid) throws UserException{
		User user = userRepository.findById(uid).get();
		if(user != null) {
			return user.getCustomerCare();
		}else {
			throw new UserException("User not Found");
		}
	}

	public User getuserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	public User RemovePlayCard(int uid, int pid) throws UserException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(uid).get();
		if(user != null) {
			PlayCard card = playcardRepository.findById(pid).get();
			if(card != null) {
				user.getPlayCards().remove(card);
				return userRepository.save(user);		 
			}else {
				throw new UserException("Playcard not Found");
			}
		}else {
			throw new UserException("User not Found");
		}
	}

	public User RemoveCards(int uid) throws UserException {
		User user = userRepository.findById(uid).get();
		if(user != null) {
			 user.getPlayCards().clear();
			 return userRepository.save(user);
		}else {
			throw new UserException("User not Found");
		}
	}

	public List<Game> GetUserGames(int uid, int pid) throws UserException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(uid).get();
		if(user != null) {
			PlayCard card = playcardRepository.findById(pid).get();
			if(card != null) {
				return card.getGames();	 
			}else {
				throw new UserException("Playcard not Found");
			}
		}else {
			throw new UserException("User not Found");
		}
	}
	
	
}












