package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Model.PlayCard;

@Repository
public interface PlayCardRepository extends JpaRepository<PlayCard, Integer>{
	

}
