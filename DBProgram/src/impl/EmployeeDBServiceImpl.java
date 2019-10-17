package impl;

import java.util.ArrayList;
import java.util.List;

import model.EmployeeDB;
import model.EmployeeDBService;

public class EmployeeDBServiceImpl implements EmployeeDBService {
	EmployeeDAO dao = new EmployeeDAO();

	@Override
	public void insertEmployee(EmployeeDB empdb) {
		dao.InsertEmp(empdb);
	}

	@Override
	public EmployeeDB getEmployee(String name) {
		if (dao.checkName(name)) {
			return dao.getList(name);
		} else {
			return null;
		}

	}

	@Override
	public List<EmployeeDB> getDeptEmployee(EmployeeDB empdb) {
		List<EmployeeDB> empldb = new ArrayList<>();
		if (dao.checkDept(empdb.getDept())) {
			empldb = dao.getEmpDept(empdb.getDept());
			System.out.println(empdb.getDept() + " 부서 리스트");
		} else {
			empldb = dao.getListByDept(empdb);
			System.out.println("전체 리스트를 조회합니다.");
		}
		return empldb;
	}

	@Override
	public void updateEmployeeDept(EmployeeDB empdb) {
		EmployeeDB empldb = new EmployeeDB();
		if (dao.checkEmpId(empdb.getId())) {
			dao.updateEmpDept(empdb);
		} else {
			System.out.println("존재하지 않는 사원 번호입니다.");
		}
	}

	@Override
	public void fireEmployee(EmployeeDB empdb) {
		dao.fireEmp(empdb);
	}

}
