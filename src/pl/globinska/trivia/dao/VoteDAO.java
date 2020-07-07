package pl.globinska.trivia.dao;

import pl.globinska.trivia.model.Vote;

import java.util.List;

public interface VoteDAO extends GenericDAO<Vote, Long>{

    List<Vote> getVoteByIDs(long userId, long triviaId);
}
