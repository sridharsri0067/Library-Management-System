import java.time.LocalDate;
import java.time.LocalTime;

public class Book {

	private int bookId;
	private String bookName;
	private String bookAuthor;
	private double bookPrice;
	private LocalDate date;
	private LocalTime time;

	public Book() {
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Book(int bookId, String bookName, String bookAuthor, double bookPrice, LocalDate date, LocalTime time) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.date = date;
		this.time = time;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		System.out.println("Book Id :: "+ bookId );
		System.out.println("Book name :: "+ bookName);
		System.out.println("Book Author :: "+ bookAuthor);
		System.out.println("Book Price :: "+ bookPrice);
		System.out.println("Book added date :: "+ date);
		System.out.println("Book added time :: "+ time);
		System.out.println("_____________________________");
		return"" ;
	}

}