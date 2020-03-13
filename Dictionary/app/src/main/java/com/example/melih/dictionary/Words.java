package com.example.melih.dictionary;

public class Words {

    private int word_id;
    private String wordTR;
    private String wordEN;

    public Words() {

    }

    public Words(int word_id, String wordTR, String wordEN) {
        this.word_id = word_id;
        this.wordTR = wordTR;
        this.wordEN = wordEN;
    }

    public int getWord_id() {
        return word_id;
    }

    public void setWord_id(int word_id) {
        this.word_id = word_id;
    }

    public String getWordTR() {
        return wordTR;
    }

    public void setWordTR(String wordTR) {
        this.wordTR = wordTR;
    }

    public String getWordEN() {
        return wordEN;
    }

    public void setWordEN(String wordEN) {
        this.wordEN = wordEN;
    }
}