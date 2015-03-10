package com.tinkercademy.yjsoon.dadjokes;

/**
 * Created by yingjie on 10/3/15.
 */
public class Joke {

    protected String mTitle;
    protected String mQuestion;
    protected String mAnswer;
    protected boolean mSeen;

    public Joke(String title, String question, String answer) {
        mTitle = title;
        mQuestion = question;
        mAnswer = answer;
        mSeen = false;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public String getAnswer() {
        return mAnswer;
    }

    public void setAnswer(String answer) {
        mAnswer = answer;
    }

    public boolean isSeen() {
        return mSeen;
    }

    public void setSeen(boolean seen) {
        mSeen = seen;
    }
}
