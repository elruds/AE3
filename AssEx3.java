/** This program retrieves information about fitness classes (time of class, class name and 
 * tutor name) from a file ("ClassesIn.txt") and displays it as a timetable in a GUI.  If there is no class 
 * scheduled at a particular time, the time slot is shown as "Available".  The user can schedule
 * a class in an "Available" time slot by entering class time, class name and tutor name in
 * the text fields and clicking "Add".  Alternatively they can remove a scheduled class by 
 * entering the same information and clicking "Delete".
 * 
 *
 * The program retrieves attendance figures for these classes from a different file("AttendancesIn.txt").  By clicking "View
 * attendances" the user is able to view an attendance report which is displayed in a separate
 * window.  This contains a table showing the fitness class ID, class name, tutor name, 
 * attendance figures for five weeks, average attendance for each class over the five weeks 
 * and overall average attendance over the five weeks.
 * 
 * When the user clicks "Save and Exit", a file called "ClassesOut.txt" is created which contains 
 * information (class ID, class name, tutor name and class start time) about the classes in the
 * timetable.
 * 
 * 
 * */
 
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.*;


/**
 * The main class
 */
public class AssEx3 {
	/**
	 * The main method
	 * @param args the arguments
	 */

	public static void main(String[] args) {
		SportsCentreGUI display = new SportsCentreGUI(); 
		display.setVisible(true);
		
	}
}







		
		
		
		
		

			
