import java.awt.*;
import javax.swing.*;

/**
 * Class to define window in which attendance report is displayed.
 */
public class ReportFrame extends JFrame {
	
	/** display of attendance report */
	private JTextArea displayReport;
	private FitnessProgram fitnessP;

	public ReportFrame(FitnessProgram fitP) {

		this.fitnessP = fitP;
		setTitle("Attendance Report");
		setSize(700, 300);
		displayReport = new JTextArea();
		displayReport.setFont(new Font("Courier", Font.PLAIN, 14));
		add(displayReport, BorderLayout.CENTER);

	}

	public void buildReport()	{
		
		String idHead = "ID";
		String classHead = "Class";
		String tutorHead = "Tutor";
		String attendancesHead = "Attendances";
		String averageAttendanceHead = "Average Attendance";
		String columnHeadings = String.format("%5s %15s %15s %20s %20s\n", idHead, classHead, tutorHead, attendancesHead, averageAttendanceHead);
		String separator = "=====================================================================================";
		
		displayReport.append(columnHeadings);
		displayReport.append(separator);
		displayReport.append("\n "+ fitnessP.sortFitnessClassesDescAttendance());
		displayReport.append("\nOverall average: " + fitnessP.overallAverageAttendance());
		
	}
}



		
		
		
		
		
		
		
		
		
		
		
