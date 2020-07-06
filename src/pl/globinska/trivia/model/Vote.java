package pl.globinska.trivia.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Vote {
    private VoteType voteType;
    private int voteId;
    private int triviaId;
    private int userId;
    private Timestamp date;

    public Vote() {
    }

    public Vote(Vote vote) {
        this.voteType = vote.voteType;
        this.voteId = vote.voteId;
        this.triviaId = vote.triviaId;
        this.userId = vote.userId;
        this.date = new Timestamp(vote.date.getTime());
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getTriviaId() {
        return triviaId;
    }

    public void setTriviaId(int triviaId) {
        this.triviaId = triviaId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return voteId == vote.voteId &&
                triviaId == vote.triviaId &&
                userId == vote.userId &&
                voteType == vote.voteType &&
                date.equals(vote.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voteType, voteId, triviaId, userId, date);
    }

    @Override
    public String toString() {
        return "Vote{" +
                "voteType=" + voteType +
                ", voteId=" + voteId +
                ", triviaId=" + triviaId +
                ", userId=" + userId +
                ", date=" + date +
                '}';
    }
}
