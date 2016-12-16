package cs1220.finals;

public class Movies {

	String moviename,days,available;
	int id,gold,platinum,silver;
	
	public Movies(int id, String days,String moviename,String available,int silver,int gold,int platinum)
	{
		this.id=id;
		this.days=days;
		this.moviename=moviename;
		this.available=available;
		this.gold=gold;
		this.silver=silver;
		this.platinum=platinum;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getPlatinum() {
		return platinum;
	}

	public void setPlatinum(int platinum) {
		this.platinum = platinum;
	}

	public int getSilver() {
		return silver;
	}

	public void setSilver(int silver) {
		this.silver = silver;
	}
	
}
