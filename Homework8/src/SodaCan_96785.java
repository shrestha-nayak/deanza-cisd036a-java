/**
 * SodaCan_12345 class represents a soda can object.
 * It stores drink type, can dimensions in millimeters, and the remaining soda volume in FL ounces.
 * @author Shrestha Nayak
 * Homework 8
 */

public class SodaCan_96785 {
    private final String drinkType;
    private final double radius;
    private final double height;
    private double remainingSoda;

    public static final double PI = 3.14;
    public static final double MM_IN_INCH = 25.4;
    public static final double FL_OZ_PER_CUBIC_MM = 3.3814e-5;

    /**
     * Default constructor: creates a standard soda can (12 FL ounce).
     * Drink type: "Soda"
     * Radius: 1.195 inches; Height: 4.83 inches (converted to mm)
     */

    public SodaCan_96785( ) {
        this("Soda", 1.195, 4.83);
    }

    /**
     * Constructs a soda can with specified drink type and dimensions in inches.
     * @param drinkType Type of drink (e.g., Coke, Pepsi)
     * @param radius Radius of can in inches
     * @param height Height of can in inches
     */

    public SodaCan_96785(String drinkType, double radius, double height) {
        this.drinkType = drinkType;
        this.radius = radius * MM_IN_INCH;
        this.height = height * MM_IN_INCH;
        this.remainingSoda = getFullCanCapacity();
    }

    /**
     * @return DrinkType as a String
     */
    public String getDrinkType() {
        return drinkType;
    }

    /**
     * @return Radius in inches
     */
    public double getCanRadius() {
        return radius / MM_IN_INCH;
    }

    /**
     * @return Height in inches.
     */
    public double getCanHeight() {
        return height / MM_IN_INCH;
    }

    /**
     * @return Full capacity in fluid ounces.
     */
    public double getFullCanCapacity() {
        return PI * radius * radius * height * FL_OZ_PER_CUBIC_MM;
    }

    /**
     * @return Remaining amount in fluid ounces.
     */
    public double getRemainingDrink() {
        return remainingSoda;
    }

    /**
     * @param volume Volume to drink in FL ounces.
     * @return True if operation successful; False if volume negative or can empty and cannot drink.
     */
    public boolean consumeDrink(double volume) {
        if (volume < 0) {
            return false;
        }
        else if (remainingSoda == 0 && volume > 0) {
            return false;
        }
        else if (remainingSoda < volume) {
            remainingSoda = 0;
            return true;
        }
        else {
            remainingSoda -= volume;
        }
        return true;
    }

    /**
     * @param volume Volume to refill in FL ounces.
     * @return true if operation successful; false if volume negative or refill exceeds capacity.
     */
    public boolean refillDrink(double volume) {
        if (volume < 0) {
            return false;
        } else if (remainingSoda + volume > getFullCanCapacity()) {
            return false;
        } else if (remainingSoda + volume <= getFullCanCapacity()) {
            remainingSoda += volume;
            return true;
        }
        return true;
    }

    /**
     * @return true if can is full; false otherwise.
     */
    public boolean isFull() {
        return remainingSoda == getFullCanCapacity();
    }
}