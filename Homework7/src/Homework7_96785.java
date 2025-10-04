import java.io.*;
import java.util.Scanner;

public class Homework7_96785 {
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        System.out.println("This program read a number file and print statistics.");
        System.out.print("Enter a file name: ");
        String fileName = sc.nextLine();
        File file = new File(fileName);
        // Check if file exists or file is empty
        checkInputFile(file, fileName);
        // Read all numbers, keep count, smallest and highest number, calculates average
        double average = processFileFirstPass(file);
        // Read all numbers, keep count of numbers below and above the average
        processFileSecondPass(file, average);
    }

    public static void checkInputFile(File file, String fileName)
            throws IOException {

        if (!file.exists()) {
            System.out.println("The file " + fileName + " does not exist!");
            System.exit(0);
        }

        Scanner inputFile = new Scanner(file);

        if (!inputFile.hasNextLine()) {
            System.out.println("File " + fileName + " is empty or does not contain numbers.");
            inputFile.close();
            System.exit(0);
        }
        inputFile.close();
    }

    public static double processFileFirstPass(File file)
            throws IOException {
        Scanner inputFile = new Scanner(file);

        inputFile.nextLine();
        if (!inputFile.hasNextInt()) {
            System.out.println("File is empty or does not contain numbers.");
            System.exit(0);
        }

        int count = 0;
        int sum = 0;
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        while(inputFile.hasNextInt()) {
            count++;

            int num = inputFile.nextInt();
            sum += num;

            if (num < smallest){
                smallest = num;
            }

            if (num > largest){
                largest = num;
            }

        }

        inputFile.close();

        double average = (double) sum / count;

        System.out.printf("\n%50s\n", "File Statistics");
        System.out.printf("%25s %19d\n", "Number count", count);
        System.out.printf("%25s %19d\n", "Smallest number", smallest);
        System.out.printf("%25s %19d\n", "Largest number", largest);
        System.out.printf("%25s %19.2f\n", "Average number", average);

        return average;
    }

    public static void processFileSecondPass(File file, double average)
            throws IOException {
        Scanner inputFile = new Scanner(file);

        int belowAverage = 0;
        int aboveAverage = 0;

        inputFile.nextLine();
        while (inputFile.hasNextInt()) {
            int num = inputFile.nextInt();

            if (num > average) {
                aboveAverage++;
            }
            else if (num < average){
                belowAverage++;
            }
        }

        inputFile.close();

        System.out.printf("%25s %19d\n", "Numbers below average", belowAverage);
        System.out.printf("%25s %19d\n", "Numbers above average", aboveAverage);
    }
}