package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManagementDAO;
import model.EmployeeBean;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// パラメータをGetして、Postへ流す
		doPost(request, response);
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
		String name = request.getParameter("name");
		String name_hiragana = request.getParameter("name_hiragana");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		String mail_address = request.getParameter("mail_address");
		String telephone_number = request.getParameter("telephone_number");
		String s_company_info_id = request.getParameter("company_info_id");
		String business_manager = request.getParameter("business_manager");
		String department = request.getParameter("department");
		String commissioning_status = request.getParameter("commissioning_status");
		String created_id = request.getParameter("created_id");
		String modified_id = request.getParameter("modified_id");
		String s_employee_info_id = request.getParameter("employee_info_id");
		String enter_date = request.getParameter("enter_date");
		String retire_date = request.getParameter("retire_date");
		String status = request.getParameter("status");

		// 変数を初期化
		String msg = null;
		int employee_id = 0;
		int company_info_id = 0;
		int employee_info_id = 0;

		// int に変換
		try {
			company_info_id = Integer.parseInt(s_company_info_id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			employee_info_id = Integer.parseInt(s_employee_info_id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		/*
		 * 詳細画面
		 * list.jsp 詳細ボタン押下
		 */
		if (request.getParameter("detailData") != null) {

			// JavaBeansの初期化
			EmployeeBean emp = new EmployeeBean(request);
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("/detail.jsp").forward(request, response);
		}

		/*
		 * 登録/更新画面
		 * 登録：register.jsp 登録ボタン押下
		 * 更新：detail.jsp	 更新ボタン押下
		 */
		if (request.getParameter("addData") != null) {				// 登録
			dao.addData(employee_id, name, name_hiragana, birthday, sex, mail_address, telephone_number, company_info_id, business_manager,
					department, commissioning_status, created_id, modified_id, employee_info_id, enter_date, retire_date, status);
			msg = "登録しました";
		} else if (request.getParameter("updateData") != null) {	// 更新
			try {
				employee_id = Integer.parseInt(s_employee_id);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("INT変換ERROR");
			}
			dao.updateData(employee_id, name, name_hiragana, birthday, sex, mail_address, telephone_number, company_info_id, business_manager,
					department, commissioning_status, created_id, modified_id, employee_info_id, enter_date, retire_date, status);
			msg = "更新しました";
		}
		// msgをセットして、一覧画面へ転送
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/ManagementServlet").forward(request, response);
	}

}
