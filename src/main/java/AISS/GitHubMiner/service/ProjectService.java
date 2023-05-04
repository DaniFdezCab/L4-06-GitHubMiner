package AISS.GitHubMiner.service;

import AISS.GitHubMiner.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;
    public Project findProject(String id){
        String uri = "https://gitlab.com/api/v4/projects/" + id + "?private_token=glpat-2_yFGw7WLXHPBHEZHbG5";

        Project project = restTemplate.getForObject(uri, Project.class);

        return project;

    }


}
