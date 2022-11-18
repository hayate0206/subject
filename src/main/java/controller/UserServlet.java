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

import act.LoginAction;
import act.RegisterAction;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String status = (String) session.getAttribute("status");

		if (status != null && status.equals("login")) {
			String url = "./TweetServlet";
			response.sendRedirect(url);
		} else {

			String action = request.getParameter("action");
			String jsp;

			if (action != null && action.equals("register")) {
				jsp = "/register.jsp";
			} else {
				jsp = "/login.jsp";
			}
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("userAction");
		String jsp = "";

		if (action.equals("登録")) {
			RegisterAction register = new RegisterAction();
			System.out.println(register);
			try {
				String message = register.execute(request);
				if (message.equals("数字で入力してください") || message.equals("例外発生")) {
					jsp = "/register.jsp";
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("status", "login");
					jsp = "/tweet.jsp";
				}

			} catch (Exception e) {
				e.printStackTrace();
				jsp = "/register.jsp";
			} finally {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
				dispatcher.forward(request, response);

			}
		} else if (action.equals("ログイン")) {
			LoginAction login = new LoginAction();
			try {
				String message = login.execute(request);
				HttpSession session = request.getSession();
				String status = (String) session.getAttribute("status");

				if (status.equals("login")) {
					//リダイレクト
					String url = "TweetServlet";
					response.sendRedirect(url);
					return;
				} else {
					throw new Exception();
					//					jsp = "/login.jsp";
					//					RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
					//					dispatcher.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				jsp = "/login.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
				dispatcher.forward(request, response);
			}
		}
	}

}
