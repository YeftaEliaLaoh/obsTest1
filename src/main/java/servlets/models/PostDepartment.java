package servlets.models;

import java.util.List;

public class PostDepartment {
	String department;
	List<PostData> postData;
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<PostData> getPostData() {
		return postData;
	}
	public void setPostData(List<PostData> postData) {
		this.postData = postData;
	}
	
}
