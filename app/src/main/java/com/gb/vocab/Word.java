package com.gb.vocab;

import com.orm.SugarRecord;

public class Word extends SugarRecord {

    private int id1;
    private String word;
    private int variant;
    private String meaning;
    private float ratio;

    /**
     * No args constructor for use in serialization
     *
     */
    public Word() {
    }

    /**
     *
     * @param id11
     * @param ratio
     * @param word
     * @param meaning
     * @param variant
     */
    public Word(int id1, String word, int variant, String meaning, float ratio) {
        this.id1 = id1;
        this.word = word;
        this.variant = variant;
        this.meaning = meaning;
        this.ratio = ratio;
    }

    /**
     *
     * @return
     * The id
     */
    public int getId1() {
        return id1;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(int id) {
        this.id1 = id1;
    }

    /**
     *
     * @return
     * The word
     */
    public String getWord() {
        return word;
    }

    /**
     *
     * @param word
     * The word
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     *
     * @return
     * The variant
     */
    public int getVariant() {
        return variant;
    }

    /**
     *
     * @param variant
     * The variant
     */
    public void setVariant(int variant) {
        this.variant = variant;
    }

    /**
     *
     * @return
     * The meaning
     */
    public String getMeaning() {
        return meaning;
    }

    /**
     *
     * @param meaning
     * The meaning
     */
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    /**
     *
     * @return
     * The ratio
     */
    public float getRatio() {
        return ratio;
    }

    /**
     *
     * @param ratio
     * The ratio
     */
    public void setRatio(float ratio) {
        this.ratio = ratio;
    }


}