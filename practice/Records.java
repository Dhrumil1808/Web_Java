package cs1220.practice;

public class Records {

	String fname,lname,task,date;
	public Records(String fname,String lname, String task,String date)
	{
	
		this.fname=fname;
		this.lname=lname;
		this.task=task;
		this.date=date;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
