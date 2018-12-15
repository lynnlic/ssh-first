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
	
	//Ĭ�ϳ�ʼ����
	public StudentServiceImpl() {

	}
	
	//�ļ��ϴ�֮�󴴽��µ�ѧ��
	public void setNewStudent(List<Student> newStudent) {
		studentDao.setNewStudent(newStudent);
	}
	
	//����ѧ��
	public List<Student> creatStudent() {
		return studentDao.creatStudent();
	}

	//ͨ���༶�Ų�ѯ
	public List<Student> getStudentsByClass(String classCode) {
		return studentDao.getStudentsByClass(classCode);
	}

	//��д����������Ϣ���ѯ
	public List<Student> getStuByAllCondition(String classCode, String type, String condition, String value) {
		return studentDao.getStuByAllCondition(classCode, type, condition, value);
	}
	
	//ͨ��������������
	public List<Student> getStuByCondition(String type, String condition, String value) {
		return studentDao.getStuByCondition(type, condition, value);
	}
	
	//ɾ��ѧ��
	public void deleteStu(String stuId) {
		studentDao.deleteStu(stuId);
	}
	
	//�༭ѧ����Ϣ
	public void editStu(Student student) {
		studentDao.editStu(student);
	}
}
