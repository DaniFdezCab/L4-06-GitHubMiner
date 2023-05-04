package AISS.GitHubMiner.controller;

import AISS.GitHubMiner.model.Project;
import AISS.GitHubMiner.service.CommitService;
import AISS.GitHubMiner.service.IssueService;
import AISS.GitHubMiner.service.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService project;
    private final CommitService commits;
    private final IssueService issues;
    public ProjectController(ProjectService project, CommitService commits, IssueService issues){
        this.project = project;
        this.commits = commits;
        this.issues = issues;
    }
    @GetMapping("/{owner}/{repo}")
    public Project findAll(@PathVariable String owner, @PathVariable String repo) {
        Project project = this.project.findProject(owner, repo);
        return project;
    }


}
