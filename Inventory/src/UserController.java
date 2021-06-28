import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserController {
	
	UserView theView;
	UserModel theModel;
	
	public UserController(UserView theView, UserModel theModel) {
		
		this.theView = theView;
		this.theModel = theModel;
		
		this.theView.addAddListener(new AddListener());
		this.theView.addMouseListener(new BackListener());
		this.theView.addCloseListener(new CloseListener());
		this.theView.addDeleteListener(new DeleteListener());
		this.theView.addEditListener(new EditListener());
		this.theView.addClearListener(new ClearListener());
		this.theView.addExportListener(new ExportListener());
		this.theView.addTableListener(new TableListener());
		
		try {
			FileReader fr = new FileReader(theModel.file);
			BufferedReader br = new BufferedReader(fr);
				
			DefaultTableModel mode = (DefaultTableModel)theView.table.getModel();
			Object[] lines = br.lines().toArray();
				
			for(int i = 0; i < lines.length; i++) {
				String[] rows = lines[i].toString().split(" ");
				theView.model.addRow(rows);
			}	
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	class ExportListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			theView.displayMessage("Succesfully saved!");
			
			try {
				FileWriter fw = new FileWriter(theModel.file);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(int i = 0; i < theView.table.getRowCount(); i++) {
					for(int j = 0; j < theView.table.getColumnCount(); j++) { //row
						bw.write(theView.table.getValueAt(i, j).toString()+" "); //column
					}
					bw.newLine();
				}
				bw.close();
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	class AddListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			theView.row[0] = theView.userid.getText();
			theView.row[1] = theView.role.getText();
			theView.row[2] = theView.user.getText();
			theView.row[3] = theView.password.getText();
			theView.row[4] = theView.phone.getText();
			theView.model.addRow(theView.row);

			theView.userid.setText("");
			theView.role.setText("");
			theView.user.setText("");
			theView.password.setText("");
			theView.phone.setText("");
			
		}
		
	}
	
	class BackListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
			theView.btnback.setForeground(Color.RED);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			theView.btnback.setForeground(Color.BLACK);
			
		}
	}
	class CloseListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			int response = theView.displayValidation("Are you sure you want to exit?", "Confirmation");
			if (response==JOptionPane.YES_OPTION ) {
				theView.dispose();
			}
			else if (response==JOptionPane.NO_OPTION) {
				theView.setVisible(true);
			}
			else if (response==JOptionPane.CLOSED_OPTION) {
				theView.setVisible(true);
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
			theView.CloseButton.setForeground(Color.RED);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			theView.CloseButton.setForeground(Color.BLACK);
			
		}
		
	}
	class DeleteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int i = theView.table.getSelectedRow();
			theView.model.removeRow(i);
			
		}
		
	}
	class EditListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int i = theView.table .getSelectedRow();
			theView.model.setValueAt(theView.userid.getText(), i, 0);
			theView.model.setValueAt(theView.role.getText(), i, 1);
			theView.model.setValueAt(theView.user.getText(), i, 2);
			theView.model.setValueAt(theView.password.getText(), i, 3);
			theView.model.setValueAt(theView.phone.getText(), i, 4);
			
		}
		
	}
	
	class ClearListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			theView.userid.setText("");
			theView.role.setText("");
			theView.user.setText("");
			theView.password.setText("");
			theView.phone.setText("");
			
		}
		
	}
	
	class TableListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int i = theView.table.getSelectedRow();
			theView.userid.setText(theView.model.getValueAt(i, 0).toString());
			theView.role.setText(theView.model.getValueAt(i, 0).toString());
			theView.user.setText(theView.model.getValueAt(i, 0).toString());
			theView.password.setText(theView.model.getValueAt(i, 0).toString());
			theView.phone.setText(theView.model.getValueAt(i, 0).toString());
			
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
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public void setVisible(boolean b) {
	
	}

}
