import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ProductModel {
	
	public String ProdFile = "C:\\Users\\mynam\\Desktop\\INVENTORY SYSTEM\\PRODUCTS.txt";
	public String infoFile = "C:C:\\Users\\mynam\\Desktop\\INVENTORY SYSTEM\\info.txt";
	private String ID, name, quantity, price, description;
	private Object[] row = new Object[5];

	public String getID() {
		return ID;
	}

	public Object[] getRow() {
		return row;
	}

	public String getProdFile() {
		return ProdFile;
	}

	public void setProdFile(String prodFile) {
		ProdFile = prodFile;
	}

	public String getInfoFile() {
		return infoFile;
	}

	public void setInfoFile(String infoFile) {
		this.infoFile = infoFile;
	}

	public void setRow(Object[] row) {
		this.row = row;
	}

	public String getFilePath() {
		return ProdFile;
	}

	public void setFilePath(String filePath) {
		this.ProdFile = filePath;
	}

	public String getCfilePath() {
		return infoFile;
	}

	public void setCfilePath(String cfilePath) {
		infoFile = cfilePath;
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

}