package pl.globinska.trivia.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Discovery {
    private int triviaId;
    private String triviaName;
    private String triviaUrl;
    private String triviaDescription;
    private Timestamp triviaTime;
    private User user;
    private int upvote;
    private int downvote;

    public Discovery() {
    }

    public Discovery(Discovery discovery) {
        this.triviaId = discovery.triviaId;
        this.triviaName = discovery.triviaName;
        this.triviaUrl = discovery.triviaUrl;
        this.triviaDescription = discovery.triviaDescription;
        this.triviaTime = new Timestamp(discovery.triviaTime.getTime());
        this.user = new User(discovery.user);
        this.upvote = discovery.upvote;
        this.downvote = discovery.downvote;
    }
}

