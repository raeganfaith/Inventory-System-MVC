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

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ProductController {
	
	private ProductView theView;
	private ProductModel theModel;	
	
	public ProductController( ProductView theView, ProductModel theModel) {
		this.theView = theView;
		this.theModel = theModel;	
		this.theView.addAddListener(new AddListener());
		this.theView.addBackListener(new BackListener());
		this.theView.addClearListener(new ClearListener());
		this.theView.addCloseListener(new CloseListener());
		this.theView.addEditListener(new EditListener());
		this.theView.addSaveListener(new SaveListener());
		this.theView.addDeleteListener(new DeleteListener());
		this.theView.addSwitchListener(new SwitchListener());
		
		try {
			FileReader fr = new FileReader(theModel.ProdFile);
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
	
	class AddListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			theView.row[0] = theView.ID.getText();
			theView.row[1] = theView.name.getText();
			theView.row[2] = theView.comboBox.getSelectedItem();
			theView.row[3] = theView.quantity.getText();
			theView.row[4] = theView.price.getText();
			theView.model.addRow(theView.row);

			theView.ID.setText("");
			theView.name.setText("");
			theView.comboBox.setSelectedItem("");
			theView.quantity.setText("");
			theView.price.setText("");
		}
	}	
	class BackListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			DashboardView dv = new DashboardView();	
			dv.setVisible(true);
			theView.dispose();
		}
		@Override
		public void mousePressed(MouseEvent e) {			
		}
		@Override
		public void mouseReleased(MouseEvent e) {			
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
	class ClearListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			theView.ID.setText("");
			theView.name.setText("");
			theView.comboBox.setSelectedItem("");
			theView.quantity.setText("");
			theView.price.setText("");		
		}
		
	}
	class CloseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int response = theView.Validation("Are you sure you want to exit?", "Confirmation");
			if (response==JOptionPane.YES_OPTION ) {
				ProductView theView = new ProductView();
				ProductModel theModel = new ProductModel();
		        ProductController pc = new ProductController(theView, theModel);    
				theView.dispose();
			}
			else if (response==JOptionPane.NO_OPTION) {
				ProductView theView = new ProductView();
				ProductModel theModel = new ProductModel();
		        ProductController pc = new ProductController(theView, theModel);    
		    	theView.setVisible(true);
			}
			else if (response==JOptionPane.CLOSED_OPTION) {
				ProductView theView = new ProductView();
				ProductModel theModel = new ProductModel();
		        ProductController pc = new ProductController(theView, theModel);    
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
	class EditListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int i = theView.table .getSelectedRow();
			theView.model.setValueAt(theView.ID.getText(), i, 0);
			theView.model.setValueAt(theView.name.getText(), i, 1);
			theView.model.setValueAt(theView.comboBox.getSelectedItem(), i, 2);
			theView.model.setValueAt(theView.quantity.getText(), i, 3);
			theView.model.setValueAt(theView.price.getText(), i, 4);
			
		}
		
	}
	
	class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			theView.theMessage("Successfuly saved!");
			
			try {
				FileWriter fw = new FileWriter(theModel.ProdFile);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(int i = 0; i < theView.model.getRowCount(); i++) {
					for(int j = 0; j < theView.model.getColumnCount(); j++) { //row
						bw.write(theView.model.getValueAt(i, j).toString()+" "); //column
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
		
	}
	
	class DeleteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int i = theView.table.getSelectedRow();
			theView.model.removeRow(i);
		}
		
			
	}
	
	class SwitchListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			TableModel model1 = theView.table.getModel();
			int index[] = theView.table.getSelectedRows();
			
			Object[] row = new Object[6];
			
			 TransactView tv = new TransactView();
             TransactModel tm = new TransactModel();
             TransactController tc = new TransactController(tv, tm);
             tv.setVisible(true);
			
			DefaultTableModel model2 = (DefaultTableModel)tv.table.getModel();
			theView.setVisible(false);
			
			for(int i = 0; i < index.length; i++) {
				row[0] = model1.getValueAt(index[i], 0);
				row[1] = model1.getValueAt(index[i], 1);
				row[2] = model1.getValueAt(index[i], 2);
				row[3] = model1.getValueAt(index[i], 3);
				row[4] = model1.getValueAt(index[i], 4);
				
				
				model2.addRow(row);
			}
			tv.setVisible(true);
			
		}
	
	}
	

}