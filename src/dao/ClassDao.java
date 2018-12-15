package dao;

import java.util.List;

import model.MyClass;

public interface ClassDao {
	public List<MyClass> queryClass() throws Exception;
	public List<MyClass> queryClassByCondition(String classId);
}
