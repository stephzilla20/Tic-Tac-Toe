/*
TicTacToeGame
View class
Created by: Stephen
Created: 06/16/22
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TicTacToeGame extends JPanel {
    //declare variables
    private TicTacToe game; //game model
    private static GameButtonsController buttonsController;
    private static JPanel gameWindow = new JPanel(new BorderLayout()); //holds all components of the game
    private JPanel scoreBoard = new JPanel(); //holds the components that display the entire scoreboard
    private JPanel gameGrid = new JPanel(); //holds the 3x3 game grid
    private JPanel scores = new JPanel(); //holds the actual scores of the player and computer
    private JPanel buttonsPanel = new JPanel(); //holds the buttons
    private JPanel roundsPanel = new JPanel(); //holds rounds info
    protected static JLabel playerScore = new JLabel(); //player score
    protected static JLabel computerScore = new JLabel(); //computer score
    private JLabel roundsTitle = new JLabel("Round:"); //rounds title
    protected static JLabel roundsPlayed = new JLabel(); //number of rounds played
    private JLabel player = new JLabel("Player:"); //player title
    private JLabel computer = new JLabel("Computer:"); //computer title
    private JLabel score = new JLabel("Score board"); //scoreboard title
    private JButton endGame = new JButton("End Game"); //end game button
    protected static JButton[][] buttons = new JButton[3][3]; //The buttons that are in the grid

    //display stats
    private static JPanel statsPanel = new JPanel(new BorderLayout()); //holds all the stat and game over panels
    private JPanel statsTitle = new JPanel(); //holds the title
    private JPanel winners = new JPanel(); //holds the winner name and label
    private JLabel gameOver = new JLabel("GAME OVER"); //title
    private JLabel winnerDisplay = new JLabel("WINNER:"); //winner label
    private JLabel winner = new JLabel(); //winner name



    //default GUI constructor that assigns the model and view and identifies the controllers and draws the layout
    public TicTacToeGame(TicTacToe newGame) {
        super();
        this.game = newGame;
        this.game.setGameView(this);
        this.layoutView();
        this.updatePlayerScore();
        this.updateComputerScore();
        this.updateRounds();
        this.registerControllers();
    }

    //draw the initial start layout
    private void layoutView() {
        //add all the score components
        scores.add(this.player);
        player.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        scores.add(this.playerScore);
        playerScore.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        scores.add(this.computer);
        computer.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        scores.add(this.computerScore);
        computerScore.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        roundsPanel.add(this.roundsTitle);
        roundsPanel.add(this.roundsPlayed);
        roundsTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        roundsPlayed.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        scores.setBackground(Color.ORANGE);
        roundsPanel.setBackground(Color.LIGHT_GRAY);
        scoreBoard.add(this.score);
        score.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        scoreBoard.add(this.scores);
        scoreBoard.add(this.roundsPanel);
        scoreBoard.setBackground(Color.LIGHT_GRAY);

        gameGrid.setLayout(new GridLayout(3, 3)); //set the game grid as a grid layout

        //adding all the buttons to the grid
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                buttons[x][y] = new JButton();
                buttons[x][y].setPreferredSize(new Dimension(100, 100));
                buttons[x][y].setText(" ");
                buttons[x][y].setFont(new Font("MV Boli", Font.BOLD, 20));
                buttons[x][y].setBorder(BorderFactory.createEtchedBorder());
                buttons[x][y].setText("");
                gameGrid.add(buttons[x][y]);
            }
        }
        buttonsController = new GameButtonsController(game, this);

        //add buttons to button panel
        buttonsPanel.add(endGame);
        endGame.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        endGame.setBorder(BorderFactory.createEtchedBorder());

        //adding scoreboard, buttons, and game grid to the game window
        gameWindow.add(scoreBoard, BorderLayout.NORTH);
        gameWindow.add(gameGrid, BorderLayout.CENTER);
        gameWindow.add(buttonsPanel, BorderLayout.SOUTH);

        //add game window to frame
        this.add(gameWindow);
        this.setVisible(true);
        this.setBackground(Color.GRAY);


        //adding stats
        statsTitle.add(this.winnerDisplay);
        winners.add(this.winnerDisplay);
        winners.add(this.winner);
        statsPanel.add(statsTitle, BorderLayout.NORTH);
        statsPanel.add(winners, BorderLayout.CENTER);

    }



    //updates rounds played
    public void updateRounds() {
        roundsPlayed.setText(Integer.toString(game.getRoundsPlayed()));
    }

    //updates player score
    public void updatePlayerScore() {
        playerScore.setText(Integer.toString(game.getPlayerWins()));
    }


    //updates computer score
    public void updateComputerScore() {
        computerScore.setText(Integer.toString(game.getComputerWins()));
    }

    public void drawX(ActionEvent e) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (e.getSource() == (buttons[x][y])) {
                    buttons[x][y].setForeground(Color.YELLOW);
                    buttons[x][y].setText("X");
                    buttons[x][y].setEnabled(false);
                }
            }
        }
    }

    public void drawO(int x, int y) {
        buttons[x][y].setText("O");
        buttons[x][y].setForeground(Color.BLUE);
        buttons[x][y].setEnabled(false);
    }

    //register controllers
    public void registerControllers() {
        EndGameController endGameController = new EndGameController(this.game, this.endGame);
        this.endGame.addActionListener(endGameController);

        GameButtonsController gameButtonsController = new GameButtonsController(this.game, this);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                this.buttons[x][y].addActionListener(gameButtonsController);

            }
        }
    }


    //goes back to the start view
    public static void updateStartView() {
        TicTacToeStart.window.setVisible(true);
        TicTacToeStart.numRounds.setText("");
    }

    //new game
    public static void displayNew()
    {
        roundsPlayed.setText("0");
        playerScore.setText("0");
        computerScore.setText("0");

        TicTacToe.roundsPlayed=0;
        TicTacToe.playerWins=0;
        TicTacToe.computerWins=0;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                buttons[x][y].setText("");
                buttons[x][y].setEnabled(true);
            }
        }
        TicTacToeStart.numRounds.setVisible(true);
        TicTacToeStart.newGame.setVisible(false);
    }
}//end of class