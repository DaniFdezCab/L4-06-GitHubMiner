package AISS.GitHubMiner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reaction {

    @JsonProperty("+1")
    private Integer upVotes;
    @JsonProperty("-1")
    private Integer downVotes;


    public Reaction(Integer upVotes, Integer downVotes) {
        this.upVotes = upVotes;
        this.downVotes = downVotes;
    }

    public Integer getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(Integer upVotes) {
        this.upVotes = upVotes;
    }

    public Integer getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(Integer downVotes) {
        this.downVotes = downVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reaction reaction = (Reaction) o;
        return Objects.equals(upVotes, reaction.upVotes) && Objects.equals(downVotes, reaction.downVotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upVotes, downVotes);
    }
}
