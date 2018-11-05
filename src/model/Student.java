package model;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String stuId;
	private String stuName;
	private Integer stuAge;
	private Class ownClass;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String stuName, Integer stuAge) {
		this.stuName = stuName;
		this.stuAge = stuAge;
	}

	// Property accessors

	public String getStuId() {
		return this.stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Integer getStuAge() {
		return this.stuAge;
	}

	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}

	public Class getOwnClass() {
		return ownClass;
	}

	public void setOwnClass(Class ownClass) {
		this.ownClass = ownClass;
	}
}