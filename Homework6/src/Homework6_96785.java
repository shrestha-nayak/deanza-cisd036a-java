/**
 Author: Shrestha Nayak
 Homework 6
 This program generates and displays numbers that are divisible by certain input divisor values.
*/

import java.util.Scanner;

public class Homework6_96785 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        final int MIN_NUMBER = 10;
        final int MAX_NUMBER = 500;

        System.out.println("This programs displays all numbers divisible by a certain" +
                " divisor starting from 10.");

        System.out.print("\nEnter a divisor from 2–10: ");

        int divisor = scnr.nextInt();
        while (divisor < 2 || divisor > 10) {
            System.out.println("Input " + divisor + " is not in the range of 2 to 10. ");
            System.out.print("Enter a divisor from 2–10: ");
            divisor = scnr.nextInt();
        }

        System.out.print("Enter the largest number to be generated. " +
                "It must be in the range of 10-500: ");

        int largestNumber = scnr.nextInt();
        while (largestNumber < MIN_NUMBER || largestNumber > MAX_NUMBER) {
            System.out.println("Input " + largestNumber + " is not in the range of 10-500. ");
            System.out.print("Enter the largest number to be generated. " +
                    "It must be in the range of 10-500: ");
            largestNumber = scnr.nextInt();
        }

        System.out.println("\nGenerated numbers divisible by " + divisor + " from "
                + MIN_NUMBER + " to " + largestNumber + ":\n");

        int count = 0;
        int sum = 0;

        for (int num = MIN_NUMBER; num <= largestNumber; num++) {
            if (num % divisor == 0 && count % 15 == 14) {
                System.out.printf("%6d\n", num);
                count++;
                sum += num;
            } else if (num % divisor == 0) {
                System.out.printf("%6d", num);
                count++;
                sum += num;
            }
        }

        System.out.printf("\n\n%s %11d", "Total sum:", sum);
        System.out.printf("\n%s %15d", "Count:", count);

        if (count > 0) {
            double average = (double) sum / count;
            System.out.printf("\n%s %13.2f", "Average:", average);
        }
    }
}