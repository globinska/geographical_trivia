package pl.globinska.trivia.service;

import pl.globinska.trivia.dao.DAOFactory;
import pl.globinska.trivia.dao.TriviaDAO;
import pl.globinska.trivia.model.Trivia;
import pl.globinska.trivia.model.User;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;

public class TriviaService {

    public void addTrivia(String name, String description, String url, User user){
        Trivia trivia = createTrivia(name, description, url, user);
        DAOFactory factory = DAOFactory.getDAOFactory();
        TriviaDAO triviaDAO = factory.getTriviaDao();
        triviaDAO.create(trivia);

    }
    private Trivia createTrivia(String name, String description, String url, User user){
        Trivia trivia = new Trivia();
        trivia.setTriviaName(name);
        trivia.setTriviaDescription(description);
        trivia.setTriviaUrl(url);
        User userCopy = new User(user);
        trivia.setUser(userCopy);
        return trivia;
    }

}
