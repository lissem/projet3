package fr.pandami.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Availability implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer dayOfTheWeek;
	private String day;
	private LocalTime startTime;
	private LocalTime endTime;
	private LocalDate validityStartDate;
	private LocalDate validityEndDate;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private User user;
	
	
	public Availability() {
		super();
	}
	
	


	



	public Availability(Integer id, Integer dayOfTheWeek, String day, LocalTime startTime, LocalTime endTime,
			LocalDate validityStartDate, LocalDate validityEndDate, User user) {
		super();
		this.id = id;
		this.dayOfTheWeek = dayOfTheWeek;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.validityStartDate = validityStartDate;
		this.validityEndDate = validityEndDate;
		this.user = user;
	}








	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getDayOfTheWeek() {
		return dayOfTheWeek;
	}


	public void setDayOfTheWeek(Integer dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}


	public LocalTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}


	public LocalTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}


	public LocalDate getValidityStartDate() {
		return validityStartDate;
	}


	public void setValidityStartDate(LocalDate validityStartDate) {
		this.validityStartDate = validityStartDate;
	}


	public LocalDate getValidityEndDate() {
		return validityEndDate;
	}


	public void setValidityEndDate(LocalDate validityEndDate) {
		this.validityEndDate = validityEndDate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getDay() {
		return day;
	}




	public void setDay(String day) {
		this.day = day;
	}








	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((dayOfTheWeek == null) ? 0 : dayOfTheWeek.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((validityEndDate == null) ? 0 : validityEndDate.hashCode());
		result = prime * result + ((validityStartDate == null) ? 0 : validityStartDate.hashCode());
		return result;
	}








	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Availability other = (Availability) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (dayOfTheWeek == null) {
			if (other.dayOfTheWeek != null)
				return false;
		} else if (!dayOfTheWeek.equals(other.dayOfTheWeek))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (validityEndDate == null) {
			if (other.validityEndDate != null)
				return false;
		} else if (!validityEndDate.equals(other.validityEndDate))
			return false;
		if (validityStartDate == null) {
			if (other.validityStartDate != null)
				return false;
		} else if (!validityStartDate.equals(other.validityStartDate))
			return false;
		return true;
	}








	@Override
	public String toString() {
		return "Availability [id=" + id + ", dayOfTheWeek=" + dayOfTheWeek + ", day=" + day + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", validityStartDate=" + validityStartDate + ", validityEndDate="
				+ validityEndDate + ", user=" + user + "]";
	}
	
	
	
	
	
	
}
