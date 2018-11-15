package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Class;
import model.Student;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
				return "like '" + value + "' ";
			} else if(condition.equals("����")) {
				return "= '" + value + "'";
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
				return "> " + value; 
			} else if(condition.equals("���ڵ���")) {
				return ">= " + value;
			} else if(condition.equals("����")) {
				return "= " + value;
			} else if(condition.equals("С��")) {
				return "< " + value;
			} else if(condition.equals("С�ڵ���")) {
				return "<= " + value;
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
	 * @param classCode �༶Id
	 * @return
	 */
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

	public List<Student> getStuByAllCondition(String classCode, String type, String condition, String value) {
		Session session = HibernateUtils.getSession();
//		Transaction t = session.beginTransaction();
//		List<Student> result = new ArrayList<Student>();
//		Student gouzi = new Student();
//		String hql = "select s.stuId, s.stuName, s.stuAge, s.ownClass.classCode from Student s";
//		
//		
//		System.out.println(classCode +"====1");
//		q.setParameter("classCode", classCode);
//		q.setParameter(0, classCode);
//		if(type.equals("age")) {
//			q.setParameter(1, Integer.parseInt(value));
//		} else {
//			q.setParameter(1, "'" + value + "'");
//		}
//		result = q.list();		
//		System.out.println("======2" + result.size());
//		for(int i = 0; i < result.size();i++) {
//			System.out.println("======" + result.get(i).getStuName());
//		}
//		String hql = " from Student as s where classCode= "+  classCode + " " + find(type, condition, value);
//		String hql = "from Student where stuName=:name";
//		Query q = session.createQuery(hql);
//		q.setParameter("classCode", classCode);
//		q.setParameter("name", value);
//		if(type.equals("age")) {
//			q.setParameter(1, Integer.parseInt(value));
//		} else {
//			q.setParameter(1, "'" + value + "'");
//		}
		String hql = "from Student as s where s.ownClass.classCode = " + classCode + " " + find(type, condition, value);
		System.out.println("hql:"+hql);
		Query q = session.createQuery(hql);
		
//		SQLQuery query = session.createSQLQuery(hql);
//		query.addEntity(Student.class);
		List<Student> result = q.list();
//		t.commit();
		session.close();
		return result;
	}
//	
//	public static void main(String[] args){
//		Session session=HibernateUtils.getSession();
//		Query query=session.createQuery("from Student as s where s.ownClass.classCode = '116030803' and s.stuName = '����'");
//		List<Student> students=query.list();
//		System.out.println(students.size());
//	}
	
	//ɾ��ѧ��
	public void deleteStu(String stuId) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		Student delStudetn = (Student)session.load(Student.class, stuId);
		session.delete(delStudetn);
		t.commit();
		session.close();
	}
	
	//�༭ѧ����Ϣ
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

	public void setStudents(List<Student> newStudent) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		for(int i = 0; i < newStudent.size(); i++) {
			Student student = newStudent.get(i);
			String sql = "insert into student(stuID, stuName, stuAge, classCode) "
					+ "values('"+student.getStuId()+"','"+student.getStuName()+"','"+student.getStuAge()+"','"+student.getOwnClass().getClassCode()+"')";
			Query q = session.createSQLQuery(sql);
			q.executeUpdate();
		}
//		
//		int result = q.executeUpdate();
//		if(result > 0) {
//			System.out.println("�����ɹ�");
//		}
		t.commit();
		session.close();
	}
}
