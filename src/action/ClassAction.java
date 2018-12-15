package action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import model.MyClass;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;

import service.ClassService;
import service.ClassServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

//@Controller("classAction")
public class ClassAction extends ActionSupport{
//	@Resource(name="classService")
	private ClassService classService;
	List<MyClass> classes = new ArrayList<MyClass>();
	String condition = "";
	
//	static ClassServiceImpl service;
//	public static ClassServiceImpl getService() {
//		return classService;
//	}

	public ClassService getClassService() {
		return classService;
	}

	public void setService(ClassServiceImpl service) {
		classService = service;
	}

	public void setClassService(ClassService classService) {
		this.classService = classService;
	}

//	static {
//		classService = new ClassServiceImpl();
//		try {
//			classService.queryClass();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public List<MyClass> getClasses() {
		return classes;
	}

	public void setClasses(List<MyClass> classes) {
		this.classes = classes;
	}
	
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String execute() throws Exception {
		classes = classService.queryClass();
		return SUCCESS;
	}
}
