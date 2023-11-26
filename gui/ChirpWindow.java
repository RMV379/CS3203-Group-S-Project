package gui;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChirpWindow extends JFrame {
	
	private JTextArea chirpTextArea;
	
	public ChirpWindow(String username) {
		setTitle("New Chirp - " + username);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel prompt = new JLabel("Chirp here (max 256 Characters):");
		add(prompt, BorderLayout.NORTH);
		
		chirpTextArea = new JTextArea(10, 30);
		chirpTextArea.setLineWrap(true);
		chirpTextArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(chirpTextArea);
		add(scrollPane, BorderLayout.CENTER);
		
		JButton chirpButton = new JButton("Chirp");
		chirpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chirpText = chirpTextArea.getText();
				if(chirpText.length() <= 256) {
					JOptionPane.showMessageDialog(null, "Message Chirped:\n" + chirpText);
					// TODO: Additional actions --> send chirp to database
				}
				else {
					JOptionPane.showMessageDialog(null, "Cannot send Chirps over 256 characters");
				}
			}
		});
		
		add(chirpButton, BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
