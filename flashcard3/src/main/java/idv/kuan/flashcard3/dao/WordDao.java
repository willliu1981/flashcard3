package idv.kuan.flashcard3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import idv.kuan.flashcard3.connection.DBConn;
import idv.kuan.flashcard3.model.Word;

public class WordDao implements Dao<Word> {

	@Override
	public void add(Word t) {

	}

	@Override
	public Word get(Object id) {
		String sql = "select * from word where id=?";
		Connection conn = DBConn.getConnection();

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id.toString());
			ResultSet rs = stmt.executeQuery();
			Word word = new Word();
			word.setId(Integer.valueOf(id.toString()));
			word.setTerm(rs.getString("term"));
			word.setTranslation(rs.getString("translation"));
			return word;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void update(Word t, Object o) {

	}

	@Override
	public void delete(Object o) {

	}

}
