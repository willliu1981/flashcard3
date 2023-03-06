package idv.kuan.flashcard3.core.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	public static Connection getConnection() {
		String url = "jdbc:sqlite:C:/java/db/sqlite/flashcard3/fc3.db";
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(url);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static DBConn getAndroidDBConnection() {
		
		
		return null;
	}
}


