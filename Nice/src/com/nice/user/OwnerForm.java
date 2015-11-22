package com.nice.user;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.security.cert.X509Certificate;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.BeanFactory;

import com.nice.bean.FileBean;
import com.nice.bean.Users;
import com.nice.dao.DataBaseDataSource;
import com.nice.dao.RegistrationDAO;
import com.nice.key.CryptMsgUtil;
import com.nice.key.X509V1Certificate;

/**
 * 
 * @author __USER__
 */
public class OwnerForm extends javax.swing.JFrame {
	RegistrationDAO registrationDAO;
	Users users;

	/** Creates new form OwnerForm */
	public OwnerForm(Users users) {
		this.users = users;
		try {
			System.out.println("haiiiiiii");
			initComponents();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// Determine the new location of the window
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width - w) / 4;
		int y = (dim.height - h) / 4;
		BeanFactory factory = new DataBaseDataSource().getDataFactory();
		registrationDAO = (RegistrationDAO) factory.getBean("registrationDAO");

		// Move the window
		this.setLocation(x, y);
		jTabbedPane2 = new javax.swing.JTabbedPane();
		jPanel3 = new javax.swing.JPanel();
		jpanel = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jLabel3 = new JLabel();		jLabel5 = new JLabel();		jLabel4 = new JLabel();

		jPanel2 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jPanel5 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100,
				Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100,
				Short.MAX_VALUE));

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100,
				Short.MAX_VALUE));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100,
				Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("OwnerForm");

		jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTabbedPane1MouseClicked(evt);
			}
		});

		jButton1.setText("Browse");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout.createSequentialGroup().addContainerGap()
						.addComponent(jButton1).addContainerGap(15,
								Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				jPanel2Layout.createSequentialGroup().addContainerGap(77,
						Short.MAX_VALUE).addComponent(jButton1)));

		jLabel1.setFont(new java.awt.Font("Verdana", 1, 12));
		jLabel1.setForeground(new java.awt.Color(255, 0, 0));
		jLabel1.setText("File :");

		jButton2.setText("Upload");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Verdana", 1, 18));
		jLabel2.setForeground(new java.awt.Color(255, 51, 0));
		jLabel2.setText("Upload File Here");

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel3.setForeground(new java.awt.Color(255, 0, 0));
		jLabel3.setText("VMNAME :");

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel4.setForeground(new java.awt.Color(255, 0, 51));
		jLabel4.setText("KEY :");

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel5.setForeground(new java.awt.Color(255, 0, 0));
		jLabel5.setText("SIGNATURE :");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
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
																				47,
																				47,
																				47)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel1)
																										.addGap(
																												30,
																												30,
																												30)
																										.addComponent(
																												jTextField1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												195,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								jLabel2))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jPanel2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				166,
																				166,
																				166)
																		.addComponent(
																				jButton2))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				119,
																				119,
																				119)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								jLabel5))
																		.addGap(
																				18,
																				18,
																				18)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel8)
																						.addComponent(
																								jLabel7)
																						.addComponent(
																								jLabel6))))
										.addContainerGap(59, Short.MAX_VALUE)));
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
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				52,
																				52,
																				52)
																		.addComponent(
																				jPanel2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel2)
																		.addGap(
																				39,
																				39,
																				39)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel1)
																						.addComponent(
																								jTextField1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addGap(33, 33, 33)
										.addComponent(jButton2)
										.addGap(32, 32, 32)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(jLabel6))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(jLabel7))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(jLabel8))
										.addContainerGap(82, Short.MAX_VALUE)));

		jTabbedPane1.addTab("Upload", jPanel1);

		Object obj[][] = registrationDAO.viewUploadFiles(users.getLoginid());
		Object string[] = registrationDAO.viewUplaodFileMetaData();

		jTable1.setModel(new javax.swing.table.DefaultTableModel(obj, string));
		jScrollPane1.setViewportView(jTable1);

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel5Layout.createSequentialGroup().addContainerGap(
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel5Layout.createSequentialGroup().addComponent(
						jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
						395, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		jTabbedPane1.addTab("ViewFiles", jPanel5);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>

	// GEN-END:initComponents

	private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {
		Object obj[][] = registrationDAO.viewUploadFiles(users.getLoginid());
		Object string[] = registrationDAO.viewUplaodFileMetaData();

		jTable1.setModel(new javax.swing.table.DefaultTableModel(obj, string));
		jScrollPane1.setViewportView(jTable1);

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		browse();
	}

	private void browse() {
		// TODO Auto-generated method stub
		JFileChooser jfr = new JFileChooser();
		int check = jfr.showOpenDialog(this);
		try {
			if (check == JFileChooser.APPROVE_OPTION) {

				String path = jfr.getSelectedFile().getPath();

				jTextField1.setText(path);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

		FileBean fileBean = new FileBean();
		fileBean.setFilename(jTextField1.getText());
		fileBean.setVmowner(users.getLoginid());

		CryptMsgUtil decrypt = new CryptMsgUtil(new File(jTextField1.getText())
				.getName());
		String key = decrypt.encrypt(new File(jTextField1.getText()).getName());
		fileBean.setKey(key);

		X509V1Certificate certificate = certificate = new X509V1Certificate();
		X509Certificate cert = certificate.getCertificate();
		String[] s = String.valueOf(cert).split("Signature:");
		fileBean.setSignature(s[1].trim());
		String vmname = registrationDAO.uploadCloudFile(fileBean);

		jLabel6.setText(vmname);
		jLabel7.setText(fileBean.getKey());
		jLabel8.setText(fileBean.getSignature());

		if (!vmname.equals("")) {
			JOptionPane.showMessageDialog(jpanel, "File SuccessFully Uploaded");
		} else {
			JOptionPane.showMessageDialog(jpanel, "File Uploading Fail");
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// new OwnerForm().setVisible(true);
			}
		});
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	javax.swing.JLabel jLabel6;
	javax.swing.JLabel jLabel7;
	javax.swing.JLabel jLabel8;
	private javax.swing.JPanel jPanel1;
	javax.swing.JPanel jpanel;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTabbedPane jTabbedPane2;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables

}