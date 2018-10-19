package service;

import com.opensymphony.xwork2.ActionContext;

import model.User;

public class LoginService {
	public int isAbleToLogin(User user) {
		String userName = user.getUserName();
		String userPwd = user.getUserPwd();
		
		if(userName != null && userName.equals("admin")) {
			if(userPwd != null && userPwd.equals("123")) {
				return 1;//¿ÉÒÔµÇÂ¼
			}
		}
		return 0;//ÕËºÅÃÜÂë´íÎó
	}

}
