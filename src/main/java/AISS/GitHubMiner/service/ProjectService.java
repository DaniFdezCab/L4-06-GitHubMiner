package AISS.GitHubMiner.service;

import AISS.GitHubMiner.model.Issue;
import AISS.GitHubMiner.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<Project> getProject(String uri) {

        //Request
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer" + "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");

        HttpEntity<Project> request = new HttpEntity<>(null, headers);
        //send
        ResponseEntity<Project> response = restTemplate.exchange(uri, HttpMethod.GET, request, Project.class);

        return response;
    }
    public Project findProject(String owner, String repo){

        String uri = "https://api.github.com/repos/" + owner + "/" + repo;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + "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");

        HttpEntity<Project> request = new HttpEntity<>(null, headers);
        //send
        ResponseEntity<Project> response = restTemplate.exchange(uri, HttpMethod.GET, request, Project.class);

        return response.getBody();

    }

}
