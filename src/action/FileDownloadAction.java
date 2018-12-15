package action;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import model.Student;
import service.FileUploadService;
import service.StudentServiceImpl;
import utils.ListToStr;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class FileDownloadAction extends ActionSupport{
	private String fileName;
	private String path;
	private String contentType;
	List<Student> students;

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

	public void setFileName(String fileName) throws UnsupportedEncodingException {
		fileName = new String(fileName.getBytes("iso8895-1"), "utf-8");
		this.fileName = fileName;
	}
	
	public String getContentType() {
		return ServletActionContext.getServletContext().getMimeType(fileName);
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String execute() throws Exception {		
		return SUCCESS;
	}
	
	public InputStream getDownloadFile() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		students = (List<Student>) session.getAttribute("downLoadStu");
		ActionContext.getContext();
		String str = ListToStr.listToStr(students);
		InputStream inputStream=new ByteArrayInputStream(str.getBytes("UTF-8"));
		return inputStream;
	}

}
