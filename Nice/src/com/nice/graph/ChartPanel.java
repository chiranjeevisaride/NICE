package com.nice.graph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.nice.bean.CloudServer;






public class ChartPanel extends JPanel {
	private double[] values;

	private String[] names;

	private String title;

	public ChartPanel(double[] v, String[] n, String t) {
		names = n;
		values = v;
		title = t;
	}

	public ChartPanel() {
		// TODO Auto-generated constructor stub
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (values == null || values.length == 0)
			return;
		double minValue = 0;
		double maxValue = 0;
		for (int i = 0; i < values.length; i++) {
			if (minValue > values[i])
				minValue = values[i];
			if (maxValue < values[i])
				maxValue = values[i];
		}

		Dimension d = getSize();
		int clientWidth = d.width;
		int clientHeight = d.height;
		int barWidth = clientWidth / values.length;

		Font titleFont = new Font("SansSerif", Font.BOLD, 20);
		FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
		Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
		FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

		int titleWidth = titleFontMetrics.stringWidth(title);
		int y = titleFontMetrics.getAscent();
		int x = (clientWidth - titleWidth) / 2;
		g.setFont(titleFont);
		g.drawString(title, x, y);

		int top = titleFontMetrics.getHeight();
		int bottom = labelFontMetrics.getHeight();
		if (maxValue == minValue)
			return;
		double scale = (clientHeight - top - bottom) / (maxValue - minValue);
		y = clientHeight - labelFontMetrics.getDescent();
		g.setFont(labelFont);

		for (int i = 0; i < values.length; i++) {
			int valueX = i * 60;
			int valueY = top;
			int height = (int) (values[i] * scale);
			if (values[i] >= 0)
				valueY += (int) ((maxValue - values[i]) * scale);
			else {
				valueY += (int) (maxValue * scale);
				height = -height;
			}
			if (i % 2 == 0)
				g.setColor(Color.red);
			else
				g.setColor(Color.green);
			g.fillRect(valueX, valueY, barWidth - 100, height);
			g.setColor(Color.black);
			g.drawRect(valueX, valueY, barWidth - 100, height);

			x = i * 60;
			g.drawString(names[i], x, y);
		}
	}

	public static void viewGraph(Vector<CloudServer> vector) {
		JFrame f = new JFrame();
		f.setSize(700, 600);
		f.setTitle("File Uploaded Graph");
		double[] values = new double[vector.size()];
		String[] names = new String[vector.size()];

		Iterator it = vector.iterator();
		int i = 0;
		CloudServer loadBalancer;
		while (it.hasNext()) {
			loadBalancer = (CloudServer) it.next();
			values[i] = loadBalancer.getFilesize();
			names[i] = loadBalancer.getBalancername();
			i++;
		}

		f.getContentPane().add(
				new ChartPanel(values, names, "File Upload Genereted Graph"));

		WindowListener wndCloser = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

			}
		};
		f
				.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		f.setVisible(true);
	}
}