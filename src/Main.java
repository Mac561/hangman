import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] w = {"two", "hangman", "sleep", "cute", "church", "god", "food", "code"};
        List<Character> playerGuesses = new ArrayList<>();
        List<String> words = new ArrayList<>(Arrays.asList(w));
        Scanner playerInput = new Scanner(System.in);
        // System.out.println(words);
        Random rand = new Random();
        String randomWord = words.get(rand.nextInt(words.size()));
        System.out.println(randomWord);

        int wrongGuessCount = 0;
        while (true) {
            printHangedMan(wrongGuessCount);
            if (wrongGuessCount >= 6) {
                System.out.println("You lose!");
                break;
            }

            printWordGameState(playerGuesses, randomWord);
            if (!getPlayerInput(playerGuesses, playerInput, randomWord)) {
                wrongGuessCount++;
            }

            if (printWordGameState(playerGuesses, randomWord)) {
                System.out.println("Congratulation you win!");
                break;
            }

            System.out.println(("Enter you guess for the word:"));
            if (playerInput.nextLine().equals(randomWord)) {
                System.out.println("Congratulation you win!");
                break;
            } else {
                System.out.println("Try again!");
            }
        }
    }

    private static void printHangedMan(int wrongGuessCount) {
        System.out.println("  --------- ");
        System.out.println("  |       | ");
        if (wrongGuessCount >= 1) {
            System.out.println("  O ");
        }
        ////
        if (wrongGuessCount >= 2) {
            System.out.print("\\ ");
            if (wrongGuessCount >= 3) {
                System.out.println("  / ");
            } else {
                System.out.println(" ");
            }
        }
        /////
        if (wrongGuessCount >= 4) {
            System.out.println("  | ");
        }
        ///
        if (wrongGuessCount >= 5) {
            System.out.print("/ ");
            if (wrongGuessCount >= 6) {
                System.out.print(" \\");
            } else {
                System.out.println(" ");
            }
        }
        System.out.println(" ");
        System.out.println(" ");
    }

    private static boolean getPlayerInput(List<Character> playerGuesses, Scanner playerInput, String randomWord) {
        System.out.println("Please enter a letter");
        String letterGuess = playerInput.nextLine();
        playerGuesses.add(letterGuess.charAt(0));
        // printWordGameState(playerGuesses, randomWord);
        return randomWord.contains(letterGuess);
    }

    private static boolean printWordGameState(List<Character> playerGuesses, String randomWord) {
        int correctWordCount = 0;
        for (int i = 0; i < randomWord.length(); i++) {
            if (playerGuesses.contains(randomWord.charAt(i))) {
                System.out.print(randomWord.charAt(i));
                correctWordCount++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
        return (randomWord.length() == correctWordCount);
    }
}