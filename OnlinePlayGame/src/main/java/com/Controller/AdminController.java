package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Model.Game;
import com.Model.PlayCard;
import com.Model.User;
import com.service.Gameservice;
import com.service.PlayCardService;
import com.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("Admin")
public class AdminController {
	
	@Autowired
	private PlayCardService playCardService;
	
	@Autowired
	private Gameservice gameservice;
	
	@Autowired
	private UserService userservice;
	
	@PostMapping(value = "AddPlaycard")
	public PlayCard AddGame(@RequestBody PlayCard game) throws Exception {
		return playCardService.AddPlayCard(game);
	}
	
	@PutMapping(value = "UpdateDiscount/{gid}/{discount}")
	public PlayCard UpdateDiscount(@PathVariable("gid") int gid,@PathVariable("discount") int discount) throws Exception {
		return playCardService.UpdateDiscount(gid, discount);
	}
	
	@DeleteMapping(value = "DeletePlaycard/{gid}")
	public PlayCard DeletePlaycard(@PathVariable("gid") int gid) throws Exception {
		return playCardService.DeletePlaycard(gid);
	}
	
	@PatchMapping(value = "UpdatePlaycard")
	public PlayCard UpdateGame(@RequestBody PlayCard game) throws Exception {
		return playCardService.updatePlaycard(game);
	}
	@GetMapping(value = "getAllPlaycards")
	public List<PlayCard> getAllPlaycards(){
		return playCardService.getAllPlaycards();
	}
	
	@PostMapping(value = "AddGame")
	public Game AddGame(@RequestBody Game game) {
		return gameservice.AddGame(game);
	}
	
	@PutMapping(value = "UpdateGame/{gid}/{gname}")
	public Game UpdateGame(@PathVariable("gid") int gid, @PathVariable("gname") String gname) throws Exception {
		return gameservice.UpdateGame(gid,gname);
	}
	
	@GetMapping(value = "getAllGames")
	public List<Game> getAllGame(){
		return gameservice.getAllGame();
	}
	
	@DeleteMapping(value = "DeleteGame/{gid}")
	public Game DeleteGame(@PathVariable("gid") int gid) throws Exception {
		return gameservice.DeleteGame(gid);
	}
	
	@PutMapping(value = "AddGameTocard/{pcid}/{gid}")
	public PlayCard AddGameTocard(@PathVariable("pcid") int pcid, @PathVariable("gid") int gid) throws Exception {
		return gameservice.AddGameTocard(pcid,gid);
	}
	
	@GetMapping(value = "getuserById/{id}")
	public User getuserById(@PathVariable("id") int id) {
		return userservice.getuserById(id);
	}

}
