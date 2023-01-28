package idv.kuan.flashcard3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		String url = "jdbc:sqlite:C:/java/db/sqlite/flashcard3/fc3.db";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection(url);
			String sql = "insert into word (term,translation)values(?,?)";
			PreparedStatement prepareStatement = connection
					.prepareStatement(sql);
			prepareStatement.setString(1, "apple");
			prepareStatement.setString(2, "蘋果");

			prepareStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Hello World!");

	}
}
