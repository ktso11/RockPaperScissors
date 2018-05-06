package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game{

    static ArrayList<String> games = new ArrayList<>();

    public Game(){
    }


    public void runGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Rock Paper Scissors!" +"\n\n"+ "MAIN MENU"+"\n"+ "===="+"\n"+ "1. Type 'play' to play" +"\n"+ "2. Type 'history' to view your game history"+"\n"+"Type quit to stop playing");
        String input = scanner.nextLine();
        input = input.toUpperCase();
        switch(input){
            case "PLAY" :
                System.out.println("Choose your opponent: 'cpu' or 'player2'");
                chooseOpponent();
                break;
            case "HISTORY" :
                for(int i = 0; i< games.size();i++) {
                    System.out.println("Game#: "+ ""+ i +"" +" // " +games.get(i));
                }
                runGame();
                break;
            case "QUIT" :
                System.out.println("thanks for playing, BYE!");
                break;
            default :
                System.out.println("Invalid input. Enter play, history or quit. Thanks :)");
                runGame();
        }
    }

    public void chooseOpponent() {
        Scanner scanner = new Scanner(System.in);
        String opponent = scanner.nextLine();
        opponent = opponent.toUpperCase();
        if (opponent.equals("PLAYER2")) {
            playPlayer2();
            runGame();
            return;
        }
        if (opponent.equals("CPU")) {
            playCPU();
            runGame();
            return;
        } else {
            System.out.println("invalid input");
            runGame();
        }
    }

        public void playPlayer2() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is player1's name?");
            String name = scanner.nextLine();
            Player playerOne = new Player(name);
            System.out.println("What is player2's name?");
            String player2 = scanner.nextLine();
            Player playerTwo = new Player(player2);
            System.out.println(playerOne.getPlayerName() + ": Type in 'rock' 'paper' or 'scissors' to play.");
            String player1Chose = scanner.nextLine();
            player1Chose = player1Chose.toUpperCase();
            System.out.println(playerTwo.getPlayerName() + ": Type in 'rock' 'paper' or 'scissors' to play.");
            String player2Chose = scanner.nextLine();
            player2Chose = player2Chose.toUpperCase();
            String result;
            if (player1Chose.equals(player2Chose)) {
                System.out.println("tie!");
                result = "Tie Game between " +playerOne.getPlayerName() + " & " + playerTwo.getPlayerName();
                games.add(result);
                runGame();
            } else if (player1Chose.equals("SCISSORS") && player2Chose.equals("PAPER") ||
                    player1Chose.equals("PAPER") && player2Chose.equals("ROCK") ||
                    player1Chose.equals("ROCK") && player2Chose.equals("SCISSORS")) {
                System.out.println(playerOne.getPlayerName() + " wins!");
                result = "Winner: " + playerOne.getPlayerName() + ", Loser: " + playerTwo.getPlayerName();
                games.add(result);
            } else {
                System.out.println(playerTwo.getPlayerName() + " wins!");
                result = "Winner: " + playerTwo.getPlayerName() + ", Loser: " + playerOne.getPlayerName();
                games.add(result);
            }
        }


        public void playCPU() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is player1's name?");
            String name = scanner.nextLine();
            Player playerOne = new Player(name);
            System.out.println(playerOne.getPlayerName() + ": Type in 'rock' 'paper' or 'scissors' to play." );
            String player1Chose = scanner.nextLine();
            player1Chose = player1Chose.toUpperCase();
            Random cpu = new Random();
            int number = cpu.nextInt(2);
            String cpuChose;
            if (number == 0) {
                cpuChose = "ROCK";
            }
            if (number == 1) {
                cpuChose = "PAPER";
            } else {
                cpuChose = "SCISSORS";
            }
            System.out.println("Mr. Computer choose: " + cpuChose);
            String result;
            if (player1Chose.equals(cpuChose)) {
                System.out.println("tie! Want to play again?" +"\n\n");
                result = "Tie Game between " +playerOne.getPlayerName() + " & Mr. Computer";
                games.add(result);
            } else if (player1Chose.equals("SCISSORS") && cpuChose.equals("PAPER") ||
                    player1Chose.equals("PAPER") && cpuChose.equals("ROCK") ||
                    player1Chose.equals("ROCK") && cpuChose.equals("SCISSORS")) {
                System.out.println(playerOne.getPlayerName() + " wins!" +"\n"+"Want to play again?" +"\n\n");
                result = "Winner: " + playerOne.getPlayerName() + ", Loser: & Mr. Computer";
                games.add(result);
            } else {
                System.out.println("Mr. Computer win!" +"\n"+"Want to play again?" +"\n\n");
                result = "Winner: & Mr. Computer, Loser: " + playerOne.getPlayerName();
                games.add(result);
            }
        }
}
