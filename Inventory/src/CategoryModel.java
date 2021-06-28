
import java.io.File;

public class CategoryModel{	
	String CfilePath = "C:\\Users\\mynam\\Desktop\\PRODUCT\\CATEGORY.txt";
	File Cfile = new File(CfilePath);
	String filePath = "C:\\Users\\mynam\\Desktop\\PRODUCT\\CATEGORY.txt";
	File file = new File(filePath);
	String ID;
	String name;
		
	public CategoryModel() {
		
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
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	

