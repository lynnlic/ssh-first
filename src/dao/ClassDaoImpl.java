package dao;

import java.util.ArrayList;
import java.util.List;

import model.MyClass;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import utils.HibernateUtils;

//@Repository("classDao")
public class ClassDaoImpl implements ClassDao{
	
	public List<MyClass> queryClass() throws Exception {
		List<MyClass> classes = new ArrayList<MyClass>();
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		String hql = "from MyClass";
		Query query = session.createQuery(hql);
		List<MyClass> list = query.list();
		classes.addAll(list);
		t.commit();
		session.close();
		return classes;
	}
	
	public List<MyClass> queryClassByCondition(String classId) {
		List<MyClass> classes = new ArrayList<MyClass>();
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		String hql = "from Class where className=:className";
		Query query = session.createQuery(hql);
		query.setParameter("className", classId);
		List<MyClass> list = query.list();
		classes.addAll(list);
		t.commit();
		session.close();
		return classes;
	}
}
