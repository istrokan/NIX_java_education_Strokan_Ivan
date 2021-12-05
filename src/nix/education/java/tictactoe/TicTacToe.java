package nix.education.java.tictactoe;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    final private Scanner scanner = new Scanner(System.in);
    private char [][] field = { {'+','—','+','—','+','—','+'},
                                {'|',' ','|',' ','|',' ','|'},
                                {'+','—','+','—','+','—','+'},
                                {'|',' ','|',' ','|',' ','|'},
                                {'+','—','+','—','+','—','+'},
                                {'|',' ','|',' ','|',' ','|'},
                                {'+','—','+','—','+','—','+'},};
    private static ArrayList<Integer> p1Positions = new ArrayList<>();
    private static ArrayList<Integer> p2Positions = new ArrayList<>();

    private void getField(){
        for (char[] row : field) {
            for (char c : row) {
                System.out.print(" " + c + " ");
            }
            System.out.println();
        }
    }

    private void getChoice(int pos, String p){
        char symbol = ' ';
        if (p.equals("player1")){
            symbol = 'X';
            p1Positions.add(pos);
        } else if (p.equals("player2")){
            symbol = 'O';
            p2Positions.add(pos);
        }

        switch (pos){
            case 1:
                field[1][1] = symbol;
                break;
            case 2:
                field[1][3] = symbol;
                break;
            case 3:
                field[1][5] = symbol;
                break;
            case 4:
                field[3][1] = symbol;
                break;
            case 5:
                field[3][3] = symbol;
                break;
            case 6:
                field[3][5] = symbol;
                break;
            case 7:
                field[5][1] = symbol;
                break;
            case 8:
                field[5][3] = symbol;
                break;
            case 9:
                field[5][5] = symbol;
                break;
            default:
                break;
        }
    }

   private String checkWinner(){

        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning){
            if (p1Positions.containsAll(l)){
                return  "Congratulations PLAYER 1, you WON!";

            } else  if (p2Positions.containsAll(l)){
                return  "Congratulations PLAYER 2, you WON!";

            } else if (p1Positions.size() + p2Positions.size() == 9){
                return "Nobody won >_<";
            }
        }

        return "";
    }

    private int checkCondition(int i){
        while (i > 9 || i < 1 ){
            System.out.println("Pls enter a number from 1 to 9 incl. ");
            i = scanner.nextInt();
        }
        while (p1Positions.contains(i) || p2Positions.contains(i)){
            System.out.println("Position taken, pls repeat:(");
            i = scanner.nextInt();
        }
        return i;
    }

    private boolean checkWin(String winner){
        boolean w = false;
        if(winner.length() > 0){
            System.out.println(winner);
            w = true;
        }
        return w;
    }

    private void startGame(){
        boolean win = false;
        getField();
        while(!win){
            String winner;

            System.out.println("Player 1 make a move (number 1 - 9)");
            int choiceP1 = scanner.nextInt();
            choiceP1 = checkCondition(choiceP1);
            getChoice(choiceP1,"player1");
            getField();
            winner = checkWinner();
            win = checkWin(winner);
            if(win){
                break;
            }else {
                System.out.println("Player 2 make a move (number 1 - 9)");
                int choiceP2 = scanner.nextInt();
                choiceP2 = checkCondition(choiceP2);
                getChoice(choiceP2,"player2");
                getField();
                winner = checkWinner();
                win = checkWin(winner);
            }
        }
    }


    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.startGame();

    }
}
