 /*********************************************************
 * Program Name   : AccountMaker
 * Author         : Luke Cavanaugh
 * Date           : 29 Janaury 2016
 * Course/Section : CSC 264
 * Program Description: This program will create a username
 *    and password for a student. It will allow for students
 *    with the same name to have individual ID's.
 *
 * Methods:
 * -------
 *  Main - prompts for username, displays new username and passwords
 * +Formatter(firstName,lastName)        : String
 * +duplicateCheck(userID,arrayCount)    : String
 **********************************************************/

//needed for random class, used in Formatter
import java.util.*;

public class AccountMaker
{
    /******************************************************
    * Program Name   : AccountCreator
    * Author         : Luke Cavanaugh
    * Date           : 29 Janaury 2016
    * Course/Section : CSC 264
    * Program Description: This program will create a username
    *    and password for a student. It will then store them in an array
    *    and print to screen.
    *
    * BEGIN AccountCreator (main)
    *    Initialize array count = 0**
    *    Prompt for first name or sentinel
    *    WHILE ( first name != sentinel )
    *        set firstName to lowercase
    *        Prompt for last name or -1 to quit
    *        set lastName to lowercase
    *        CALL Formatter () Method to create username
	*           Insert username into the username array (at pos array count)
    *           Insert username into the password array (at pos array count)
	*           Increment array count
	*           IF (the array is now full)
	*               Set first name to sentinel
	*               Display full message
	*           ELSE
	*               Get next first name
	*           END IF
    *    END WHILE
    *    CALL Print_Array() Method
    * END AccountCreator
    ********************************************************/

    public static void main (String [] args)
   {
      //local constants
      final String SENTINEL  = "-1";                      //exit value for program
      final int ARRAY_SIZE   = 10;                        //sets size of userArray, passwordArray

      //local variables
      String[] userArray     = new String [ARRAY_SIZE];   //array for username values
      String[] passwordArray = new String [ARRAY_SIZE];   //array for password values
      String firstName       = "";                        //user last name
      String lastName        = "";                        //users last name
      String userID          = "";                        //holds user ID
      int arrayCount         = 0;                         //number of times program runs, removes duplicates

      //enables clear screen
	   //Library64 myLib = new Library64();

      /********************   Start main method  *****************/

      //Prompt for first name or sentinel
      System.out.print("\tPlease enter your first name or -1 to quit : \t");
      firstName = Keyboard.readString();

      //WHILE firstName != sentinel
      while (!firstName.equals(SENTINEL))
      {
         //set firstname to lowercase
         firstName = firstName.toLowerCase();

         //prompt user for last name
         System.out.print("\tPlease enter your last name : \t\t\t");
         lastName = Keyboard.readString();

         //set lastName to lowercase
         lastName = lastName.toLowerCase();

         //create user ID with Formatter method
         userID = Formatter(firstName, lastName);

         //cycles through aray, checks for duplicates
         for (int i = 0; i <= ARRAY_SIZE -1; i++)
         {
            //if duplicate at current position, send to duplicateCheck method
            if (userID.equals(userArray[i]))
               {

                //userID is imported from duplicateCheck method
                userID = duplicateCheck(userID,arrayCount);

               }
         }

         //load user ID into user array
         userArray[arrayCount]     = userID;

         //load password into password array
         passwordArray[arrayCount] = firstName;

         // IF array is full, exit
         if (arrayCount == ARRAY_SIZE-1)
         {
            firstName = SENTINEL;
         }

         //ELSE prompt for first name
         else
         {
            System.out.print("\tPlease enter your first name or -1 to quit : \t");
            firstName = Keyboard.readString();
         }

         //increment array
         arrayCount++;


      } //END while

      //clear the screen
      //myLib.clrscr();

      //cycles through userArray, passwordArray and prints contents
      for (int l = 0; l < arrayCount; l++)
      {
      System.out.println(Util.setLeft(31,"Username : " + userArray[l])
         + "\n" + Util.setLeft(31,"Password : " + passwordArray[l] + "\n"));
      }

   } // END main

   /**********************************************************
    * Program Name   : Formatter
    * Author         : Luke Cavanaugh
    * Date           : 29 Janaury 2016
    * Course/Section : CSC 264
    * Method Description: This method will format username
    *
    * BEGIN Formatter(firstName, lastName)
    *    Truncate first name to two letters
    *    IF (lastname > 3 chars)
    *        truncate last name down to 3 chars
    *    END IF
    *    Create random digit between 1 , 3
    *    Concatinate first + last + random digit
    *    IF (username = existing name)
    *       IF (username != username1)
    *          concatinate 1 to end of username
    *       ELSE IF (username != username2)
    *          concatinate 2 to end of username
    *       ELSE IF (username != username3)
    *          concatinate 3 to end of username
    *    END IF
    *    Return username
    * END Formatter
    **********************************************************/

    static String Formatter(String fName, String lName)
    {

       String firstName = fName;  //sets first name
       String lastName  = lName;  //sets last name
       String fullName;           //declares full name
       int random;                //random number

       //IF firstName > = 2 chars, truncate to 2 chars
       if (firstName.length() >= 2)
       firstName = firstName.substring(0, 2);
       //END IF

       //IF lastName > = 2 chars, truncate to 2 chars
       if (lastName.length() >= 3)
       lastName  = lastName.substring(0, 3);
       //END IF

       //Generate random between 1, 3
       random    = new Random().nextInt(3) + 1;

       //Concatinate firstName, lastName, and random
       fullName  = firstName + lastName + random;

       //return the fullName
       return fullName;

    }//END Formatter

    /**********************************************************
    * Program Name   : duplicateCheck
    * Author         : Luke Cavanaugh
    * Date           : 29 Janaury 2016
    * Course/Section : CSC 264
    * Method Description: This method will remove any duplicte ID's
    *
    * BEGIN duplicateCheck (String userID, int arrayCount)
    *    Create unique user ID by number of runs % 4
    *    return userID to main
    * END duplicateCheck ()
    ************************************************************/
    static String duplicateCheck (String userID, int arrayCount)
    {

       //import number of times program has run
       int adder = arrayCount;

       //unique ID created from prgrm runs mod 4, (1-3)
       userID += Integer.toString(adder%4);

       //return unique ID back to main
       return userID;

    }//END duplicateCheck

} //END AccountMaker