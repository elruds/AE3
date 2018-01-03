/** Defines an object representing a single fitness class
 */
public class FitnessClass implements Comparable<FitnessClass> {
	
	/** Constant representing no. of weeks of recorded attendance */
	private final int WEEKS_RECORDED_ATTENDANCE = 5;
	
	private String classID;
	private String className;
	private String tutorName;
	private int startTime;
	
	/** Set of attendance records */
	private int [] attendanceRecords; 

	/** Default constructor */
	public FitnessClass()	{
	}
	
	/**
	 * Constructor which sets values of instance variables to String split into tokens
	 * @param classDetails String from file
	 */
	public FitnessClass(String classDetails)	{		
		String [] classTokens = classDetails.split(" ");
		
			classID = classTokens[0];				
			className = classTokens[1];
			tutorName = classTokens[2];
			startTime = Integer.parseInt(classTokens[3]);
		}
	
	/**Mutator methods to set values of instance variables
	 * 
	 * @param cID class ID
	 */

	public void setClassID(String cID) {		
		this.classID = cID;
	}
	
	/** @param cName class name */
	 
	public void setClassName(String cName) {
		this.className = cName;
	}

	/** @param tutName tutor name */
	 
	public void setTutorName(String tutName) {
		this.tutorName = tutName;
	}

	/** @param sTime class start time */
	
	public void setStartTime(int sTime) {
		this.startTime = sTime;
	}
	
	/** @param attRecords array of integers representing attendances */
	 
	public void setAttendanceRecords(int [] attRecords) {
		this.attendanceRecords = attRecords;
	}	

	/**
	 * accessor methods to return values of instance variables
	 * 
	 * @return class ID
	 */
	
	public String getClassID() {		
		return classID;
	}

	/** @return class name */
	
	public String getClassName() {
		return className;
	}
	
	/** @return tutor name */
	 
	public String getTutorName() {
		return tutorName;
	}
	
	/** @return class start time */
	 
	public int getStartTime() {
		return startTime;
	}
	
	/** @return class attendance records in String format */
	 
	public String getAttendanceRecords() {
		StringBuilder attendanceBuilder = new StringBuilder();
		for (int i: attendanceRecords) {
			attendanceBuilder.append(i + "   ");
		}
		String attendanceRecordsString = attendanceBuilder.toString();
		return attendanceRecordsString;
	}
	
	/**
	 * Method to calculate average attendance for the class
	 * @return average attendance for the class
	 */
	
	public double getAverageAttendance() {
		
		int sum = 0;
		double average = 0;
		for (int a : attendanceRecords) {
			sum += a;
			average = (double) sum/attendanceRecords.length;

		}
		return average;
	}
	
	/**Method to compare average attendance of two Fitness Class objects */
	 
	public int compareTo(FitnessClass other) {
		
		double averageAttendance = this.getAverageAttendance();
		double otherAverageAttendance = other.getAverageAttendance();
		if (averageAttendance < otherAverageAttendance) 
			return 1;		

		else if (averageAttendance == otherAverageAttendance)  
			return 0;

		else 
			return -1;

	}  	
	
	/** 
	 * Method to dictate the format in which Fitness Class should be printed in 
	 * GUI attendance report
	 * @return String containing class ID, class name, tutor name, attendance records
	 * and average attendance for the class
	 */
	
	public String toString() {

		String details = String.format("%5s %15s %15s %25s %13s\n", classID, className, tutorName, getAttendanceRecords(), getAverageAttendance());
		return details;
	}
	
	/**
	 * Method to dictate format in which Fitness Class should be printed in ClassesOut file
	 * @return String containing class ID, class name, tutor name and class start time
	 */

	public String toStringClassesOut() {

		String classOutDetails = String.format("%5s %10s %10s %10d\n", classID, className, tutorName, startTime);
		return classOutDetails;
		
}
}
