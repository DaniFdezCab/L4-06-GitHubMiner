package AISS.GitHubMiner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty("id")
    private String id;
    @JsonProperty("login")
    private String userName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("url")
    private String webUrl;


    public User(String id, String userName, String name, String avatarUrl, String webUrl){
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.webUrl = webUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", avatar_url='" + avatarUrl + '\'' +
                ", web_url='" + webUrl + '\'' +
                '}';
    }

}
