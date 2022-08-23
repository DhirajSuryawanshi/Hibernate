package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Director {

	@Id
	private String directorID;
	private String directorName;
	private Integer bornIn;
	
	public Director(String directorID, String directorName, Integer bornIn) {
		super();
		this.directorID = directorID;
		this.directorName = directorName;
		this.bornIn = bornIn;
	}

	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDirectorID() {
		return directorID;
	}

	public void setDirectorID(String directorID) {
		this.directorID = directorID;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public Integer getBornIn() {
		return bornIn;
	}

	public void setBornIn(Integer bornIn) {
		this.bornIn = bornIn;
	}

	@Override
	public String toString() {
		return "Director [directorID=" + directorID + ", directorName=" + directorName + ", bornIn=" + bornIn + "]";
	}
	
}
