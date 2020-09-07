package dao;
//package dao;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import model.EmployeeBean;
//
//public class ListDAO2 {
//
//	// DB初期設定
//	private Connection con = null;
//	private PreparedStatement ps = null;
//	private DataSource ds = null;
//	private ResultSet rs = null;
//
//	public List<EmployeeBean> findAll() {
//
//		 List<EmployeeBean> employeeDAO = new ArrayList<>();
//
//		 try {
//			//JDBCドライバを読み込む
//			Class.forName("org.h2.Driver");
//
//			//DBに接続
//			con = DriverManager.getConnection("jdbc:h2:~/employee", "sa", "");
//
//			// sql文の作成準備
//			StringBuffer sql = new StringBuffer();
//
//			sql.append("SELECT employee_id, name, name_hiragana, birthday, sex, mail_address, telephone_number, company_info_id, business_manager, department, commissioning_status, EMPLOYEE_INFO.created_id, EMPLOYEE_INFO.modified_id,"
//					+ "employee_info_id, enter_date, retire_date, status "
//					+ "FROM EMPLOYEE_INFO JOIN EMPLOYEE_STATE ON EMPLOYEE_INFO.EMPLOYEE_ID=EMPLOYEE_INFO_ID WHERE employee_id;");
//
//			// sqlを表示
//			System.out.println(sql);
//
//			// sql実行準備
//			ps = con.prepareStatement(new String(sql));
//
//			// sql実行
//			ps.execute();
//
//			// 実行結果をResultSetクラスに代入
//			rs = ps.executeQuery();
//
//			// 取得データを empList に入れるループ
//			while (rs.next()) {
//				EmployeeBean emp = new EmployeeBean();
//
//				emp.setEmployee_id(rs.getString("employee_id"));
//				emp.setName(rs.getString("name"));
//				emp.setName_hiragana(rs.getString("name_hiragana"));
//				emp.setBirthday(rs.getString("birthday"));
//				emp.setSex(rs.getString("sex"));
//				emp.setMail_address(rs.getString("mail_address"));
//				emp.setTelephone_number(rs.getString("telephone_number"));
//				emp.setCompany_info_id(rs.getString("company_info_id"));
//				emp.setBusiness_manager(rs.getString("business_manager"));
//				emp.setDepartment(rs.getString("department"));
//				emp.setCommissioning_status(rs.getString("commissioning_status"));
//				emp.setCreated_id(rs.getString("created_id"));
//				emp.setModified_id(rs.getString("modified_id"));
//				emp.setEmployee_info_id(rs.getString("employee_info_id"));
//				emp.setEnter_date(rs.getString("enter_date"));
//				emp.setRetire_date(rs.getString("retire_date"));
//				emp.setStatus(rs.getString("status"));
//
//				employeeDAO.add(emp);
//			}
//		 } catch (SQLException e) {
//			 // 例外処理
//			e.printStackTrace();
//			System.out.println("ListDAO2 SQL error");
//		 } catch (ClassNotFoundException ce) {
//			 ce.printStackTrace();
//			 System.out.println("ListDAO2 ClassNotFound error");
//		 } finally {
//			 // DB切断
//			 if(con != null) {
//				try {
//					con.close();
//				} catch(SQLException e) {
//					e.printStackTrace();
//					return null;
//				}
//	 		}
//		 }
//
//		 return employeeDAO;
//	 }
//
//
////	public void insert(EmployeeBean bean) throws SQLException {
////
////		try {
////			//JDBCドライバを読み込む
////			Class.forName("org.h2.Driver");
////
////			//DBに接続
////			con = DriverManager.getConnection("jdbc:h2:~/employee", "sa", "");
////
////			// sql文の作成準備
////			StringBuffer sql = new StringBuffer();
////			sql.append("set FOREIGN_KEY_CHECKS=0;");
////			sql.append("INSERT ALL INTO EMPLOYEE_INFO(employee_id, name, name_hiragana, birthday, sex, mail_address, telephone_number, company_info_id, business_manager, department, commissioning_status, created_id, modified_id) "
////					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
////					+ "INTO EMPLOYEE_STATE(employee_info_id, enter_date, retire_date, status) "
////					+ "values(?, ?, ?, ?);");
////			sql.append("set FOREIGN_KEY_CHECKS=1;");
////
////			// sqlを表示
////			System.out.println(sql);
////
////			// sql実行準備
////			ps = con.prepareStatement(new String(sql));
////			ps.setString(1, bean.getEmployee_id());
////			ps.setString(2, bean.getName());
////			ps.setString(3, bean.getName_hiragana());
////			ps.setString(4, bean.getBirthday());
////			ps.setString(5, bean.getSex());
////			ps.setString(6, bean.getMail_address());
////			ps.setString(7, bean.getTelephone_number());
////			ps.setString(8, bean.getCompany_info_id());
////			ps.setString(9, bean.getBusiness_manager());
////			ps.setString(10, bean.getDepartment());
////			ps.setString(11, bean.getCommissioning_status());
////			ps.setString(12, bean.getCreated_id());
////			ps.setString(13, bean.getModified_id());
////			ps.setString(14, bean.getEmployee_info_id());
////			ps.setString(15, bean.getEnter_date());
////			ps.setString(16, bean.getRetire_date());
////			ps.setString(17, bean.getStatus());
////
////			// sql実行
////			ps.executeUpdate();
////
////		} catch (SQLException e) {
////			 // 例外処理
////			e.printStackTrace();
////			System.out.println("ListDAO2 SQL error");
////		} catch (ClassNotFoundException ce) {
////			ce.printStackTrace();
////			System.out.println("ListDAO2 ClassNotFound error");
////		} finally {
////			 // DB切断
////			 if(con != null) {
////				try {
////					con.close();
////				} catch(SQLException e) {
////					e.printStackTrace();
////				}
////	 		}
////		 }
////
////	}
//
//
////	public void update(EmployeeBean bean) throws SQLException {
////
////		try {
////			//JDBCドライバを読み込む
////			Class.forName("org.h2.Driver");
////
////			//DBに接続
////			con = DriverManager.getConnection("jdbc:h2:~/employee", "sa", "");
////
////			// sql文の作成準備
////			StringBuffer sql = new StringBuffer();
////			sql.append("set FOREIGN_KEY_CHECKS=0;");
////			sql.append("UPDATE EMPLOYEE_INFO SET name=?, name_hiragana=?, birthday=?, sex=?, mail_address=?, telephone_number=?, "
////					+ "company_info_id=?, business_manager=?, department=?, commissioning_status=?, created_id=?, modified_id=? WHERE employee_id=?");
////			sql.append("UPDATE EMPLOYEE_STATE SET enter_date=?, retire_date=?, status=? WHERE employee_info_id=?");
////			sql.append("set FOREIGN_KEY_CHECKS=1;");
////
////			// sqlを表示
////			System.out.println(sql);
////
////			// sql実行準備
////			ps = con.prepareStatement(new String(sql));
////			ps.setString(1, bean.getName());
////			ps.setString(2, bean.getName_hiragana());
////			ps.setString(3, bean.getBirthday());
////			ps.setString(4, bean.getSex());
////			ps.setString(5, bean.getMail_address());
////			ps.setString(6, bean.getTelephone_number());
////			ps.setString(7, bean.getCompany_info_id());
////			ps.setString(8, bean.getBusiness_manager());
////			ps.setString(9, bean.getDepartment());
////			ps.setString(10, bean.getCommissioning_status());
////			ps.setString(11, bean.getCreated_id());
////			ps.setString(12, bean.getModified_id());
////			ps.setString(13, bean.getEmployee_id());
////			ps.setString(14, bean.getEnter_date());
////			ps.setString(15, bean.getRetire_date());
////			ps.setString(16, bean.getStatus());
////			ps.setString(17, bean.getEmployee_info_id());
////
////			// sql実行
////			ps.executeUpdate();
////
////		} catch {
////
////		}
////
////	}
//
//
//}
//
//
//
//
//
//
