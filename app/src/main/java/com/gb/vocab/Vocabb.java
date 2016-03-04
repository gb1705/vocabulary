package com.gb.vocab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Vocabb {


    @SerializedName("version")
    @Expose
    private int version;
    @SerializedName("words")
    @Expose
     List<Word> words = new ArrayList<Word>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Vocabb() {
    }

    /**
     *
     * @param words
     * @param version
     */
    public Vocabb(int version, List<Word> words) {
        this.version = version;
        this.words = words;
    }

    /**
     *
     * @return
     * The version
     */
    public int getVersion() {
        return version;
    }

    /**
     *
     * @param version
     * The version
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     *
     * @return
     * The words
     */
    public List<Word> getWords() {
        return words;
    }

    /**
     *
     * @param words
     * The words
     */
    public void setWords(List<Word> words) {
        this.words = words;
    }

}