package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.TweetBean;
import bean.UserBean;

public class TweetDAO extends Dao {

	//SELECT文実行処理
	private PreparedStatement tweetInsertStatement;
	private PreparedStatement tweetSelectStatement;

	//java_web_systemデータベースとの接続を行う	//コンストラクター
	public TweetDAO() throws Exception, SQLException {
		String sql = "INSERT INTO tweet(tweet,user_id) VALUES(?,?)";
		tweetInsertStatement = getConnection().prepareStatement(sql);

		String sql1 = "SELECT * FROM tweet WHERE tweet=? AND user_id=?";
		tweetSelectStatement = getConnection().prepareStatement(sql1);
	}

	public int insertTweet(String tweet, HttpServletRequest request) throws SQLException {
		tweetInsertStatement.setString(1, tweet);
		HttpSession session = request.getSession();
		UserBean userInfo = (UserBean) session.getAttribute("userInfo");
		int userId = userInfo.getId();
		tweetInsertStatement.setInt(2, userId);

		int result = tweetInsertStatement.executeUpdate();

		return result;
	}

	public TweetBean selectTweet(String tweet, int user_id) throws SQLException {
		tweetSelectStatement.setString(1, tweet);
		tweetSelectStatement.setInt(2, user_id);

		TweetBean bean = null;
		ResultSet rs = tweetSelectStatement.executeQuery();
		System.out.println("");
		System.out.println(tweet);
		if (rs.next()) {
			bean = new TweetBean();

			tweet = rs.getString("tweet");
			bean.setTweet(tweet);
			int userId = rs.getInt("user_id");
			bean.setUser_id(userId);
		}
		return bean;
	}

}
