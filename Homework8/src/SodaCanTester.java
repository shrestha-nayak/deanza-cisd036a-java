/**
 * Test class for SodaCan_96785. Replace 96785 with last 5 digits of your student
 * ID assuming that your class is named correctly.
 * Do not modify this class other than the 96785. Do not submit this class.
 * @author Tony Nguyen
 */
public class SodaCanTester {
    public static void main(String[] args)
    {
        System.out.println("This program simulates a soda can object behavior.");
        SodaCan_96785 can = new SodaCan_96785();
        System.out.printf("%s %.2f\n","Create a new can of soda: ", can.getFullCanCapacity());
        System.out.println("Expected Value:    12.00");


        System.out.printf("%s %s\n",  "Can is full:      ", can.isFull());
        System.out.println("Expected Value:    true");


        boolean result = can.consumeDrink(3);
        System.out.printf("%s %.2f result = %s\n","\nDrink 3fl. ounce.\nSoda can remaining volume is:",
                can.getRemainingDrink(), result);
        System.out.println("Expected Value: 9.00 result = true");


        System.out.printf("%s %s\n",  "Can is full:      ", can.isFull());
        System.out.println("Expected Value:    false");


        result = can.consumeDrink(2.5);
        System.out.printf("%s %.2f result = %s\n", "\nDrink 2.5fl. ounce.\nSoda remain is:",
                can.getRemainingDrink(), result);
        System.out.println("Expected Value: 6.50 result = true");


        result = can.consumeDrink(1.5);
        System.out.printf("%s %.2f result = %s\n", "\nDrink 1.5fl. ounce.\nSoda remain is:",
                can.getRemainingDrink(), result);
        System.out.println("Expected Value: 5.00 result = true");


        result = can.consumeDrink(3.5);
        System.out.printf("%s %.2f result = %s\n", "\nDrink 3.5fl. ounce.\nSoda remain is:",
                can.getRemainingDrink(), result);
        System.out.println("Expected Value: 1.50 result = true");


        result = can.consumeDrink(4.0);
        System.out.printf("%s %.2f result = %s\n", "\nDrink 4.0fl. ounce.\nSoda remain is:",
                can.getRemainingDrink(), result);
        System.out.println("Expected Value: 0.00 result = true");


        System.out.print("\nDrink 1.0fl. ounce from empty can.\n");


        result = can.consumeDrink(1.0);
        System.out.printf("%s %.2f result = %s\n", "Soda remain is:",
                can.getRemainingDrink(), result);
        System.out.println("Expected Value: 0.00 result = false");


        result = can.consumeDrink(0.0);
        System.out.printf("%s %.2f result = %s\n", "\nDrink 0.0fl. ounce.\nSoda remain is:",
                can.getRemainingDrink(), result);
        System.out.println("Expected Value: 0.00 result = true");


        result = can.refillDrink(5);
        System.out.printf("%s %.2f result = %s\n", "\nRefill with 5.0fl. ounce.\nSoda remain is:",
                can.getRemainingDrink(), result);
        System.out.println("Expected Value: 5.00 result = true");


        result = can.refillDrink(7.1);
        System.out.printf("%s %.2f result = %s\n", "\nRefill with 7.1fl. ounce.\nSoda remain is:",
                can.getRemainingDrink(), result);
        System.out.println("Expected Value: 5.00 result = false");




        SodaCan_96785 canCoke = new SodaCan_96785("Coke", 1.3, 4.762);
        System.out.printf("%s %.2f\n", "\nGet new full can of Coke: ", canCoke.getFullCanCapacity());
        System.out.println("Expected Value:    14.00");


        System.out.printf("%s %s\n",  "Can is full:      ", canCoke.isFull());
        System.out.println("Expected Value:    true");


        result = canCoke.consumeDrink(3.3);
        System.out.printf("%s %.2f result = %s\n", "\nDrink 3.3fl. ounce.\nCoke remain is:",
                canCoke.getRemainingDrink(), result);
        System.out.println("Expected Value: 10.70 result = true");


        result = canCoke.consumeDrink(6.8);
        System.out.printf("%s %.2f result = %s\n", "\nDrink 6.8fl. ounce.\nCoke remain is:",
                canCoke.getRemainingDrink(), result);
        System.out.println("Expected Value: 3.90 result = true");


        result = canCoke.consumeDrink(-1);
        System.out.printf("%s %.2f result = %s\n", "\nDrink -1fl. ounce.\nCoke remain is:",
                canCoke.getRemainingDrink(), result);
        System.out.println("Expected Value: 3.90 result = false");


        result = canCoke.consumeDrink(4.0);
        System.out.printf("%s %.2f result = %s\n", "\nDrink 4.0fl. ounce.\nCoke remain is:",
                canCoke.getRemainingDrink(), result);
        System.out.println("Expected Value: 0.00 result = true");


        result = canCoke.refillDrink(14.1);
        System.out.printf("%s %.2f result = %s\n", "\nRefill with 14.1fl. ounce.\nCoke remain is:",
                canCoke.getRemainingDrink(), result);
        System.out.println("Expected Value: 0.00 result = false");


        SodaCan_96785 canPepsi = new SodaCan_96785("Pepsi", 1.5, 4.762);
        System.out.printf("%s %s%s %.2f\n", "\nGet new full can of", canPepsi.getDrinkType(),
                ", capacity: ", canPepsi.getFullCanCapacity());
        System.out.println("Expected Value:                       18.64");


        System.out.printf("%s %s %s %.2f\n", "\nCan of", canCoke.getDrinkType(), "radius is:", canCoke.getCanRadius());
        System.out.println("Expected Value:        1.30");
        System.out.printf("%s %s %s %.2f\n", "\nCan of", canCoke.getDrinkType(), "height is:", canCoke.getCanHeight());
        System.out.println("Expected Value:        4.76");


        System.out.printf("%s %s %s %.2f\n", "\nCan of", canCoke.getDrinkType(), "remain is: ",
                canCoke.getRemainingDrink());
        System.out.println("Expected Value:         0.00");

        result = canCoke.refillDrink(5.1);
        System.out.printf("%s %.2f result = %s\n", "\nRefill coke with 5.1fl. ounce.\nCoke remain is:",
                canCoke.getRemainingDrink(), result);
        System.out.println("Expected Value: 5.10 result = true");

        result = canCoke.consumeDrink(4.0);
        System.out.printf("%s %.2f result = %s\n", "\nDrink 4.0fl. ounce.\nCoke remain is:",
                canCoke.getRemainingDrink(), result);
        System.out.println("Expected Value: 1.10 result = true");

        result = canPepsi.consumeDrink(4.0);
        System.out.printf("%s %.2f result = %s\n", "\nDrink 4.0fl. ounce of Pepsi.\nPepsi remain is:",
                canPepsi.getRemainingDrink(), result);
        System.out.println("Expected Value: 14.64 result = true");
    }

}

