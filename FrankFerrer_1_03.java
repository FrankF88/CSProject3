import java.util.Scanner;
import java.io.*;

public class FrankFerrer_1_03 {

   public static void main(String[ ] args) {
   
      // Declarations
      final String INPUT_FILE  = "FrankFerrer_1_03_Input.txt";
      final String OUTPUT_FILE = "FrankFerrer_1_03_Output.txt";

      
      double[] mileage;       // Mileage values to process
      double[] reimb;         // Calculated reimbursements
      int nMileage = 0;       // # of mileage values in the input file
      int nRead = 0;          // # of mileage values actually read
      
      // Access the input and output files
      
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile  = new Scanner(inputDataFile);
      
      FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputDataFile);
      
      // ******** End declarations, begin execution ********
      
      // Get the number of mileage values that are supposed to be in the file
      // and use that number to allocate the two arrays
      nMileage = inputFile.nextInt();
      mileage = new double[nMileage];
      reimb = new double[nMileage];
      
      // Get to work!
      explainProgram(outputFile);
      nRead = readInput(inputFile, mileage, nMileage);
      calcReimbursement(mileage,reimb,nRead);
      printHeading(outputFile);
      printDetails(outputFile,mileage,reimb,nRead);
      double averageMiles = calcAverage(mileage,nRead);
      double averageReimb = calcAverage(reimb,nRead);
      double sumMiles = calcSum(mileage,nRead);
      double sumReimb = calcSum(reimb,nRead);
      // More data to calculate or count

   } // End main 
      
   //************************************************************************

   public static void explainProgram(PrintWriter output) {
   } // End explainProgram
      
   //************************************************************************

   public static int readInput(Scanner input, 
                                  double[] mileage,
                                  int nValues) {
      int numRead = 0;
      
      while (input.hasNext() && numRead < nValues) {
          mileage[numRead] = input.nextDouble();
          ++numRead;
      } // End while
      
      return numRead;
   } // End readInput
   
   //************************************************************************
   
   public static void calcReimbursement(double[] mileage,
                                        double[] reimb,
                                        int nProcess) {
   } // End calcReimbursement
   
   //************************************************************************
   
   public static void printHeading(PrintWriter output) {
   } // End printHeading
   
   //************************************************************************
   
   public static void printDetails(PrintWriter output,
                                   double[] mileage,
                                   double[] reimb,
                                   int nProcess) {
   } // End printDetails 
   
   //************************************************************************
   
   public static double calcAverage(double[] data, int nProcess) {
      return 0.0;
   } // End calcAverage
   
   //************************************************************************
   
   public static double calcSum(double[] data, int nProcess) {
      return 0.0;
   } // End calcSum
   
} // End class