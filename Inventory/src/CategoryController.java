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

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CategoryController extends CategoryView{
		private CategoryView cv;
		private CategoryModel cm;
		
		public CategoryController (CategoryView cv, CategoryModel cm) {
			this.cv = cv;
			this.cm = cm;
			
			this.cv.addAddListener(new AddListener());;
			this.cv.addMouseListener(new BackListener());
			this.cv.addEditListener(new EditListener());
			this.cv.addDelListener(new DelListener());
			this.cv.addClearListener(new ClearListener());
			this.cv.addSaveListener(new SaveListener());		
			this.cv.addCloseListener(new CloseListener());	
			try {
				FileReader fr = new FileReader(cm.file);
				BufferedReader br = new BufferedReader(fr);
				
				DefaultTableModel mode = (DefaultTableModel)cv.table.getModel();
				Object[] lines = br.lines().toArray();
				
				for(int i = 0; i < lines.length; i++) {
					String[] rows = lines[i].toString().split(" ");
					cv.model.addRow(rows);
				}	
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			}
		class AddListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {		
				cv.row[0] = cv.ID.getText();
				cv.row[1] = cv.name.getText();
				cv.model.addRow(cv.row);
				
				cv.ID.setText("");
				cv.name.setText("");			
			}
		}
		class EditListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = cv.table .getSelectedRow();
				cv.model.setValueAt(cv.ID.getText(), i, 0);
				cv.model.setValueAt(cv.name.getText(), i, 1);			
			}
		}
		class DelListener implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent e) {
						int c = cv.table.getSelectedRow();
						cv.model.removeRow(c);	
				}
		
		}
		class ClearListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				cv.ID.setText("");
				cv.name.setText("");	
			}
		}
		class SaveListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				cv.displaysuccesmessage("Successfully Saved!");
				
				String filePath = "C:\\\\Users\\\\mynam\\\\Desktop\\\\PRODUCT\\\\CATEGORY.txt";
				File file = new File(filePath);
				
				try {
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					
					for(int u = 0; u < cv.model.getRowCount(); u++) {
						for(int j = 0; j < cv.model.getColumnCount(); j++) { //row
							bw.write(cv.model.getValueAt(u, j).toString()+" "); //column
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
				cv.dispose();
			}
			@Override
			public void mousePressed(MouseEvent e) {	
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				cv.btnback.setForeground(Color.RED);				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cv.btnback.setForeground(Color.BLACK);				
			}
		}
		class CloseListener implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent e) {
				int response = cv.displayValidation("Are you sure you want to exit?", "Confirmation");
				if (response==JOptionPane.YES_OPTION ) {
					cv.dispose();
				}
				else if (response==JOptionPane.NO_OPTION) {
					cv.setVisible(true);
				}
				else if (response==JOptionPane.CLOSED_OPTION) {
					cv.setVisible(true);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
	
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				cv.CloseButton.setForeground(Color.RED);				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cv.CloseButton.setForeground(Color.BLACK);
				
			}
			
		}
	}
		
		
		
	


	










