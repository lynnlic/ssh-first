package action;

import model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class Test2 {
	public static void main(String[] args) {
		
	}
	
	@Test
	public void findByIdTest() {
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();	
		Student s = (Student)session.get(Student.class, "001");
		System.out.println(s.getStuName());
		t.commit();
		session.close();
		sessionFactory.close();
	}
}
