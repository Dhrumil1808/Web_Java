package cs1220.homework3;

public class admin {

	private String name,image;
	private int seats_gold,seats_silver,seats_platinum;
	private double rating,gold,silver,platinum;
	
	public admin(String name,String image,double rating, double gold,int seats_gold, double silver,int seats_silver,double platinum,int seats_platinum)
	{
		this.name=name;
		this.image=image;
		this.rating=rating;
		this.gold=gold;
		this.seats_gold=seats_gold;
		this.silver=silver;
		this.seats_silver=seats_silver;
		this.seats_platinum=seats_platinum;
		this.platinum=platinum;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getSeats_gold() {
		return seats_gold;
	}

	public void setSeats_gold(int seats_gold) {
		this.seats_gold = seats_gold;
	}

	public int getSeats_silver() {
		return seats_silver;
	}

	public void setSeats_silver(int seats_silver) {
		this.seats_silver = seats_silver;
	}

	public int getSeats_platinum() {
		return seats_platinum;
	}

	public void setSeats_platinum(int seats_platinum) {
		this.seats_platinum = seats_platinum;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getGold() {
		return gold;
	}

	public void setGold(double gold) {
		this.gold = gold;
	}

	public double getSilver() {
		return silver;
	}

	public void setSilver(double silver) {
		this.silver = silver;
	}

	public double getPlatinum() {
		return platinum;
	}

	public void setPlatinum(double platinum) {
		this.platinum = platinum;
	}


	
}
