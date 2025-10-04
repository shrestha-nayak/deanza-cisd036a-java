/**
 Midterm C1
 Author: Shrestha Nayak
 Program Purpose: Virtual Game Store where the total price and tax are
 calculated based on the user's purchase choices.
 */

import java.util.Scanner;

public class MidtermC1_96785 {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        final double TAX_RATE = 0.0925;
        final double PRICE_NEW_16 =  499.99;
        final double PRICE_NEW_32 = 549.99;
        final double PRICE_REFURB_16 = 419.99;
        final double PRICE_REFURB_32 = 429.99;
        final double PRICE_DENTED_16 = 339.99;
        final double PRICE_DENTED_32 = 359.99;

        System.out.println("Welcome to CIS36A Game Store.\nHere is the price list:\n");

        //Formating and displaying the price list
        System.out.printf("%25s %24s %24s %24s\n", "Memory size/Status", "New", "Refurbished", "Dented");
        System.out.printf("%25s %24.2f %24.2f %24.2f\n", "16 gigabytes", PRICE_NEW_16, PRICE_REFURB_16, PRICE_DENTED_16);
        System.out.printf("%25s %24.2f %24.2f %24.2f\n", "32 gigabytes", PRICE_NEW_32, PRICE_REFURB_32, PRICE_DENTED_32);

        System.out.print("\nEnter the memory size of the console (32 or 16 gigabytes): ");
        int memorySize = scnr.nextInt();

        boolean decision; // This variable will be used for all attributes chosen
        decision = memorySize == 16 || memorySize == 32; // Will be true for valid memory size

        if (!decision) {
            System.out.println("Invalid memory size!");
            System.exit(0);
        }

        System.out.print("Enter the quality of the console (N for New, R for Refurbished, or D for Dented): ");
        String quality = scnr.next();

        decision = quality.equals("N") || quality.equals("R") || quality.equals("D"); // Will be true for valid quality

        if (!decision) {
            System.out.println("Invalid quality!");
            System.exit(0);
        }

        System.out.print("Enter the console quantity to buy: ");
        int quantity = scnr.nextInt();

        // Checking validity of quantity for each specific quality
        if (quantity < 0 || quantity > 50) {
            System.out.println("Invalid quantity!");
            System.exit(0);
        }
        else if (quality.equals("N") && quantity > 7) {
            System.out.println("We cannot sell more than 7 new consoles");
            System.exit(0);
        }
        else if (quality.equals("R") && quantity > 12) {
            System.out.println("We cannot sell more than 12 refurbished consoles");
            System.exit(0);
        }
        else if (quality.equals("D") && quantity > 15) {
            System.out.println("We cannot sell more than 15 dented consoles");
            System.exit(0);
        }

        // Assigning the item price based on memory size and quality
        double itemPrice = 0.0;
        if (memorySize == 16) {
            switch (quality)
            {
                case "N":
                    itemPrice = PRICE_NEW_16;
                    break;
                case "R":
                    itemPrice = PRICE_REFURB_16;
                    break;
                case "D":
                    itemPrice = PRICE_DENTED_16;
                    break;
            }
        }
        else { // No need to specify if (memorySize == 32) because it will always be true in this scenario
            switch (quality)
            {
                case "N":
                    itemPrice = PRICE_NEW_32;
                    break;
                case "R":
                    itemPrice = PRICE_REFURB_32;
                    break;
                case "D":
                    itemPrice = PRICE_DENTED_32;
                    break;
            }
        }

        // Calculate, space, and display final values
        double itemTotal =  itemPrice * quantity;
        System.out.printf("%s %4s %8.2f", "\nThe item total is" , "$", itemTotal);

        double itemTax = itemTotal * TAX_RATE;
        System.out.printf("%s %6s %8.2f", "\nThe sale tax is" , "$", itemTax);

        System.out.printf("%s %4s %8.2f\n\n", "\nThe total bill is" , "$", (itemTotal + itemTax));

    }
}