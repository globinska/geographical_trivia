package pl.globinska.trivia.dao;

import pl.globinska.trivia.model.User;

import java.util.List;

public class UserDAOimp implements UserDAO{
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public User create(User newObject) {
        return null;
    }

    @Override
    public User read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(User updateObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }
}
