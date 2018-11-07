package action;

import service.StudentService;

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
		StudentService service = new StudentService();
		service.deleteStu(stuId);
		return SUCCESS;
	}
}
