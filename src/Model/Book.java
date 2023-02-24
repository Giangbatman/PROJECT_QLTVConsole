package Model;

public class Book extends InfoDocument {
	public String authorName;
	public int numberPage;
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getNumberPage() {
		return numberPage;
	}
	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String documentCode, String publisherName, int issueNumber, String authorName, int numberPage) {
		super(documentCode, publisherName, issueNumber);
		this.authorName = authorName;
		this.numberPage = numberPage;
	}
	@Override
	public String toString() {
		return "Book [documentCode=" + documentCode + ", publisherName=" + publisherName + ", issueNumber="
				+ issueNumber + ", authorName=" + authorName + ", numberPage=" + numberPage + "]";
	}
	
	
	
	
}
