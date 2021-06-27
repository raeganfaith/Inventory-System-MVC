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
	
	//private Image img_logo = new ImageIcon(ProductView.class.getResource("ress/logoh.png")).getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH);
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
	private JPanel contentPane = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel = new JPanel();
	public static JComboBox<String> comboBox;
	private JButton btnadd = new JButton("ADD");
	private JButton btnEdit = new JButton("EDIT");
	private JButton btnDelete = new JButton("DELETE");
	private JButton btnClear = new JButton("CLEAR");
	private JButton btnSave = new JButton("SAVE");
	private JButton btnSwitch = new JButton("SWITCH");
	final Object[] row = new Object[5];
	
	DefaultComboBoxModel combo;
	DefaultTableModel model;
	
	ProductView() {
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
		
		lblProdID.setBounds(31, 186, 87, 24);
		lblProdID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblProdID);
		
		lblname.setBounds(31, 220, 100, 24);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblname);
		
		ID.setBounds(123, 191, 139, 19);
		contentPane.add(ID);
		ID.setColumns(10);
		
		lblcat.setBounds(31, 253, 87, 24);
		lblcat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblcat);
		
		lblstock.setBounds(31, 287, 87, 24);
		lblstock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblstock);
		
		lblprice.setBounds(31, 321, 87, 24);
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblprice);
		
		lbldesc.setBounds(31, 355, 87, 24);
		lbldesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lbldesc);
		
		name.setBounds(123, 225, 139, 19);
		name.setColumns(10);
		contentPane.add(name);
		

		quantity.setBounds(123, 292, 139, 19);
		quantity.setColumns(10);
		contentPane.add(quantity);
		

		price.setBounds(123, 326, 139, 19);
		price.setColumns(10);
		contentPane.add(price);
		
		description.setBounds(123, 360, 139, 38);
		description.setColumns(10);
		contentPane.add(description);
		
		comboBox = new JComboBox();
		combo = new DefaultComboBoxModel();
		comboBox.setBounds(123, 257, 138, 21);
		contentPane.add(comboBox);
		fillComboFromTxtFile();
		
		scrollPane.setBounds(295, 186, 377, 292);
		contentPane.add(scrollPane);
		
		model = new DefaultTableModel();
		Object[] column = {"Product ID","Name","Category","Quantity","Price","Description"};
		final Object[] row = new Object[6];
		//Object[] row = new Object [0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		String filePath = "C:\\Users\\mynam\\Desktop\\PRODUCT\\PRODUCTS.txt";
		File file = new File(filePath);
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			DefaultTableModel mode = (DefaultTableModel)table.getModel();
			Object[] lines = br.lines().toArray();
			
			for(int i = 0; i < lines.length; i++) {
				String[] rows = lines[i].toString().split(" ");
				model.addRow(rows);
			}	
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBounds(31, 408, 231, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = ID.getText();
				row[1] = name.getText();
				row[2] = comboBox.getSelectedItem();
				row[3] = quantity.getText();
				row[4] = price.getText();
				row[5] = description.getText();
				model.addRow(row);

				ID.setText("");
				name.setText("");
				comboBox.setSelectedItem("");
				quantity.setText("");
				price.setText("");
				description.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setBounds(31, 448, 231, 30);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table .getSelectedRow();
				model.setValueAt(ID.getText(), i, 0);
				model.setValueAt(name.getText(), i, 1);
				model.setValueAt(comboBox.getSelectedItem(), i, 2);
				model.setValueAt(quantity.getText(), i, 3);
				model.setValueAt(price.getText(), i, 4);
				model.setValueAt(description.getText(), i, 5);
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(31, 488, 100, 30);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnDelete);
		
		//----------CLOSE BUTTON------------	
		JLabel CloseButton = new JLabel("CLOSE");
		CloseButton.setBounds(620, 0, 80, 41);
		CloseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					ProductView.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				CloseButton.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				CloseButton.setForeground(Color.BLACK);
			}
		});
		CloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		CloseButton.setForeground(Color.BLACK);
		CloseButton.setFont(new Font("Arial Black", Font.BOLD, 16));
		contentPane.add(CloseButton);
		
		JLabel btnback = new JLabel("  BACK");
		btnback.setBounds(0, 0, 71, 41);
		btnback.setForeground(Color.BLACK);
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//DashboardView first = new DashboardView();
				//first.setVisible(true);
				ProductView.this.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnback.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnback.setForeground(Color.BLACK);
			}
		});
		
		btnback.setFont(new Font("Arial Black", Font.PLAIN, 16));
		contentPane.add(btnback);
		
		
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(161, 488, 100, 30);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID.setText("");
				name.setText("");
				comboBox.setSelectedItem("");
				quantity.setText("");
				price.setText("");
				description.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnClear);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(295, 488, 165, 30);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Successfully Saved!");
				String filePath = "C:\\Users\\mynam\\Desktop\\PRODUCT\\PRODUCTS.txt";
				File file = new File(filePath);
				try {
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					
					for(int i = 0; i < model.getRowCount(); i++) {
						for(int j = 0; j < model.getColumnCount(); j++) { //row
							bw.write(model.getValueAt(i, j).toString()+" "); //column
						}
						bw.newLine();
					}
					
					bw.close();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnSave);
		
		JButton btnSwitch = new JButton("VIEW");
		btnSwitch.setBounds(507, 488, 165, 30);
		btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TableModel model1 = table.getModel();
				int index[] = table.getSelectedRows();
				
				Object[] row = new Object[6];
				
				TransactView th = new TransactView();
				DefaultTableModel model2 = (DefaultTableModel)th.table.getModel();
				ProductView.setVisibility(false);
				for(int i = 0; i < index.length; i++) {
					row[0] = model1.getValueAt(index[i], 0);
					row[1] = model1.getValueAt(index[i], 1);
					row[2] = model1.getValueAt(index[i], 2);
					row[3] = model1.getValueAt(index[i], 3);
					row[4] = model1.getValueAt(index[i], 4);
					row[5] = model1.getValueAt(index[i], 5);
					
					
					model2.addRow(row);
				}
				th.setVisible(true);
			}
		});
		btnSwitch.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnSwitch);
	
	}
protected static void setVisibility(boolean b) {
		// TODO Auto-generated method stub
		
	}
public void fillComboFromTxtFile(){
        
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
