package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.Account;
import model.Login;

public class AccountDAO {

	// DB初期設定
	private Connection con = null;
	private PreparedStatement ps = null;
	private DataSource ds = null;
	private ResultSet rs = null;

	public Account findByLogin(Login login) {

		Account account = null;

		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//DBに接続
			con = DriverManager.getConnection("jdbc:h2:~/employee", "sa", "");

			// SQL文の作成準備
//			StringBuffer sql = new StringBuffer();

			// SELECT文を準備
//			sql.append("SELECT LOGIN_ID, PASSWORD FROM LOGIN_INFO WHERE LOGIN_ID = ? AND PASSWORD = ?;");
			String sql = "SELECT LOGIN_ID, PASSWORD FROM LOGIN_INFO WHERE LOGIN_ID = ? AND PASSWORD = ?";
			// SQL実行準備
			ps = con.prepareStatement(sql);
			ps.setString(1, login.getLogin_id());
			ps.setString(2, login.getPassword());

			// SQLを表示
			System.out.println(sql);

			// SELECTを実行し、結果表を代入
			rs = ps.executeQuery();

			// 一致したユーザーが存在した場合、Accountインスタンスを生成
			if(rs.next()) {
				// 結果表からデータを取得
				String login_id = rs.getString("LOGIN_ID");
				String password = rs.getString("PASSWORD");
				account = new Account(login_id, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
 			}
		}
		//見つかったユーザーまたはnullを返す
		return account;
	}
}


