package Model;

public class Magazine extends InfoDocument {
	public String magazineName;
	public String datePubliction;
	public String getMagazineName() {
		return magazineName;
	}
	public void setMagazineName(String magazineName) {
		this.magazineName = magazineName;
	}
	public String getDatePubliction() {
		return datePubliction;
	}
	public void setDatePubliction(String datePubliction) {
		this.datePubliction = datePubliction;
	}
	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Magazine(String documentCode, String publisherName, int issueNumber, String magazineName, String datePubliction) {
		super(documentCode, publisherName, issueNumber);
		this.magazineName = magazineName;
		this.datePubliction = datePubliction;
	}
	@Override
	public String toString() {
		return "Magazine [documentCode=" + documentCode + ", publisherName=" + publisherName + ", issueNumber="
				+ issueNumber + ", magazineName=" + magazineName + ", datePubliction=" + datePubliction + "]";
	}
	
}
