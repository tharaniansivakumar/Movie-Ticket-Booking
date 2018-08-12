package org.web.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="mtb_seatadmin")
public class SeatCheck {

		@Id
		@Column(name="Id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		
		private int seatid;
		@Column(name="date")
		private String date;

		@Column(name="time")
		private String time;
	
		@Column(name="seatno")
		private String seatno;
		
		@Column(name="user")
		private String customer;
		
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getSeatno() {
			return seatno;
		}
		public void setSeatno(String seatno) {
			this.seatno = seatno;
		}
		public int getSeatid() {
			return seatid;
		}
		public void setSeatid(int seatid) {
			this.seatid = seatid;
		}
		public String getCustomer() {
			return customer;
		}
		public void setCustomer(String customer) {
			this.customer = customer;
		}
		
	}
