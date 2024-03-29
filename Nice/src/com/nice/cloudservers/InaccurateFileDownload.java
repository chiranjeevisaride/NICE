/*
 * InaccurateFileDownload.java
 *
 * Created on __DATE__, __TIME__
 */

package com.nice.cloudservers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import com.nice.bean.Users;

/**
 * 
 * @author __USER__
 */
public class InaccurateFileDownload extends javax.swing.JFrame {
	TreeMap<Integer, Users> timemap;

	/** Creates new form InaccurateFileDownload */
	public InaccurateFileDownload(TreeMap<Integer, Users> timemap) {
		this.timemap = timemap;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// Determine the new location of the window
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width - w) / 4;
		int y = (dim.height - h) / 4;

		// Move the window
		this.setLocation(x, y);
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setForeground(new java.awt.Color(255, 0, 0));
		jLabel1.setText("Inaccurate File Download Time");

		Set set = timemap.keySet();
		Iterator iterator = set.iterator();
		Object[][] obj = new Object[20][10];
		int i = 0;
		while (iterator.hasNext()) {
			int id = (Integer) iterator.next();
			Users users = (Users) timemap.get(id);
			obj[i][0] = users.getLoginid();
			obj[i][1] = users.getCloudservername();
			obj[i][2] = users.getVirtuvalmachine();
			obj[i][3] = users.getFilename();
			obj[i][4] = users.getFilesize();
			obj[i][5] = users.getDownloadtime();
			obj[i][6] = users.getMintime();
			obj[i][7] = users.getDifftime();
			obj[i][8] = users.getBandwidth();
			obj[i][9] = users.getDownloadcost();
			i++;

		}

		jTable1.setModel(new javax.swing.table.DefaultTableModel(obj,
				new String[] { "Name", "CS-NAME", "CS-VM", "FileName",
						"FileSize", "D-Time", "MIN-Time", "Diff-Time", "BandWidth", "D-Cost" }));
		jScrollPane1.setViewportView(jTable1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				26,
																				26,
																				26)
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				725,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				219,
																				219,
																				219)
																		.addComponent(
																				jLabel1)))
										.addContainerGap(18, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGap(19, 19, 19).addComponent(
						jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14,
						Short.MAX_VALUE).addPreferredGap(
						javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 335,
								javax.swing.GroupLayout.PREFERRED_SIZE).addGap(
								88, 88, 88)));

		pack();
	}// </editor-fold>

	// GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// new InaccurateFileDownload().setVisible(true);
			}
		});
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	// End of variables declaration//GEN-END:variables

}