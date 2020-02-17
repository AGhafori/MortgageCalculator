/* Program by Ahmad Ghafori
   MortgagePlan
*/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class MortgagePlan {

   public static double calculateMonthlyPayment(
      double loanAmount, int termInYears, double interestRate) {
       
      // Convert interest rate into a decimal
      // eg. 6.5% = 0.065      
      interestRate /= 100.0;
     
      // monthly interest rate
      double monthlyRate = interestRate / 12.0;
     
      //term in months  
      int termInMonths = termInYears * 12;
       
      // Calculate the monthly payment
       
      // Since I can't use Java.math i have to find out a way to calculate it with simple maths and algorithms
      // U * b * (1+b)^p
     
      double base = (1 + monthlyRate);
      double top = 1;
     
      for (int i = 0; i < termInMonths; i++)
      {
         top = top * base;
      }
     
      double topSide = loanAmount * monthlyRate * top; // U[b(1+b)^p)]
      double bot = top - 1;
      double monthlyPayment = topSide/bot; 
       
      return monthlyPayment;
   }


   public static void main(String args[]) {
   
   //Variables
   String filename = "";
   String strline = "";
   Scanner scan = new Scanner(System.in);
    
      // E = U[b(1 + b)^p]/[(1 + b)^p - 1]
   
   // Read from file or get input from user
   System.out.println("Enter 1 to read from file and 2 to enter own values");
   int choice = scan.nextInt();
   switch(choice)  {
    case 1:
    //Get filename
     Scanner scanner = new Scanner(System.in);
         System.out.println("Enter Filename");
         filename = scanner.nextLine();
         
         try {  
            //Open file
            FileInputStream fstream = new FileInputStream(filename + ".txt");
            //Read file
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            //Read to file
            FileOutputStream out = new FileOutputStream("Result.txt"); 
            int i = 0;
            String firstLine = br.readLine();               
            while ((strline = br.readLine()) != null) { //loop
               String[] items = strline.split("\n,+");
               //System.out.println(items[0]);
               String[] val = items[0].split(",");
               //System.out.println(val[0]);
               double loan = Double.parseDouble(val[1]);
               double interest = Double.parseDouble(val[2]);
               int yrs = Integer.parseInt(val[3]);
               
               double result = calculateMonthlyPayment(loan, yrs, interest);
               
               out.write((val[0] + " wants to borrow ").getBytes());       //name
               out.write((loan + " Euros ").getBytes());    //loan
               out.write(("for a period of " + yrs).getBytes());    //years
               out.write((" and pay " + result + "\n").getBytes());      //selling price
               
            }

            System.out.println("Written to the file Result.txt");   

               
              in.close();
            } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            }
         break;
    case 2:
      
    System.out.print("Enter loan amount: ");
            double loanAmount = scan.nextDouble();
         
            System.out.print("Enter loan term (in years): ");
            int termInYears = scan.nextInt();
         
            System.out.print("Enter interest rate: ");
            double interestRate = scan.nextDouble();
           
            double monthlyPayment = calculateMonthlyPayment(loanAmount, termInYears, interestRate);
           
            System.out.println("The customer will need to pay €" + monthlyPayment + " every month for " + termInYears + " years");
           
            break;
            default:
            System.out.println("Only two choices available");
    }
   
   } // end of main
}
