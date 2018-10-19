package service;

import java.util.List;
import java.util.StringTokenizer;

import model.Student;

public class FileUploadService {
	private String[][] info = null;
	
	//�ַ����и�
	public void strToinfo(String str) {
		String[] infos = str.trim().split(";");//ͨ���ֺ�����ÿһ������
		info = new String[infos.length][3];
		String[] temp = new String[3];
		for(int i = 0; i < infos.length; i++) {
			temp = infos[i].split(" ");
			info[i][0] = temp[0];
			info[i][1] = temp[1];
			info[i][2] = temp[2];
		}
	}
	
	//д������
	public void addStudent() {
		StudentService studentService = new StudentService();		
		List<Student> newStudent = studentService.getStudents();
		
		for(int i = 0; i < info.length; i++) {
			Student student = new Student();
			student.setStuID(info[i][0]);
			student.setStuName(info[i][1]);
			student.setStuAge(Integer.parseInt(info[i][2]));
			newStudent.add(student);
		}
		studentService.setStudents(newStudent);
	}
}