package act;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

public class RegisterAction extends Action {
	public String execute(HttpServletRequest request) throws Exception {

		try {
			String nickname = request.getParameter("nickName");
			String phone = request.getParameter("phone");
			String birth_date = request.getParameter("birth_date");
			String password = request.getParameter("password");
			int phoneNum = Integer.parseInt(phone);
			int birth_dateNum = Integer.parseInt(birth_date);

			RegisterDAO rdao = new RegisterDAO();
			int result = rdao.insertRegister(nickname, phoneNum, birth_dateNum, password);
			HttpSession session = request.getSession();
				System.out.println(2222);
			if (result == 1) {
				System.out.println(3333);
				session.setAttribute("status", "login");
			} else {
				System.out.println(4444);
				session.setAttribute("status", "notLogin");
			}
		} catch (NumberFormatException e) {
			return "数字で入力してください";
		} catch (Exception e) {
			return "例外発生";
		}

		//		HttpSession session = request.getSession();
		//		session.setAttribute("table_items", item);
		//		if (item.size() == 0) {
		//			session.setAttribute("no_item", "");
		//		}
		return "/top.jsp";
	}
}
