package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManagementDAO;
import model.EmployeeBean;

/**
 * Servlet implementation class ManagementServlet
 */
@WebServlet("/ManagementServlet")
public class ManagementServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		response.setContentType("text/html; charset=UTF-8");

		if (session == null || session.getAttribute("login_id") == null) {
			System.out.println("ログインnull");
			request.setAttribute("msg_login", "ログインが必要です");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {

		// 処理クラスをインスタンス化
		ManagementDAO dao = new ManagementDAO();

		// すべてのデータを empList として取得
		List<EmployeeBean> empList = dao.getEmployeeList();

		// フォワードの準備
		request.setAttribute("empList", empList);

		// 一覧画面に移動
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
