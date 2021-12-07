package utils;

public class UserInfoFromTable {

	private String firstAndSecondName;
	private String address;
	private String mobile;
	private String email;
	
	public UserInfoFromTable(String firstAndSecondName, String address, String email, String mobile) {
		
		this.firstAndSecondName = firstAndSecondName;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
	}

	public String getFirstAndSecondName() {
		return firstAndSecondName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public String getEmail() {
		return email;
	}

	
}
