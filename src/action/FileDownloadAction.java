package action;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import model.Student;
import service.StudentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class FileDownloadAction extends ActionSupport{
	private String fileName;
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() {
		try {
			fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String execute() throws Exception {
		System.out.println(fileName+"----");//struts自动调用set方法
		StudentService studentService = new StudentService();		
		List<Student> students = studentService.getStudents();	
		path = ServletActionContext.getServletContext().getRealPath(path);
		File file = new File(path, fileName + ".txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
		BufferedWriter writer=new BufferedWriter(output);
		writer.write("学号\t姓名\t年龄\n");
		for(int i = 0; i < students.size(); i++) {
			Student temp = students.get(i);
			writer.write(temp.getStuID() + "\t" + temp.getStuName() + "\t" + temp.getStuAge() + "\n");
		}
		writer.close();		
		return SUCCESS;
	}
	
//	public InputStream getDownloadFile() throws Exception{
//		File file = new File(path, fileName);
//		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//		return inputStream;
//	}
	
	
}
