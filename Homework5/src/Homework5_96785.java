/**
 Homework 5
 Author: Shrestha Nayak
 Program Description: Program to order at a restaurant using the
 text inputs/outputs and the Java console.
 */

import java.util.Scanner;

public class Homework5_96785 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        final double PRICE_A = 28.99;
        final double PRICE_B = 21.99;
        final double PRICE_C = 17.99;
        final double PRICE_D = 8.99;
        final double PRICE_E = 7.99;
        final double PRICE_F = 6.99;
        final double PRICE_G = 1.29;
        final double PRICE_H = 1.50;
        final double PRICE_I = 2.50;
        final double TAX_RATE = 0.095;

        String itemName = "";
        double unitPrice = 0;
        int maxQuantity = 0;

        System.out.println("Welcome to the Java restaurant." +
                "\nPlease choose 1 of the following items: \n" +
                "A- Grilled salmon, price      $28.99\n" +
                "B- New York Steak, price      $21.99\n" +
                "C- Roast Chicken, price       $17.99\n" +
                "D- Salad, price               $8.99\n" +
                "E- Soup, price                $7.99\n" +
                "F- Hamburger, price           $6.99\n" +
                "G- Soft drink, price          $1.29\n" +
                "H- Tea, price                 $1.50\n" +
                "I- Orange juice, price        $2.50\n");

        System.out.print("Select a letter from the above menu: ");
        char menuChoice = scnr.next().charAt(0);

        if (menuChoice == 'A') {
            itemName = "Grilled salmon";
            unitPrice = PRICE_A;
            maxQuantity = 40;
        } else if (menuChoice == 'B') {
            itemName = "New York Steak";
            unitPrice = PRICE_B;
            maxQuantity = 40;
        } else if (menuChoice == 'C') {
            itemName = "Roast Chicken";
            unitPrice = PRICE_C;
            maxQuantity = 40;
        } else if (menuChoice == 'D') {
            itemName = "Salad";
            unitPrice = PRICE_D;
            maxQuantity = 100;
        } else if (menuChoice == 'E') {
            itemName = "Soup";
            unitPrice = PRICE_E;
            maxQuantity = 100;
        } else if (menuChoice == 'F') {
            itemName = "Hamburger";
            unitPrice = PRICE_F;
            maxQuantity = 100;
        } else if (menuChoice == 'G') {
            itemName = "Soft drink";
            unitPrice = PRICE_G;
            maxQuantity = 100;
        } else if (menuChoice == 'H') {
            itemName = "Tea";
            unitPrice = PRICE_H;
            maxQuantity = 100;
        } else if (menuChoice == 'I') {
            itemName = "Orange juice";
            unitPrice = PRICE_I;
            maxQuantity = 100;
        } else {
            System.out.println("Invalid menu item");
            System.exit(0);
        }

        System.out.print("Enter the quantity: ");
        int quantity = scnr.nextInt();

        if (quantity < 0) {
            System.out.println("Invalid negative quantity");
            System.exit(0);
        }
        else if (quantity > maxQuantity) {
            System.out.println("Invalid item quantity. It must not exceed " + maxQuantity + ".");
            System.exit(0);
        }

        double itemTotal = unitPrice * quantity;
        System.out.print("\nThe item price for (" + quantity + " X " + itemName + ") is: $");
        System.out.printf("%.2f", itemTotal);

        double salesTax = itemTotal * TAX_RATE;
        System.out.printf("\n%s%.2f", "The sale tax is $", salesTax);

        System.out.print("\n\nEnter the gratuity amount: $");
        double gratuity = scnr.nextDouble();

        if (gratuity < 0) {
            System.out.println("Invalid gratuity amount");
            System.exit(0);
        }

        double totalBill = itemTotal + salesTax + gratuity;
        System.out.printf("\n%s%.2f", "Your total bill is $", totalBill);
        System.out.println("\nThank you for your order");
    }
}