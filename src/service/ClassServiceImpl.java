package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import model.MyClass;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import dao.ClassDao;
import utils.HibernateUtils;

//@Service("classService")
public class ClassServiceImpl implements ClassService{	
	List<MyClass> classes = new ArrayList<MyClass>();
//	@Resource(name="classDao")
	private ClassDao classDao;

	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}
	
	public List<MyClass> queryClass() throws Exception {	
		return classDao.queryClass();
	}
	
	public List<MyClass> queryClassByCondition(String classId) {
		return classDao.queryClassByCondition(classId);
	}
}
