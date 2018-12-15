package service;

import java.util.List;

import model.MyClass;

public interface ClassService {
	public List<MyClass> queryClass() throws Exception;
	public List<MyClass> queryClassByCondition(String classId);
}
