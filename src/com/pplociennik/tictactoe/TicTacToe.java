package com.pplociennik.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static final Random RANDOM = new Random();

    public static void main(String args[]) {
        Board board = new Board();
        Scanner scan = new Scanner(System.in);

        board.displayBoard();

        System.out.println("Select turn:\n1. Computer (X) / 2. User (O) : ");

        int choice = scan.nextInt();

        if (choice == Board.PLAYER_X) {
            Point p = new Point(RANDOM.nextInt(3), RANDOM.nextInt(3));
            board.placeAMove(p, Board.PLAYER_X);
            board.displayBoard();
        }

        while (!board.isGameOver()) {
            boolean moveOK = true;

            do {
                if (!moveOK) {
                    System.out.println("Cell already filled!");
                }

                System.out.println("Your move: ");
                Point userMove = new Point(scan.nextInt(), scan.nextInt());
                moveOK = board.placeAMove(userMove, Board.PLAYER_O);
            } while (!moveOK);

            board.displayBoard();

            if (board.isGameOver())
                break;

            board.minMax(0, Board.PLAYER_X);
            System.out.println("Computer choose position: " + board.computerMove);

            board.placeAMove(board.computerMove, Board.PLAYER_X);
            board.displayBoard();
        }

        if (board.hasPlayerWon(Board.PLAYER_X))
            System.out.println("You lost!");
        else if (board.hasPlayerWon(Board.PLAYER_O))
            System.out.println("You win!");
        else
            System.out.println("Draw!");
    }
}
