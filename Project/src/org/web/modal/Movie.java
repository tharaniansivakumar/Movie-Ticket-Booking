package org.web.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.web.modal.ScreenStatus;

@Entity
@Table(name = "mtb_movie")
public class Movie {
	@Id
	@Column(name = "movie_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	@Column(name = "movie_name", length = 32, nullable = false)
	private String movieName;
	@Column(name = "actor_name", length = 32, nullable = false)
	private String actorName;
	@Column(name = "actress_name", length = 32, nullable = false)
	private String actressName;
	@Column(name = "director", length = 32, nullable = false)
	private String directorName;
	@Column(name = "Release_date", length = 32, nullable = false)
	private String releaseDate;
	@Column(name = "Url", length = 100, nullable = false)
	private String Url;
	@Column(name = "first_class", length = 32, nullable = false)
	private int firstClass;
	@Column(name = "second_class", length = 32, nullable = false)
	private int secondClass;
	@Column(name = "third_class", length = 32, nullable = false)
	private int thirdClass;
	@Column(name="screenstatus")
	@Enumerated(EnumType.STRING)
	private ScreenStatus screen=ScreenStatus.SCREEN1;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActressName() {
		return actressName;
	}

	public void setActressName(String actressName) {
		this.actressName = actressName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public ScreenStatus getScreen() {
		return screen;
	}

	public void setScreen(ScreenStatus screen) {
		this.screen = screen;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
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
