package org.web.modal;


import javax.persistence.*;

@Entity
@Table(name = "mtb_shows")
public class Show {

	@Id
	@Column(name = "show_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int showId;

	@Column(name = "date", length = 32, nullable = false)
	private String date;

	@Column(name = "showtime", length = 22, nullable = false)
	private String showTime;

	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="email")
	private Customer customer;



	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

}
