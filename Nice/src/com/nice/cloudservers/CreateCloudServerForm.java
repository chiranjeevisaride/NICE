/*
 * CreateCloudServerForm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.nice.cloudservers;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.beans.factory.BeanFactory;

import com.nice.bean.CloudServer;
import com.nice.dao.DataBaseDataSource;
import com.nice.dao.RegistrationDAO;

/**
 * 
 * @author __USER__
 */
public class CreateCloudServerForm extends javax.swing.JFrame {
	String balancerName;
	RegistrationDAO registrationDAO;

	/** Creates new form CreateNodeForm */
	public CreateCloudServerForm(String balancerName) {
		this.balancerName = balancerName;
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
		BeanFactory beanFactory = new DataBaseDataSource().getDataFactory();
		registrationDAO = (RegistrationDAO) beanFactory
				.getBean("registrationDAO");
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("CreateCloudServerForm");

		jLabel1.setFont(new java.awt.Font("Verdana", 1, 12));
		jLabel1.setText("Name :");

		jLabel2.setFont(new java.awt.Font("Verdana", 1, 12));
		jLabel2.setText("Virtual IP :");

		jLabel3.setFont(new java.awt.Font("Verdana", 1, 12));
		jLabel3.setText("Port :");

		jLabel4.setFont(new java.awt.Font("Verdana", 1, 12));
		jLabel4.setText("Region :");

		jButton1.setText("Create");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/Load Balancing i1.jpg"))); // NOI18N

		jLabel5.setBackground(new java.awt.Color(255, 0, 0));
		jLabel5.setFont(new java.awt.Font("Verdana", 1, 14));
		jLabel5.setForeground(new java.awt.Color(255, 0, 0));
		jLabel5.setText("Create Cloud Server");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addGap(53, 53, 53)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(
																				jLabel2)
																		.addComponent(
																				jLabel1))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				8,
																				8,
																				8)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								jLabel4))))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																100,
																Short.MAX_VALUE)
														.addComponent(
																jTextField4,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																100,
																Short.MAX_VALUE)
														.addComponent(
																jTextField3,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																100,
																Short.MAX_VALUE)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																100,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jButton2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												147,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)).addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap(
										132, Short.MAX_VALUE).addComponent(
										jLabel5).addGap(115, 115, 115))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap(
										197, Short.MAX_VALUE).addComponent(
										jButton1).addGap(140, 140, 140)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				90,
																				90,
																				90)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel1)
																						.addComponent(
																								jTextField1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(
																				18,
																				18,
																				18)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jTextField2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(
																				26,
																				26,
																				26)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jTextField3,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel3))
																		.addGap(
																				26,
																				26,
																				26)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jTextField4,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel4))
																		.addGap(
																				18,
																				18,
																				18))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				38,
																				38,
																				38)
																		.addComponent(
																				jLabel5)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButton2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				140,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				27,
																				27,
																				27)))
										.addComponent(jButton1)
										.addContainerGap(63, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	// GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		JPanel jPanel = new JPanel();
		try {
			if (!jTextField1.getText().equals("")
					|| !jTextField3.getText().equals("")
					|| !jTextField3.getText().equals("")
					|| !jTextField4.getText().equals("")) {

				CloudServer cloudServer = new CloudServer();
				cloudServer.setName(jTextField1.getText());
				cloudServer.setVirtualip(jTextField2.getText());
				cloudServer.setPort(jTextField3.getText());
				cloudServer.setRegion(jTextField4.getText());

				boolean flag = registrationDAO.createCloudServer(cloudServer)
						.booleanValue();
				if (flag) {
					JOptionPane.showMessageDialog(jPanel,
							"Cloud Server Created SuccessFully");
				} else {
					JOptionPane.showMessageDialog(jPanel,
							"Cloud Server Created SuccessFully");
				}
			} else {
				JOptionPane
						.showMessageDialog(jPanel, "Please Enter All Fields");
			}

		} catch (Exception e) {
			System.out.println(e);
			JOptionPane
					.showMessageDialog(jPanel, "	Load Balancer  Not Created");
		}

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CreateVirtuvalMachineForm("a").setVisible(true);
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
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	// End of variables declaration//GEN-END:variables

}