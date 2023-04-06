package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Model.Query;
import com.Repository.QueryRepository;
import com.exception.QueryException;

@Service
public class QueryService implements QueryInterface {
	@Autowired
	private QueryRepository queryRepository;
	
	public List<Query> getAllQueries(){
		return queryRepository.findAll();
	}
	
	public Query updateQuery(int qid,String Answer) throws QueryException {
		Query query = queryRepository.findById(qid).get();
		if(query != null) {
			query.setAnswerCreatedAt(LocalDate.now());
			query.setAnswer(Answer);
			return queryRepository.save(query);
		}else {
			throw new QueryException("Question Not Found");
		}
	}
}

