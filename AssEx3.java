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
//		
//		FileReader reader = null;
//		try	{
//			try {
//			reader = new FileReader("/Users/Lauren/eclipse-workspace/AssEx3/ClassesIn.txt");
//			Scanner scan = new Scanner(reader);
//			FitnessClass fc;
//			FitnessProgram fp = new FitnessProgram();
//			
//			while (scan.hasNextLine() ) {
//				String classLine = scan.nextLine();
//				fc = new FitnessClass(classLine);
//				fp.addFitnessClass(fc);
//				
//			}
//			
//			System.out.print(fp.getFirstAvailableClassTime());
//			}
//			finally {
//
//				if (reader != null) {
//					reader.close();
//					}
//				}
//			}
//		
//			catch (IOException ioe) {
//				JOptionPane.showMessageDialog(null, "File not found",
//						"Error", JOptionPane.ERROR_MESSAGE);
//
//			}
//			catch (InputMismatchException e) {
//				JOptionPane.showMessageDialog(null, "Invalid file content",
//						"Error", JOptionPane.ERROR_MESSAGE);
//			}
//		}
//	}






		
		
		
		
		

			
