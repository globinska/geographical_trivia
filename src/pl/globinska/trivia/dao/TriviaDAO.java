package pl.globinska.trivia.dao;


import pl.globinska.trivia.model.Trivia;

import java.util.List;

public interface TriviaDAO extends GenericDAO<Trivia, Long>{

    List<Trivia> getAll();

}
