package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DAO;
import model.EmployeeDB;

public class EmployeeDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	public void InsertEmp(EmployeeDB empdb) {
		conn = DAO.getConnect();
		String sql = "insert into employee(employee_id, name, dept, salary, hire_date)"
				+ "values ((select max(employee_id)+1 from employee),?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empdb.getName());
			pstmt.setString(2, empdb.getDept());
			pstmt.setInt(3, empdb.getSalary());
			int r = pstmt.executeUpdate();
			System.out.println(r + " 건이 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public EmployeeDB getList(String name) {
		conn = DAO.getConnect();
		EmployeeDB empl = null;
		String sql = "select * from employee where name = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				empl = new EmployeeDB();
				empl.setId(rs.getInt("employee_id"));
				empl.setName(rs.getString("name"));
				empl.setDept(rs.getString("dept"));
				empl.setSalary(rs.getInt("salary"));
				empl.setDate(rs.getString("hire_date"));

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

		return empl;

	}

	public List<EmployeeDB> getListByDept(EmployeeDB empdb) { // 전체 검색
		conn = DAO.getConnect();
		List<EmployeeDB> list1 = new ArrayList<>();
		String sql = "select * from employee";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeDB empldb = new EmployeeDB();
				empldb.setId(rs.getInt("employee_id"));
				empldb.setName(rs.getString("name"));
				empldb.setDept(rs.getString("dept"));
				empldb.setSalary(rs.getInt("salary"));
				empldb.setDate(rs.getString("hire_date"));
				list1.add(empldb);

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
		return list1;
	}


	public List<EmployeeDB> getEmpDept(String dept) { // 부서 검색 체크
		conn = DAO.getConnect();
		String sql = "select * from employee where dept = ?";
		List<EmployeeDB> list = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeDB empl = new EmployeeDB();
				empl.setId(rs.getInt("employee_id"));
				empl.setName(rs.getString("name"));
				empl.setDept(rs.getString("dept"));
				empl.setSalary(rs.getInt("salary"));
				empl.setDate(rs.getString("hire_date"));
				list.add(empl);
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

		return list;
	}

	public boolean checkDept(String dept) { // dept 유무 boolean 체크
		conn = DAO.getConnect();
		String sql = "select * from employee where dept = ?";
		String dChk = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dChk = rs.getString("dept");
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
		if (dChk != null) {
			return true;
		} else {
			return false;
		}

	}
	public boolean checkName(String name) { // Name 유무 boolean 체크
		conn = DAO.getConnect();
		String sql = "select * from employee where Name = ?";
		String nChk = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				nChk = rs.getString("name");
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
		if (nChk != null) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean checkEmpId(int id) { // 사원 id 유무 boolean 체크
		conn = DAO.getConnect();
		String sql = "select * from employee where employee_id = ?";
		String iChk = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				iChk = rs.getString("employee_id");
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
		if (iChk != null) {
			return true;
		} else {
			return false;
		}

	}

	public void updateEmpDept(EmployeeDB empdb) {
		conn = DAO.getConnect();
		String sql = "update employee set dept = ? where employee_id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empdb.getDept());
			pstmt.setInt(2, empdb.getId());
			int r = pstmt.executeUpdate();

			System.out.println("사원 아이디" + empdb.getId() + "의 사원이 " + " 부서 이동되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void fireEmp(EmployeeDB empdb) {
		conn = DAO.getConnect();
		String sql = "delete from employee where employee_id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empdb.getId());
			rs = pstmt.executeQuery();
			System.out.println("사원 아이디" + empdb.getId() + " 의 사원이 퇴사 처리 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
