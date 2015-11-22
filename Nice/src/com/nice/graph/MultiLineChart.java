package com.nice.graph;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import com.nice.bean.FileBean;
import com.nice.bean.Users;

public class MultiLineChart extends ApplicationFrame {
	FileBean fileBean;
	List<FileBean> vFileBeans;

	public MultiLineChart(final String title, List<FileBean> vFileBeans) {
		super(title);
		this.vFileBeans = vFileBeans;
		XYDataset dataset = null;
		try {
			dataset = createDataset();
		} catch (Exception e) {
			System.out.println("MultiLineChart -- Constructor" + e);
		}
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(300, 270));
		setContentPane(chartPanel);
		this.pack();
		RefineryUtilities.centerFrameOnScreen(this);
		this.setVisible(true);

	}

	private XYDataset createDataset() {
		XYSeriesCollection dataset = null;
		try {
			
			int i = 0;
			final XYSeries series3 = new XYSeries("Batch Auding (c=460)");
			Iterator iterator = vFileBeans.iterator();
			while (iterator.hasNext()) {
				fileBean = (FileBean) iterator.next();
				series3.add((int)i, fileBean.getFiledownloadsize());
				i=i+1;
			}

			dataset = new XYSeriesCollection();
			dataset.addSeries(series3);

		} catch (Exception e) {
			System.out.println(e);
		}
		return dataset;
	}

	private JFreeChart createChart(final XYDataset dataset) {
		final JFreeChart chart = ChartFactory.createXYLineChart("FilePreventing",
				"Attackers", "loss of File size", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		chart.setBackgroundPaint(Color.white);
		final XYPlot plot1 = chart.getXYPlot();
		plot1.setBackgroundPaint(Color.lightGray);
		plot1.setDomainGridlinePaint(Color.white);
		plot1.setRangeGridlinePaint(Color.white);

		final XYPlot plot2 = chart.getXYPlot();
		plot2.setBackgroundPaint(Color.lightGray);
		plot2.setDomainGridlinePaint(Color.white);
		plot2.setRangeGridlinePaint(Color.white);

		final XYPlot plot3 = chart.getXYPlot();
		plot3.setBackgroundPaint(Color.lightGray);
		plot3.setDomainGridlinePaint(Color.white);
		plot3.setRangeGridlinePaint(Color.white);

		return chart;
	}

	public static void main(String[] args) {
		/*final MultiLineChart demo = new MultiLineChart("Benfit ROI Chart",
				new ArrayList<Users>(3));
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);*/
	}

}