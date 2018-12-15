package service;

import java.util.List;
import javax.annotation.Resource;

import model.Student;

import org.springframework.stereotype.Service;

import dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{
	@Resource
	private StudentDao studentDao;
	
	//默认初始数据
	public StudentServiceImpl() {

	}
	
	//文件上传之后创建新的学生
	public void setNewStudent(List<Student> newStudent) {
		studentDao.setNewStudent(newStudent);
	}
	
	//创建学生
	public List<Student> creatStudent() {
		return studentDao.creatStudent();
	}

	//通过班级号查询
	public List<Student> getStudentsByClass(String classCode) {
		return studentDao.getStudentsByClass(classCode);
	}

	//填写完整所有信息后查询
	public List<Student> getStuByAllCondition(String classCode, String type, String condition, String value) {
		return studentDao.getStuByAllCondition(classCode, type, condition, value);
	}
	
	//通过其他条件搜索
	public List<Student> getStuByCondition(String type, String condition, String value) {
		return studentDao.getStuByCondition(type, condition, value);
	}
	
	//删除学生
	public void deleteStu(String stuId) {
		studentDao.deleteStu(stuId);
	}
	
	//编辑学生信息
	public void editStu(Student student) {
		studentDao.editStu(student);
	}
}
