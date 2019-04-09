/**
    This program takes in an array of numbers that are to 
    be used as input for mileage
    Once the input is received,the program will calculate the 
    reimbursement for mileage and output a neat table
    
    @author Frank Ferrer & Mbami Luka
    Project #3, CS 1050, Section 1

    Superfluous - unnecessary, especially through being more than enough.
    
    "All that was great in the past was ridiculed, condemned, combated, suppressed 
     only to emerge all the more powerfully, all the more triumphantly from the struggle."
    - Nikola Tesla (1856 - 1943)
*/

import java.util.Scanner;
import java.io.*;
public class FrankFerrer_1_03 {

   public static void main(String[] args) throws IOException 
   {
   
      // Declarations
      final String INPUT_FILE  = "FrankFerrer_1_03_Input.txt";
      final String OUTPUT_FILE = "FrankFerrer_1_03_Output.txt";

      
      double[] mileage;      // Mileage values to process
      double[] reimb;        // Calculated reimbursements
      int nMileage = 0;      // # of mileage values in the input file
      int nRead = 0;
      double averageMiles;   // average miles
      double averageReimb;   // average reimbursement
      double sumMiles;       // sum of miles
      double sumReimb;		  // # of mileage values actually read
      int validInput = 0;    // # of valid inputs
      
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
      validInput = nPositiveNums(mileage);
      
      // More data to calculate or count
      
      // Display info to outputFile and console with method
      printSummary(outputFile, averageMiles, averageReimb, sumReimb,
    			   sumReimb, nRead, validInput);
      
      inputFile.close();
      outputFile.close();
      System.exit(0);	

   } // End main 
      
   //************************************************************************

   public static void explainProgram(PrintWriter output) 
   {
      String line = ("This program takes in an array of numbers that are to be used as input for mileage.\r" +
       "\nOnce the input is received,the program will calculate the reimbursement for mileage "
     + "and output a neat table" +
       "\r\n");
      System.out.println(line);
      output.println(line);
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
                                        int nProcess) 
   	{
   		for(int i =0; i < nProcess; i++){
   	      
   	      if(mileage[i] < 400.00){
   	         reimb[i] = mileage[i] * .18;
   	      }
   	   
   	      else if(mileage[i] <= 900.00){
   	         reimb[i] = ((mileage[i] - 400) * .15) + 65.00;
   	      }
   	   
   	      else if(mileage[i] <= 1300.00){
   	         reimb[i] = ((mileage[i] - 900) * .12) + 115.00;
   	      }
   	   
   	      else if(mileage[i] <= 1900.00){
   	         reimb[i] = ((mileage[i] - 1300) * .10) + 140.00;
   	      }
   	   
   	      else if(mileage[i] <= 2600.00){
   	         reimb[i] = ((mileage[i] - 1900) * .08) + 165.00;
   	      }
   	      
   	      else if(mileage[i] >= 2600.00){
   	         reimb[i] = ((mileage[i] - 2600) * .06) + 195.00;   
   	      }
   	      else{
   	         reimb[i] = 0;
   	      }
   	    }
   	      
   	         
   	   } // End calcReimbursement
   

   
   //************************************************************************
   
   public static void printHeading(PrintWriter output) 
   {
	   String line1 = ("Mileage" + "     " + "Reimbursement"
              + "\r\n-------" + "     " + "-------------");
	   // Print to outputFile
	   output.println(line1);
	   
	   //print to console
	   System.out.println(line1);
	   
   } // End printHeading
   
   //************************************************************************
   
   public static void printDetails(PrintWriter output,
                                   double[] mileage,
                                   double[] reimb,
                                   int nProcess) 
   {
	   String lineSpacing2 = ("      ");
	   for(int j = 0; j < mileage.length; j++){
        String line1 =(Toolkit.leftPad(mileage[j], 7, "0.00", " ") + 
            "      "  + Toolkit.leftPad(reimb[j], 12, "$0.00", " "));
                     
        String line2 =(Toolkit.leftPad(mileage[j], 7, "0.00", " ") + 
			   "      " + "       *****");           
		  if (mileage[j] > 0)
		  {
		     System.out.println(line1);
		  
	        output.println(line1);
		  }
		  else
		  {
			  System.out.println(line2);
			  
		      output.println(line2);
		  }
	   }
   } // End printDetails 
   
   //************************************************************************
   
   public static double calcAverage(double[] data, int nProcess) 
   {
	   int reimbCount = 0;
	      double averageCalculation;
	      double calcSum = 0;
	      
	      for(int i = 0; i < nProcess; i++){
	         if(data[i] > 0){
	            calcSum += data[i];
	            reimbCount++;
	         }
	      }
	      
	      averageCalculation = calcSum / reimbCount;
	      
	      return averageCalculation;
   } // End calcAverage
   
   //************************************************************************
   
   public static double calcSum(double[] data, int nProcess) 
   {
	   
	   double sumReimb = 0;
	   for(int i = 0; i < nProcess; i++)
	   {
		   if(data[i] > 0)
		   {
			   sumReimb += data[i];
		   }
	   }
	   return sumReimb;
   } // End calcSum
   
   public static int nPositiveNums(double [] data)
   {
	   int nPositiveNums = 0;
	   for (int i = 0; i < data.length ; i++)
	   {
		   if (data[i] > 0)
		   {
			   nPositiveNums ++;
		   }
	   }
	   return nPositiveNums;
   } // End nPositiveNums
   
   public static void printSummary
   (PrintWriter output, double avgM, double avgR, double sumM, 
	double sumR, int nVals, int valNum)
   {
         String line1 =("o Average Mileage is: " + avgM
         + "\r\no Average Reimbursement is: $" + avgR
         + "\r\no Total Mileage is: " + sumM
         + "\r\no Total Reimbursement is: $" + sumR
         + "\r\no Number of values processed: " + nVals
         + "\r\no Number of valid values processed: " + valNum);
         
	   	output.println("");
	      output.println(line1);
         
	      //print to console
	      System.out.println("");
	      System.out.println(line1);
   
   }
   
} // End class