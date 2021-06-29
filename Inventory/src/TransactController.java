
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TransactController extends JFrame {
	private TransactView tv;
	private TransactModel tm;
	
	public TransactController(TransactView tv, TransactModel tm) {
		this.tv = tv;
		this.tm = tm;
		
		this.tv.addMouseListener(new BackListener());;
		this.tv.addSaveListener(new SaveListener());		
		this.tv.addCloseListener(new CloseListener());
		
		try {
			FileReader fr = new FileReader(tm.file);
			BufferedReader br = new BufferedReader(fr);
			
			DefaultTableModel mode = (DefaultTableModel)tv.table.getModel();
			Object[] lines = br.lines().toArray();
			
			for(int i = 0; i < lines.length; i++) {
				String[] rows = lines[i].toString().split(" ");
				tv.model.addRow(rows);
			}	
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		}
	
	class SaveListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			tv.displaysuccesmessage("Successfully Saved!");
			
			String filePath = "C:\\Users\\mynam\\Desktop\\INVENTORY SYSTEM\\TRANSACTHISTORY.txt";
			File file = new File(filePath);
			try {
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(int u = 0; u < tv.model.getRowCount(); u++) {
					for(int j = 0; j < tv.model.getColumnCount(); j++) { //row
						bw.write(tv.model.getValueAt(u, j).toString()+" "); //column
					}
					bw.newLine();
				}
				bw.close();
				fw.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
		}
	}
	class BackListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {		
			DashboardView dv = new DashboardView();	
			dv.setVisible(true);
	        tv.dispose();
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			tv.btnback.setForeground(Color.RED);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			tv.btnback.setForeground(Color.BLACK);
			
		}	
	}
	class CloseListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			int response = tv.displayValidation("Are you sure you want to exit?", "Confirmation");
			if (response==JOptionPane.YES_OPTION ) {
				tv.dispose();
			}
			else if (response==JOptionPane.NO_OPTION) {
				tv.setVisible(true);
			}
			else if (response==JOptionPane.CLOSED_OPTION) {
				tv.setVisible(true);
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
			tv.CloseButton.setForeground(Color.RED);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			tv.CloseButton.setForeground(Color.BLACK);			
		}
		
	}
}