package io.sandromax.checkmyknowledge.domain;

import java.util.HashSet;

public class Issue {
    private String question;
    private String rightAnswer;
    private HashSet<String> variantAnswers;

    public Issue(String question, String rightAnswer, HashSet<String> variantAnswers) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.variantAnswers = variantAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public HashSet<String> getVariantAnswers() {
        return variantAnswers;
    }
}
