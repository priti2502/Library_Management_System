package jdbc_library;

import java.util.Scanner;

public class UserController {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter your choice:\n1.SignUp\n2.Login\n3.Exit");
		UserCRUD crud = new UserCRUD();
		User user = new User();
		int choice = scanner.nextInt();
		switch (choice)
		{
		case 1: 
		{
			System.out.println("Enter the id");
			int userid = scanner.nextInt();
		

			System.out.println("Enter the name");
			String name = scanner.next();
			
			System.out.println("Enter the address");
			String address=scanner.next();
			
			System.out.println("Enter the phone");
			long phone = scanner.nextLong();

			System.out.println("Enter the email");
			String email = scanner.next();

			System.out.println("Enter the password");
			String password = scanner.next();

			user.setUserId(userid);
			user.setName(name);
			user.setPhone(phone);
			user.setEmail(email);
			user.setPassword(password);
			
			crud.signUpUser(user);

			break;

		}

		case 2:
		{
			System.out.println("Enter the email");
			String email = scanner.next();

			System.out.println("Enter the password");
			String password = scanner.next();
			boolean result = crud.loginUser(email, password);

			if (result) 
			{

				System.out.println("login success");
				System.out.println("Welcome Librarian");
				System.out.println(
						"enter your choice:\n1:Add BOOk\n2:Get BookById\n3.GetAllBooks\n4.GetBookBYName\n5.getBookByGenre\n6.DeleteBookById"
						+ "\n7.UpadteBookBYID\n8.UpdateBookBYGenre\n9.Logout");
				BookCRUD crd = new BookCRUD();
				Book book = new Book();
				int choose = scanner.nextInt();

				switch (choose) {
				case 1: {
					System.out.println("Enter the bookid");
					int bookid = scanner.nextInt();

					System.out.println("Enter the name");
					String name = scanner.next();

					System.out.println("Enter the author");
					String author = scanner.next();

					System.out.println("Enter the price");
					double price = scanner.nextDouble();

					System.out.println("Enter the genre");
					String genre = scanner.next();

					book.setBookId(bookid);
					book.setName(name);
					book.setAuthor(author);
					book.setPrice(price);
					book.setGenre(genre);
					crd.addBook(book);

					break;
				}

				case 2: {
					System.out.println("enter the bookid");
					int bookid = scanner.nextInt();

					crd.getBookById(bookid);
					break;

				}
				case 3: {
					System.out.println("All Available book list");
					crd.getAllBook();
					break;

				}
				case 4: {
					System.out.println("enter the name");
					String name = scanner.next();

					crd.getBookByName(name);
					break;
				}
				case 5: {
					System.out.println("enter the genre");
					String genre = scanner.next();

					crd.getBookByGenre(genre);
					break;
				}
				case 6: {
					System.out.println("Enter the bookId to delete the book");
					int id = scanner.nextInt();
					crd.DeleteBookById(id);
					break;
				}
				case 7: {

					System.out.println("Enter the bookid");
					int bookid = scanner.nextInt();

					System.out.println("Enter the name");
					String name = scanner.next();

					System.out.println("Enter the author");
					String author = scanner.next();

					System.out.println("Enter the price");
					double price = scanner.nextDouble();

					System.out.println("Enter the genre");
					String genre = scanner.next();

					crd.updateBookById(name, author, price, genre,bookid);
					break;
				}
				case 8: {
					System.out.println("Enter the genre");
					String genre = scanner.next();
					System.out.println("Enter the name");
					String name = scanner.next();

					System.out.println("Enter the author");
					String author = scanner.next();

					System.out.println("Enter the price");
					double price = scanner.nextDouble();
					crd.updateBookByGenre(genre, name, author, price);
					break;
				}

				default: {
					System.out.println("Logout");
					break;

				}
				}
			}

			else {
				System.out.println("Invalid details");
			}
           break;
		}
		

		case 3: {
			System.out.println("Exit");
			break;

		}
	}

	}

}
