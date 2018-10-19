function isableToLogin() {
	var userName = loginForm.userName.value.trim();
	var userPwd = loginForm.userPwd.value.trim();
	console.log(userName,'----',userPwd);
	if(userName == null || userName == '') {
		alert("用户名不能为空！");
		loginForm.userName.focus();
		return false;
	}
	if(userPwd != '') {
		if(userPwd.length < 3 || userPwd.length > 10) {
			alert("密码长度为3-10位！");
			loginForm.userPwd.focus();
			return false;
		}
	}
	else {
		alert("密码不能为空！");
		loginForm.userPwd.focus();
		return false;
	}
	return true;
}