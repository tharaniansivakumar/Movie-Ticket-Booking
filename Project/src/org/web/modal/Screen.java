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
@Table(name="mtb_screen")
public class Screen {
	
	@Id
	@Column(name = "Movie_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	
	@Column(name = "screen_no", length = 12, nullable = false)
	private String screenNo;
	
	@Column(name="movie_name",length=12,nullable=false)
	private String movieName;
	
	@Column(name="url",length=30,nullable=false)
	private String url;
	
	@Column(name="director",length=12,nullable=false)
	private String director;
	
	@Column(name = "first_class", length = 32, nullable = false)
	private int firstClass;
	
	@Column(name = "second_class", length = 32, nullable = false)
	private int secondClass;
	
	@Column(name = "third_class", length = 32, nullable = false)
	private int thirdClass;

	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="email")
	private Customer customer;

	
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getFirstClass() {
		return firstClass;
	}

	public void setFirstClass(int firstClass) {
		this.firstClass = firstClass;
	}

	public int getSecondClass() {
		return secondClass;
	}

	public void setSecondClass(int secondClass) {
		this.secondClass = secondClass;
	}

	public int getThirdClass() {
		return thirdClass;
	}

	public void setThirdClass(int thirdClass) {
		this.thirdClass = thirdClass;
	}

	
	
	
	
}
