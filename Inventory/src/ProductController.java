
import java.awt.Color;
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
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ProductController extends CategoryView{
	
	private ProductView theView;
	private ProductModel theModel;
	
	public ProductController(ProductView theView, ProductModel theModel) {
		
		this.theView = theView;
		this.theModel = theModel;
		
		this.theView.addAddListener(new AddListener());;
		this.theView.addEditListener(new EditListener());
		this.theView.addDelListener(new DelListener());
		this.theView.addClearListener(new ClearListener());
		this.theView.addSaveListener(new SaveListener());
		this.theView.addSwitchListener(new SwitchListener());
		this.theView.addMouseListener(new CloseListener());
		this.theView.addMouseListener(new BackListener());
		this.theView.addComboboxListener(new ComboboxListener());
			/*theView.model = new DefaultTableModel();
			Object[] column = {"Product ID","Name","Category","Quantity","Price","Description"};
			final Object[] row = new Object[6];
			theView.model.setColumnIdentifiers(column);
			theView.table.setModel(theView.model);*/
	
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
		e1.printStackTrace();
	}
	}

	
	class AddListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {		
			theView.row[0] = theView.ID.getText();
			theView.row[1] = theView.name.getText();
			//theView.row[2] = theView.comboBox.getSelectedItem();
			theView.row[3] = theView.quantity.getText();
			theView.row[4] = theView.price.getText();
			theView.row[5] = theView.description.getText();
			theView.model.addRow(theView.row);
			
			theView.ID.setText("");
			theView.name.setText("");
			//theView.comboBox.setSelectedItem("");
			theView.quantity.setText("");
			theView.price.setText("");
			theView.description.setText("");
			
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
			theView.model.setValueAt(theView.description.getText(), i, 5);
			
		}
		
	}
	
	class DelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
				int i = theView.table.getSelectedRow();
				theView.model.removeRow(i);
			
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
			theView.description.setText("");
			
		}
		
	
	}
	
	class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			theView.displaysuccesmessage("Successfully Saved!");
			
			String filePath = "C:\\Users\\User\\Desktop\\SISTEMANGMALUPET\\PRODUCT.txt";
			File file = new File(filePath);
			
			try {
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(int i = 0; i < theView.model.getRowCount(); i++) {
					for(int j = 0; j < theView.model.getColumnCount(); j++) { //row
						bw.write(theView.model.getValueAt(i, j).toString()+" "); //column
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

	class SwitchListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TableModel model1 = theView.table.getModel();
			int index[] = theView.table.getSelectedRows();
			
			Object[] row = new Object[6];
			
			//TransactHistoryView th = new TransactHistoryView();
			//DefaultTableModel model2 = (DefaultTableModel)th.table.getModel();
			//ProductView.setVisibility(false);
			
			for(int i = 0; i < index.length; i++) {
				row[0] = model1.getValueAt(index[i], 0);
				row[1] = model1.getValueAt(index[i], 1);
				row[2] = model1.getValueAt(index[i], 2);
				row[3] = model1.getValueAt(index[i], 3);
				row[4] = model1.getValueAt(index[i], 4);
				row[5] = model1.getValueAt(index[i], 5);
				
				
				//model2.addRow(row);
			}
			//th.setVisible(true);
			
		}
	
	}

	class CloseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if (theView.displayValidation( "Are you sure you want to exit?", "Confirmation")) {
				theView.dispose();
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			theView.CloseButton.setForeground(Color.RED);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			theView.btnback.setForeground(Color.BLACK);
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
	class ComboboxListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(theModel.Cfile));
	            Object[] lines = br.lines().toArray();
	            
	            for(int i = 0; i < lines.length; i++){
	                String line = lines[i].toString();
	                theView.comboBox.addItem(line);
	            }
	            } catch (FileNotFoundException ex) {
	            	ex.printStackTrace();
	            
	            
	        }   

			
		}
		
	}
	

}