import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DashboardView2 extends JFrame {
	private Image img_logo = new ImageIcon(DashboardView2.class.getResource("ress/logoh.png")).getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
	private Image img_product = new ImageIcon(DashboardView2.class.getResource("ress/PRODUCT.png")).getImage().getScaledInstance(130, 110, Image.SCALE_SMOOTH);
	private Image img_category = new ImageIcon(DashboardView.class.getResource("ress/CATEGORY.png")).getImage().getScaledInstance(130, 110, Image.SCALE_SMOOTH);
	private Image img_transact = new ImageIcon(DashboardView2.class.getResource("ress/TRANSACT.png")).getImage().getScaledInstance(130, 110, Image.SCALE_SMOOTH);
	private Image img_exit = new ImageIcon(DashboardView2.class.getResource("ress/EXIT.png")).getImage().getScaledInstance(130, 110, Image.SCALE_SMOOTH);
	private JPanel contentPane;

	public DashboardView2() {
		setUndecorated(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
				
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(156, 0, 109, 144);
		lblNewLabel.setIcon(new ImageIcon(img_logo));
		contentPane.add(lblNewLabel);
		
		JLabel lblUni = new JLabel("UNI");
		lblUni.setBounds(260, 40, 124, 69);
		lblUni.setForeground(new Color(245, 245, 245));
		lblUni.setFont(new Font("Big John", Font.PLAIN, 50));
		contentPane.add(lblUni);
		
		JLabel lblStore = new JLabel("STORE");
		lblStore.setBounds(353, 33, 209, 82);
		lblStore.setForeground(new Color(0, 51, 51));
		lblStore.setFont(new Font("Big John", Font.PLAIN, 50));
		contentPane.add(lblStore);
		
		JLabel lblNewLabel_1 = new JLabel("Inventory system");
		lblNewLabel_1.setBounds(261, 82, 242, 48);
		lblNewLabel_1.setForeground(new Color(153, 204, 204));
		lblNewLabel_1.setFont(new Font("Big John", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 149, 700, 10);
		panel.setBackground(new Color(220, 220, 220));
		contentPane.add(panel);
		
		JLabel CloseButton = new JLabel("CLOSE");
		CloseButton.setBounds(620, 0, 80, 41);
		CloseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					DashboardView2.this.dispose();
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
		
		JLabel lblProducts = new JLabel(" PRODUCTS");
		lblProducts.setBounds(72, 309, 131, 33);
		lblProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductView theView = new ProductView();
				ProductModel theModel = new ProductModel();
		        ProductController pc = new ProductController(theView, theModel);    
		    	theView.setVisible(true);
				DashboardView2.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblProducts.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblProducts.setForeground(Color.BLACK);
		}});
		lblProducts.setForeground(new Color(0, 51, 51));
		lblProducts.setFont(new Font("Big John", Font.PLAIN, 20));
		contentPane.add(lblProducts);
		
		JPanel PnlProducts = new JPanel();
		PnlProducts.setBounds(62, 181, 141, 131);
		PnlProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductView theView = new ProductView();
				ProductModel theModel = new ProductModel();
		        ProductController pc = new ProductController(theView, theModel);    
		    	theView.setVisible(true);
				DashboardView2.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblProducts.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblProducts.setForeground(Color.BLACK);
			}});
		PnlProducts.setBackground(new Color(51, 153, 153));
		contentPane.add(PnlProducts);
		PnlProducts.setLayout(null);
		
		JLabel lblProduct = new JLabel("");
		lblProduct.setBounds(10, 10, 149, 125);
		lblProduct.setIcon(new ImageIcon(img_product));
		PnlProducts.add(lblProduct);
		
		JLabel lblcat = new JLabel(" CATEGORY");
		lblcat.setBounds(258, 309, 141, 33);
		lblcat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CategoryView cv = new CategoryView();
		    	CategoryModel cm = new CategoryModel();
		    	CategoryController cc = new CategoryController(cv, cm);
		    	cv.setVisible(true);
				DashboardView2.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblcat.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblcat.setForeground(Color.BLACK);
			}});
		lblcat.setForeground(new Color(0, 51, 51));
		lblcat.setFont(new Font("Big John", Font.PLAIN, 20));
		contentPane.add(lblcat);
		
		JPanel PnlCategories = new JPanel();
		PnlCategories.setBounds(248, 181, 141, 131);
		PnlCategories.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CategoryView cv = new CategoryView();
		    	CategoryModel cm = new CategoryModel();
		    	CategoryController cc = new CategoryController(cv, cm);
		    	cv.setVisible(true);
				DashboardView2.this.setVisible(false);			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblcat.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblcat.setForeground(Color.BLACK);
			}});
		PnlCategories.setBackground(new Color(51, 153, 153));
		contentPane.add(PnlCategories);
		PnlCategories.setLayout(null);
		
		JLabel lblcategory = new JLabel("");
		lblcategory.setBounds(10, 10, 163, 125);
		lblcategory.setIcon(new ImageIcon(img_category));
		PnlCategories.add(lblcategory);
		
		JLabel lbltransacthist = new JLabel(" TRANSACT HISTORY");
		lbltransacthist.setBounds(422, 309, 242, 33);
		lbltransacthist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TransactView tv = new TransactView();
		        TransactModel tm = new TransactModel();
		        TransactController tc = new TransactController(tv, tm);
		        tv.setVisible(true);
				DashboardView2.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbltransacthist.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbltransacthist.setForeground(Color.BLACK);
			}});
		lbltransacthist.setForeground(new Color(0, 51, 51));
		lbltransacthist.setFont(new Font("Big John", Font.PLAIN, 20));
		contentPane.add(lbltransacthist);
		
		JPanel PnlTransactionHistory = new JPanel();
		PnlTransactionHistory.setBounds(469, 181, 141, 131);
		PnlTransactionHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TransactView tv = new TransactView();
		        TransactModel tm = new TransactModel();
		        TransactController tc = new TransactController(tv, tm);
		        tv.setVisible(true);
				DashboardView2.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbltransacthist.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbltransacthist.setForeground(Color.BLACK);
			}});
		PnlTransactionHistory.setBackground(new Color(51, 153, 153));
		contentPane.add(PnlTransactionHistory);
		PnlTransactionHistory.setLayout(null);
		
		JLabel lbltransact = new JLabel("");
		lbltransact.setBounds(10, 10,163, 125);
		lbltransact.setIcon(new ImageIcon(img_transact));
		PnlTransactionHistory.add(lbltransact);
		
		JLabel lblexit = new JLabel("EXIT");
		lblexit.setBounds(258, 482, 131, 41);
		lblexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblexit.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblexit.setForeground(Color.BLACK);
			}});
		lblexit.setHorizontalAlignment(SwingConstants.CENTER);
		lblexit.setForeground(new Color(0, 51, 51));
		lblexit.setFont(new Font("Big John", Font.PLAIN, 20));
		contentPane.add(lblexit);
		
		JPanel PnlExit = new JPanel();
		PnlExit.setBounds(248, 352, 163, 125);
		PnlExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to Exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					LoginPageView first = new LoginPageView();
					first.setVisible(true);
					DashboardView2.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblexit.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblexit.setForeground(Color.BLACK);
			}});
		PnlExit.setBackground(new Color(51, 153, 153));
		contentPane.add(PnlExit);
		PnlExit.setLayout(null);
		
		JLabel lblExit = new JLabel("");
		lblExit.setBounds(10, 0, 163, 135);
		lblExit.setIcon(new ImageIcon(img_exit));
		PnlExit.add(lblExit);

	}

}
