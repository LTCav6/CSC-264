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
*
*START ScoreCard
* set window size
* set background
* create outter panel and settings
* create title panel and settings
* create input panel and settings
* create result panel and settings
* creat exit panel and settings
* create button panel and settings
* set title text
* create judge labels
* create new text field and add
* create new judge text fields with labels
* add button to calculate total score
* add button to show players and scores
* add button to save
* add button to exit program
* add label to exit panel
* add title to panel
* add output label to button panel
* add result label to button panel
* add space to separate
* add total button to button panel
* add save button to button panel
* add end button to button panel
* add exit button
* add label to exit button
* add panels
*END ScoreCard
*
*BEGIN ScoreListener
* get list of scores
* if any boxes are empty set error to 1
* if any of the score boxes are empty, set error code to 1
* if error: set judge score to 0
* else gather scores
* if total is hit
*    add scores to array
*    sort array
*    add to total
*    set label to scores
* end else
* else if save button is hit
*    set skater name to equal the text field
*    add skater to array at next position
*    increment count
*    clear fields
* end else
* else if end button is clicked
*    create new text box
* for cycle through array and print contents
*    displays the contents followed by a new line
*    adds scores and names to a text box
* end for
* add scores and names to panel
* remove the score panel
* remove the buttons panel
* add the result panel
* add the exit button
* end else
* else if exit is clicked
* exit program
*END ScoreListener
****************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class ScorecardPanel extends JPanel
{

   //local variables
   private skater[] skaterArray = new skater[10];	//holds skater objects
   private JLabel inputLabelJ1;						//judge 1 input
   private JLabel inputLabelJ2;						//judge 2 input
   private JLabel inputLabelJ3;						//judge 3 input
   private JLabel inputLabelJ4;						//judge 4 input
   private JLabel inputLabelJ5;						//judge 5 input
   private JLabel outputLabel;						//name label
   private JLabel resultLabel;						//score label
   private JLabel playerLabel;						//player label
   private JLabel title;							//prints title
   private JLabel exitLabel;						//final label
   private JTextField judge1;						//judge score box
   private JTextField judge2;						//judge score box
   private JTextField judge3;						//judge score box
   private JTextField judge4;						//judge score box
   private JTextField judge5;						//judge score box
   private JTextField playerText;					//displays player name box
   private JTextArea result;						//text box that holds scores and names
   private JButton totalButton;						//calcs total score
   private JButton saveButton;						//saves score
   private JButton endButton;						//shows results
   private JButton exitButton;						//exits program
   private int error;								//toggles an error
   private int count = 0;							//counter
   private int judge1Score;							//judges scores
   private int judge2Score;							//judges scores
   private int judge3Score;							//judges scores
   private int judge4Score;							//judges scores
   private int judge5Score;							//judges scores
   private int total;								//total score
   private String playerName = "";					//default player name
   private String holder ="Name" + "\t" + "Score" + "\t\t";	//concats thename and score
   private JLabel space; 		 				    //adds space
   private JPanel menuPanel;						//outter most panel
   private JPanel titlePanel;						//holds title
   private JPanel inputPanel;						//holds score boxes
   private JPanel exitPanel;						//holds exit button
   private JPanel resultPanel;						//holds player names and scores
   private JPanel buttonPanel;						//holds save, results, and total buttons


   //-----------------------------------------------------------------
   //  Constructor: Sets up the main GUI components.
   //-----------------------------------------------------------------
   public ScorecardPanel()
   {


	  /*********************** Begin ScorecardPanel *****************/


      //set window size
      setPreferredSize(new Dimension(400, 400));

      //set background
      setBackground(Color.green);

      //create outter panel and settings
      menuPanel = new JPanel();
      menuPanel.setPreferredSize(new Dimension(350, 350));
      menuPanel.setBackground(Color.blue);

      //create title panel and settings
      titlePanel = new JPanel();
	  titlePanel.setPreferredSize(new Dimension(325, 50));
      titlePanel.setBackground(Color.yellow);

      //create input panel and settings
      inputPanel = new JPanel();
	  inputPanel.setPreferredSize(new Dimension(250, 175));
      inputPanel.setBackground(Color.yellow);

      //create result panel and settings
      resultPanel = new JPanel();
	  resultPanel.setPreferredSize(new Dimension(325, 175));
      resultPanel.setBackground(Color.yellow);

      //creat exit panel and settings
      exitPanel = new JPanel();
 	  exitPanel.setPreferredSize(new Dimension(250, 100));
      exitPanel.setBackground(Color.yellow);

	  //create button panel and settings
      buttonPanel = new JPanel();
	  buttonPanel.setPreferredSize(new Dimension(250, 100));
      buttonPanel.setBackground(Color.yellow);

      //set title text
      title = new JLabel("2016 Olympic Ice Skating Scorer's Table");
      title.setFont(new Font("Verdana", Font.BOLD, 14));

      //creates a new Jlabel
      inputLabelJ1 = new JLabel("Enter Judge 1 score :            ");

	  //creates a new Jlabel
      inputLabelJ2 = new JLabel("Enter Judge 2 score :            ");

      //creates a new Jlabel
      inputLabelJ3 = new JLabel("Enter Judge 3 score :            ");

      //creates a new Jlabel
      inputLabelJ4 = new JLabel("Enter Judge 4 score :            ");

      //creates a new Jlabel
      inputLabelJ5 = new JLabel("Enter Judge 5 score :            ");

      //creates a new Jlabel
      playerLabel = new JLabel("Skater : ");

	  //creates a new Jlabel
	  outputLabel = new JLabel("Total Score         : ");

      //creates a new Jlabel
      resultLabel = new JLabel("----------");

	  //create new text field and add
	  playerText = new JTextField(15);
	  playerText.addActionListener(new ScoreListener());
	  inputPanel.add(playerLabel);
	  inputPanel.add(playerText);

      //create new judge text field and label
      judge1 = new JTextField(5);
      judge1.addActionListener(new ScoreListener());
      inputPanel.add(inputLabelJ1);
      inputPanel.add(judge1);

	  //create new judge text field and label
      judge2 = new JTextField(5);
      judge2.addActionListener(new ScoreListener());
      inputPanel.add(inputLabelJ2);
      inputPanel.add(judge2);

      //create new judge text field and label
      judge3 = new JTextField(5);
      judge3.addActionListener(new ScoreListener());
      inputPanel.add(inputLabelJ3);
      inputPanel.add(judge3);

      //create new judge text field and label
      judge4 = new JTextField(5);
      judge4.addActionListener(new ScoreListener());
      inputPanel.add(inputLabelJ4);
      inputPanel.add(judge4);

      //create new judge text field and label
      judge5 = new JTextField(5);
      judge5.addActionListener(new ScoreListener());
      inputPanel.add(inputLabelJ5);
      inputPanel.add(judge5);

      //add button to calculate total score
      totalButton = new JButton("Total");
      totalButton.addActionListener(new ScoreListener());

      //add button to show players and scores
      endButton = new JButton("Results");
      endButton.addActionListener(new ScoreListener());

      //add button to save
      saveButton = new JButton("Save");
      saveButton.addActionListener(new ScoreListener());

      //add button to exit program
      exitButton = new JButton("Exit");
      exitButton.addActionListener(new ScoreListener());

	  //add label to exit panel
	  exitLabel = new JLabel ("  Congratulations!  ");
	  exitLabel.setFont(new Font("Verdana", Font.BOLD, 18));

      //add title to panel
      titlePanel.add(title);

      //add output label to button panel
      buttonPanel.add(outputLabel);

      //add result label to button panel
      buttonPanel.add(resultLabel);

	  JLabel space = new JLabel("               ");

	  //add space to separate
      buttonPanel.add(space);

      //add total button to button panel
      buttonPanel.add(totalButton);

      //add save button to button panel
      buttonPanel.add(saveButton);

      //add end button to button panel
      buttonPanel.add(endButton);

      //add exit button
      exitPanel.add(exitButton);

      //add label to exit button
      exitPanel.add(exitLabel);

      //add menu panel
      add(menuPanel);

      //add title panel
      menuPanel.add(titlePanel);

      //add input panel
      menuPanel.add(inputPanel);

      //add result panel
      menuPanel.add(resultPanel);

      //add exit panel
      menuPanel.add(exitPanel);

      //set result panel to invisible
      resultPanel.setVisible(false);

      //set exit panel to invisible
      exitPanel.setVisible(false);

	  //add button panel to menu
	  menuPanel.add(buttonPanel);

    }//end scorecard

   //*****************************************************************
   //  Represents an action listener for the temperature input field.
   //*****************************************************************
   private class ScoreListener implements ActionListener
   {


      //--------------------------------------------------------------
      //  Performs the conversion when the enter key is pressed in
      //  the text field.
      //--------------------------------------------------------------
      public void actionPerformed(ActionEvent event)
      {

         //get list of scores
         String score1 = judge1.getText();
		 String score2 = judge2.getText();
		 String score3 = judge3.getText();
		 String score4 = judge4.getText();
		 String score5 = judge5.getText();

		 //if any boxes are empty set error to 1
		 if(judge1.getText().isEmpty() || judge2.getText().isEmpty() || judge3.getText().isEmpty() || judge4.getText().isEmpty() ||judge5.getText().isEmpty())
		 {

		 //if any of the score boxes are empty, set error code to 1
		 error = 1;

		 //error: set judge score to 0
		 judge1Score = 0;

         //error: set judge score to 0
         judge2Score = 0;

         //error: set judge score to 0
         judge3Score = 0;

         //error: set judge score to 0
         judge4Score = 0;

         //error: set judge score to 0
         judge5Score = 0;

	     }

		 //else gatther scores
         else
         {

		 //turn off error
	     error = 0;
		 judge1Score = Integer.parseInt(score1);
         judge2Score = Integer.parseInt(score2);
         judge3Score = Integer.parseInt(score3);
         judge4Score = Integer.parseInt(score4);
         judge5Score = Integer.parseInt(score5);

	     }

         //if total is hit
         if (event.getSource() == totalButton)
            {
				if (error == 1)
				resultLabel.setText("Error    ");

				else
				{

				//add scores to array
				int[] Array = {judge1Score, judge2Score, judge3Score, judge4Score, judge5Score};

				//sort array
				Arrays.sort(Array);

				//add to total
				total = Array[1] + Array[2] + Array[3];

                //set label to scores
                resultLabel.setText(Integer.toString(total) + "     ");

			   }//end else

		    }//end if

         //else if save button is hit
         else if (event.getSource() == saveButton)
         {

		    //set skater name to equal the text field
		    playerName = playerText.getText();

		    //add skater to array at next position
		    skaterArray[count] = new skater(playerName, total);

		    //increment count
		    count++;

			//clear fields
            playerText.setText("");
            resultLabel.setText("----------");
            judge1.setText("");
            judge2.setText("");
            judge3.setText("");
            judge4.setText("");
            judge5.setText("");

	     }// end else

		//else if end button is clicked
	    else if (event.getSource() == endButton)
	    {

		    //create new text box
		    result = new JTextArea(2, 20);
		    result.setText(holder);
		    result.setWrapStyleWord(true);
            result.setLineWrap(true);
            result.setFont(new Font("Verdana", Font.BOLD, 13));
            result.setBackground(Color.yellow);

		    //cycle through array and print contents
		    for (int i =0; i < count; i++)
		    {

		       //displays the contents followed by a new line
		       holder += skaterArray[i].toString() + "\n";

		       //adds scores and names to a text box
			   result.setText(holder);

		    }//end for

			//add scores and names to panel
			resultPanel.add(result);

            //remove the score panel
            inputPanel.setVisible(false);

            //remove the buttons panel
            buttonPanel.setVisible(false);

            //add the result panel
            resultPanel.setVisible(true);

            //add the exit button
            exitPanel.setVisible(true);

		}//end else

         //else if exit is clicked
         else if (event.getSource() == exitButton)
         {

		  //exit program
		  System.exit(0);

	     }// end else


      }//end action listener


   }// end other listener


}//end class



//title
//error