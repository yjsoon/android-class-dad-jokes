package com.tinkercademy.yjsoon.dadjokes;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yingjie on 10/3/15.
 */
public class Joke implements Parcelable {

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

    protected Joke(Parcel in) {
        mTitle = in.readString();
        mQuestion = in.readString();
        mAnswer = in.readString();
        mSeen = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mQuestion);
        dest.writeString(mAnswer);
        dest.writeByte((byte) (mSeen ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Joke> CREATOR = new Parcelable.Creator<Joke>() {
        @Override
        public Joke createFromParcel(Parcel in) {
            return new Joke(in);
        }

        @Override
        public Joke[] newArray(int size) {
            return new Joke[size];
        }
    };
}
