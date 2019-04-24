package io.sandromax.checkmyknowledge.domain;

import java.util.ArrayList;

public class Issue {
    private String question;
    private String rightAnswer;
    private ArrayList<String> variantAnswers;

    public Issue(String question, String rightAnswer, ArrayList<String> variantAnswers) {
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

    public ArrayList<String> getVariantAnswers() {
        return variantAnswers;
    }
}
