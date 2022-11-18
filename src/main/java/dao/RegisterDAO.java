package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO extends Dao {

	PreparedStatement registerInsertStatement;

	public RegisterDAO() throws Exception, SQLException {
		//SQLを保持するPreparedStatementオブジェクトの生成
		String sql = "INSERT INTO user(name,phone,birth_date,password) VALUES(?,?,?,?)";
		registerInsertStatement = getConnection().prepareStatement(sql);
	}

	public int insertRegister(String nickname, int phone, int birth_date, String password) throws SQLException {
		registerInsertStatement.setString(1, nickname);
		registerInsertStatement.setInt(2, phone);
		registerInsertStatement.setInt(3, birth_date);
		registerInsertStatement.setString(4, password);

		int result = registerInsertStatement.executeUpdate();

		return result;
	}
}
