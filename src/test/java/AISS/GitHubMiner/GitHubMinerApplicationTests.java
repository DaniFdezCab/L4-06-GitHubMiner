package AISS.GitHubMiner;

import AISS.GitHubMiner.model.Comment;
import AISS.GitHubMiner.model.Commit;
import AISS.GitHubMiner.model.Issue;
import AISS.GitHubMiner.model.Project;
import AISS.GitHubMiner.service.CommentService;
import AISS.GitHubMiner.service.CommitService;
import AISS.GitHubMiner.service.IssueService;
import AISS.GitHubMiner.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class GitHubServiceTest {

	@Autowired
	ProjectService projectService;
	@Autowired
	CommitService commitService;
	@Autowired
	IssueService issueService;
	@Autowired
	CommentService commentService;

	@Test
	void getProjectById() {
		Project project = projectService.findProject("octocat", "Hello-World");
		assertTrue(project != null, "the project is empty");
		System.out.println(project);
	}

	@Test
	void getAllCommits() {
		List<Commit> commits = commitService.getSimpleCommits("octocat", "Hello-World");
		assertTrue(commits != null, "no commits have been found");
		System.out.println(commits);
	}

	@Test
	void getAllIssues() {
		List<Issue> issues = issueService.getSimpleIssues("octocat", "Hello-World");
		assertTrue(issues != null, "no issues have been found");
		System.out.println(issues);
	}
	//funcion modificada, para que devuelva ya una lista, ya tenemos el metodo que lo hace, el que se llama group.
	@Test
	void getIssueComments() {
		List<Comment> comments = commentService.getCommentIssue("https://api.github.com/repos/octocat/Hello-World/issues/2639/comments");
		assertTrue(comments != null, "no comments were found");
		System.out.println(comments);
	}

}
