package com.citronbrick.swing;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class MySwing extends JPanel {

	private int startX = 100;
	private int startY = 230;
	private int width = 100;
	private int height = 30;
	// private double angle = -Math.PI/6;
	private double angle = Math.PI/3;
	private double dx = Math.PI/180;
	private Timer timer;

	public int midX = (startX+width)/2;
	public int midY = 20;

	private int maxIterations=  3; 

	private int radius = 210;


	public MySwing() {
		super(new FlowLayout());
		setBorder(new StrokeBorder(new BasicStroke(3)));
		setPreferredSize(new Dimension(300,300));
		var that = this;
		final ActionListener listener = (ActionEvent ae)-> {
			angle += Math.PI/180;
			System.out.println((angle * 180)/Math.PI);
			that.repaint();
			if(angle > Math.PI/2) {
				angle *= -1;
			}
		};
		SwingUtilities.invokeLater(()->{
			var timer = new Timer(100, listener);
			// timer.start();
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		var g2 = (Graphics2D)g;
		// var g2 = new Graphics2D();
		g2.setStroke(new BasicStroke(7));
		g2.setColor(Color.BLACK);
		g2.drawLine(startX,midY, startX+width, midY);
		// super.paintComponent(g);

		drawSeater(g2, -50);
	}


	// public void drawSeater(Graphics2D g2, int delta) {
	// 	// var sx = start
	// 	g2.drawLine(startX , 230, endX, 230); // hori top
	// 	g2.drawLine(endX, 230, endX+delta, 260); // verti right
	// 	g2.drawLine(startX+delta, 260, endX+delta, 260); // hori bottom;
	// 	g2.drawLine(startX, 230, startX+delta, 260); // verti left
	// }

	public void drawSeater(Graphics2D g2,  int delta) {
		g2.setStroke(new BasicStroke(3));
		var sx = midX + (int)Math.round(radius * Math.cos(angle)) - width/2;
		var sy = midY + (int)Math.round(radius * Math.sin(angle)) - height/2 ;
		System.out.println(sx+","+sy);
		g2.drawLine(sx , sy, sx+width, sy); // hori top
		g2.drawLine(sx + width, sy , sx + width + delta, sy + height); // verti right
		g2.drawLine(sx+delta, sy+height, sx+width+delta, sy+height); // hori bottom;
		g2.drawLine(sx, sy, sx+delta, sy+height); // verti left
	}



}