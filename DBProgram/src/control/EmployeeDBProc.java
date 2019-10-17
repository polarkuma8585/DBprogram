package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import impl.EmployeeDBServiceImpl;
import model.EmployeeDB;
import model.EmployeeDBService;

public class EmployeeDBProc {
	Scanner sc = new Scanner(System.in);
	List<EmployeeDB> empdb = new ArrayList<>();
	EmployeeDBService service = new EmployeeDBServiceImpl();

	public void execute() {

		while (true) {
			int menu = 0;
			System.out.println("1. 사원등록 | 2. 사원이름 조회 | 3. 부서별 조회 | 4. 부서 변경 | 5. 퇴사 처리 | 6. 종료");
			menu = sc.nextInt();
			sc.nextLine();
			if (menu == 1) {
				System.out.println("사원을 등록합니다.");
				insertEmployee();
			} else if (menu == 2) {
				getEmployeeList();
			} else if (menu == 3) {
				getEmpListByDept();
			} else if (menu == 4) {
				updateEmpDept();
			} else if (menu == 5) {
				fireEmployee();
			} else if (menu == 6) {
				break;
				
			}
			
		}
		System.out.println("인사 프로그램을 종료합니다.");

	}

	public void insertEmployee() {
		System.out.println("사원 이름 등록");
		String name = sc.nextLine();
		System.out.println("부서 등록");
		String dept = sc.nextLine();
		System.out.println("급여 등록");
		int sal = sc.nextInt();
		sc.nextLine();
		EmployeeDB empdb = new EmployeeDB();

		empdb.setName(name);
		empdb.setDept(dept);
		empdb.setSalary(sal);

		service.insertEmployee(empdb);

	}

	public void getEmployeeList() {
		System.out.println("사원이름 조회");
		System.out.println("조회할 사원 이름");
		String name = sc.nextLine();
		EmployeeDB empdb = service.getEmployee(name);
		System.out.println("===============================");
		System.out.println("사원아이디: " + empdb.getId());
		System.out.println("사원 이름: " + empdb.getName());
		System.out.println("소속 부서: " + empdb.getDept());
		System.out.println("급여: " + empdb.getSalary());
		System.out.println("입사일: " + empdb.getDate());
	}

	public void getEmpListByDept() {
		System.out.println("사원 부서 조회");
		System.out.println("조회할 부서 이름");
		String dept = sc.nextLine();

		EmployeeDB empdb = new EmployeeDB();
		empdb.setDept(dept);
		service.getDeptEmployee(empdb);
//		System.out.println(empdb);
		
		System.out.println("소속 부서: "+ empdb.getDept());
		System.out.println("사원아이디: " + empdb.getId());
		System.out.println("사원 이름: " + empdb.getName());
		System.out.println("급여: " + empdb.getSalary());
		System.out.println("입사일: " + empdb.getDate());

	}

	public void updateEmpDept() {
		System.out.println("부서이동 사원 아이디: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("변경할 부서 이름: ");
		String chnDept = sc.nextLine();
		EmployeeDB empdb = new EmployeeDB();
		empdb.setId(id);
		empdb.setDept(chnDept);

		service.updateEmployeeDept(empdb);
	}

	public void fireEmployee() {
		System.out.println("사원 퇴사조치");
		System.out.println("퇴사 조치할 사원의 아이디 넘버: ");
		int id = sc.nextInt();
		sc.nextLine();

		EmployeeDB empdb = new EmployeeDB();
		empdb.setId(id);

		service.fireEmployee(empdb);

	}

}
