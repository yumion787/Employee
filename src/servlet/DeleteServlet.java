package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManagementDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		// パラメータをGetして、Postへ流す
//		doPost(request, response);

		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		// 処理クラスをインスタンス化
		ManagementDAO dao = new ManagementDAO();

		// フォームから送信されるデータを受け取る
		String s_employee_id = request.getParameter("employee_id");

		// 変数を初期化
		String msg = null;
		int employee_id = 0;

		if (s_employee_id != null) {
			employee_id = Integer.parseInt(s_employee_id);
			dao.deleteData(employee_id);
			msg = "削除しました";
		}
		// msgをセットして、result.jspへ転送
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/result.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		// 処理クラスをインスタンス化
		ManagementDAO dao = new ManagementDAO();

		// フォームから送信されるデータを受け取る
		String s_employee_id = request.getParameter("employee_id");

		// 変数を初期化
		String msg = null;
		int employee_id = 0;

		// int に変換
		try {
			employee_id = Integer.parseInt(s_employee_id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		if (request.getParameter("deleteData") != null) {
			dao.deleteData(employee_id);
			msg = "削除しました";
		}
		// msgをセットして、一覧画面へ転送
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/ManagementServlet").forward(request, response);
	}

}
