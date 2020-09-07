//package test;
//
//import java.util.List;
//
//import dao.ListDAO2;
//import model.EmployeeBean;
//
//public class ListDAOTest {
//
//	public static void main (String[] args) {
//
//		ListDAO2 listDAO = new ListDAO2();
//		List<EmployeeBean> employeeList = listDAO.findAll();
//
//		for(EmployeeBean employee : employeeList) {
//			System.out.println("・TABLE 社員情報");
//			System.out.println("社員ID：" + employee.getEmployee_id());
//			System.out.println("部門：" + employee.getDepartment());
//			System.out.println("名前：" + employee.getName());
//			System.out.println("ふりがな：" + employee.getName_hiragana());
//			System.out.println("誕生日：" + employee.getBirthday());
//			System.out.println("性別：" + employee.getSex());
//			System.out.println("メールアドレス：" + employee.getMail_address());
//			System.out.println("電話番号：" + employee.getTelephone_number());
//			System.out.println("担当管理営業：" + employee.getBusiness_manager());
//			System.out.println("稼働状況：" + employee.getCommissioning_status());
//			System.out.println("・TABLE 社員状況");
//			System.out.println("入社日：" + employee.getEmployee_info_id());
//			System.out.println("入社日：" + employee.getEnter_date());
//			System.out.println("退職日：" + employee.getRetire_date());
//			System.out.println("ステータス：" + employee.getStatus());
//			System.out.println( );
//		}
//		System.out.println("表示できていればEmployeeDAOは使えるよー");
//
//
//	}
//
//}
