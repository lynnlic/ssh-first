package utils;

import java.util.List;

import model.Student;

public class ListToStr {
	public static String listToStr(List<Student> students) {
		String str = "";
		for(int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
//			str += "[�༶=" + student.getOwnClass().getClassName() + ", ѧ��=" + student.getStuId() + ", ����=" + student.getStuName() + ", ����=" + student.getStuAge() + "] \n";
			str += "[�༶=" + student.getOwnClass().getClassName() + ", ";
			str += "ѧ��=" + student.getStuId() + ", ";
			str += "����=" + student.getStuName() + ", ";
			str += "����=" + student.getStuAge() + "] \n";
		}
		return str;
	}
}
