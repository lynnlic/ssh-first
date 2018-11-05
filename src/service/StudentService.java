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
	//Ĭ�ϳ�ʼ����
	public StudentService() {

	}
	
	//����ѧ��
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
	 * ͨ�����ֲ�ѯ
	 * @param condition name
	 * @param value ����ֵ
	 * @return
	 */
	public String findByName(String condition, String value) {
		if(condition != null) {
			if(condition.equals("����")) {
				return "like '?' ";
			} else if(condition.equals("����")) {
				return "= ?";
			}
		} 
		return "";
	}
	
	/**
	 * ͨ���������
	 * @param condition age
	 * @param value ���������
	 * @return
	 */
	public String findByAge(String condition, String value) {	
		if(condition != null) {
			if(condition.equals("����")) {
				return "> ?"; 
			} else if(condition.equals("���ڵ���")) {
				return ">= ?";
			} else if(condition.equals("����")) {
				return "= ?";
			} else if(condition.equals("С��")) {
				return "< ?";
			} else if(condition.equals("С�ڵ���")) {
				return "<= ?";
			}		
		}
		return "";
	}
	
	/**
	 * �ж�ͨ�����ַ�����ѯ
	 * @param type ��ѯ���� name��ͨ������ age��ͨ������
	 * @param condition ����
	 * @param value ����Ĳ�ѯֵ
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
	 * ͨ���༶id��ѯ
	 * @param classId �༶Id
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
		System.out.println("/////"+hql);
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
}
