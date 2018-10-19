package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import service.FileUploadService;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private File file;// 提交过来的文件
	private String fileFileName;// 提交过来的file名字
	private String fileContentType;// 提交过来的文件的类型

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String execute() throws Exception {
		FileUploadService service = new FileUploadService();
		InputStream is = new FileInputStream(file);
		String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
		File toFile = new File(uploadPath, this.getFileFileName());
		OutputStream os = new FileOutputStream(toFile);
		byte[] buffer = new byte[1024];
		String str = "";
		int length = 0;
		while(-1 != (length = is.read(buffer, 0, buffer.length))) {
			str += new String(buffer, "GBK");
			os.write(buffer);
		}
		service.strToinfo(str);
		service.addStudent();
		System.out.println(str);
		is.close();
		os.close();
		return SUCCESS;
	}
}
