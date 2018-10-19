package service;

import java.util.ArrayList;
import java.util.List;

import utils.StrToNum;
import model.Student;

public class StudentService {
	private List<Student> students = new ArrayList<Student>();
	
	//Ĭ�ϳ�ʼ����
	public StudentService() {

	}
	
	//����ѧ��
	public void creatStudent() {
		Student student = new Student();
		student.setStuID("001");
		student.setStuName("����");
		student.setStuAge(20);
		students.add(student);
		
		student = new Student();
		student.setStuID("002");
		student.setStuName("����");
		student.setStuAge(21);
		students.add(student);
		
		student = new Student();
		student.setStuID("003");
		student.setStuName("����");
		student.setStuAge(19);
		students.add(student);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	/**
	 * ͨ�����ֲ�ѯ
	 * @param condition name
	 * @param value ����ֵ
	 * @return
	 */
	public List<Student> findByName(String condition, String value) {
		List<Student> result = new ArrayList<Student>();
		
		if(condition != null) {
			if(condition.equals("����")) {
				if(value != null && !value.trim().equals("")) {
					for(Student s : students) {
						if(s.getStuName().indexOf(value) > -1) {
							result.add(s);
						}
					}
				}
			}
			else if(condition.equals("����")) {
				if(value != null && value.trim().equals("")) {
					for (Student s : students) {
						if(value.equals(s.getStuName())) {
							result.add(s);
						}						
					}
				}
			}
			else {
				result = students;
			}
//			switch(condition) {
//			case "����" : 
//				if(value != null && value.trim().equals("")) {
//					for(Student s : students) {
//						if(s.getStuName().indexOf(value) > -1) {
//							result.add(s);
//						}
//					}
//				}
//				break;
//			case "����": 
//				if(value != null && value.trim().equals("")) {
//					for (Student s : students) {
//						if(value.trim().equals(s.getStuName())) {
//							result.add(s);
//						}						
//					}
//				}
//				break;
//			default: 
//				result = students;
//				break;
//			}
		}
		
		return result;
	}
	
	/**
	 * ͨ���������
	 * @param condition age
	 * @param value ���������
	 * @return
	 */
	public List<Student> findByAge(String condition, String value) {
		List<Student> result = new ArrayList<Student>();
		int numValue = 0;
		
		if(StrToNum.isOk(value)) {
			numValue = StrToNum.getNum();
		}
		if(condition != null) {
			if(condition.equals("����")) {
				for (Student s : students) {
					if (s.getStuAge() > numValue) {
						result.add(s);
					}
				}
			}
			else if(condition.equals("���ڵ���")) {
				for (Student s : students) {
					if (s.getStuAge() >= numValue) {
						result.add(s);
					}
				}
			}
			else if(condition.equals("С��")) {
				for (Student s : students) {
					if (s.getStuAge() < numValue) {
						result.add(s);
					}
				}
			}
			else if(condition.equals("С�ڵ���")) {
				for (Student s : students) {
					if (s.getStuAge() <= numValue) {
						result.add(s);
					}
				}
			}
			else {
				result = students;
			}
		}
		return result;
//			switch (condition) {
//			case "����":
//				for (Student s : students) {
//					if (s.getStuAge() > numValue) {
//						result.add(s);
//					}
//				}
//				break;
//			case "���ڵ���":
//				for (Student s : students) {
//					if (s.getStuAge() >= numValue) {
//						result.add(s);
//					}
//				}
//				break;
//			case "С��":
//				for (Student s : students) {
//					if (s.getStuAge() < numValue) {
//						result.add(s);
//					}
//				}
//				break;
//			case "С�ڵ���":
//				for (Student s : students) {
//					if (s.getStuAge() <= numValue) {
//						result.add(s);
//					}
//				}
//				break;
//			default:
//				result = students;
//				break;
//			}
//		}
		
	}
	
	/**
	 * �ж�ͨ�����ַ�����ѯ
	 * @param type ��ѯ���� name��ͨ������ age��ͨ������
	 * @param condition ����
	 * @param value ����Ĳ�ѯֵ
	 * @return
	 */
	public List<Student> find(String type, String condition, String value) {
		List<Student> result = new ArrayList<Student>();
		
			if(type.equals("name")) {
				result = findByName(condition, value);
			}
			else if(type.equals("age")) {
				result = findByAge(condition, value);
			}
			else {
				result = students;
			}
//			switch (type) {
//			case "name":
//				result = findByName(condition, value);
//				break;
//			case "age":
//				result = findByAge(condition, value);
//				break;
//			default:
//				result = students;
//				break;
//			}
		return result;
	}
}
