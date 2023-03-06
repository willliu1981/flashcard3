package idv.kuan.flashcard3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import idv.kuan.flashcard3.core.dao.WordDao;
import idv.kuan.flashcard3.core.model.Word;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		testGet();

	}

	public static void testGet() {
		WordDao dao = new WordDao();
		Word word = dao.get("2");
		System.out.println(word);
	}

	public static void test1() {
		String url = "jdbc:sqlite:C:/java/db/sqlite/flashcard3/fc3.db";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection(url);
			String sql = "insert into word (term,translation)values(?,?)";
			PreparedStatement prepareStatement = connection
					.prepareStatement(sql);
			prepareStatement.setString(1, "tree");
			prepareStatement.setString(2, "樹");

			prepareStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Hello World!");
	}
}
