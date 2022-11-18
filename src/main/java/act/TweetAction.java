package act;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.TweetBean;
import dao.TweetDAO;

public class TweetAction extends Action {
	public String execute(HttpServletRequest request) throws Exception {

		String tweet = request.getParameter("tweet");
		TweetDAO tdao = new TweetDAO();
		int result = tdao.insertTweet(tweet, request);
		Integer i = Integer.valueOf(result);
		String j = i.toString();
		return j;
	}

	public String getTweet(HttpServletRequest request) throws Exception {

		String tweet = request.getParameter("tweet");
		String user_id = request.getParameter("user_id");
		int userId = Integer.parseInt(user_id);

		TweetDAO tdao = new TweetDAO();
		TweetBean tweetBean = tdao.selectTweet(tweet, userId);
		HttpSession session = request.getSession();

		if (tweetBean != null) {
			session.setAttribute("tweet", "tweet");
			session.setAttribute("tweetInfo", tweetBean);
		} else {
			session.setAttribute("tweet", "notTweet");
		}
		return "/tweet.jsp";
	}

}
