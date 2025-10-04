/**
 Homework 4
 Description: Use "if else if" with logical operators (&&, ||) from Chapter 3
 and JOptionPane from Chapter 2 to make a Leap Year Calculator.
 @author Shrestha Nayak
 */

import javax.swing.*;

public class Homework4_96785 {
    public static void main(String[] args) {
        String stringYear = JOptionPane.showInputDialog("This program determines leap year, written by Shrestha Nayak." +
                "\nEnter a year (not earlier that 1582):");

        int intYear = Integer.parseInt(stringYear);

        if (intYear < 1582){
            JOptionPane.showMessageDialog(null, "There was no leap year before 1582.");
        }
        else if (intYear % 4 == 0 && intYear % 100 != 0 || intYear % 400 == 0) {
            JOptionPane.showMessageDialog(null,"The year " + intYear + " is a leap year.");
        }
        else {
            JOptionPane.showMessageDialog(null,"The year " + intYear + " is not a leap year.");
        }

        System.exit(0);
    }
}