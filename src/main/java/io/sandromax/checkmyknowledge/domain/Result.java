package io.sandromax.checkmyknowledge.domain;

import javafx.beans.property.SimpleStringProperty;

public class Result {
    private SimpleStringProperty question;
    private SimpleStringProperty yourAnswer;
    private SimpleStringProperty rightAnswer;

    public Result(String question, String yourAnswer, String rightAnswer) {
        this.question = new SimpleStringProperty(question);
        this.yourAnswer = new SimpleStringProperty(yourAnswer);
        this.rightAnswer = new SimpleStringProperty(rightAnswer);
    }

    public String getQuestion() {
        return question.get();
    }

    public void setQuestion(String question) {
        this.question.set(question);
//        this.question = new SimpleStringProperty(question);
    }

    public String getYourAnswer() {
        return yourAnswer.get();
    }
    public String getRightAnswer() {
        return rightAnswer.get();
    }
}
