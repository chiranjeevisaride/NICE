/*
 * AttackAnalyserForm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.nice.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.jfree.ui.RefineryUtilities;
import org.springframework.beans.factory.BeanFactory;

import com.nice.bean.FileBean;
import com.nice.bean.Users;
import com.nice.dao.DataBaseDataSource;
import com.nice.dao.RegistrationDAO;
import com.nice.graph.MultiLineChart;

/**
 * 
 * @author __USER__
 */
public class AttackAnalyserForm extends javax.swing.JFrame {
	Users users;
	TreeMap<Integer, Users> treeMap;
	RegistrationDAO registrationDAO;

	/** Creates new form AttackAnalyserForm */
	public AttackAnalyserForm(Users users, TreeMap<Integer, Users> treeMap) {
		this.users = users;
		this.treeMap = treeMap;
		BeanFactory factory = new DataBaseDataSource().getDataFactory();
		registrationDAO = (RegistrationDAO) factory.getBean("registrationDAO");
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

		jTabbedPane4 = new javax.swing.JTabbedPane();
		jPanel7 = new javax.swing.JPanel();
		jPanel1 = new javax.swing.JPanel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel2 = new javax.swing.JPanel();
		jPanel9 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jComboBox2 = new javax.swing.JComboBox();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jComboBox3 = new javax.swing.JComboBox();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jLabel4 = new javax.swing.JLabel();
		jButton7 = new javax.swing.JButton();
		jButton7.setEnabled(false);
		jButton8 = new javax.swing.JButton();
		jButton8.setEnabled(false);
		jButton9 = new javax.swing.JButton();
		jPanel5 = new javax.swing.JPanel();
		jPanel6 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jLabel5 = new javax.swing.JLabel();

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
				jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100,
				Short.MAX_VALUE));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100,
				Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("AttackerAnalyserWindow");

		jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel1.setForeground(new java.awt.Color(255, 0, 0));
		jLabel1.setText("CloudNames :");

		String cloudServerNames = registrationDAO.viewCloudServerNames();

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(
				cloudServerNames.split(",")));

		jButton1.setText("CloudFileDetection");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("CloudPrevention");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel2.setForeground(new java.awt.Color(255, 0, 0));
		jLabel2.setText("VMNames :");

		String serverNames = registrationDAO.viewVirtuvalMachineNames();

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(serverNames
				.split(",")));

		jButton3.setText("VMFilesDetection");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("VMFilePrevention");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel3.setForeground(new java.awt.Color(255, 0, 0));
		jLabel3.setText("FileNames :");
		String filename = registrationDAO.viewServerFiles();

		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(filename
				.split(",")));

		jButton5.setText("FileDetection");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setText("FilePrevention");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "ID",
						"FileName", "LossPackets", "AttackerName",
						"AttackingDate", "ActualSize", "DownloadSize" }));
		jScrollPane1.setViewportView(jTable1);

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel4.setForeground(new java.awt.Color(255, 0, 102));
		jLabel4
				.setText("Detection and Prevention Process of File in Cloud Servers");

		jButton7.setText("CloudGraph");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jButton8.setText("VMGraph");
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});

		jButton9.setText("FileGraph");
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(
				jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout
				.setHorizontalGroup(jPanel9Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel9Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																764,
																Short.MAX_VALUE)
														.addGroup(
																jPanel9Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel9Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								jPanel9Layout
																										.createSequentialGroup()
																										.addGap(
																												8,
																												8,
																												8)
																										.addComponent(
																												jLabel3)
																										.addGap(
																												4,
																												4,
																												4))
																						.addGroup(
																								jPanel9Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel2)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
																						.addGroup(
																								jPanel9Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel1)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel9Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								jPanel9Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel9Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																false)
																														.addComponent(
																																jComboBox3,
																																0,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																jComboBox2,
																																0,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																jComboBox1,
																																0,
																																202,
																																Short.MAX_VALUE))
																										.addGap(
																												18,
																												18,
																												18)
																										.addGroup(
																												jPanel9Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jButton7,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																128,
																																Short.MAX_VALUE)
																														.addComponent(
																																jButton8,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																128,
																																Short.MAX_VALUE)
																														.addComponent(
																																jButton9,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																128,
																																Short.MAX_VALUE))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												10,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGroup(
																												jPanel9Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																false)
																														.addComponent(
																																jButton5,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																jButton3,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																jButton1,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																161,
																																Short.MAX_VALUE))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												jPanel9Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																jButton4,
																																javax.swing.GroupLayout.Alignment.LEADING,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																158,
																																Short.MAX_VALUE)
																														.addComponent(
																																jButton6,
																																javax.swing.GroupLayout.Alignment.LEADING,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																158,
																																Short.MAX_VALUE)
																														.addComponent(
																																jButton2,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																154,
																																javax.swing.GroupLayout.PREFERRED_SIZE)))
																						.addGroup(
																								jPanel9Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel4)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
										.addContainerGap()));
		jPanel9Layout
				.setVerticalGroup(jPanel9Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel9Layout
										.createSequentialGroup()
										.addGap(31, 31, 31)
										.addComponent(jLabel4)
										.addGap(18, 18, 18)
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																jComboBox1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton7)
														.addComponent(jButton2)
														.addComponent(jButton1))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																jComboBox2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton4)
														.addComponent(jButton3)
														.addComponent(jButton8))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																jComboBox3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton6)
														.addComponent(jButton5)
														.addComponent(jButton9))
										.addGap(24, 24, 24)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												372,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(29, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout.createSequentialGroup().addComponent(jPanel9,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		jTabbedPane1.addTab("Detection", jPanel2);

		Set set = treeMap.keySet();
		Iterator iterator = set.iterator();
		Object[][] obj = new Object[20][5];
		int i = 0;
		while (iterator.hasNext()) {
			int id = (Integer) iterator.next();
			Users users = (Users) treeMap.get(id);
			obj[i][0] = i + 1;
			obj[i][1] = users.getLoginid();
			obj[i][2] = users.getFilename();
			obj[i][3] = users.getFilestatus();
			obj[i][4] = users.getRequestdate();

			i++;

		}

		jTable2.setModel(new javax.swing.table.DefaultTableModel(obj,
				new String[] { "ID", "USER-NAME", "FILENAME", "FILESTATUS",
						"FILEREQUESTDATE" }));
		jScrollPane2.setViewportView(jTable2);

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel5.setForeground(new java.awt.Color(255, 0, 204));
		jLabel5.setText("User File Download Requests");

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
				jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel6Layout.createSequentialGroup().addGap(30, 30, 30)
						.addComponent(jScrollPane2,
								javax.swing.GroupLayout.PREFERRED_SIZE, 700,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(44, Short.MAX_VALUE)).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				jPanel6Layout.createSequentialGroup().addContainerGap(209,
						Short.MAX_VALUE).addComponent(jLabel5,
						javax.swing.GroupLayout.PREFERRED_SIZE, 376,
						javax.swing.GroupLayout.PREFERRED_SIZE).addGap(189,
						189, 189)));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel6Layout.createSequentialGroup().addGap(28, 28, 28)
						.addComponent(jLabel5).addGap(31, 31, 31).addComponent(
								jScrollPane2,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(77, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		jTabbedPane1.addTab("UserRequests", jPanel5);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613,
				Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>

	// GEN-END:initComponents

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		int status = registrationDAO.preventFileUploadFiles(jComboBox3
				.getSelectedItem().toString());
		JOptionPane.showMessageDialog(jPanel1,
				"Prevention of data lossing packets recovery successfully...");

	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		Vector<Object[][]> vObjects = registrationDAO
				.viewVectorFileUploadFiles(jComboBox3.getSelectedItem()
						.toString());

		Object obj[][] = new Object[500][7];
		Iterator iterator = vObjects.iterator();
		while (iterator.hasNext()) {
			Object type[][] = (Object[][]) iterator.next();
			for (int i = 0; i < type.length; i++) {
				if (type[i][0] != null) {
					for (int j = 0; j < 7; j++) {
						obj[i][j] = type[i][j];
					}
				}
			}

		}

		jTable1.setModel(new javax.swing.table.DefaultTableModel(obj,
				new String[] { "ID", "FileName", "LossPackets", "AttackerName",
						"AttackingDate", "ActualSize", "DownloadSize" }));
		jScrollPane1.setViewportView(jTable1);
	}

	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
		Vector<Object[][]> vObjects = registrationDAO
				.viewVectorFileUploadFiles(jComboBox3.getSelectedItem()
						.toString());
		Vector<FileBean> vBeans = new Vector<FileBean>();
		FileBean fileBean = null;
		Iterator iterator = vObjects.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			Object type[][] = (Object[][]) iterator.next();
			System.out.println(vObjects.size());

			if (type[i][0] != null) {
				fileBean = new FileBean();
				fileBean.setAttackername(type[i][3].toString());
				fileBean
						.setFiledownloadsize(new Integer(type[i][6].toString()));
				i++;
				vBeans.add(fileBean);
			}

		}
		final MultiLineChart demo = new MultiLineChart("Benfit ROI Chart",
				vBeans);
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo
				.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		demo.setVisible(true);
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		int status = registrationDAO.preventVMUploadFiles(jComboBox2
				.getSelectedItem().toString());
		JOptionPane.showMessageDialog(jPanel1,
				"Prevention of data lossing packets recovery successfully...");

	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

		Vector<Object[][]> vObjects = registrationDAO
				.viewVMUploadFiles(jComboBox2.getSelectedItem().toString());

		Object obj[][] = new Object[500][7];
		Iterator iterator = vObjects.iterator();
		while (iterator.hasNext()) {
			Object type[][] = (Object[][]) iterator.next();
			for (int i = 0; i < type.length; i++) {
				if (type[i][0] != null) {
					for (int j = 0; j < 7; j++) {
						obj[i][j] = type[i][j];
					}
				}
			}
		}
		jTable1.setModel(new javax.swing.table.DefaultTableModel(obj,
				new String[] { "ID", "FileName", "LossPackets", "AttackerName",
						"AttackingDate", "ActualSize", "DownloadSize" }));
		jScrollPane1.setViewportView(jTable1);
	}

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		int status = registrationDAO.preventCloudUploadFiles(jComboBox1
				.getSelectedItem().toString());
		JOptionPane.showMessageDialog(jPanel1,
				"Prevention of data lossing packets recovery successfully...");
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		Vector<Object[][]> vObjects = registrationDAO
				.viewCloudUploadFiles(jComboBox1.getSelectedItem().toString());

		Object obj[][] = new Object[500][7];
		Iterator iterator = vObjects.iterator();
		while (iterator.hasNext()) {
			Object type[][] = (Object[][]) iterator.next();
			for (int i = 0; i < type.length; i++) {
				if (type[i][0] != null) {
					for (int j = 0; j < 7; j++) {
						obj[i][j] = type[i][j];
					}
				}
			}
		}
		jTable1.setModel(new javax.swing.table.DefaultTableModel(obj,
				new String[] { "ID", "FileName", "LossPackets", "AttackerName",
						"AttackingDate", "ActualSize", "DownloadSize" }));
		jScrollPane1.setViewportView(jTable1);
	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// new AttackAnalyserForm().setVisible(true);
			}
		});
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JComboBox jComboBox3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTabbedPane jTabbedPane4;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	// End of variables declaration//GEN-END:variables

}