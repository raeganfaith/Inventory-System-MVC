import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
	private JLabel lblprice = new JLabel("Price:");
	private JLabel lbldesc = new JLabel("Description:");
	public JLabel CloseButton = new JLabel("CLOSE");
	public JLabel btnback = new JLabel("  BACK");
	public JTable table = new JTable();
	private JPanel contentPane = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel = new JPanel();
	private JButton btnadd = new JButton("ADD");
	private JButton btnEdit = new JButton("EDIT");
	private JButton btnDelete = new JButton("DELETE");
	private JButton btnClear = new JButton("CLEAR");
	private JButton btnSave = new JButton("SAVE");
	private JButton btnSwitch = new JButton("PREVIEW");
	static Object[] row = new Object[6];
	static JComboBox<String> comboBox;
	
	DefaultComboBoxModel combo;
	DefaultTableModel model;

	ProductView(){
		JPanel prodpanel = new JPanel();
		
		setUndecorated(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		lblUni.setBounds(257, 32, 124, 69);
		lblUni.setForeground(new Color(245, 245, 245));
		lblUni.setFont(new Font("Big John", Font.PLAIN, 50));
		contentPane.add(lblUni);
		
		lblStore.setBounds(350, 25, 209, 82);
		lblStore.setForeground(new Color(0, 51, 51));
		lblStore.setFont(new Font("Big John", Font.PLAIN, 50));
		contentPane.add(lblStore);
		
		title.setBounds(258, 74, 242, 48);
		title.setForeground(new Color(153, 204, 204));
		title.setFont(new Font("Big John", Font.PLAIN, 17));
		contentPane.add(title);
		
		logo.setBounds(184, 0, 77, 130);
		logo.setIcon(new ImageIcon(img_logo));
		contentPane.add(logo);
		
		panel.setBounds(0, 132, 700, 10);
		panel.setBackground(new Color(220, 220, 220));
		contentPane.add(panel);
		
		lblTitle.setBounds(242, 152, 251, 24);
		lblTitle.setForeground(SystemColor.menu);
		lblTitle.setFont(new Font("Big John", Font.PLAIN, 20));
		contentPane.add(lblTitle);
		
		lblProdID.setBounds(31, 186, 100, 30);
		lblProdID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblProdID);
		
		lblname.setBounds(31, 226, 100, 35);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblname);
		
		ID.setBounds(123, 186, 139, 30);
		contentPane.add(ID);
		ID.setColumns(10);
		
		lblcat.setBounds(31, 271, 87, 34);
		lblcat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblcat);
		
		lblprice.setBounds(31, 366, 87, 30);
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblprice);
		
		name = new JTextField();
		name.setBounds(123, 229, 138, 30);
		name.setColumns(10);
		contentPane.add(name);
		
		quantity = new JTextField();
		quantity.setBounds(123, 321, 139, 30);
		quantity.setColumns(10);
		contentPane.add(quantity);
		
		price = new JTextField();
		price.setBounds(123, 366, 139, 30);
		price.setColumns(10);
		contentPane.add(price);
		
		comboBox = new JComboBox();
		combo = new DefaultComboBoxModel();
		comboBox.setBounds(123, 275, 138, 30);
		contentPane.add(comboBox);
		fill();
		fillComboFromTxtFile();
		
		scrollPane.setBounds(295, 186, 377, 292);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Product ID","Name","Category","Stock","Price"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		btnadd.setBounds(31, 408, 231, 30);
		btnadd.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnadd);
		
		btnEdit.setBounds(31, 448, 231, 30);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnEdit);
		
		btnDelete.setBounds(31, 488, 100, 30);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnDelete);
		
		CloseButton.setBounds(620, 0, 80, 41);
		CloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		CloseButton.setForeground(Color.BLACK);
		CloseButton.setFont(new Font("Arial Black", Font.BOLD, 16));
		contentPane.add(CloseButton);
		
		btnback.setBounds(0, 0, 71, 41);
		btnback.setForeground(Color.BLACK);
		btnback.setFont(new Font("Arial Black", Font.PLAIN, 16));
		contentPane.add(btnback);
		
		btnClear.setBounds(161, 488, 100, 30);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnClear);
		
		btnSave.setBounds(295, 488, 165, 30);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnSave);
		
		btnSwitch.setBounds(507, 488, 165, 30);
		btnSwitch.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnSwitch);
		
		getContentPane().add(prodpanel);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStock.setBounds(31, 320, 87, 36);
		contentPane.add(lblStock);
		
	}
	
	public String getID() {
		return ID.getText();
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
	
	void addAddListener (ActionListener listenForbtnadd) {
		btnadd.addActionListener(listenForbtnadd);
	}
	
	void addEditListener (ActionListener listenForEdit) {
		btnEdit.addActionListener(listenForEdit);
	}
	
	void addClearListener (ActionListener listenForClear) {
		btnClear.addActionListener(listenForClear);
	}
	void addSaveListener (ActionListener listenForSave) {
		btnSave.addActionListener(listenForSave);
	}
	void addSwitchListener (ActionListener listenForSwitch) {
		btnSwitch.addActionListener(listenForSwitch);
	}
	void addBackListener (MouseListener listenForBack) {
		btnback.addMouseListener(listenForBack);
	}
	void addCloseListener (MouseListener listenForClose) {
		CloseButton.addMouseListener(listenForClose);
	}
	void addDeleteListener (ActionListener listenForDelete) {
		btnDelete.addActionListener(listenForDelete);
	}
	int Validation(String Message1, String Message2) {
		return JOptionPane.showConfirmDialog(null, Message1, Message2, JOptionPane.YES_NO_OPTION);	
	}
	void addTableListener(MouseListener listenForTable) {
		table.addMouseListener(listenForTable);
	}

	public Object[] getRow() {
		return row;
	}
	
	public JComboBox<String> fill() {
		return comboBox;
		
	}
	void fillComboFromTxtFile() {
		try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\mynam\\\\Desktop\\\\INVENTORY SYSTEM\\\\CATEGORYDROPDOWNBOX.txt"));
            Object[] lines = br.lines().toArray();
            
            for(int i = 0; i < lines.length; i++){
               String line = lines[i].toString();
              comboBox.addItem(line);
           }
            } catch (FileNotFoundException ex) {
            	ex.printStackTrace();
            }
	}
	
	void theMessage(String Message) {
		JOptionPane.showMessageDialog(null, Message);
	}
}

