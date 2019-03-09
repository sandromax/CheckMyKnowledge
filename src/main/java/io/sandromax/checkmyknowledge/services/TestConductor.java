package io.sandromax.checkmyknowledge.services;

import io.sandromax.checkmyknowledge.domain.Issue;
import io.sandromax.checkmyknowledge.domain.Result;
import io.sandromax.checkmyknowledge.storage.IssueBase;
import io.sandromax.checkmyknowledge.storage.TestResults;
import io.sandromax.checkmyknowledge.services.test_loaders.impl.SimpleTestLoader;

import java.io.IOException;

public class TestConductor {
    private IssueBase issueBase;
    private TestResults testResults;

    public void init(String path) {
        try {
            SimpleTestLoader loader = new SimpleTestLoader();
            issueBase = new IssueBase(loader.load(path));

            testResults = new TestResults();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Issue getNewIssue() {
        return issueBase.getRandomIssue();
    }

    public void saveIssueDone(Issue issue, String answer) {
        testResults.addResult(new Result(issue, answer));
    }

    public void endTest() {

    }
}
