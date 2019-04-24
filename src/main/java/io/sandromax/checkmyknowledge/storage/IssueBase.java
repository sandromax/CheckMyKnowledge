package io.sandromax.checkmyknowledge.storage;

import io.sandromax.checkmyknowledge.domain.Issue;
import io.sandromax.checkmyknowledge.exceptions.NoNewIssuesInBase;

import java.util.*;

public class IssueBase {
    private HashMap<String, Issue> issueBase = new HashMap<>();
    private List<Issue> pastIssues = new ArrayList<>();

    public IssueBase(LinkedList<Issue> issues) {
        for(Issue issue : issues) {
            String key = issue.getQuestion();

            issueBase.put(key, issue);
        }
    }

    public Issue getRandomIssue() throws NoNewIssuesInBase{
        if(issueBase.size() == pastIssues.size()) {
            throw new NoNewIssuesInBase("issue base is empty");
        }

        Random generator = new Random();
        Object[] keys = issueBase.keySet().toArray();
        Object randomKey = keys[generator.nextInt(keys.length)];

        while(pastIssues.contains(issueBase.get(randomKey))) {
            randomKey = keys[generator.nextInt(keys.length)];
        }

        Issue result = issueBase.get(randomKey);
        pastIssues.add(result);

        return result;
    }
}
