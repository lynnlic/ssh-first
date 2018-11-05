package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import utils.HibernateUtils;

public class ClassService {
	List<Class> classes = new ArrayList<Class>();

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}
	
	public void queryClass() throws Exception {	
		classes.clear();
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		String hql = "from Class";
		Query query = session.createQuery(hql);
		List<Class> list = query.list();
		classes.addAll(list);
		t.commit();
		session.close();
	}
	
	public void queryClassByCondition(String classId) {
		classes.clear();
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		String hql = "from Class where className=:className";
		Query query = session.createQuery(hql);
		query.setParameter("className", classId);
		List<Class> list = query.list();
		classes.addAll(list);
		t.commit();
		session.close();
	}
}
