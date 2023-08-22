import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookLogic {

	Book[] books = new Book[3];
	private int count;

	public int getCount() {
		return count;
	}

	public void addBook(Book book) {
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/dinga", "root", "dinga");
			Statement statement = connection.createStatement() ;
			
			String q = "Insert into books values("+book.getBookId()+""
					+ ",'"+book.getBookName()+"',"
							+ "'"+book.getBookAuthor()+"',"
									+ ""+book.getBookPrice()+")" ;
			
			int res = statement.executeUpdate(q) ;
			System.out.println( res + " is added");
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	public void searchBookById(int bookId) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinga", "root", "dinga");
			String q = "Select * from books where bookId="+bookId ;
			Statement statement = connection.createStatement() ;
			ResultSet rs = statement.executeQuery(q) ;
			boolean flag = true;
			while (rs.next()) {
				System.out.println("Bookl Id :: " + rs.getInt(1));
				System.out.println("Book Name :: " + rs.getString(2));
				System.out.println("Book author :: " + rs.getString(3));
				System.out.println("Book Price :: " + rs.getDouble(4));
				System.out.println("______________________________________");
				flag = false;
			}
			if (flag) {
				System.out.println("No book is available in table with id "+bookId);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
	}
	public void display() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinga", "root", "dinga");
			String q = "Select * from books" ;
			Statement statement = connection.createStatement() ;
			ResultSet rs = statement.executeQuery(q) ;
			boolean flag = true;
			while (rs.next()) {
				System.out.println("Bookl Id :: " + rs.getInt(1));
				System.out.println("Book Name :: " + rs.getString(2));
				System.out.println("Book author :: " + rs.getString(3));
				System.out.println("Book Price :: " + rs.getDouble(4));
				System.out.println("______________________________________");
				flag = false;
			}
			if (flag) {
				System.out.println("No data available in table");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBookById(int bookId) {
		for (int i = 0; i < books.length; i++) {
			if( books[i] != null && books[i].getBookId() == bookId ) {
				books[i] = null ; count-- ;
				System.out.println("Book with id "+ bookId + " is removed from rack no. "+(i+1));return ;
			}
		}
		System.out.println("Book with id "+ bookId + " is not present in library...!" ) ;
	}

}