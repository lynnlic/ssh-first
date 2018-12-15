package action;

import service.StudentServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteStudentAction extends ActionSupport{
	private String stuId;

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	
	public String execute() {
		StudentServiceImpl service = new StudentServiceImpl();
		service.deleteStu(stuId);
		return SUCCESS;
	}
}
