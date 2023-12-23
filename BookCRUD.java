package jdbc_library;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class BookCRUD {
	public Connection getConnection() throws Exception {
		FileReader reader = new FileReader("dbconfig.properties"); // <c> java.io
		Properties properties = new Properties();// <c>java.util
		properties.load(reader);
		Class.forName(properties.getProperty("ClassName1"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));
		return connection;
	}

	public void addBook(Book book) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into book(bookid,name,author,price,genre)values(?,?,?,?,?)");
		preparedStatement.setInt(1, book.getBookid());
		preparedStatement.setString(2, book.getName());
		preparedStatement.setString(3, book.getAuthor());
		preparedStatement.setDouble(4, book.getPrice());
		preparedStatement.setString(5, book.getGenre());
		int result1 = preparedStatement.executeUpdate();
		if (result1 != 0) {
			System.out.println("Book Added");
		} else {
			System.out.println("Book not added");
		}
		connection.close();

	}

	public void getBookById(int bookId) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select*from book where bookid=?");
		preparedStatement.setInt(1, bookId);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("bookid"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("author"));
			System.out.println(rs.getDouble("price"));
			System.out.println(rs.getString("genre"));

		}
		connection.close();

	}

	public void getAllBook() throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select*from book");

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("bookid"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("author"));
			System.out.println(rs.getDouble("price"));
			System.out.println(rs.getString("genre"));

		}
		connection.close();

	}

	public void getBookByName(String name) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select*from book where name=?");
		preparedStatement.setString(1, name);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("bookid"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("author"));
			System.out.println(rs.getDouble("price"));
			System.out.println(rs.getString("genre"));

		}
		connection.close();

	}

	public void getBookByGenre(String genre) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select* from book where genre=?");
		preparedStatement.setString(1, genre);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("bookid"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("author"));
			System.out.println(rs.getDouble("price"));
			System.out.println(rs.getString("genre"));

		}
		connection.close();

	}

public void DeleteBookById(int bookid) throws Exception {
	  Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("delete from book where bookid=?");
	  preparedStatement.setInt(1,bookid);
	  int resultset=preparedStatement.executeUpdate();
	  if(resultset!=0) {
		  System.out.println("deleted");
	  }
	  else {
		  System.out.println("not deleted");
	  }
}

	public void updateBookById( String name, String author, double price, String genre,int bookid) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("update book set name=?,author=?,price=?,genre=? where bookid=?");
		
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, author);
		preparedStatement.setDouble(3, price);
		preparedStatement.setString(4, genre);
		preparedStatement.setInt(5, bookid);

		int resultset = preparedStatement.executeUpdate();
		if (resultset != 0) {
			System.out.println("updated");
		} else {
			System.out.println("not updated");
		}
	}

	public void updateBookByGenre( String genre,String name, String author, double price) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("update book set name=?,author=?,price=? where genre=?");
		
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, author);
		preparedStatement.setDouble(3, price);
		preparedStatement.setString(4, genre);

		int resultset = preparedStatement.executeUpdate();
		if (resultset != 0) {
			System.out.println("updated");
		} else {
			System.out.println("not updated");
		}
	}
}
