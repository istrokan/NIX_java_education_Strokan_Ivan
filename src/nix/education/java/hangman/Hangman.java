package nix.education.java.hangman;

import java.util.HashSet;
import java.util.Scanner;

public class Hangman {

    final Scanner scanner = new Scanner(System.in);
    private static String[] words = {"python", "java", "javascript", "kotlin"};
    private static int counter = 0;
    private HashSet<Character> usedLetters = new HashSet<>();

    private boolean checkUserTypedLetterBefore(char letter) {
        if(usedLetters.contains(letter))
            return true;

        usedLetters.add(letter);
        return false;
    }

    private boolean checkDone(char[] myAnswers){
        boolean done = true;
        for (int i = 0; i < myAnswers.length; i++) {
            if (myAnswers[i] == '-') {
                done = false;
            }
        }
        return done;
    }

    private boolean checkResult(char[] myAnswers,boolean done){
        boolean finished = false;
        if (done) {
            System.out.println();
            System.out.println(myAnswers);
            System.out.println("You guessed the word!\n" +
                    "You survived!");
            finished = true;
        }
        return finished;
    }

    private void checkCondition(boolean moreThanTwo, boolean englishLater, boolean sameLater, boolean found){
        if (moreThanTwo) {
            System.out.println("You should input a single letter");
        } else if (!englishLater) {
            System.out.println("Please enter a lowercase English letter");
        } else if (!sameLater && !found) {
            counter++;
            System.out.println("That letter doesn't appear in the word");
        } else if (sameLater) {
            System.out.println("You've already guessed this letter");
        }
    }

    private void checkCounter(){
        if (counter > 7){
            System.out.println("GAME OVER :(");
        }
    }

    private void playGame() {
        String word = words[(int) (Math.random() * words.length)];
        Hangman hang = new Hangman();
        char[] textArray = word.toCharArray();
        char[] myAnswers = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            myAnswers[i] = '-';
        }
        System.out.println(word);

        boolean finished = false;
        counter = 0;

        while (counter < 8 & !finished) {
            System.out.println();
            System.out.println(myAnswers);
            System.out.print("Input a letter: > ");
            String letter = scanner.next();

            boolean found = false;

            boolean moreThanTwo = letter.length() > 1;
            boolean englishLater = letter.matches("[a-z]");
            boolean sameLater = hang.checkUserTypedLetterBefore(letter.charAt(0));

            for (int i = 0; i < textArray.length; i++) {
                if (letter.charAt(0) == textArray[i] && !moreThanTwo) {
                    myAnswers[i] = textArray[i];
                    found = true;
                }
            }

            boolean done = hang.checkDone(myAnswers);
            hang.checkCondition(moreThanTwo,englishLater,sameLater,found);
            hang.checkCounter();
            finished = hang.checkResult(myAnswers,done);

        }
    }

    final public void startGame(){
        boolean start = true;
        Hangman hang = new Hangman();
        while (start){
            System.out.println("\nHANGMAN\n");
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: ");
            String choice = scanner.next();
            switch (choice){
                case "play":
                    hang.playGame();
                    break;
                case "exit":
                    start = false;
                    break;
                default:
                    continue;
            }
        }
    }

    public static void main(String[] args) {

        Hangman hangman = new Hangman();
        hangman.startGame();

            }
        }
