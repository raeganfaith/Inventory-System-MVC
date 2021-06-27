import java.io.File;


public class ProductModel {
	String CfilePath = "C:\\\\Users\\\\mynam\\\\Desktop\\\\PRODUCT\\\\PRODUCTS.txt";
	File Cfile = new File(CfilePath);
	String filePath = "C:\\\\Users\\\\mynam\\\\Desktop\\\\PRODUCT\\\\PRODUCTS.txt";
	File file = new File(filePath);
	String ID;
	String name;
	String quantity;
	String price;
	String description;

	public ProductModel() {
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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