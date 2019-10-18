package model;

public interface LogInService {

	public LogIn SignIn(LogIn logIn); // 로그인
	public LogIn SignUp(LogIn SignUp); // 가입
	public void SignOut(LogIn SignOut);  // 탈퇴
	
	
}
