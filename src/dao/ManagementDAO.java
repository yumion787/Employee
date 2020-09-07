package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.EmployeeBean;

public class ManagementDAO {

	public ArrayList<EmployeeBean> getEmployeeList() {

		// ResultSet を初期化
		ResultSet rs = null;

		// bean を入れるためのリスト
		ArrayList<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();

		// データベース接続をするために DAO をインスタンス化
		EmployeeDAO dao = new EmployeeDAO();

		try {
			// データを取得
			rs = dao.findAll();

			// 取得したデータを employeeList に入れるループ
			while (rs.next()) {
				EmployeeBean emp = new EmployeeBean();

				emp.setEmployee_id(rs.getInt("employee_id"));
//				emp.setEmployee_id(rs.getString("employee_id"));
				emp.setName(rs.getString("name"));
				emp.setName_hiragana(rs.getString("name_hiragana"));
				emp.setBirthday(rs.getString("birthday"));
				emp.setSex(rs.getString("sex"));
				emp.setMail_address(rs.getString("mail_address"));
				emp.setTelephone_number(rs.getString("telephone_number"));
				emp.setCompany_info_id(rs.getInt("company_info_id"));
//				emp.setCompany_info_id(rs.getString("company_info_id"));
				emp.setBusiness_manager(rs.getString("business_manager"));
				emp.setDepartment(rs.getString("department"));
				emp.setCommissioning_status(rs.getString("commissioning_status"));
				emp.setCreated_id(rs.getString("created_id"));
				emp.setModified_id(rs.getString("modified_id"));
				emp.setEmployee_info_id(rs.getInt("employee_info_id"));
//				emp.setEmployee_info_id(rs.getString("employee_info_id"));
				emp.setEnter_date(rs.getString("enter_date"));
				emp.setRetire_date(rs.getString("retire_date"));
				emp.setStatus(rs.getString("status"));

				employeeList.add(emp);
			}

		} catch (SQLException e) {
			 // 例外処理
			e.printStackTrace();
			System.out.println("ManagementDAO SQL error");
		 } finally {
			 // 処理終了時に各接続を解除
			 dao.close();
		 }

		return employeeList;
	}


	/**
	 * items テーブルにアイテムのデータを追加する
	 *
	 * @param employee_id
	 * @param name
	 * @param name_hiragana
	 */
	public void addData(int employee_id ,String name, String name_hiragana, String birthday, String sex, String mail_address, String telephone_number, int company_info_id, String business_manager, String department,
			String commissioning_status, String created_id, String modified_id, int employee_info_id, String enter_date, String retire_date, String status) {
		// データベース接続をするために DAO をインスタンス化
		EmployeeDAO dao = new EmployeeDAO();

		// bean を生成
		EmployeeBean bean = new EmployeeBean();

		bean.setEmployee_id(employee_id);
		bean.setName(name);
		bean.setName_hiragana(name_hiragana);
		bean.setBirthday(birthday);
		bean.setSex(sex);
		bean.setMail_address(mail_address);
		bean.setTelephone_number(telephone_number);
		bean.setCompany_info_id(company_info_id);
		bean.setBusiness_manager(business_manager);
		bean.setDepartment(department);
		bean.setCommissioning_status(commissioning_status);
		bean.setCreated_id(created_id);
		bean.setModified_id(modified_id);
		bean.setEmployee_info_id(employee_info_id);
		bean.setEnter_date(enter_date);
		bean.setRetire_date(retire_date);
		bean.setStatus(status);

		try {
			// bean のデータをもとに情報を変更
			dao.insert(bean);
		} catch (SQLException e) {
			// 例外処理
			e.printStackTrace();
		} finally {
			// データベースから切断
			dao.close();
		}
	}


	public void updateData(int employee_id ,String name, String name_hiragana, String birthday, String sex, String mail_address, String telephone_number, int company_info_id, String business_manager, String department,
			String commissioning_status, String created_id, String modified_id, int employee_info_id, String enter_date, String retire_date, String status) {
		// データベース接続をするために DAO をインスタンス化
		EmployeeDAO dao = new EmployeeDAO();

		// bean を生成
		EmployeeBean bean = new EmployeeBean();

		bean.setEmployee_id(employee_id);
		bean.setName(name);
		bean.setName_hiragana(name_hiragana);
		bean.setBirthday(birthday);
		bean.setSex(sex);
		bean.setMail_address(mail_address);
		bean.setTelephone_number(telephone_number);
		bean.setCompany_info_id(company_info_id);
		bean.setBusiness_manager(business_manager);
		bean.setDepartment(department);
		bean.setCommissioning_status(commissioning_status);
		bean.setCreated_id(created_id);
		bean.setModified_id(modified_id);
		bean.setEmployee_info_id(employee_info_id);
		bean.setEnter_date(enter_date);
		bean.setRetire_date(retire_date);
		bean.setStatus(status);

		try {
			// bean のデータをもとに情報を変更
			dao.update(bean);
		} catch (SQLException e) {
			// 例外処理
			e.printStackTrace();
		} finally {
			// データベースから切断
			dao.close();
		}
	}



}
