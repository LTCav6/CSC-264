/**********************************************************
 * Program Name   : FracConverter
 * Author         : Luke Cavanaugh 
 * Date           : February 01, 2001
 * Course/Section : CSC111 - 02
 * Program Description: Create a Java application that inputs
 * the numerator and denominator of a fraction and display the
 * decimal equivalent to 3 decimal places.  Center the output
 * on the screen. Continue to input fractions until the user 
 * decides to quit. Write the pseudocode first and show it to
 * the instructor.
 *
 *
 * Methods:
 * -------
 * Main - executes conversion from fraction to decimal 
 *
 **********************************************************/
import java.util.*;

public class FracConverter
{


   /**********************************************************
    * Method Name    : FractionConverter
    * Author         : Luke Cavanaugh 
    * Date           : 23 January 2016 
    * Course/Section : CSC - 264 
    * Program Description: This method will calculate the of two quiz
    *    grades.  The grades will be input from the keyboard.  The
    *    program will then sum the grades and calculate the average.
    *    Finally, the average will be displayed on the screen.
    *    If either grade is invalid it will display an error message
    *    instead.
    *
    * BEGIN FractionConverter
    *    Prompt user for numerator
    *    Prompt user for denominator
    *    IF (numerator == 0)
    *        Display answer as '0'
    *    ELSE IF (denominator == 0)
    *        Display error message 
    *    ELSE
    *        Divide numerator by denominator 
    *        Format to 3 decimal places 
    *        Display output 
    *    END IF
    * END FractionConverter
    **********************************************************/

   public static void main (String [] args)
   {
      //local constants
      final String EMPTY     = "0.000 ";                   //fraction is 0
      final String UNDEFINED = "Fraction is undefined ";   //error message 

      //local variables
      int numerator;                                       //dividend
      int denominator;                                     //divisor
      float decimal;                                       //float equivalent of numerator / denominator

      //Library64 myLib = new Library64();
      
      /******************** Begin main method  *****************/
      
      //prompt user for numerator
      System.out.print("Enter numerator\t\t: \t\t");
      numerator   = Keyboard.readInt();

      //prompt user for denominator 
      System.out.print("Enter denominator\t: \t\t");
      denominator = Keyboard.readInt();
      
      //clear the screen
      myLib.clrscr();

      //IF (numerator == 0)
      if (numerator == 0)
      {
         //display answer as '0'
         System.out.print(numerator + "/" + denominator + " = \t\t: ");
         System.out.println(Util.setLeft(14,EMPTY));
      } //END primary IF 
      
      //ELSE IF (denominator == 0)
      else if (denominator == 0)
      {

		   //display error message
         System.out.print("Error\t\t\t:");
		   System.out.println(Util.setLeft(15,UNDEFINED));
	   } //END secondary if 
      
      //ELSE
      else
      {
 
         //divide numerator by denominator
         decimal = numerator / denominator;
         
         //display output by converting to string and formatting to center screen
         System.out.print(numerator + "/" + denominator + " = \t\t: ");
         System.out.println(Util.setLeft(14,String.format ("%.3f", decimal)));
      
      } //END final IF
      
   } //END main method

} //END FracConverter

