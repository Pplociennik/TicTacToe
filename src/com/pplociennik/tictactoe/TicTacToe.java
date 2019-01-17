package com.pplociennik.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static final Random RANDOM = new Random();

    public static void main(String args[]) {
        Board board = new Board();
        Scanner scan = new Scanner(System.in);

        board.displayBoard();

        System.out.println("Wybierz turę:\n1. Komputer (X) / 2. Gracz (O) : ");

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
                    System.out.println("Komórka już zajęta!");
                }

                System.out.println("Twój ruch: ");
                Point userMove = new Point(scan.nextInt(), scan.nextInt());
                moveOK = board.placeAMove(userMove, Board.PLAYER_O);
            } while (!moveOK);

            board.displayBoard();

            if (board.isGameOver())
                break;

            board.minMax(0, Board.PLAYER_X);
            System.out.println("Komputer wybiera pozycję: " + board.computerMove);

            board.placeAMove(board.computerMove, Board.PLAYER_X);
            board.displayBoard();
        }

        if (board.hasPlayerWon(Board.PLAYER_X))
            System.out.println("Przegrałeś!");
        else if (board.hasPlayerWon(Board.PLAYER_O))
            System.out.println("Zwycięstwo!");
        else
            System.out.println("Remis!");
    }
}
