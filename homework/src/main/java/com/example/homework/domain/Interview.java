package com.example.homework.domain;

import java.util.List;
import java.util.StringJoiner;

public class Interview {
    private int number;
    private String question;
    private List<String> answers;
    private int correctAnswer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        answers.forEach(s -> joiner.add((answers.indexOf(s) + 1) + ". " + s));
        /*String answersString = answers.stream().collect(Collectors.joining("\n"));
        String result = String.join("\n", answers);*/
        return "Вопрос № " + number + ":\n" + question + "\n" +
                joiner + "\n" + "Выберетие вариант ответа:";
    }
}
