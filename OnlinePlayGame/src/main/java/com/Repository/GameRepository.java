package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{

}
