package AISS.GitHubMiner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GMUser {
    @JsonProperty("id")
    private String id;
    @JsonProperty("username")
    private String userName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("web_url")
    private String webUrl;


    public GMUser(String id, String userName, String name, String avatarUrl, String webUrl){
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.webUrl = webUrl;
    }
    @JsonProperty("id")
    public String getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("username")
    public String getUserName() {
        return userName;
    }
    @JsonProperty("username")
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }
    @JsonProperty("avatar_url")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    @JsonProperty("web_url")
    public String getWebUrl() {
        return webUrl;
    }
    @JsonProperty("web_url")
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
