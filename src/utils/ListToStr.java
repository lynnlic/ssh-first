package utils;

import java.util.List;

import model.Student;

public class ListToStr {
	public static String listToStr(List<Student> students) {
		String str = "";
		for(int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
//			str += "[班级=" + student.getOwnClass().getClassName() + ", 学号=" + student.getStuId() + ", 姓名=" + student.getStuName() + ", 年龄=" + student.getStuAge() + "] \n";
			str += "[班级=" + student.getOwnClass().getClassName() + ", ";
			str += "学号=" + student.getStuId() + ", ";
			str += "姓名=" + student.getStuName() + ", ";
			str += "年龄=" + student.getStuAge() + "] \n";
		}
		return str;
	}
}
