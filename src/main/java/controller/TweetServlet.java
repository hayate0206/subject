package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import act.TweetAction;
import bean.UserBean;

/**
 * Servlet implementation class TweetServlet
 */
@WebServlet("/TweetServlet")
public class TweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(777777);
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String status = (String) session.getAttribute("status");
		System.out.println(status);
		if (status.equals("login")) {
			UserBean userInfo = (UserBean) session.getAttribute("userInfo");
			String name = userInfo.getName();
			String message = name + "さん、こんにちは！";
			request.setAttribute("message", message);

			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/tweet.jsp");
			rd.forward(request, response);
		} else {
			String url = "./";
			response.sendRedirect(url);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String status = (String) session.getAttribute("status");
		String action = request.getParameter("userAction");
		String jsp = "";
		String message = "";

		if (action.equals("ツイート")) {
			//ツイート実行
			TweetAction tweet = new TweetAction();
			try {
				UserBean userInfo = (UserBean) session.getAttribute("userInfo");
				String name = userInfo.getName();
				message = name + "さん、こんにちは！";
				request.setAttribute("message", message);
				String result = tweet.execute(request);
				ServletContext context = getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/tweet.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			session.invalidate();
			message = "ログアウトしました";
			String url = "./";
			response.sendRedirect(url);
		}
	}

}
