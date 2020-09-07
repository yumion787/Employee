package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeBean;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		// パラメータをGetして、Postへ流す
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");

		// modeの取得
		String mode = request.getParameter("mode");

		// 実行ステータスの宣言
		String msg = "成功しました";

		// JavaBeansの初期化
		EmployeeBean emp = new EmployeeBean(request);

		// 失敗時のステータス
		if (mode == "deleteData") {
			if (emp.deleteData() == false) {
				msg = "失敗しました";
			}
		}

		// msgをセットして、result.jspへ転送
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/result.jsp").forward(request, response);

	}

}
