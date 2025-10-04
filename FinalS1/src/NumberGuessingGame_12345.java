/***************************************
 @author Shrestha Nayak
 /* Description: Number guessing game with up to 3 trials per game. Tracks wins/losses
 and displays summary when the user exits.
 /***************************************/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame_12345 {


    private int answerCount;          // number of answers in the current game (0–3)
    private int secretNumber;         // random number 1–10
    private boolean isWon;            // true if guessed within 3 trials
    private boolean isStoppedEarly;   // true if user quits with 0 before finishing
    private int[] answers;            // array of answers (size 3, no zeros stored)


    /**
     * No-argument constructor.
     */
    public NumberGuessingGame_12345() {
        answerCount = 0;
        secretNumber = 0;
        isWon = false;
        isStoppedEarly = false;
        answers = new int[3];
    }


    public int getSecretNumber() {
        return secretNumber;
    }


    public void setSecretNumber(int secret) {
        this.secretNumber = secret;
    }


    public boolean isStoppedEarly() {
        return isStoppedEarly;
    }


    public void setStoppedEarly(boolean isStopped) {
        this.isStoppedEarly = isStopped;
    }


    public void addAnswer(int answer) {
        if (answer != 0 && answerCount < 3) {
            answers[answerCount] = answer;
            answerCount++;
        }
    }


    public boolean isWon() {
        return isWon;
    }


    public void setWon(boolean isWon) {
        this.isWon = isWon;
    }


    public String getAllAnswersAsString() {
            String result = "";
            for (int i = 0; i < answerCount; i++) {
                result += answers[i] + (i < answerCount - 1 ? " " : "");
            }
            return result;
    }


    /**
     * Plays a single game.
     * @param secretNum the secret number to guess
     * @param in Scanner object for user input
     * @return the completed NumberGuessingGame_12345 object
     */
    public static NumberGuessingGame_12345 playAGame(int secretNum, Scanner in) {
        NumberGuessingGame_12345 game = new NumberGuessingGame_12345();
        game.setSecretNumber(secretNum);


        for (int trial = 1; trial <= 3; trial++) {
            if (trial == 1) {
                System.out.print("Enter a number from 1 to 10. Enter 0 to exit: ");
            } else {
                System.out.print("Not correct, try again: ");
            }


            int guess = in.nextInt();


            if (guess == 0) {
                game.setStoppedEarly(true);
                break;
            }


            game.addAnswer(guess);


            if (guess == secretNum) {
                game.setWon(true);
                System.out.println("Congratulations, correct! Let’s start a new game  with a new secret number.");
                break;
            }


            if (trial == 3 && guess != secretNum) {
                System.out.println("Not correct. You have reached your third trial. The correct number is " + secretNum + ".");
                System.out.println("Let's start a new game with a new secret number.");
            }
        }


        return game;
    }


    public static void main(String[] args) {
        System.out.println("Welcome to the number guessing game.");
        System.out.println("For each game, you have at most 3 chances to guess a secret number from 1 to 10.\n");


        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        ArrayList<NumberGuessingGame_12345> games = new ArrayList<>();


        while (true) {
            int secret = rand.nextInt(10) + 1; // 1–10 inclusive
            NumberGuessingGame_12345 game = playAGame(secret, in);


            if (game.isStoppedEarly()) {
                break; // exit loop without adding to list
            }
            games.add(game);
        }


        // Display summary
        System.out.println("\nHere is your game summary:");
        System.out.printf("%-8s %-8s %-12s %-15s\n", "Game", "Won", "Secret", "Answers");


        int wins = 0;
        int losses = 0;


        for (int i = 0; i < games.size(); i++) {
            NumberGuessingGame_12345 g = games.get(i);
            if (g.isWon()) wins++;
            else losses++;


            System.out.printf("%-8d %-8b %-12d %-15s\n",
                    (i + 1), g.isWon(), g.getSecretNumber(), g.getAllAnswersAsString());
        }


        System.out.println("\n              Total games:       " + games.size());
        System.out.println("              Total game wins:   " + wins);
        System.out.println("              Total game losses: " + losses);


        in.close();
    }
}


