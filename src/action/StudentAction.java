package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.Student;
import service.StudentService;

public class StudentAction extends ActionSupport{
	String type, condition, value;
	String userName,password;
	List<Student> students = new ArrayList<Student>();
	static StudentService service;
	static {
		service = new StudentService();
		service.creatStudent();
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
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
		if(type != null) {
			students = service.find(type, condition, value);
		}
		else {
			students = service.getStudents();
		}		
		return "success";
	}
}
