package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Model.Query;
import com.service.QueryService;

@RestController
@CrossOrigin
@RequestMapping("CustomerCare")
public class CustomerCareController {
	
	@Autowired
	private QueryService queryService;
	
	@GetMapping("getAllQueries")
	public List<Query> getAllQueries(){
		return queryService.getAllQueries();
	}
	
	@PutMapping(value = "updateQuery/{qid}/{answer}")
	public Query updateQuery(@PathVariable("qid") int qid,@PathVariable("answer") String answer) throws Exception {
		return queryService.updateQuery(qid, answer);
	}

}
