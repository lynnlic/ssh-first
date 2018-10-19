package interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext();
		Object user = actionContext.getSession().get("user");
		if(user != null) {
			return invocation.invoke();
		}
		else {
			actionContext.put("msg", "»¹Î´µÇÂ½£¬ÇëÏÈµÇÂ¼£¡");
			return Action.LOGIN;
		}
	}

}
