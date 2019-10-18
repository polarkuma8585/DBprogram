package impl;

import model.LogIn;
import model.LogInService;

public class LogInServiceImpl implements LogInService {
	LogInDAO dao = new LogInDAO();
	@Override
	public LogIn SignIn(LogIn logIn) {
		if(dao.LogingInChk(logIn)) {
			return dao.LogingInChk(logIn);
		}else {
			return null;
		}
			
			
		
		
	}

	@Override
	public LogIn SignUp(LogIn SignUp) {
		return null;
	}

	@Override
	public void SignOut(LogIn SignOut) {
		
	}

}
