package AISS.GitHubMiner.etl;

import AISS.GitHubMiner.model.Commit;
import AISS.GitHubMiner.model.Issue;
import AISS.GitHubMiner.model.Project;

import java.util.List;

public class Transformation {


    public static Project getGMProject(Project p, List<Commit> c, List<Issue> i){
        Project project = p;
        project.setCommits(c);
        project.setIssue(i);
        return project;
    }
}
