package service;

import java.util.ArrayList;
import java.util.List;

import utils.StrToNum;
import model.Student;

public class StudentService {
	private List<Student> students = new ArrayList<Student>();
	
	//默认初始数据
	public StudentService() {

	}
	
	//创建学生
	public void creatStudent() {
		Student student = new Student();
		student.setStuID("001");
		student.setStuName("李四");
		student.setStuAge(20);
		students.add(student);
		
		student = new Student();
		student.setStuID("002");
		student.setStuName("张三");
		student.setStuAge(21);
		students.add(student);
		
		student = new Student();
		student.setStuID("003");
		student.setStuName("王五");
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
	 * 通过名字查询
	 * @param condition name
	 * @param value 搜索值
	 * @return
	 */
	public List<Student> findByName(String condition, String value) {
		List<Student> result = new ArrayList<Student>();
		
		if(condition != null) {
			if(condition.equals("包含")) {
				if(value != null && !value.trim().equals("")) {
					for(Student s : students) {
						if(s.getStuName().indexOf(value) > -1) {
							result.add(s);
						}
					}
				}
			}
			else if(condition.equals("等于")) {
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
//			case "包含" : 
//				if(value != null && value.trim().equals("")) {
//					for(Student s : students) {
//						if(s.getStuName().indexOf(value) > -1) {
//							result.add(s);
//						}
//					}
//				}
//				break;
//			case "等于": 
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
	 * 通过年龄查找
	 * @param condition age
	 * @param value 输入的年龄
	 * @return
	 */
	public List<Student> findByAge(String condition, String value) {
		List<Student> result = new ArrayList<Student>();
		int numValue = 0;
		
		if(StrToNum.isOk(value)) {
			numValue = StrToNum.getNum();
		}
		if(condition != null) {
			if(condition.equals("大于")) {
				for (Student s : students) {
					if (s.getStuAge() > numValue) {
						result.add(s);
					}
				}
			}
			else if(condition.equals("大于等于")) {
				for (Student s : students) {
					if (s.getStuAge() >= numValue) {
						result.add(s);
					}
				}
			}
			else if(condition.equals("小于")) {
				for (Student s : students) {
					if (s.getStuAge() < numValue) {
						result.add(s);
					}
				}
			}
			else if(condition.equals("小于等于")) {
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
//			case "大于":
//				for (Student s : students) {
//					if (s.getStuAge() > numValue) {
//						result.add(s);
//					}
//				}
//				break;
//			case "大于等于":
//				for (Student s : students) {
//					if (s.getStuAge() >= numValue) {
//						result.add(s);
//					}
//				}
//				break;
//			case "小于":
//				for (Student s : students) {
//					if (s.getStuAge() < numValue) {
//						result.add(s);
//					}
//				}
//				break;
//			case "小于等于":
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
	 * 判断通过何种方法查询
	 * @param type 查询类型 name：通过姓名 age：通过年龄
	 * @param condition 条件
	 * @param value 输入的查询值
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
