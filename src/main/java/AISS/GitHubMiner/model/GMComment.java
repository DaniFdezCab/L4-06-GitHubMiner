package AISS.GitHubMiner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GMComment {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("author")
    private GMUser author;
    @JsonProperty("body")
    private String body;
    @JsonProperty("created_at")
    private String created_at;
    @JsonProperty("updated_at")
    private String updated_at;

    public GMComment() {
    }

    public GMComment(Integer id, GMUser auth, String body, String created_at, String updated_at) {
        this.id = id;
        this.author = auth;
        this.body = body;
        this.created_at = created_at;
        this.updated_at = updated_at;

    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public GMUser getAuthor() {
        return author;
    }

    public void setAuthor(GMUser author) {
        this.author = author;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty("created_at")
    public String getCreated_at() {
        return created_at;
    }

    @JsonProperty("created_at")
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @JsonProperty("updated_at")
    public String getUpdated_at() {
        return updated_at;
    }

    @JsonProperty("updated_at")
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", body='" + body + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}


