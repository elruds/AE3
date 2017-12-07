/** Defines an object representing a single fitness class
 */
public class FitnessClass implements Comparable<FitnessClass> {
	// your code here
	private final int WEEKS_RECORDED_ATTENDANCE = 5;
	private String classID;
	private String className;
	private String tutorName;
	private int startTime;
	private int [] attendanceRecords; 

	public FitnessClass()	{

	}

	public FitnessClass(String classDetails)	{		//sets values of instance variables
		String [] classTokens = classDetails.split(" ");
		if (classTokens.length < 4) {
			System.out.print("Missing data");
		}
		else {
			classID = classTokens[0];				
			className = classTokens[1];
			tutorName = classTokens[2];
			startTime = Integer.parseInt(classTokens[3]);

		}
	}

	public void setClassID(String cID) {		//mutator methods to set values of instance variables
		this.classID = cID;
	}

	public void setClassName(String cName) {
		this.className = cName;
	}

	public void setTutorName(String tutName) {
		this.tutorName = tutName;
	}

	public void setStartTime(int sTime) {
		this.startTime = sTime;
	}

	public void setAttendanceRecords(int [] attRecords) {
		this.attendanceRecords = attRecords;
	}	

	public String getClassID() {		//accessor methods to return values of instance variables
		return classID;
	}

	public String getClassName() {
		return className;
	}
	
	public String getTutorName() {
		return tutorName;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public String getAttendanceRecords() {
		StringBuilder attendanceBuilder = new StringBuilder();
		for (int i: attendanceRecords) {
			attendanceBuilder.append(i + "   ");
		}
		String attendanceRecordsString = attendanceBuilder.toString();
		return attendanceRecordsString;
	}
	
	public double getAverageAttendance() {
		
		int sum = 0;
		double average = 0;
		for (int a : attendanceRecords) {
			sum += a;
			average = (double) sum/attendanceRecords.length;

		}
		return average;
	}
	

		
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
	public String toString() {

		String details = String.format("%5s %15s %15s %25s %13s\n", classID, className, tutorName, getAttendanceRecords(), getAverageAttendance());
		return details;
	}



}

