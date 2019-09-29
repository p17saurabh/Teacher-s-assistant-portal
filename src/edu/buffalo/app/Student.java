package edu.buffalo.app;

import java.util.Date;

/**
 * @author Saurabh pansare
 *
 */

public class Student {

	private String name;
	private String email;
	private Date bannedDate;

	/**
	 * @param name
	 * @param email
	 */
	public Student(String name, String email) {
		
		this.name = name;
		this.email = email;
	}

	/**
	 * @return String
	 */
	protected String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * @return String
	 */
	protected String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	protected void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Date
	 */
	protected Date getBannedDate() {
		return bannedDate;
	}

	/**
	 * @param bannedDate
	 */
	protected void setBannedDate(Date bannedDate) {
		this.bannedDate = bannedDate;
	}

}
