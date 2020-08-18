// Sarthak Gupta
// 11/14/2019
// Includes Main Method to Create the Advanced GUI Using Java Swing
// Finds all of the genes
// Updates genes every time text box for DNA is updated by user

import java.awt.*;
import javax.swing.*;

public class UserInterface2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		final int FRAME_WIDTH = 1000;
		final int FRAME_HEIGHT = 800;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Gene Finder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final int DNA_FIELD_LENGTH = 30;
		JTextField DNAField = new JTextField(DNA_FIELD_LENGTH);
		JLabel DNALabel = new JLabel("DNA: ");

		JLabel resultLabel = new JLabel("Genes: ");

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 800));

		panel.setLocation(0, 0);
		panel.setBackground(Color.cyan);

		panel.add(DNALabel);
		panel.add(DNAField);
		panel.add(resultLabel);

		frame.add(panel);
		frame.setVisible(true);

		JTextArea textArea = new JTextArea(45, 18);
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);
		panel.add(textArea);

		while (true) {
			String DNA = DNAField.getText().toUpperCase();
			// resultLabel.setText("Genes: " + Methods.printAllGenes(DNA));
			textArea.setText(Methods.printAllGenes(DNA));
		}
	}
}
