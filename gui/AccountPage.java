package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AccountPage extends JFrame {
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	public AccountPage() { /*
		setTitle("Create Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 200);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,2));
		
		JLabel usernameLabel = new JLabel("New Username:");
		usernameField = new JTextField();
		add(usernameLabel);
		add(usernameField);
		
		JLabel passwordLabel = new JLabel("New Password:");
		passwordField = new JPasswordField();
		add(passwordLabel);
		add(passwordField);
		
		JButton createButton = new JButton("Create Account");
		createButton.addActionListener(e -> {
			String newUsername = usernameField.getText();
			char[] newPassword = passwordField.getPassword();
			// TODO: Process and save new username and password into database
			
			JOptionPane.showMessageDialog(null, "Account Created Successfully");
			dispose();
			
		});
		
		add(createButton);
		setVisible(true); */
		setTitle("Welcome to Chirp!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 200);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,2));
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				promptLogin();
				dispose();
			}
		});
		
		JButton createAccountButton = new JButton("Create Account");
		createAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				promptCreateAccount();
				dispose();
			}
		});
		
		add(loginButton);
		add(createAccountButton);
		setVisible(true);
		
	}
	
	public void promptLogin() {
		JFrame frame = new JFrame("Log In");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(3,2));
		
		// Username Field
		JLabel usernameLabel = new JLabel("Username");
		usernameField = new JTextField();
		frame.add(usernameLabel);
		frame.add(usernameField);
		
		// Password Field
		JLabel passwordLabel = new JLabel("Password");
		passwordField = new JPasswordField();
		frame.add(passwordLabel);
		frame.add(passwordField);
		
		JButton loginButton = new JButton("Log In");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				char[] password = passwordField.getPassword();
				String passwordString = new String(password);
				
				// TODO: Insert authentication logic here to replace this block
				if (username.equals("username") && passwordString.equals("password")) {
					JOptionPane.showMessageDialog(null, "Logged In");
					frame.dispose();
					
					new ChirpWindow(username);
					// TODO: Implement actions after successful login
				}
				
				else {
					int option = JOptionPane.showConfirmDialog(null, "Do you want to create an account?", "Create Account", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						frame.dispose();
						promptCreateAccount();
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Okay. Please input a correct username and password");
					}
				}
			}
		});
		
		frame.add(loginButton);
		frame.setVisible(true);
	}
	
	public void promptCreateAccount() {
		JFrame frame = new JFrame("Create Account");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(3,2));
		
		// Username Field
		JLabel usernameLabel = new JLabel("New Username:");
		usernameField = new JTextField();
		frame.add(usernameLabel);
		frame.add(usernameField);
		
		// Password Field
		JLabel passwordLabel = new JLabel("New Password:");
		passwordField = new JPasswordField();
		frame.add(passwordLabel);
		frame.add(passwordField);
		
		JButton createButton = new JButton("Create New Account");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newUsername = usernameField.getText();
				char[] newPassword = passwordField.getPassword();
				
				// TODO: Process and save new username and password into database
				JOptionPane.showMessageDialog(null, "Account Created Successfully");
				dispose();
				promptLogin();
			}
		});
		
		frame.add(createButton);
		frame.setVisible(true);
	}
}
