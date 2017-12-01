import java.util.*;

/**
 * Maintains a list of Fitness Class objects
 * The list is initialised in order of start time
 * The methods allow objects to be added and deleted from the list
 * In addition an array can be returned in order of average attendance
 */
public class FitnessProgram {
    // your code here
	private final int MAX_CLASSES = 7;
	private FitnessClass singleFClass;
	private FitnessClass [] fClasses;
	private int countClasses;
	
	
	
	
	
	public FitnessProgram()	{
		
		
	}

	public FitnessProgram(FitnessClass fC) {
		
		this.singleFClass = fC;
		fClasses = new FitnessClass[MAX_CLASSES];
//		int timeStarts = f.getStartTime();
//		switch(timeStarts) {
//		case 9: fClasses[0] = f;
//		break;
//		case 10: fClasses[1] = f;
//		break;
//		case 11: fClasses[2] = f;
//		break;
//		case 12: fClasses[3] = f;
//		break;
//		case 13: fClasses[4] = f;
//		break;
//		case 14: fClasses[5] = f;
//		break;
//		case 15: fClasses[6] = f;
//		break;
//		default: fClasses = null;
//		break;
//		}
		
		for (int i = 0; i < MAX_CLASSES; i++)	{
			
			fClasses[i] = fC;
			
		}
		System.out.print(fC.getStartTime());
//			
		}
		
	
			
			
			
			
		
		
	
	
		public int numFClasses(FitnessClass [] fClasses)	{
			
			countClasses = 0;
			for (int i = 0; i < MAX_CLASSES; i++)	{
				
				if (fClasses[i] == null){
					i++;
				}
		
				else countClasses++;
	}
			return countClasses;
}
}