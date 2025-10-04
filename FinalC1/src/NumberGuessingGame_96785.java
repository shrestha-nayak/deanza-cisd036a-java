/***************************************
 @author Shrestha Nayak
 /* Description: Number guessing game with up to 3 trials per game.
 Tracks wins/losses and displays summary when the user exits.
 /***************************************/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame_96785 {
    private int answerCount;
    private int secretNumber;
    private boolean isWon;
    private boolean isStoppedEarly;
    private int answers[];

    /**
     * Constructs a new NumberGuessingGame_96785 object.
     * Initializes the answer array and sets initial game status.
     */
    public NumberGuessingGame_96785(){
        this.answerCount = 0;
        this.secretNumber = 0;
        this.isWon = false;
        this.isStoppedEarly = false;
        this.answers = new int[3];
    }

    /**
     * @return The secret number.
     */
    public int getSecretNumber(){
        return secretNumber;
    }

    /**
     * Sets the secret random number for the game.
    * @param secret The secret number to be set.
     */
    public void setSecretNumber(int secret){
        this.secretNumber = secret;
    }

    /**
    * @return True if the user entered 0 to exit early, false otherwise.
     */
    public boolean isStoppedEarly(){
        return isStoppedEarly;
    }

    /**
     * Sets the boolean value of the isStoppedEarly field.
     * * @param isStopped True if the game is stopped early, false otherwise.
     */
    public void setStoppedEarly(boolean isStopped){
        this.isStoppedEarly = isStopped;
    }

    /**
     * Adds valid answers (1-10) to the answers array
    * @param answer The user's guess to add.
     */
    public void addAnswer(int answer) {
        if (answer != 0 && answerCount < 3) {
            this.answers[answerCount] = answer;
            this.answerCount++;
        }
    }

    /**
    * @return True if the user guessed correctly, false otherwise.
     */
    public boolean isWon() {
        return isWon;
    }

    /**
     * Sets the boolean value of the isWon field.
     * @param isWon True if the user won the game, false otherwise.
     */
    public void  setWon(boolean isWon) {
        this.isWon = isWon;
    }

    /**
     * Returns a string that contains all the answers of a game separated by spaces.
     * @return A string containing all recorded answers.
     */
    public String getAllAnswersAsString() {
        String result = "";
        for (int i = 0; i < answerCount; i++) {
            result += answers[i];
            if (i < answerCount - 1) {
                result += " ";
            }
        }
        return result;
    }

    /**
     * Plays one guessing game. This method handles user input, checks guesses, and updates the game status.
     * @param secretNum The secret number for this game.
     * @param in The Scanner object for user input.
     * @return A NumberGuessingGame_96785 object representing the played game's status.
     */
    public static NumberGuessingGame_96785 playAGame(int secretNum, Scanner in) {
        NumberGuessingGame_96785 game = new NumberGuessingGame_96785();
        game.setSecretNumber(secretNum);

        int guess;
        int trials = 0;
        final int MAX_TRIALS = 3;

        while (trials < MAX_TRIALS && !game.isWon) {
            if (trials == 0) {
                System.out.print("Enter a number from 1 to 10. Enter 0 to exit: ");
            }
            else {
                System.out.print("Not correct, try again: ");
            }

            guess = in.nextInt();
            game.addAnswer(guess);

            if (guess == 0) {
                game.setStoppedEarly(true);
                return game;
            }
            else if (guess == game.getSecretNumber()) {
                game.setWon(true);
                System.out.println("Congratulations, correct! Let’s start a new game with a new secret number.");
            }
            else {
                trials++;
                if (trials == MAX_TRIALS) {
                    System.out.printf("Not correct. You have reached your third trial. " +
                            "The correct number is %d.\n", game.getSecretNumber());
                    System.out.println("Let's start a new game with a new secret number.");
                }
            }
        }
        return game;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        ArrayList<NumberGuessingGame_96785> gamesPlayed = new ArrayList<>();

        System.out.println("Welcome to the number guessing game.");
        System.out.println("For each game, you have at most 3 chances to guess a secret number from 1 to 10.\n");

        NumberGuessingGame_96785 currentGame;

        do {
            int secret = random.nextInt(10) + 1;
            // System.out.println("DEBUG: Secret number is " + secret);
            currentGame = playAGame(secret, scanner);

            if (!currentGame.isStoppedEarly()) {
                gamesPlayed.add(currentGame);
            }
        }
        while (!currentGame.isStoppedEarly());

        System.out.println("\nHere is your game summary:");
        System.out.printf("%5s %8s %20s %15s", "Game", "Won" , "Secret", "Answers");

        int totalGames = gamesPlayed.size();
        int totalWins = 0;
        int totalLosses = 0;

        for (int i = 0; i < totalGames; i++) {
            NumberGuessingGame_96785 game = gamesPlayed.get(i);
            System.out.printf("\n   %-7d %-19b %-14d %s",
                    (i + 1),
                    game.isWon(),
                    game.getSecretNumber(),
                    game.getAllAnswersAsString());

            if (game.isWon()) {
                totalWins++;
            } else {
                totalLosses++;
            }
        }

        System.out.printf("\n\n              %s %8d" , "Total games:", totalGames);
        System.out.printf("\n              %s %4d" , "Total game wins:" , totalWins);
        System.out.printf("\n              %s %2d" , "Total game losses:" , totalLosses);

        scanner.close();
    }
}