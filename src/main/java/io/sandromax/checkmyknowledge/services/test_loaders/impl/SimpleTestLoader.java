package io.sandromax.checkmyknowledge.services.test_loaders.impl;

import io.sandromax.checkmyknowledge.domain.Issue;
import io.sandromax.checkmyknowledge.services.test_loaders.TestLoader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleTestLoader implements TestLoader {
    public LinkedList<Issue> load(String filePath) throws IOException {
        return parse(readFile(filePath));
    }

    private static LinkedList<String> readFile(String  filePath) throws IOException {
        LinkedList<String> rows = new LinkedList<>();

        Files.lines(Paths.get(filePath), StandardCharsets.UTF_8).forEach(str -> {
            rows.add(str);
        });

        return rows;
    }

    private static LinkedList parse(LinkedList<String> rows) {
        int rowCounter = 0;
        LinkedList<Issue> issues = new LinkedList<>();

        String question= "";
        String rightAnswer= "";
        ArrayList<String> answers= new ArrayList<>();

        for(String str : rows) {
            Matcher matcher = Pattern.compile("^(\\*){1}.{1,}").matcher(str);
            if(!str.equals("")) {
                if(rowCounter == 0) {
                    question = str;
                    rowCounter = 1;
                }
                else if(rowCounter == 1) {
                    if(matcher.matches()) {
                        str = str.substring(1);
                        rightAnswer = str;
                    }
                    answers.add(str);
                    rowCounter = 2;
                }
                else if(rowCounter == 2) {
                    if(matcher.matches()) {
                        str = str.substring(1);
                        rightAnswer = str;
                    }
                    answers.add(str);
                    rowCounter = 3;
                }
                else if(rowCounter == 3) {
                    if(matcher.matches()) {
                        str = str.substring(1);
                        rightAnswer = str;
                    }
                    answers.add(str);
                    rowCounter = 4;
                }
                else if(rowCounter == 4) {
                    if(matcher.matches()) {
                        str = str.substring(1);
                        rightAnswer = str;
                    }
                    answers.add(str);
// TODO: 2019-02-23 make exception and check this block
                    issues.add(new Issue(question, rightAnswer, answers));

                    question = "";
                    rightAnswer = "";
                    answers = new ArrayList<>();
                    rowCounter = 0;
                }
            }
            else if(str.equals("")) {
                continue;
            }
        }

        return issues;
    }
}
