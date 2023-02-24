package Model;

public class ArticleManagement extends InfoDocument {
	public String contentArticle;
	public String datePubliction;
	public String getContentArticle() {
		return contentArticle;
	}
	public void setContentArticle(String contentArticle) {
		this.contentArticle = contentArticle;
	}
	public String getDatePubliction() {
		return datePubliction;
	}
	public void setDatePubliction(String datePubliction) {
		this.datePubliction = datePubliction;
	}
	public ArticleManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArticleManagement(String documentCode, String publisherName, int issueNumber, String contentArticle, String datePubliction) {
		super(documentCode, publisherName, issueNumber);
		this.contentArticle = contentArticle;
		this.datePubliction = datePubliction;
	}
	@Override
	public String toString() {
		return "ArticleManagement [documentCode=" + documentCode + ", publisherName=" + publisherName + ", issueNumber="
				+ issueNumber + ", contentArticle=" + contentArticle + ", datePubliction=" + datePubliction + "]";
	}
	
}
