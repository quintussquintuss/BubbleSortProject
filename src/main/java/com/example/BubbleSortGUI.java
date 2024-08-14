package com.example;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BubbleSortGUI extends JFrame {
    private final JTextArea textArea;
    private final JTextField inputField;
    private final BubbleSort sortAlgorithm;

    public BubbleSortGUI() {
        setTitle("Bubble Sort Visualizer");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        sortAlgorithm = new BubbleSort();
        sortAlgorithm.setGui(this); // Pass the GUI instance to the algorithm

        inputField = new JTextField();
        JButton sortButton = new JButton("Ordenar");
        textArea = new JTextArea();
        textArea.setEditable(false);

        sortButton.addActionListener(new SortButtonListener());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(inputField, BorderLayout.CENTER);
        topPanel.add(sortButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void updateTextArea(String text) {
        textArea.setText(text); // Update the text area with new text
    }

    private class SortButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText(""); // Clear the text area
            String input = inputField.getText();
            try {
                String[] parts = input.split(",");
                int[] arr = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    arr[i] = Integer.parseInt(parts[i].trim());
                }
                sortAlgorithm.sort(arr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(BubbleSortGUI.this, "Entrada inválida. Por favor, ingrese una lista de números separados por comas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BubbleSortGUI frame = new BubbleSortGUI();
            frame.setVisible(true);
        });
    }
}
