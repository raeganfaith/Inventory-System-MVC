
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
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

public class CategoryView{
	
	public JTextField ID = new JTextField(10);
	public JTextField name = new JTextField(10);
	private JLabel lblUni = new JLabel("UNI");
	private JLabel lblStore = new JLabel("STORE");
	private JLabel title = new JLabel("Inventory system");
	private JLabel logo = new JLabel("");
	//private JPanel panel = new JPanel();
	private JLabel lblTitle = new JLabel("CATEGORY INVENTORY");
	private JLabel lblCatID = new JLabel("Category ID:");
	private JLabel lblname = new JLabel("Name:");
	private JButton btnAdd = new JButton("ADD");
	private JButton btnSave = new JButton("SAVE");
	private JButton btnClear = new JButton("CLEAR");
	public JLabel CloseButton = new JLabel("CLOSE");
	public JLabel btnback = new JLabel("  BACK");
	private JButton btnDelete = new JButton("DELETE");
	private JButton btnEdit = new JButton("EDIT");
	public JTable table = new JTable();
	private JPanel panel = new JPanel();
	public JPanel prodpanel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	final Object[] row = new Object[2];
	
	DefaultTableModel model;
	
	CategoryView() {	
		this.prodpanel.setBounds(100, 100, 700, 550); //Frame size
		prodpanel = new JPanel();
		prodpanel.setBackground(new Color(51, 153, 153));
		prodpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setprodpanel(prodpanel);
		//prodpanel.setLocation(null);
		prodpanel.setLayout(null);
		
		prodpanel.add(ID, name);
		prodpanel.add(lblUni, lblStore);
		prodpanel.add(title, logo);
		prodpanel.add(lblTitle, lblCatID);
		prodpanel.add(lblname, btnAdd);
		prodpanel.add(btnSave, btnClear);
		prodpanel.add(CloseButton, btnback);
		prodpanel.add(btnDelete, btnEdit);
		
		scrollPane.setBounds(295, 186, 377, 347); 
		prodpanel.add(scrollPane); 
		
		table = new JTable();     
		model = new DefaultTableModel();
		Object[] column = {"Category ID","Name"};
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
		//Image img_logo = new ImageIcon(CategoryView.class.getResource("ress/logoh.png")).getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH);
		//logo.setIcon(new ImageIcon(img_logo));
		prodpanel.add(logo);
		
		
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 132, 700, 10);
		prodpanel.add(panel);
		
		lblTitle.setForeground(SystemColor.menu);
		lblTitle.setFont(new Font("Big John", Font.PLAIN, 20));
		lblTitle.setBounds(229, 152, 279, 24);
		prodpanel.add(lblTitle);
		
		lblCatID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCatID.setBounds(30, 186, 87, 24);
		prodpanel.add(lblCatID);
		
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblname.setBounds(30, 239, 100, 24);
		prodpanel.add(lblname);		
		
		ID.setBounds(122, 186, 139, 29);
		prodpanel.add(ID);
		
		name.setBounds(122, 239, 139, 29);
		prodpanel.add(name);		

		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBounds(30, 340, 231, 41);
		prodpanel.add(btnEdit);
		
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(30, 391, 231, 41);
		prodpanel.add(btnDelete);
	
		CloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		CloseButton.setForeground(Color.BLACK);
		CloseButton.setFont(new Font("Arial Black", Font.BOLD, 16));
		CloseButton.setBounds(620, 0, 80, 41);
		prodpanel.add(CloseButton);

		btnback.setForeground(Color.BLACK);
		btnback.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnback.setBounds(0, 0, 71, 41);
		prodpanel.add(btnback);
				
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClear.setBounds(30, 442, 231, 40);
		prodpanel.add(btnClear);
		
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBounds(30, 492, 231, 41);
		prodpanel.add(btnSave);
				
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(30, 289, 231, 41);
		prodpanel.add(btnAdd);
		
		//this.(prodpanel);
	}

	private void setprodpanel(JPanel prodpanel2) {
			
	}
	public Object[] getRow() {
		return row;
	}	
	public String getID() {
		return ID.getText();
		
	}
	public String getName() {
		return name.getText();
		
	}
	void addAddListener(ActionListener listenForbtnadd) {
		btnAdd.addActionListener(listenForbtnadd);
		
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

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	}
	
	








	