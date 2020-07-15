package pl.globinska.trivia.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Trivia{
    private int triviaId;
    private String triviaName;
    private String triviaUrl;
    private String triviaDescription;
    private Timestamp triviaTime;
    private User user;
    private int upvote;
    private int downvote;

    public Trivia() {
    }

    public Trivia(Trivia trivia) {
        this.triviaId = trivia.triviaId;
        this.triviaName = trivia.triviaName;
        this.triviaUrl = trivia.triviaUrl;
        this.triviaDescription = trivia.triviaDescription;
        this.triviaTime = new Timestamp(trivia.triviaTime.getTime());
        this.user = new User(trivia.user);
        this.upvote = trivia.upvote;
        this.downvote = trivia.downvote;
    }

    public int getTriviaId() {
        return triviaId;
    }

    public void setTriviaId(int triviaId) {
        this.triviaId = triviaId;
    }

    public String getTriviaName() {
        return triviaName;
    }

    public void setTriviaName(String triviaName) {
        this.triviaName = triviaName;
    }

    public String getTriviaUrl() {
        return triviaUrl;
    }

    public void setTriviaUrl(String triviaUrl) {
        this.triviaUrl = triviaUrl;
    }

    public String getTriviaDescription() {
        return triviaDescription;
    }

    public void setTriviaDescription(String triviaDescription) {
        this.triviaDescription = triviaDescription;
    }

    public Timestamp getTriviaTime() {
        return triviaTime;
    }

    public void setTriviaTime(Timestamp triviaTime) {
        this.triviaTime = triviaTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public int getDownvote() {
        return downvote;
    }

    public void setDownvote(int downvote) {
        this.downvote = downvote;
    }
}

