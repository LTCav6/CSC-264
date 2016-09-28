/**********************************************************
 * Program Name   : SemesterInfo
 * Author         : Luke Cavanaugh
 * Date           : 5 March 2016
 * Course/Section : CSC - 264
 * Program Description: This program will store
 *    an array of course objects and print a semester
 *    on screen.
 *
 * Variables and Objects:
 * ----------------------
 *   -  courses        : CourseInfo[]
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
 *   +  display        : String
 *
 * Methods:
 * -------
 *   +SemesterInfo()   : cnstrctr  - constructs new semester
 *   +addCourse()      : void      - adds new course
 *   +toString()       : void      - prints the courses
 *   +modSemName()     : String    - allows to change semester name
 *   +calcSemesterGPA(): double    - calculates GPA
 ***********************************************************/

//needed for formatting to two decimal places in addCourse()
import java.text.*;
import java.lang.*;


public class SemesterInfo
{

    //local constants
	 private final int MAX_COURSES = 7;  //max number of courses in array

    //local variables
    private CourseInfo[] courses = new CourseInfo[MAX_COURSES];  //sets size of array
    private String semesterName;                                 //name of semester
    private int courseCount;                                     //number of courses
    private int totalCrHrs = 0;                                      //total credit hours
    private double totalGrdPts =0;                                  //total grade points
    private double semesterGPA =0;                                 //semester gpa
    private String display = "";							       //outputs courses

    /**********************************************************
    * Program Name   : SemesterInfo
    * Author         : Luke Cavanaugh
    * Date           : 5 March 2016
    * Course/Section : CSC - 264
    * Program Description: Constructor for new semester
    *
    * Methods:
    * -------
    * SemesterInfo - constructs new semester
    *
    * BEGIN SemesterInfo()
    *    Set variables using this operator
    *    Create new courses array
    *    Prompt for semester name
    * END SemesterInfo()
    **********************************************************/

   public SemesterInfo(String semesterName)
	{

     this.semesterName = semesterName;          //sets semester name
     courseCount = 0;                           //sets courseCount
     totalCrHrs  = 0;                           //sets total credit hours
     totalGrdPts = 0;                           //sets total grade points
     semesterGPA = 0;                           //sets semesterGPA

     /******************** Start SemesterInfo() method  *****************/


   } //END SemesterInfo



    /**********************************************************
    * Program Name   : addCourse
    * Author         : Luke Cavanaugh
    * Date           : 5 March 2016
    * Course/Section : CSC - 264
    * Program Description: This will add a new course to the array
    *
    * Methods:
    * -------
    * addCourse() - adds course to array
    *
    * BEGIN addCourse()
    *    IF course is not empty
    *       FOR(cycles through entire array)
    *          IF(array at i is empty)
    *             place course at current position
    *             increment course count
    *             exit for
    *			  increment total credit hours
    *			  increment total grade points
    *			  IF total credit hours or total grade points are 0
    *             set semester GPA is 0
    *             else semesterGPA = total grade points / total credit hours
    *          END IF
    *       END FOR
    *    END IF
    * END addCourse()
    **********************************************************/

    public void addCourse(CourseInfo course)
	{

     /******************** Start addCourse() method  *****************/

     //IF course is not empty
     if (course != null)
     {
			//FOR(cycles through entire array)
         for (int i =0; i <= 7; i++)
         {

            //IF(array at i is empty)
            if (courses[i] == null)
            {
               //place course at current position
               courses[i] = course;

               //increment course count
               courseCount++;

               //exit for
               i = 7;

               //increment total credit hours
               totalCrHrs  +=  course.credits;

               //increment total grade points
               totalGrdPts +=  course.gradePoints;

               //if total credit hours or total grade points are 0
               if(totalCrHrs <=0 || totalGrdPts <= 0)
               {
				   //set semester GPA is 0
				   semesterGPA = 0;
		       }

		       //else semesterGPA = total grade points / total credit hours
               else
               semesterGPA  =   totalGrdPts /  totalCrHrs;

            }//END IF

         }//END FOR

      }//END IF

	}//END addCourse

    /**********************************************************
    * Program Name   : toString()
    * Author         : Luke Cavanaugh
    * Date           : 5 March 2016
    * Course/Section : CSC - 264
    * Program Description: This will return the array of courses
    *
    * Methods:
    * -------
    * toString() -
    *
    * BEGIN toString()
    *   IF semester has less than one course
    *   print title only
    *   FOR (cycle through entire array)
    *      IF course is first element, print title above
    *      ELSE display only course information
    *      IF semester has a course
    *         return entire string
    *   END FOR
    * END deleteCourse()
    **********************************************************/

    public String toString()
	{


    /********************   Start toString method  *****************/

    ///number formatting
    NumberFormat formatter = new DecimalFormat("#0.00");

    //allows display
    display = "";

    // IF semester has less than one course
    if (courseCount < 1)
        {

		 //print title only
         System.out.println("\n" + Util.setRight(28,semesterName) + "\n"
         + Util.setLeft(32,"Title\t Grade\tCreditHours\t GradePoints\n")
         + Util.setLeft(32,"No Courses Added"));
        }

    //FOR(cycle through array)
    for (int i = 0; i < courseCount; i++)
      {

        //IF course is first element, print title above
        if (i < 1)
        {
        display += "\n" + Util.setLeft(28,semesterName) + "\n" + Util.setLeft(32,"Title\t Grade\tCreditHours\tGradePoints\n")
        + courses[i].toString() + "\n";
        }

        //else display only course information
        else
        {
        display += courses[i].toString() + "\n";
        }
      }

      //if semester has a course
      if (courseCount > 0)
      display += "\n" + Util.setLeft(32,"Courses: " + courseCount
      + " GrdPts: " + formatter.format(totalGrdPts) + " Credits: " + totalCrHrs
      + " GPA: " + formatter.format(semesterGPA) + "\n");

      //
      return display;

	}//END addCourse

    /**********************************************************
    * Program Name   : modSemName
    * Author         : Luke Cavanaugh
    * Date           : 5 March 2016
    * Course/Section : CSC - 264
    * Program Description:
    *
    * Methods:
    * -------
    * modSemName() -
    *
    * BEGIN modSemName()
    *    Concatinate prefix, number, grade, credits, gradePoints
    *    Return result
    * END modSemName()
    **********************************************************/

    public String modSemName (String semesterName)
	{

     //set semester name
     this.semesterName = semesterName;

     /********************   Start modSemName method  *****************/

     //Return result
	  return semesterName;

	}//END modSemName


    /**********************************************************
	* Program Name   : getSemName()
	* Author         : Luke Cavanaugh
	* Date           : 5 March 2016
	* Course/Section : CSC - 264
	* Program Description: This will return the semester name
	*
    * BEGIN getSemName()
	*    return smester name
	* END getSemName()
    **********************************************************/

   public String getSemName()
   {

    /***************** Begin getSemName() ********************/

     return semesterName;

   }


   /**********************************************************
   	* Program Name   : getTotalGrdPts()
   	* Author         : Luke Cavanaugh
   	* Date           : 5 March 2016
   	* Course/Section : CSC - 264
   	* Program Description: This will return the grade points
   	*
    * BEGIN getTotalGrdPts()
   	*    return totalGrdPts
   	* END getTotalGrdPts()
    **********************************************************/

   public double getTotalGrdPts()
   {

    /***************** Begin getTotalGrdPts() ********************/

     return totalGrdPts;

   }

   /**********************************************************
   * Program Name   : getTotalCrdHrs()
   * Author         : Luke Cavanaugh
   * Date           : 5 March 2016
   * Course/Section : CSC - 264
   * Program Description: This will return the credit hours
   *
   * BEGIN getTotalCrdHrs()
   *    return totalCrHrs
   * END getTotalCrdHrs()
   **********************************************************/

   public int getTotalCrdHrs()
   {

	/***************** Begin getTotalGrdPts() ********************/

     return totalCrHrs;

   }

     /**************************************************************
	 * Program Name   : courseSearch
	 * Author         : Luke Cavanaugh
	 * Date           : 5 March 2016
	 * Course/Section : CSC - 264
	 * Program Description: This method allows for a course
	 *    to be found in the array
	 *
	 * BEGIN courseSearch
	 *    FOR(executes through all courses and returns
	 *       IF(prefix and number are found in array at current position
	 *          return course
	 *       END IF
	 *       ElSE
	 *          return null
	 *       END IF
	 *    END FOR
	 * END courseSearch
	 **************************************************************/

     public CourseInfo courseSearch(String prefix, int number)
     {

	    //Local Constants

	    //local Variables
        String coursePrefix = prefix;    //takes course prefix
	    int    courseNum    = number;    //takes course number


        /********************   Start courseSearch method  *****************/

         //executes through all courses and returns
         for(int i = 0; i < courseCount; i++)
	     {
		    //if prefix & number are found in array at current position
		    if((coursePrefix.equalsIgnoreCase(courses[i].prefix) && courseNum == (courses[i].number)))
		    {

		       //return course
		       return courses[i];

		    }//end if

	    }//ends for loop

        return null;

     }//end course search

   	 /**************************************************************
   	 * Program Name   : removeCourse
   	 * Author         : Luke Cavanaugh
   	 * Date           : 5 March 2016
   	 * Course/Section : CSC - 264
   	 * Program Description: This method removes courses
   	 *
   	 * BEGIN studentInfo
   	 *    create new array to load in course s
   	 *    FOR (executes through valid courses
   	 *       IF (course prefix and number are found
   	 *    FOR (cycle array starting at target)
   	 *       course to be removed is replaced by next course, etc
   	 *    END for
   	 *    FOR (cyclce through courses and move to new array
   	 *    END for
   	 *    clear old array
   	 *    FOR (cycle through array for every course)
   	 *       place data back in usable array
   	 *       print completion message
   	 *       decrement course count
   	 *       decrement total credit hours
   	 *       decrement total grade points
   	 *       return course
   	 *    END if
   	 *    END for loop
   	 *    return null if course not found
   	 * END courseRemove
   	 **************************************************************/

   	 public CourseInfo removeCourse(String prefix, int number)
   	 {
   	    //Local Constants

   	 	//local Variables
        String coursePrefix = prefix;    //takes course prefix
	    int    courseNum    = number;    //takes course number

   	 	/********************   Start removeCourse method  *****************/

   	 	 //create new array to load in courses
         CourseInfo[] courses2 = new CourseInfo[courseCount-1];

          //for (executes through valid courses
          for(int i = 0; i < courseCount; i++)
   		 {

   			//if (course prefix and number are found
   			if(coursePrefix.equals(courses[i].prefix) && courseNum == courses[i].number)
   			{

               //for (cycle array starting at target)
               for(int w = i; w < courseCount-1; w++)
               {

                  //course to be removed is replaced by next course, etc
                  courses[w] = courses[w+1];
			   }//end for

			     //for (cyclce through courses and move to new array
   				 for(int h=0; h < courseCount-1; h++)
   				 {

   				   courses2[h] = courses[h];

   			     }//end for

                //clear old array
                courses = new CourseInfo[7];

                //for (cycle through array for every course)
                for (int l = 0; l < courses2.length; l++)
                {
				   //place data back in usable array
                   courses[l] = courses2[l];
			    }


                 //decrement course count
                 courseCount--;

                 //decrement total credit hours
                 totalCrHrs  -=  courses[i].credits;

                 //decrement total grade points
                 totalGrdPts -=  courses[i].gradePoints;

                //return course
                return courses[i];

           }//END if

        }//END for

   		 //return null if not found
   		 return null;

   	 }//END removeCourse

}//END SemesterInfo


