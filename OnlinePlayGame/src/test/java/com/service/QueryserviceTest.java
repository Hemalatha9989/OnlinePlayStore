package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Model.Query;
import com.Repository.QueryRepository;


class QueryserviceTest {

    @InjectMocks
    private QueryService queryService;

    @Mock
    private QueryRepository queryRepository;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllQueries() {
        Query query1 = new Query(1, "What is Java?", null, null);
        Query query2 = new Query(2, "What is Mockito?", null, null);

        List<Query> queryList = Arrays.asList(query1, query2);

        when(queryRepository.findAll()).thenReturn(queryList);

        List<Query> result = queryService.getAllQueries();

        assertEquals(2, result.size());
        assertEquals("What is Java?", result.get(0).getQuestion());
        assertEquals("What is Mockito?", result.get(1).getQuestion());
    }

    @Test
    void testUpdateQuery() throws Exception {
        Query query = new Query(1, "What is Java?", null, null);
        String answer = "Java is a programming language.";

        when(queryRepository.findById(1)).thenReturn(Optional.of(query));
        when(queryRepository.save(query)).thenReturn(query);

        Query result = queryService.updateQuery(1, answer);

        assertEquals("Java is a programming language.", result.getAnswer());
        assertEquals(LocalDate.now(), result.getAnswerCreatedAt());
    }

    

}
