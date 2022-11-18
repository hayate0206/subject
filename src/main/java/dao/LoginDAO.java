package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserBean;

public class LoginDAO {
	private Connection connection;
	private PreparedStatement loginSelectStatement;

	//java_web_systemデータベースとの接続を行う	//コンストラクター
	public LoginDAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/twitter_demo";
		String user = "root";
		String password = "root";
		connection = DriverManager.getConnection(url, user, password);

		//SQLを保持するPreparedStatementオブジェクトの生成
		String sql = "SELECT * FROM user WHERE name=? AND password=?";
		loginSelectStatement = connection.prepareStatement(sql);
	}
	public UserBean selectLogin (String nickname, String password) throws SQLException{
		loginSelectStatement.setString(1, nickname);
		loginSelectStatement.setString(2, password);

		UserBean bean = null;
		ResultSet rs = loginSelectStatement.executeQuery();

		if(rs.next()) {
			bean = new UserBean();

			int id = rs.getInt("id");
			bean.setId(id);
			String name = rs.getString("name");
			bean.setName(name);
			int phone = rs.getInt("phone");
			bean.setPhone(phone);
			int birth_date = rs.getInt("birth_date");
			bean.setBirth_date(birth_date);
			password = rs.getString("password");
			bean.setPassword(password);
		}
		return bean;
	}
}
