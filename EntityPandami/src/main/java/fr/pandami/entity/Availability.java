package fr.pandami.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
	private String dayOfTheWeek;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private LocalDateTime validityStartLocalDateTime;
	private LocalDateTime validityEndLocalDateTime;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private User user;
	
	
	public Availability() {
		super();
	}
	public Availability(Integer id, String dayOfTheWeek, LocalDateTime startTime, LocalDateTime endTime, LocalDateTime validityStartLocalDateTime,
			LocalDateTime validityEndLocalDateTime) {
		super();
		this.id = id;
		this.dayOfTheWeek = dayOfTheWeek;
		
		this.startTime = startTime;
		this.endTime = endTime;
		this.validityStartLocalDateTime = validityStartLocalDateTime;
		this.validityEndLocalDateTime = validityEndLocalDateTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}
	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public LocalDateTime getValidityStartLocalDateTime() {
		return validityStartLocalDateTime;
	}
	public void setValidityStartLocalDateTime(LocalDateTime validityStartLocalDateTime) {
		this.validityStartLocalDateTime = validityStartLocalDateTime;
	}
	public LocalDateTime getValidityEndLocalDateTime() {
		return validityEndLocalDateTime;
	}
	public void setValidityEndLocalDateTime(LocalDateTime validityEndLocalDateTime) {
		this.validityEndLocalDateTime = validityEndLocalDateTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dayOfTheWeek == null) ? 0 : dayOfTheWeek.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((validityEndLocalDateTime == null) ? 0 : validityEndLocalDateTime.hashCode());
		result = prime * result + ((validityStartLocalDateTime == null) ? 0 : validityStartLocalDateTime.hashCode());
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
		if (validityEndLocalDateTime == null) {
			if (other.validityEndLocalDateTime != null)
				return false;
		} else if (!validityEndLocalDateTime.equals(other.validityEndLocalDateTime))
			return false;
		if (validityStartLocalDateTime == null) {
			if (other.validityStartLocalDateTime != null)
				return false;
		} else if (!validityStartLocalDateTime.equals(other.validityStartLocalDateTime))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Availability [id=" + id + ", dayOfTheWeek=" + dayOfTheWeek + ", startTime=" + startTime + ", endTime="
				+ endTime + ", validityStartLocalDateTime=" + validityStartLocalDateTime + ", validityEndLocalDateTime=" + validityEndLocalDateTime + "]";
	}
	
	
	
	
	
}
