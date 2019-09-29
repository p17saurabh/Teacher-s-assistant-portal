package edu.buffalo.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * @author Saurabh pansare
 * reference - https://codippa.com/how-to-generate-a-random-number-with-in-a-range-in-java/
 */
public class AppointmentGenerator {

	List<Appointment> appointmentQueue;

	/**
	 * @return List<Appointment>
	 */
	public List<Appointment> getAppointments() {
		return appointmentQueue;
	}

	/**
	 * @param appointments
	 */
	public void setAppointments(List<Appointment> appointments) {
		this.appointmentQueue = appointments;
	}

	/**
	 * @return
	 * 
	 * Randomly generates  0 -4 appointments
	 */
	public List<Appointment> generateRandomAppointments() {

		appointmentQueue = new ArrayList<Appointment>();
		
		double randomDouble = Math.random();
		randomDouble = randomDouble * 6 - 1;
		int randomInt = (int) randomDouble;

		for (int i = 0; i < randomInt; i++) {

			Appointment appointment = new Appointment(i + 1, Calendar.getInstance());
			appointmentQueue.add(appointment);
		}

		return appointmentQueue;
	}

	/**
	 * @return
	 * removes the present student from the queue
	 */
	public boolean studentPresent() {

		appointmentQueue.remove(0);

		return true;
	}

	/**
	 * @return
	 * depending on current time decides if to ban the student or add it to the end of the queue
	 */
	public boolean studentAbsent() {
		boolean isBanned = false;
		final long TEN_MINUTE_IN_MILLIS = 600000;// millisecs
		Appointment headAppointment = appointmentQueue.remove(0);
		Date appointmentTime = headAppointment.getTime();
		Date currentTime = Calendar.getInstance().getTime();

		long difference = currentTime.getTime() - appointmentTime.getTime();

		if (difference > TEN_MINUTE_IN_MILLIS) {
			isBanned = true;
			headAppointment.getStudent().setBannedDate(currentTime);
		}

		else {
			appointmentQueue.add(headAppointment);
		}

		return isBanned;
	}
	
	
	/**
	 * @return Appointment
	 */
	public Appointment getQueueHead() {
		
		
		return appointmentQueue.get(0);
		
	}


}
