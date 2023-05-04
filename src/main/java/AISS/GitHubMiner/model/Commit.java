package AISS.GitHubMiner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Commit {

    @JsonProperty("node_id")
    private String id;
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("commit")
    private CommitV2 commit;
    @JsonProperty("url")
    private String url;

    public Commit(String id, String sha, CommitV2 commit, String url) {
        this.id = id;
        this.sha = sha;
        this.commit = commit;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public CommitV2 getCommit() {
        return commit;
    }

    public void setCommit(CommitV2 commit) {
        this.commit = commit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "id='" + id + '\'' +
                ", sha='" + sha + '\'' +
                ", commit=" + commit +
                ", url='" + url + '\'' +
                '}';
    }
}