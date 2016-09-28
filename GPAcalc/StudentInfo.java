/**********************************************************
 * Program Name   : StudentInfo
 * Author         : Luke Cavanaugh
 * Date           : 5 March 2016
 * Semester/Section : CSC - 264
 * Program Description: This program will store
 *    an array of course objects and print a semester
 *    on screen.
 *
 * Variables and Objects:
 * ----------------------
 *   -  semesters        : SemesterInfo[]
 *   +  courseCount    : int
 *   +  semesterName   : String
 *   +  totalGrdPts    : double
 *   +  totalCrHrs     : int
 *   +  semesterGPA    : double
 *   +  courseCount    : int
 *   +  semesterName   : String
 *   +  totalGrdPts    : double
 *   +  totalCrHrs     : int
 *   +  semesterGPA    : double
 *
 * Methods:
 * -------
 *   +StudentInfo()    : cnstrctr    - constructs new semester
 *   +addSemester()    : void        - adds new course
 *   +toStrings()      : void        - prints the semesters
 *   +modSemName()     : String      - allows to change semester name
 *   +calcSemesterGPA(): double      - calculates GPA
 *   +semSearch()      :
 ***********************************************************/

//needed for formatting to two decimal places in addSemester()
import java.text.*;

public class StudentInfo
{

    //local constants
	public final int MAX_SEMESTERS = 16;  //max number of semesters in array

    //local variables
    private SemesterInfo[] semesters = new SemesterInfo[MAX_SEMESTERS];  //sets size of array
    private String firstName;
    private String lastName;
    private int semCount = 0;
    private int totalCredHrs =0;
    private double totalGrdPts =0;
    private double overallGPA =0;
    String disp = "";

    /**********************************************************
    * Program Name   : StudentInfo
    * Author         : Luke Cavanaugh
    * Date           : 5 March 2016
    * Semester/Section : CSC - 264
    * Program Description: Constructor for new semester
    *
    * Methods:
    * -------
    * StudentInfo - constructs new semester
    *
    * BEGIN StudentInfo()
    *    Set variables using this operator
    *    Create new semesters array
    *    Prompt for semester name
    * END StudentInfo()
    **********************************************************/

   public StudentInfo(String firstName, String lastName, final int MAX_SEMESTERS)
	{

      //local constants

      //local variables
      final int MAX_SEM = MAX_SEMESTERS;
      this.firstName = firstName;
      this.lastName = lastName;

      /******************** Start StudentInfo() method  *****************/



   } //END StudentInfo


   /**********************************************************
    * Program Name   : addSemester
    * Author         : Luke Cavanaugh
    * Date           : 5 March 2016
    * Semester/Section : CSC - 264
    * Program Description: Constructor for new semester
    *
    * Methods:
    * -------
    * StudentInfo - constructs new semester
    *
    * BEGIN addSemester()
    *    IF semester is not empty
    *     FOR(cycles through entire array)
    *     IF(array at i is empty)
    *     place course at current position
    *     increment course count
    *      exit for
    *END IF
    *END FOR
    * END IF
    * END addSemester
    *
    *
    *
    *
    *
    *
    *
    *
    *
    * END addSemester()
    **********************************************************/

   public void addSemester(SemesterInfo semester)
	{

      //local constants

      //local variables

     /******************** Start addSemester() method  *****************/

     //IF semester is not empty

     if (semester != null)
     {
			//FOR(cycles through entire array)
         for (int i =0; i < MAX_SEMESTERS; i++)
         {
            //IF(array at i is empty)
            if (semesters[i] == null)
            {
               //place course at current position
               semesters[i] = semester;

               //increment course count
               semCount++;

               //exit for
               i = MAX_SEMESTERS;



            }//END IF

         }//END FOR

     }//END IF

	}//END addSemester

   /**********************************************************
    * Program Name   : toString()
    * Author         : Luke Cavanaugh
    * Date           : 5 March 2016
    * Course/Section : CSC - 264
    * Program Description: This will return the array of courses
    *
    * Methods:
    * -------
    * toStrings() -
    *
    * BEGIN toStrings()
    *   FOR(cycle through array for every semester)
    *      concatinate semesters into a string
    *      increment total credit for output
    *      increment total grade points for output
    * 	      IF( there are no courses, set GPA to 0)
    * 	      ELSE overall GPA is total grade points / total credit hours
    *   END for
    *      concatinate to display total student information
    *      send display back to main
    * END addCourse
    **********************************************************/

    public String toString()
	{

	  //local constants

      //local variables
           totalCredHrs   =0;                                    //total credit hours
           totalGrdPts    =0;								     //total grade points
           overallGPA     =0;                                    //overall GPA
           disp           = "";                                  //displays output
           NumberFormat formatter = new DecimalFormat("#0.00");  //decimal formatter


       //FOR(cycle through array for every semester)
       for (int i = 0; i < semCount; i++)
          {

			 //concatinate semesters into a string
             disp += semesters[i].toString();

             //increment total credit for output
             totalCredHrs += semesters[i].getTotalCrdHrs();

			 //increment total grade points for output
             totalGrdPts += semesters[i].getTotalGrdPts();

             //if( there are no courses, set GPA to 0)
             if(totalCredHrs <=0 && totalGrdPts <= 0)
                overallGPA = 0;

             //else overall GPA is total grade points / total credit hours
             else
                overallGPA =  totalGrdPts /  totalCredHrs;

          }//end for

          //concatinate to display total student information
          disp += "\n" + Util.setLeft(32,"ttlGrdPts : " ) + formatter.format(totalGrdPts)
          + " ttlCredHrs : " + totalCredHrs
          + " Overall GPA : " + formatter.format(overallGPA) + "\n";




     //send display back to main
     return disp;


	}//END addCourse



   /**********************************************************
    * Program Name   : semSearch
    * Author         : Luke Cavanaugh
    * Date           : 5 March 2016
    * Semester/Section : CSC - 264
    * Program Description: This method will print out entire student academic information
    *
    * Methods:
    * -------
    * semSearch -
    *
    * BEGIN semSearch()
    *    FOR (cycle through entire array)
    *       increment catcher
    *       IF (semester at current positionn is null
    *	      set catcher to invalid value
    *       ELSE IF (semester at current spot  = semester being searched
    *          catcher is equal to position
    *          exit loop
    *	    END ELSE IF
    *   END FOR
    *   IF  catcher = invalid value (-1)
    *   return null
    *   END IF
    *   ELSE return value of catcher
    * END semSearch()
    **********************************************************/

   public SemesterInfo semSearch(String semesterName)
	{

      //catcher variable to determine validity
      int catcher = 0;

      //for (cycle through entire array)
      for (int i = 0; i < MAX_SEMESTERS; i++)
      {

         //increment catcher
         catcher++;

		 //if (semester at current positionn is null
         if (semesters[i] == null)

         //set catcher to invalid value
         catcher = -1;

         //else if (semester at current spot  = semester being searched
         else if (semesters[i].getSemName().equals(semesterName))
         {

         //catcher is equal to position
         catcher = i;

         //exit loop
         i = MAX_SEMESTERS;

         }//end else if



     } //end for

       //if catcher = invalid value (-1)
       if (catcher == -1)
       {

	   //return null
       return null;
       }//end if

       //else return value of catcher
       else
       return semesters[catcher];

    } //end semSearch

 }//END StudentInfo


