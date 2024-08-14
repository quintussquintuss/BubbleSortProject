package com.example;

public abstract class SortAlgorithm {
    public abstract void sort(int[] array);

    protected void printArray(int[] array, StringBuilder sb) {
        for (int j : array) {
            sb.append(j).append(" ");
        }
        sb.append("\n");
    }
}

