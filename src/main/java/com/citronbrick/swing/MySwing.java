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
	private double dv = Math.PI/1800;
	private Timer timer;
	private ActionListener listener;

	public int midX = (startX+width)/2;
	public int midY = 20;




	private int radius = 210;


	public MySwing() {
		super(new FlowLayout());
		setBorder(new StrokeBorder(new BasicStroke(3)));
		setPreferredSize(new Dimension(300,300));
		var that = this;
		listener = (ActionEvent ae)-> {
			angle += dx;
			// dx += dv;
			System.out.println((angle * 180)/Math.PI);
			that.repaint();
			if(angle > Math.PI/2) {
				dx *= -1;
				// dv *= -1;
			} else if (angle < Math.PI/6) {
				dx *= -1;
				// dv *= -1;
			}
		};
		this.start();
		
	}

	public void start() {
		SwingUtilities.invokeLater(()->{
			if(timer ==null) {
				timer = new Timer(100, listener);
			}
			timer.start();
		});
	}

	public void stop() {
		SwingUtilities.invokeLater(()->{
			timer.stop();
		});
	}

	public void faster() {
		dx*=2;
	}

	public void slower() {
		dx /= 2;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		var g2 = (Graphics2D)g;
		drawBar(g2);
		drawSeat(g2, -50);
	}

	public void drawBar(Graphics2D g2) {
		g2.setColor(Color.DARK_GRAY);
		g2.setStroke(new BasicStroke(7));
		g2.drawLine(startX,midY, startX+width, midY);
	}


	public void drawSeat(Graphics2D g2,  int delta) {
		g2.setStroke(new BasicStroke(3));
		g2.setColor(new Color(233, 116, 81));
		var sx = midX + (int)Math.round(radius * Math.cos(angle)) - width/2;
		var sy = midY + (int)Math.round(radius * Math.sin(angle)) - height/2 ;
		System.out.println(sx+","+sy);
		g2.drawLine(sx , sy, sx+width, sy); // hori top
		g2.drawLine(sx + width, sy , sx + width + delta, sy + height); // verti right
		g2.drawLine(sx+delta, sy+height, sx+width+delta, sy+height); // hori bottom;
		g2.drawLine(sx, sy, sx+delta, sy+height); // verti left
		g2.fillPolygon(new int[]{sx,sx + width,sx + width+delta,sx+delta }, new int[]{sy, sy, sy+height,sy+height  }, 4);


		//draw chains
		var dashArray = new float[]{3};
		g2.setStroke(new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND, 1f,dashArray , 1f));
		g2.setColor(Color.DARK_GRAY);
		g2.drawLine(midX,midY, sx, sy);
		g2.drawLine(midX+width,midY, sx+width, sy);
		g2.drawLine(midX+width,midY, sx+width+delta, sy+height);
		g2.drawLine(midX,midY, sx+delta, sy+height);
	}



}