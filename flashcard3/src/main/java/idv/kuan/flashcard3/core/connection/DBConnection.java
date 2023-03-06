package idv.kuan.flashcard3.core.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBConnection {
	private static DBConnection defaultDBConnection = new DBConnection() {
		@Override
		public Connection getConnection(String command) {
			String url = "jdbc:sqlite:C:/java/db/sqlite/flashcard3/fc3.db";
			try {
				Class.forName("org.sqlite.JDBC");
				return DriverManager.getConnection(url);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return null;
		}
	};

	private static DBConnection androidDBConnection = new DBConnection() {
		@Override
		public Connection getConnection(String command) {
			String url = "jdbc:sqldroid:" + "/data/data/" + command
					+ "/databases/fc3.db";
			try {
				Class.forName("org.sqldroid.SQLDroidDriver");
				return DriverManager.getConnection(url);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return null;
		}
	};

	public abstract Connection getConnection(String command);

	public static Connection getAndroidDBConnection(String command) {
		return androidDBConnection.getConnection(command);
	}

	public static Connection getDefaultDBConnection() {
		return defaultDBConnection.getConnection(null);
	}
}
