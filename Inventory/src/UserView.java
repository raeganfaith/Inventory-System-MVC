
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class UserView extends JFrame{
	
	private Image img_logo = new ImageIcon(UserView.class.getResource("ress/logoh.png")).getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH);
	
	public JTextField userid = new JTextField(10);
	public JTextField role = new JTextField(10);
	public JTextField user = new JTextField(10);
	public JTextField password = new JTextField(10);
	public JTextField phone = new JTextField(10);
	private JLabel lblUni = new JLabel("UNI");
	private JLabel lblStore = new JLabel("STORE");
	private JLabel lblNewLabel_1 = new JLabel("Inventory system");
	private JLabel lblNewLabel = new JLabel("");
	private JPanel panel = new JPanel();
	private JLabel lblNewLabel_2 = new JLabel("MANAGE USERS:");
	private JLabel lblNewLabel_3 = new JLabel("User ID:");
	private JLabel lblNewLabel_3_1 = new JLabel("Role:");
	private JLabel lblNewLabel_3_1_1 = new JLabel("Username:");
	private JLabel lblNewLabel_3_1_2 = new JLabel("Password:");
	private JButton btnEdit = new JButton("EDIT");
	private JButton btnDelete = new JButton("DELETE");
	private JScrollPane scrollPane = new JScrollPane();
	private JButton btnAdd = new JButton("ADD");
	public JLabel btnback = new JLabel("  BACK");
	private JLabel phonenum = new JLabel("Phone:");
	public JLabel CloseButton = new JLabel("CLOSE");
	private JButton btnsClear = new JButton("CLEAR");
	private JButton btnExport = new JButton("SAVE");
	private JPanel contentPane = new JPanel();
	public JTable table = new JTable();
	final Object[] row = new Object[5];

	DefaultTableModel model;
	
	UserView(){
		
		JPanel userpanel = new JPanel();
		
		setUndecorated(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		userpanel.add(userid, role);
		userpanel.add(user, password);
		userpanel.add(phone, lblUni);
		userpanel.add(lblStore, lblNewLabel_1);
		userpanel.add(lblNewLabel, panel);
		userpanel.add(lblNewLabel_2, lblNewLabel_3);
		userpanel.add(lblNewLabel_3_1, lblNewLabel_3_1_1);
		userpanel.add(lblNewLabel_3_1_2, btnEdit);
		userpanel.add(btnDelete, scrollPane);
		userpanel.add(btnAdd, btnback);
		userpanel.add(phonenum, CloseButton);
		userpanel.add(btnsClear, btnExport);

		lblUni.setForeground(new Color(245, 245, 245));
		lblUni.setFont(new Font("Big John", Font.PLAIN, 50));
		lblUni.setBounds(257, 32, 124, 69);
		contentPane.add(lblUni);
		
		lblStore.setForeground(new Color(0, 51, 51));
		lblStore.setFont(new Font("Big John", Font.PLAIN, 50));
		lblStore.setBounds(350, 25, 209, 82);
		contentPane.add(lblStore);
		
		lblNewLabel_1.setForeground(new Color(153, 204, 204));
		lblNewLabel_1.setFont(new Font("Big John", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(258, 74, 242, 48);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel.setBounds(184, 0, 77, 130);
		lblNewLabel.setIcon(new ImageIcon(img_logo));
		contentPane.add(lblNewLabel);
		
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 132, 700, 10);
		contentPane.add(panel);
		
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(SystemColor.menu);
		lblNewLabel_2.setFont(new Font("Big John", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(242, 152, 251, 24);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(30, 193, 87, 24);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(30, 227, 100, 24);
		contentPane.add(lblNewLabel_3_1);
		
		userid.setBounds(122, 198, 139, 19);
		contentPane.add(userid);
		
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(30, 260, 87, 24);
		contentPane.add(lblNewLabel_3_1_1);
		
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2.setBounds(30, 294, 87, 24);
		contentPane.add(lblNewLabel_3_1_2);
		
		role.setBounds(122, 232, 139, 19);
		contentPane.add(role);
		
		user.setBounds(122, 265, 139, 19);
		contentPane.add(user);
		
		password.setBounds(122, 299, 139, 19);
		contentPane.add(password);
		
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBounds(30, 416, 231, 30);
		contentPane.add(btnEdit);
		
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(30, 496, 231, 30);
		contentPane.add(btnDelete);
		
		scrollPane.setBounds(295, 186, 377, 300);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"User ID","Role","UserName","Password","Phone"};
		final Object[] row = new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(30, 376, 231, 30);
		contentPane.add(btnAdd);
		
		btnback.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnback.setBounds(0, 0, 71, 41);
		contentPane.add(btnback);
		
		JLabel phonenum = new JLabel("Phone:");
		phonenum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phonenum.setBounds(30, 328, 87, 24);
		contentPane.add(phonenum);
		
		phone.setBounds(122, 333, 139, 19);
		contentPane.add(phone);
		
		CloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		CloseButton.setForeground(Color.BLACK);
		CloseButton.setFont(new Font("Arial Black", Font.BOLD, 16));
		CloseButton.setBounds(620, 0, 80, 41);
		contentPane.add(CloseButton);
		
		btnsClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnsClear.setBounds(30, 456, 231, 30);
		contentPane.add(btnsClear);
		
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExport.setBounds(295, 496, 377, 30);
		contentPane.add(btnExport);
		
		this.add(userpanel);
	
	}
	
	public String getUserID() {
		return userid.getText();
	}
	public String getrole() {
		return role.getText();
	}
	public String getUser() {
		return user.getText();
	}
	public String getPass() {
		return password.getText();
	}
	public String getPhone() {
		return phone.getText();
	}
	public Object[] getRow() {
		return row;
	}
	void addAddListener(ActionListener listenForAdd) {
		btnAdd.addActionListener(listenForAdd);
	}
	void addEditListener(ActionListener listerForEdit) {
		btnEdit.addActionListener(listerForEdit);
	}
	void addDeleteListener(ActionListener listenForDel) {
		btnDelete.addActionListener(listenForDel);
	}
	void addBackListener(MouseListener listenForBack) {
		btnback.addMouseListener(listenForBack);
	}
	void addCloseListener(MouseListener listenDorClose) {
		CloseButton.addMouseListener(listenDorClose);
	}
	void addClearListener(ActionListener listenForClear) {
		btnsClear.addActionListener(listenForClear);
	}
	void addExportListener(ActionListener listenForExport) {
		btnExport.addActionListener(listenForExport);
	}
	void addTableListener(MouseListener listenForTable) {
		table.addMouseListener(listenForTable);
	}
	int displayValidation(String Message1, String Message2) {
		return JOptionPane.showConfirmDialog(null, Message1, Message2, JOptionPane.YES_NO_OPTION);
		
	}
	void displayMessage(String Message) {
		JOptionPane.showMessageDialog(null, Message);
	}

	

}