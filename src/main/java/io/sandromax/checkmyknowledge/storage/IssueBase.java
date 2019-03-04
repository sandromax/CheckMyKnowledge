package io.sandromax.checkmyknowledge.storage;

import io.sandromax.checkmyknowledge.domain.Issue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class IssueBase {
    private HashMap<String, Issue> issueBase;

    public IssueBase(HashSet<Issue> issues) {
        for(Issue issue : issues) {
            String key = issue.getQuestion();

            issueBase.put(key, issue);
        }
    }

    public Issue getRandomIssue() {
        Random generator = new Random();
        Object[] values = issueBase.values().toArray();
        Object randomValue = values[generator.nextInt(values.length)];

        return (Issue)randomValue;
    }
}
