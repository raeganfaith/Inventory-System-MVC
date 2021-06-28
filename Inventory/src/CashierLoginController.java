
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

	public class CashierLoginController extends JFrame {
		CashierLoginView clv;
		CashierLoginModel clm;
		String Username, Password;
		
		public CashierLoginController(CashierLoginView clv, CashierLoginModel clm) {
			
			this.clv = clv;
			this.clm = clm;	
			this.clv.addLoginListener(new LoginListener());
			this.clv.addCancelListener(new CancelListener());
			this.clv.addCloseListener(new CloseListener());	
			
		}
		class CloseListener implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent e) {
				int response = clv.displayValidation("Are you sure you want to exit?", "Confirmation");
				if (response==JOptionPane.YES_OPTION ) {
					clv.dispose();
				}
				else if (response==JOptionPane.NO_OPTION) {
					clv.setVisible(true);
				}
				else if (response==JOptionPane.CLOSED_OPTION) {
					clv.setVisible(true);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				clv.CloseButton.setForeground(Color.RED);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				clv.CloseButton.setForeground(Color.BLACK);
				
			}
			
		}
		
   class LoginListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			clm.createFolder();
			clm.readFile();
			clm.countLines();
			clm.logic(clv.getUserName(), clv.getUserPass());	
		}
		}
	class CancelListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					DashboardView first = new DashboardView();
					first.setVisible(true);
					clv.dispose();
			}
		}
	
	}
}
	
	
		
	
	
	
	
	
	