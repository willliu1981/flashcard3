package idv.kuan.flashcard3.core.connection;

import java.sql.Connection;

public class DBFactory {
	public static final String DEFAULT = "default";
	public static final String ANDROID = "android";

	private static String source = DEFAULT;
	private static String commands[];

	public static void config(String provider) {
		config(provider,null);
	}
	
	public static void config(String provider,String ... commands) {
		source = provider;
		DBFactory.commands=commands;
	}

	public static Connection getConnection() {
		switch (source) {
		case DEFAULT:
			return DBConnection.getDefaultDBConnection();
		case ANDROID:
			return DBConnection.getAndroidDBConnection(commands[0]);
		default:
			return null;
		}
	}
}
