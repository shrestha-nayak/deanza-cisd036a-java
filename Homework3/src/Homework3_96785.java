/**
 Homework 3
 @author Shrestha Nayak
 @since   2025-7-7
 Program purpose: Gets input from user and calculates and
 displays the focus, area, and perimeter of an eclipse.
 */

import javax.swing.*;

public class Homework3_96785 {
    public static void main(String[] args) {
        String numberString = JOptionPane.showInputDialog("Program to calculate ellipse geometry." +
                "\n Enter the major radius:");
        double majorRadius = Double.parseDouble(numberString);

        numberString = JOptionPane.showInputDialog("Enter the minor radius:");
        double minorRadius = Double.parseDouble(numberString);

        double focus = Math.sqrt(Math.pow(majorRadius, 2) - Math.pow(minorRadius, 2));
        double area = Math.PI * majorRadius * minorRadius;
        double perimeter = Math.PI * (3 * (majorRadius + minorRadius)
                - Math.sqrt(10 * majorRadius * minorRadius + 3
                * (Math.pow(majorRadius, 2) + Math.pow(minorRadius, 2))));
        JOptionPane.showMessageDialog(null, "Focus: " + focus
                + "\nArea: " + area + "\nPerimeter: " + perimeter);
        System.exit(0);
    }
}