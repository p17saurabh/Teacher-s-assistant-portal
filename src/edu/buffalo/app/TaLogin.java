package edu.buffalo.app;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Saurabh pansare
 *
 */
public class TaLogin {

	AppointmentGenerator appointmentGenerator;
	List<Appointment> appointmentQueue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new TaLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public TaLogin() {
		appointmentGenerator = new AppointmentGenerator();
		appointmentQueue = appointmentGenerator.generateRandomAppointments();

		initializeReport();

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void initializeReport() {
		if (appointmentQueue.size() == 0) {
			initializeAlert();
		} else {
			JFrame frame;
			frame = new JFrame();
			frame.setVisible(true);
			frame.setBounds(100, 100, 1281, 756);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.DARK_GRAY);

			JLabel lblTaPortal = new JLabel("TA PORTAL");
			lblTaPortal.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			lblTaPortal.setForeground(Color.LIGHT_GRAY);
			lblTaPortal.setBounds(441, 13, 196, 61);
			frame.getContentPane().add(lblTaPortal);
			
			JLabel lblStudentName = new JLabel("Student Name");
			lblStudentName.setForeground(Color.WHITE);
			lblStudentName.setBounds(61, 100, 370, 57);
			lblStudentName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			frame.getContentPane().add(lblStudentName);


			JLabel lblStudentEmail = new JLabel("Student email : -");
			lblStudentEmail.setForeground(Color.WHITE);
			lblStudentEmail.setBounds(61, 161, 210, 38);
			lblStudentEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			frame.getContentPane().add(lblStudentEmail);

			JLabel lblQuestions = new JLabel("Questions : -");
			lblQuestions.setForeground(Color.WHITE);
			lblQuestions.setBounds(61, 222, 210, 38);
			lblQuestions.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			frame.getContentPane().add(lblQuestions);
			
			
			
			
			JLabel studentNameLbl = new JLabel(appointmentGenerator.getQueueHead().getStudent().getName());
			studentNameLbl.setForeground(Color.WHITE);
			studentNameLbl.setBounds(528, 100, 350, 28);
			studentNameLbl.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
			frame.getContentPane().add(studentNameLbl);

			
			JLabel emailLabel = new JLabel(appointmentGenerator.getQueueHead().getStudent().getEmail());
			emailLabel.setForeground(Color.WHITE);
			emailLabel.setBounds(528, 161, 350, 28);
			emailLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
			frame.getContentPane().add(emailLabel);

			JLabel questionLabel = new JLabel(appointmentGenerator.getQueueHead().getQuestion());
			questionLabel.setForeground(Color.WHITE);
			questionLabel.setBounds(528, 222, 376, 27);
			questionLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
			frame.getContentPane().add(questionLabel);

			

			JButton btnPresent = new JButton("Present");
			btnPresent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (appointmentGenerator.studentPresent()) {
						initializeQueue();
						frame.dispose();
					}

				}
			});
			btnPresent.setBounds(500, 510, 237, 48);
			btnPresent.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			btnPresent.setForeground(Color.DARK_GRAY);
			btnPresent.setBackground(Color.WHITE);
			frame.getContentPane().add(btnPresent);

			JButton btnAbsent = new JButton("Absent");
			btnAbsent.setBounds(139, 510, 213, 48);
			btnAbsent.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			btnAbsent.setForeground(Color.DARK_GRAY);
			btnAbsent.setBackground(Color.WHITE);
			frame.getContentPane().add(btnAbsent);
			btnAbsent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					 appointmentGenerator.studentAbsent();

					
					appointmentQueue = appointmentGenerator.getAppointments();

					frame.getContentPane().revalidate();
					frame.getContentPane().repaint();

					if (appointmentQueue.size() == 0) {
						frame.setVisible(false);
						initializeAlert();
					} else {
						initializeQueue();
						studentNameLbl.setText(appointmentGenerator.getQueueHead().getStudent().getName());
						emailLabel.setText(appointmentGenerator.getQueueHead().getStudent().getEmail());
						questionLabel.setText(appointmentGenerator.getQueueHead().getQuestion());
					}

				}
			});

		}
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initializeAlert() {

		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 1281, 756);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();

		frame.setBounds(100, 100, 1281, 756);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblQPortal = new JLabel("Queue status");
		lblQPortal.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblQPortal.setForeground(Color.LIGHT_GRAY);
		lblQPortal.setBounds(441, 13, 196, 61);
		frame.getContentPane().add(lblQPortal);


		JLabel altert = new JLabel("No appointments present at this time , please check again later !!");
		altert.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		altert.setForeground(Color.WHITE);
		altert.setBounds(78, 73, 976, 527);
		frame.getContentPane().add(altert);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();

			}
		});
		btnExit.setBounds(100, 510, 237, 48);
		btnExit.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnExit.setForeground(Color.DARK_GRAY);
		btnExit.setBackground(Color.WHITE);
		frame.getContentPane().add(btnExit);

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initializeQueue() {

		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 1281, 756);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();

		frame.setBounds(100, 100, 1281, 756);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblQPortal = new JLabel("Queue status");
		lblQPortal.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblQPortal.setForeground(Color.LIGHT_GRAY);
		lblQPortal.setBounds(441, 13, 196, 61);
		frame.getContentPane().add(lblQPortal);

		StringBuilder queueValue = new StringBuilder();

		if (appointmentQueue.size() == 0) {
			queueValue.append("Queue empty !!");
		} else {
			for (int i = 0; i < appointmentQueue.size(); i++) {
				queueValue.append("\n" + appointmentQueue.get(i).getStudent().getName()).append("..");
			}
		}

		JLabel queueDetails = new JLabel(queueValue.toString());
		queueDetails.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		queueDetails.setForeground(Color.WHITE);
		queueDetails.setBounds(78, 73, 1076, 527);
		frame.getContentPane().add(queueDetails);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();

			}
		});
		btnExit.setBounds(100, 510, 237, 48);
		btnExit.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnExit.setForeground(Color.DARK_GRAY);
		btnExit.setBackground(Color.WHITE);
		frame.getContentPane().add(btnExit);

	}
}
