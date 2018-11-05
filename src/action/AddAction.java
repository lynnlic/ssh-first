package action;

import model.Student;

import com.opensymphony.xwork2.ActionSupport;

public class AddAction extends ActionSupport {	
	private Student student = new Student();
		
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

	@Override
	public void validate() {
		if(student.getOwnClass().getClassId() == null || "".equals(student.getOwnClass().getClassId())) {
			super.addFieldError("classId", "∞‡º∂±ÿ–ÎÃÓ–¥£°");
		}
	}
	
	public String execute() {
		System.out.println("!!!!"+student.getStuId());
		
		return SUCCESS;
	}
}
