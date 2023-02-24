package Model;

public abstract class InfoDocument {
		public String documentCode;
		public String publisherName;
		public int issueNumber;
		public String getDocumentCode() {
			return documentCode;
		}
		public void setDocumentCode(String documentCode) {
			this.documentCode = documentCode;
		}
		public String getPublisherName() {
			return publisherName;
		}
		public void setPublisherName(String publisherName) {
			this.publisherName = publisherName;
		}
		public int getIssueNumber() {
			return issueNumber;
		}
		public void setIssueNumber(int issueNumber) {
			this.issueNumber = issueNumber;
		}
		@Override
		public String toString() {
			return "InfoDocument [documentCode=" + documentCode + ", publisherName=" + publisherName + ", issueNumber="
					+ issueNumber + "]";
		}
		public InfoDocument() {
		}
		public InfoDocument(String documentCode, String publisherName, int issueNumber) {
			this.documentCode = documentCode;
			this.publisherName = publisherName;
			this.issueNumber = issueNumber;
		}
		
		
		
}
