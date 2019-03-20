package io.sandromax.checkmyknowledge.services;

import io.sandromax.checkmyknowledge.domain.Issue;
import io.sandromax.checkmyknowledge.domain.Result;
import io.sandromax.checkmyknowledge.exceptions.NoNewIssuesInBase;
import io.sandromax.checkmyknowledge.storage.IssueBase;
import io.sandromax.checkmyknowledge.services.test_loaders.impl.SimpleTestLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class TestConductor {
    private IssueBase issueBase;
    private ObservableList<Result> testResults;
    private int rightIssues, totalIssues;

    public TestConductor(String pathToFile) throws IOException {
        issueBase = loadIssues(pathToFile);
        testResults = FXCollections.observableArrayList();
        rightIssues = 0;
        totalIssues = 0;
    }

    public int getRightIssues() {
        return rightIssues;
    }

    public int getTotalIssues() {
        return totalIssues;
    }

    public ObservableList<Result> getTestResults() {
        return testResults;
    }

    public void answerIsRight() {
        rightIssues++;
        totalIssues++;
    }

    public void answerIsWrong() {
        totalIssues++;
    }

    private IssueBase loadIssues(String path) throws IOException {
            SimpleTestLoader loader = new SimpleTestLoader();
            return new IssueBase(loader.load(path));
    }

    public Issue getNewIssue() throws NoNewIssuesInBase {
        return issueBase.getRandomIssue();
    }

    public void saveIssueDone(String question, String yourAnswer, String rightAnswer) {
        testResults.add(new Result(question, yourAnswer, rightAnswer));
    }

}
