import java.lang.reflect.Array;
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
	private FitnessClass [] fClasses = new FitnessClass[MAX_CLASSES]; 
	
	
	
	public FitnessProgram()	{
	}

	public void addFitnessClass(FitnessClass fC) {

		int timeStarts = fC.getStartTime();
		switch(timeStarts) {
		case 9: fClasses[0] = fC;
		break;
		case 10: fClasses[1] = fC;
		break;
		case 11: fClasses[2] = fC;
		break;
		case 12: fClasses[3] = fC;
		break;
		case 13: fClasses[4] = fC;
		break;
		case 14: fClasses[5] = fC;
		break;
		case 15: fClasses[6] = fC;
		break;
		default: fClasses = null;
		break;
		}
	}
		
	public FitnessClass [] allFClasses()	{
		
		return fClasses;
	}
	
	
		public int numFClasses()	{ //counts number of fitness classes
			
			return Array.getLength(fClasses);
			
		}
			

		public FitnessClass getFitnessClassAtIndex(int i){ //returns FitnessClass at 
															//specified index position
			return fClasses[i];
		}
		
		public FitnessClass getFitnessClassAtTime(int t) { //return FitnessClass at 
																//specified time
			return fClasses[t - 9];
			
		}


		public int getFirstAvailableClassTime() { //first available start time for a class
			int i;
			for (i = 0; i < MAX_CLASSES; i++)	{

				if (fClasses[i] != null){
				}
				else {
					return i+9;
					
				}
			}
			System.err.print("No available class times");
			return 0;
		}



		public FitnessClass getFitnessClassWithID(String iD) {

			int i;
			for (i = 0; i < MAX_CLASSES; i++)	{

				if ((fClasses[i] == null)) {
					i++;
				}

				else {
					String currentID = fClasses[i].getClassID();

					if (currentID.equals(iD)) {
						return fClasses[i];
					}
				}
			}
			return null;
		
		}
}


