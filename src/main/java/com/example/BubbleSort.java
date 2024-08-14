package com.example;

public class BubbleSort extends SortAlgorithm {
    private BubbleSortGUI gui; // Reference to the GUI to update the text area

    public void setGui(BubbleSortGUI gui) {
        this.gui = gui;
    }

    @Override
    public void sort(int[] array) {
        StringBuilder sb = new StringBuilder();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                appendArray(array, sb);  // Append the current state of the array
            }
        }
        appendArray(array, sb);  // Append the final sorted array
        gui.updateTextArea(sb.toString());  // Update the GUI with all the steps
    }

    private void appendArray(int[] array, StringBuilder sb) {
        for (int j : array) {
            sb.append(j).append(" ");
        }
        sb.append("\n");
    }
}
