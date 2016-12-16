package cs1220.database;

public class log {

	public int id;
	public String user,pass;
	
	public log(int id, String user, String pass)
	{
		this.id=id;
		this.user=user;
		this.pass=pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
