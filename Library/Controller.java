import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
	static {
		System.out.println("Welcome to Dinga Library\n__________________________");
	}
	static BookLogic bookLogic = new BookLogic();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			try {
				System.out.println("Select an Option\n___________________________");
				System.out.println("1)Add Book");
				System.out.println("2)Display Book Details");
				System.out.println("3)Delet Book By Id");
				System.out.println("4)Search Book By Id");
				System.out.println("5)Exit");
				System.out.println("___________________________");
				int choice = sc.nextInt();
				System.out.println("___________________________");
				switch (choice) {
				case 1:
					addBook(sc);
					break;
				case 2:
					display();
					break;
				case 3:
					deleteBookById(sc);
					break;
				case 4:
					searchBookById(sc);
					break;
				case 5:
					flag = false;
					break;
				default:
					System.err.println("Invalid Selection,Select Option from list.");
				}
			} catch (InputMismatchException e) {
				System.err.println("Input Mismatch");
				;
				sc.next();
			}
		}
		System.out.println("Thank you for visiting Dinga Library...");
		sc.close();
	}

	public static void addBook(Scanner sc) {

		System.out.println("Enter Book Id :: ");
		int bookId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Book Name :: ");
		String bookName = sc.nextLine();
		System.out.println("Enter Book Author :: ");
		String bookAuthor = sc.nextLine();
		System.out.println("Enter Book Price :: ");
		double bookPrice = sc.nextDouble();
		Book book = new Book(bookId, bookName, bookAuthor, bookPrice, LocalDate.now(), LocalTime.now().withNano(0));
		bookLogic.addBook(book);

	}

	public static void display() {

		bookLogic.display();
	}

	public static void deleteBookById(Scanner sc) {
		if (isAvailable()) {
			System.out.println("Enter Book Id :: ");
			int bookId = sc.nextInt();
			bookLogic.deleteBookById(bookId);
		}
	}

	public static void searchBookById(Scanner sc) {

		System.out.println("Enter Book Id :: ");
		int bookId = sc.nextInt();
		bookLogic.searchBookById(bookId);

	}

	public static boolean isAvailable() {
		if (bookLogic.getCount() == 0) {
			System.out.println("There are no books in the Library...!");
			return false;
		}
		return true;
	}

	public static boolean isEmpty() {
		if (bookLogic.getCount() == bookLogic.books.length) {
			System.out.println("Library is Full...!");
			return false;
		}
		return true;
	}

}