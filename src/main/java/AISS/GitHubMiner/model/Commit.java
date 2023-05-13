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
    @JsonProperty("node_id")
    public String getId() {
        return id;
    }
    @JsonProperty("node_id")
    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }
    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }
    @JsonProperty("commit")
    public CommitV2 getCommit() {
        return commit;
    }
    @JsonProperty("commit")
    public void setCommit(CommitV2 commit) {
        this.commit = commit;
    }
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }
    @JsonProperty("url")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commit commit1 = (Commit) o;
        return Objects.equals(id, commit1.id) && Objects.equals(sha, commit1.sha) && Objects.equals(commit, commit1.commit) && Objects.equals(url, commit1.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sha, commit, url);
    }
}