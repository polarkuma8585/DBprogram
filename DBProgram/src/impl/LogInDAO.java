package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DAO;
import model.LogIn;

public class LogInDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	public boolean LogingInChk(LogIn logIn) {
		conn = DAO.getConnect();
		LogIn log = new LogIn();
		boolean boo = false;
		String sql = "select * from login_server where id = ? and passwd = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, logIn.getId());
			pstmt.setString(2, logIn.getPassword());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				log = new LogIn();
				log.setName("name");
				log.setId(rs.getString("id"));
				log.setPassword(rs.getString("passwd"));
				if (log.getId().equals("") && !log.getPassword().equals("")) {
					System.out.println("존재하지 않는 ID입니다.");
					boo = false;
				} else if (!log.getId().equals("") && log.getPassword().equals("")) {
					System.out.println("PASSWORD가 맞지 않습니다.");
					boo = false;
				} else if (log.getId().equals("") && log.getPassword().equals("")) {
					System.out.println("존재하지 않는 계정입니다.");
					boo = false;
				} else {
					System.out.println("로그인 되었습니다.");
					System.out.println(log.getName() + "님 환영합니다.");
					boo = true;

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return boo;
	}

}
