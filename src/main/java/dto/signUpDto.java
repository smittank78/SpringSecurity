package dto;

public class signUpDto 
{
	private String UserName;
	private String Password;
	private String Role;
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	@Override
	public String toString() {
		return "signUpDto [UserName=" + UserName + ", Password=" + Password + ", Role=" + Role + "]";
	}
}