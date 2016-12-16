package cs1220.Midterm;

import java.util.Date;

public class quotes {
	
	String quote,author;
	Date date;
	public 	quotes(String quote, String author, Date date)
	{
		this.quote=quote;
		this.author=author;
		this.date=date;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
