/*
Homework #2
This program reads user data & calculates surface area & volume of a cuboid.
Author: Shrestha Nayak
 */

import java.util.Scanner;

public class Homework2_96785 {

    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);

        System.out.println("My name is Shrestha Nayak.");
        System.out.println("This program calculates the volume and surface area of a cuboid.");

        double length;
        System.out.print("Enter the cuboid length: ");
        length = scnr.nextDouble();

        double height;
        System.out.print("Enter the cuboid height: ");
        height = scnr.nextDouble();

        double width;
        System.out.print("Enter the cuboid width: ");
        width = scnr.nextDouble();

        double cuboidVolume;
        cuboidVolume = height * length * width;

        double surfaceArea;
        surfaceArea = (2 * width * length) + (2 * length * height) + (2 * height * width);

        System.out.println("\nVolume of the cuboid with length " + length + ", width " + width
                + ", height " + height + " is " + cuboidVolume);
        System.out.println("Surface area of the cuboid with length " + length + ", width " + width
                + ", height " + height + " is " + surfaceArea);
    }
}