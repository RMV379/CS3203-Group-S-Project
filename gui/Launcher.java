package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Launcher extends JFrame {
		
	public Launcher() {
		new AccountPage();
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
