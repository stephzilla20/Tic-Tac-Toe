/*
TicTacToe
Model class
Created by: Ravi
Created: 06/16/22
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class TicTacToe {

    private static TicTacToeStart startView;
    private static TicTacToeGame gameView;
    //variables
    protected static int roundsPlayed = 0; //number of rounds played
    protected static int playerWins = 0; //number of wins for player
    protected static int computerWins = 0; //number of wins for computer
    protected static int x; //x coordinate for buttons
    protected static int y; //y coordinate for buttons
    protected static String winner=""; //the name of the winner
    protected static int gamesPlayed; //number of games played

    //creates a default TicTacToe game
    public TicTacToe() {
        super();
    }


    //sets the start view
    public void setStartView(TicTacToeStart currentStart) {
        this.startView = currentStart;
    }

    //sets the game view
    public void setGameView(TicTacToeGame currentGame) {
        this.gameView = currentGame;
    }


    //gets the player wins
    public int getPlayerWins() {
        return this.playerWins;
    }

    //gets the computer wins
    public int getComputerWins() {
        return this.computerWins;
    }

    //gets number of rounds played
    public int getRoundsPlayed() {
        return this.roundsPlayed;
    }

    //gets the name of winner
    public static String getWinner() {
        if (computerWins > playerWins) {
            winner = "Computer";
        }
        if (playerWins > computerWins) {
            winner = "Player";
        }
        if(playerWins==computerWins){
            winner="tie";
        }

        return winner;
    }


    //generates random coordinates from 0 to 2 for where the computer places marker
    public void computerCoordinates() {
        x = (int) ((Math.random() * (3 - 0) + 0));
        y = (int) ((Math.random() * (3 - 0) + 0));
    }


    //checks for winner
    public void checkForWinner(){
        //check X win conditions
        //check rows
        for (int a = 0; a < 3; a++) {
            if ((gameView.buttons[a][0].getText() == "X") && (gameView.buttons[a][1].getText() == "X") && (gameView.buttons[a][2].getText() == "X")) {
                playerWins += 1;
                roundsPlayed += 1;
                gameView.updateRounds();
                gameView.updatePlayerScore();
                newGrid();
            }
        }

        //checks columns
        for (int b = 0; b < 3; b++) {
            if ((gameView.buttons[0][b].getText() == "X") && (gameView.buttons[1][b].getText() == "X") && (gameView.buttons[2][b].getText() == "X")) {
                playerWins += 1;
                roundsPlayed += 1;
                gameView.updateRounds();
                gameView.updatePlayerScore();
                newGrid();
            }
        }


        //checks for win diagonally
        if (gameView.buttons[0][0].getText().equals("X") && gameView.buttons[1][1].getText().equals("X") && gameView.buttons[2][2].getText().equals("X")) {
            playerWins += 1;
            roundsPlayed += 1;
            gameView.updateRounds();
            gameView.updatePlayerScore();
            newGrid();
        }

        if (gameView.buttons[0][2].getText().equals("X") && gameView.buttons[1][1].getText().equals("X") && gameView.buttons[2][0].getText().equals("X")) {
            playerWins += 1;
            roundsPlayed += 1;
            gameView.updateRounds();
            gameView.updatePlayerScore();
            newGrid();
        }

        //check O win conditions
        //check rows
        for (int a = 0; a < 3; a++) {
            if ((gameView.buttons[a][0].getText() == "O") && (gameView.buttons[a][1].getText() == "O") && (gameView.buttons[a][2].getText() == "O")) {
                computerWins += 1;
                roundsPlayed += 1;
                gameView.updateRounds();
                gameView.updateComputerScore();
                newGrid();
            }
        }
        //checks columns
        for (int a = 0; a < 3; a++) {
            if ((gameView.buttons[0][a].getText() == "O") && (gameView.buttons[1][a].getText() == "O") && (gameView.buttons[2][a].getText() == "O")) {
                computerWins += 1;
                roundsPlayed += 1;
                gameView.updateRounds();
                gameView.updateComputerScore();
                newGrid();
            }
        }

        //checks for win diagonally
        if (gameView.buttons[0][0].getText().equals("O") && gameView.buttons[1][1].getText().equals("O") && gameView.buttons[2][2].getText().equals("O")) {
            computerWins += 1;
            roundsPlayed += 1;
            gameView.updateRounds();
            gameView.updateComputerScore();
            newGrid();
        }
        if (gameView.buttons[0][2].getText().equals("O") && gameView.buttons[1][1].getText().equals("O") && gameView.buttons[2][0].getText().equals("O")) {
            computerWins += 1;
            roundsPlayed += 1;
            gameView.updateRounds();
            gameView.updateComputerScore();
            newGrid();
        }


        //if all markers are placed while no win condition is true, there is a tie, no score is increased
                if(!(gameView.buttons[0][0].isEnabled())&&
                        !(gameView.buttons[0][1].isEnabled())&&
                        !(gameView.buttons[0][2].isEnabled())&&
                        !(gameView.buttons[1][0].isEnabled())&&
                        !(gameView.buttons[1][1].isEnabled())&&
                        !(gameView.buttons[1][2].isEnabled())&&
                        !(gameView.buttons[2][0].isEnabled())&&
                        !(gameView.buttons[2][1].isEnabled())&&
                        !(gameView.buttons[2][2].isEnabled()))
                {

                    roundsPlayed += 1;
                    gameView.updateRounds();
                    newGrid();

                }
    }


    //when someone wins, redraws the grid to display empty grid
    public void newGrid() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                gameView.buttons[x][y].setText("");
                gameView.buttons[x][y].setEnabled(true);
            }
        }
        gameOver();
    }


    //updates view to game view
    public static void goGameView() {
        startView.updateGameView();
    }

    //closes everything
    public static void closeWindow()
    {
        System.exit(0);
    }

    //when a button on the grid is pressed, the view updates and the computer places a random maker
    public void buttonPressed(ActionEvent e)
    {
        gameView.drawX(e);
        checkForWinner();
        computerCoordinates();

        //generates random coordinates for computer marker until coordinates are at empty place
        while(gameView.buttons[x][y].getText().equals("O") || gameView.buttons[x][y].getText().equals("X"))
        {
            computerCoordinates();
        }

        //draws computer marker if the place doesnt have a marker
        if (gameView.buttons[x][y].isEnabled())
        {
            gameView.drawO(x, y);
            checkForWinner();
        }
    }

    //when game is over, the view will change to display the stats
    public void gameOver() {
        if (SetRoundsController.totalRounds == roundsPlayed) {
            gameView.updateStartView();
            startView.displayStats();
            this.gamesPlayed+=1;
            sendInfo();
        }
    }

    //sends all the information to a txt file
    public void sendInfo()
    {
        try {
            File file = new File("Game Over Info.txt");
            PrintWriter pw = new PrintWriter(file);
            if(getWinner()=="tie"){
                pw.println("There was a tie");
            }
            else {
                pw.println("The winner is the " + getWinner() + ".");
            }
            pw.println("You won " + getPlayerWins()+" time(s).");
            pw.println("The computer won " + getComputerWins()+" time(s).");
            pw.println(getRoundsPlayed()+" round(s) were played.");
            pw.close();
            //readFile(file);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}//end of class