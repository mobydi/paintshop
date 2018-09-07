package com.paintshop.models;


public class TestResult {
    private final int numColors;
    private final boolean[] solution;

    public TestResult(int numColors, boolean[] solution) {
        this.numColors = numColors;
        this.solution = solution;
    }

    public int getNumColors() {
        return numColors;
    }

    public boolean[] getSolution() {
        return solution;
    }

    @Override
    public String toString() {
        if (solution != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numColors; i++) {
                sb.append(solution[i] ? '1' : '0');
                if (i < numColors - 1) sb.append(' ');
            }
            return sb.toString();
        } else {
            return "IMPOSSIBLE";
        }
    }
}
