package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import utils.HibernateUtils;
import model.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

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
				return "like '" + value + "' ";
			} else if(condition.equals("等于")) {
				return "= '" + value + "'";
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
				return "> " + value; 
			} else if(condition.equals("大于等于")) {
				return ">= " + value;
			} else if(condition.equals("等于")) {
				return "= " + value;
			} else if(condition.equals("小于")) {
				return "< " + value;
			} else if(condition.equals("小于等于")) {
				return "<= " + value;
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
		String s = "";
		if(type.equals("name")) {
			s += "s.stuName " + findByName(condition, value);
		} else if(type.equals("age")) {
			s += "s.stuAge " + findByAge(condition, value);
		}
		return s;
	}

	public List<Student> getStuByAllCondition(String classCode, String type,
			String condition, String value) {
		Session session = HibernateUtils.getSession();
		String hql = "from Student as s where s.ownClass.classCode =:classCode and " + find(type, condition, value);
		System.out.println("hql:"+hql);
		Query q = session.createQuery(hql);
		q.setParameter("classCode", classCode);
		List<Student> result = q.list();
		session.close();
		return result;
	}

	public List<Student> getStuByCondition(String type, String condition,
			String value) {
		Session session = HibernateUtils.getSession();
		String hql = "from Student as s where " + find(type, condition, value);
		System.out.println("hql:"+hql);
		Query q = session.createQuery(hql);
		List<Student> result = q.list();
		session.close();
		return result;
	}

	public List<Student> getStudentsByClass(String classCode) {
		Session session = HibernateUtils.getSession();
		List<Student> result = new ArrayList<Student>();
		Transaction t = session.beginTransaction();
		String hql = "from Student where classCode=:classCode";
		Query q = session.createQuery(hql);
		q.setParameter("classCode", classCode);
		result = q.list();
		t.commit();
		session.close();
		return result;
	}

	public void deleteStu(String stuId) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		Student delStudetn = (Student)session.load(Student.class, stuId);
		session.delete(delStudetn);
		t.commit();
		session.close();
	}

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

	//文件上传之后创建新的学生
	public void setNewStudent(List<Student> newStudent) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		for(int i = 0; i < newStudent.size(); i++) {
			Student student = newStudent.get(i);
			String sql = "insert into student(stuID, stuName, stuAge, classCode) "
					+ "values('"+student.getStuId()+"','"+student.getStuName()+"','"+student.getStuAge()+"','"+student.getOwnClass().getClassCode()+"')";
			Query q = session.createSQLQuery(sql);
			q.executeUpdate();
		}
		t.commit();
		session.close();
	}

}
