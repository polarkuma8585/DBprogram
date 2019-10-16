package model;

import java.util.List;

public interface EmployeeDBService {
	
	public void insertEmployee(EmployeeDB empdb);
	public EmployeeDB getEmployee(String name);
	public List<EmployeeDB> getDeptEmployee(EmployeeDB empdb);
	public void updateEmployeeDept(EmployeeDB empdb);
	public void fireEmployee(EmployeeDB empdb);
	
}
