
package edu.buffalo.app;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @author Saurabh pansare
 * reference - https://stackoverflow.com/questions/9043981/how-to-add-minutes-to-my-date/9044010
 * https://codippa.com/how-to-generate-a-random-number-with-in-a-range-in-java/
 */
public class Appointment {

	Student student;
	String question;
	Date time;
	int apponitmentId;

	/**
	 * @param appointmentId
	 * @param currentTime   Appointment Contructor , constructs the appointment
	 *                      object with randomly assigning the value of the
	 *                      appointment time to 5 or 11 mins before the current time
	 */
	public Appointment(int appointmentId, Calendar currentTime) {
		String studentemail = "student" + appointmentId + "@buffalo.edu";
		Student newStudent = new Student("Student_name" + appointmentId, studentemail);
		this.student = newStudent;
		this.question = "question " + appointmentId;
		Random r = new Random();
		int low = 1;
		int high = 10;
		int result = r.nextInt(high - low) + low;

		if (result > 5) {
			result = 11;
		} else {
			result = 5;
		}

		final long ONE_MINUTE_IN_MILLIS = 60000;// millisecs
		long t = currentTime.getTimeInMillis();

		this.time = new Date(t - (result * ONE_MINUTE_IN_MILLIS));

		this.apponitmentId = appointmentId;
	}

	/**
	 * @return
	 */
	protected Student getStudent() {
		return student;
	}

	/**
	 * @param student
	 */
	protected void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return
	 */
	protected String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 */
	protected void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return
	 */
	protected Date getTime() {
		return time;
	}

	/**
	 * @param time
	 */
	protected void setTime(Date time) {
		this.time = time;
	}

	/**
	 * @return
	 */
	protected int getApponitmentId() {
		return apponitmentId;
	}

	/**
	 * @param apponitmentId
	 */
	protected void setApponitmentId(int apponitmentId) {
		this.apponitmentId = apponitmentId;
	}

}
