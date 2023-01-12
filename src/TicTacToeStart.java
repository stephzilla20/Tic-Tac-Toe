/*
TicTacToeStart
View class
Created by: Stephen
Created: 06/16/22
 */

import javax.swing.*;
import java.awt.*;

public class TicTacToeStart extends JPanel
{
    //declare variables
    protected static JFrame window;
    private TicTacToe game = new TicTacToe();
    private TicTacToeGame gameView= new TicTacToeGame(game);
    private SetRoundsController roundsController;
    private static JPanel startWindow = new JPanel(new BorderLayout()); //holds all the panels
    private JPanel header = new JPanel(); //holds the header components
    private static JPanel middle = new JPanel(new BorderLayout()); //holds description components
    private static JPanel bottom = new JPanel(); //holds the bottom components
    private JPanel instructions = new JPanel(new BorderLayout()); //instructions label
    private JLabel title = new JLabel("Tic Tac Toe"); //title label
    private static JLabel rules = new JLabel("Get three in a row to win!"); //rules label
    private static JLabel instructions1 = new JLabel("Enter the number"); //instructions label
    private static JLabel instructions2 = new JLabel("of rounds that"); //instructions label
    private static JLabel instructions3 = new JLabel("you want to play"); //instructions label

    protected static JTextField numRounds= new JTextField(10); //textfield to enter rounds

    //display stats components
    //private static JPanel statsPanel = new JPanel(new BorderLayout()); //holds all the stat and game over panels
    private static JPanel statsTitle = new JPanel(); //hold game over component
    private static JPanel winners = new JPanel(); //holds the winner components
    private JLabel gameOver = new JLabel("GAME OVER"); //game over label
    private JLabel winnerDisplay = new JLabel("WINNER:"); //winner label
    private static JLabel winner = new JLabel(); //the winner
    protected static JButton newGame = new JButton("New Game"); //new game button

    //default GUI constructor that assigns the model and view and identifies the controllers and draws the layout
    public TicTacToeStart(TicTacToe newGame, JFrame aFrame)
    {
        super();
        this.window = aFrame;
        this.game = newGame;
        this.game.setStartView(this);
        this.layoutView();
        this.registerControllers();
    }

    //draw the initial start layout
    private void layoutView()
    {
        //add components to header
        header.setBackground(Color.ORANGE);
        title.setFont(new Font("Comic Sans MS",Font.BOLD,25));
        header.add(this.title);

        //adding components to middle
        instructions.add(this.instructions1,BorderLayout.NORTH);
        instructions.add(this.instructions2,BorderLayout.CENTER);
        instructions.add(this.instructions3,BorderLayout.SOUTH);
        instructions.setBackground(Color.ORANGE);
        statsTitle.add(this.gameOver);
        winners.add(this.winnerDisplay);
        gameOver.setFont(new Font("Comic Sans MS",Font.PLAIN,16));
        winnerDisplay.setFont(new Font("Comic Sans MS",Font.PLAIN,16));
        winners.add(this.winner);
        winner.setFont(new Font("Comic Sans MS",Font.PLAIN,16));
        rules.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        instructions1.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        instructions2.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        instructions3.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        middle.add(this.rules,BorderLayout.EAST);
        middle.add(this.instructions,BorderLayout.SOUTH);
        middle.add(statsTitle, BorderLayout.NORTH);
        middle.add(winners, BorderLayout.CENTER);
        middle.setBackground(Color.ORANGE);

        //hide the game stats components
        statsTitle.setVisible(false);
        winners.setVisible(false);
        newGame.setVisible(false);

        //add componenets to bottom
        bottom.add(this.numRounds);
        bottom.add(this.newGame);
        newGame.setBorder(BorderFactory.createEtchedBorder());
        newGame.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        bottom.setBackground(Color.ORANGE);

        //add all panels to main panel
        startWindow.add(header,BorderLayout.NORTH);
        startWindow.add(middle,BorderLayout.CENTER);
        startWindow.add(bottom,BorderLayout.SOUTH);
        startWindow.setPreferredSize(new Dimension(200, 200));
        startWindow.setBackground(Color.ORANGE);
        this.add(startWindow);
        this.setVisible(true);
        this.setBackground(Color.ORANGE);
    }


    //assigns controller to set round text box and start game button
    private void registerControllers()
    {
        //set rounds textbox
        SetRoundsController setRoundsController = new  SetRoundsController(this.game, this.numRounds);
        this.numRounds.addActionListener(setRoundsController);

        //new game button
        NewGameController newGameController = new NewGameController(this.game, this.newGame);
        this.newGame.addActionListener(newGameController);
    }

    //displays the stats at end of a game
    public static void displayStats()
    {
        numRounds.setVisible(false);
        winner.setText(TicTacToe.getWinner());
        statsTitle.setVisible(true);
        winners.setBackground(Color.ORANGE);
        statsTitle.setBackground(Color.ORANGE);
        winners.setVisible(true);
        newGame.setVisible(true);
        rules.setVisible(false);
        instructions1.setVisible(false);
        instructions2.setVisible(false);
        instructions3.setVisible(false);
    }

    //updates view to the game view
    public void updateGameView()
    {
        window.setVisible(false);
        JFrame g = new JFrame("Tic Tac Toe");
        g.setSize(600,500);
        g.setLocation(300,200);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setContentPane(gameView);
        g.setVisible(true);
    }
}//end of class-
