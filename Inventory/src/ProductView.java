
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ProductView extends JFrame {
	
	private Image img_logo = new ImageIcon(ProductView.class.getResource("ress/logoh.png")).getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH);
	public JTextField ID = new JTextField(10);
	public JTextField name = new JTextField(10);
	public JTextField quantity = new JTextField(10);
	public JTextField price = new JTextField(10);
	public JTextField description = new JTextField(10);
	private JLabel lblUni = new JLabel("UNI");
	private JLabel lblStore = new JLabel("STORE");
	private JLabel title = new JLabel("Inventory system");
	private JLabel logo = new JLabel("");
	private JLabel lblTitle = new JLabel("PRODUCT INVENTORY");
	private JLabel lblProdID = new JLabel("Product ID:");
	private JLabel lblname = new JLabel("Name:");
	private JLabel lblcat = new JLabel("Category:");
	private JLabel lblstock = new JLabel("Stock:");
	private JLabel lblprice = new JLabel("Price:");
	private JLabel lbldesc = new JLabel("Description:");
	public JLabel CloseButton = new JLabel("CLOSE");
	public JLabel btnback = new JLabel("  BACK");
	public JTable table = new JTable();
	public JPanel prodpanel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel = new JPanel();
	public static JComboBox<String> comboBox;
	private JButton btnadd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private JButton btnClear = new JButton();
	private JButton btnSave = new JButton();
	private JButton btnSwitch = new JButton();
	final Object[] row = new Object[6];
	
	DefaultComboBoxModel combo;
	DefaultTableModel model;
	
	ProductView(){		
		JPanel prodpanel = new JPanel();
		setUndecorated(true); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 700, 550); //Frame size
		prodpanel.setBackground(new Color(51, 153, 153));
		prodpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setprodpanel(prodpanel);
		setLocationRelativeTo(null);
		prodpanel.setLayout(null);
		
		prodpanel.add(ID, name);
		prodpanel.add(quantity, price);
		prodpanel.add(description, lblUni);
		prodpanel.add(lblStore, title);
		prodpanel.add(lblTitle, logo);
		prodpanel.add(lblProdID, lblname);
		prodpanel.add(lblcat, lblstock);
		prodpanel.add(lblprice, lbldesc);
		prodpanel.add(scrollPane);
		prodpanel.add(btnadd, btnEdit);
		prodpanel.add(btnDelete, btnClear);
		prodpanel.add(btnSave, btnSwitch);
		
		
		scrollPane.setBounds(295, 186, 377, 292);
		prodpanel.add(scrollPane);
		
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Product ID","Name","Category","Quantity","Price","Description"};
		//final Object[] row = new Object[6];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);	
		
		lblUni.setBounds(257, 32, 124, 69);
		lblUni.setForeground(new Color(245, 245, 245));
		lblUni.setFont(new Font("Big John", Font.PLAIN, 50));
		prodpanel.add(lblUni);
		
		lblStore.setBounds(350, 25, 209, 82);
		lblStore.setForeground(new Color(0, 51, 51));
		lblStore.setFont(new Font("Big John", Font.PLAIN, 50));
		prodpanel.add(lblStore);
		
		title.setBounds(258, 74, 242, 48);
		title.setForeground(new Color(153, 204, 204));
		title.setFont(new Font("Big John", Font.PLAIN, 17));
		prodpanel.add(title);
		
		logo.setBounds(184, 0, 77, 130);
		logo.setIcon(new ImageIcon(img_logo));
		prodpanel.add(logo);
		
		panel.setBounds(0, 132, 700, 10);
		panel.setBackground(new Color(220, 220, 220));
		prodpanel.add(panel);
		
		lblTitle.setBounds(242, 152, 251, 24);
		lblTitle.setForeground(SystemColor.menu);
		lblTitle.setFont(new Font("Big John", Font.PLAIN, 20));
		prodpanel.add(lblTitle);
		
		lblProdID.setBounds(31, 186, 87, 24);
		lblProdID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prodpanel.add(lblProdID);
		
		lblname.setBounds(31, 220, 100, 24);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prodpanel.add(lblname);
		
		ID.setBounds(123, 191, 139, 19);
		prodpanel.add(ID);
		
		lblcat.setBounds(31, 253, 87, 24);
		lblcat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prodpanel.add(lblcat);
		
		lblstock.setBounds(31, 287, 87, 24);
		lblstock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prodpanel.add(lblstock);
		
		lblprice.setBounds(31, 321, 87, 24);
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prodpanel.add(lblprice);
		
		lbldesc.setBounds(31, 355, 87, 24);
		lbldesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prodpanel.add(lbldesc);
		
		name.setBounds(123, 225, 139, 19);
		prodpanel.add(name);
		
		quantity.setBounds(123, 292, 139, 19);
		prodpanel.add(quantity);
		
		price.setBounds(123, 326, 139, 19);
		prodpanel.add(price);
		
		description.setBounds(123, 360, 139, 38);
		prodpanel.add(description);
	
		//combo = new DefaultComboBoxModel();
		//comboBox.setBounds(123, 257, 138, 21);
		//prodpanel.add(comboBox);
		
		btnadd.setBounds(31, 408, 231, 30);
		btnadd.setFont(new Font("Tahoma", Font.BOLD, 12));
		prodpanel.add(btnadd);
		
		btnEdit.setBounds(31, 448, 231, 30);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		prodpanel.add(btnEdit);
		
		btnDelete.setBounds(31, 488, 100, 30);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		prodpanel.add(btnDelete);
		
		CloseButton.setBounds(620, 0, 80, 41);
		CloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		CloseButton.setForeground(Color.BLACK);
		CloseButton.setFont(new Font("Arial Black", Font.BOLD, 16));
		prodpanel.add(CloseButton);
		
		btnback.setBounds(0, 0, 71, 41);
		btnback.setForeground(Color.BLACK);
		btnback.setFont(new Font("Arial Black", Font.PLAIN, 16));
		prodpanel.add(btnback);
		
		btnClear.setBounds(161, 488, 100, 30);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		prodpanel.add(btnClear);
		
		btnSave.setBounds(295, 488, 165, 30);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		prodpanel.add(btnSave);
		
		btnSwitch.setBounds(507, 488, 165, 30);
		btnSwitch.setFont(new Font("Tahoma", Font.BOLD, 12));
		prodpanel.add(btnSwitch);
		
		this.add(prodpanel);

	}
	private void setprodpanel(JPanel prodpanel2) {
		// TODO Auto-generated method stub
		
	}
	public Object[] getRow() {
		return row;
	}


	public String getName() {
		return name.getText();
		
	}
	
	public String getQuantity() {
		return quantity.getText();
	}
	
	public String getPrice() {
		return price.getText();
		
	}
	
	public String getDescription() {
		return description.getText();
	}
	
	
	void addAddListener(ActionListener listenForbtnadd) {
		btnadd.addActionListener(listenForbtnadd);
		
	}
	
	void addEditListener(ActionListener listenForbtnEdit) {
		btnEdit.addActionListener(listenForbtnEdit);;
		
	}
	
	void addDelListener(ActionListener listenForbtnDelete) {
		btnDelete.addActionListener(listenForbtnDelete);
		
	}
	
	void addClearListener(ActionListener listenForClear) {
		btnClear.addActionListener(listenForClear);
		
	}
	
	void addSaveListener(ActionListener listenForSave) {
		btnSave.addActionListener(listenForSave);
		
	}
	
	void addSwitchListener(ActionListener listenForSwitch) {
		btnSwitch.addActionListener(listenForSwitch);
	}
	
	void addCloseListener(ActionListener listenForClose) {
		CloseButton.addMouseListener((MouseListener) listenForClose);
		
	}
	
	void addBackListener(ActionListener listenForBack) {
		btnback.addMouseListener((MouseListener) listenForBack);
		
	}
	boolean displayValidation(String errorMessage, String string) {
		JOptionPane.showConfirmDialog(CloseButton, errorMessage, errorMessage, JOptionPane.YES_NO_OPTION);
		return rootPaneCheckingEnabled;
	}
	void addComboboxListener(ActionListener listenForCombobox) {
		comboBox.addMouseListener((MouseListener) listenForCombobox);
	}
	
	void displaysuccesmessage(String succesMessage) {
		JOptionPane.showMessageDialog(null, succesMessage);
	}


	public static JComboBox<String> getComboBox() {
		return comboBox;
	}


	public static void setComboBox(JComboBox<String> comboBox) {
		fillComboFromTxtFile();
		ProductView.comboBox = comboBox;
	}


	private static void fillComboFromTxtFile() {
		  String filePath = "C:\\Users\\mynam\\Desktop\\PRODUCT\\info.txt";
	        File file = new File(filePath);
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            Object[] lines = br.lines().toArray();
	            
	            for(int i = 0; i < lines.length; i++){
	                String line = lines[i].toString();
	                comboBox.addItem(line);
	            }
	            } catch (FileNotFoundException ex) {
	            	ex.printStackTrace();
	            }	
	}

}	



	