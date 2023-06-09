package AISS.GitHubMiner.service;

import AISS.GitHubMiner.model.Comment;
import AISS.GitHubMiner.model.Commit;
import AISS.GitHubMiner.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    RestTemplate restTemplate;


    public ResponseEntity<Comment[]> getComments(String uri) {

        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer " + "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");

        HttpEntity<Comment[]> request = new HttpEntity<>(null, headers);

        //send
        ResponseEntity<Comment[]> response = restTemplate.exchange(uri, HttpMethod.GET, request, Comment[].class);

        return response;
    }
    public List<Comment> getCommentIssue(String uri) {

        ResponseEntity<Comment[]> response = getComments(uri);

        return Arrays.stream(response.getBody()).toList();
    }

}
