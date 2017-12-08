import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

/**
 * Defines a GUI that displays details of a FitnessProgram object
 * and contains buttons enabling access to the required functionality.
 */
public class SportsCentreGUI extends JFrame implements ActionListener {
	
	/** GUI JButtons */
	private JButton closeButton, attendanceButton;
	private JButton addButton, deleteButton;

	/** GUI JTextFields */
	private JTextField idIn, classIn, tutorIn;

	/** Display of class timetable */
	private JTextArea display;

	/** Display of attendance information */
	private ReportFrame report;

	/** Names of input text files */
	private final String classesInFile = "ClassesIn.txt";
	private final String classesOutFile = "ClassesOut.txt";
	private final String attendancesFile = "AttendancesIn.txt";
	
	private FitnessProgram fitnessProg; //FitnessProgram object
	private FitnessClass [] fitnessClass; //array of Fitness Classes
	private FitnessClass fc;

	/**
	 * Constructor for AssEx3GUI class
	 */
	public SportsCentreGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Boyd-Orr Sports Centre");
		setSize(700, 300);
		display = new JTextArea();
		display.setFont(new Font("Courier", Font.PLAIN, 14));
		add(display, BorderLayout.CENTER);
		layoutTop();
		layoutBottom();
		
		initLadiesDay(); //calls method which reads data from ClassesIn file
		initAttendances(); //calls method which reads data from AttendancesIn file
		

	}

	/**
	 * Creates the FitnessProgram list ordered by start time
	 * using data from the file ClassesIn.txt
	 */
	public void initLadiesDay() {
	    // your code here
		
		FileReader classesReader = null;
		try	{
			try {
			classesReader = new FileReader(classesInFile);
			Scanner classesScanner = new Scanner(classesReader);
			fitnessProg = new FitnessProgram();
			
			while (classesScanner.hasNextLine() ) {
				String classLine = classesScanner.nextLine();
				fc = new FitnessClass(classLine);
				fitnessProg.addFitnessClass(fc);
			}
			
			updateDisplay(fitnessProg);
			
			}
			finally {

				if (classesReader != null) {
					classesReader.close();
					}
				}
			}
		
			catch (IOException ioe) {
				JOptionPane.showMessageDialog(null, "File not found",
						"Error", JOptionPane.ERROR_MESSAGE);

			}
			catch (InputMismatchException e) {
				JOptionPane.showMessageDialog(null, "Invalid file content",
						"Error", JOptionPane.ERROR_MESSAGE);
			}	
	}

	/**
	 * Initialises the attendances using data
	 * from the file AttendancesIn.txt
	 */
	public void initAttendances() {
		
		FileReader attendancesReader = null;
		try	{
			try {
				attendancesReader = new FileReader(attendancesFile);
				Scanner attendancesScanner = new Scanner(attendancesReader);

				while (attendancesScanner.hasNextLine() ) {
					String attendancesLine = attendancesScanner.nextLine();
					String [] attendanceTokens = attendancesLine.split("\\s+");
					String currentClassID = attendanceTokens[0];

					fc = fitnessProg.getFitnessClassWithID(currentClassID);
					int attendance1 = Integer.parseInt(attendanceTokens[1]);
					int attendance2 = Integer.parseInt(attendanceTokens[2]);
					int attendance3 = Integer.parseInt(attendanceTokens[3]);
					int attendance4 = Integer.parseInt(attendanceTokens[4]);
					int attendance5 = Integer.parseInt(attendanceTokens[5]);
					int [] passAttendances = {attendance1, attendance2, attendance3, attendance4, attendance5};
					fc.setAttendanceRecords(passAttendances);
				}
				
			}
			finally {

				if (attendancesReader != null) {
					attendancesReader.close();
					}
				}
			}

		catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "File not found",
					"Error", JOptionPane.ERROR_MESSAGE);

		}
		catch (InputMismatchException e) {
			JOptionPane.showMessageDialog(null, "Invalid file content",
					"Error", JOptionPane.ERROR_MESSAGE);
		}	
	}

	/**
	 * Instantiates timetable display and adds it to GUI
	 */
	public void updateDisplay(FitnessProgram fitnessProg) {

		display.setText("");
		String sTime = "";
		String cName = "";
		String tName = "";
		int start = 0;
		StringBuilder startTimes = new StringBuilder(sTime);
		StringBuilder classNames = new StringBuilder(cName);
		StringBuilder tutorNames = new StringBuilder(tName);

		fitnessClass = fitnessProg.allFClasses();
		int i;
		for (i = 0; i < fitnessClass.length; i++)	{

			if (fitnessClass[i] == null) {
				start = i+9;
				cName = "Available";
				tName = "";
			}

			else {
				start = fitnessClass[i].getStartTime();
				cName = fitnessClass[i].getClassName();
				tName = fitnessClass[i].getTutorName();

			}
			sTime = String.format("%7d - %d", start, start+1);
			cName = String.format("%12s", cName);
			tName = String.format("%12s", tName);
			startTimes.append(sTime);
			classNames.append(cName);
			tutorNames.append(tName);
		}

		display.append(startTimes.toString() + "\n");
		display.append(classNames.toString() + "\n");
		display.append(tutorNames.toString() + "\n");
	}

	/**
	 * adds buttons to top of GUI
	 */
	public void layoutTop() {
		JPanel top = new JPanel();
		closeButton = new JButton("Save and Exit");
		closeButton.addActionListener(this);
		top.add(closeButton);
		attendanceButton = new JButton("View Attendances");
		attendanceButton.addActionListener(this);
		top.add(attendanceButton);
		add(top, BorderLayout.NORTH);
	}

	/**
	 * adds labels, text fields and buttons to bottom of GUI
	 */
	public void layoutBottom() {
		// instantiate panel for bottom of display
		JPanel bottom = new JPanel(new GridLayout(3, 3));

		// add upper label, text field and button
		JLabel idLabel = new JLabel("Enter Class Id");
		bottom.add(idLabel);
		idIn = new JTextField();
		bottom.add(idIn);
		JPanel panel1 = new JPanel();
		addButton = new JButton("Add");
		addButton.addActionListener(this);
		panel1.add(addButton);
		bottom.add(panel1);

		// add middle label, text field and button
		JLabel nmeLabel = new JLabel("Enter Class Name");
		bottom.add(nmeLabel);
		classIn = new JTextField();
		bottom.add(classIn);
		JPanel panel2 = new JPanel();
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(this);
		panel2.add(deleteButton);
		bottom.add(panel2);

		// add lower label text field and button
		JLabel tutLabel = new JLabel("Enter Tutor Name");
		bottom.add(tutLabel);
		tutorIn = new JTextField();
		bottom.add(tutorIn);

		add(bottom, BorderLayout.SOUTH);
	}

	/**
	 * Processes adding a class
	 */
	public void processAdding() {
		
		String iD = idIn.getText();
		String clName = classIn.getText();
		String tutName = tutorIn.getText();

		if (tutName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter a tutor name",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (clName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter a class name",
					"Error", JOptionPane.ERROR_MESSAGE);
		}

		else {

			int full = fitnessProg.getFirstAvailableClassTime();

			if (full == 1) {
				JOptionPane.showMessageDialog(null, "There are no available class times",
						"Error", JOptionPane.ERROR_MESSAGE);
			}

			else {

				fc = fitnessProg.getFitnessClassWithID(iD);


				if (fc == null){

					int availableTime = fitnessProg.getFirstAvailableClassTime();
					FitnessClass newFC = new FitnessClass();
					newFC.setClassID(iD);
					newFC.setClassName(clName);
					newFC.setStartTime(availableTime);
					newFC.setTutorName(tutName);
					int [] newAttRecords = {0,0,0,0,0};
					newFC.setAttendanceRecords(newAttRecords);
					fitnessProg.addFitnessClass(newFC);
				}
				else {
					JOptionPane.showMessageDialog(null, "There is already a class scheduled with this ID",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	/**
	 * Processes deleting a class
	 */
	public void processDeletion() {

		String iD = idIn.getText();

		fc = fitnessProg.getFitnessClassWithID(iD);

		if (fc != null) {
			
			int startTime = fc.getStartTime();
			FitnessClass newFC = new FitnessClass();
			newFC.setStartTime(startTime);
			newFC.setClassName("Available");
			newFC.setTutorName("");
			fitnessProg.addFitnessClass(newFC);
		}
		else {
			JOptionPane.showMessageDialog(null, "There is no scheduled class with this ID",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Instantiates a new window and displays the attendance report
	 */
	public void displayReport() {
		report = new ReportFrame(fitnessProg);
		report.buildReport();
		report.setVisible(true);
	}

	/**
	 * Writes lines to file representing class name, 
	 * tutor and start time and then exits from the program
	 */
	public void processSaveAndClose() {

		PrintWriter writer = null;
		try {
			try {
				writer = new PrintWriter(classesOutFile);

				int i = 0;
				for (FitnessClass fc: fitnessClass) {

					if (fc == null) {
						i++;
					}

					else {
						String fileOutput = fc.toStringClassesOut();
						writer.print(fileOutput);
					}
					
				}
			}
			finally {

				if (writer != null) {
					writer.close();
					System.exit(0);
				}
			} 	
		}
		catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "File not found",
					"Error", JOptionPane.ERROR_MESSAGE);

		}				

	}

	/**
	 * Process button clicks.
	 * @param ae the ActionEvent
	 */
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == attendanceButton) {
			displayReport();
		}
		else if (ae.getSource() == addButton) {
			processAdding();
			updateDisplay(fitnessProg);
		}
		else if (ae.getSource() == deleteButton) {
			processDeletion();
			updateDisplay(fitnessProg);
		}
		else if (ae.getSource() == closeButton) {
			processSaveAndClose();
		}
	}
	
}

		
	
