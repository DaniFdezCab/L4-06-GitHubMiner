package AISS.GitHubMiner.etl;

import AISS.GitHubMiner.model.*;
import AISS.GitHubMiner.service.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Transformation {

    private static CommentService commentService;

    public Transformation(CommentService commentService) {
        this.commentService = commentService;
    }


    public static GMProject parseProject(Project p){
        GMProject gMProject = new GMProject();
        gMProject.setId(p.getId());
        gMProject.setName(p.getName());
        gMProject.setWeb_url(p.getWeb_url());
        gMProject.setCommits(p.getCommits().stream().map(c -> parseCommit(c)).toList());
        gMProject.setIssue(p.getIssue().stream().map(i -> parseIssue(i)).toList());

        return gMProject;
    }

    private static GMIssue parseIssue(Issue issue) {
        GMIssue gmIssue = new GMIssue(issue.getId(), issue.getRef_id(), issue.getTitle(), issue.getDescription(),
                issue.getState(), issue.getCreated_at(), issue.getUpdated_at(), issue.getClosed_at(),
                issue.getLabels(), parseUser(issue.getAuthor()), parseUser(issue.getAssignee()), issue.getReaction().getUpVotes(), issue.getReaction().getDownVotes(),
                parseComments(commentService.getCommentIssue(issue.getComments())));
        return gmIssue;
    }

    private static List<GMComment> parseComments(List<Comment> commentIssue) {
        List<GMComment> gmComments = commentIssue.stream().map(comment -> {
            GMComment gmComment = new GMComment(comment.getId(),parseUser(comment.getAuthor()), comment.getBody(), comment.getCreated_at(), comment.getUpdated_at());
            return gmComment;
        }).toList();
        return gmComments;
    }

    private static GMCommit parseCommit(Commit commit) {
        Author author = commit.getCommit().getAuthor();
        Committer committer = commit.getCommit().getCommitter();
        GMCommit gmCommit = new GMCommit(commit.getId(), commit.getSha(), commit.getCommit().getMessage(),
                author.getName(), author.getEmail(), author.getDate().toString(), committer.getName(), committer.getEmail(),
                committer.getDate().toString(), commit.getUrl());
        return gmCommit;
    }

    private static GMUser parseUser(User user){
        GMUser gmUser = null;
        if(user != null) {
            gmUser = new GMUser(user.getId(), user.getUserName(), user.getName(), user.getAvatarUrl(), user.getWebUrl());
        }
        return gmUser;
    }
}

