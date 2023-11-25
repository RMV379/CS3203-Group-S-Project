package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Launcher extends JFrame {
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	public Launcher() {
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,2));
		
		// Username Field
		JLabel usernameLabel = new JLabel("Username");
		usernameField = new JTextField();
		add(usernameLabel);
		add(usernameField);
		
		// Password Field
		JLabel passwordLabel = new JLabel("Password");
		passwordField = new JPasswordField();
		add(passwordLabel);
		add(passwordField);
		
		JButton loginButton = new JButton("Log In");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				char[] password = passwordField.getPassword();
				String passwordString = new String(password);
				
				// TODO: Authentication for password
				
				if (username.equals("username") && passwordString.equals("password")) {
					JOptionPane.showMessageDialog(null, "Logged in");
					
					// TODO: Actions after successful login
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Username or Password is invalid.");
				}
			}
		});
		
		add(loginButton);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Launcher();
			}
		});
	}

}
