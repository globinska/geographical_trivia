package pl.globinska.trivia.dao;

public abstract class DAOFactory {
    public abstract TriviaDAO getTriviaDao();
    public abstract UserDAO getUserDAO();
    public abstract VoteDAO getVoteDAO();
}
