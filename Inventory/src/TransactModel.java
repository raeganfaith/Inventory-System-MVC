import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

	public class TransactModel extends JFrame {
		String CfilePath = "C:\\Users\\mynam\\Desktop\\INVENTORY SYSTEM\\TRANSACTHISTORY.txt";
		File Cfile = new File(CfilePath);
		String filePath = "C:\\Users\\mynam\\Desktop\\INVENTORY SYSTEM\\TRANSACTHISTORY.txt";
		File file = new File(filePath);
		
		public TransactModel() {
			
		}
		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}

		public File getFile() {
			return file;
		}		
		public void setFile(File file) {
			this.file = file;
		}
		public String getCfilePath() {
			return CfilePath;
		}
		public void setCfilePath(String cfilePath) {
			CfilePath = cfilePath;
		}
		public File getCfile() {
			return Cfile;
		}
		public void setCfile(File cfile) {
			Cfile = cfile;
		}
		
		
}
