package act;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.LoginDAO;

public class LoginAction {
	public String execute(HttpServletRequest request) throws Exception {
		try {
			String nickname = request.getParameter("nickName");
			String password = request.getParameter("password");

			LoginDAO rdao = new LoginDAO();
			UserBean userBean = rdao.selectLogin(nickname, password);
			HttpSession session = request.getSession();

			if(userBean != null) {
				session.setAttribute("status", "login");
				session.setAttribute("userInfo", userBean);
			}else {
				session.setAttribute("status", "notLogin");
			}
		} catch (NumberFormatException e) {
			return "数字で入力してください";
		} catch (Exception e) {
			return "例外発生";
		}
		return "/top.jsp";
	}
}
