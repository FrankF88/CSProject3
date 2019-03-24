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
      double averageMiles;    // avg miles
      double averageReimb;    // avg reimb
      double sumMiles;        // sum of miles
      double sumReimb;        // sum of reimbursement
      
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
      averageMiles = calcAverage(mileage,nRead);
      averageReimb = calcAverage(reimb,nRead);
      sumMiles = calcSum(mileage,nRead);
      sumReimb = calcSum(reimb,nRead);
      // More data to calculate or count

   } // End main 
      
   //************************************************************************

   public static void explainProgram(PrintWriter output) {
      outputFile.println("This program takes in an array of 
                        numbers that are to be used as input
                        for mileage.\nOnce the input is received,
                        the program will calculate the reimbursement
                        for mileage and output a neat table");
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
      double mileageRate;
      
      if(mileage > 0 && mileage < 400.00){
         mileageRate = mileage * .18;
      }
   
      else if(mileage >= 400.00 && mileage <= 900.00){
         mileageRate = ((mileage - 400) * .15) + 65.00;
      }
   
      else if(mileage >= 900.00 && mileage < 1300.00){
         mileageRate = ((mileage - 900) * .12) + 115.00;
      }
   
      else if(mileage >= 1300.00 && mileage < 1900.00){
         mileageRate = ((mileage - 1300) * .10) + 140.00;
      }
   
      else if(mileage >= 1900.00 && mileage < 2600.00){
         mileageRate = ((mileage - 1900) * .08) + 165.00;
      }
      
      else if(mileage >= 2600.00){
         mileageRate = ((mileage - 2600) * .06) + 195.00;   
      }
      else{
         mileageRate = 0;
      }
      
         
   } // End calcReimbursement
   
   //************************************************************************
   
   public static void printHeading(PrintWriter output) {
   String lineSpacing = "     ";
   
   System.out.println("Mileage" + lineSpacing + "Reimbursement");
   System.out.println("-------" + lineSpacing + "-------------");
   } // End printHeading
   
   //************************************************************************
   
   public static void printDetails(PrintWriter output,
                                   double[] mileage,
                                   double[] reimb,
                                   int nProcess) {
   String lineSpacing2 = "     ";
   
   for(int j = 0; j < mileage.length; j++){
      System.out.println(mileage[i] + lineSpacing2 + reimb[i];
   }
                                   
   } // End printDetails 
   
   //************************************************************************
   
   public static double calcAverage(double[] data, int nProcess) {
   
      int reimbCount;
      double averageReimb;
      
      for(int i = 0; i < data.length; i++){
         reimbCount++;
      }
      
      averageReimb = calcSum / reimbCount;
      
      return averageReimb;
   } // End calcAverage
   
   //************************************************************************
   
   public static double calcSum(double[] data, int nProcess) {
      
      for(int i = 0; i < data.length; i++){
         sumReimb += data[i];
      
      return sumReimb;
   } // End calcSum
   
} // End class