package service;

import java.util.List;

import model.Student;

public interface StudentService {
	public List<Student> creatStudent();
	public void setNewStudent(List<Student> newStudent);
	public List<Student> getStuByAllCondition(String classCode, String type, String condition, String value);
	public List<Student> getStuByCondition(String type, String condition, String value);
	public List<Student> getStudentsByClass(String classCode);
	public void deleteStu(String stuId);
	public void editStu(Student student);
}
