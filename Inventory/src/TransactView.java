
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

	public class TransactView extends JFrame {
		
		private JLabel lblUni = new JLabel("UNI");
		private JLabel lblStore = new JLabel("STORE");
		private JLabel title = new JLabel("Inventory system");
		private JLabel logo = new JLabel("");
		private JPanel panel = new JPanel();
		private JLabel lbltitle = new JLabel("TRANSACTION HISTORY");
		private JScrollPane scrollPane = new JScrollPane();
		public JPanel prodpanel = new JPanel();
		public JLabel CloseButton = new JLabel("CLOSE");
		public JLabel btnback = new JLabel("  BACK");
		private JButton btnSave = new JButton("SAVE");
		public JTable table = new JTable();
		final Object[] row = new Object[6];
		
		DefaultTableModel model;
		
		TransactView(){
			setUndecorated(true); 
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(100, 100, 700, 550); //Frame size
			prodpanel = new JPanel();
			prodpanel.setBackground(new Color(51, 153, 153));
			prodpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			setprodpanel(prodpanel);
			setLocationRelativeTo(null);
			prodpanel.setLayout(null);
			
			prodpanel.add(lblUni,lblStore);
			prodpanel.add(title,logo);
			prodpanel.add(lbltitle,CloseButton);
			prodpanel.add(btnback,btnSave);
			
			scrollPane.setBounds(10, 186, 680, 295);
			prodpanel.add(scrollPane);
			
			table = new JTable();
			model = new DefaultTableModel();
			Object[] column = {"Product ID","Name","Category","Stock","Price","Description"};//add date
			model.setColumnIdentifiers(column);
			table.setModel(model);
			scrollPane.setViewportView(table);
			
			lblUni.setForeground(new Color(245, 245, 245));
			lblUni.setFont(new Font("Big John", Font.PLAIN, 50));
			lblUni.setBounds(257, 32, 124, 69);
			prodpanel.add(lblUni);			

			lblStore.setForeground(new Color(0, 51, 51));
			lblStore.setFont(new Font("Big John", Font.PLAIN, 50));
			lblStore.setBounds(350, 25, 209, 82);
			prodpanel.add(lblStore);
			
			title.setForeground(new Color(153, 204, 204));
			title.setFont(new Font("Big John", Font.PLAIN, 17));
			title.setBounds(258, 74, 242, 48);
			prodpanel.add(title);
			
			logo.setBounds(184, 0, 77, 130);
			//logo.setIcon(new ImageIcon(img_logo));
			prodpanel.add(logo);
			
			panel.setBackground(new Color(220, 220, 220));
			panel.setBounds(0, 132, 700, 10);
			prodpanel.add(panel);
			
			lbltitle.setForeground(SystemColor.menu);
			lbltitle.setFont(new Font("Big John", Font.PLAIN, 20));
			lbltitle.setBounds(213, 152, 287, 24);
			prodpanel.add(lbltitle);
						
			CloseButton.setHorizontalAlignment(SwingConstants.CENTER);
			CloseButton.setForeground(Color.BLACK);
			CloseButton.setFont(new Font("Arial Black", Font.BOLD, 16));
			CloseButton.setBounds(620, 0, 80, 41);
			prodpanel.add(CloseButton);
			
			btnback.setForeground(Color.BLACK);
			btnback.setFont(new Font("Arial Black", Font.PLAIN, 16));
			btnback.setBounds(0, 0, 71, 41);
			prodpanel.add(btnback);
			
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnSave.setBounds(213, 491, 287, 30);
			prodpanel.add(btnSave);
			
			this.add(prodpanel);
		}
		private void setprodpanel(JPanel prodpanel2) {
			
		}
		public Object[] getRow() {
		return row;
		}	
		void addSaveListener(ActionListener listenForSave) {
			btnSave.addActionListener(listenForSave);
			
		}
		void addBackListener(MouseListener listenForBack) {
			btnback.addMouseListener(listenForBack);
		}
		void addCloseListener(MouseListener listenDorClose) {
			CloseButton.addMouseListener(listenDorClose);
		}
		int displayValidation(String Message1, String Message2) {
			return JOptionPane.showConfirmDialog(null, Message1, Message2, JOptionPane.YES_NO_OPTION);	
		}
		void displaysuccesmessage(String succesMessage) {
			JOptionPane.showMessageDialog(null, succesMessage);
		}
		
	}
