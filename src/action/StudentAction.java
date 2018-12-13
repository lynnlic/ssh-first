package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.Student;
import service.StudentService;

public class StudentAction extends ActionSupport{
	String type, condition, value, classId;
	String userName,password;
	List<Student> students;
	static StudentService service;
	static {
		service = new StudentService();
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
		
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() {	
		if (("".equals(classId) || classId == null) && type == null) {
			students = service.creatStudent();
		} else if (("".equals(classId) || classId == null) && type != null) {// 班级未选，搜索类型已选
			students = service.getStuByCondition(type, condition, value);
		} else if (!"".equals(classId) && (type == null || "".equals(type))) {
			students = service.getStudentsByClass(classId);
		} else if (!"".equals(classId) && type != null) {
			students = service.getStuByAllCondition(classId, type, condition,
					value);
		}

		return "success";
	}
}
