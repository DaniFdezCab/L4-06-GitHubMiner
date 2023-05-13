package AISS.GitHubMiner.controller;

import AISS.GitHubMiner.model.Project;
import AISS.GitHubMiner.service.CommitService;
import AISS.GitHubMiner.service.IssueService;
import AISS.GitHubMiner.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private RestTemplate restTemplate;
    private final ProjectService project;
    private final CommitService commits;
    private final IssueService issues;
    public ProjectController(ProjectService project, CommitService commits, IssueService issues){
        this.project = project;
        this.commits = commits;
        this.issues = issues;
    }
    @GetMapping("/prueba/{owner}/{repo}")
    public Project findAll(@PathVariable String owner, @PathVariable String repo,
                           @RequestParam(required = false, name = "sinceCommits") Integer sinceCommits,
                           @RequestParam(required = false, name = "sinceIssues") Integer sinceIssues,
                           @RequestParam(required = false, name = "maxPages") Integer maxPages) {
        if(sinceCommits==null){
            sinceCommits=2;
        }if(sinceIssues==null) {
            sinceIssues=20;
        }if(maxPages==null){
            maxPages=2;
        }
        Project project = this.project.findProject(owner, repo);
        project.setCommits(this.commits.getAllCommits(owner, repo, sinceCommits, maxPages));
        project.setIssue(this.issues.getAllIssues(owner, repo, sinceIssues, maxPages));

        return project;
    }

    @GetMapping("/{owner}/{repo}")
    public Project sendProject(@PathVariable String owner, @PathVariable String repo,
                           @RequestParam(required = false, name = "sinceCommits") Integer sinceCommits,
                           @RequestParam(required = false, name = "sinceIssues") Integer sinceIssues,
                           @RequestParam(required = false, name = "maxPages") Integer maxPages) {
        if(sinceCommits==null){
            sinceCommits=2;
        }if(sinceIssues==null) {
            sinceIssues=20;
        }if(maxPages==null){
            maxPages=2;
        }
        Project project = this.project.findProject(owner, repo);
        project.setCommits(this.commits.getAllCommits(owner, repo, sinceCommits, maxPages));
        project.setIssue(this.issues.getAllIssues(owner, repo, sinceIssues, maxPages));

        /*
       restTemplate.postForObject("http://localhost:8081/api/project/" + id
                + "?sinceCommits=" + sinceCommits + "&sinceIssues="
                + sinceIssues +"&maxPages=" + maxPages, project, Project.class);
        */
        return project;
    }
}
