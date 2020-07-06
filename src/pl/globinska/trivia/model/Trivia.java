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
}

