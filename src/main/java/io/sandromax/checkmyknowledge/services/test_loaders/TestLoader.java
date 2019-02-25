package io.sandromax.checkmyknowledge.services.test_loaders;

import io.sandromax.checkmyknowledge.domain.Issue;

import java.io.IOException;
import java.util.HashSet;

public interface TestLoader {
    HashSet<Issue> load(String filePath) throws IOException;
}
