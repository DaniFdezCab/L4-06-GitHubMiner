package AISS.GitHubMiner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("html_url")
    private String webUrl;
    @JsonProperty("commits")
    private List<Commit> commits;
    @JsonProperty("issues")
    private List<Issue> issues;

    public Project(){
    }

    public Project(String id, String name, String webUrl, List<Commit> commits, List<Issue> issues){
        this.id = id;
        this.name = name;
        this.webUrl = webUrl;
        this.commits = commits;
        this.issues = issues;
    }
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("html_url")
    public String getWeb_url() {
        return webUrl;
    }
    @JsonProperty("html_url")
    public void setWeb_url(String web_url) {
        this.webUrl = web_url;
    }
    @JsonProperty("commits")
    public List<Commit> getCommits() {
        return commits;
    }
    @JsonProperty("commits")
    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }
    @JsonProperty("issues")
    public List<Issue> getIssue() {
        return issues;
    }
    @JsonProperty("issues")
    public void setIssue(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", commits=" + commits +
                ", issues=" + issues +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(name, project.name) && Objects.equals(webUrl, project.webUrl) && Objects.equals(commits, project.commits) && Objects.equals(issues, project.issues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, webUrl, commits, issues);
    }
}
