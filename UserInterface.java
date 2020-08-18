// Sarthak Gupta
// 11/15/2019
// Includes Main Method to Create the GUI Using Java Swing
// Click "Update genes button" to find the number of genes in that DNA string

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserInterface {
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 800;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Gene Finder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final int DNA_FIELD_LENGTH = 10;
		JTextField DNAField = new JTextField(DNA_FIELD_LENGTH);
		JLabel DNALabel = new JLabel("DNA: ");

		JLabel resultLabel = new JLabel("Genes: ");

		class AddDNAListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				String DNA = DNAField.getText();
				resultLabel.setText("Genes: " + GeneFinder.printAllGenes(DNA));
			}
		}

		JButton button = new JButton("Update genes");
		ActionListener update = new AddDNAListener();
		button.addActionListener(update);

		JPanel panel = new JPanel();

		panel.setPreferredSize(new Dimension(30, 40));
		panel.setLocation(0, 0);
		panel.setBackground(Color.cyan);

		panel.add(DNALabel);
		panel.add(DNAField);
		panel.add(button);

		panel.add(resultLabel);

		frame.add(panel);
		frame.setVisible(true);
	}
}