//package servlet;
//
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dao.ListDAO2;
//import model.EmployeeBean;
//
///**
// * Servlet implementation class ListServlet
// */
//@WebServlet("/ListServlet")
//public class ListServlet extends HttpServlet {
//
//	private static final long serialVersionUID = 1L;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ListServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		// 処理クラスをインスタンス化
//		ListDAO2 dao = new ListDAO2();
//
//		// すべてのデータを empList として取得
//		List<EmployeeBean> empList = dao.findAll();
//
//		// フォワードの準備
//		request.setAttribute("empList", empList);
//
//		// 一覧画面に移動
//		request.getRequestDispatcher("/list.jsp").forward(request, response);
//
//
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
