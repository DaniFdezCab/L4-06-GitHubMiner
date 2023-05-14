package AISS.GitHubMiner.controller;

import AISS.GitHubMiner.etl.Transformation;
import AISS.GitHubMiner.model.Comment;
import AISS.GitHubMiner.model.GMProject;
import AISS.GitHubMiner.model.Project;
import AISS.GitHubMiner.service.CommentService;
import AISS.GitHubMiner.service.CommitService;
import AISS.GitHubMiner.service.IssueService;
import AISS.GitHubMiner.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private RestTemplate restTemplate;
    private final ProjectService project;
    private final CommitService commits;
    private final IssueService issues;
    private final Transformation transformation;
    private final CommentService comments;

    public ProjectController(ProjectService project, CommitService commits, IssueService issues, Transformation transformation, CommentService comments){
        this.project = project;
        this.commits = commits;
        this.issues = issues;
        this.transformation = transformation;
        this.comments = comments;
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

    @PostMapping("/{owner}/{repo}")
    public GMProject sendProject(@PathVariable String owner, @PathVariable String repo,
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

        GMProject p = restTemplate.postForObject("http://localhost:8080/gitminer/projects", transformation.parseProject(project), GMProject.class);

        return p;
    }

    @GetMapping("/comments/{id}")
    public List<Comment> findComments(@PathVariable Integer id,
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
       String uri = "https://api.github.com/repos/octocat/Hello-World/issues/" + id + "/comments?sinceCommits=10000&sinceIssues=20&maxPages=2";

        return comments.getCommentIssue(uri);
    }
}
