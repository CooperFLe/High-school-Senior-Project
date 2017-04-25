
public class Login {
	private String user;
	private byte[] pass;
	private byte[] salt;
	
	public Login(String user, char[] pass)
	{
		this.setUser(user);
		
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public byte[] getPass() {
		return pass;
	}

	public void setPass(byte[] pass) {
		this.pass = pass;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
}
