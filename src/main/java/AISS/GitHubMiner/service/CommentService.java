package AISS.GitHubMiner.service;

import AISS.GitHubMiner.model.Comment;
import AISS.GitHubMiner.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    RestTemplate restTemplate;

    public List<Comment> getCommentIssue(String uri) {
        Comment[] response = restTemplate.getForObject(uri, Comment[].class);
        return Arrays.stream(response).toList();
    }

}
