package control;

import java.util.Scanner;

import impl.LogInServiceImpl;
import model.LogIn;
import model.LogInService;

public class LogInProc {
	Scanner sc = new Scanner(System.in);
	LogInService service = new LogInServiceImpl();
	EmployeeDBProc edbP = new EmployeeDBProc();
	public void firstSite() {
		int menu = 0;
		while (true) {
			System.out.println("인사 시스템에 오신것을 환영합니다.");
			System.out.println("1. 로그인 | 2. 인사시스템가입 | 3. 인사시스템 계정 관리| 4, 인사시스템 종료");
			menu = sc.nextInt();
			sc.nextLine();
			if (menu == 1) {
				System.out.println("인사시스템 로그인");
				LogingIn();
			} else if (menu == 2) {
				System.out.println("인사시스템 가입");
				accountSignIn();
			} else if (menu == 3) {
				System.out.println("인사시시스템 계정 관리");
				accountManage();
			} else if (menu == 4){
				System.out.println("인사시스템을 종료합니다.");
				break;

			}
		}
	}

	public void LogingIn() {
		System.out.println("ID 입력");
		String id = sc.nextLine();
		System.out.println("PASSWORD 입력");
		String passwd = sc.nextLine();
		LogIn logIn = new LogIn();
		
		logIn.setId(id);
		logIn.setPassword(passwd);
		
		service.SignIn(logIn);
		edbP.execute();
	}

	public void accountSignIn() {

	}

	public void accountManage() {

	}

}
