package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final Configuration config;
	private static final SessionFactory sessionFactory;
	static {
		config = new Configuration().configure();
		sessionFactory = config.buildSessionFactory();
	}
	public static Session getSession() {
		return sessionFactory.openSession();
		
	}
}	
