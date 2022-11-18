package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	private Connection connection = null;
	public Dao() throws Exception, SQLException {
		//java_web_systemデータベースとの接続を行う	//コンストラクター
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/twitter_demo";
			String user = "root";
			String password = "root";
			connection = DriverManager.getConnection(url, user, password);
			System.out.println(1111);
	}
	public Connection getConnection() {
		return this.connection;
	}
}
