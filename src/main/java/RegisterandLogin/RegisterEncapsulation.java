package RegisterandLogin;

public class RegisterEncapsulation {
	private String Firstname;
	private String Lastname;
	private String email;
	private String password;
	

	public RegisterEncapsulation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RegisterEncapsulation(String firstname, String lastname, String email, String password) {
		super();
		Firstname = firstname;
		Lastname = lastname;
		this.email = email;
		this.password = password;
	}


	public String getFirstname() {
		return Firstname;
	}


	public void setFirstname(String firstname) {
		Firstname = firstname;
	}


	public String getLastname() {
		return Lastname;
	}


	public void setLastname(String lastname) {
		Lastname = lastname;
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
