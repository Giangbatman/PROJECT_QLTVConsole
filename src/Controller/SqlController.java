package Controller;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.ArticleManagement;
import Model.Book;
import Model.Magazine;
import Model.InfoDocument;
public class SqlController {
	private static Connection conn;

	public SqlController() {
		conn = SqlConnection.getConn();
	}

	public ArrayList<Book> showBook() throws SQLException {
		ArrayList<Book> bookList = new ArrayList<>();
		String sql = "select * from BOOK";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Book st = new Book(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getInt(5));
				bookList.add(st);
			}
		} catch (SQLException e) {
		}
		return bookList;
	}
	

	public ArrayList<Magazine> showMagazine() throws SQLException {
		ArrayList<Magazine> magazineList = new ArrayList<>();
		String sql = "select * from MAGAZINE";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Magazine st = new Magazine(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5));
				magazineList.add(st);
			}
		} catch (SQLException e) {
		}
		return magazineList;
	}

	public ArrayList<ArticleManagement> showArticle() throws SQLException {
		ArrayList<ArticleManagement> articleList = new ArrayList<>();
		String sql = "select * from ARTICLE";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ArticleManagement st = new ArticleManagement(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5));
				articleList.add(st);
			}
		} catch (SQLException e) {
		}
		return articleList;
	}	
	public boolean addBook(Book b) {

		String sql = "insert into BOOK values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getDocumentCode());
			ps.setString(2, b.getPublisherName());
			ps.setInt(3, b.getIssueNumber());
			ps.setString(4, b.getAuthorName());
			ps.setInt(5, b.getNumberPage());

			return ps.executeUpdate() > 0;
		} catch (SQLException ex) {
		}
		return false;
	}
	
	public boolean addMagazine(Magazine m) {

		String sql = "insert into MAGAZINE values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getDocumentCode());
			ps.setString(2, m.getPublisherName());
			ps.setInt(3, m.getIssueNumber());
			ps.setString(4, m.getMagazineName());
			ps.setString(5, m.getDatePubliction());

			return ps.executeUpdate() > 0;
		} catch (SQLException ex) {
		}
		return false;
	}
	public boolean addArticle(ArticleManagement a) {

		String sql = "insert into ARTICLE values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getDocumentCode());
			ps.setString(2, a.getPublisherName());
			ps.setInt(3, a.getIssueNumber());
			ps.setString(4, a.getContentArticle());
			ps.setString(5, a.getDatePubliction());

			return ps.executeUpdate() > 0;
		} catch (SQLException ex) {
		}
		return false;
	}
	public ArrayList<Book> findBookById(Book k,String documentCode, int issueNumber) throws Exception {
		/*
		 * co thi tra ve true/ k thi false
		 */
		ArrayList<Book> bookList = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet rSet = null;
		try {
			// cau lenh tim kiem sql
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BOOK WHERE documentCodeB =? and issueNumberB= ? ORDER BY issueNumberB DESC ");
			ps.setString(1,documentCode);
			ps.setInt(2,issueNumber );
			rSet = ps.executeQuery();
			while (rSet.next()) {
				Book st = new Book(rSet.getString(1), rSet.getString(2), rSet.getInt(3), rSet.getString(4),
						rSet.getInt(5));
				bookList.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}
	public ArrayList<Magazine> findMagazineById(Magazine k,String documentCode, String monthPub) throws Exception {
		/*
		 * co thi tra ve true/ k thi false
		 */
		ArrayList<Magazine> magazineList = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet rSet = null;
		try {
			// cau lenh tim kiem sql
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM MAGAZINE WHERE documentCodeM =? and monthPub= ? ORDER BY monthPub DESC ");
			ps.setString(1,documentCode);
			ps.setString(2,monthPub );
			rSet = ps.executeQuery();
			while (rSet.next()) {
				Magazine st = new Magazine(rSet.getString(1), rSet.getString(2), rSet.getInt(3), rSet.getString(4),
						rSet.getString(5));
				magazineList.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return magazineList;
	}
	public ArrayList<ArticleManagement> findArticleById(ArticleManagement k,String documentCode, String datePub) throws Exception {
		/*
		 * co thi tra ve true/ k thi false
		 */
		ArrayList<ArticleManagement> articleList = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet rSet = null;
		try {
			// cau lenh tim kiem sql
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ARTICLE WHERE documentCodeA =? and publicDate= ? ORDER BY publicDate DESC ");
			ps.setString(1,documentCode);
			ps.setString(2,datePub );
			rSet = ps.executeQuery();
			while (rSet.next()) {
				ArticleManagement st = new ArticleManagement(rSet.getString(1), rSet.getString(2), rSet.getInt(3), rSet.getString(4),
						rSet.getString(5));
				articleList.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articleList;
	}

	
	
}