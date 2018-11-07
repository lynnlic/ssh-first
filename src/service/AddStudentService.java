package service;

import java.util.List;

import model.Student;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtils;

public class AddStudentService {
	
	//����ѧ��
	public void addStudent(Student student) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		String sql = "insert into student(stuID, stuName, stuAge, classId) "
				+ "values('"+student.getStuId()+"','"+student.getStuName()+"','"+student.getStuAge()+"','"+student.getOwnClass().getClassId()+"')";
		Query q = session.createSQLQuery(sql);
		int result = q.executeUpdate();
		if(result > 0) {
			System.out.println("�����ɹ�");
		}
		t.commit();
		session.close();
	}
}
