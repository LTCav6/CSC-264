/**********************************************************
 * Program Name   : Skater
 * Author         : Luke Cavanaugh
 * Date           : 15 April 2016
 * Course/Section : CSC - 264
 * Program Description: This program will create a skater
 *    object
 *
 * Variables and Objects:
 * -------
 *   -  score             : int
 *   -  name              : String
 *
 * Methods:
 * -------
 * setName()  - sets skaters name
 * setScore() - sets skaters score
 * getName()  - gets skaters name
 * getScore() - gets skaters score
 *
 ***********************************************************/

import javax.swing.JFrame;
import java.util.*;

public class skater
{

   private String name;
   private int score;

	/**********************************************************
	* Program Name   : skater (constructor)
	* Author         : Luke Cavanaugh
	* Date           : 15 April 2016
	* Course/Section : CSC - 264
	* Program Description: This method will create a new skater
	*
	* Variables and Objects
	* ------------------------
	* name  : String
	* score : int
	*
    **********************************************************/
	public skater(String name, int score)
	{

      //local constants

      //local variables
      this.name      = name;	    //first name
      this.score	 = score;		//skater total score

  	 } //END


	/**********************************************************
	* Program Name   : setName
	* Author         : Luke Cavanaugh
	* Date           : 15 April 2016
	* Course/Section : CSC - 264
	* Program Description: This method will set skaters name
	*
	* Variables and Objects
	* ------------------------
	* name : String
	*
    **********************************************************/
	public void setName(String sName)
	{

		//sets first name
		name = sName;

	} //END

	/**********************************************************
	* Program Name   : setScore
	* Author         : Luke Cavanaugh
	* Date           : 15 April 2016
	* Course/Section : CSC - 264
	* Program Description: This method will set skaters score
	*
	* Variables and Objects
	* ------------------------
	* score : int
	*
    **********************************************************/
	public void setScore(int ttlScore)
	{

		//sets score
		score = ttlScore;

	}//END

	/**********************************************************
	* Program Name   : getName
	* Author         : Luke Cavanaugh
	* Date           : 15 April 2016
	* Course/Section : CSC - 264
	* Program Description: This method will get skaters name
	*
	* Variables and Objects
	* ------------------------
	* name : String
	*
    **********************************************************/
	public String getName()
	{

		//returns first name
		return name;

	}//END

	/**********************************************************
	* Program Name   : getScore
	* Author         : Luke Cavanaugh
	* Date           : 15 April 2016
	* Course/Section : CSC - 264
	* Program Description: This method will get skaters score
	*
	* Variables and Objects
	* ------------------------
	* score : int
	*
    **********************************************************/
	public int getScore()
	{

		//returns score
		return score;

	}//END

	/**********************************************************
	* Program Name   : setName
	* Author         : Luke Cavanaugh
	* Date           : 15 April 2016
	* Course/Section : CSC - 264
	* Program Description: This method will set skaters name
	*
	* Variables and Objects
	* ------------------------
	* info  : String
	* name  : String
	* score : int
    **********************************************************/
	public String toString()
	{

		 //concatinate name and score
		 String info = this.name + "\t" + this.score;

		 //return score
		 return info;

	}//END

}// END CLASS
