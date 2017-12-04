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
		// more code needed here
	}

	/**
	 * Creates the FitnessProgram list ordered by start time
	 * using data from the file ClassesIn.txt
	 */
	public void initLadiesDay() {
	    // your code here
		
		FileReader reader = null;
		try	{
			try {
			reader = new FileReader(classesInFile);
			Scanner scan = new Scanner(reader);
			FitnessClass fc;
			FitnessProgram fp = new FitnessProgram();
			
			while (scan.hasNextLine() ) {
				String classLine = scan.nextLine();
				fc = new FitnessClass(classLine);
				fp.addFitnessClass(fc);
			}
			
			updateDisplay(fp);
			
			}
			finally {

				if (reader != null) {
					reader.close();
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
	    // your code here
	}

	/**
	 * Instantiates timetable display and adds it to GUI
	 */
	public void updateDisplay(FitnessProgram fP) {
		// your code here

		String sTime = "";
		String cName = "";
		String tName = "";
		int start = 0;
		StringBuilder startTimes = new StringBuilder(sTime);
		StringBuilder classNames = new StringBuilder(cName);
		StringBuilder tutorNames = new StringBuilder(tName);
		
		FitnessClass [] fitClass = fP.allFClasses();
		int i;
		for (i = 0; i < fitClass.length; i++)	{
			
			if (fitClass[i] == null) {
				start = i+9;
				cName = "Available";
				tName = "";
			}

			else {
				start = fitClass[i].getStartTime();
				cName = fitClass[i].getClassName();
				tName = fitClass[i].getTutorName();
			
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

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		FitnessClass [] fitClass = fP.allFClasses();
//		int i;
//		int start = 0;
//		String className = "";
//		boolean endOfLine = false;
//		for (i = 0; i < fitClass.length; i++)	{
//
//				
//			if (fitClass[i] == null) {
//				i++;
//			}
//			
//			else {
//				start = fitClass[i].getStartTime();
//				className = fitClass[i].getClassName();
//			}
//			
//			
//			if (i == fitClass.length-1) {
//				endOfLine = true;
//				String sTimeNL = String.format("%10d - %d\n", start, start+1);
//				String cNameNL = String.format("%15s\n", className);
//				display.append(sTimeNL);
////				display.append(cNameNL);
//			}
//
//			if (!endOfLine) {
//
//				String sTime = String.format("%10d - %d", start, start+1);
//				String cName = String.format("%15s", className);
//				display.append(sTime);
////				display.append(cName);
//				
//			}

		
		


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
	    // your code here
	}

	/**
	 * Processes deleting a class
	 */
	public void processDeletion() {
	    // your code here
	}

	/**
	 * Instantiates a new window and displays the attendance report
	 */
	public void displayReport() {
	    // your code here
	}

	/**
	 * Writes lines to file representing class name, 
	 * tutor and start time and then exits from the program
	 */
	public void processSaveAndClose() {
	    // your code here
	}

	/**
	 * Process button clicks.
	 * @param ae the ActionEvent
	 */
	public void actionPerformed(ActionEvent ae) {
	    // your code here
		initLadiesDay();
		
	}
}
		
		
	
