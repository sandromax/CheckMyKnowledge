package io.sandromax.checkmyknowledge.services.test_loaders;

import io.sandromax.checkmyknowledge.domain.Issue;

import java.io.IOException;
import java.util.LinkedList;

public interface TestLoader {
    LinkedList<Issue> load(String filePath) throws IOException;
}
