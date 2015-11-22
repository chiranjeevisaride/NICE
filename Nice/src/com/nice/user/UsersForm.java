/*
 * UsersForm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.nice.user;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.TreeMap;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.springframework.beans.factory.BeanFactory;

import com.nice.bean.FileStatus;
import com.nice.bean.Users;
import com.nice.dao.DataBaseDataSource;
import com.nice.dao.RegistrationDAO;

/**
 * 
 * @author __USER__
 */
public class UsersForm extends javax.swing.JFrame {
	RegistrationDAO registrationDAO;
	TreeMap<Integer, Users> treeMap;
	Users taskrequest;
	int count;

	/** Creates new form UsersForm */
	public UsersForm(TreeMap<Integer, Users> treeMap, Users taskrequest) {
		try {
			this.treeMap = treeMap;
			this.taskrequest = taskrequest;
			count = treeMap.size() + 1;
			initComponents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		
		BeanFactory factory = new DataBaseDataSource().getDataFactory();
		registrationDAO = (RegistrationDAO) factory.getBean("registrationDAO");
		setTitle("UserForm");
		jPanel2 = new javax.swing.JPanel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList();

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100,
				Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100,
				Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		final String fileNames[] = registrationDAO.viewServerFiles().split(",");
		jList1.setModel(new javax.swing.AbstractListModel() {
			String[] strings = fileNames;

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane1.setViewportView(jList1);

		jButton1.setFont(new java.awt.Font("Tahoma", 1, 11));
		jButton1.setText("RequestDownload");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new java.awt.Font("Tahoma", 1, 11));
		jButton2.setText("CheckCloudPermission");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setFont(new java.awt.Font("Tahoma", 1, 11));
		jButton3.setText("Download");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addComponent(
						jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
						227, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(59,
						59, 59).addGroup(
						jPanel1Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING,
								false).addComponent(jButton1,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addComponent(jButton2,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addComponent(jButton3,
								javax.swing.GroupLayout.DEFAULT_SIZE, 190,
								Short.MAX_VALUE)).addContainerGap(71,
						Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				104,
																				104,
																				104)
																		.addComponent(
																				jButton1)
																		.addGap(
																				57,
																				57,
																				57)
																		.addComponent(
																				jButton2)
																		.addGap(
																				51,
																				51,
																				51)
																		.addComponent(
																				jButton3))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				412,
																				Short.MAX_VALUE)))
										.addContainerGap()));

		jTabbedPane1.addTab("user", jPanel1);

		jScrollPane1.setViewportView(jList1);
		jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				// jTabbedPane1MouseClicked(evt);
			}
		});
		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 547,
				Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout.createSequentialGroup().addComponent(
						jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		jTabbedPane1.addTab("FileKeys", jPanel3);

		Object obj[][] = registrationDAO.viewAllUploadFiles();
		Object string[] = registrationDAO.viewUplaodFileMetaData();
		jScrollPane2.setViewportView(jTable1);
		jTable1.setModel(new javax.swing.table.DefaultTableModel(obj, string));
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1));

		pack();
	}// </editor-fold>

	// GEN-END:initComponents

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		int status = registrationDAO.getFileStatus(jList1.getSelectedValue()
				.toString());
		if (status != 0) {
			JOptionPane.showMessageDialog(jPanel,
					"wait for Cloud Server provider permission");
		} else {
			String privatekey = JOptionPane
					.showInputDialog("Please Enter Private Key");
			if (privatekey != null) {
				String existedkey = registrationDAO.getKey(jList1
						.getSelectedValue().toString());
				if (existedkey.trim().equals(privatekey.trim())) {
					JOptionPane.showMessageDialog(null, "Key Matched",
							"Private Key", 1);
					Users users = (Users) treeMap.get(count);
					// if (!(users.getDownloadtime() > users.getMintime())) {
					try {
						String downloadfile = registrationDAO
								.downloadFile(jList1.getSelectedValue()
										.toString());
						if (!downloadfile.equals("")) {
							JFileChooser c = new JFileChooser();
							int x = c.showSaveDialog(null);
							if (x == JFileChooser.APPROVE_OPTION) {
								try {
									String saveFilename = null;
									String filename = new File(downloadfile)
											.getName().toString();
									System.out.println(filename);
									String[] token = filename.split("\\.");
									if (c.getSelectedFile() != null) {
										try {
											saveFilename = c.getSelectedFile()
													+ "." + token[1];
											FileInputStream fileInputStream = new FileInputStream(
													new File(downloadfile));
											FileOutputStream fileOutputStream = new FileOutputStream(
													saveFilename);
											int data;
											while ((data = fileInputStream
													.read()) != -1) {
												fileOutputStream.write(data);
												// fileOutputStream.write((int)
												// data);
											}
										} catch (Exception e) {
											// TODO: handle exception
										}
									} else {
										saveFilename = new File(downloadfile)
												.getName().toString();
									}
									System.out.println(saveFilename);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					} catch (Exception e) {
						System.out.println(e);
					}

				} else
					JOptionPane.showMessageDialog(null, "Key Not Matched",
							"Private Key", 1);
			}
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		int status = registrationDAO.getFileStatus(jList1.getSelectedValue()
				.toString());
		if (status != 0) {
			JOptionPane.showMessageDialog(jPanel,
					"wait for Cloud Server provider permission");
		} else {
			JOptionPane.showMessageDialog(jPanel,
					"Please click Download Button");
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		taskrequest.setFilename(jList1.getSelectedValue().toString());
		int filestatus = registrationDAO.getFileStatus(jList1
				.getSelectedValue().toString());
		taskrequest.setFilestatus(filestatus + "-"
				+ FileStatus.getFileStatus().get(filestatus));
		taskrequest.setRequestdate(new Date().toString());
		treeMap.put(count, taskrequest);
		JOptionPane.showMessageDialog(jPanel, "Request sent to Cloud Server");

	}

	private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {
		Object obj[][] = registrationDAO.viewAllUploadFiles();
		Object string[] = registrationDAO.viewUplaodFileMetaData();
		jTable1.setModel(new javax.swing.table.DefaultTableModel(obj, string));
		jScrollPane1.setViewportView(jTable1);
		JOptionPane.showMessageDialog(jPanel, "Request sent to Cloud Server");
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// new UsersForm().setVisible(true);
			}
		});
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JList jList1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;
	JPanel jPanel = new JPanel();
	// End of variables declaration//GEN-END:variables

}