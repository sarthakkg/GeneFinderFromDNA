// Sarthak Gupta
// 11/14/2019
// Includes Main Method to Create the Advanced GUI Using Java Swing
// Finds all of the genes
// Updates genes every time text box for DNA is updated by user

import java.awt.*;
import javax.swing.*;

public class Application {
	public static void main(String[] args) {
		// created the Gene Finder GUI Window
		JFrame frame = new JFrame();
		frame.setSize(1000, 800);
		frame.setTitle("Gene Finder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// creates the text field for user to enter DNA string
		JLabel DNALabel = new JLabel("DNA: ");
		JTextField DNAField = new JTextField(30);

		// creates the label for "Genes: "
		JLabel resultLabel = new JLabel("Genes: ");
		
		JPanel panel = new JPanel();

		JTextArea textArea = new JTextArea(45, 24);
		JScrollPane scrollPane = new JScrollPane(textArea);

		panel.setBackground(Color.cyan);

		panel.add(DNALabel);
		panel.add(DNAField);
		panel.add(resultLabel);
		panel.add(scrollPane);

		frame.add(panel);
		frame.setVisible(true);

		while (true) {
			String DNA = DNAField.getText().toUpperCase();
			textArea.setText(GeneFinder.printAllGenes(DNA));
		}

	}
}