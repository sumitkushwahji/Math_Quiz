package com.example.mathquiz;

public class QuestionBank {
    private int question;
    private boolean trueQuestion;

    public QuestionBank(int question,boolean trueQuestion){
        this.question=question;
        this.trueQuestion=trueQuestion;
    }

    //getter and setter are used to get and set value of private variable

    public int getQuestion(){
        return question;
    }
    public void setQuestion(int question){
        this.question=question;
    }

    public boolean isTrueQuestion() {
        return trueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        this.trueQuestion = trueQuestion;
    }
    
}
