import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class AdminLoginModel extends JFrame {
	
	File f = new File("C:\\Users\\mynam\\Desktop\\INVENTORY SYSTEM");
    int ln;
    String Username, Password;
    
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
	}
	void readFile(){
        try {
            FileReader fr = new FileReader(f+ "\\ADMIN.txt");
            System.out.println("file exists!");
        }
        catch (FileNotFoundException ex) {
        	try {
                FileWriter fw = new FileWriter(f+ "\\ADMIN.txt");
                System.out.println("File created");
            } 
        	catch (IOException e) {
                Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    void addData(String user,String password){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+ "\\ADMIN.txt", "rw");
            for(int i = 0; i < ln; i++) {
                raf.readLine();
            }
            if(ln > 0) {
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            }
            raf.writeBytes("Username: " + user + "\r\n");
            raf.writeBytes("Password: " + password);
        } 
        catch (FileNotFoundException e) {
            Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (IOException e) {
            Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    void logic(String user, String password){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+ "\\ADMIN.txt", "rw");
            for(int i = 0; i < ln; i+=3) {
            	System.out.println("count " + i);
         
                String forUser = raf.readLine().substring(10);
                String forPass = raf.readLine().substring(10);
                
                if(user.equals(forUser) & password.equals(forPass)) {
                    JOptionPane.showMessageDialog(null, "Login Successfull!");
                    DashboardView dv = new DashboardView();	
                    dv.setVisible(true);
                    AdminLoginView av = new AdminLoginView();
                    av.setVisible(false);       

                    break;
                }else if(i == (ln-2)){
                    JOptionPane.showMessageDialog(null, "Incorrect username/password");
                    AdminLoginView av = new AdminLoginView();
                    av.setVisible(false);
                    break;
                }
                for(int k = 1; k < 2; k++){
                    raf.readLine();
                }
            }
        } 
        catch (FileNotFoundException e) {
            Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (IOException e) {
            Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
        }
    }      
    void countLines(){
        try {
            ln = 0;
            RandomAccessFile raf = new RandomAccessFile(f+ "\\ADMIN.txt", "rw");
            for(int i = 0; raf.readLine()!= null; i++){
                ln++;
            }
            System.out.println("number of lines:" + ln);
        } 
        catch (FileNotFoundException e) {
            Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (IOException e) {
            Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//----------------Interface---------------
    
	interface ReadWriteSources{
	  void readfile();
	  void addData();
	  void logic();
	 }
	public class InterfaceExample implements ReadWriteSources {
		@Override
		public void readfile() {
			System.out.println("Successfully read the file!");
		}
		@Override
		public void addData() {
			System.out.println("Successfully added data!");		
		}
		@Override
		public void logic() {
			System.out.println("Successfully passed the logic!");
		}		
	}
	
 //-----------------------------------------------  

}
