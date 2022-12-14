package dto;

public class ChangePassword {

	private String oldPassword;

	private String newPassword;

	private String confirmedPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

	@Override
	public String toString() {
		return "ChangePassword [oldPassword=" + oldPassword + ", newPassword=" + newPassword + ", confirmedPassword="
				+ confirmedPassword + "]";
	}
	
	
}