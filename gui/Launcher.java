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
				
				// TODO: Authentication logic for password
				
				if (username.equals("username") && passwordString.equals("password")) {
					JOptionPane.showMessageDialog(null, "Logged in");
					
					// Actions after successful login
					SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
					
					// New Window with welcome message
					JFrame welcomeFrame = new JFrame("Welcome " + username);
					JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
					welcomeFrame.add(welcomeLabel);
					welcomeFrame.setSize(600,500);
					welcomeFrame.setLocationRelativeTo(null);
					welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					welcomeFrame.setVisible(true);
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Username or Password is invalid.");
				}
			}
		});
		
		add(loginButton);
		
		setVisible(true);
	}
	
	public static boolean writeUsernamePassword(File security, String username, String password){ //write to File function
        try{ //attempt to create a new object with security
            FileWriter securityWriter = new FileWriter(security, false); //overwrite security.txt
                    
            //write information to file
            securityWriter.write(username + "\n"); 
            securityWriter.write(password + "\n");
            securityWriter.write("0");

            securityWriter.close(); //close FileWriter
            return true; //for testing purposes
        }
        catch(IOException e){ //catch error with FileWriter
            System.out.println("Error creating new login.");
            return false; //for testing purposes
        }
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
