package jdbc_library;

public class User {
	private int userid;
	private String name;
	private long phone;
	private String address;
	private String email;
	private String password;
	
	
	public  int getUserId() {
		return userid;
	}
	public void setUserId(int userid) {
		this.userid =userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}