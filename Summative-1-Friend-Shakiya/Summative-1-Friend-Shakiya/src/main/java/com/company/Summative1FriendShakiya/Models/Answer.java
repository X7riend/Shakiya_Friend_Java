package com.company.Summative1FriendShakiya.Models;

import java.util.Objects;

public class Answer
{
    private int id;
    private String question;

    public Answer(String answer,String question, int id)
    {
        this.answer = answer;
        this.question = question;
        this.id = id;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer1 = (Answer) o;
        return id == answer1.id && Objects.equals(question, answer1.question) && Objects.equals(answer, answer1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private String answer;
}
