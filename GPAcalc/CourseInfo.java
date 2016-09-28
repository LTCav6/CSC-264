/**********************************************************
 * Program Name   : CourseInfo
 * Author         : Luke Cavanaugh
 * Date           : 5 March 2016
 * Course/Section : CSC - 264
 * Program Description: This program will create a course
 *    object
 *
 * Variables and Objects:
 * -------
 *   -  String             : prefix
 *   -  number             : int
 *   -  credits            : int
 *   -  grade              : double
 *   -  gradePoints        : double
 *
 * Methods:
 * -------
 * CourseInfo()  - calculates the average of 2 quiz grades
 * toString()    - converts course info to string
  **********************************************************/

//needed for formatting to two decimal places in toString()
import java.text.*;

public class CourseInfo
{

    //local constants
	//none in this program

    //local variables
    public String prefix;            //course prefix
    public int number;               //course number
    public int credits;              //course creditHours
    public double grade;             //course grade
    public double gradePoints;       //grade points earned

    /**********************************************************
    * Program Name   : CourseInfo
    * Author         : Luke Cavanaugh
    * Date           : 5 March 2016
    * Course/Section : CSC - 264
    * Program Description: Constructor for new courses
    *
    * Methods:
    * -------
    * CourseInfo - constructs new course
    *
    * BEGIN CourseInfo()
    *    Set variables using this operator
    * END CourseInfo()
    **********************************************************/

    public CourseInfo(String prefix, int number, int credits, double grade)
	{

      //Set variables using this operator
      this.prefix    = prefix;           //sets course prefix
	  this.number    = number;           //sets course number
	  this.credits   = credits;          //sets course creditHours
	  this.grade     = grade;            //sets course grade
      gradePoints    = credits * grade;  //sets grade points earned

	 /********************   Start courseInfo method  *****************/

	} //END CourseInfo

    /**********************************************************
    * Program Name   : toString
    * Author         : Luke Cavanaugh
    * Date           : 5 March 2016
    * Course/Section : CSC - 264
    * Program Description: Formats course info and returns
    *
    * Methods:
    * -------
    * toString() - returns course info
    *
    * BEGIN toString()
    *    Concatinate prefix, number, grade, credits, gradePoints
    *    Return result
    * END toString()
    **********************************************************/

    public String toString()
	{

    /******************** Start toString() method  *****************/

      //Sets formatting to two decimal places
      NumberFormat formatter = new DecimalFormat("#0.00");

      //Concatinate prefix, number, grade, credits, gradePoints
      String result = Util.setLeft(32, prefix + " " + number)
      + "\t  " + formatter.format(grade)
      + "\t          " + credits + "\t       "
      + formatter.format(gradePoints);

      //Return result
	   return result;

	}//END toString

}//END CourseInfo