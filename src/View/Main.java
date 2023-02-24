package View;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Magazine;
import Model.Book;
import Model.ArticleManagement;
import Controller.SqlConnection;
import Controller.SqlController;

public class Main {
	public static void main(String[] args)
	{
		ArrayList<Book> bookList;
		ArrayList<Magazine> magazineList;
		ArrayList<ArticleManagement> articleList;
		Connection conn = SqlConnection.getConn();
		SqlController sqlController = new SqlController();
		Scanner sc = new Scanner(System.in);
		String code, publisher, authorName,magazineName,monthPub,contentArt,datePub;
		int issueNumber, numberPage;
		do 
		{
			System.out.println("1. Input your Book: ");
			System.out.println("2. Input your Magazine:");
			System.out.println("3. Input your Article: ");
			System.out.println("4. Output Book Information");
			System.out.println("5. Output Magazine Information");
			System.out.println("6. Output Article Mangage");
			System.out.println("7. Output Book Infor by Id and IssueNumber");
			System.out.println("8. Output Magazine Infor by Id and MonthPublic");
			System.out.println("9. Output Article Manage by Id and Publication Date");
			System.out.println("0. Exit");
			System.out.println("Choose :");
			String myChoice = sc.nextLine();
			switch(myChoice)
			{
			case "1":
				System.out.printf("book code: ");
				code = sc.nextLine();
				System.out.printf("book publisher: ");
				publisher = sc.nextLine();
				System.out.printf("Book issue number: ");
				issueNumber = sc.nextInt();
				sc.nextLine();
				System.out.printf("Book Author Name: ");
				authorName = sc.nextLine();
				System.out.printf("Book numberPage: ");
				numberPage = sc.nextInt();
				System.out.printf(": ");
				String tl = sc.nextLine();
				Book b = new Book();
		        b.setDocumentCode(code);
		        b.setPublisherName(publisher);
		        b.setIssueNumber(issueNumber);
		        b.setAuthorName(authorName);
		        b.setNumberPage(numberPage);
		        
		        if(sqlController.addBook(b)){
		            System.out.println("Add successfull!!");
		        } else{
		        	System.out.println("Add failure!!");
		        }
				break;
			case "2":
				System.out.printf("Magazine code: ");
				code = sc.nextLine();
				System.out.printf("Magazine publisher: ");
				publisher = sc.nextLine();
				System.out.printf("Magazine issue number: ");
				issueNumber = sc.nextInt();
				sc.nextLine();
				System.out.printf("Magazine Name: ");
				magazineName = sc.nextLine();
				System.out.printf("Month publishion: ");
				monthPub = sc.nextLine();
				
				Magazine m = new Magazine();
		        m.setDocumentCode(code);
		        m.setPublisherName(publisher);
		        m.setIssueNumber(issueNumber);
		        m.setMagazineName(magazineName);
		        m.setDatePubliction(monthPub);
		        
		        if(sqlController.addMagazine(m)){
		            System.out.println("Add successfull!!");
		        } else{
		        	System.out.println("Add failure!!");
		        }
				break;
			case "3":
				System.out.printf("Article code: ");
				code = sc.nextLine();
				System.out.printf("Article publisher: ");
				publisher = sc.nextLine();
				System.out.printf("Article issue number: ");
				issueNumber = sc.nextInt();
				sc.nextLine();
				System.out.printf("Content of Article: ");
				contentArt = sc.nextLine();
				System.out.printf("Date public: ");
				datePub = sc.nextLine();
				ArticleManagement a = new ArticleManagement();
		        a.setDocumentCode(code);
		        a.setPublisherName(publisher);
		        a.setIssueNumber(issueNumber);
		        a.setContentArticle(contentArt);;
		        a.setDatePubliction(datePub);;
		        
		        if(sqlController.addArticle(a)){
		            System.out.println("Add successfull!!");
		        } else{
		        	System.out.println("Add failure!!");
		        }
				break;
				
			case "4":
				try {
					bookList = sqlController.showBook();

					System.out.println("=============");
					bookList.forEach(j -> System.out.println(j));

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("No infor!!");
				}

				break;
			case "5":
				try {
					magazineList = sqlController.showMagazine();

					System.out.println("=============");
					magazineList.forEach(j -> System.out.println(j));

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("No infor!!");
				}

				break;
			case "6":
				try {
					articleList = sqlController.showArticle();

					System.out.println("=============");
					articleList.forEach(j ->System.out.println(j));
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("No infor!!");
				}
				break;
			case "7":
			{
				try {
					System.out.printf("Book code: ");
					code = sc.nextLine();
					System.out.printf("Issue Number: ");
					issueNumber = sc.nextInt();
					Book c= new Book();
			        bookList = sqlController.findBookById(c, code, issueNumber);
			        System.out.println("=============");
					bookList.forEach(j ->System.out.println(j));
		        	} 
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("No infor!!");
					}
				break;
			}
			case "8":
			{
				try {
					System.out.printf("Magazine code: ");
					code = sc.nextLine();
					System.out.printf("Month publication: ");
					monthPub = sc.nextLine();
					Magazine c= new Magazine();
			        magazineList = sqlController.findMagazineById(c, code, monthPub);
			        System.out.println("=============");
					magazineList.forEach(j ->System.out.println(j));
		        	} 
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("No infor!!");
					}
				break;
			}
			case "9":
			{
				try {
					System.out.printf("Article code: ");
					code = sc.nextLine();
					System.out.printf("Date publication: ");
					datePub = sc.nextLine();
					ArticleManagement c= new ArticleManagement();
			        articleList = sqlController.findArticleById(c, code, datePub);
			        System.out.println("=============");
					articleList.forEach(j ->System.out.println(j));
		        	} 
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("No infor!!");
					}
				break;
			}
			case "0":
				System.exit(0);
				break;
		}
			
			
		}
		while(true);
	}

}
