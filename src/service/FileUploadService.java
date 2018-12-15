package service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import com.p6spy.cglib.core.ClassesKey;

import model.Student;

public class FileUploadService {
	private String[][] info = null;
	
	//字符串切割
	public void strToinfo(String str) {
		String[] infos = str.trim().split(";");//通过分号区别每一条数据
		info = new String[infos.length][4];
		String[] temp = new String[3];
		for(int i = 0; i < infos.length; i++) {
			temp = infos[i].split(" ");
			info[i][0] = temp[0];
			info[i][1] = temp[1];
			info[i][2] = temp[2];
			info[i][3] = temp[3];
		}
	}
	
	//写入数据
	public void addStudent() throws Exception {
		StudentServiceImpl studentService = new StudentServiceImpl();		
		List<Student> newStudent = new ArrayList<Student>();
		
		for(int i = 0; i < info.length; i++) {
			Student student = new Student();
			model.MyClass tempClass = new model.MyClass();
			student.setStuId(info[i][0]);
			student.setStuName(info[i][1]);
			student.setStuAge(Integer.parseInt(info[i][2]));
			tempClass.setClassCode(info[i][3]);
			student.setOwnClass(tempClass);
			newStudent.add(student);
		}
		studentService.setNewStudent(newStudent);
	}
}
