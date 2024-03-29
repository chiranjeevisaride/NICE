/*
 * PublicCloudOwnerForm.java
 *
 * Created on __DATE__, __TIME__
 */

package rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.springframework.beans.factory.BeanFactory;

import com.nice.bean.CloudServer;
import com.nice.bean.Users;
import com.nice.cloudservers.CreateCloudServerForm;
import com.nice.cloudservers.CreateVirtuvalMachineForm;
import com.nice.dao.DataBaseDataSource;
import com.nice.dao.RegistrationDAO;
import com.nice.graph.ChartPanel;
import com.nice.user.DeleteFile;

/**
 * 
 * @author __USER__
 */
public class PublicCloudOwnerForm extends javax.swing.JFrame {

	Users users;
	TreeMap<Integer, Users> treeMap;
	RegistrationDAO registrationDAO;

	/** Creates new form PublicCloudOwnerForm */
	public PublicCloudOwnerForm(TreeMap<Integer, Users> treeMap, Users users) {
		BeanFactory factory = new DataBaseDataSource().getDataFactory();
		registrationDAO = (RegistrationDAO) factory.getBean("registrationDAO");
		this.treeMap = treeMap;
		this.users = users;
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

		jFrame1 = new javax.swing.JFrame();
		jFrame2 = new javax.swing.JFrame();
		jFrame3 = new javax.swing.JFrame();
		jDialog1 = new javax.swing.JDialog();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jComboBox1 = new javax.swing.JComboBox();
		jButton2 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jComboBox2 = new javax.swing.JComboBox();
		jButton8 = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList();
		jButton7 = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jScrollPane4 = new javax.swing.JScrollPane();
		jTable3 = new javax.swing.JTable();
		jButton10 = new javax.swing.JButton();
		jButton11 = new javax.swing.JButton();
		jLabel6 = new javax.swing.JLabel();
		if(users.getLogintype().equals("user")){
			jButton1.setEnabled(false);
			jButton9.setEnabled(false);
			jButton3.setEnabled(false);
			jButton4.setEnabled(false);
			jButton8.setEnabled(false);
			
		}

		javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(
				jFrame1.getContentPane());
		jFrame1.getContentPane().setLayout(jFrame1Layout);
		jFrame1Layout.setHorizontalGroup(jFrame1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
				Short.MAX_VALUE));
		jFrame1Layout.setVerticalGroup(jFrame1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
				Short.MAX_VALUE));

		javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(
				jFrame2.getContentPane());
		jFrame2.getContentPane().setLayout(jFrame2Layout);
		jFrame2Layout.setHorizontalGroup(jFrame2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
				Short.MAX_VALUE));
		jFrame2Layout.setVerticalGroup(jFrame2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
				Short.MAX_VALUE));

		javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(
				jFrame3.getContentPane());
		jFrame3.getContentPane().setLayout(jFrame3Layout);
		jFrame3Layout.setHorizontalGroup(jFrame3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
				Short.MAX_VALUE));
		jFrame3Layout.setVerticalGroup(jFrame3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
				Short.MAX_VALUE));

		javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(
				jDialog1.getContentPane());
		jDialog1.getContentPane().setLayout(jDialog1Layout);
		jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
				Short.MAX_VALUE));
		jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
				Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("PublicCloudOwner");

		jPanel1.setBackground(new java.awt.Color(204, 255, 204));
		jPanel1.setForeground(new java.awt.Color(153, 255, 255));

		jLabel1.setFont(new java.awt.Font("Verdana", 1, 18));
		jLabel1.setForeground(new java.awt.Color(255, 51, 51));
		jLabel1.setText("Cloud LoadBalancers");

		jButton1.setText("Create Load Balancer");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentShown(java.awt.event.ComponentEvent evt) {
				// jTable1ComponentShown(evt);
			}
		});
		jTable1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseMoved(java.awt.event.MouseEvent evt) {
				//jTable1MouseMoved(evt);
			}
		});
		jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				//jTable1FocusGained(evt);
			}
		});
		jScrollPane1.setViewportView(jTable1);

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));

		jButton2.setText("View Load Balancer Nodes");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		jButton9.setText("changestatus");
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});

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
																				104,
																				104,
																				104)
																		.addComponent(
																				jLabel1))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				418,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(44, Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jComboBox1, 0,
																167,
																Short.MAX_VALUE)
														.addComponent(
																jButton9,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																167,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																219,
																Short.MAX_VALUE)
														.addComponent(
																jButton1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																219,
																Short.MAX_VALUE))
										.addGap(78, 78, 78)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												207, Short.MAX_VALUE)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				11,
																				11,
																				11)
																		.addComponent(
																				jButton1))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jComboBox1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jButton9)
																						.addComponent(
																								jButton2))))
										.addGap(12, 12, 12)));

		jPanel2.setBackground(new java.awt.Color(204, 204, 255));

		jLabel2.setBackground(new java.awt.Color(0, 0, 0));
		jLabel2.setFont(new java.awt.Font("Verdana", 1, 14));
		jLabel2.setForeground(new java.awt.Color(255, 0, 51));
		jLabel2.setText("Nodes");

		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane2.setViewportView(jTable2);

		jButton3.setText("Create Server Nodes");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("Delete Server Nodes");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));

		jButton8.setText("ChangeStatus");
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanel2Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jLabel2))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanel2Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jScrollPane2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanel2Layout
																		.createSequentialGroup()
																		.addGap(
																				43,
																				43,
																				43)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jButton8,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jComboBox2,
																								0,
																								135,
																								Short.MAX_VALUE))
																		.addGap(
																				29,
																				29,
																				29)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jButton4,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								257,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton3,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								257,
																								Short.MAX_VALUE))))
										.addContainerGap()));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addComponent(jLabel2)
										.addGap(18, 18, 18)
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												223,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(11, 11, 11)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton3)
														.addComponent(
																jComboBox2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton4)
														.addComponent(jButton8))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jPanel3.setBackground(new java.awt.Color(204, 204, 255));

		jLabel3.setFont(new java.awt.Font("Arial", 1, 12));
		jLabel3.setText("Upload FileHere :");

		jButton5.setText("Browse");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setText("Upload");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});
		BeanFactory factory = new DataBaseDataSource().getDataFactory();
		RegistrationDAO registrationDAO = (RegistrationDAO) factory
				.getBean("registrationDAO");
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
		jScrollPane3.setViewportView(jList1);

		jButton7.setText("Download");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jLabel4.setFont(new java.awt.Font("Verdana", 1, 14));
		jLabel4.setForeground(new java.awt.Color(255, 0, 0));
		jLabel4.setText("File Upload and Download :");

		jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/upload.jpg"))); // NOI18N

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout.createSequentialGroup().addGap(
										30, 30, 30).addComponent(jLabel4)
										.addContainerGap(237, Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(35, 35, 35).addComponent(
												jLabel5).addGap(113, 113, 113))
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jTextField1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												255,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jButton5)
										.addContainerGap(32, Short.MAX_VALUE))
						.addGroup(
								jPanel3Layout.createSequentialGroup().addGap(
										183, 183, 183).addComponent(jButton6)
										.addContainerGap(230, Short.MAX_VALUE))
						.addGroup(
								jPanel3Layout.createSequentialGroup().addGap(
										82, 82, 82).addComponent(jButton7,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										273, Short.MAX_VALUE).addGap(125, 125,
										125)));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addGap(22, 22, 22)
										.addComponent(jLabel4)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton5))
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel3Layout
																		.createSequentialGroup()
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jButton6)
																		.addGap(
																				28,
																				28,
																				28)
																		.addComponent(
																				jLabel5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				103,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel3Layout
																		.createSequentialGroup()
																		.addGap(
																				50,
																				50,
																				50)
																		.addComponent(
																				jScrollPane3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(28, 28, 28).addComponent(
												jButton7).addGap(81, 81, 81)));

		jPanel4.setBackground(new java.awt.Color(255, 204, 204));

		jTable3.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane4.setViewportView(jTable3);

		jButton10.setText("GenerateGraph");
		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}
		});

		jButton11.setText("FutureGraph");
		jButton11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton11ActionPerformed(evt);
			}
		});

		jLabel6.setFont(new java.awt.Font("Arial", 1, 14));
		jLabel6.setForeground(new java.awt.Color(204, 0, 0));
		jLabel6.setText("File Upload Details ");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jLabel6,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				163,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(
																jScrollPane4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addGap(
																				71,
																				71,
																				71)
																		.addComponent(
																				jButton10,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				139,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				54,
																				54,
																				54)
																		.addComponent(
																				jButton11,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				128,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(20, Short.MAX_VALUE)));
		jPanel4Layout
				.setVerticalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addGap(34, 34, 34)
										.addComponent(
												jLabel6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												27,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												158,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(27, 27, 27)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton10)
														.addComponent(jButton11))
										.addContainerGap(61, Short.MAX_VALUE)));

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
														.addComponent(
																jPanel3,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPanel1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel4,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPanel2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))));
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
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPanel2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(jPanel3,
																0, 336,
																Short.MAX_VALUE)
														.addComponent(
																jPanel4,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));

		pack();
	}// </editor-fold>

	// GEN-END:initComponents

	

	

	private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
		BeanFactory factory = new DataBaseDataSource().getDataFactory();
		RegistrationDAO registrationDAO = (RegistrationDAO) factory
				.getBean("registrationDAO");
		Vector<CloudServer> vLoadBalancers = registrationDAO
				.viewUploadedFileGraph(new File(jTextField1.getText())
						.getName());
		new ChartPanel().viewGraph(vLoadBalancers);
	}

	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
		BeanFactory factory = new DataBaseDataSource().getDataFactory();
		RegistrationDAO registrationDAO = (RegistrationDAO) factory
				.getBean("registrationDAO");
		Vector<CloudServer> vLoadBalancers = registrationDAO
				.viewUploadedFutureFileGraph(new File(jTextField1.getText())
						.getName());
		new ChartPanel().viewGraph(vLoadBalancers);
	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		BeanFactory factory = new DataBaseDataSource().getDataFactory();
		RegistrationDAO registrationDAO = (RegistrationDAO) factory
				.getBean("registrationDAO");
		try {
			String file = jList1.getSelectedValue().toString();
			if (!file.equals("")) {
				String downloadfile = registrationDAO.downloadFile(file);
				JFileChooser c = new JFileChooser();
				int x = c.showSaveDialog(null);
				if (x == JFileChooser.APPROVE_OPTION) {
					try {

						String saveFilename = null;
						String filename = new File(downloadfile).getName()
								.toString();
						System.out.println(filename);
						String[] token = filename.split("\\.");

						if (c.getSelectedFile() != null) {
							try {
								saveFilename = c.getSelectedFile() + "."
										+ token[1];
								FileInputStream fileInputStream = new FileInputStream(
										new File(downloadfile));
								FileOutputStream fileOutputStream = new FileOutputStream(
										saveFilename);
								int data;
								while ((data = fileInputStream.read()) != -1) {
									fileOutputStream.write(data);
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
						} else {
							saveFilename = new File(downloadfile).getName()
									.toString();
						}
						System.out.println(saveFilename);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				String deletefile = new File("download").getAbsolutePath();
				new DeleteFile().deletemethod(deletefile);
				JOptionPane.showMessageDialog(null,
						"File Downloaded successfully", "Download File", 1);

			} else {
				JOptionPane.showMessageDialog(null, "Please Select One File",
						"Download File", 1);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		JPanel jPanel = new JPanel();
		String status = JOptionPane
				.showInputDialog("Please Enter Statsu Only Idle (or) Normal (or) Overload");

		if (status.toLowerCase().equals("idle")
				|| status.toLowerCase().equals("normal")
				|| status.toLowerCase().equals("overload")) {

			BeanFactory factory = new DataBaseDataSource().getDataFactory();
			RegistrationDAO registrationDAO = (RegistrationDAO) factory
					.getBean("registrationDAO");
			int flag = 0;
			try {
				flag = registrationDAO
						.changeServerNodeStatus(status.toLowerCase(),
								jComboBox2.getSelectedItem().toString());
			} catch (Exception e) {
				System.out.println(e);
			}
			if (flag > 0) {
				JOptionPane.showMessageDialog(jPanel,
						"Status Changed SuccessFully...");
			}
			repaint();
		} else {
			JOptionPane.showMessageDialog(jPanel, "Please Enter Proper String");
		}
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		JPanel jPanel = new JPanel();

		BeanFactory factory = new DataBaseDataSource().getDataFactory();
		RegistrationDAO registrationDAO = (RegistrationDAO) factory
				.getBean("registrationDAO");
		boolean flag = false;
		try {
			flag = registrationDAO.deleteServerNodes(jComboBox2
					.getSelectedItem().toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		if (flag) {
			JOptionPane.showMessageDialog(jPanel,
					"Server Node Deleted SuccessFully...");
		} else {
			JOptionPane.showMessageDialog(jPanel,
					"Server Node Deleted SuccessFully...");
		}
	}

	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
		JPanel jPanel = new JPanel();
		String status = JOptionPane
				.showInputDialog("Please Enter Statsu Only Idle (or) Normal (or) Overload");

		if (status.toLowerCase().equals("idle")
				|| status.toLowerCase().equals("normal")
				|| status.toLowerCase().equals("overload")) {

			BeanFactory factory = new DataBaseDataSource().getDataFactory();
			RegistrationDAO registrationDAO = (RegistrationDAO) factory
					.getBean("registrationDAO");
			int flag = 0;
			try {
				flag = registrationDAO.changeServerStatus(status.toLowerCase(),
						jComboBox1.getSelectedItem().toString());
			} catch (Exception e) {
				System.out.println(e);
			}
			if (flag > 0) {
				JOptionPane.showMessageDialog(jPanel,
						"Status Changed SuccessFully...");
			}
			repaint();
		} else {
			JOptionPane.showMessageDialog(jPanel, "Please Enter Proper String");
		}

	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		CreateVirtuvalMachineForm createNodeForm = new CreateVirtuvalMachineForm(jComboBox1
				.getSelectedItem().toString());
		createNodeForm.setVisible(true);

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		CreateCloudServerForm createLoadBalancerForm = new CreateCloudServerForm(
				jComboBox1.getSelectedItem().toString());
		createLoadBalancerForm.setVisible(true);

	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		browse();
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		BeanFactory factory = new DataBaseDataSource().getDataFactory();
		RegistrationDAO registrationDAO = (RegistrationDAO) factory
				.getBean("registrationDAO");
		boolean flag = registrationDAO.uploadCloudFile(jTextField1.getText());
		java.util.List<CloudServer> list = registrationDAO
				.viewCloudFile(new File(jTextField1.getText()).getName());
		Iterator rs = list.iterator();
		Object obj[][] = new Object[list.size()][4];
		int i = 0;
		CloudServer loadBalancer;
		while (rs.hasNext()) {
			loadBalancer = (CloudServer) rs.next();
			obj[i][0] = loadBalancer.getOrderid();
			obj[i][1] = loadBalancer.getBalancername();
			obj[i][2] = loadBalancer.getServername();
			obj[i][3] = loadBalancer.getFilesize();
			i++;
		}
		Object string[] = registrationDAO.fileDetailsMetaData(new File(
				jTextField1.getText()).getName());
		jTable3.setModel(new javax.swing.table.DefaultTableModel(obj, string));
		jScrollPane4.setViewportView(jTable3);

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

		BeanFactory factory = new DataBaseDataSource().getDataFactory();
		RegistrationDAO registrationDAO = (RegistrationDAO) factory
				.getBean("registrationDAO");
		String balancerName = jComboBox1.getSelectedItem().toString();
		

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
/*	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PublicCloudOwnerForm().setVisible(true);
			}
		});
	}*/

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton11;
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
	private javax.swing.JDialog jDialog1;
	private javax.swing.JFrame jFrame1;
	private javax.swing.JFrame jFrame2;
	private javax.swing.JFrame jFrame3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JList jList1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTable jTable3;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables

}