package io.sandromax.checkmyknowledge.storage;

import io.sandromax.checkmyknowledge.domain.Result;

import java.util.LinkedList;

public class TestResults {
    private LinkedList<Result> results;

    public TestResults() {
        this.results = new LinkedList<>();
    }

    public LinkedList<Result> getResults() {
        return results;
    }

    public void addResult(Result result) {
        results.add(result);
    }
}
