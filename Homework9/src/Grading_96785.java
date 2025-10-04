/**
 @author Shrestha Nayak
 Homework 9
 This program reads student scores from a file, then calculates and prints individual
 homework statistics and overall final exam statistics.
 */

import java.io.*;
import java.util.Scanner;

public class Grading_96785 {

    static final int HOMEWORK_CNT = 8;
    private String fileName;
    private double finalScoreAverage;
    private int finalScoreMax;
    private int finalScoreMin;

    /**
     * Constructor for the Grading_96785 class.
     * Initializes the input file name and default values for final score statistics.
     * @param fileName The name of the input file containing student scores.
     */
    public Grading_96785(String fileName) {
        this.fileName = fileName;
        this.finalScoreAverage = 0.0;
        this.finalScoreMax = Integer.MIN_VALUE;
        this.finalScoreMin = Integer.MAX_VALUE;
    }

    /**
     * Reads and processes the input file to calculate student homework statistics
     * and overall final exam statistics.
     * @param outfileName Output file to print homework statistics
     * @return -1 if file doesn't exist, 0 if  file is empty or returns student count.
     */
    public int processGrades(String outfileName) throws IOException {
        File inputFile = new File(fileName);
        if (!inputFile.exists()) {
            return -1;
        }

        Scanner fileScanner = new Scanner(inputFile);
        if (fileScanner.hasNextLine()) {
            fileScanner.nextLine();
        } else {
            return 0;
        }

        PrintWriter outputWriter = new PrintWriter(outfileName);
        outputWriter.printf("%10s%15s%12s%13s%n", "ID", "Average HW", "Lowest HW", "Highest HW");

        double totalFinalScores = 0;
        int studentCount = 0;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);

            String studentID = lineScanner.next();
            int[] scores = new int[HOMEWORK_CNT];
            for (int i = 0; i < HOMEWORK_CNT; i++) {
                scores[i] = lineScanner.nextInt();
            }

            int midtermScore = lineScanner.nextInt();
            int finalExamScore = lineScanner.nextInt();
            int labsScore = lineScanner.nextInt();
            int quizScore = lineScanner.nextInt();

            double avgHW = getAverageScore(scores);
            int highestHW = getHighestScore(scores);
            int lowestHW = getLowestScore(scores);

            totalFinalScores += finalExamScore;
            if (finalExamScore > finalScoreMax) {
                finalScoreMax = finalExamScore;
            }
            if (finalExamScore < finalScoreMin) {
                finalScoreMin = finalExamScore;
            }

            outputWriter.printf("%10s%15.2f%12d%13d%n", studentID, avgHW, lowestHW, highestHW);
            studentCount++;

            lineScanner.close();
        }

        fileScanner.close();
        outputWriter.close();

        if (studentCount > 0) {
            finalScoreAverage = totalFinalScores / studentCount;
        } else {
            finalScoreAverage = 0.0;
            finalScoreMax = Integer.MIN_VALUE;
            finalScoreMin = Integer.MAX_VALUE;
            return 0;
        }
        return studentCount;
    }

    /**
     * Displays average, lowest, and highest final exam scores on console.
     */
    public void displayFinalScoreStat(){
        System.out.printf("%s %13.2f", "Average final score is:", finalScoreAverage);
        System.out.printf("\n%s %13d", "Highest final score is:", finalScoreMax);
        System.out.printf("\n%s %14d", "Lowest final score is:", finalScoreMin);
    }

    /**
     * Calculates average of scores in a given integer array.
     * @param scores Array of integer scores.
     * @return The average of the scores as a double. Returns 0.0 if the array is empty.
     */
    public static double getAverageScore(int [ ] scores) {
        if (scores == null || scores.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    /**
     * Calculates highest score in a given integer array.
     * @param scores Array of integer scores.
     * @return Highest score in array. Returns Integer.MIN_VALUE if the array is empty.
     */
    public static int getHighestScore(int[] scores) {
        if (scores == null || scores.length == 0) {
            return Integer.MIN_VALUE;
        }
        int highest = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > highest) {
                highest = scores[i];
            }
        }
        return highest;
    }

    /**
     * Calculates lowest score in a given integer array.
     * @param scores Array of integer scores.
     * @return Lowest score in the array. Returns Integer.MAX_VALUE if the array is empty.
     */
    public static int getLowestScore(int[] scores) {
        if (scores == null || scores.length == 0) {
            return Integer.MAX_VALUE;
        }
        int lowest = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < lowest) {
                lowest = scores[i];
            }
        }
        return lowest;
    }

    /**
     * Main method to run the program.
     * Prompts the user for an input file name, processes the grades,
     * and displays summary statistics.
     * @param args Command line arguments (not used).
     * @throws IOException If an I/O error occurs during file operations.
     */
    public static void main(String[] args) throws IOException {
        final String OUTPUT_NAME = "OUTPUT-96785.TXT";

        System.out.println("This program reads scores data file and displays statistics.\n");
        System.out.print("Enter a student score file: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        System.out.println();
        Grading_96785 sp = new Grading_96785(fileName);
        int result = sp.processGrades(OUTPUT_NAME);
        if (result == -1)
            System.out.println("The file " + fileName + " does not exist!");
        else if (result == 0)
            System.out.println("File " + fileName + " is empty or does not contain scores.");
        else {
            System.out.println("\nFile " + fileName + " contains " + result + " students.");
            System.out.println();
            sp.displayFinalScoreStat();
        }
        scanner.close();
    }

}