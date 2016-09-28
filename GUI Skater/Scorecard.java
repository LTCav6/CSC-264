/**********************************************************
 * Program Name   : ScoreCard
 * Author         : Luke Cavanaugh
 * Date           : 15 April 2016
 * Course/Section : CSC - 264
 * Program Description: This program will take
 *    a panel of judge's scores for olympic
 *    skaters and display.
 *
 *
 * Variables and Objects:
 * -------
 *   -  frame             : JFrame
 *   -  panel             : ScorecardPanel
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

public class Scorecard
{
   //-----------------------------------------------------------------
   //  Creates and displays the temperature converter GUI.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {

      //-----------------------------------------------------------------
	  //  Begin Main Method
      //-----------------------------------------------------------------

      //create the scorers table frame
      JFrame frame = new JFrame("Scorer's Table");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //create new scorers table panel and add to frame
      ScorecardPanel panel = new ScorecardPanel();
      frame.getContentPane().add(panel);

      //set frame visible
      frame.pack();
      frame.setVisible(true);



   }
}
