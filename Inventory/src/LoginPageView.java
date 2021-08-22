import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
public class LoginPageView extends JFrame {
	
	private Image img_logo2 = new ImageIcon(LoginPageView.class.getResource("ress/logoh.png")).getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
	private Image img_cashier2 = new ImageIcon(LoginPageView.class.getResource("ress/cashier.png")).getImage().getScaledInstance(130, 175, Image.SCALE_SMOOTH);
	private Image img_admin2 = new ImageIcon(LoginPageView.class.getResource("ress/admin.png")).getImage().getScaledInstance(140, 165, Image.SCALE_SMOOTH);
	private JLabel lblUni = new JLabel("UNI");
	private JLabel lblNewLabel = new JLabel("");
	private JLabel lblStore = new JLabel("STORE");
	private JLabel lblNewLabel_1 = new JLabel("Inventory system");
	private JLabel lbladmn = new JLabel("ADMIN");
	private JLabel lbladmin = new JLabel("");
	private JLabel lblNewLabel_2 = new JLabel("LOGIN AS:");
	public JLabel lblCash = new JLabel("CASHIER");
	public JLabel lblCashier = new JLabel("");
	public JPanel panelCashier = new JPanel();
	public JPanel panelAdmin = new JPanel();
	public JPanel prodpanel = new JPanel();
	public JLabel CloseButton = new JLabel("CLOSE");
	
	public static void main(String[] args) {	
	        LoginPageView lv = new LoginPageView();    
	    	lv.setVisible(true);
		}
	
	LoginPageView(){
		setUndecorated(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450); //Frame size
		prodpanel = new JPanel();
		prodpanel.setBackground(new Color(51, 153, 153));
		prodpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(prodpanel);
		setLocationRelativeTo(null);
		prodpanel.setLayout(null);
		
		prodpanel.add(lblUni,lblNewLabel);
		prodpanel.add(lblStore,lblNewLabel_1);
		prodpanel.add(lbladmin,lbladmn);
		prodpanel.add(lbladmin,lblNewLabel_2);
		prodpanel.add(lblCash,lblCashier);
		prodpanel.add(panelCashier,panelAdmin);
		prodpanel.add(CloseButton);
		
		lblUni.setForeground(new Color(245, 245, 245));
		lblUni.setFont(new Font("Big John", Font.PLAIN, 50));
		lblUni.setBounds(280, 50, 124, 69);
		prodpanel.add(lblUni);
			
		lblNewLabel.setBounds(176, 10, 109, 144);
		prodpanel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(img_logo2));
		
		lblStore.setForeground(new Color(0, 51, 51));
		lblStore.setFont(new Font("Big John", Font.PLAIN, 50));
		lblStore.setBounds(373, 43, 209, 82);
		prodpanel.add(lblStore);
		
		lblNewLabel_1.setForeground(new Color(153, 204, 204));
		lblNewLabel_1.setFont(new Font("Big John", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(281, 92, 242, 48);
		prodpanel.add(lblNewLabel_1);
		
		JPanel panelMainLog = new JPanel();
		
		panelMainLog.setBackground(SystemColor.controlHighlight);
		panelMainLog.setBounds(0, 161, 700, 289);
		prodpanel.add(panelMainLog);
		panelMainLog.setLayout(null);
		lbladmn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to Login as Admin?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					AdminLoginView frame = new AdminLoginView();
					AdminLoginModel model = new AdminLoginModel();
					AdminLoginController control = new AdminLoginController(frame, model);
					frame.setVisible(true);
					LoginPageView.this.dispose();
				}}
				@Override
				public void mouseEntered(MouseEvent e) {
					lbladmn.setForeground(Color.GRAY);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lbladmn.setForeground(Color.BLACK);
				}
		});
		lbladmn.setForeground(new Color(0, 51, 51));
		lbladmn.setFont(new Font("Big John", Font.PLAIN, 23));
		lbladmn.setBounds(442, 191, 91, 29);
		panelMainLog.add(lbladmn);

		lbladmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to Login as Admin?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					AdminLoginView frame = new AdminLoginView();
					AdminLoginModel model = new AdminLoginModel();
					AdminLoginController control = new AdminLoginController(frame, model);
					frame.setVisible(true);
					LoginPageView.this.dispose();
				}}
				@Override
				public void mouseEntered(MouseEvent e) {
					lbladmn.setForeground(Color.GRAY);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lbladmn.setForeground(Color.BLACK);
				}
		});
		lbladmin.setBounds(411, 66, 140, 122);
		lbladmin.setIcon(new ImageIcon(img_admin2));
		panelMainLog.add(lbladmin);
		
		lblNewLabel_2.setBounds(293, 23, 113, 24);
		lblNewLabel_2.setForeground(new Color(0, 51, 51));
		lblNewLabel_2.setFont(new Font("Big John", Font.PLAIN, 20));
		panelMainLog.add(lblNewLabel_2);
		
		lblCash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to Login as Cashier?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					CashierLoginView clv = new CashierLoginView();
					CashierLoginModel clm = new CashierLoginModel();
					CashierLoginController clc = new CashierLoginController(clv, clm);
					clv.setVisible(true);
					LoginPageView.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCash.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCash.setForeground(Color.BLACK);
			}
		});
		lblCashier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to Login as Cashier?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					CashierLoginView clv = new CashierLoginView();
					CashierLoginModel clm = new CashierLoginModel();
					CashierLoginController clc = new CashierLoginController(clv, clm);
					clv.setVisible(true);
					LoginPageView.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCash.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCash.setForeground(Color.BLACK);
			}
		});
		lblCashier.setBounds(149, 51, 130, 137);
		lblCashier.setIcon(new ImageIcon(img_cashier2));
		panelMainLog.add(lblCashier);
		
		lblCash.setForeground(new Color(0, 51, 51));
		lblCash.setFont(new Font("Big John", Font.PLAIN, 23));
		lblCash.setBounds(159, 191, 108, 29);
		panelMainLog.add(lblCash);
		
		panelCashier.setBorder(null);
		panelCashier.setBackground(SystemColor.controlHighlight);
		panelCashier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to Login as Cashier?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					CashierLoginView clv = new CashierLoginView();
					CashierLoginModel clm = new CashierLoginModel();
					CashierLoginController clc = new CashierLoginController(clv, clm);
					clv.setVisible(true);
					LoginPageView.this.dispose();
					
				}
			}
		});
		panelCashier.setBounds(145, 66, 140, 156);
		panelMainLog.add(panelCashier);
		
		panelAdmin.setBorder(null);
		panelAdmin.setBackground(SystemColor.controlHighlight);
		panelAdmin.setBounds(421, 57, 130, 171);
		panelMainLog.add(panelAdmin);
		
		CloseButton.setHorizontalAlignment(SwingConstants.CENTER);		
		CloseButton.setForeground(Color.BLACK);
		CloseButton.setFont(new Font("Arial Black", Font.BOLD, 16));
		CloseButton.setBounds(620, 0, 80, 41);
		CloseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					LoginPageView.this.dispose();
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
		prodpanel.add(CloseButton);
		setLocationRelativeTo(null);
	}
	public interface ReadSources{
		void Read();
	}
	public interface WriteSources{
	    void Write();
	}
	public interface CheckData{
	    void  Check();
	}
	public class Checking implements ReadSources, WriteSources, CheckData {
		@Override
		public void Check() {
			System.out.println("Successfully checked data!");
		}

		@Override
		public void Write() {
			System.out.println("Successfully Written the data!");		
		}
		@Override
		public void Read() {
			System.out.println("Successfully read data!");	
		}
	}
	void addCashierListener(MouseListener listenForCashier) {
		panelCashier.addMouseListener(listenForCashier);
	}
	void addCashListener(MouseListener listenForCashier) {
		lblCash.addMouseListener(listenForCashier);
	}
	void addCashiListener(MouseListener listenForCashier) {
		lblCashier.addMouseListener(listenForCashier);
	}
	int displayValidation(String Message1, String Message2) {
		return JOptionPane.showConfirmDialog(null, Message1, Message2, JOptionPane.YES_NO_OPTION);	
	}
	void addCloseListener(MouseListener listenDorClose) {
		CloseButton.addMouseListener(listenDorClose);
	}
}
