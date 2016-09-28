/**********************************************************
 * Program Name   : RandomArray
 * Author         : Luke Cavanaugh
 * Date           : 24 January 2016 
 * Course/Section : CSC264
 * Program Description: This program will generate a random
 *    number of integers. It will then fill an array and 
 *    finally output them to the user. 
 *
 * Methods:
 * -------
 * Main - generates randoms and fills array 
 *
 **********************************************************/
import java.util.*;

public class RandomArray
{
   /**********************************************************
    * Method Name    : RandomInts
    * Author         : Luke Cavanaugh 
    * Date           : 24 January 2016 
    * Course/Section : CSC264
    * Program Description: This method will first generate
    *    a random number between 5 and 10 (inclusive) which represents 
    *    the he number of values to generate. Next, it will generate 
    *    that many values and store them in an array. These numbers will 
    *    be between 0 and 100 (inclusive). Finally, it will display
    *    the numbers generated
    *
    * BEGIN RandomArray
    *    Generate random number between 5,10
    *    Set the array size = to the random number 
    *    Set spacing 
    *    FOR (execute from 0 - randomNumber)
    *        generate random number between 0,100
    *        display contents 
    *    END FOR
    * END RandomArray 
    **********************************************************/

   public static void main (String [] args)
   {
      //local constants
      final int NUM_MIN = 5;  //min random value 
 
      //local variables 
      int arraySize;          //determine size of array 
      int randomArray[];      //array for random numbers to be printed 
      
      /******************** Start main method  *****************/
      
      //Generate random number between 5,10
      arraySize = new Random().nextInt(NUM_MIN+1) + NUM_MIN;  
     
      //Set the array size = to the random number 
      randomArray = new int [arraySize];
      
      //Set Spacing 
      System.out.print("Contents of the array : ");
      //System.out.print(Util.setLeft(10, ""));
      
      //FOR (execute from 0 - randomNumber)
      for (int i = 0; i < arraySize; i++)
      {
         //generate number between 0,100
         randomArray[i] = new Random().nextInt(101);
         
         //display contents
         System.out.print(Integer.toString(randomArray[i]) + ",");
                      
      }//END FOR
      
       //buffer for press any key 
       System.out.println("\n");
       
   } //END main method

} //END randomArray

