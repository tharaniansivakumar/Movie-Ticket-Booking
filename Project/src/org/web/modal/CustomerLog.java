package org.web.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mtb_customerlog")
public class CustomerLog {

	@Id
	@Column(name="customer_id",length=10,nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	
	@Column(name = "email", length = 42, nullable = false)
	private String email;
	
	@Column(name = "screen_no", length = 12, nullable = false)
	private String screenNo;
	
	@Column(name="movie_name",length=12,nullable=false)
	private String movieName;
	
	@Column(name = "date", length = 32, nullable = false)
	private String date;

	@Column(name = "showtime", length = 22, nullable = false)
	private String showTime;


	@Column(name="seatno",length=50,nullable=false)
	private String seatNo;

	@Column(name="noofseat",length=15,nullable=false)
	private int noOfSeat;
	
	@Column(name = "ticket_price", length = 32, nullable = false)
	private int price;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(String screenNo) {
		this.screenNo = screenNo;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public int getNoOfSeat() {
		return noOfSeat;
	}

	public void setNoOfSeat(int noOfSeat) {
		this.noOfSeat = noOfSeat;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



}
