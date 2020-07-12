package pl.globinska.trivia.dao;

import pl.globinska.trivia.model.Vote;

import java.util.List;

public class VoteDAOimp implements VoteDAO {
    @Override
    public List<Vote> getVoteByIDs(long userId, long triviaId) {
        return null;
    }

    @Override
    public Vote create(Vote newObject) {
        return null;
    }

    @Override
    public Vote read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(Vote updateObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    @Override
    public List<Vote> getAll() {
        return null;
    }
}
