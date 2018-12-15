package model;

import java.util.HashSet;
import java.util.Set;

/**
 * Class entity. @author MyEclipse Persistence Tools
 */

public class MyClass implements java.io.Serializable {

	// Fields

	private String classCode;
	private String className;
	private Integer number;
	private Set<Student> students = new HashSet<Student>();
	
	// Constructors

	/** default constructor */
	public MyClass() {
	}

	/** full constructor */
	public MyClass(String className, Integer number) {
		this.className = className;
		this.number = number;
	}

	// Property accessors

//	public String getClassId() {
//		return this.classId;
//	}
//
//	public void setClassId(String classId) {
//		this.classId = classId;
//	}

	
	public String getClassName() {
		return this.className;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}