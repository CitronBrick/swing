package com.citronbrick.swing;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Hello world!
 */
public class App {


	private MySwing drawnPanel;


	public void show() {
		var frame = new JFrame("swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400,400);

		var label = new JLabel("Here's a swing made with Swing", SwingConstants.CENTER);

		var main = frame.getContentPane();
		main.add(label, BorderLayout.NORTH);

		var centerPanel = new JPanel();

		drawnPanel = new MySwing();



		centerPanel.add(drawnPanel);
		// centerPanel.setBackground(Color.RED);
		main.add(centerPanel,BorderLayout.CENTER);
		main.add(setupControls(),BorderLayout.SOUTH);

		// frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	public JPanel setupControls() {
		var panel = new JPanel();
		// panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		var start = new JButton("Start");
		var stop = new JButton("Stop");
		var faster = new JButton("Faster");
		var slower = new JButton("Slower");
		start.addActionListener((ActionEvent ae)->{drawnPanel.start();});
		stop.addActionListener((ActionEvent ae)->{drawnPanel.stop();});
		faster.addActionListener((ActionEvent ae)->{drawnPanel.faster();});
		slower.addActionListener((ActionEvent ae)->{drawnPanel.slower();});
		for(var b : new JButton[]{start,stop,faster,slower}) {
			panel.add(b);
		}
		return panel;
	}

	
    public static void main(String[] args) {
        System.out.println("Hello World!");
        new App().show();
    }
}
