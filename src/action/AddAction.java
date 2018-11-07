package action;

import service.AddStudentService;
import utils.StrToNum;
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
			super.addFieldError("classId", "班级必须填写！");
		}
		if(student.getStuId() == null || "".equals(student.getStuId())) {
			super.addFieldError("stuId", "学号必须填写!");
		} else {
			if(!StrToNum.isOk(student.getStuId())) {
				super.addFieldError("stuId", "学号只能包含数字！");
			}
		}
		if(student.getStuName() == null || "".equals(student.getStuName())) {
			super.addFieldError("stuName", "姓名必须填写！");
		}
		if(student.getStuAge() == null) {
			super.addFieldError("stuAge", "年龄必须填写！");
		}
	}
	
	public String execute() {
		AddStudentService service = new AddStudentService();
		service.addStudent(student);
		return SUCCESS;
	}
}
