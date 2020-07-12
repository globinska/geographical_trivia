package pl.globinska.trivia.service;

import pl.globinska.trivia.dao.DAOFactory;
import pl.globinska.trivia.dao.UserDAO;
import pl.globinska.trivia.model.User;

public class UserService {

    public void addUser(String username, String email, String password){
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setActive(true);
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.create(user);
    }
}
