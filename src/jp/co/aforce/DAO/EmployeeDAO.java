package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

	
	// ユーザー情報をリストでもらう
	public boolean loginCheck(String user_id, String password) throws ClassNotFoundException, SQLException {

		// データベースへの接続の取得、PreparedStatementの取得
			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pst = con.prepareStatement("SELECT * FROM employee WHERE user_id = ? AND password = ?")) {

					// プレースホルダへの値の設定
					pst.setString(1, user_id);
					pst.setString(2, password);

					// SQLステートメントの実行
					ResultSet rs = pst.executeQuery();

					// 結果の操作
					if (rs.next()) {
						return true;
					}
				}
				return false;
			}

		}
