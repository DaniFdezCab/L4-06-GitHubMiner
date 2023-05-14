package AISS.GitHubMiner.service;

import AISS.GitHubMiner.model.Commit;
import AISS.GitHubMiner.model.Issue;
import org.apache.logging.log4j.Logger;
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
public class CommitService {
    @Autowired
    RestTemplate restTemplate;


    public ResponseEntity<Commit[]> getCommits(String uri) {

        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer " + "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");

        HttpEntity<Commit[]> request = new HttpEntity<>(null, headers);

        //send
        ResponseEntity<Commit[]> response = restTemplate.exchange(uri, HttpMethod.GET, request, Commit[].class);

        return response;
    }

    public List<Commit> getAllCommits(String owner, String repo, Integer sinceDays, Integer maxPages){

        List<Commit> commits = new ArrayList<>();
        LocalDateTime since = LocalDateTime.now().minusDays(sinceDays);

        // FIRST PAGE

        String uri = "https://api.github.com/repos/" + owner + "/" + repo +"/commits?since=" + since.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")).toString();


        ResponseEntity<Commit[]> response = getCommits(uri);
        List<Commit> pageCommits = Arrays.stream(response.getBody()).toList();

        commits.addAll(pageCommits);

        String nextPageUrl = Utils.getNextPageUrl(response.getHeaders());
        int page = 2;
        while (nextPageUrl != null && page <= maxPages){
            response = getCommits(nextPageUrl);
            pageCommits = Arrays.stream(response.getBody()).toList();
            nextPageUrl = Utils.getNextPageUrl(response.getHeaders());
            page++;
            commits.addAll(pageCommits);
        }
        return commits;

    }
    public List<Commit> getSimpleCommits(String owner, String repo ) {

        String uri = "https://api.github.com/repos/" + owner + "/" + repo +"/commits";

        Commit[] response = restTemplate.getForObject(uri, Commit[].class);

        return Arrays.stream(response).toList();
    }




}
