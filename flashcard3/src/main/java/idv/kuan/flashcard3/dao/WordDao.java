package idv.kuan.flashcard3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import idv.kuan.flashcard3.connection.DBConn;
import idv.kuan.flashcard3.model.Word;

public class WordDao implements Dao<Word> {

	@Override
	public void add(Word t) {
		Connection conn = DBConn.getConnection();

		String sql = "insert into word (term,phonetic_symbol,translation)values(?,?,?)";
		try {
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, t.getTerm());
			prepareStatement.setString(2, t.getPhoneticSymbol());
			prepareStatement.setString(3, t.getTranslation());

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Word get(Object id) {
		String sql = "select id,term,phonetic_symbol,translation,datetime(created_at, 'localtime') from word where id=?";
		Connection conn = DBConn.getConnection();

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id.toString());
			ResultSet rs = stmt.executeQuery();
			Word word = new Word();
			word.setId(Integer.valueOf(id.toString()));
			word.setTerm(rs.getString("term"));
			word.setPhoneticSymbol(rs.getString("phonetic_symbol"));
			word.setTranslation(rs.getString("translation"));
			return word;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Word getByTerm(String term) {
		String sql = "select id,term,phonetic_symbol,translation,datetime(created_at, 'localtime') from word where term=?";
		Connection conn = DBConn.getConnection();

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, term);
			ResultSet rs = stmt.executeQuery();
			Word word = new Word();
			word.setId(rs.getInt("id"));
			word.setTerm(rs.getString("term"));
			word.setPhoneticSymbol(rs.getString("phonetic_symbol"));
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
