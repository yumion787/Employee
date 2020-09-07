package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.EmployeeBean;

public class EmployeeDAO {

	// DB初期設定
	private Connection con = null;
	private PreparedStatement ps = null;
	private DataSource ds = null;
	private ResultSet rs = null;

	/**
	 * employee_info & employee_state テーブルのデータを取得
	 *
	 * @return rs
	 * @throws SQLException
	 */
	public ResultSet findAll() throws SQLException {

		try {

			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//DBに接続
			con = DriverManager.getConnection("jdbc:h2:~/employee", "sa", "");

			// SQL文の作成準備
			StringBuffer sql = new StringBuffer();

			// SQL文の作成
			sql.append("SELECT employee_id, name, name_hiragana, birthday, sex, mail_address, telephone_number, company_info_id, business_manager, department, commissioning_status, EMPLOYEE_INFO.created_id, EMPLOYEE_INFO.modified_id,"
					+ "employee_info_id, enter_date, retire_date, status "
					+ "FROM EMPLOYEE_INFO JOIN EMPLOYEE_STATE ON EMPLOYEE_INFO.EMPLOYEE_ID=EMPLOYEE_INFO_ID WHERE employee_id ORDER BY employee_id");

			// SQLを表示
			System.out.println(sql);

			// SQL実行準備
			ps = con.prepareStatement(new String(sql));

			// SQL実行
			ps.execute();

			// 実行結果を代入
			rs = ps.executeQuery();

		} catch (ClassNotFoundException ce) {
			// JDBCドライバが見つからなかったときの処理
			ce.printStackTrace();
		}

		return rs;
	}


//	public ResultSet findOne() throws SQLException {
//
//		try {
//
//			//JDBCドライバを読み込む
//			Class.forName("org.h2.Driver");
//
//			//DBに接続
//			con = DriverManager.getConnection("jdbc:h2:~/employee", "sa", "");
//
//			// SQL文の作成準備
//			StringBuffer sql = new StringBuffer();
//
//			// SQL文の作成
//			sql.append("SELECT employee_id, name, name_hiragana, birthday, sex, mail_address, telephone_number, company_info_id, business_manager, department, commissioning_status, EMPLOYEE_INFO.created_id, EMPLOYEE_INFO.modified_id,"
//					+ "employee_info_id, enter_date, retire_date, status "
//					+ "FROM EMPLOYEE_INFO JOIN EMPLOYEE_STATE ON EMPLOYEE_INFO.EMPLOYEE_ID=EMPLOYEE_INFO_ID WHERE employee_id");
//
//			// SQLを表示
//			System.out.println(sql);
//
//			// SQL実行準備
//			ps = con.prepareStatement(new String(sql));
//
//			// SQL実行
//			ps.execute();
//
//			// 実行結果を代入
//			rs = ps.executeQuery();
//
//		} catch (ClassNotFoundException ce) {
//			// JDBCドライバが見つからなかったときの処理
//			ce.printStackTrace();
//		}
//
//		return rs;
//	}


	/**
	 * データベース接続を切断
	 */
	public void close() {

		try {

			// データベースとの接続を切断
			if(con != null) {
				con.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(rs != null) {
				rs.close();
			}

		} catch (SQLException e) {

			// データベースからの切断に失敗した場合
			e.printStackTrace();
		}
	}


	/**
	 * アイテム名と価格、数量を指定してレコードを追加する
	 *
	 * @param EmployeeBean bean
	 * @throws SQLException
	 */
	public void insert(EmployeeBean bean) throws SQLException {

		try {

			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//DBに接続
			con = DriverManager.getConnection("jdbc:h2:~/employee", "sa", "");

			// SQL文の作成準備
			StringBuffer sql = new StringBuffer();
			sql.append("set FOREIGN_KEY_CHECKS=0;");
			sql.append("INSERT INTO EMPLOYEE_INFO(employee_id, name, name_hiragana, birthday, sex, mail_address, telephone_number, company_info_id, business_manager, department, commissioning_status, created_id, modified_id) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			sql.append("INSERT INTO EMPLOYEE_STATE(employee_info_id, enter_date, retire_date, status) "
					+ "values(?, ?, ?, ?);");
			sql.append("set FOREIGN_KEY_CHECKS=1;");

			// sqlを表示
			System.out.println(sql);

			// sql実行準備
			ps = con.prepareStatement(new String(sql));
			ps.setInt(1, bean.getEmployee_id());
//			ps.setString(1, bean.getEmployee_id());
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getName_hiragana());
			ps.setString(4, bean.getBirthday());
			ps.setString(5, bean.getSex());
			ps.setString(6, bean.getMail_address());
			ps.setString(7, bean.getTelephone_number());
			ps.setInt(8, bean.getCompany_info_id());
//			ps.setString(8, bean.getCompany_info_id());
			ps.setString(9, bean.getBusiness_manager());
			ps.setString(10, bean.getDepartment());
			ps.setString(11, bean.getCommissioning_status());
			ps.setString(12, bean.getCreated_id());
			ps.setString(13, bean.getModified_id());
			ps.setInt(14, bean.getEmployee_info_id());
//			ps.setString(14, bean.getEmployee_info_id());
			ps.setString(15, bean.getEnter_date());
			ps.setString(16, bean.getRetire_date());
			ps.setString(17, bean.getStatus());

			// sql実行
			ps.executeUpdate();

		} catch (ClassNotFoundException ce) {
			// JDBCドライバが見つからなかったときの処理
			ce.printStackTrace();
			System.out.println("EmployeeDAO ClassNotFound error");
		}
	}


	/**
	 * アイテム名、価格と数量を指定して、特定のIDのレコードを更新する
	 *
	 * @param bean
	 * @throws SQLException
	 */
	public void update(EmployeeBean bean) throws SQLException {

		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//DBに接続
			con = DriverManager.getConnection("jdbc:h2:~/employee", "sa", "");

			// SQL文の作成準備
			StringBuffer sql = new StringBuffer();
			sql.append("set FOREIGN_KEY_CHECKS=0;");
			sql.append("UPDATE EMPLOYEE_INFO SET name=?, name_hiragana=?, birthday=?, sex=?, mail_address=?, telephone_number=?, "
					+ "company_info_id=?, business_manager=?, department=?, commissioning_status=?, created_id=?, modified_id=? WHERE employee_id=? ;");
			sql.append("UPDATE EMPLOYEE_STATE SET enter_date=?, retire_date=?, status=? WHERE employee_info_id=? ;");
			sql.append("set FOREIGN_KEY_CHECKS=1;");

			// sqlを表示
			System.out.println(sql);

			// sql実行準備
			ps = con.prepareStatement(new String(sql));
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getName_hiragana());
			ps.setString(3, bean.getBirthday());
			ps.setString(4, bean.getSex());
			ps.setString(5, bean.getMail_address());
			ps.setString(6, bean.getTelephone_number());
			ps.setInt(7, bean.getCompany_info_id());
//			ps.setString(7, bean.getCompany_info_id());
			ps.setString(8, bean.getBusiness_manager());
			ps.setString(9, bean.getDepartment());
			ps.setString(10, bean.getCommissioning_status());
			ps.setString(11, bean.getCreated_id());
			ps.setString(12, bean.getModified_id());
			ps.setInt(13, bean.getEmployee_id());
//			ps.setString(13, bean.getEmployee_id());
			ps.setString(14, bean.getEnter_date());
			ps.setString(15, bean.getRetire_date());
			ps.setString(16, bean.getStatus());
			ps.setInt(17, bean.getEmployee_id());
//			ps.setString(17, bean.getEmployee_id());

			// sql実行
			ps.executeUpdate();

		} catch (ClassNotFoundException ce) {
			// JDBCドライバが見つからなかったときの処理
			ce.printStackTrace();
			System.out.println("EmployeeDAO ClassNotFound error");
		}
	}



}
