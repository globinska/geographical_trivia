package pl.globinska.trivia.dao;

public class MySqlDAOFactory extends DAOFactory{
    @Override
    public TriviaDAO getTriviaDao() {
        return new TriviaDAOimp();
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOimp();
    }

    @Override
    public VoteDAO getVoteDAO() {
        return new VoteDAOimp();
    }
}
