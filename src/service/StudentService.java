package service;

import java.util.ArrayList;
import java.util.List;

import model.Class;
import model.Student;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;
import utils.StrToNum;

public class StudentService {
	//默认初始数据
	public StudentService() {

	}
	
	//创建学生
	public List<Student> creatStudent() {
		Session session = HibernateUtils.getSession();
		Transaction t = (Transaction) session.beginTransaction();
		String hql = "from Student";
		Query query = session.createQuery(hql);
		List<Student> list = query.list();
		t.commit();
		session.close();
		return list;
	}

	/**
	 * 通过名字查询
	 * @param condition name
	 * @param value 搜索值
	 * @return
	 */
	public String findByName(String condition, String value) {
		if(condition != null) {
			if(condition.equals("包含")) {
				return "like '?' ";
			} else if(condition.equals("等于")) {
				return "= ?";
			}
		} 
		return "";
	}
	
	/**
	 * 通过年龄查找
	 * @param condition age
	 * @param value 输入的年龄
	 * @return
	 */
	public String findByAge(String condition, String value) {	
		if(condition != null) {
			if(condition.equals("大于")) {
				return "> ?"; 
			} else if(condition.equals("大于等于")) {
				return ">= ?";
			} else if(condition.equals("等于")) {
				return "= ?";
			} else if(condition.equals("小于")) {
				return "< ?";
			} else if(condition.equals("小于等于")) {
				return "<= ?";
			}		
		}
		return "";
	}
	
	/**
	 * 判断通过何种方法查询
	 * @param type 查询类型 name：通过姓名 age：通过年龄
	 * @param condition 条件
	 * @param value 输入的查询值
	 * @return
	 */
	public String find(String type, String condition, String value) {
		String s = "and ";
		if(type.equals("name")) {
			s += "s.stuName " + findByName(condition, value);
		} else if(type.equals("age")) {
			s += "s.stuAge " + findByAge(condition, value);
		}
		return s;
	}

	/**
	 * 通过班级id查询
	 * @param classId 班级Id
	 * @return
	 */
	public List<Student> getStudentsByClass(String classId) {
		Session session = HibernateUtils.getSession();
		List<Student> result = new ArrayList<Student>();
		Transaction t = session.beginTransaction();
		String hql = "from Student where classId=:classId";
		Query q = session.createQuery(hql);
		q.setParameter("classId", classId);
		result = q.list();
		t.commit();
		session.close();
		return result;
	}

	public List<Student> getStuByAllCondition(String classId, String type, String condition, String value) {
		Session session = HibernateUtils.getSession();
		List<Student> result = new ArrayList<Student>();
		Transaction t = session.beginTransaction();
		String hql = "select s.stuId, s.stuName, s.stuAge, c.className from Student s, Class c "
				+ "where s.ownClass.classId = c.classId and s.ownClass.classId = ? " + find(type, condition, value);
		Query q = session.createQuery(hql);
		q.setParameter(0, classId);
		if(type.equals("age")) {
			q.setParameter(1, Integer.parseInt(value));
		} else {
			q.setParameter(1, "'" + value + "'");
		}
		result = q.list();
		t.commit();
		session.close();
		return result;
	}
	
	//删除学生
	public void deleteStu(String stuId) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		Student delStudetn = (Student)session.load(Student.class, stuId);
		session.delete(delStudetn);
		t.commit();
		session.close();
	}
	
	//编辑学生信息
	public void editStu(Student student) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		Student editStudent = (Student)session.load(Student.class, student.getStuId());
		System.out.println(editStudent);
		editStudent.setStuName(student.getStuName());
		editStudent.setStuAge(student.getStuAge());
		session.update(editStudent);		
		t.commit();
		session.close();
	}
}
