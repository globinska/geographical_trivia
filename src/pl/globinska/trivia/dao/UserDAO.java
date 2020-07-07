package pl.globinska.trivia.dao;

import pl.globinska.trivia.model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long>{

    List<User> getAll();
    User getUserByUsername(String username);

}
