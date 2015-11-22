package com.nice.cloudservers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ButtonAddDynamic {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ButtonAddDynamic().createAndShowGUI();
			}
		});
	}

	private JFrame frame;
	private JPanel panel = new JPanel(new GridBagLayout());
	private GridBagConstraints constraints = new GridBagConstraints();

	private List fields = new ArrayList();
	private List fieldButton = new ArrayList();
	private List fieldFile = new ArrayList();

	private static int countReport = 0;
	String files = null;
	int y = 2;

	protected void createAndShowGUI() {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		}
		for (int i = 5; i > 0; i--) {
			addColumn(i);
		}

		constraints.gridx = 0;
		constraints.gridy = 1;
		// panel.add(button1, constraints);

		frame = new JFrame("Add Button Dynamically");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new JScrollPane(panel));
		frame.setSize(500, 500);
		frame.setResizable(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	private void addColumn(int labelText) {
		constraints.gridx = fields.size();
		constraints.gridy = 1;
		constraints.gridy = 2;
		fields.add(null);

		constraints.gridy = 3;
		constraints.gridx = fields.size() + fieldButton.size();
		JButton button = new JButton("" + labelText);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(null,
						"Program to add swing components dynamically", "HI", 1);
			}
		});
		panel.add(button, constraints);
		fieldButton.add(button);
		panel.revalidate(); // redo layout for extra column
	}

}