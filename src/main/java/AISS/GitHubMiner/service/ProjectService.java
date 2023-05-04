package AISS.GitHubMiner.service;

import AISS.GitHubMiner.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;
    public Project findProject(String owner, String repo){
        String uri = "https://api.github.com/repos/" + owner + "/" + repo;

        Project project = restTemplate.getForObject(uri, Project.class);

        return project;

    }


}
