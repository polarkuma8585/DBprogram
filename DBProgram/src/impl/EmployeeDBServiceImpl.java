package impl;


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
		
		return dao.getList(name);
	}

	@Override
	public List<EmployeeDB> getDeptEmployee(EmployeeDB empdb) {
		List<EmployeeDB> empldb = dao.getListByDept(empdb);
		
		return empldb;
	}

	@Override
	public void updateEmployeeDept(EmployeeDB empdb) {
		dao.updateEmpDept(empdb);
	}

	@Override
	public void fireEmployee(EmployeeDB empdb) {
		dao.fireEmp(empdb);
	}
	

}
