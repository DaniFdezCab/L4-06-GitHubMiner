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
    private String message;

    public CommitV2(){

    }
    public CommitV2(Author author, Committer committer, String message) {
        this.author = author;
        this.committer = committer;
        this.message = message;
    }
    @JsonProperty("author")
    public Author getAuthor() {
        return author;
    }
    @JsonProperty("author")
    public void setAuthor(Author author) {
        this.author = author;
    }
    @JsonProperty("committer")
    public Committer getCommitter() {
        return committer;
    }
    @JsonProperty("committer")
    public void setCommitter(Committer committer) {
        this.committer = committer;
    }
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }
    @JsonProperty("message")
    public void setMessage(String message) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommitV2 commitV2 = (CommitV2) o;
        return Objects.equals(author, commitV2.author) && Objects.equals(committer, commitV2.committer) && Objects.equals(message, commitV2.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, committer, message);
    }
}
