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
			super.addFieldError("classId", "�༶������д��");
		}
		if(student.getStuId() == null || "".equals(student.getStuId())) {
			super.addFieldError("stuId", "ѧ�ű�����д!");
		} else {
			if(!StrToNum.isOk(student.getStuId())) {
				super.addFieldError("stuId", "ѧ��ֻ�ܰ������֣�");
			}
		}
		if(student.getStuName() == null || "".equals(student.getStuName())) {
			super.addFieldError("stuName", "����������д��");
		}
		if(student.getStuAge() == null) {
			super.addFieldError("stuAge", "���������д��");
		}
	}
	
	public String execute() {
		AddStudentService service = new AddStudentService();
		service.addStudent(student);
		return SUCCESS;
	}
}
