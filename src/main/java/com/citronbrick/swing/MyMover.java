package com.citronbrick.swing;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class MyMover extends JPanel {

	private int startX = 100;
	private int startY = 230;
	private int width = 100;
	private int height = 30;
	private Timer timer;
	private int delta = 0;

	private int maxIterations=  3; 

	public MyMover() {
		super(new FlowLayout());
		System.out.println("MyMover");
		setBorder(new StrokeBorder(new BasicStroke(3)));
		setPreferredSize(new Dimension(300,300));
		var that = this;
		final ActionListener listener = (ActionEvent ae)-> {
			that.delta += 20;
			that.repaint();
			if(++maxIterations > 3) {
				if(that.timer != null) {
					that.timer.stop();
				}
			}
		};
		SwingUtilities.invokeLater(()->{
			var timer = new Timer(1000, listener);
			timer.start();
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		var g2 = (Graphics2D)g;
		// var g2 = new Graphics2D();
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.BLACK);
		g2.drawRect(startX+delta,startY, startX+delta+width, height);
		// super.paintComponent(g);

	}


}