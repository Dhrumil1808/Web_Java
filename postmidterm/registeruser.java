package cs1220.postmidterm;

public class registeruser {

	private String firstname,lastname;
	private int grade;
     
	
	public registeruser(String firstname,String lastname, int grade)
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.grade=grade;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}

	
}
