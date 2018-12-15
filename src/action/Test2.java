package action;

import model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ClassService;
import service.StudentService;

public class Test2 {
	public static void main(String[] args) throws Exception {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		ClassService classService = (ClassService)applicationContext.getBean("classService");
		classService.queryClass();
		ClassAction classAction = (ClassAction)applicationContext.getBean("classAction");
		classAction.getClassService().queryClass();
	}
	
//	@Test
//	public void findByIdTest() {
//		Configuration config = new Configuration().configure();
//		SessionFactory sessionFactory = config.buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction t = session.beginTransaction();	
//		Student s = (Student)session.get(Student.class, "001");
//		System.out.println(s.getStuName());
//		t.commit();
//		session.close();
//		sessionFactory.close();
//	}
//	
	@Test
	public void demo() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		StudentAction studentAction = (StudentAction)applicationContext.getBean("studentAction");
		StudentService studentService = (StudentService)applicationContext.getBean("studentServiceImpl");
		System.out.println(studentAction+"!!");
		System.out.println(studentService);
	}
}
 