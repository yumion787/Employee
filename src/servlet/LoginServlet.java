package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String login_id = request.getParameter("login_id");
		String password = request.getParameter("password");

		//ログイン処理の実行
		Login login = new Login(login_id, password);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);

		//ログイン処理の成否によって処理を分岐
		if(result) {  //ログイン成功時

			// セッションスコープにログインIDを保存
			HttpSession session = request.getSession(true);
			session.setAttribute("login_id", login_id);

			// フォワード
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ManagementServlet");
			dispatcher.forward(request, response);

		} else {  //ログイン失敗時

			request.setAttribute("msg_error", "IDまたはパスワードが間違っています");
			request.getRequestDispatcher("/login.jsp").forward(request, response);

			//リダイレクト
//			response.sendRedirect("/Employee/LoginServlet");

		}
	}
}
