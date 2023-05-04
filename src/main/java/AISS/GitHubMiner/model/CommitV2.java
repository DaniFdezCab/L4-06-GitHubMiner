package AISS.GitHubMiner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitV2 {

    @JsonProperty("author")
    private Author author;
    @JsonProperty("committer")
    private Committer committer ;
    @JsonProperty("message")
    private CommitV2 message;

    public CommitV2(Author author, Committer committer, CommitV2 message) {
        this.author = author;
        this.committer = committer;
        this.message = message;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Committer getCommitter() {
        return committer;
    }

    public void setCommitter(Committer committer) {
        this.committer = committer;
    }

    public CommitV2 getMessage() {
        return message;
    }

    public void setMessage(CommitV2 message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CommitV2{" +
                "author=" + author +
                ", committer=" + committer +
                ", message=" + message +
                '}';
    }
}
