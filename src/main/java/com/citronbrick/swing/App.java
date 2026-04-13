package com.citronbrick.swing;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * Hello world!
 */
public class App {


	public void show() {
		var frame = new JFrame("swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400,600);

		var label = new JLabel("Here's a swing made with Swing");

		var main = frame.getContentPane();
		main.add(label, BorderLayout.NORTH);

		var centerPanel = new JPanel();

		var drawnPanel = new MySwing();

		centerPanel.add(drawnPanel);
		centerPanel.setBackground(Color.RED);
		main.add(centerPanel,BorderLayout.CENTER);

		// frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	
    public static void main(String[] args) {
        System.out.println("Hello World!");
        new App().show();
    }
}
