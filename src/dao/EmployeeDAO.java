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

//	// DBへのアクション
//	private void doDataBase(String sql) throws Exception {
//		// コンテキストを取得
//		InitialContext ic = new InitialContext();
//		// ルックアップしてデータソースを取得
//		ds = (DataSource) ic.lookup("java:comp/env/jdbc/searchman");
//		con = ds.getConnection();
//
//		// sql文を表示
//		System.out.println(sql);
//		ps = con.prepareStatement(sql);
//		// sql実行
//		ps.execute();
//
//		// 使用したオブジェクトを終了させる
//		ps.close();
//		con.close();
//	}

	/**
	 * employee_info & employee_state テーブルのデータを取得
	 */
	public ResultSet findAll() throws SQLException {

		try {
			//JDBCドライバを読み込む
//			Class.forName("org.h2.Driver");					// h2
			Class.forName("com.mysql.cj.jdbc.Driver");		// MySQL

			//DBに接続
//			con = DriverManager.getConnection("jdbc:h2:~/employee", "sa", "");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management?serverTimezone=UTC&useSSL=false",
					"root", "taku07151735");

			// SQL文を準備(SELECT文)
			String sql = "SELECT employee_id, name, name_hiragana, birthday, sex, mail_address, telephone_number, company_info_id, business_manager, department, commissioning_status, EMPLOYEE_INFO.created_id, EMPLOYEE_INFO.modified_id,"
					+ "employee_info_id, enter_date, retire_date, status "
					+ "FROM EMPLOYEE_INFO JOIN EMPLOYEE_STATE ON EMPLOYEE_INFO.EMPLOYEE_ID=EMPLOYEE_INFO_ID WHERE employee_id ORDER BY employee_id";

			// SQL表示
			System.out.println(sql);

			// SQL実行準備
			ps = con.prepareStatement(sql);

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
	 * レコード追加
	 */
	public void insert(EmployeeBean bean) throws SQLException {
		try {
			//JDBCドライバを読み込む
//			Class.forName("org.h2.Driver");					// h2
			Class.forName("com.mysql.cj.jdbc.Driver");		// MySQL

			//DBに接続
//			con = DriverManager.getConnection("jdbc:h2:~/employee", "sa", "");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management?serverTimezone=UTC&useSSL=false",
					"root", "taku07151735");

			// SQL文を準備(INSERT文)
			// sql(employee_infoテーブル)
			String sql = "INSERT INTO EMPLOYEE_INFO(employee_id, name, name_hiragana, birthday, sex, mail_address, telephone_number, company_info_id, business_manager, department, commissioning_status, created_id, modified_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			// sql2(employee_stateテーブル)
			String sql2 = "INSERT INTO EMPLOYEE_STATE(employee_info_id, enter_date, retire_date, status) values(?, ?, ?, ?)";

			// SQL表示
			System.out.println(sql);
			System.out.println(sql2);

			// SQL実行準備
			// sql(employee_infoテーブル)
			ps = con.prepareStatement(sql);
			ps.setInt(1, bean.getEmployee_id());
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getName_hiragana());
			ps.setString(4, bean.getBirthday());
			ps.setString(5, bean.getSex());
			ps.setString(6, bean.getMail_address());
			ps.setString(7, bean.getTelephone_number());
			ps.setInt(8, bean.getCompany_info_id());
			ps.setString(9, bean.getBusiness_manager());
			ps.setString(10, bean.getDepartment());
			ps.setString(11, bean.getCommissioning_status());
			ps.setString(12, bean.getCreated_id());
			ps.setString(13, bean.getModified_id());
			ps.executeUpdate();

			// sql2(employee_stateテーブル)
			ps = con.prepareStatement(sql2);
			ps.setInt(1, bean.getEmployee_id());
//			ps.setString(14, bean.getEmployee_info_id());
			ps.setString(2, bean.getEnter_date());
			ps.setString(3, bean.getRetire_date());
			ps.setString(4, bean.getStatus());
			ps.executeUpdate();

		} catch (ClassNotFoundException ce) {
			// JDBCドライバが見つからなかったときの処理
			ce.printStackTrace();
			System.out.println("EmployeeDAO ClassNotFound error");
		}
	}


	/**
	 * レコード更新
	 */
	public void update(EmployeeBean bean) throws SQLException {
		try {
			//JDBCドライバを読み込む
//			Class.forName("org.h2.Driver");				// h2
			Class.forName("com.mysql.jdbc.Driver");		// MySQL

			//DB接続
//			con = DriverManager.getConnection("jdbc:h2:~/employee", "sa", "");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management?serverTimezone=UTC&useSSL=false",
					"root", "taku07151735");

			// SQL文準備(UPDATE文)
			// sql(employee_infoテーブル)
			String sql = "UPDATE EMPLOYEE_INFO SET name=?, name_hiragana=?, birthday=?, sex=?, mail_address=?, telephone_number=?, "
					+ "company_info_id=?, business_manager=?, department=?, commissioning_status=?, created_id=?, modified_id=? WHERE employee_id=?";
			// sql2(employee_stateテーブル)
			String sql2 = "UPDATE EMPLOYEE_STATE SET enter_date=?, retire_date=?, status=? WHERE employee_info_id=?";

			// SQL表示
			System.out.println(sql);
			System.out.println(sql2);

			// SQL実行準備
			// sql(employee_infoテーブル)
			ps = con.prepareStatement(sql);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getName_hiragana());
			ps.setString(3, bean.getBirthday());
			ps.setString(4, bean.getSex());
			ps.setString(5, bean.getMail_address());
			ps.setString(6, bean.getTelephone_number());
			ps.setInt(7, bean.getCompany_info_id());
			ps.setString(8, bean.getBusiness_manager());
			ps.setString(9, bean.getDepartment());
			ps.setString(10, bean.getCommissioning_status());
			ps.setString(11, bean.getCreated_id());
			ps.setString(12, bean.getModified_id());
			ps.setInt(13, bean.getEmployee_id());
			ps.executeUpdate();

			// sql2(employee_stateテーブル)
			ps = con.prepareStatement(sql2);
			ps.setString(1, bean.getEnter_date());
			ps.setString(2, bean.getRetire_date());
			ps.setString(3, bean.getStatus());
			ps.setInt(4, bean.getEmployee_id());
			ps.executeUpdate();

		} catch (ClassNotFoundException ce) {
			// JDBCドライバが見つからなかったときの処理
			ce.printStackTrace();
			System.out.println("EmployeeDAO ClassNotFound error");
		}
	}


	/**
	 * 特定employee_idのレコード削除
	 */
	public void delete(EmployeeBean bean) throws SQLException {
		try {
			//JDBCドライバを読み込む
//			Class.forName("org.h2.Driver");					// h2
			Class.forName("com.mysql.cj.jdbc.Driver");		// MySQL

			//DBに接続
//			con = DriverManager.getConnection("jdbc:h2:~/employee", "sa", "");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management?serverTimezone=UTC&useSSL=false",
					"root", "taku07151735");

			// SQL文準備(DELETE文)
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM EMPLOYEE_INFO WHERE employee_id IN (SELECT employee_info_id FROM EMPLOYEE_STATE WHERE EMPLOYEE_STATE.employee_info_id=?); ");

			// SQL表示
			System.out.println(sql);

			// SQL実行準備
			ps = con.prepareStatement(new String(sql));
			ps.setInt(1, bean.getEmployee_id());

			// SQL実行
			ps.executeUpdate();

		} catch (ClassNotFoundException ce) {
			// JDBCドライバが見つからなかったときの処理
			ce.printStackTrace();
			System.out.println("EmployeeDAO ClassNotFound error");
		}
	}

}
