/**********************************************************
 * Program Name   : StudentGPAcalculator
 * Author         : Luke Cavanaugh
 * Date           : 5 March 2016
 * Course/Section : CSC - 264
 * Program Description: This program will calculate a GPA
 *    for students
 *
 * Variables and Objects:
 * -------
 *   -  courses        : CourseInfo[]
 *   +  SEMAX          : final int
 *   +  prefix         : String
 *	 +  number         : int
 *   +  credits        : int
 *   +  grade          : float
 *   +  gradePoints    : float
 *   +  choice         : int
 *   +  exit           : int
 *   +  semesterName   : String
 *   +  firstName      : String
 *   +  lastName       : String
 *   +  semChoice      : String
 *   +  formatter      : NumberFormat
 *
 * Methods:
 * -------
 * Main - Tester for driver class
 *
 * Pseudocode:
 * ----------
 *
 *  BEGIN GPAcalculator
 *     print heading
 *     prompt for first name
 *     prompt for last name
 *     create student with credentials
 *     get default semester name
 *     create new semester with semester name
 *     add semester to  array
 *     print menu
 *     prompt for choice
 *     WHILE choice != quit
 *        SWITCH (choice)
 *
 *           BEGIN case 1: create semester
 *             clear screen
 *  			   prompt for new semester name
 *              create new semester
 *              add semester to course
 *           END case 1
 *
 *           BEGIN case 2: add course
 *              clear screen
 *              print header
 *              print list of exisitng semesters to choose from
 *              prompt the user fpr the semester the course will be placed in
 *              prompt for course prefix
 *              WHILE (prefix != quit)
 *                 prompt for user course number
 *                 prompt for credits
 *                 prompt for grade
 *                 create new course
 *                 seearch for semester
 *                 IF semester is null print error
 *                 ELSE add course
 *                 prompt for course information
 *            END WHILE
 *          END case 2: add course
 *
 *          BEGIN case 3: print courses
 *             print out all courses
 *          END case 3: print courses
 *
 *          BEGIN case 4 search courses
 *             prompt for prefix
 *             prompt for course number
 *             IF (course is found)
 *                display course found
 *             ELSE display course not found
 *          END case 4
 *
 *          BEGIN case 5: removeCourse
 *             print exisiting courses
 *             prompt for semester to remove course from
 *             prompt for prefix
 *             prompt for course number
 *             IF semester returns valid value
 *                print success
 *             ELSE
 *                display course not found message
 *          END case 5
 *
 *          BEGIN case 6 EXIT
 *               set exit variable value to exit(-1)
 *          END CASE 6
 *       END SWITCH
 *       print menu
 *       prompt for menu choice
 *    END WHILE
 *  END MAIN
 * END CLASS
 *
 **********************************************************/
import java.text.*;

public class GPAcalculator
{
   public static void main (String [] args)
   {
      //Library64 myLib = new Library64();
      //Library myLib = new Library();

      final int SEMAX = 12;                                //max number of semesters
      String prefix;                                       //course prefix
	  int number;                                          //course number
      int credits = 0;                                     //course credits
      float grade = 0;                                     //course grade
      float gradePoints = 0;                               //grade points
      int choice = 0;                                      //user choice
      int exit = 0;                                        //exit value
      String semesterName = "";                            //name of semester
      String firstName;                                    //student first name
      String lastName;                                     //student last name
      String semChoice = "";           					   //semester choice
      NumberFormat formatter = new DecimalFormat("#0.00"); //enables decimal formatting

      /******************** Start main method  *****************/

      //print heading
      System.out.print(Util.setLeft(32,"--Transcript Tracker--\n\n\n"));

      //prompt for first name
      System.out.println(Util.setLeft(35,"--New Student--"));
      System.out.print(Util.setLeft(32,"Enter first name : "));
      firstName = Keyboard.readString();

      //prompt for last name
      System.out.print(Util.setLeft(32,"Enter last name  : "));
      lastName = Keyboard.readString();

      //create student with credentials
      StudentInfo student = new StudentInfo(firstName, lastName, SEMAX);

      //get default semester name
      System.out.print(Util.setLeft(32,"Enter default semester name  : "));
      semesterName = Keyboard.readString();

      //create new semester with semester name
      SemesterInfo semester = new SemesterInfo(semesterName);

      //add semester to array
      student.addSemester(semester);

     //print menu
	      System.out.println("");
	      System.out.println(Util.setLeft(38, "--Menu--"));
	      System.out.println(Util.setLeft(32, "1) Add Semester"));
	      System.out.println(Util.setLeft(32, "2) Add Course" ));
	      System.out.println(Util.setLeft(32, "3) View Transcript" ));
	      System.out.println(Util.setLeft(32, "4) Course Search" ));
	      System.out.println(Util.setLeft(32, "5) Remove Course" ));
	      System.out.println(Util.setLeft(32, "6) Quit Program "));
          System.out.println("");

     //prompt for choice
     System.out.print(Util.setRight(44,"Menu Choice : "));
     choice = Keyboard.readInt();

  //execute until user hits sentinel (7)
  while (choice != 6)
  {

      //begin switch
      switch (choice)
      {

         //case 1 : Create Semester
         case 1:

			//myLib.clrscr();

            //prompt for new semester name
            System.out.print(Util.setLeft(32,"Enter new semester name  : "));
            semesterName = Keyboard.readString();

            //creates new semester
            semester = new SemesterInfo(semesterName);

            //add semester to course
            student.addSemester(semester);

         //end case 1
         break;


         //case 2: Add Course
         case 2:

            //myLib.clrscr();

            //print header
            System.out.println(Util.setLeft(32,"--- Current Semesters -- : \n"));

            //print list of existing semesters for user to choose from
            System.out.print(student.toString());
            System.out.println("\n");

            //prompt for the semester the user wants to add the course to
            System.out.print(Util.setLeft(20,"Enter Semester Name you would like to add new course(s) to : "));
            semChoice = Keyboard.readString();

            //prompt for course information
            System.out.print(Util.setLeft(32,"Enter Course prefix or -1 : \t"));
            prefix = Keyboard.readString();

            //while prefix != -1
            while (!prefix.equals("-1"))
            {
               //prompt for course number
               System.out.print(Util.setLeft(32,"Enter course number : \t\t"));
               number = Keyboard.readInt();

               //prompt for credits
               System.out.print(Util.setLeft(32,"Enter course credits : \t\t"));
               credits = Keyboard.readInt();

               //prompt for grade
               System.out.print(Util.setLeft(32,"Enter course grade : \t\t"));
               grade = Keyboard.readFloat();

               //create new course
               CourseInfo course = new CourseInfo(prefix, number, credits, grade);

               //selects semester
               semester = student.semSearch(semChoice);

               //if semester == null, print error
               if (semester == null)
               System.out.println("Semester not found\n");

               //else add course
               else
               semester.addCourse(course);


               //prompt for course information
               System.out.print(Util.setLeft(32,"Enter Course prefix or -1 : \t"));
               prefix = Keyboard.readString();

            }//end add course while

          break; //end add course

          //case 3: print courses
          case 3:

             //myLib.clrscr();

             //print out courses - call toString in StudentInfo
             System.out.println(student.toString());

          break; //end add course

		  //case 4: search courses
          case 4:

                //Prompt user for prefix
				System.out.print(Util.setLeft(32, "Enter course prefix : "));
				prefix = Keyboard.readString();

				//Prompt user for course number
				System.out.print(Util.setLeft(32, "Enter course number : "));
	            number = Keyboard.readInt();

	            //if course is found
	            if(semester.courseSearch(prefix, number) != null)
	             {

					  //Displays your course was found to the user
					  System.out.println(Util.setLeft(32,"Course Found : ")
					  + "\n" + semester.courseSearch(prefix, number));
				 }

				  //else if course does not exist
				  else
				  {
					  //Print course DNE
					  System.out.println(Util.setLeft(32,"Course not found in semester"));
				  }

                  break;

           //case 5: Remove Course
           case 5:

					  //myLib.clrscr();

		      //Print existing courses
			  System.out.println("\n" + Util.setLeft(12,"Semesters : "));

			  //Prints courses
			  System.out.println(student.toString());

		    //prompt for the semester the user wants to add the course to
					  System.out.print(Util.setLeft(16,"Enter Semester Name you would like to add new course(s) to : "));
                      semChoice = Keyboard.readString();

					  //Prompt for course prefix
					  System.out.print("\n" + Util.setLeft(32, "Enter course prefix         : "));
					  prefix = Keyboard.readString();

					  //Prompt user for course number
					  System.out.print("\n" + Util.setLeft(32, "Enter course number         : "));
					  number = Keyboard.readInt();

					 //selects semester
					 semester = student.semSearch(semChoice);

					 //if semester returns valid value
					 if(semester.removeCourse(prefix, number) != null)
					  {
						  //Print success
						  System.out.println("\n" + Util.setLeft(16,"Course Removed Successfully"));

					  }

					 //else print course not found
					 else
					  {

						  //Displays course was not found to the user
						  System.out.println(Util.setLeft(16,"Course was not found!"));
				      }


          break;


          //exit
          case 6:

            //set exit value to exit
            exit = 1;

          break;//end exit


    } //end switch


     //print menu
     System.out.println("");
     System.out.println(Util.setLeft(38, "--Menu--"));
     System.out.println(Util.setLeft(32, "1) Add Semester"));
     System.out.println(Util.setLeft(32, "2) Add Course" ));
     System.out.println(Util.setLeft(32, "3) View Transcript" ));
     System.out.println(Util.setLeft(32, "4) Course Search" ));
     System.out.println(Util.setLeft(32, "5) Remove Course" ));
     System.out.println(Util.setLeft(32, "6) Quit Program "));
     System.out.println("");

     //Prompt for menu choice
     System.out.print(Util.setRight(44,"Menu Choice : "));
     choice = Keyboard.readInt();

  } //end while

 } //end main

} //end class