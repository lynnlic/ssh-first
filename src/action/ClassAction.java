package action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import service.ClassService;

import com.opensymphony.xwork2.ActionSupport;

public class ClassAction extends ActionSupport{
	List<Class> classes = new ArrayList<Class>();
	String condition = "";
	
	static ClassService service;
	static {
		service = new ClassService();
		try {
			service.queryClass();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}
	
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String execute() {
		classes = service.getClasses();
		return SUCCESS;
	}
}
