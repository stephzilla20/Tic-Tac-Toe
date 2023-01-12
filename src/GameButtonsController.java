/*
GameButtonsController
Controller class
Created by: Stephen and Ravi
Created: 06/16/22
 */


import javax.swing.*;
import java.awt.event.*;

public class GameButtonsController implements ActionListener
{

    private TicTacToe game; //game model
    private static TicTacToeGame gameView;

    //default constructor
    public GameButtonsController(TicTacToe aGame, TicTacToeGame aGameView) {
        this.game = aGame;
        this.gameView = aGameView;
    }

    //calls method in model to update view
    public void actionPerformed(ActionEvent e)
    {
        game.buttonPressed(e);

    }
}//end of class

