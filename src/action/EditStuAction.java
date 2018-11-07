package action;

import service.StudentService;
import model.Student;

import com.opensymphony.xwork2.ActionSupport;

public class EditStuAction extends ActionSupport{
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String execute() {
		StudentService service = new StudentService();
		service.editStu(student);
		return SUCCESS;
	}
}
