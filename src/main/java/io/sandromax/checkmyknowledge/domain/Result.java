package io.sandromax.checkmyknowledge.domain;

public class Result {
    private Issue issue;
    private String answer;
    private Boolean isRight;

    public Result(Issue issue, String answer) {
        this.issue = issue;
        this.answer = answer;

        if(answer.equals(issue.getRightAnswer())) {
            isRight = true;
        }
    }

    public Issue getIssue() {
        return issue;
    }

    public String getAnswer() {
        return answer;
    }

    public Boolean getRight() {
        return isRight;
    }
}
