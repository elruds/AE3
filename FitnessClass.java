/** Defines an object representing a single fitness class
 */
public class FitnessClass implements Comparable<FitnessClass> {
	// your code here
	private final int WEEKS_RECORDED_ATTENDANCE = 5;
	private String classID;
	private String className;
	private String tutorName;
	private int startTime;
	private int [] attendanceRecords; //= new int [WEEKS_RECORDED_ATTENDANCE];

	public FitnessClass()	{

	}

	public FitnessClass(String classDetails)	{		//sets values of instance variables
		String [] tokens = classDetails.split(" ");
		if (tokens.length < 4) {
			System.out.print("Missing data");
		}
		else {
			classID = tokens[0];				
			className = tokens[1];
			tutorName = tokens[2];
			startTime = Integer.parseInt(tokens[3]);

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
	
	public int [] getAttendanceRecords() {
		return attendanceRecords;
	}
	
    public int compareTo(FitnessClass other) {
    	
    	int startTime = this.getStartTime();
    	int otherStartTime = other.getStartTime();
    	if (startTime < otherStartTime) {
    		return 0;		
    	}
    	else 
    		return 1;
    }
    
}  	
    	
	   // replace with your code
    
 
    	

    
    
    
    
    
    
    



