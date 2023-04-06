package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Model.Query;
@Repository
public interface QueryRepository extends JpaRepository<Query, Integer> {

}
