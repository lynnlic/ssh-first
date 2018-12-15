package action;

import service.LoginService;
import model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	User user = new User();
	
	@Override
	public String execute(){
		LoginService service = new LoginService();
		ActionContext actionContext = ActionContext.getContext();
		if(service.isAbleToLogin(user) == 1) {
			actionContext.getSession().put("user", user);
			return SUCCESS;
		}	
		else {
			actionContext.put("message", "用户名或密码不正确");
			return INPUT;
		}
	}

	public User getModel() {
		return user;
	}
}
