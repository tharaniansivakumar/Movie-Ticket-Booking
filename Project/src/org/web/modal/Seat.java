package org.web.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mtb_seat")
public class Seat {
	
	@Id
	@Column(name = "seat_id", length = 12, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seat_id;
	
	@Column(name="seatno",length=50,nullable=false)
	private String seatNo;

	@Column(name="noofseat",length=15,nullable=false)
	private int noOfSeat;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="email")
	private Customer customer;

	

	public int getSeat_id() {
		return seat_id;
	}


	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
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


	public String getSeatNo() {
		return seatNo;
	}
	

}
