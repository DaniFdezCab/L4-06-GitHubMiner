package AISS.GitHubMiner.service;

import AISS.GitHubMiner.model.Commit;
import AISS.GitHubMiner.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import utils.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class IssueService {
    @Autowired
    RestTemplate restTemplate;


    public ResponseEntity<Issue[]> getIssues(String uri) {

        //Request
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + "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");

        HttpEntity<Issue[]> request = new HttpEntity<>(null, headers);

        //send
        ResponseEntity<Issue[]> response = restTemplate.exchange(uri, HttpMethod.GET, request, Issue[].class);

        return response;
    }

    public List<Issue> getAllIssues(String owner, String repo, Integer sinceDays, Integer maxPages){

        List<Issue> issues = new ArrayList<>();
        LocalDateTime since = LocalDateTime.now().minusDays(sinceDays);

        // FIRST PAGE

        String uri = "https://api.github.com/repos/" + owner + "/" + repo +"/issues?since=" + since.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")).toString();


        ResponseEntity<Issue[]> response = getIssues(uri);
        List<Issue> pageIssues = Arrays.stream(response.getBody()).toList();

        issues.addAll(pageIssues);

        String nextPageUrl = Utils.getNextPageUrl(response.getHeaders());
        int page = 2;
        while (nextPageUrl != null && page <= maxPages){
            response = getIssues(nextPageUrl);
            pageIssues = Arrays.stream(response.getBody()).toList();
            nextPageUrl = Utils.getNextPageUrl(response.getHeaders());
            page++;
            issues.addAll(pageIssues);
        }
        return issues;

    }
    public List<Issue> getSimpleIssues(String owner, String repo ) {

        String uri = "https://api.github.com/repos/" + owner + "/" + repo +"/issues";

        Issue[] response = restTemplate.getForObject(uri, Issue[].class);
        return Arrays.stream(response).toList();
    }

}
