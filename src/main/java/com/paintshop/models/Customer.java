package com.paintshop.models;


import java.util.Arrays;

public class Customer {
    private final boolean[] glossies;
    private Integer matte = null;

    public Customer(Integer maxColor) {
        glossies = new boolean[maxColor];
    }

    public void setGlossy(int bitIndex) {
        glossies[bitIndex] = true;
    }

    public int getMatte() {
        return matte;
    }

    public void setMatte(int bitIndex) {
        matte = bitIndex;
    }

    public boolean hasMatte() {
        return matte != null;
    }

    public boolean isSolutionSuitable(boolean[] solution) {
        return suitableColors(solution) > 0;
    }

    private int suitableColors(boolean[] batches) {
        int suitableColors = suitableGlossyColors(batches);
        if (isMatteColorSuitable(batches)) suitableColors++;
        return suitableColors;
    }

    private int suitableGlossyColors(boolean[] batches) {
        int suitableGlossyColors = 0;
        for (int i = 0; i < batches.length; i++) {
            if(glossies[i]) {
                suitableGlossyColors += batches[i] ? 0 : 1;
            }
        }
        return suitableGlossyColors;
    }

    private boolean isMatteColorSuitable(boolean[] batches) {
        return matte != null && batches[matte];
    }

    @Override
    public String toString() {
        return "matte=" + matte +
                "glossies[]=" + Arrays.toString(glossies);
    }
}
